package com.xjy.autotest.generate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.platform.commons.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.persistence.Column;

/**
 * Created by ychaoyang on 2017/8/17.
 */
public class GenerateBaseFile {

	protected final static Logger log = LoggerFactory.getLogger(GenerateBaseFile.class);

	public static void main(String[] args) {
		String projectName = "platfrompay";

		new GenerateBaseFile().generateBaseFile(projectName, "huairen", false, GenerateBaseFile.class);

	}

	/**
	 * 根据项目名称生成services,base,Parameters类文件
	 *
	 * @param projectName 项目名
	 * @param author      作者
	 * @param covered     是否覆盖原有base文件
	 * @param cla         main方法所在的类，用于定位生成文件的位置
	 * @return
	 */
	public void generateBases(String projectName, String author, boolean covered, Class<?> cla) {
		try {
			ArrayList<Map<String, Object>> facades = new ArrayList<>();
			Field[] fields = cla.getDeclaredFields();
			if (fields.length == 0) {
				return;
			}
			for (Field f : fields) {
				String facadeName = f.getName();
				Class<?> facadeCLa = f.getType();
				String className = facadeCLa.getName();
				Map<String, Object> facadeMap = new HashMap<>();
				facadeMap.put("facadeName", facadeName);
				facadeMap.put("className", className);
				facades.add(facadeMap);

			}
			String packageName = cla.getPackage().getName();
			// 项目名为空时截取类名得到项目名
			// String projectName =
			// cla.getSimpleName().split("DalAutoTestService")[0].toLowerCase();
			if (StringUtils.isBlank(projectName)) {
				System.out.println("项目名为空，不能执行该操作！");
				return;
			}
			String version = "1.0";
			if (StringUtils.isBlank(version)) {
				version = "1.0";
			}
			// freeMarker模板所在路径
			String ftlPath = Thread.currentThread().getContextClassLoader().getResource("ftl/").getPath()
					.replace("/target/test-classes", "/src/test/resources");
			// 生成的文件需要放置的位置路径
			String filePath = Thread.currentThread().getContextClassLoader().getResource("integration/").getPath()
					.replace("/target/test-classes", "/src/test/resources") + projectName;
			File file = new File(filePath);
			// 如果文件夹不存在则创建一个
			if (!file.exists() && !file.isDirectory()) {
				System.out.println(filePath + "不存在");
				file.mkdir();
			}
			// 组装输出文件路径
			String outFile = filePath + "/dubbo-" + projectName + ".xml";
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
			cfg.setDirectoryForTemplateLoading(new File(ftlPath));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			Map<String, Object> root = new HashMap<String, Object>();
			root.put("packageName", packageName);
			root.put("author", author);
			root.put("date", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
			root.put("facades", facades);
			root.put("version", version);
			root.put("projectName", projectName);
			Template template = cfg.getTemplate("generateDubboXml.ftl");
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
			template.process(root, out);
			System.out.println("更新成功" + outFile);

			// 生成servicesbase文件
			String className1 = toUpperCaseFirstOne(projectName) + "AutoTestService";
			String outFile1 = getClassFilePath(cla).replace("\\target\\test-classes", "\\src\\test\\java")
					.replace(cla.getSimpleName() + ".class", className1 + ".java");
			if (covered || !new File(outFile).exists()) {
				Template template1 = cfg.getTemplate("generateServiceBase.ftl");
				PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(outFile1)));
				root.put("className", className1);
				template1.process(root, out1);
				System.out.println("更新成功" + outFile1);
			}

			// 生成base文件
			generateBaseFile(projectName, "huairen", covered, cla);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据项目名称生成base类
	 *
	 * @param projectName
	 * @return
	 */
	public void generateBaseFile(String projectName, String author, boolean covered, Class<?> cla) {
		try {
			// Class<?> cla = Class.forName(clazzName);
			// 从包路径获取全部DOclass类
			Set<Class<?>> cls = getClasses("dal.model." + projectName);
			List<Map<String, Object>> tableList = new ArrayList<>();
			for (Class<?> c : cls) {
				if (!c.getName().contains("Example")) {
					System.out.println(c.getName());
					Map<String, Object> table = new HashMap<String, Object>();
					table.put("tableName", c.getSimpleName().replace("DO", ""));
					List<Param> pars = new ArrayList<>();
					Field[] fields = c.getDeclaredFields();
					for (Field f : fields) {
						if ("serialVersionUID".equals(f.getName())) {
							continue;
						}
						Param par = new Param();
						par.setName(f.getName());
						par.setTypeName(f.getType().getSimpleName());
						if ("Long".equals(f.getType().getSimpleName())) {
							par.setTypeName("long");
						}
						Column column = f.getAnnotation(Column.class);
						if (null != column) {
							String clumnName = column.name();
							if (clumnName.split("_").length > 1 && clumnName.split("_")[0].length() == 1) {
								par.setAnnotation(column.name());
							}
						}
						pars.add(par);
					}
					table.put("pars", pars);
					tableList.add(table);
				}
			}
			// AutoTestBase类
			String className = toUpperCaseFirstOne(projectName) + "TestBase";
			String filePath = Thread.currentThread().getContextClassLoader().getResource("ftl/").getPath()
					.replace("/target/test-classes", "/src/test/resources");
			String outFile = getClassFilePath(cla).replace("\\target\\classes", "\\src\\test\\java")
					.replace(cla.getSimpleName() + ".class", className + ".java");
			String packageName = cla.getPackage().getName();
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
			cfg.setDirectoryForTemplateLoading(new File(filePath));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			Map<String, Object> root = new HashMap<String, Object>();
			root.put("packageName", packageName);
			root.put("projectName", projectName);
			root.put("className", className);
			root.put("time", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
			root.put("author", author);
			root.put("tableList", tableList);
			if (covered || !new File(outFile).exists()) {
				Template template = cfg.getTemplate("generateTestBase.ftl");
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
				template.process(root, out);
				System.out.println("更新成功" + outFile);
			}

			// DataSourceConfig类
			String className3 = toUpperCaseFirstOne(projectName) + "DataSourceConfig";
			String outFile3 = getClassFilePath(cla).replace("\\target\\classes", "\\src\\test\\java")
					.replace("testbase\\" + cla.getSimpleName() + ".class", "datasource\\"
							+ className3 + ".java");
			if (covered || !new File(outFile3).exists()) {
				Template template3 = cfg.getTemplate("generateDataSourceConfig.ftl");
				PrintWriter out3 = new PrintWriter(new BufferedWriter(new FileWriter(outFile3)));
				root.put("className", className3);
				template3.process(root, out3);
				System.out.println("更新成功" + outFile3);
			}

/*			// AutoTestParameters类
			String className1 = toUpperCaseFirstOne(projectName) + "AutoTestParameters";
			String outFile1 = getClassFilePath(cla).replace("\\target\\classes", "\\src\\test\\java")
					.replace(cla.getSimpleName() + ".class", className1 + ".java");
			if (covered || !new File(outFile1).exists()) {
				Template template1 = cfg.getTemplate("generateTestParameters.ftl");
				PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(outFile1)));
				root.put("className", className1);
				template1.process(root, out1);
				System.out.println("更新成功" + outFile1);
			}

			// DBXml文件
			String className2 = "dal-db-" + projectName;
			String outFile2 = Thread.currentThread().getContextClassLoader().getResource("dal/").getPath()
					.replace("/target/classes", "/src/test/resources") + className2 + ".xml";
			if (covered || !new File(outFile2).exists()) {
				Template template2 = cfg.getTemplate("generateDBXml.ftl");
				PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter(outFile2)));
				root.put("className", className2);
				template2.process(root, out2);
				System.out.println("更新成功" + outFile2);
			}
*/
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 得到当前类的路径
	 *
	 * @param clazz
	 * @return
	 */
	public static String getClassFilePath(Class<?> clazz) {
		try {
			return java.net.URLDecoder.decode(getClassFile(clazz).getAbsolutePath(), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 取得当前类所在的文件
	 *
	 * @param clazz
	 * @return
	 */
	public static File getClassFile(Class<?> clazz) {
		URL path = clazz.getResource(clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1) + ".classs");
		if (path == null) {
			String name = clazz.getName().replaceAll("[.]", "/");
			path = clazz.getResource("/" + name + ".class");
		}
		return new File(path.getFile());
	}

	/**
	 * 首字母转小写
	 *
	 * @param s
	 * @return
	 */
	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}

	/**
	 * 首字母转大写
	 *
	 * @param s
	 * @return
	 */
	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}

	/**
	 * 从包package中获取所有的Class
	 *
	 * @param pack
	 * @return
	 */
	public static Set<Class<?>> getClasses(String pack) {

		// 第一个class类的集合
		Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
		// 是否循环迭代
		boolean recursive = true;
		// 获取包的名字 并进行替换
		String packageName = pack;
		String packageDirName = packageName.replace('.', '/');
		// 定义一个枚举的集合 并进行循环来处理这个目录下的things
		Enumeration<URL> dirs;
		try {
			dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
			// 循环迭代下去
			while (dirs.hasMoreElements()) {
				// 获取下一个元素
				URL url = dirs.nextElement();
				// 得到协议的名称
				String protocol = url.getProtocol();
				// 如果是以文件的形式保存在服务器上
				if ("file".equals(protocol)) {
//                    System.err.println("file类型的扫描");
					// 获取包的物理路径
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					// 以文件的方式扫描整个包下的文件 并添加到集合中
					findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
				} else if ("jar".equals(protocol)) {
					// 如果是jar包文件
					// 定义一个JarFile
//                    System.err.println("jar类型的扫描");
					JarFile jar;
					try {
						// 获取jar
						jar = ((JarURLConnection) url.openConnection()).getJarFile();
						// 从此jar包 得到一个枚举类
						Enumeration<JarEntry> entries = jar.entries();
						// 同样的进行循环迭代
						while (entries.hasMoreElements()) {
							// 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
							JarEntry entry = entries.nextElement();
							String name = entry.getName();
							// 如果是以/开头的
							if (name.charAt(0) == '/') {
								// 获取后面的字符串
								name = name.substring(1);
							}
							// 如果前半部分和定义的包名相同
							if (name.startsWith(packageDirName)) {
								int idx = name.lastIndexOf('/');
								// 如果以"/"结尾 是一个包
								if (idx != -1) {
									// 获取包名 把"/"替换成"."
									packageName = name.substring(0, idx).replace('/', '.');
								}
								// 如果可以迭代下去 并且是一个包
								if ((idx != -1) || recursive) {
									// 如果是一个.class文件 而且不是目录
									if (name.endsWith(".class") && !entry.isDirectory()) {
										// 去掉后面的".class" 获取真正的类名
										String className = name.substring(packageName.length() + 1, name.length() - 6);
										try {
											// 添加到classes
											classes.add(Class.forName(packageName + '.' + className));
										} catch (ClassNotFoundException e) {
											// log
											// .error("添加用户自定义视图类错误
											// 找不到此类的.class文件");
											e.printStackTrace();
										}
									}
								}
							}
						}
					} catch (IOException e) {
						// log.error("在扫描用户定义视图时从jar包获取文件出错");
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return classes;
	}

	/**
	 * 以文件的形式来获取包下的所有Class
	 *
	 * @param packageName
	 * @param packagePath
	 * @param recursive
	 * @param classes
	 */
	public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean
			recursive,
														Set<Class<?>> classes) {
		// 获取此包的目录 建立一个File
		File dir = new File(packagePath);
		// 如果不存在或者 也不是目录就直接返回
		if (!dir.exists() || !dir.isDirectory()) {
			// log.warn("用户定义包名 " + packageName + " 下没有任何文件");
			return;
		}
		// 如果存在 就获取包下的所有文件 包括目录
		File[] dirfiles = dir.listFiles(new FileFilter() {
			// 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
			@Override
			public boolean accept(File file) {
				return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
			}
		});
		// 循环所有文件
		for (File file : dirfiles) {
			// 如果是目录 则继续扫描
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive,
						classes);
			} else {
				// 如果是java类文件 去掉后面的.class 只留下类名
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					// 添加到集合中去
					// classes.add(Class.forName(packageName + '.' +
					// className));
					classes.add(
							Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}


	/**
	 * 循环向上转型, 获取对象的 DeclaredField
	 *
	 * @param
	 * @param
	 * @return
	 */

	public List<Field> getClassAllFields(Class<?> clazz, List<Field> allGenericFields) {

		// 如果clazz为空则直接返回
		if (clazz == null) {
			return allGenericFields;
		}
		Object parent = clazz.getGenericSuperclass();
		// 如果有父类并且父类不是Object 则递归调用
		if (parent != null && !((Class<?>) parent).getName().equals("Object")) {
			getClassAllFields((Class<?>) parent, allGenericFields);
		}
		Field[] fields = clazz.getDeclaredFields();
		if (fields != null) {// 如果clazz存在声明的属性
			for (int i = 0; i < fields.length; i++)
				allGenericFields.add(fields[i]);
		}

		return allGenericFields;
	}

	/**
	 * 判断一个类是否为基本数据类型。
	 *
	 * @param clazz 要判断的类。
	 * @return true 表示为基本数据类型。
	 */
	protected boolean isBaseDataType(Class<?> clazz) throws Exception {
		return (clazz.equals(String.class) || clazz.equals(Integer.class) || clazz.equals(Byte.class)
				|| clazz.equals(Long.class) || clazz.equals(Double.class) || clazz.equals(Float.class)
				|| clazz.equals(Character.class) || clazz.equals(Short.class) || clazz.equals(BigDecimal.class)
				|| clazz.equals(BigInteger.class) || clazz.equals(Boolean.class) ||
				// clazz.equals(Date.class) ||
//                clazz.equals(Money.class) ||
				clazz.isEnum() || clazz.isPrimitive());
	}



    /**
     * 发送get请求，返回内容字符串
     */
    public String httpGet(String url) {
        String result = null;
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            CloseableHttpResponse response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}