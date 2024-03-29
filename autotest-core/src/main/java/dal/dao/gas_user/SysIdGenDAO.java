package dal.dao.gas_user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_user.SysIdGenDO;
import dal.model.gas_user.SysIdGenDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysIdGenDAO extends MyMapper<SysIdGenDO> {
    long countByExample(SysIdGenDOExample example);

    int deleteByExample(SysIdGenDOExample example);

    List<SysIdGenDO> selectByExample(SysIdGenDOExample example);

    int updateByExampleSelective(@Param("record") SysIdGenDO record, @Param("example") SysIdGenDOExample example);

    int updateByExample(@Param("record") SysIdGenDO record, @Param("example") SysIdGenDOExample example);
}