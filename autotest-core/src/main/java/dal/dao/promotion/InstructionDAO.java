package dal.dao.promotion;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.promotion.InstructionDO;
import dal.model.promotion.InstructionDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InstructionDAO extends MyMapper<InstructionDO> {
    long countByExample(InstructionDOExample example);

    int deleteByExample(InstructionDOExample example);

    List<InstructionDO> selectByExampleWithBLOBs(InstructionDOExample example);

    List<InstructionDO> selectByExample(InstructionDOExample example);

    int updateByExampleSelective(@Param("record") InstructionDO record, @Param("example") InstructionDOExample example);

    int updateByExampleWithBLOBs(@Param("record") InstructionDO record, @Param("example") InstructionDOExample example);

    int updateByExample(@Param("record") InstructionDO record, @Param("example") InstructionDOExample example);
}