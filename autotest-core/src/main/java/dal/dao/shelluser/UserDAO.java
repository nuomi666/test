package dal.dao.shelluser;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.shelluser.UserDO;
import dal.model.shelluser.UserDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDAO extends MyMapper<UserDO> {
    long countByExample(UserDOExample example);

    int deleteByExample(UserDOExample example);

    List<UserDO> selectByExample(UserDOExample example);

    int updateByExampleSelective(@Param("record") UserDO record, @Param("example") UserDOExample example);

    int updateByExample(@Param("record") UserDO record, @Param("example") UserDOExample example);
}