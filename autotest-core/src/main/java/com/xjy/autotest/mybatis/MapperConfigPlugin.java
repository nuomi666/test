package com.xjy.autotest.mybatis;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.util.StringUtility;
import org.mybatis.generator.internal.util.messages.Messages;

/**
 * Created by ychaoyang on 2017/8/2.
 */
public class MapperConfigPlugin extends PluginAdapter {
    private List<String> mapperFiles = new ArrayList();

    public MapperConfigPlugin() {
    }

    @Override
    public boolean validate(List<String> warnings) {
        boolean valid = true;
        if (!StringUtility.stringHasValue(this.properties.getProperty("targetProject"))) {
            warnings.add(Messages.getString("ValidationError.18", "MapperConfigPlugin", "targetProject"));
            valid = false;
        }

        if (!StringUtility.stringHasValue(this.properties.getProperty("targetPackage"))) {
            warnings.add(Messages.getString("ValidationError.18", "MapperConfigPlugin", "targetPackage"));
            valid = false;
        }

        return valid;
    }

    @Override
    public List<GeneratedXmlFile> contextGenerateAdditionalXmlFiles() {
        Document document = new Document("-//mybatis.org//DTD Config 3.0//EN", "http://mybatis.org/dtd/mybatis-3-config.dtd");
        XmlElement root = new XmlElement("configuration");
        document.setRootElement(root);
        root.addElement(new TextElement("<!--"));
        root.addElement(new TextElement("  This file is generated by MyBatis Generator."));
        root.addElement(new TextElement("-->"));
        XmlElement mappers = new XmlElement("mappers");
        root.addElement(mappers);
        Iterator var6 = this.mapperFiles.iterator();

        while (var6.hasNext()) {
            String mapperFile = (String) var6.next();
            XmlElement mapper = new XmlElement("mapper");
            mapper.addAttribute(new Attribute("resource", mapperFile));
            mappers.addElement(mapper);
        }

        GeneratedXmlFile gxf = new GeneratedXmlFile(document, this.properties.getProperty("fileName", "MapperConfig.xml"), this.properties.getProperty("targetPackage"), this.properties.getProperty("targetProject"), false, this.context.getXmlFormatter());
        List<GeneratedXmlFile> answer = new ArrayList(1);
        answer.add(gxf);
        return answer;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        StringBuilder sb = new StringBuilder();
        sb.append(sqlMap.getTargetPackage());
        sb.append('.');
        String temp = sb.toString();
        sb.setLength(0);
        sb.append(temp.replace('.', '/'));
        sb.append(sqlMap.getFileName());
        this.mapperFiles.add(sb.toString());
        return true;
    }
}
