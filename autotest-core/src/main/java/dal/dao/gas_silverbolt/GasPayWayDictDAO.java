package dal.dao.gas_silverbolt;

import com.xjy.autotest.annotation.MyMapper;
import dal.model.gas_silverbolt.GasPayWayDictDO;
import dal.model.gas_silverbolt.GasPayWayDictDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GasPayWayDictDAO extends MyMapper<GasPayWayDictDO> {
    long countByExample(GasPayWayDictDOExample example);

    int deleteByExample(GasPayWayDictDOExample example);

    List<GasPayWayDictDO> selectByExample(GasPayWayDictDOExample example);

    int updateByExampleSelective(@Param("record") GasPayWayDictDO record, @Param("example") GasPayWayDictDOExample example);

    int updateByExample(@Param("record") GasPayWayDictDO record, @Param("example") GasPayWayDictDOExample example);
}