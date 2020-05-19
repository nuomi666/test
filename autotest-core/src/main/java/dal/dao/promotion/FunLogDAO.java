package dal.dao.promotion;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.promotion.FunLogDO;
import dal.model.promotion.FunLogDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunLogDAO extends MyMapper<FunLogDO> {
    long countByExample(FunLogDOExample example);

    int deleteByExample(FunLogDOExample example);

    List<FunLogDO> selectByExample(FunLogDOExample example);

    int updateByExampleSelective(@Param("record") FunLogDO record, @Param("example") FunLogDOExample example);

    int updateByExample(@Param("record") FunLogDO record, @Param("example") FunLogDOExample example);
}