package dal.dao.gas_user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_user.NotifyTaskDO;
import dal.model.gas_user.NotifyTaskDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotifyTaskDAO extends MyMapper<NotifyTaskDO> {
    long countByExample(NotifyTaskDOExample example);

    int deleteByExample(NotifyTaskDOExample example);

    List<NotifyTaskDO> selectByExampleWithBLOBs(NotifyTaskDOExample example);

    List<NotifyTaskDO> selectByExample(NotifyTaskDOExample example);

    int updateByExampleSelective(@Param("record") NotifyTaskDO record, @Param("example") NotifyTaskDOExample example);

    int updateByExampleWithBLOBs(@Param("record") NotifyTaskDO record, @Param("example") NotifyTaskDOExample example);

    int updateByExample(@Param("record") NotifyTaskDO record, @Param("example") NotifyTaskDOExample example);
}