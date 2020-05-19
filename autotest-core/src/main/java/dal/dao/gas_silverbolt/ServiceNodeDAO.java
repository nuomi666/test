package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.ServiceNodeDO;
import dal.model.gas_silverbolt.ServiceNodeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceNodeDAO extends MyMapper<ServiceNodeDO> {
    long countByExample(ServiceNodeDOExample example);

    int deleteByExample(ServiceNodeDOExample example);

    List<ServiceNodeDO> selectByExample(ServiceNodeDOExample example);

    int updateByExampleSelective(@Param("record") ServiceNodeDO record, @Param("example") ServiceNodeDOExample example);

    int updateByExample(@Param("record") ServiceNodeDO record, @Param("example") ServiceNodeDOExample example);
}