package dal.dao.user;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.user.AccountChangeLogDO;
import dal.model.user.AccountChangeLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountChangeLogDAO extends MyMapper<AccountChangeLogDO> {
    long countByExample(AccountChangeLogDOExample example);

    int deleteByExample(AccountChangeLogDOExample example);

    List<AccountChangeLogDO> selectByExample(AccountChangeLogDOExample example);

    int updateByExampleSelective(@Param("record") AccountChangeLogDO record, @Param("example") AccountChangeLogDOExample example);

    int updateByExample(@Param("record") AccountChangeLogDO record, @Param("example") AccountChangeLogDOExample example);
}