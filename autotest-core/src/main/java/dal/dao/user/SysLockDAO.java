package dal.dao.user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.user.SysLockDO;
import dal.model.user.SysLockDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLockDAO extends MyMapper<SysLockDO> {
    long countByExample(SysLockDOExample example);

    int deleteByExample(SysLockDOExample example);

    List<SysLockDO> selectByExample(SysLockDOExample example);

    int updateByExampleSelective(@Param("record") SysLockDO record, @Param("example") SysLockDOExample example);

    int updateByExample(@Param("record") SysLockDO record, @Param("example") SysLockDOExample example);
}