package com.xjy.autotest.testbase;

import java.util.List;
import java.util.Date;
import com.xjy.autotest.base.AutoTestBase;
import com.xjy.autotest.utils.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Import;
import com.xyb.adk.common.util.money.Money;
import java.math.BigDecimal;
import dal.dao.gas_merchant.*;
import dal.model.gas_merchant.*;
import com.xjy.autotest.config.Gas_merchantDataSourceConfig;

/**
 * @author autotest
 * Created on 2019/11/18.
 */
@Service
@Import({
        Gas_merchantDataSourceConfig.class
})
public class Gas_merchantTestBase extends AutoTestBase{

	@Autowired
	BaseStationDAO baseStationDAO;

	@Autowired
	BaseTradeBkDAO baseTradeBkDAO;

	@Autowired
	BaseTradeCopy1DAO baseTradeCopy1DAO;

	@Autowired
	BaseTradeDAO baseTradeDAO;

	@Autowired
	DListDAO dListDAO;

	@Autowired
	DayAmountDAO dayAmountDAO;

	@Autowired
	DianxinDAO dianxinDAO;

	@Autowired
	GasCityDAO gasCityDAO;

	@Autowired
	GasDevicePrintDAO gasDevicePrintDAO;

	@Autowired
	GasDeviceResourceDAO gasDeviceResourceDAO;

	@Autowired
	GasDictDataDAO gasDictDataDAO;

	@Autowired
	GasDictTypeDAO gasDictTypeDAO;

	@Autowired
	GasDistrictDAO gasDistrictDAO;

	@Autowired
	GasGoodsDAO gasGoodsDAO;

	@Autowired
	GasInvoiceCompanyDAO gasInvoiceCompanyDAO;

	@Autowired
	GasInvoiceConfigDAO gasInvoiceConfigDAO;

	@Autowired
	GasLoginLogDAO gasLoginLogDAO;

	@Autowired
	GasMallExchangeGoodsDAO gasMallExchangeGoodsDAO;

	@Autowired
	GasMallExchangeRecordDAO gasMallExchangeRecordDAO;

	@Autowired
	GasMerchantCardDAO gasMerchantCardDAO;

	@Autowired
	GasMerchantCardObjectDAO gasMerchantCardObjectDAO;

	@Autowired
	GasMerchantCardRuleDAO gasMerchantCardRuleDAO;

	@Autowired
	GasMerchantDAO gasMerchantDAO;

	@Autowired
	GasMerchantDeviceDAO gasMerchantDeviceDAO;

	@Autowired
	GasMerchantDeviceFunctionDAO gasMerchantDeviceFunctionDAO;

	@Autowired
	GasMerchantGoodsDAO gasMerchantGoodsDAO;

	@Autowired
	GasMerchantGoodsPricePlanDAO gasMerchantGoodsPricePlanDAO;

	@Autowired
	GasMerchantMotorcadeDAO gasMerchantMotorcadeDAO;

	@Autowired
	GasMerchantPaywayDAO gasMerchantPaywayDAO;

	@Autowired
	GasMerchantResourceDAO gasMerchantResourceDAO;

	@Autowired
	GasMerchantRoleDAO gasMerchantRoleDAO;

	@Autowired
	GasMerchantRoleResourceDAO gasMerchantRoleResourceDAO;

	@Autowired
	GasMerchantSourceDataDAO gasMerchantSourceDataDAO;

	@Autowired
	GasMerchantStationDAO gasMerchantStationDAO;

	@Autowired
	GasMerchantUserDAO gasMerchantUserDAO;

	@Autowired
	GasMerchantUserStationDAO gasMerchantUserStationDAO;

	@Autowired
	GasOilStationDescriptionDAO gasOilStationDescriptionDAO;

	@Autowired
	GasPartnerMappingDAO gasPartnerMappingDAO;

	@Autowired
	GasProvinceDAO gasProvinceDAO;

	@Autowired
	GasRoleDAO gasRoleDAO;

	@Autowired
	GasRuleDescriptionDAO gasRuleDescriptionDAO;

	@Autowired
	GasStationGoodsDAO gasStationGoodsDAO;

	@Autowired
	GasStationGoodsPricePlanDAO gasStationGoodsPricePlanDAO;

	@Autowired
	GasStationOilGunDAO gasStationOilGunDAO;

	@Autowired
	GasStationVoiceBroadcastDAO gasStationVoiceBroadcastDAO;

	@Autowired
	GasTicketPrintDAO gasTicketPrintDAO;

	@Autowired
	GasTradeNotifyTaskWashDAO gasTradeNotifyTaskWashDAO;

	@Autowired
	GasVoiceBroadcastFieldDAO gasVoiceBroadcastFieldDAO;

	@Autowired
	GasWechatTokenDAO gasWechatTokenDAO;

	@Autowired
	MerchantProtocolRuleDAO merchantProtocolRuleDAO;

	@Autowired
	NotifyTaskDAO notifyTaskDAO;

	@Autowired
	SListDAO sListDAO;

	@Autowired
	Sheet1DAO sheet1DAO;

	@Autowired
	SingleDAO singleDAO;

	@Autowired
	StationChannalDAO stationChannalDAO;

	@Autowired
	SysIdGenDAO sysIdGenDAO;

	@Autowired
	SysSeqDAO sysSeqDAO;

	@Autowired
	TOrderDAO tOrderDAO;

	@Autowired
	TOrderItemDAO tOrderItemDAO;

	@Autowired
	TmpPointsGoodsMapDAO tmpPointsGoodsMapDAO;

	public BaseStationDAO getBaseStationDAO() {
		return this.baseStationDAO;
	}

	public BaseTradeBkDAO getBaseTradeBkDAO() {
		return this.baseTradeBkDAO;
	}

	public BaseTradeCopy1DAO getBaseTradeCopy1DAO() {
		return this.baseTradeCopy1DAO;
	}

	public BaseTradeDAO getBaseTradeDAO() {
		return this.baseTradeDAO;
	}

	public DListDAO getDListDAO() {
		return this.dListDAO;
	}

	public DayAmountDAO getDayAmountDAO() {
		return this.dayAmountDAO;
	}

	public DianxinDAO getDianxinDAO() {
		return this.dianxinDAO;
	}

	public GasCityDAO getGasCityDAO() {
		return this.gasCityDAO;
	}

	public GasDevicePrintDAO getGasDevicePrintDAO() {
		return this.gasDevicePrintDAO;
	}

	public GasDeviceResourceDAO getGasDeviceResourceDAO() {
		return this.gasDeviceResourceDAO;
	}

	public GasDictDataDAO getGasDictDataDAO() {
		return this.gasDictDataDAO;
	}

	public GasDictTypeDAO getGasDictTypeDAO() {
		return this.gasDictTypeDAO;
	}

	public GasDistrictDAO getGasDistrictDAO() {
		return this.gasDistrictDAO;
	}

	public GasGoodsDAO getGasGoodsDAO() {
		return this.gasGoodsDAO;
	}

	public GasInvoiceCompanyDAO getGasInvoiceCompanyDAO() {
		return this.gasInvoiceCompanyDAO;
	}

	public GasInvoiceConfigDAO getGasInvoiceConfigDAO() {
		return this.gasInvoiceConfigDAO;
	}

	public GasLoginLogDAO getGasLoginLogDAO() {
		return this.gasLoginLogDAO;
	}

	public GasMallExchangeGoodsDAO getGasMallExchangeGoodsDAO() {
		return this.gasMallExchangeGoodsDAO;
	}

	public GasMallExchangeRecordDAO getGasMallExchangeRecordDAO() {
		return this.gasMallExchangeRecordDAO;
	}

	public GasMerchantCardDAO getGasMerchantCardDAO() {
		return this.gasMerchantCardDAO;
	}

	public GasMerchantCardObjectDAO getGasMerchantCardObjectDAO() {
		return this.gasMerchantCardObjectDAO;
	}

	public GasMerchantCardRuleDAO getGasMerchantCardRuleDAO() {
		return this.gasMerchantCardRuleDAO;
	}

	public GasMerchantDAO getGasMerchantDAO() {
		return this.gasMerchantDAO;
	}

	public GasMerchantDeviceDAO getGasMerchantDeviceDAO() {
		return this.gasMerchantDeviceDAO;
	}

	public GasMerchantDeviceFunctionDAO getGasMerchantDeviceFunctionDAO() {
		return this.gasMerchantDeviceFunctionDAO;
	}

	public GasMerchantGoodsDAO getGasMerchantGoodsDAO() {
		return this.gasMerchantGoodsDAO;
	}

	public GasMerchantGoodsPricePlanDAO getGasMerchantGoodsPricePlanDAO() {
		return this.gasMerchantGoodsPricePlanDAO;
	}

	public GasMerchantMotorcadeDAO getGasMerchantMotorcadeDAO() {
		return this.gasMerchantMotorcadeDAO;
	}

	public GasMerchantPaywayDAO getGasMerchantPaywayDAO() {
		return this.gasMerchantPaywayDAO;
	}

	public GasMerchantResourceDAO getGasMerchantResourceDAO() {
		return this.gasMerchantResourceDAO;
	}

	public GasMerchantRoleDAO getGasMerchantRoleDAO() {
		return this.gasMerchantRoleDAO;
	}

	public GasMerchantRoleResourceDAO getGasMerchantRoleResourceDAO() {
		return this.gasMerchantRoleResourceDAO;
	}

	public GasMerchantSourceDataDAO getGasMerchantSourceDataDAO() {
		return this.gasMerchantSourceDataDAO;
	}

	public GasMerchantStationDAO getGasMerchantStationDAO() {
		return this.gasMerchantStationDAO;
	}

	public GasMerchantUserDAO getGasMerchantUserDAO() {
		return this.gasMerchantUserDAO;
	}

	public GasMerchantUserStationDAO getGasMerchantUserStationDAO() {
		return this.gasMerchantUserStationDAO;
	}

	public GasOilStationDescriptionDAO getGasOilStationDescriptionDAO() {
		return this.gasOilStationDescriptionDAO;
	}

	public GasPartnerMappingDAO getGasPartnerMappingDAO() {
		return this.gasPartnerMappingDAO;
	}

	public GasProvinceDAO getGasProvinceDAO() {
		return this.gasProvinceDAO;
	}

	public GasRoleDAO getGasRoleDAO() {
		return this.gasRoleDAO;
	}

	public GasRuleDescriptionDAO getGasRuleDescriptionDAO() {
		return this.gasRuleDescriptionDAO;
	}

	public GasStationGoodsDAO getGasStationGoodsDAO() {
		return this.gasStationGoodsDAO;
	}

	public GasStationGoodsPricePlanDAO getGasStationGoodsPricePlanDAO() {
		return this.gasStationGoodsPricePlanDAO;
	}

	public GasStationOilGunDAO getGasStationOilGunDAO() {
		return this.gasStationOilGunDAO;
	}

	public GasStationVoiceBroadcastDAO getGasStationVoiceBroadcastDAO() {
		return this.gasStationVoiceBroadcastDAO;
	}

	public GasTicketPrintDAO getGasTicketPrintDAO() {
		return this.gasTicketPrintDAO;
	}

	public GasTradeNotifyTaskWashDAO getGasTradeNotifyTaskWashDAO() {
		return this.gasTradeNotifyTaskWashDAO;
	}

	public GasVoiceBroadcastFieldDAO getGasVoiceBroadcastFieldDAO() {
		return this.gasVoiceBroadcastFieldDAO;
	}

	public GasWechatTokenDAO getGasWechatTokenDAO() {
		return this.gasWechatTokenDAO;
	}

	public MerchantProtocolRuleDAO getMerchantProtocolRuleDAO() {
		return this.merchantProtocolRuleDAO;
	}

	public NotifyTaskDAO getNotifyTaskDAO() {
		return this.notifyTaskDAO;
	}

	public SListDAO getSListDAO() {
		return this.sListDAO;
	}

	public Sheet1DAO getSheet1DAO() {
		return this.sheet1DAO;
	}

	public SingleDAO getSingleDAO() {
		return this.singleDAO;
	}

	public StationChannalDAO getStationChannalDAO() {
		return this.stationChannalDAO;
	}

	public SysIdGenDAO getSysIdGenDAO() {
		return this.sysIdGenDAO;
	}

	public SysSeqDAO getSysSeqDAO() {
		return this.sysSeqDAO;
	}

	public TOrderDAO getTOrderDAO() {
		return this.tOrderDAO;
	}

	public TOrderItemDAO getTOrderItemDAO() {
		return this.tOrderItemDAO;
	}

	public TmpPointsGoodsMapDAO getTmpPointsGoodsMapDAO() {
		return this.tmpPointsGoodsMapDAO;
	}


    /**
	 * 断言base_station表
	 */
	public void baseStationAssert(
	        BaseStationDO baseStationDO,
			Integer id, 
			String stationName, 
			Date addTime, 
			Date tradeTime, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String terminalCode, 
			Long stationP, 
			Long stationC, 
			Long stationD, 
			String type, 
			String stationAddres
	) {
        assertEquals(id, baseStationDO.getId());
        assertEquals(stationName, baseStationDO.getStationName());
        assertEquals(addTime, baseStationDO.getAddTime());
        assertEquals(tradeTime, baseStationDO.getTradeTime());
        assertEquals(partnerId, baseStationDO.getPartnerId());
        assertEquals(partnerName, baseStationDO.getPartnerName());
        assertEquals(stationId, baseStationDO.getStationId());
        assertEquals(stationCode, baseStationDO.getStationCode());
        assertEquals(terminalCode, baseStationDO.getTerminalCode());
        assertEquals(stationP, baseStationDO.getStationP());
        assertEquals(stationC, baseStationDO.getStationC());
        assertEquals(stationD, baseStationDO.getStationD());
        assertEquals(type, baseStationDO.getType());
        assertEquals(stationAddres, baseStationDO.getStationAddres());
	}

	/**
	 * 断言base_station表数据
	 */
	public void assertBaseStation(BaseStationDO expect, BaseStationDO baseStationDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			baseStationDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, baseStationDO);
	}

    /**
	 * 插入base_station表数据
	 */
	public void insertBaseStation(BaseStationDO baseStationDO) {
		baseStationDAO.insert(baseStationDO);
	}

    /**
	 * 插入base_station表数据
	 */
	public void insertBaseStation(
			Integer id, 
			String stationName, 
			Date addTime, 
			Date tradeTime, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String terminalCode, 
			Long stationP, 
			Long stationC, 
			Long stationD, 
			String type, 
			String stationAddres
	) {
		if (addTime == null) {
			addTime = new Date();
		}
		if (tradeTime == null) {
			tradeTime = new Date();
		}
		BaseStationDO baseStationDO = new BaseStationDO();
		baseStationDO.setId(id);
		baseStationDO.setStationName(stationName);
		baseStationDO.setAddTime(addTime);
		baseStationDO.setTradeTime(tradeTime);
		baseStationDO.setPartnerId(partnerId);
		baseStationDO.setPartnerName(partnerName);
		baseStationDO.setStationId(stationId);
		baseStationDO.setStationCode(stationCode);
		baseStationDO.setTerminalCode(terminalCode);
		baseStationDO.setStationP(stationP);
		baseStationDO.setStationC(stationC);
		baseStationDO.setStationD(stationD);
		baseStationDO.setType(type);
		baseStationDO.setStationAddres(stationAddres);
		baseStationDAO.insert(baseStationDO);
	}

    /**
     * 删除base_station表所有数据
     */
    public void cleanBaseStation() {
        BaseStationDOExample exam = new BaseStationDOExample();
        exam.createCriteria();
        baseStationDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除base_station表数据
	 */
	public void cleanBaseStationById(Integer id) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		baseStationDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除base_station表数据
	*/
	public void cleanBaseStationByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		baseStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除base_station表数据
	 */
	public void cleanBaseStationByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		baseStationDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除base_station表数据
	*/
	public void cleanBaseStationByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		baseStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除base_station表数据
	 */
	public void cleanBaseStationByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		baseStationDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除base_station表数据
	*/
	public void cleanBaseStationByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		baseStationDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除base_station表数据
	*/
	public void cleanBaseStationByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		baseStationDAO.deleteByExample(exam);
	}

    /**
     * 查询base_station表所有数据
     */
    public List<BaseStationDO> findBaseStationAll() {
        BaseStationDOExample exam = new BaseStationDOExample();
        exam.createCriteria();
		return baseStationDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询base_station表数据
	 */
	public List<BaseStationDO> findBaseStationById(Integer id) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return baseStationDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询base_station表数据
	*/
	public List<BaseStationDO> findBaseStationByStationName(String stationName) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return baseStationDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询base_station表数据
	 */
	public List<BaseStationDO> findBaseStationByPartnerId(String partnerId) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return baseStationDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询base_station表数据
	*/
	public List<BaseStationDO> findBaseStationByPartnerName(String partnerName) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return baseStationDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询base_station表数据
	 */
	public List<BaseStationDO> findBaseStationByStationId(String stationId) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return baseStationDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询base_station表数据
	*/
	public List<BaseStationDO> findBaseStationByStationCode(String stationCode) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return baseStationDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询base_station表数据
	*/
	public List<BaseStationDO> findBaseStationByTerminalCode(String terminalCode) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return baseStationDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新base_station表数据
	 */
	public void updateBaseStationById(Integer id,BaseStationDO baseStationDO) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		baseStationDAO.updateByExample(baseStationDO, exam);
	}

	/**
	* 根据stationName更新base_station表数据
	*/
	public void updateBaseStationByStationName(String stationName,BaseStationDO baseStationDO) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		baseStationDAO.updateByExample(baseStationDO, exam);
	}

    /**
	 * 根据partnerId更新base_station表数据
	 */
	public void updateBaseStationByPartnerId(String partnerId,BaseStationDO baseStationDO) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		baseStationDAO.updateByExample(baseStationDO, exam);
	}

	/**
	* 根据partnerName更新base_station表数据
	*/
	public void updateBaseStationByPartnerName(String partnerName,BaseStationDO baseStationDO) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		baseStationDAO.updateByExample(baseStationDO, exam);
	}

    /**
	 * 根据stationId更新base_station表数据
	 */
	public void updateBaseStationByStationId(String stationId,BaseStationDO baseStationDO) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		baseStationDAO.updateByExample(baseStationDO, exam);
	}

	/**
	* 根据stationCode更新base_station表数据
	*/
	public void updateBaseStationByStationCode(String stationCode,BaseStationDO baseStationDO) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		baseStationDAO.updateByExample(baseStationDO, exam);
	}

	/**
	* 根据terminalCode更新base_station表数据
	*/
	public void updateBaseStationByTerminalCode(String terminalCode,BaseStationDO baseStationDO) {
		BaseStationDOExample exam = new BaseStationDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		baseStationDAO.updateByExample(baseStationDO, exam);
	}

    /**
	 * 断言base_trade_bk表
	 */
	public void baseTradeBkAssert(
	        BaseTradeBkDO baseTradeBkDO,
			Integer id, 
			String identity, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String terminalCode, 
			Long amount, 
			Date day, 
			String status
	) {
        assertEquals(id, baseTradeBkDO.getId());
        assertEquals(identity, baseTradeBkDO.getIdentity());
        assertEquals(partnerId, baseTradeBkDO.getPartnerId());
        assertEquals(partnerName, baseTradeBkDO.getPartnerName());
        assertEquals(stationId, baseTradeBkDO.getStationId());
        assertEquals(stationCode, baseTradeBkDO.getStationCode());
        assertEquals(stationName, baseTradeBkDO.getStationName());
        assertEquals(terminalCode, baseTradeBkDO.getTerminalCode());
        assertEquals(amount, baseTradeBkDO.getAmount());
        assertEquals(day, baseTradeBkDO.getDay());
        assertEquals(status, baseTradeBkDO.getStatus());
	}

	/**
	 * 断言base_trade_bk表数据
	 */
	public void assertBaseTradeBk(BaseTradeBkDO expect, BaseTradeBkDO baseTradeBkDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			baseTradeBkDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, baseTradeBkDO);
	}

    /**
	 * 插入base_trade_bk表数据
	 */
	public void insertBaseTradeBk(BaseTradeBkDO baseTradeBkDO) {
		baseTradeBkDAO.insert(baseTradeBkDO);
	}

    /**
	 * 插入base_trade_bk表数据
	 */
	public void insertBaseTradeBk(
			Integer id, 
			String identity, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String terminalCode, 
			Long amount, 
			Date day, 
			String status
	) {
		if (day == null) {
			day = new Date();
		}
		BaseTradeBkDO baseTradeBkDO = new BaseTradeBkDO();
		baseTradeBkDO.setId(id);
		baseTradeBkDO.setIdentity(identity);
		baseTradeBkDO.setPartnerId(partnerId);
		baseTradeBkDO.setPartnerName(partnerName);
		baseTradeBkDO.setStationId(stationId);
		baseTradeBkDO.setStationCode(stationCode);
		baseTradeBkDO.setStationName(stationName);
		baseTradeBkDO.setTerminalCode(terminalCode);
		baseTradeBkDO.setAmount(amount);
		baseTradeBkDO.setDay(day);
		baseTradeBkDO.setStatus(status);
		baseTradeBkDAO.insert(baseTradeBkDO);
	}

    /**
     * 删除base_trade_bk表所有数据
     */
    public void cleanBaseTradeBk() {
        BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
        exam.createCriteria();
        baseTradeBkDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除base_trade_bk表数据
	 */
	public void cleanBaseTradeBkById(Integer id) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andIdEqualTo(id);
		baseTradeBkDAO.deleteByExample(exam);
	}

	/**
	 * 根据identity删除base_trade_bk表数据
	 */
	public void cleanBaseTradeBkByIdentity(String identity) {
        if (StringUtils.isBlank(identity)){
            identity = "test_identity";
        }
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		baseTradeBkDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除base_trade_bk表数据
	 */
	public void cleanBaseTradeBkByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		baseTradeBkDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除base_trade_bk表数据
	*/
	public void cleanBaseTradeBkByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		baseTradeBkDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除base_trade_bk表数据
	 */
	public void cleanBaseTradeBkByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		baseTradeBkDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除base_trade_bk表数据
	*/
	public void cleanBaseTradeBkByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		baseTradeBkDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除base_trade_bk表数据
	*/
	public void cleanBaseTradeBkByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		baseTradeBkDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除base_trade_bk表数据
	*/
	public void cleanBaseTradeBkByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		baseTradeBkDAO.deleteByExample(exam);
	}

    /**
     * 查询base_trade_bk表所有数据
     */
    public List<BaseTradeBkDO> findBaseTradeBkAll() {
        BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
        exam.createCriteria();
		return baseTradeBkDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询base_trade_bk表数据
	 */
	public List<BaseTradeBkDO> findBaseTradeBkById(Integer id) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return baseTradeBkDAO.selectByExample(exam);
	}

    /**
	 * 根据identity查询base_trade_bk表数据
	 */
	public List<BaseTradeBkDO> findBaseTradeBkByIdentity(String identity) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		return baseTradeBkDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询base_trade_bk表数据
	 */
	public List<BaseTradeBkDO> findBaseTradeBkByPartnerId(String partnerId) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return baseTradeBkDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询base_trade_bk表数据
	*/
	public List<BaseTradeBkDO> findBaseTradeBkByPartnerName(String partnerName) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return baseTradeBkDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询base_trade_bk表数据
	 */
	public List<BaseTradeBkDO> findBaseTradeBkByStationId(String stationId) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return baseTradeBkDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询base_trade_bk表数据
	*/
	public List<BaseTradeBkDO> findBaseTradeBkByStationCode(String stationCode) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return baseTradeBkDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询base_trade_bk表数据
	*/
	public List<BaseTradeBkDO> findBaseTradeBkByStationName(String stationName) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return baseTradeBkDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询base_trade_bk表数据
	*/
	public List<BaseTradeBkDO> findBaseTradeBkByTerminalCode(String terminalCode) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return baseTradeBkDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新base_trade_bk表数据
	 */
	public void updateBaseTradeBkById(Integer id,BaseTradeBkDO baseTradeBkDO) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andIdEqualTo(id);
		baseTradeBkDAO.updateByExample(baseTradeBkDO, exam);
	}

    /**
	 * 根据identity更新base_trade_bk表数据
	 */
	public void updateBaseTradeBkByIdentity(String identity,BaseTradeBkDO baseTradeBkDO) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		baseTradeBkDAO.updateByExample(baseTradeBkDO, exam);
	}

    /**
	 * 根据partnerId更新base_trade_bk表数据
	 */
	public void updateBaseTradeBkByPartnerId(String partnerId,BaseTradeBkDO baseTradeBkDO) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		baseTradeBkDAO.updateByExample(baseTradeBkDO, exam);
	}

	/**
	* 根据partnerName更新base_trade_bk表数据
	*/
	public void updateBaseTradeBkByPartnerName(String partnerName,BaseTradeBkDO baseTradeBkDO) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		baseTradeBkDAO.updateByExample(baseTradeBkDO, exam);
	}

    /**
	 * 根据stationId更新base_trade_bk表数据
	 */
	public void updateBaseTradeBkByStationId(String stationId,BaseTradeBkDO baseTradeBkDO) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		baseTradeBkDAO.updateByExample(baseTradeBkDO, exam);
	}

	/**
	* 根据stationCode更新base_trade_bk表数据
	*/
	public void updateBaseTradeBkByStationCode(String stationCode,BaseTradeBkDO baseTradeBkDO) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		baseTradeBkDAO.updateByExample(baseTradeBkDO, exam);
	}

	/**
	* 根据stationName更新base_trade_bk表数据
	*/
	public void updateBaseTradeBkByStationName(String stationName,BaseTradeBkDO baseTradeBkDO) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		baseTradeBkDAO.updateByExample(baseTradeBkDO, exam);
	}

	/**
	* 根据terminalCode更新base_trade_bk表数据
	*/
	public void updateBaseTradeBkByTerminalCode(String terminalCode,BaseTradeBkDO baseTradeBkDO) {
		BaseTradeBkDOExample exam = new BaseTradeBkDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		baseTradeBkDAO.updateByExample(baseTradeBkDO, exam);
	}

    /**
	 * 断言base_trade_copy1表
	 */
	public void baseTradeCopy1Assert(
	        BaseTradeCopy1DO baseTradeCopy1DO,
			Integer id, 
			String identity, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String terminalCode, 
			Long amount, 
			Date day, 
			String status
	) {
        assertEquals(id, baseTradeCopy1DO.getId());
        assertEquals(identity, baseTradeCopy1DO.getIdentity());
        assertEquals(partnerId, baseTradeCopy1DO.getPartnerId());
        assertEquals(partnerName, baseTradeCopy1DO.getPartnerName());
        assertEquals(stationId, baseTradeCopy1DO.getStationId());
        assertEquals(stationCode, baseTradeCopy1DO.getStationCode());
        assertEquals(stationName, baseTradeCopy1DO.getStationName());
        assertEquals(terminalCode, baseTradeCopy1DO.getTerminalCode());
        assertEquals(amount, baseTradeCopy1DO.getAmount());
        assertEquals(day, baseTradeCopy1DO.getDay());
        assertEquals(status, baseTradeCopy1DO.getStatus());
	}

	/**
	 * 断言base_trade_copy1表数据
	 */
	public void assertBaseTradeCopy1(BaseTradeCopy1DO expect, BaseTradeCopy1DO baseTradeCopy1DO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			baseTradeCopy1DO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, baseTradeCopy1DO);
	}

    /**
	 * 插入base_trade_copy1表数据
	 */
	public void insertBaseTradeCopy1(BaseTradeCopy1DO baseTradeCopy1DO) {
		baseTradeCopy1DAO.insert(baseTradeCopy1DO);
	}

    /**
	 * 插入base_trade_copy1表数据
	 */
	public void insertBaseTradeCopy1(
			Integer id, 
			String identity, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String terminalCode, 
			Long amount, 
			Date day, 
			String status
	) {
		if (day == null) {
			day = new Date();
		}
		BaseTradeCopy1DO baseTradeCopy1DO = new BaseTradeCopy1DO();
		baseTradeCopy1DO.setId(id);
		baseTradeCopy1DO.setIdentity(identity);
		baseTradeCopy1DO.setPartnerId(partnerId);
		baseTradeCopy1DO.setPartnerName(partnerName);
		baseTradeCopy1DO.setStationId(stationId);
		baseTradeCopy1DO.setStationCode(stationCode);
		baseTradeCopy1DO.setStationName(stationName);
		baseTradeCopy1DO.setTerminalCode(terminalCode);
		baseTradeCopy1DO.setAmount(amount);
		baseTradeCopy1DO.setDay(day);
		baseTradeCopy1DO.setStatus(status);
		baseTradeCopy1DAO.insert(baseTradeCopy1DO);
	}

    /**
     * 删除base_trade_copy1表所有数据
     */
    public void cleanBaseTradeCopy1() {
        BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
        exam.createCriteria();
        baseTradeCopy1DAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除base_trade_copy1表数据
	 */
	public void cleanBaseTradeCopy1ById(Integer id) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andIdEqualTo(id);
		baseTradeCopy1DAO.deleteByExample(exam);
	}

	/**
	 * 根据identity删除base_trade_copy1表数据
	 */
	public void cleanBaseTradeCopy1ByIdentity(String identity) {
        if (StringUtils.isBlank(identity)){
            identity = "test_identity";
        }
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		baseTradeCopy1DAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除base_trade_copy1表数据
	 */
	public void cleanBaseTradeCopy1ByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		baseTradeCopy1DAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除base_trade_copy1表数据
	*/
	public void cleanBaseTradeCopy1ByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		baseTradeCopy1DAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除base_trade_copy1表数据
	 */
	public void cleanBaseTradeCopy1ByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		baseTradeCopy1DAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除base_trade_copy1表数据
	*/
	public void cleanBaseTradeCopy1ByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		baseTradeCopy1DAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除base_trade_copy1表数据
	*/
	public void cleanBaseTradeCopy1ByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		baseTradeCopy1DAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除base_trade_copy1表数据
	*/
	public void cleanBaseTradeCopy1ByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		baseTradeCopy1DAO.deleteByExample(exam);
	}

    /**
     * 查询base_trade_copy1表所有数据
     */
    public List<BaseTradeCopy1DO> findBaseTradeCopy1All() {
        BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
        exam.createCriteria();
		return baseTradeCopy1DAO.selectByExample(exam);
    }

    /**
	 * 根据id查询base_trade_copy1表数据
	 */
	public List<BaseTradeCopy1DO> findBaseTradeCopy1ById(Integer id) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andIdEqualTo(id);
		return baseTradeCopy1DAO.selectByExample(exam);
	}

    /**
	 * 根据identity查询base_trade_copy1表数据
	 */
	public List<BaseTradeCopy1DO> findBaseTradeCopy1ByIdentity(String identity) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		return baseTradeCopy1DAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询base_trade_copy1表数据
	 */
	public List<BaseTradeCopy1DO> findBaseTradeCopy1ByPartnerId(String partnerId) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return baseTradeCopy1DAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询base_trade_copy1表数据
	*/
	public List<BaseTradeCopy1DO> findBaseTradeCopy1ByPartnerName(String partnerName) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return baseTradeCopy1DAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询base_trade_copy1表数据
	 */
	public List<BaseTradeCopy1DO> findBaseTradeCopy1ByStationId(String stationId) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return baseTradeCopy1DAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询base_trade_copy1表数据
	*/
	public List<BaseTradeCopy1DO> findBaseTradeCopy1ByStationCode(String stationCode) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return baseTradeCopy1DAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询base_trade_copy1表数据
	*/
	public List<BaseTradeCopy1DO> findBaseTradeCopy1ByStationName(String stationName) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return baseTradeCopy1DAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询base_trade_copy1表数据
	*/
	public List<BaseTradeCopy1DO> findBaseTradeCopy1ByTerminalCode(String terminalCode) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return baseTradeCopy1DAO.selectByExample(exam);
	}

    /**
	 * 根据id更新base_trade_copy1表数据
	 */
	public void updateBaseTradeCopy1ById(Integer id,BaseTradeCopy1DO baseTradeCopy1DO) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andIdEqualTo(id);
		baseTradeCopy1DAO.updateByExample(baseTradeCopy1DO, exam);
	}

    /**
	 * 根据identity更新base_trade_copy1表数据
	 */
	public void updateBaseTradeCopy1ByIdentity(String identity,BaseTradeCopy1DO baseTradeCopy1DO) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		baseTradeCopy1DAO.updateByExample(baseTradeCopy1DO, exam);
	}

    /**
	 * 根据partnerId更新base_trade_copy1表数据
	 */
	public void updateBaseTradeCopy1ByPartnerId(String partnerId,BaseTradeCopy1DO baseTradeCopy1DO) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		baseTradeCopy1DAO.updateByExample(baseTradeCopy1DO, exam);
	}

	/**
	* 根据partnerName更新base_trade_copy1表数据
	*/
	public void updateBaseTradeCopy1ByPartnerName(String partnerName,BaseTradeCopy1DO baseTradeCopy1DO) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		baseTradeCopy1DAO.updateByExample(baseTradeCopy1DO, exam);
	}

    /**
	 * 根据stationId更新base_trade_copy1表数据
	 */
	public void updateBaseTradeCopy1ByStationId(String stationId,BaseTradeCopy1DO baseTradeCopy1DO) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		baseTradeCopy1DAO.updateByExample(baseTradeCopy1DO, exam);
	}

	/**
	* 根据stationCode更新base_trade_copy1表数据
	*/
	public void updateBaseTradeCopy1ByStationCode(String stationCode,BaseTradeCopy1DO baseTradeCopy1DO) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		baseTradeCopy1DAO.updateByExample(baseTradeCopy1DO, exam);
	}

	/**
	* 根据stationName更新base_trade_copy1表数据
	*/
	public void updateBaseTradeCopy1ByStationName(String stationName,BaseTradeCopy1DO baseTradeCopy1DO) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		baseTradeCopy1DAO.updateByExample(baseTradeCopy1DO, exam);
	}

	/**
	* 根据terminalCode更新base_trade_copy1表数据
	*/
	public void updateBaseTradeCopy1ByTerminalCode(String terminalCode,BaseTradeCopy1DO baseTradeCopy1DO) {
		BaseTradeCopy1DOExample exam = new BaseTradeCopy1DOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		baseTradeCopy1DAO.updateByExample(baseTradeCopy1DO, exam);
	}

    /**
	 * 断言base_trade表
	 */
	public void baseTradeAssert(
	        BaseTradeDO baseTradeDO,
			Integer id, 
			String identity, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String terminalCode, 
			Long amount, 
			Date day, 
			String status
	) {
        assertEquals(id, baseTradeDO.getId());
        assertEquals(identity, baseTradeDO.getIdentity());
        assertEquals(partnerId, baseTradeDO.getPartnerId());
        assertEquals(partnerName, baseTradeDO.getPartnerName());
        assertEquals(stationId, baseTradeDO.getStationId());
        assertEquals(stationCode, baseTradeDO.getStationCode());
        assertEquals(stationName, baseTradeDO.getStationName());
        assertEquals(terminalCode, baseTradeDO.getTerminalCode());
        assertEquals(amount, baseTradeDO.getAmount());
        assertEquals(day, baseTradeDO.getDay());
        assertEquals(status, baseTradeDO.getStatus());
	}

	/**
	 * 断言base_trade表数据
	 */
	public void assertBaseTrade(BaseTradeDO expect, BaseTradeDO baseTradeDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			baseTradeDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, baseTradeDO);
	}

    /**
	 * 插入base_trade表数据
	 */
	public void insertBaseTrade(BaseTradeDO baseTradeDO) {
		baseTradeDAO.insert(baseTradeDO);
	}

    /**
	 * 插入base_trade表数据
	 */
	public void insertBaseTrade(
			Integer id, 
			String identity, 
			String partnerId, 
			String partnerName, 
			String stationId, 
			String stationCode, 
			String stationName, 
			String terminalCode, 
			Long amount, 
			Date day, 
			String status
	) {
		if (day == null) {
			day = new Date();
		}
		BaseTradeDO baseTradeDO = new BaseTradeDO();
		baseTradeDO.setId(id);
		baseTradeDO.setIdentity(identity);
		baseTradeDO.setPartnerId(partnerId);
		baseTradeDO.setPartnerName(partnerName);
		baseTradeDO.setStationId(stationId);
		baseTradeDO.setStationCode(stationCode);
		baseTradeDO.setStationName(stationName);
		baseTradeDO.setTerminalCode(terminalCode);
		baseTradeDO.setAmount(amount);
		baseTradeDO.setDay(day);
		baseTradeDO.setStatus(status);
		baseTradeDAO.insert(baseTradeDO);
	}

    /**
     * 删除base_trade表所有数据
     */
    public void cleanBaseTrade() {
        BaseTradeDOExample exam = new BaseTradeDOExample();
        exam.createCriteria();
        baseTradeDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除base_trade表数据
	 */
	public void cleanBaseTradeById(Integer id) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		baseTradeDAO.deleteByExample(exam);
	}

	/**
	 * 根据identity删除base_trade表数据
	 */
	public void cleanBaseTradeByIdentity(String identity) {
        if (StringUtils.isBlank(identity)){
            identity = "test_identity";
        }
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		baseTradeDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除base_trade表数据
	 */
	public void cleanBaseTradeByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		baseTradeDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除base_trade表数据
	*/
	public void cleanBaseTradeByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		baseTradeDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除base_trade表数据
	 */
	public void cleanBaseTradeByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		baseTradeDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除base_trade表数据
	*/
	public void cleanBaseTradeByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		baseTradeDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除base_trade表数据
	*/
	public void cleanBaseTradeByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		baseTradeDAO.deleteByExample(exam);
	}

	/**
	* 根据terminalCode删除base_trade表数据
	*/
	public void cleanBaseTradeByTerminalCode(String terminalCode) {
        if (StringUtils.isBlank(terminalCode)){
            terminalCode = "test_terminalCode";
        }
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		baseTradeDAO.deleteByExample(exam);
	}

    /**
     * 查询base_trade表所有数据
     */
    public List<BaseTradeDO> findBaseTradeAll() {
        BaseTradeDOExample exam = new BaseTradeDOExample();
        exam.createCriteria();
		return baseTradeDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询base_trade表数据
	 */
	public List<BaseTradeDO> findBaseTradeById(Integer id) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return baseTradeDAO.selectByExample(exam);
	}

    /**
	 * 根据identity查询base_trade表数据
	 */
	public List<BaseTradeDO> findBaseTradeByIdentity(String identity) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		return baseTradeDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询base_trade表数据
	 */
	public List<BaseTradeDO> findBaseTradeByPartnerId(String partnerId) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return baseTradeDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询base_trade表数据
	*/
	public List<BaseTradeDO> findBaseTradeByPartnerName(String partnerName) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return baseTradeDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询base_trade表数据
	 */
	public List<BaseTradeDO> findBaseTradeByStationId(String stationId) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return baseTradeDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询base_trade表数据
	*/
	public List<BaseTradeDO> findBaseTradeByStationCode(String stationCode) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return baseTradeDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询base_trade表数据
	*/
	public List<BaseTradeDO> findBaseTradeByStationName(String stationName) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return baseTradeDAO.selectByExample(exam);
	}

	/**
	* 根据terminalCode查询base_trade表数据
	*/
	public List<BaseTradeDO> findBaseTradeByTerminalCode(String terminalCode) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		return baseTradeDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新base_trade表数据
	 */
	public void updateBaseTradeById(Integer id,BaseTradeDO baseTradeDO) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		baseTradeDAO.updateByExample(baseTradeDO, exam);
	}

    /**
	 * 根据identity更新base_trade表数据
	 */
	public void updateBaseTradeByIdentity(String identity,BaseTradeDO baseTradeDO) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		baseTradeDAO.updateByExample(baseTradeDO, exam);
	}

    /**
	 * 根据partnerId更新base_trade表数据
	 */
	public void updateBaseTradeByPartnerId(String partnerId,BaseTradeDO baseTradeDO) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		baseTradeDAO.updateByExample(baseTradeDO, exam);
	}

	/**
	* 根据partnerName更新base_trade表数据
	*/
	public void updateBaseTradeByPartnerName(String partnerName,BaseTradeDO baseTradeDO) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		baseTradeDAO.updateByExample(baseTradeDO, exam);
	}

    /**
	 * 根据stationId更新base_trade表数据
	 */
	public void updateBaseTradeByStationId(String stationId,BaseTradeDO baseTradeDO) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		baseTradeDAO.updateByExample(baseTradeDO, exam);
	}

	/**
	* 根据stationCode更新base_trade表数据
	*/
	public void updateBaseTradeByStationCode(String stationCode,BaseTradeDO baseTradeDO) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		baseTradeDAO.updateByExample(baseTradeDO, exam);
	}

	/**
	* 根据stationName更新base_trade表数据
	*/
	public void updateBaseTradeByStationName(String stationName,BaseTradeDO baseTradeDO) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		baseTradeDAO.updateByExample(baseTradeDO, exam);
	}

	/**
	* 根据terminalCode更新base_trade表数据
	*/
	public void updateBaseTradeByTerminalCode(String terminalCode,BaseTradeDO baseTradeDO) {
		BaseTradeDOExample exam = new BaseTradeDOExample();
		exam.createCriteria().andTerminalCodeEqualTo(terminalCode);
		baseTradeDAO.updateByExample(baseTradeDO, exam);
	}

    /**
	 * 断言d_list表
	 */
	public void dListAssert(
	        DListDO dListDO,
			String name, 
			String name1, 
			String c1, 
			String c2, 
			String c3, 
			String c4, 
			String c5, 
			String c6, 
			String c7, 
			String c8, 
			String c9, 
			String c10
	) {
        assertEquals(name, dListDO.getName());
        assertEquals(name1, dListDO.getName1());
        assertEquals(c1, dListDO.getC1());
        assertEquals(c2, dListDO.getC2());
        assertEquals(c3, dListDO.getC3());
        assertEquals(c4, dListDO.getC4());
        assertEquals(c5, dListDO.getC5());
        assertEquals(c6, dListDO.getC6());
        assertEquals(c7, dListDO.getC7());
        assertEquals(c8, dListDO.getC8());
        assertEquals(c9, dListDO.getC9());
        assertEquals(c10, dListDO.getC10());
	}

	/**
	 * 断言d_list表数据
	 */
	public void assertDList(DListDO expect, DListDO dListDO) {
		Assertions.assertEquals(expect, dListDO);
	}

    /**
	 * 插入d_list表数据
	 */
	public void insertDList(DListDO dListDO) {
		dListDAO.insert(dListDO);
	}

    /**
	 * 插入d_list表数据
	 */
	public void insertDList(
			String name, 
			String name1, 
			String c1, 
			String c2, 
			String c3, 
			String c4, 
			String c5, 
			String c6, 
			String c7, 
			String c8, 
			String c9, 
			String c10
	) {
		DListDO dListDO = new DListDO();
		dListDO.setName(name);
		dListDO.setName1(name1);
		dListDO.setC1(c1);
		dListDO.setC2(c2);
		dListDO.setC3(c3);
		dListDO.setC4(c4);
		dListDO.setC5(c5);
		dListDO.setC6(c6);
		dListDO.setC7(c7);
		dListDO.setC8(c8);
		dListDO.setC9(c9);
		dListDO.setC10(c10);
		dListDAO.insert(dListDO);
	}

    /**
     * 删除d_list表所有数据
     */
    public void cleanDList() {
        DListDOExample exam = new DListDOExample();
        exam.createCriteria();
        dListDAO.deleteByExample(exam);
    }


	/**
	* 根据name删除d_list表数据
	*/
	public void cleanDListByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		DListDOExample exam = new DListDOExample();
		exam.createCriteria().andNameEqualTo(name);
		dListDAO.deleteByExample(exam);
	}

	/**
	* 根据name1删除d_list表数据
	*/
	public void cleanDListByName1(String name1) {
        if (StringUtils.isBlank(name1)){
            name1 = "test_name1";
        }
		DListDOExample exam = new DListDOExample();
		exam.createCriteria().andName1EqualTo(name1);
		dListDAO.deleteByExample(exam);
	}

    /**
     * 查询d_list表所有数据
     */
    public List<DListDO> findDListAll() {
        DListDOExample exam = new DListDOExample();
        exam.createCriteria();
		return dListDAO.selectByExample(exam);
    }

	/**
	* 根据name查询d_list表数据
	*/
	public List<DListDO> findDListByName(String name) {
		DListDOExample exam = new DListDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return dListDAO.selectByExample(exam);
	}

	/**
	* 根据name1查询d_list表数据
	*/
	public List<DListDO> findDListByName1(String name1) {
		DListDOExample exam = new DListDOExample();
		exam.createCriteria().andName1EqualTo(name1);
		return dListDAO.selectByExample(exam);
	}

	/**
	* 根据name更新d_list表数据
	*/
	public void updateDListByName(String name,DListDO dListDO) {
		DListDOExample exam = new DListDOExample();
		exam.createCriteria().andNameEqualTo(name);
		dListDAO.updateByExample(dListDO, exam);
	}

	/**
	* 根据name1更新d_list表数据
	*/
	public void updateDListByName1(String name1,DListDO dListDO) {
		DListDOExample exam = new DListDOExample();
		exam.createCriteria().andName1EqualTo(name1);
		dListDAO.updateByExample(dListDO, exam);
	}

    /**
	 * 断言day_amount表
	 */
	public void dayAmountAssert(
	        DayAmountDO dayAmountDO,
			Integer id, 
			String day, 
			String amount
	) {
        assertEquals(id, dayAmountDO.getId());
        assertEquals(day, dayAmountDO.getDay());
        assertEquals(amount, dayAmountDO.getAmount());
	}

	/**
	 * 断言day_amount表数据
	 */
	public void assertDayAmount(DayAmountDO expect, DayAmountDO dayAmountDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			dayAmountDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, dayAmountDO);
	}

    /**
	 * 插入day_amount表数据
	 */
	public void insertDayAmount(DayAmountDO dayAmountDO) {
		dayAmountDAO.insert(dayAmountDO);
	}

    /**
	 * 插入day_amount表数据
	 */
	public void insertDayAmount(
			Integer id, 
			String day, 
			String amount
	) {
		DayAmountDO dayAmountDO = new DayAmountDO();
		dayAmountDO.setId(id);
		dayAmountDO.setDay(day);
		dayAmountDO.setAmount(amount);
		dayAmountDAO.insert(dayAmountDO);
	}

    /**
     * 删除day_amount表所有数据
     */
    public void cleanDayAmount() {
        DayAmountDOExample exam = new DayAmountDOExample();
        exam.createCriteria();
        dayAmountDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除day_amount表数据
	 */
	public void cleanDayAmountById(Integer id) {
		DayAmountDOExample exam = new DayAmountDOExample();
		exam.createCriteria().andIdEqualTo(id);
		dayAmountDAO.deleteByExample(exam);
	}

    /**
     * 查询day_amount表所有数据
     */
    public List<DayAmountDO> findDayAmountAll() {
        DayAmountDOExample exam = new DayAmountDOExample();
        exam.createCriteria();
		return dayAmountDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询day_amount表数据
	 */
	public List<DayAmountDO> findDayAmountById(Integer id) {
		DayAmountDOExample exam = new DayAmountDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return dayAmountDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新day_amount表数据
	 */
	public void updateDayAmountById(Integer id,DayAmountDO dayAmountDO) {
		DayAmountDOExample exam = new DayAmountDOExample();
		exam.createCriteria().andIdEqualTo(id);
		dayAmountDAO.updateByExample(dayAmountDO, exam);
	}

    /**
	 * 断言dianxin表
	 */
	public void dianxinAssert(
	        DianxinDO dianxinDO,
			String name, 
			String userName, 
			String p, 
			String pName, 
			String c, 
			String cName, 
			String d, 
			String dName, 
			String addres, 
			String temp, 
			String type, 
			String num
	) {
        assertEquals(name, dianxinDO.getName());
        assertEquals(userName, dianxinDO.getUserName());
        assertEquals(p, dianxinDO.getP());
        assertEquals(pName, dianxinDO.getpName());
        assertEquals(c, dianxinDO.getC());
        assertEquals(cName, dianxinDO.getcName());
        assertEquals(d, dianxinDO.getD());
        assertEquals(dName, dianxinDO.getdName());
        assertEquals(addres, dianxinDO.getAddres());
        assertEquals(temp, dianxinDO.getTemp());
        assertEquals(type, dianxinDO.getType());
        assertEquals(num, dianxinDO.getNum());
	}

	/**
	 * 断言dianxin表数据
	 */
	public void assertDianxin(DianxinDO expect, DianxinDO dianxinDO) {
		Assertions.assertEquals(expect, dianxinDO);
	}

    /**
	 * 插入dianxin表数据
	 */
	public void insertDianxin(DianxinDO dianxinDO) {
		dianxinDAO.insert(dianxinDO);
	}

    /**
	 * 插入dianxin表数据
	 */
	public void insertDianxin(
			String name, 
			String userName, 
			String p, 
			String pName, 
			String c, 
			String cName, 
			String d, 
			String dName, 
			String addres, 
			String temp, 
			String type, 
			String num
	) {
		DianxinDO dianxinDO = new DianxinDO();
		dianxinDO.setName(name);
		dianxinDO.setUserName(userName);
		dianxinDO.setP(p);
		dianxinDO.setpName(pName);
		dianxinDO.setC(c);
		dianxinDO.setcName(cName);
		dianxinDO.setD(d);
		dianxinDO.setdName(dName);
		dianxinDO.setAddres(addres);
		dianxinDO.setTemp(temp);
		dianxinDO.setType(type);
		dianxinDO.setNum(num);
		dianxinDAO.insert(dianxinDO);
	}

    /**
     * 删除dianxin表所有数据
     */
    public void cleanDianxin() {
        DianxinDOExample exam = new DianxinDOExample();
        exam.createCriteria();
        dianxinDAO.deleteByExample(exam);
    }


	/**
	* 根据name删除dianxin表数据
	*/
	public void cleanDianxinByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andNameEqualTo(name);
		dianxinDAO.deleteByExample(exam);
	}

	/**
	* 根据userName删除dianxin表数据
	*/
	public void cleanDianxinByUserName(String userName) {
        if (StringUtils.isBlank(userName)){
            userName = "test_userName";
        }
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		dianxinDAO.deleteByExample(exam);
	}

	/**
	* 根据pName删除dianxin表数据
	*/
	public void cleanDianxinByPName(String pName) {
        if (StringUtils.isBlank(pName)){
            pName = "test_pName";
        }
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andPNameEqualTo(pName);
		dianxinDAO.deleteByExample(exam);
	}

	/**
	* 根据cName删除dianxin表数据
	*/
	public void cleanDianxinByCName(String cName) {
        if (StringUtils.isBlank(cName)){
            cName = "test_cName";
        }
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andCNameEqualTo(cName);
		dianxinDAO.deleteByExample(exam);
	}

	/**
	* 根据dName删除dianxin表数据
	*/
	public void cleanDianxinByDName(String dName) {
        if (StringUtils.isBlank(dName)){
            dName = "test_dName";
        }
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andDNameEqualTo(dName);
		dianxinDAO.deleteByExample(exam);
	}

    /**
     * 查询dianxin表所有数据
     */
    public List<DianxinDO> findDianxinAll() {
        DianxinDOExample exam = new DianxinDOExample();
        exam.createCriteria();
		return dianxinDAO.selectByExample(exam);
    }

	/**
	* 根据name查询dianxin表数据
	*/
	public List<DianxinDO> findDianxinByName(String name) {
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return dianxinDAO.selectByExample(exam);
	}

	/**
	* 根据userName查询dianxin表数据
	*/
	public List<DianxinDO> findDianxinByUserName(String userName) {
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		return dianxinDAO.selectByExample(exam);
	}

	/**
	* 根据pName查询dianxin表数据
	*/
	public List<DianxinDO> findDianxinByPName(String pName) {
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andPNameEqualTo(pName);
		return dianxinDAO.selectByExample(exam);
	}

	/**
	* 根据cName查询dianxin表数据
	*/
	public List<DianxinDO> findDianxinByCName(String cName) {
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andCNameEqualTo(cName);
		return dianxinDAO.selectByExample(exam);
	}

	/**
	* 根据dName查询dianxin表数据
	*/
	public List<DianxinDO> findDianxinByDName(String dName) {
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andDNameEqualTo(dName);
		return dianxinDAO.selectByExample(exam);
	}

	/**
	* 根据name更新dianxin表数据
	*/
	public void updateDianxinByName(String name,DianxinDO dianxinDO) {
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andNameEqualTo(name);
		dianxinDAO.updateByExample(dianxinDO, exam);
	}

	/**
	* 根据userName更新dianxin表数据
	*/
	public void updateDianxinByUserName(String userName,DianxinDO dianxinDO) {
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		dianxinDAO.updateByExample(dianxinDO, exam);
	}

	/**
	* 根据pName更新dianxin表数据
	*/
	public void updateDianxinByPName(String pName,DianxinDO dianxinDO) {
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andPNameEqualTo(pName);
		dianxinDAO.updateByExample(dianxinDO, exam);
	}

	/**
	* 根据cName更新dianxin表数据
	*/
	public void updateDianxinByCName(String cName,DianxinDO dianxinDO) {
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andCNameEqualTo(cName);
		dianxinDAO.updateByExample(dianxinDO, exam);
	}

	/**
	* 根据dName更新dianxin表数据
	*/
	public void updateDianxinByDName(String dName,DianxinDO dianxinDO) {
		DianxinDOExample exam = new DianxinDOExample();
		exam.createCriteria().andDNameEqualTo(dName);
		dianxinDAO.updateByExample(dianxinDO, exam);
	}

    /**
	 * 断言gas_city表
	 */
	public void gasCityAssert(
	        GasCityDO gasCityDO,
			Long id, 
			String cityName, 
			String cityChar, 
			Long provinceId
	) {
        assertEquals(id, gasCityDO.getId());
        assertEquals(cityName, gasCityDO.getCityName());
        assertEquals(cityChar, gasCityDO.getCityChar());
        assertEquals(provinceId, gasCityDO.getProvinceId());
	}

	/**
	 * 断言gas_city表数据
	 */
	public void assertGasCity(GasCityDO expect, GasCityDO gasCityDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasCityDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasCityDO);
	}

    /**
	 * 插入gas_city表数据
	 */
	public void insertGasCity(GasCityDO gasCityDO) {
		gasCityDAO.insert(gasCityDO);
	}

    /**
	 * 插入gas_city表数据
	 */
	public void insertGasCity(
			Long id, 
			String cityName, 
			String cityChar, 
			Long provinceId
	) {
		GasCityDO gasCityDO = new GasCityDO();
		gasCityDO.setId(id);
		gasCityDO.setCityName(cityName);
		gasCityDO.setCityChar(cityChar);
		gasCityDO.setProvinceId(provinceId);
		gasCityDAO.insert(gasCityDO);
	}

    /**
     * 删除gas_city表所有数据
     */
    public void cleanGasCity() {
        GasCityDOExample exam = new GasCityDOExample();
        exam.createCriteria();
        gasCityDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_city表数据
	 */
	public void cleanGasCityById(Long id) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasCityDAO.deleteByExample(exam);
	}

	/**
	* 根据cityName删除gas_city表数据
	*/
	public void cleanGasCityByCityName(String cityName) {
        if (StringUtils.isBlank(cityName)){
            cityName = "test_cityName";
        }
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andCityNameEqualTo(cityName);
		gasCityDAO.deleteByExample(exam);
	}

	/**
	 * 根据provinceId删除gas_city表数据
	 */
	public void cleanGasCityByProvinceId(Long provinceId) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		gasCityDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_city表所有数据
     */
    public List<GasCityDO> findGasCityAll() {
        GasCityDOExample exam = new GasCityDOExample();
        exam.createCriteria();
		return gasCityDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_city表数据
	 */
	public List<GasCityDO> findGasCityById(Long id) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasCityDAO.selectByExample(exam);
	}

	/**
	* 根据cityName查询gas_city表数据
	*/
	public List<GasCityDO> findGasCityByCityName(String cityName) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andCityNameEqualTo(cityName);
		return gasCityDAO.selectByExample(exam);
	}

    /**
	 * 根据provinceId查询gas_city表数据
	 */
	public List<GasCityDO> findGasCityByProvinceId(Long provinceId) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		return gasCityDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_city表数据
	 */
	public void updateGasCityById(Long id,GasCityDO gasCityDO) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasCityDAO.updateByExample(gasCityDO, exam);
	}

	/**
	* 根据cityName更新gas_city表数据
	*/
	public void updateGasCityByCityName(String cityName,GasCityDO gasCityDO) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andCityNameEqualTo(cityName);
		gasCityDAO.updateByExample(gasCityDO, exam);
	}

    /**
	 * 根据provinceId更新gas_city表数据
	 */
	public void updateGasCityByProvinceId(Long provinceId,GasCityDO gasCityDO) {
		GasCityDOExample exam = new GasCityDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		gasCityDAO.updateByExample(gasCityDO, exam);
	}

    /**
	 * 断言gas_device_print表
	 */
	public void gasDevicePrintAssert(
	        GasDevicePrintDO gasDevicePrintDO,
			Long id, 
			String printId, 
			String platPartnerId, 
			String partnerId, 
			String stationId, 
			String deviceType, 
			String printType, 
			String printTitle, 
			Integer printSleep, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasDevicePrintDO.getId());
        assertEquals(printId, gasDevicePrintDO.getPrintId());
        assertEquals(platPartnerId, gasDevicePrintDO.getPlatPartnerId());
        assertEquals(partnerId, gasDevicePrintDO.getPartnerId());
        assertEquals(stationId, gasDevicePrintDO.getStationId());
        assertEquals(deviceType, gasDevicePrintDO.getDeviceType());
        assertEquals(printType, gasDevicePrintDO.getPrintType());
        assertEquals(printTitle, gasDevicePrintDO.getPrintTitle());
        assertEquals(printSleep, gasDevicePrintDO.getPrintSleep());
        assertEquals(rawAddTime, gasDevicePrintDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasDevicePrintDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_device_print表数据
	 */
	public void assertGasDevicePrint(GasDevicePrintDO expect, GasDevicePrintDO gasDevicePrintDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasDevicePrintDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasDevicePrintDO.getRawAddTime());
		expect.setRawAddTime(gasDevicePrintDO.getRawAddTime());
        Assertions.assertTrue(null != gasDevicePrintDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasDevicePrintDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasDevicePrintDO);
	}

    /**
	 * 插入gas_device_print表数据
	 */
	public void insertGasDevicePrint(GasDevicePrintDO gasDevicePrintDO) {
		gasDevicePrintDAO.insert(gasDevicePrintDO);
	}

    /**
	 * 插入gas_device_print表数据
	 */
	public void insertGasDevicePrint(
			Long id, 
			String printId, 
			String platPartnerId, 
			String partnerId, 
			String stationId, 
			String deviceType, 
			String printType, 
			String printTitle, 
			Integer printSleep, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasDevicePrintDO gasDevicePrintDO = new GasDevicePrintDO();
		gasDevicePrintDO.setId(id);
		gasDevicePrintDO.setPrintId(printId);
		gasDevicePrintDO.setPlatPartnerId(platPartnerId);
		gasDevicePrintDO.setPartnerId(partnerId);
		gasDevicePrintDO.setStationId(stationId);
		gasDevicePrintDO.setDeviceType(deviceType);
		gasDevicePrintDO.setPrintType(printType);
		gasDevicePrintDO.setPrintTitle(printTitle);
		gasDevicePrintDO.setPrintSleep(printSleep);
		gasDevicePrintDO.setRawAddTime(rawAddTime);
		gasDevicePrintDO.setRawUpdateTime(rawUpdateTime);
		gasDevicePrintDAO.insert(gasDevicePrintDO);
	}

    /**
     * 删除gas_device_print表所有数据
     */
    public void cleanGasDevicePrint() {
        GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
        exam.createCriteria();
        gasDevicePrintDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_device_print表数据
	 */
	public void cleanGasDevicePrintById(Long id) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDevicePrintDAO.deleteByExample(exam);
	}

	/**
	 * 根据printId删除gas_device_print表数据
	 */
	public void cleanGasDevicePrintByPrintId(String printId) {
        if (StringUtils.isBlank(printId)){
            printId = "test_printId";
        }
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPrintIdEqualTo(printId);
		gasDevicePrintDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_device_print表数据
	 */
	public void cleanGasDevicePrintByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasDevicePrintDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_device_print表数据
	 */
	public void cleanGasDevicePrintByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasDevicePrintDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_device_print表数据
	 */
	public void cleanGasDevicePrintByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasDevicePrintDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_device_print表所有数据
     */
    public List<GasDevicePrintDO> findGasDevicePrintAll() {
        GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
        exam.createCriteria();
		return gasDevicePrintDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_device_print表数据
	 */
	public List<GasDevicePrintDO> findGasDevicePrintById(Long id) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasDevicePrintDAO.selectByExample(exam);
	}

    /**
	 * 根据printId查询gas_device_print表数据
	 */
	public List<GasDevicePrintDO> findGasDevicePrintByPrintId(String printId) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPrintIdEqualTo(printId);
		return gasDevicePrintDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_device_print表数据
	 */
	public List<GasDevicePrintDO> findGasDevicePrintByPlatPartnerId(String platPartnerId) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasDevicePrintDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_device_print表数据
	 */
	public List<GasDevicePrintDO> findGasDevicePrintByPartnerId(String partnerId) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasDevicePrintDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_device_print表数据
	 */
	public List<GasDevicePrintDO> findGasDevicePrintByStationId(String stationId) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasDevicePrintDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_device_print表数据
	 */
	public void updateGasDevicePrintById(Long id,GasDevicePrintDO gasDevicePrintDO) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDevicePrintDAO.updateByExample(gasDevicePrintDO, exam);
	}

    /**
	 * 根据printId更新gas_device_print表数据
	 */
	public void updateGasDevicePrintByPrintId(String printId,GasDevicePrintDO gasDevicePrintDO) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPrintIdEqualTo(printId);
		gasDevicePrintDAO.updateByExample(gasDevicePrintDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_device_print表数据
	 */
	public void updateGasDevicePrintByPlatPartnerId(String platPartnerId,GasDevicePrintDO gasDevicePrintDO) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasDevicePrintDAO.updateByExample(gasDevicePrintDO, exam);
	}

    /**
	 * 根据partnerId更新gas_device_print表数据
	 */
	public void updateGasDevicePrintByPartnerId(String partnerId,GasDevicePrintDO gasDevicePrintDO) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasDevicePrintDAO.updateByExample(gasDevicePrintDO, exam);
	}

    /**
	 * 根据stationId更新gas_device_print表数据
	 */
	public void updateGasDevicePrintByStationId(String stationId,GasDevicePrintDO gasDevicePrintDO) {
		GasDevicePrintDOExample exam = new GasDevicePrintDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasDevicePrintDAO.updateByExample(gasDevicePrintDO, exam);
	}

    /**
	 * 断言gas_device_resource表
	 */
	public void gasDeviceResourceAssert(
	        GasDeviceResourceDO gasDeviceResourceDO,
			Long id, 
			String deviceType, 
			Long parentId, 
			String name, 
			String code, 
			String url, 
			String resourceType, 
			Integer orderNo, 
			String icon, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasDeviceResourceDO.getId());
        assertEquals(deviceType, gasDeviceResourceDO.getDeviceType());
        assertEquals(parentId, gasDeviceResourceDO.getParentId());
        assertEquals(name, gasDeviceResourceDO.getName());
        assertEquals(code, gasDeviceResourceDO.getCode());
        assertEquals(url, gasDeviceResourceDO.getUrl());
        assertEquals(resourceType, gasDeviceResourceDO.getResourceType());
        assertEquals(orderNo, gasDeviceResourceDO.getOrderNo());
        assertEquals(icon, gasDeviceResourceDO.getIcon());
        assertEquals(memo, gasDeviceResourceDO.getMemo());
        assertEquals(rawAddTime, gasDeviceResourceDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasDeviceResourceDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_device_resource表数据
	 */
	public void assertGasDeviceResource(GasDeviceResourceDO expect, GasDeviceResourceDO gasDeviceResourceDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasDeviceResourceDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasDeviceResourceDO.getRawAddTime());
		expect.setRawAddTime(gasDeviceResourceDO.getRawAddTime());
        Assertions.assertTrue(null != gasDeviceResourceDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasDeviceResourceDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasDeviceResourceDO);
	}

    /**
	 * 插入gas_device_resource表数据
	 */
	public void insertGasDeviceResource(GasDeviceResourceDO gasDeviceResourceDO) {
		gasDeviceResourceDAO.insert(gasDeviceResourceDO);
	}

    /**
	 * 插入gas_device_resource表数据
	 */
	public void insertGasDeviceResource(
			Long id, 
			String deviceType, 
			Long parentId, 
			String name, 
			String code, 
			String url, 
			String resourceType, 
			Integer orderNo, 
			String icon, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasDeviceResourceDO gasDeviceResourceDO = new GasDeviceResourceDO();
		gasDeviceResourceDO.setId(id);
		gasDeviceResourceDO.setDeviceType(deviceType);
		gasDeviceResourceDO.setParentId(parentId);
		gasDeviceResourceDO.setName(name);
		gasDeviceResourceDO.setCode(code);
		gasDeviceResourceDO.setUrl(url);
		gasDeviceResourceDO.setResourceType(resourceType);
		gasDeviceResourceDO.setOrderNo(orderNo);
		gasDeviceResourceDO.setIcon(icon);
		gasDeviceResourceDO.setMemo(memo);
		gasDeviceResourceDO.setRawAddTime(rawAddTime);
		gasDeviceResourceDO.setRawUpdateTime(rawUpdateTime);
		gasDeviceResourceDAO.insert(gasDeviceResourceDO);
	}

    /**
     * 删除gas_device_resource表所有数据
     */
    public void cleanGasDeviceResource() {
        GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
        exam.createCriteria();
        gasDeviceResourceDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_device_resource表数据
	 */
	public void cleanGasDeviceResourceById(Long id) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDeviceResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据parentId删除gas_device_resource表数据
	 */
	public void cleanGasDeviceResourceByParentId(Long parentId) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		gasDeviceResourceDAO.deleteByExample(exam);
	}

	/**
	* 根据name删除gas_device_resource表数据
	*/
	public void cleanGasDeviceResourceByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andNameEqualTo(name);
		gasDeviceResourceDAO.deleteByExample(exam);
	}

	/**
	* 根据code删除gas_device_resource表数据
	*/
	public void cleanGasDeviceResourceByCode(String code) {
        if (StringUtils.isBlank(code)){
            code = "test_code";
        }
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		gasDeviceResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据orderNo删除gas_device_resource表数据
	 */
	public void cleanGasDeviceResourceByOrderNo(Integer orderNo) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasDeviceResourceDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_device_resource表所有数据
     */
    public List<GasDeviceResourceDO> findGasDeviceResourceAll() {
        GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
        exam.createCriteria();
		return gasDeviceResourceDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_device_resource表数据
	 */
	public List<GasDeviceResourceDO> findGasDeviceResourceById(Long id) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasDeviceResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据parentId查询gas_device_resource表数据
	 */
	public List<GasDeviceResourceDO> findGasDeviceResourceByParentId(Long parentId) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		return gasDeviceResourceDAO.selectByExample(exam);
	}

	/**
	* 根据name查询gas_device_resource表数据
	*/
	public List<GasDeviceResourceDO> findGasDeviceResourceByName(String name) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return gasDeviceResourceDAO.selectByExample(exam);
	}

	/**
	* 根据code查询gas_device_resource表数据
	*/
	public List<GasDeviceResourceDO> findGasDeviceResourceByCode(String code) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		return gasDeviceResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据orderNo查询gas_device_resource表数据
	 */
	public List<GasDeviceResourceDO> findGasDeviceResourceByOrderNo(Integer orderNo) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		return gasDeviceResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_device_resource表数据
	 */
	public void updateGasDeviceResourceById(Long id,GasDeviceResourceDO gasDeviceResourceDO) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDeviceResourceDAO.updateByExample(gasDeviceResourceDO, exam);
	}

    /**
	 * 根据parentId更新gas_device_resource表数据
	 */
	public void updateGasDeviceResourceByParentId(Long parentId,GasDeviceResourceDO gasDeviceResourceDO) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		gasDeviceResourceDAO.updateByExample(gasDeviceResourceDO, exam);
	}

	/**
	* 根据name更新gas_device_resource表数据
	*/
	public void updateGasDeviceResourceByName(String name,GasDeviceResourceDO gasDeviceResourceDO) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andNameEqualTo(name);
		gasDeviceResourceDAO.updateByExample(gasDeviceResourceDO, exam);
	}

	/**
	* 根据code更新gas_device_resource表数据
	*/
	public void updateGasDeviceResourceByCode(String code,GasDeviceResourceDO gasDeviceResourceDO) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andCodeEqualTo(code);
		gasDeviceResourceDAO.updateByExample(gasDeviceResourceDO, exam);
	}

    /**
	 * 根据orderNo更新gas_device_resource表数据
	 */
	public void updateGasDeviceResourceByOrderNo(Integer orderNo,GasDeviceResourceDO gasDeviceResourceDO) {
		GasDeviceResourceDOExample exam = new GasDeviceResourceDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasDeviceResourceDAO.updateByExample(gasDeviceResourceDO, exam);
	}

    /**
	 * 断言gas_dict_data表
	 */
	public void gasDictDataAssert(
	        GasDictDataDO gasDictDataDO,
			Long id, 
			String typeCode, 
			String dataCode, 
			String dataName, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasDictDataDO.getId());
        assertEquals(typeCode, gasDictDataDO.getTypeCode());
        assertEquals(dataCode, gasDictDataDO.getDataCode());
        assertEquals(dataName, gasDictDataDO.getDataName());
        assertEquals(rawAddTime, gasDictDataDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasDictDataDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_dict_data表数据
	 */
	public void assertGasDictData(GasDictDataDO expect, GasDictDataDO gasDictDataDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasDictDataDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasDictDataDO.getRawAddTime());
		expect.setRawAddTime(gasDictDataDO.getRawAddTime());
        Assertions.assertTrue(null != gasDictDataDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasDictDataDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasDictDataDO);
	}

    /**
	 * 插入gas_dict_data表数据
	 */
	public void insertGasDictData(GasDictDataDO gasDictDataDO) {
		gasDictDataDAO.insert(gasDictDataDO);
	}

    /**
	 * 插入gas_dict_data表数据
	 */
	public void insertGasDictData(
			Long id, 
			String typeCode, 
			String dataCode, 
			String dataName, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasDictDataDO gasDictDataDO = new GasDictDataDO();
		gasDictDataDO.setId(id);
		gasDictDataDO.setTypeCode(typeCode);
		gasDictDataDO.setDataCode(dataCode);
		gasDictDataDO.setDataName(dataName);
		gasDictDataDO.setRawAddTime(rawAddTime);
		gasDictDataDO.setRawUpdateTime(rawUpdateTime);
		gasDictDataDAO.insert(gasDictDataDO);
	}

    /**
     * 删除gas_dict_data表所有数据
     */
    public void cleanGasDictData() {
        GasDictDataDOExample exam = new GasDictDataDOExample();
        exam.createCriteria();
        gasDictDataDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_dict_data表数据
	 */
	public void cleanGasDictDataById(Long id) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDictDataDAO.deleteByExample(exam);
	}

	/**
	* 根据typeCode删除gas_dict_data表数据
	*/
	public void cleanGasDictDataByTypeCode(String typeCode) {
        if (StringUtils.isBlank(typeCode)){
            typeCode = "test_typeCode";
        }
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andTypeCodeEqualTo(typeCode);
		gasDictDataDAO.deleteByExample(exam);
	}

	/**
	* 根据dataCode删除gas_dict_data表数据
	*/
	public void cleanGasDictDataByDataCode(String dataCode) {
        if (StringUtils.isBlank(dataCode)){
            dataCode = "test_dataCode";
        }
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andDataCodeEqualTo(dataCode);
		gasDictDataDAO.deleteByExample(exam);
	}

	/**
	* 根据dataName删除gas_dict_data表数据
	*/
	public void cleanGasDictDataByDataName(String dataName) {
        if (StringUtils.isBlank(dataName)){
            dataName = "test_dataName";
        }
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andDataNameEqualTo(dataName);
		gasDictDataDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_dict_data表所有数据
     */
    public List<GasDictDataDO> findGasDictDataAll() {
        GasDictDataDOExample exam = new GasDictDataDOExample();
        exam.createCriteria();
		return gasDictDataDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_dict_data表数据
	 */
	public List<GasDictDataDO> findGasDictDataById(Long id) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasDictDataDAO.selectByExample(exam);
	}

	/**
	* 根据typeCode查询gas_dict_data表数据
	*/
	public List<GasDictDataDO> findGasDictDataByTypeCode(String typeCode) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andTypeCodeEqualTo(typeCode);
		return gasDictDataDAO.selectByExample(exam);
	}

	/**
	* 根据dataCode查询gas_dict_data表数据
	*/
	public List<GasDictDataDO> findGasDictDataByDataCode(String dataCode) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andDataCodeEqualTo(dataCode);
		return gasDictDataDAO.selectByExample(exam);
	}

	/**
	* 根据dataName查询gas_dict_data表数据
	*/
	public List<GasDictDataDO> findGasDictDataByDataName(String dataName) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andDataNameEqualTo(dataName);
		return gasDictDataDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_dict_data表数据
	 */
	public void updateGasDictDataById(Long id,GasDictDataDO gasDictDataDO) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDictDataDAO.updateByExample(gasDictDataDO, exam);
	}

	/**
	* 根据typeCode更新gas_dict_data表数据
	*/
	public void updateGasDictDataByTypeCode(String typeCode,GasDictDataDO gasDictDataDO) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andTypeCodeEqualTo(typeCode);
		gasDictDataDAO.updateByExample(gasDictDataDO, exam);
	}

	/**
	* 根据dataCode更新gas_dict_data表数据
	*/
	public void updateGasDictDataByDataCode(String dataCode,GasDictDataDO gasDictDataDO) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andDataCodeEqualTo(dataCode);
		gasDictDataDAO.updateByExample(gasDictDataDO, exam);
	}

	/**
	* 根据dataName更新gas_dict_data表数据
	*/
	public void updateGasDictDataByDataName(String dataName,GasDictDataDO gasDictDataDO) {
		GasDictDataDOExample exam = new GasDictDataDOExample();
		exam.createCriteria().andDataNameEqualTo(dataName);
		gasDictDataDAO.updateByExample(gasDictDataDO, exam);
	}

    /**
	 * 断言gas_dict_type表
	 */
	public void gasDictTypeAssert(
	        GasDictTypeDO gasDictTypeDO,
			Long id, 
			String typeCode, 
			String typeName, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasDictTypeDO.getId());
        assertEquals(typeCode, gasDictTypeDO.getTypeCode());
        assertEquals(typeName, gasDictTypeDO.getTypeName());
        assertEquals(memo, gasDictTypeDO.getMemo());
        assertEquals(rawAddTime, gasDictTypeDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasDictTypeDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_dict_type表数据
	 */
	public void assertGasDictType(GasDictTypeDO expect, GasDictTypeDO gasDictTypeDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasDictTypeDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasDictTypeDO.getRawAddTime());
		expect.setRawAddTime(gasDictTypeDO.getRawAddTime());
        Assertions.assertTrue(null != gasDictTypeDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasDictTypeDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasDictTypeDO);
	}

    /**
	 * 插入gas_dict_type表数据
	 */
	public void insertGasDictType(GasDictTypeDO gasDictTypeDO) {
		gasDictTypeDAO.insert(gasDictTypeDO);
	}

    /**
	 * 插入gas_dict_type表数据
	 */
	public void insertGasDictType(
			Long id, 
			String typeCode, 
			String typeName, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasDictTypeDO gasDictTypeDO = new GasDictTypeDO();
		gasDictTypeDO.setId(id);
		gasDictTypeDO.setTypeCode(typeCode);
		gasDictTypeDO.setTypeName(typeName);
		gasDictTypeDO.setMemo(memo);
		gasDictTypeDO.setRawAddTime(rawAddTime);
		gasDictTypeDO.setRawUpdateTime(rawUpdateTime);
		gasDictTypeDAO.insert(gasDictTypeDO);
	}

    /**
     * 删除gas_dict_type表所有数据
     */
    public void cleanGasDictType() {
        GasDictTypeDOExample exam = new GasDictTypeDOExample();
        exam.createCriteria();
        gasDictTypeDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_dict_type表数据
	 */
	public void cleanGasDictTypeById(Long id) {
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDictTypeDAO.deleteByExample(exam);
	}

	/**
	* 根据typeCode删除gas_dict_type表数据
	*/
	public void cleanGasDictTypeByTypeCode(String typeCode) {
        if (StringUtils.isBlank(typeCode)){
            typeCode = "test_typeCode";
        }
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andTypeCodeEqualTo(typeCode);
		gasDictTypeDAO.deleteByExample(exam);
	}

	/**
	* 根据typeName删除gas_dict_type表数据
	*/
	public void cleanGasDictTypeByTypeName(String typeName) {
        if (StringUtils.isBlank(typeName)){
            typeName = "test_typeName";
        }
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andTypeNameEqualTo(typeName);
		gasDictTypeDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_dict_type表所有数据
     */
    public List<GasDictTypeDO> findGasDictTypeAll() {
        GasDictTypeDOExample exam = new GasDictTypeDOExample();
        exam.createCriteria();
		return gasDictTypeDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_dict_type表数据
	 */
	public List<GasDictTypeDO> findGasDictTypeById(Long id) {
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasDictTypeDAO.selectByExample(exam);
	}

	/**
	* 根据typeCode查询gas_dict_type表数据
	*/
	public List<GasDictTypeDO> findGasDictTypeByTypeCode(String typeCode) {
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andTypeCodeEqualTo(typeCode);
		return gasDictTypeDAO.selectByExample(exam);
	}

	/**
	* 根据typeName查询gas_dict_type表数据
	*/
	public List<GasDictTypeDO> findGasDictTypeByTypeName(String typeName) {
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andTypeNameEqualTo(typeName);
		return gasDictTypeDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_dict_type表数据
	 */
	public void updateGasDictTypeById(Long id,GasDictTypeDO gasDictTypeDO) {
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDictTypeDAO.updateByExample(gasDictTypeDO, exam);
	}

	/**
	* 根据typeCode更新gas_dict_type表数据
	*/
	public void updateGasDictTypeByTypeCode(String typeCode,GasDictTypeDO gasDictTypeDO) {
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andTypeCodeEqualTo(typeCode);
		gasDictTypeDAO.updateByExample(gasDictTypeDO, exam);
	}

	/**
	* 根据typeName更新gas_dict_type表数据
	*/
	public void updateGasDictTypeByTypeName(String typeName,GasDictTypeDO gasDictTypeDO) {
		GasDictTypeDOExample exam = new GasDictTypeDOExample();
		exam.createCriteria().andTypeNameEqualTo(typeName);
		gasDictTypeDAO.updateByExample(gasDictTypeDO, exam);
	}

    /**
	 * 断言gas_district表
	 */
	public void gasDistrictAssert(
	        GasDistrictDO gasDistrictDO,
			Long id, 
			String districtName, 
			String districtChar, 
			Long cityId
	) {
        assertEquals(id, gasDistrictDO.getId());
        assertEquals(districtName, gasDistrictDO.getDistrictName());
        assertEquals(districtChar, gasDistrictDO.getDistrictChar());
        assertEquals(cityId, gasDistrictDO.getCityId());
	}

	/**
	 * 断言gas_district表数据
	 */
	public void assertGasDistrict(GasDistrictDO expect, GasDistrictDO gasDistrictDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasDistrictDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasDistrictDO);
	}

    /**
	 * 插入gas_district表数据
	 */
	public void insertGasDistrict(GasDistrictDO gasDistrictDO) {
		gasDistrictDAO.insert(gasDistrictDO);
	}

    /**
	 * 插入gas_district表数据
	 */
	public void insertGasDistrict(
			Long id, 
			String districtName, 
			String districtChar, 
			Long cityId
	) {
		GasDistrictDO gasDistrictDO = new GasDistrictDO();
		gasDistrictDO.setId(id);
		gasDistrictDO.setDistrictName(districtName);
		gasDistrictDO.setDistrictChar(districtChar);
		gasDistrictDO.setCityId(cityId);
		gasDistrictDAO.insert(gasDistrictDO);
	}

    /**
     * 删除gas_district表所有数据
     */
    public void cleanGasDistrict() {
        GasDistrictDOExample exam = new GasDistrictDOExample();
        exam.createCriteria();
        gasDistrictDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_district表数据
	 */
	public void cleanGasDistrictById(Long id) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDistrictDAO.deleteByExample(exam);
	}

	/**
	* 根据districtName删除gas_district表数据
	*/
	public void cleanGasDistrictByDistrictName(String districtName) {
        if (StringUtils.isBlank(districtName)){
            districtName = "test_districtName";
        }
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andDistrictNameEqualTo(districtName);
		gasDistrictDAO.deleteByExample(exam);
	}

	/**
	 * 根据cityId删除gas_district表数据
	 */
	public void cleanGasDistrictByCityId(Long cityId) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		gasDistrictDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_district表所有数据
     */
    public List<GasDistrictDO> findGasDistrictAll() {
        GasDistrictDOExample exam = new GasDistrictDOExample();
        exam.createCriteria();
		return gasDistrictDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_district表数据
	 */
	public List<GasDistrictDO> findGasDistrictById(Long id) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasDistrictDAO.selectByExample(exam);
	}

	/**
	* 根据districtName查询gas_district表数据
	*/
	public List<GasDistrictDO> findGasDistrictByDistrictName(String districtName) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andDistrictNameEqualTo(districtName);
		return gasDistrictDAO.selectByExample(exam);
	}

    /**
	 * 根据cityId查询gas_district表数据
	 */
	public List<GasDistrictDO> findGasDistrictByCityId(Long cityId) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		return gasDistrictDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_district表数据
	 */
	public void updateGasDistrictById(Long id,GasDistrictDO gasDistrictDO) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasDistrictDAO.updateByExample(gasDistrictDO, exam);
	}

	/**
	* 根据districtName更新gas_district表数据
	*/
	public void updateGasDistrictByDistrictName(String districtName,GasDistrictDO gasDistrictDO) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andDistrictNameEqualTo(districtName);
		gasDistrictDAO.updateByExample(gasDistrictDO, exam);
	}

    /**
	 * 根据cityId更新gas_district表数据
	 */
	public void updateGasDistrictByCityId(Long cityId,GasDistrictDO gasDistrictDO) {
		GasDistrictDOExample exam = new GasDistrictDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		gasDistrictDAO.updateByExample(gasDistrictDO, exam);
	}

    /**
	 * 断言gas_goods表
	 */
	public void gasGoodsAssert(
	        GasGoodsDO gasGoodsDO,
			Long id, 
			String goodsType, 
			String goodsGroupType, 
			Long groupId, 
			String goodsName, 
			String goodsCode, 
			Double taxGoodsRate, 
			String taxGoodsCode, 
			String taxGoodsName, 
			Integer orderNo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasGoodsDO.getId());
        assertEquals(goodsType, gasGoodsDO.getGoodsType());
        assertEquals(goodsGroupType, gasGoodsDO.getGoodsGroupType());
        assertEquals(groupId, gasGoodsDO.getGroupId());
        assertEquals(goodsName, gasGoodsDO.getGoodsName());
        assertEquals(goodsCode, gasGoodsDO.getGoodsCode());
        assertEquals(taxGoodsRate, gasGoodsDO.getTaxGoodsRate());
        assertEquals(taxGoodsCode, gasGoodsDO.getTaxGoodsCode());
        assertEquals(taxGoodsName, gasGoodsDO.getTaxGoodsName());
        assertEquals(orderNo, gasGoodsDO.getOrderNo());
        assertEquals(rawAddTime, gasGoodsDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasGoodsDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_goods表数据
	 */
	public void assertGasGoods(GasGoodsDO expect, GasGoodsDO gasGoodsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasGoodsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasGoodsDO.getRawAddTime());
		expect.setRawAddTime(gasGoodsDO.getRawAddTime());
        Assertions.assertTrue(null != gasGoodsDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasGoodsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasGoodsDO);
	}

    /**
	 * 插入gas_goods表数据
	 */
	public void insertGasGoods(GasGoodsDO gasGoodsDO) {
		gasGoodsDAO.insert(gasGoodsDO);
	}

    /**
	 * 插入gas_goods表数据
	 */
	public void insertGasGoods(
			Long id, 
			String goodsType, 
			String goodsGroupType, 
			Long groupId, 
			String goodsName, 
			String goodsCode, 
			Double taxGoodsRate, 
			String taxGoodsCode, 
			String taxGoodsName, 
			Integer orderNo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasGoodsDO gasGoodsDO = new GasGoodsDO();
		gasGoodsDO.setId(id);
		gasGoodsDO.setGoodsType(goodsType);
		gasGoodsDO.setGoodsGroupType(goodsGroupType);
		gasGoodsDO.setGroupId(groupId);
		gasGoodsDO.setGoodsName(goodsName);
		gasGoodsDO.setGoodsCode(goodsCode);
		gasGoodsDO.setTaxGoodsRate(taxGoodsRate);
		gasGoodsDO.setTaxGoodsCode(taxGoodsCode);
		gasGoodsDO.setTaxGoodsName(taxGoodsName);
		gasGoodsDO.setOrderNo(orderNo);
		gasGoodsDO.setRawAddTime(rawAddTime);
		gasGoodsDO.setRawUpdateTime(rawUpdateTime);
		gasGoodsDAO.insert(gasGoodsDO);
	}

    /**
     * 删除gas_goods表所有数据
     */
    public void cleanGasGoods() {
        GasGoodsDOExample exam = new GasGoodsDOExample();
        exam.createCriteria();
        gasGoodsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_goods表数据
	 */
	public void cleanGasGoodsById(Long id) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据groupId删除gas_goods表数据
	 */
	public void cleanGasGoodsByGroupId(Long groupId) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		gasGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsName删除gas_goods表数据
	*/
	public void cleanGasGoodsByGoodsName(String goodsName) {
        if (StringUtils.isBlank(goodsName)){
            goodsName = "test_goodsName";
        }
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsCode删除gas_goods表数据
	*/
	public void cleanGasGoodsByGoodsCode(String goodsCode) {
        if (StringUtils.isBlank(goodsCode)){
            goodsCode = "test_goodsCode";
        }
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据taxGoodsCode删除gas_goods表数据
	*/
	public void cleanGasGoodsByTaxGoodsCode(String taxGoodsCode) {
        if (StringUtils.isBlank(taxGoodsCode)){
            taxGoodsCode = "test_taxGoodsCode";
        }
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andTaxGoodsCodeEqualTo(taxGoodsCode);
		gasGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据taxGoodsName删除gas_goods表数据
	*/
	public void cleanGasGoodsByTaxGoodsName(String taxGoodsName) {
        if (StringUtils.isBlank(taxGoodsName)){
            taxGoodsName = "test_taxGoodsName";
        }
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andTaxGoodsNameEqualTo(taxGoodsName);
		gasGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据orderNo删除gas_goods表数据
	 */
	public void cleanGasGoodsByOrderNo(Integer orderNo) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasGoodsDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_goods表所有数据
     */
    public List<GasGoodsDO> findGasGoodsAll() {
        GasGoodsDOExample exam = new GasGoodsDOExample();
        exam.createCriteria();
		return gasGoodsDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_goods表数据
	 */
	public List<GasGoodsDO> findGasGoodsById(Long id) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据groupId查询gas_goods表数据
	 */
	public List<GasGoodsDO> findGasGoodsByGroupId(Long groupId) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		return gasGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsName查询gas_goods表数据
	*/
	public List<GasGoodsDO> findGasGoodsByGoodsName(String goodsName) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		return gasGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsCode查询gas_goods表数据
	*/
	public List<GasGoodsDO> findGasGoodsByGoodsCode(String goodsCode) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		return gasGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据taxGoodsCode查询gas_goods表数据
	*/
	public List<GasGoodsDO> findGasGoodsByTaxGoodsCode(String taxGoodsCode) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andTaxGoodsCodeEqualTo(taxGoodsCode);
		return gasGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据taxGoodsName查询gas_goods表数据
	*/
	public List<GasGoodsDO> findGasGoodsByTaxGoodsName(String taxGoodsName) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andTaxGoodsNameEqualTo(taxGoodsName);
		return gasGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据orderNo查询gas_goods表数据
	 */
	public List<GasGoodsDO> findGasGoodsByOrderNo(Integer orderNo) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		return gasGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_goods表数据
	 */
	public void updateGasGoodsById(Long id,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasGoodsDAO.updateByExample(gasGoodsDO, exam);
	}

    /**
	 * 根据groupId更新gas_goods表数据
	 */
	public void updateGasGoodsByGroupId(Long groupId,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		gasGoodsDAO.updateByExample(gasGoodsDO, exam);
	}

	/**
	* 根据goodsName更新gas_goods表数据
	*/
	public void updateGasGoodsByGoodsName(String goodsName,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasGoodsDAO.updateByExample(gasGoodsDO, exam);
	}

	/**
	* 根据goodsCode更新gas_goods表数据
	*/
	public void updateGasGoodsByGoodsCode(String goodsCode,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasGoodsDAO.updateByExample(gasGoodsDO, exam);
	}

	/**
	* 根据taxGoodsCode更新gas_goods表数据
	*/
	public void updateGasGoodsByTaxGoodsCode(String taxGoodsCode,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andTaxGoodsCodeEqualTo(taxGoodsCode);
		gasGoodsDAO.updateByExample(gasGoodsDO, exam);
	}

	/**
	* 根据taxGoodsName更新gas_goods表数据
	*/
	public void updateGasGoodsByTaxGoodsName(String taxGoodsName,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andTaxGoodsNameEqualTo(taxGoodsName);
		gasGoodsDAO.updateByExample(gasGoodsDO, exam);
	}

    /**
	 * 根据orderNo更新gas_goods表数据
	 */
	public void updateGasGoodsByOrderNo(Integer orderNo,GasGoodsDO gasGoodsDO) {
		GasGoodsDOExample exam = new GasGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasGoodsDAO.updateByExample(gasGoodsDO, exam);
	}

    /**
	 * 断言gas_invoice_company表
	 */
	public void gasInvoiceCompanyAssert(
	        GasInvoiceCompanyDO gasInvoiceCompanyDO,
			Long id, 
			String platPartnerId, 
			String stationId, 
			String taxCompany, 
			String taxCode, 
			String taxAddress, 
			String taxMobile, 
			String taxDrawer, 
			String taxBankNo, 
			String taxReviewer, 
			String taxPayee, 
			String taxAppId, 
			String taxKey, 
			String taxCertPath, 
			String taxCertPwd, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasInvoiceCompanyDO.getId());
        assertEquals(platPartnerId, gasInvoiceCompanyDO.getPlatPartnerId());
        assertEquals(stationId, gasInvoiceCompanyDO.getStationId());
        assertEquals(taxCompany, gasInvoiceCompanyDO.getTaxCompany());
        assertEquals(taxCode, gasInvoiceCompanyDO.getTaxCode());
        assertEquals(taxAddress, gasInvoiceCompanyDO.getTaxAddress());
        assertEquals(taxMobile, gasInvoiceCompanyDO.getTaxMobile());
        assertEquals(taxDrawer, gasInvoiceCompanyDO.getTaxDrawer());
        assertEquals(taxBankNo, gasInvoiceCompanyDO.getTaxBankNo());
        assertEquals(taxReviewer, gasInvoiceCompanyDO.getTaxReviewer());
        assertEquals(taxPayee, gasInvoiceCompanyDO.getTaxPayee());
        assertEquals(taxAppId, gasInvoiceCompanyDO.getTaxAppId());
        assertEquals(taxKey, gasInvoiceCompanyDO.getTaxKey());
        assertEquals(taxCertPath, gasInvoiceCompanyDO.getTaxCertPath());
        assertEquals(taxCertPwd, gasInvoiceCompanyDO.getTaxCertPwd());
        assertEquals(rawAddTime, gasInvoiceCompanyDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasInvoiceCompanyDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_invoice_company表数据
	 */
	public void assertGasInvoiceCompany(GasInvoiceCompanyDO expect, GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasInvoiceCompanyDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasInvoiceCompanyDO.getRawAddTime());
		expect.setRawAddTime(gasInvoiceCompanyDO.getRawAddTime());
        Assertions.assertTrue(null != gasInvoiceCompanyDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasInvoiceCompanyDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasInvoiceCompanyDO);
	}

    /**
	 * 插入gas_invoice_company表数据
	 */
	public void insertGasInvoiceCompany(GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		gasInvoiceCompanyDAO.insert(gasInvoiceCompanyDO);
	}

    /**
	 * 插入gas_invoice_company表数据
	 */
	public void insertGasInvoiceCompany(
			Long id, 
			String platPartnerId, 
			String stationId, 
			String taxCompany, 
			String taxCode, 
			String taxAddress, 
			String taxMobile, 
			String taxDrawer, 
			String taxBankNo, 
			String taxReviewer, 
			String taxPayee, 
			String taxAppId, 
			String taxKey, 
			String taxCertPath, 
			String taxCertPwd, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasInvoiceCompanyDO gasInvoiceCompanyDO = new GasInvoiceCompanyDO();
		gasInvoiceCompanyDO.setId(id);
		gasInvoiceCompanyDO.setPlatPartnerId(platPartnerId);
		gasInvoiceCompanyDO.setStationId(stationId);
		gasInvoiceCompanyDO.setTaxCompany(taxCompany);
		gasInvoiceCompanyDO.setTaxCode(taxCode);
		gasInvoiceCompanyDO.setTaxAddress(taxAddress);
		gasInvoiceCompanyDO.setTaxMobile(taxMobile);
		gasInvoiceCompanyDO.setTaxDrawer(taxDrawer);
		gasInvoiceCompanyDO.setTaxBankNo(taxBankNo);
		gasInvoiceCompanyDO.setTaxReviewer(taxReviewer);
		gasInvoiceCompanyDO.setTaxPayee(taxPayee);
		gasInvoiceCompanyDO.setTaxAppId(taxAppId);
		gasInvoiceCompanyDO.setTaxKey(taxKey);
		gasInvoiceCompanyDO.setTaxCertPath(taxCertPath);
		gasInvoiceCompanyDO.setTaxCertPwd(taxCertPwd);
		gasInvoiceCompanyDO.setRawAddTime(rawAddTime);
		gasInvoiceCompanyDO.setRawUpdateTime(rawUpdateTime);
		gasInvoiceCompanyDAO.insert(gasInvoiceCompanyDO);
	}

    /**
     * 删除gas_invoice_company表所有数据
     */
    public void cleanGasInvoiceCompany() {
        GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
        exam.createCriteria();
        gasInvoiceCompanyDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_invoice_company表数据
	 */
	public void cleanGasInvoiceCompanyById(Long id) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasInvoiceCompanyDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_invoice_company表数据
	 */
	public void cleanGasInvoiceCompanyByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasInvoiceCompanyDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_invoice_company表数据
	 */
	public void cleanGasInvoiceCompanyByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasInvoiceCompanyDAO.deleteByExample(exam);
	}

	/**
	* 根据taxCode删除gas_invoice_company表数据
	*/
	public void cleanGasInvoiceCompanyByTaxCode(String taxCode) {
        if (StringUtils.isBlank(taxCode)){
            taxCode = "test_taxCode";
        }
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxCodeEqualTo(taxCode);
		gasInvoiceCompanyDAO.deleteByExample(exam);
	}

	/**
	 * 根据taxBankNo删除gas_invoice_company表数据
	 */
	public void cleanGasInvoiceCompanyByTaxBankNo(String taxBankNo) {
        if (StringUtils.isBlank(taxBankNo)){
            taxBankNo = "test_taxBankNo";
        }
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxBankNoEqualTo(taxBankNo);
		gasInvoiceCompanyDAO.deleteByExample(exam);
	}

	/**
	 * 根据taxAppId删除gas_invoice_company表数据
	 */
	public void cleanGasInvoiceCompanyByTaxAppId(String taxAppId) {
        if (StringUtils.isBlank(taxAppId)){
            taxAppId = "test_taxAppId";
        }
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxAppIdEqualTo(taxAppId);
		gasInvoiceCompanyDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_invoice_company表所有数据
     */
    public List<GasInvoiceCompanyDO> findGasInvoiceCompanyAll() {
        GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
        exam.createCriteria();
		return gasInvoiceCompanyDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_invoice_company表数据
	 */
	public List<GasInvoiceCompanyDO> findGasInvoiceCompanyById(Long id) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasInvoiceCompanyDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_invoice_company表数据
	 */
	public List<GasInvoiceCompanyDO> findGasInvoiceCompanyByPlatPartnerId(String platPartnerId) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasInvoiceCompanyDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_invoice_company表数据
	 */
	public List<GasInvoiceCompanyDO> findGasInvoiceCompanyByStationId(String stationId) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasInvoiceCompanyDAO.selectByExample(exam);
	}

	/**
	* 根据taxCode查询gas_invoice_company表数据
	*/
	public List<GasInvoiceCompanyDO> findGasInvoiceCompanyByTaxCode(String taxCode) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxCodeEqualTo(taxCode);
		return gasInvoiceCompanyDAO.selectByExample(exam);
	}

    /**
	 * 根据taxBankNo查询gas_invoice_company表数据
	 */
	public List<GasInvoiceCompanyDO> findGasInvoiceCompanyByTaxBankNo(String taxBankNo) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxBankNoEqualTo(taxBankNo);
		return gasInvoiceCompanyDAO.selectByExample(exam);
	}

    /**
	 * 根据taxAppId查询gas_invoice_company表数据
	 */
	public List<GasInvoiceCompanyDO> findGasInvoiceCompanyByTaxAppId(String taxAppId) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxAppIdEqualTo(taxAppId);
		return gasInvoiceCompanyDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_invoice_company表数据
	 */
	public void updateGasInvoiceCompanyById(Long id,GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasInvoiceCompanyDAO.updateByExample(gasInvoiceCompanyDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_invoice_company表数据
	 */
	public void updateGasInvoiceCompanyByPlatPartnerId(String platPartnerId,GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasInvoiceCompanyDAO.updateByExample(gasInvoiceCompanyDO, exam);
	}

    /**
	 * 根据stationId更新gas_invoice_company表数据
	 */
	public void updateGasInvoiceCompanyByStationId(String stationId,GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasInvoiceCompanyDAO.updateByExample(gasInvoiceCompanyDO, exam);
	}

	/**
	* 根据taxCode更新gas_invoice_company表数据
	*/
	public void updateGasInvoiceCompanyByTaxCode(String taxCode,GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxCodeEqualTo(taxCode);
		gasInvoiceCompanyDAO.updateByExample(gasInvoiceCompanyDO, exam);
	}

    /**
	 * 根据taxBankNo更新gas_invoice_company表数据
	 */
	public void updateGasInvoiceCompanyByTaxBankNo(String taxBankNo,GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxBankNoEqualTo(taxBankNo);
		gasInvoiceCompanyDAO.updateByExample(gasInvoiceCompanyDO, exam);
	}

    /**
	 * 根据taxAppId更新gas_invoice_company表数据
	 */
	public void updateGasInvoiceCompanyByTaxAppId(String taxAppId,GasInvoiceCompanyDO gasInvoiceCompanyDO) {
		GasInvoiceCompanyDOExample exam = new GasInvoiceCompanyDOExample();
		exam.createCriteria().andTaxAppIdEqualTo(taxAppId);
		gasInvoiceCompanyDAO.updateByExample(gasInvoiceCompanyDO, exam);
	}

    /**
	 * 断言gas_invoice_config表
	 */
	public void gasInvoiceConfigAssert(
	        GasInvoiceConfigDO gasInvoiceConfigDO,
			Long id, 
			String platPartnerId, 
			Long expireTime, 
			Long minInvoiceAmount, 
			String remark, 
			String invoiceOils, 
			String invoicePayway, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasInvoiceConfigDO.getId());
        assertEquals(platPartnerId, gasInvoiceConfigDO.getPlatPartnerId());
        assertEquals(expireTime, gasInvoiceConfigDO.getExpireTime());
        assertEquals(minInvoiceAmount, gasInvoiceConfigDO.getMinInvoiceAmount());
        assertEquals(remark, gasInvoiceConfigDO.getRemark());
        assertEquals(invoiceOils, gasInvoiceConfigDO.getInvoiceOils());
        assertEquals(invoicePayway, gasInvoiceConfigDO.getInvoicePayway());
        assertEquals(rawAddTime, gasInvoiceConfigDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasInvoiceConfigDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_invoice_config表数据
	 */
	public void assertGasInvoiceConfig(GasInvoiceConfigDO expect, GasInvoiceConfigDO gasInvoiceConfigDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasInvoiceConfigDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasInvoiceConfigDO.getRawAddTime());
		expect.setRawAddTime(gasInvoiceConfigDO.getRawAddTime());
        Assertions.assertTrue(null != gasInvoiceConfigDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasInvoiceConfigDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasInvoiceConfigDO);
	}

    /**
	 * 插入gas_invoice_config表数据
	 */
	public void insertGasInvoiceConfig(GasInvoiceConfigDO gasInvoiceConfigDO) {
		gasInvoiceConfigDAO.insert(gasInvoiceConfigDO);
	}

    /**
	 * 插入gas_invoice_config表数据
	 */
	public void insertGasInvoiceConfig(
			Long id, 
			String platPartnerId, 
			Long expireTime, 
			Long minInvoiceAmount, 
			String remark, 
			String invoiceOils, 
			String invoicePayway, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasInvoiceConfigDO gasInvoiceConfigDO = new GasInvoiceConfigDO();
		gasInvoiceConfigDO.setId(id);
		gasInvoiceConfigDO.setPlatPartnerId(platPartnerId);
		gasInvoiceConfigDO.setExpireTime(expireTime);
		gasInvoiceConfigDO.setMinInvoiceAmount(minInvoiceAmount);
		gasInvoiceConfigDO.setRemark(remark);
		gasInvoiceConfigDO.setInvoiceOils(invoiceOils);
		gasInvoiceConfigDO.setInvoicePayway(invoicePayway);
		gasInvoiceConfigDO.setRawAddTime(rawAddTime);
		gasInvoiceConfigDO.setRawUpdateTime(rawUpdateTime);
		gasInvoiceConfigDAO.insert(gasInvoiceConfigDO);
	}

    /**
     * 删除gas_invoice_config表所有数据
     */
    public void cleanGasInvoiceConfig() {
        GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
        exam.createCriteria();
        gasInvoiceConfigDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_invoice_config表数据
	 */
	public void cleanGasInvoiceConfigById(Long id) {
		GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasInvoiceConfigDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_invoice_config表数据
	 */
	public void cleanGasInvoiceConfigByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasInvoiceConfigDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_invoice_config表所有数据
     */
    public List<GasInvoiceConfigDO> findGasInvoiceConfigAll() {
        GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
        exam.createCriteria();
		return gasInvoiceConfigDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_invoice_config表数据
	 */
	public List<GasInvoiceConfigDO> findGasInvoiceConfigById(Long id) {
		GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasInvoiceConfigDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_invoice_config表数据
	 */
	public List<GasInvoiceConfigDO> findGasInvoiceConfigByPlatPartnerId(String platPartnerId) {
		GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasInvoiceConfigDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_invoice_config表数据
	 */
	public void updateGasInvoiceConfigById(Long id,GasInvoiceConfigDO gasInvoiceConfigDO) {
		GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasInvoiceConfigDAO.updateByExample(gasInvoiceConfigDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_invoice_config表数据
	 */
	public void updateGasInvoiceConfigByPlatPartnerId(String platPartnerId,GasInvoiceConfigDO gasInvoiceConfigDO) {
		GasInvoiceConfigDOExample exam = new GasInvoiceConfigDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasInvoiceConfigDAO.updateByExample(gasInvoiceConfigDO, exam);
	}

    /**
	 * 断言gas_login_log表
	 */
	public void gasLoginLogAssert(
	        GasLoginLogDO gasLoginLogDO,
			Long id, 
			String deviceType, 
			String userId, 
			String account, 
			String partnerId, 
			String platPartnerId, 
			String partnerName, 
			String stationId, 
			String stationName, 
			String userName, 
			String deviceCode, 
			Date loginTime, 
			Date logoutTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasLoginLogDO.getId());
        assertEquals(deviceType, gasLoginLogDO.getDeviceType());
        assertEquals(userId, gasLoginLogDO.getUserId());
        assertEquals(account, gasLoginLogDO.getAccount());
        assertEquals(partnerId, gasLoginLogDO.getPartnerId());
        assertEquals(platPartnerId, gasLoginLogDO.getPlatPartnerId());
        assertEquals(partnerName, gasLoginLogDO.getPartnerName());
        assertEquals(stationId, gasLoginLogDO.getStationId());
        assertEquals(stationName, gasLoginLogDO.getStationName());
        assertEquals(userName, gasLoginLogDO.getUserName());
        assertEquals(deviceCode, gasLoginLogDO.getDeviceCode());
        assertEquals(loginTime, gasLoginLogDO.getLoginTime());
        assertEquals(logoutTime, gasLoginLogDO.getLogoutTime());
        assertEquals(rawAddTime, gasLoginLogDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasLoginLogDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_login_log表数据
	 */
	public void assertGasLoginLog(GasLoginLogDO expect, GasLoginLogDO gasLoginLogDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasLoginLogDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasLoginLogDO.getRawAddTime());
		expect.setRawAddTime(gasLoginLogDO.getRawAddTime());
        Assertions.assertTrue(null != gasLoginLogDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasLoginLogDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasLoginLogDO);
	}

    /**
	 * 插入gas_login_log表数据
	 */
	public void insertGasLoginLog(GasLoginLogDO gasLoginLogDO) {
		gasLoginLogDAO.insert(gasLoginLogDO);
	}

    /**
	 * 插入gas_login_log表数据
	 */
	public void insertGasLoginLog(
			Long id, 
			String deviceType, 
			String userId, 
			String account, 
			String partnerId, 
			String platPartnerId, 
			String partnerName, 
			String stationId, 
			String stationName, 
			String userName, 
			String deviceCode, 
			Date loginTime, 
			Date logoutTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (loginTime == null) {
			loginTime = new Date();
		}
		if (logoutTime == null) {
			logoutTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasLoginLogDO gasLoginLogDO = new GasLoginLogDO();
		gasLoginLogDO.setId(id);
		gasLoginLogDO.setDeviceType(deviceType);
		gasLoginLogDO.setUserId(userId);
		gasLoginLogDO.setAccount(account);
		gasLoginLogDO.setPartnerId(partnerId);
		gasLoginLogDO.setPlatPartnerId(platPartnerId);
		gasLoginLogDO.setPartnerName(partnerName);
		gasLoginLogDO.setStationId(stationId);
		gasLoginLogDO.setStationName(stationName);
		gasLoginLogDO.setUserName(userName);
		gasLoginLogDO.setDeviceCode(deviceCode);
		gasLoginLogDO.setLoginTime(loginTime);
		gasLoginLogDO.setLogoutTime(logoutTime);
		gasLoginLogDO.setRawAddTime(rawAddTime);
		gasLoginLogDO.setRawUpdateTime(rawUpdateTime);
		gasLoginLogDAO.insert(gasLoginLogDO);
	}

    /**
     * 删除gas_login_log表所有数据
     */
    public void cleanGasLoginLog() {
        GasLoginLogDOExample exam = new GasLoginLogDOExample();
        exam.createCriteria();
        gasLoginLogDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_login_log表数据
	 */
	public void cleanGasLoginLogById(Long id) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_login_log表数据
	 */
	public void cleanGasLoginLogByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_login_log表数据
	 */
	public void cleanGasLoginLogByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_login_log表数据
	 */
	public void cleanGasLoginLogByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_login_log表数据
	*/
	public void cleanGasLoginLogByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_login_log表数据
	 */
	public void cleanGasLoginLogByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_login_log表数据
	*/
	public void cleanGasLoginLogByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	* 根据userName删除gas_login_log表数据
	*/
	public void cleanGasLoginLogByUserName(String userName) {
        if (StringUtils.isBlank(userName)){
            userName = "test_userName";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		gasLoginLogDAO.deleteByExample(exam);
	}

	/**
	* 根据deviceCode删除gas_login_log表数据
	*/
	public void cleanGasLoginLogByDeviceCode(String deviceCode) {
        if (StringUtils.isBlank(deviceCode)){
            deviceCode = "test_deviceCode";
        }
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasLoginLogDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_login_log表所有数据
     */
    public List<GasLoginLogDO> findGasLoginLogAll() {
        GasLoginLogDOExample exam = new GasLoginLogDOExample();
        exam.createCriteria();
		return gasLoginLogDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_login_log表数据
	 */
	public List<GasLoginLogDO> findGasLoginLogById(Long id) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasLoginLogDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_login_log表数据
	 */
	public List<GasLoginLogDO> findGasLoginLogByUserId(String userId) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasLoginLogDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_login_log表数据
	 */
	public List<GasLoginLogDO> findGasLoginLogByPartnerId(String partnerId) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasLoginLogDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_login_log表数据
	 */
	public List<GasLoginLogDO> findGasLoginLogByPlatPartnerId(String platPartnerId) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasLoginLogDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_login_log表数据
	*/
	public List<GasLoginLogDO> findGasLoginLogByPartnerName(String partnerName) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasLoginLogDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_login_log表数据
	 */
	public List<GasLoginLogDO> findGasLoginLogByStationId(String stationId) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasLoginLogDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_login_log表数据
	*/
	public List<GasLoginLogDO> findGasLoginLogByStationName(String stationName) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasLoginLogDAO.selectByExample(exam);
	}

	/**
	* 根据userName查询gas_login_log表数据
	*/
	public List<GasLoginLogDO> findGasLoginLogByUserName(String userName) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		return gasLoginLogDAO.selectByExample(exam);
	}

	/**
	* 根据deviceCode查询gas_login_log表数据
	*/
	public List<GasLoginLogDO> findGasLoginLogByDeviceCode(String deviceCode) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		return gasLoginLogDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_login_log表数据
	 */
	public void updateGasLoginLogById(Long id,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

    /**
	 * 根据userId更新gas_login_log表数据
	 */
	public void updateGasLoginLogByUserId(String userId,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

    /**
	 * 根据partnerId更新gas_login_log表数据
	 */
	public void updateGasLoginLogByPartnerId(String partnerId,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_login_log表数据
	 */
	public void updateGasLoginLogByPlatPartnerId(String platPartnerId,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

	/**
	* 根据partnerName更新gas_login_log表数据
	*/
	public void updateGasLoginLogByPartnerName(String partnerName,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

    /**
	 * 根据stationId更新gas_login_log表数据
	 */
	public void updateGasLoginLogByStationId(String stationId,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

	/**
	* 根据stationName更新gas_login_log表数据
	*/
	public void updateGasLoginLogByStationName(String stationName,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

	/**
	* 根据userName更新gas_login_log表数据
	*/
	public void updateGasLoginLogByUserName(String userName,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

	/**
	* 根据deviceCode更新gas_login_log表数据
	*/
	public void updateGasLoginLogByDeviceCode(String deviceCode,GasLoginLogDO gasLoginLogDO) {
		GasLoginLogDOExample exam = new GasLoginLogDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasLoginLogDAO.updateByExample(gasLoginLogDO, exam);
	}

    /**
	 * 断言gas_mall_exchange_goods表
	 */
	public void gasMallExchangeGoodsAssert(
	        GasMallExchangeGoodsDO gasMallExchangeGoodsDO,
			Long id, 
			String goodsId, 
			String platPartnerId, 
			String partnerId, 
			String goodsType, 
			String goodsName, 
			String goodsDescription, 
			String goodsImg, 
			Date forSaleTime, 
			Date invalidTime, 
			Integer exchangePoint, 
			Integer storeNum, 
			Integer freezeStoreNum, 
			Integer oneExchangeTimes, 
			String gainStyle, 
			String gainStation, 
			Integer exchangedCount, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMallExchangeGoodsDO.getId());
        assertEquals(goodsId, gasMallExchangeGoodsDO.getGoodsId());
        assertEquals(platPartnerId, gasMallExchangeGoodsDO.getPlatPartnerId());
        assertEquals(partnerId, gasMallExchangeGoodsDO.getPartnerId());
        assertEquals(goodsType, gasMallExchangeGoodsDO.getGoodsType());
        assertEquals(goodsName, gasMallExchangeGoodsDO.getGoodsName());
        assertEquals(goodsDescription, gasMallExchangeGoodsDO.getGoodsDescription());
        assertEquals(goodsImg, gasMallExchangeGoodsDO.getGoodsImg());
        assertEquals(forSaleTime, gasMallExchangeGoodsDO.getForSaleTime());
        assertEquals(invalidTime, gasMallExchangeGoodsDO.getInvalidTime());
        assertEquals(exchangePoint, gasMallExchangeGoodsDO.getExchangePoint());
        assertEquals(storeNum, gasMallExchangeGoodsDO.getStoreNum());
        assertEquals(freezeStoreNum, gasMallExchangeGoodsDO.getFreezeStoreNum());
        assertEquals(oneExchangeTimes, gasMallExchangeGoodsDO.getOneExchangeTimes());
        assertEquals(gainStyle, gasMallExchangeGoodsDO.getGainStyle());
        assertEquals(gainStation, gasMallExchangeGoodsDO.getGainStation());
        assertEquals(exchangedCount, gasMallExchangeGoodsDO.getExchangedCount());
        assertEquals(rawAddTime, gasMallExchangeGoodsDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMallExchangeGoodsDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_mall_exchange_goods表数据
	 */
	public void assertGasMallExchangeGoods(GasMallExchangeGoodsDO expect, GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMallExchangeGoodsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMallExchangeGoodsDO.getRawAddTime());
		expect.setRawAddTime(gasMallExchangeGoodsDO.getRawAddTime());
        Assertions.assertTrue(null != gasMallExchangeGoodsDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMallExchangeGoodsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMallExchangeGoodsDO);
	}

    /**
	 * 插入gas_mall_exchange_goods表数据
	 */
	public void insertGasMallExchangeGoods(GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		gasMallExchangeGoodsDAO.insert(gasMallExchangeGoodsDO);
	}

    /**
	 * 插入gas_mall_exchange_goods表数据
	 */
	public void insertGasMallExchangeGoods(
			Long id, 
			String goodsId, 
			String platPartnerId, 
			String partnerId, 
			String goodsType, 
			String goodsName, 
			String goodsDescription, 
			String goodsImg, 
			Date forSaleTime, 
			Date invalidTime, 
			Integer exchangePoint, 
			Integer storeNum, 
			Integer freezeStoreNum, 
			Integer oneExchangeTimes, 
			String gainStyle, 
			String gainStation, 
			Integer exchangedCount, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (forSaleTime == null) {
			forSaleTime = new Date();
		}
		if (invalidTime == null) {
			invalidTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMallExchangeGoodsDO gasMallExchangeGoodsDO = new GasMallExchangeGoodsDO();
		gasMallExchangeGoodsDO.setId(id);
		gasMallExchangeGoodsDO.setGoodsId(goodsId);
		gasMallExchangeGoodsDO.setPlatPartnerId(platPartnerId);
		gasMallExchangeGoodsDO.setPartnerId(partnerId);
		gasMallExchangeGoodsDO.setGoodsType(goodsType);
		gasMallExchangeGoodsDO.setGoodsName(goodsName);
		gasMallExchangeGoodsDO.setGoodsDescription(goodsDescription);
		gasMallExchangeGoodsDO.setGoodsImg(goodsImg);
		gasMallExchangeGoodsDO.setForSaleTime(forSaleTime);
		gasMallExchangeGoodsDO.setInvalidTime(invalidTime);
		gasMallExchangeGoodsDO.setExchangePoint(exchangePoint);
		gasMallExchangeGoodsDO.setStoreNum(storeNum);
		gasMallExchangeGoodsDO.setFreezeStoreNum(freezeStoreNum);
		gasMallExchangeGoodsDO.setOneExchangeTimes(oneExchangeTimes);
		gasMallExchangeGoodsDO.setGainStyle(gainStyle);
		gasMallExchangeGoodsDO.setGainStation(gainStation);
		gasMallExchangeGoodsDO.setExchangedCount(exchangedCount);
		gasMallExchangeGoodsDO.setRawAddTime(rawAddTime);
		gasMallExchangeGoodsDO.setRawUpdateTime(rawUpdateTime);
		gasMallExchangeGoodsDAO.insert(gasMallExchangeGoodsDO);
	}

    /**
     * 删除gas_mall_exchange_goods表所有数据
     */
    public void cleanGasMallExchangeGoods() {
        GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
        exam.createCriteria();
        gasMallExchangeGoodsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_mall_exchange_goods表数据
	 */
	public void cleanGasMallExchangeGoodsById(Long id) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMallExchangeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据goodsId删除gas_mall_exchange_goods表数据
	 */
	public void cleanGasMallExchangeGoodsByGoodsId(String goodsId) {
        if (StringUtils.isBlank(goodsId)){
            goodsId = "test_goodsId";
        }
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		gasMallExchangeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_mall_exchange_goods表数据
	 */
	public void cleanGasMallExchangeGoodsByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMallExchangeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_mall_exchange_goods表数据
	 */
	public void cleanGasMallExchangeGoodsByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMallExchangeGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsName删除gas_mall_exchange_goods表数据
	*/
	public void cleanGasMallExchangeGoodsByGoodsName(String goodsName) {
        if (StringUtils.isBlank(goodsName)){
            goodsName = "test_goodsName";
        }
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasMallExchangeGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据invalidTime删除gas_mall_exchange_goods表数据
	 */
	public void cleanGasMallExchangeGoodsByInvalidTime(Date invalidTime) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andInvalidTimeEqualTo(invalidTime);
		gasMallExchangeGoodsDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_mall_exchange_goods表所有数据
     */
    public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsAll() {
        GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
        exam.createCriteria();
		return gasMallExchangeGoodsDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_mall_exchange_goods表数据
	 */
	public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsById(Long id) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMallExchangeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据goodsId查询gas_mall_exchange_goods表数据
	 */
	public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsByGoodsId(String goodsId) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		return gasMallExchangeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_mall_exchange_goods表数据
	 */
	public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsByPlatPartnerId(String platPartnerId) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMallExchangeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_mall_exchange_goods表数据
	 */
	public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsByPartnerId(String partnerId) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMallExchangeGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsName查询gas_mall_exchange_goods表数据
	*/
	public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsByGoodsName(String goodsName) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		return gasMallExchangeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据invalidTime查询gas_mall_exchange_goods表数据
	 */
	public List<GasMallExchangeGoodsDO> findGasMallExchangeGoodsByInvalidTime(Date invalidTime) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andInvalidTimeEqualTo(invalidTime);
		return gasMallExchangeGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_mall_exchange_goods表数据
	 */
	public void updateGasMallExchangeGoodsById(Long id,GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMallExchangeGoodsDAO.updateByExample(gasMallExchangeGoodsDO, exam);
	}

    /**
	 * 根据goodsId更新gas_mall_exchange_goods表数据
	 */
	public void updateGasMallExchangeGoodsByGoodsId(String goodsId,GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		gasMallExchangeGoodsDAO.updateByExample(gasMallExchangeGoodsDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_mall_exchange_goods表数据
	 */
	public void updateGasMallExchangeGoodsByPlatPartnerId(String platPartnerId,GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMallExchangeGoodsDAO.updateByExample(gasMallExchangeGoodsDO, exam);
	}

    /**
	 * 根据partnerId更新gas_mall_exchange_goods表数据
	 */
	public void updateGasMallExchangeGoodsByPartnerId(String partnerId,GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMallExchangeGoodsDAO.updateByExample(gasMallExchangeGoodsDO, exam);
	}

	/**
	* 根据goodsName更新gas_mall_exchange_goods表数据
	*/
	public void updateGasMallExchangeGoodsByGoodsName(String goodsName,GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasMallExchangeGoodsDAO.updateByExample(gasMallExchangeGoodsDO, exam);
	}

    /**
	 * 根据invalidTime更新gas_mall_exchange_goods表数据
	 */
	public void updateGasMallExchangeGoodsByInvalidTime(Date invalidTime,GasMallExchangeGoodsDO gasMallExchangeGoodsDO) {
		GasMallExchangeGoodsDOExample exam = new GasMallExchangeGoodsDOExample();
		exam.createCriteria().andInvalidTimeEqualTo(invalidTime);
		gasMallExchangeGoodsDAO.updateByExample(gasMallExchangeGoodsDO, exam);
	}

    /**
	 * 断言gas_mall_exchange_record表
	 */
	public void gasMallExchangeRecordAssert(
	        GasMallExchangeRecordDO gasMallExchangeRecordDO,
			Long id, 
			String platPartnerId, 
			String partnerId, 
			String userId, 
			String goodsId, 
			String goodsType, 
			String orderNo, 
			Integer exchangeCount, 
			String exchangeStatus, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMallExchangeRecordDO.getId());
        assertEquals(platPartnerId, gasMallExchangeRecordDO.getPlatPartnerId());
        assertEquals(partnerId, gasMallExchangeRecordDO.getPartnerId());
        assertEquals(userId, gasMallExchangeRecordDO.getUserId());
        assertEquals(goodsId, gasMallExchangeRecordDO.getGoodsId());
        assertEquals(goodsType, gasMallExchangeRecordDO.getGoodsType());
        assertEquals(orderNo, gasMallExchangeRecordDO.getOrderNo());
        assertEquals(exchangeCount, gasMallExchangeRecordDO.getExchangeCount());
        assertEquals(exchangeStatus, gasMallExchangeRecordDO.getExchangeStatus());
        assertEquals(rawAddTime, gasMallExchangeRecordDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMallExchangeRecordDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_mall_exchange_record表数据
	 */
	public void assertGasMallExchangeRecord(GasMallExchangeRecordDO expect, GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMallExchangeRecordDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMallExchangeRecordDO.getRawAddTime());
		expect.setRawAddTime(gasMallExchangeRecordDO.getRawAddTime());
        Assertions.assertTrue(null != gasMallExchangeRecordDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMallExchangeRecordDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMallExchangeRecordDO);
	}

    /**
	 * 插入gas_mall_exchange_record表数据
	 */
	public void insertGasMallExchangeRecord(GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		gasMallExchangeRecordDAO.insert(gasMallExchangeRecordDO);
	}

    /**
	 * 插入gas_mall_exchange_record表数据
	 */
	public void insertGasMallExchangeRecord(
			Long id, 
			String platPartnerId, 
			String partnerId, 
			String userId, 
			String goodsId, 
			String goodsType, 
			String orderNo, 
			Integer exchangeCount, 
			String exchangeStatus, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMallExchangeRecordDO gasMallExchangeRecordDO = new GasMallExchangeRecordDO();
		gasMallExchangeRecordDO.setId(id);
		gasMallExchangeRecordDO.setPlatPartnerId(platPartnerId);
		gasMallExchangeRecordDO.setPartnerId(partnerId);
		gasMallExchangeRecordDO.setUserId(userId);
		gasMallExchangeRecordDO.setGoodsId(goodsId);
		gasMallExchangeRecordDO.setGoodsType(goodsType);
		gasMallExchangeRecordDO.setOrderNo(orderNo);
		gasMallExchangeRecordDO.setExchangeCount(exchangeCount);
		gasMallExchangeRecordDO.setExchangeStatus(exchangeStatus);
		gasMallExchangeRecordDO.setRawAddTime(rawAddTime);
		gasMallExchangeRecordDO.setRawUpdateTime(rawUpdateTime);
		gasMallExchangeRecordDAO.insert(gasMallExchangeRecordDO);
	}

    /**
     * 删除gas_mall_exchange_record表所有数据
     */
    public void cleanGasMallExchangeRecord() {
        GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
        exam.createCriteria();
        gasMallExchangeRecordDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_mall_exchange_record表数据
	 */
	public void cleanGasMallExchangeRecordById(Long id) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMallExchangeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_mall_exchange_record表数据
	 */
	public void cleanGasMallExchangeRecordByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMallExchangeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_mall_exchange_record表数据
	 */
	public void cleanGasMallExchangeRecordByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMallExchangeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_mall_exchange_record表数据
	 */
	public void cleanGasMallExchangeRecordByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMallExchangeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据goodsId删除gas_mall_exchange_record表数据
	 */
	public void cleanGasMallExchangeRecordByGoodsId(String goodsId) {
        if (StringUtils.isBlank(goodsId)){
            goodsId = "test_goodsId";
        }
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		gasMallExchangeRecordDAO.deleteByExample(exam);
	}

	/**
	 * 根据orderNo删除gas_mall_exchange_record表数据
	 */
	public void cleanGasMallExchangeRecordByOrderNo(String orderNo) {
        if (StringUtils.isBlank(orderNo)){
            orderNo = "test_orderNo";
        }
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasMallExchangeRecordDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_mall_exchange_record表所有数据
     */
    public List<GasMallExchangeRecordDO> findGasMallExchangeRecordAll() {
        GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
        exam.createCriteria();
		return gasMallExchangeRecordDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_mall_exchange_record表数据
	 */
	public List<GasMallExchangeRecordDO> findGasMallExchangeRecordById(Long id) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMallExchangeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_mall_exchange_record表数据
	 */
	public List<GasMallExchangeRecordDO> findGasMallExchangeRecordByPlatPartnerId(String platPartnerId) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMallExchangeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_mall_exchange_record表数据
	 */
	public List<GasMallExchangeRecordDO> findGasMallExchangeRecordByPartnerId(String partnerId) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMallExchangeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_mall_exchange_record表数据
	 */
	public List<GasMallExchangeRecordDO> findGasMallExchangeRecordByUserId(String userId) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasMallExchangeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据goodsId查询gas_mall_exchange_record表数据
	 */
	public List<GasMallExchangeRecordDO> findGasMallExchangeRecordByGoodsId(String goodsId) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		return gasMallExchangeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据orderNo查询gas_mall_exchange_record表数据
	 */
	public List<GasMallExchangeRecordDO> findGasMallExchangeRecordByOrderNo(String orderNo) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		return gasMallExchangeRecordDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_mall_exchange_record表数据
	 */
	public void updateGasMallExchangeRecordById(Long id,GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMallExchangeRecordDAO.updateByExample(gasMallExchangeRecordDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_mall_exchange_record表数据
	 */
	public void updateGasMallExchangeRecordByPlatPartnerId(String platPartnerId,GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMallExchangeRecordDAO.updateByExample(gasMallExchangeRecordDO, exam);
	}

    /**
	 * 根据partnerId更新gas_mall_exchange_record表数据
	 */
	public void updateGasMallExchangeRecordByPartnerId(String partnerId,GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMallExchangeRecordDAO.updateByExample(gasMallExchangeRecordDO, exam);
	}

    /**
	 * 根据userId更新gas_mall_exchange_record表数据
	 */
	public void updateGasMallExchangeRecordByUserId(String userId,GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMallExchangeRecordDAO.updateByExample(gasMallExchangeRecordDO, exam);
	}

    /**
	 * 根据goodsId更新gas_mall_exchange_record表数据
	 */
	public void updateGasMallExchangeRecordByGoodsId(String goodsId,GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andGoodsIdEqualTo(goodsId);
		gasMallExchangeRecordDAO.updateByExample(gasMallExchangeRecordDO, exam);
	}

    /**
	 * 根据orderNo更新gas_mall_exchange_record表数据
	 */
	public void updateGasMallExchangeRecordByOrderNo(String orderNo,GasMallExchangeRecordDO gasMallExchangeRecordDO) {
		GasMallExchangeRecordDOExample exam = new GasMallExchangeRecordDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasMallExchangeRecordDAO.updateByExample(gasMallExchangeRecordDO, exam);
	}

    /**
	 * 断言gas_merchant_card表
	 */
	public void gasMerchantCardAssert(
	        GasMerchantCardDO gasMerchantCardDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String cardObjectId, 
			String cardType, 
			String tag, 
			String parentCardNo, 
			String cardNo, 
			String internalNo, 
			Long cardRuleId, 
			String operatorAccount, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantCardDO.getId());
        assertEquals(partnerId, gasMerchantCardDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantCardDO.getPlatPartnerId());
        assertEquals(cardObjectId, gasMerchantCardDO.getCardObjectId());
        assertEquals(cardType, gasMerchantCardDO.getCardType());
        assertEquals(tag, gasMerchantCardDO.getTag());
        assertEquals(parentCardNo, gasMerchantCardDO.getParentCardNo());
        assertEquals(cardNo, gasMerchantCardDO.getCardNo());
        assertEquals(internalNo, gasMerchantCardDO.getInternalNo());
        assertEquals(cardRuleId, gasMerchantCardDO.getCardRuleId());
        assertEquals(operatorAccount, gasMerchantCardDO.getOperatorAccount());
        assertEquals(rawAddTime, gasMerchantCardDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantCardDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_card表数据
	 */
	public void assertGasMerchantCard(GasMerchantCardDO expect, GasMerchantCardDO gasMerchantCardDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantCardDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantCardDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantCardDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantCardDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantCardDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantCardDO);
	}

    /**
	 * 插入gas_merchant_card表数据
	 */
	public void insertGasMerchantCard(GasMerchantCardDO gasMerchantCardDO) {
		gasMerchantCardDAO.insert(gasMerchantCardDO);
	}

    /**
	 * 插入gas_merchant_card表数据
	 */
	public void insertGasMerchantCard(
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String cardObjectId, 
			String cardType, 
			String tag, 
			String parentCardNo, 
			String cardNo, 
			String internalNo, 
			Long cardRuleId, 
			String operatorAccount, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantCardDO gasMerchantCardDO = new GasMerchantCardDO();
		gasMerchantCardDO.setId(id);
		gasMerchantCardDO.setPartnerId(partnerId);
		gasMerchantCardDO.setPlatPartnerId(platPartnerId);
		gasMerchantCardDO.setCardObjectId(cardObjectId);
		gasMerchantCardDO.setCardType(cardType);
		gasMerchantCardDO.setTag(tag);
		gasMerchantCardDO.setParentCardNo(parentCardNo);
		gasMerchantCardDO.setCardNo(cardNo);
		gasMerchantCardDO.setInternalNo(internalNo);
		gasMerchantCardDO.setCardRuleId(cardRuleId);
		gasMerchantCardDO.setOperatorAccount(operatorAccount);
		gasMerchantCardDO.setRawAddTime(rawAddTime);
		gasMerchantCardDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantCardDAO.insert(gasMerchantCardDO);
	}

    /**
     * 删除gas_merchant_card表所有数据
     */
    public void cleanGasMerchantCard() {
        GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
        exam.createCriteria();
        gasMerchantCardDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardById(Long id) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据cardObjectId删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByCardObjectId(String cardObjectId) {
        if (StringUtils.isBlank(cardObjectId)){
            cardObjectId = "test_cardObjectId";
        }
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardObjectIdEqualTo(cardObjectId);
		gasMerchantCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据parentCardNo删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByParentCardNo(String parentCardNo) {
        if (StringUtils.isBlank(parentCardNo)){
            parentCardNo = "test_parentCardNo";
        }
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andParentCardNoEqualTo(parentCardNo);
		gasMerchantCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据cardNo删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByCardNo(String cardNo) {
        if (StringUtils.isBlank(cardNo)){
            cardNo = "test_cardNo";
        }
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		gasMerchantCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据internalNo删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByInternalNo(String internalNo) {
        if (StringUtils.isBlank(internalNo)){
            internalNo = "test_internalNo";
        }
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andInternalNoEqualTo(internalNo);
		gasMerchantCardDAO.deleteByExample(exam);
	}

	/**
	 * 根据cardRuleId删除gas_merchant_card表数据
	 */
	public void cleanGasMerchantCardByCardRuleId(Long cardRuleId) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardRuleIdEqualTo(cardRuleId);
		gasMerchantCardDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_card表所有数据
     */
    public List<GasMerchantCardDO> findGasMerchantCardAll() {
        GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
        exam.createCriteria();
		return gasMerchantCardDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardById(Long id) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByPartnerId(String partnerId) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByPlatPartnerId(String platPartnerId) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据cardObjectId查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByCardObjectId(String cardObjectId) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardObjectIdEqualTo(cardObjectId);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据parentCardNo查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByParentCardNo(String parentCardNo) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andParentCardNoEqualTo(parentCardNo);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据cardNo查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByCardNo(String cardNo) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据internalNo查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByInternalNo(String internalNo) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andInternalNoEqualTo(internalNo);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据cardRuleId查询gas_merchant_card表数据
	 */
	public List<GasMerchantCardDO> findGasMerchantCardByCardRuleId(Long cardRuleId) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardRuleIdEqualTo(cardRuleId);
		return gasMerchantCardDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardById(Long id,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByPartnerId(String partnerId,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByPlatPartnerId(String platPartnerId,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 根据cardObjectId更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByCardObjectId(String cardObjectId,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardObjectIdEqualTo(cardObjectId);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 根据parentCardNo更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByParentCardNo(String parentCardNo,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andParentCardNoEqualTo(parentCardNo);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 根据cardNo更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByCardNo(String cardNo,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardNoEqualTo(cardNo);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 根据internalNo更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByInternalNo(String internalNo,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andInternalNoEqualTo(internalNo);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 根据cardRuleId更新gas_merchant_card表数据
	 */
	public void updateGasMerchantCardByCardRuleId(Long cardRuleId,GasMerchantCardDO gasMerchantCardDO) {
		GasMerchantCardDOExample exam = new GasMerchantCardDOExample();
		exam.createCriteria().andCardRuleIdEqualTo(cardRuleId);
		gasMerchantCardDAO.updateByExample(gasMerchantCardDO, exam);
	}

    /**
	 * 断言gas_merchant_card_object表
	 */
	public void gasMerchantCardObjectAssert(
	        GasMerchantCardObjectDO gasMerchantCardObjectDO,
			Long id, 
			String objectId, 
			String partnerId, 
			String platPartnerId, 
			String cardType, 
			String tag, 
			String objectName, 
			String objectCompany, 
			String status, 
			Date validStart, 
			Date validEnd, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantCardObjectDO.getId());
        assertEquals(objectId, gasMerchantCardObjectDO.getObjectId());
        assertEquals(partnerId, gasMerchantCardObjectDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantCardObjectDO.getPlatPartnerId());
        assertEquals(cardType, gasMerchantCardObjectDO.getCardType());
        assertEquals(tag, gasMerchantCardObjectDO.getTag());
        assertEquals(objectName, gasMerchantCardObjectDO.getObjectName());
        assertEquals(objectCompany, gasMerchantCardObjectDO.getObjectCompany());
        assertEquals(status, gasMerchantCardObjectDO.getStatus());
        assertEquals(validStart, gasMerchantCardObjectDO.getValidStart());
        assertEquals(validEnd, gasMerchantCardObjectDO.getValidEnd());
        assertEquals(memo, gasMerchantCardObjectDO.getMemo());
        assertEquals(rawAddTime, gasMerchantCardObjectDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantCardObjectDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_card_object表数据
	 */
	public void assertGasMerchantCardObject(GasMerchantCardObjectDO expect, GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantCardObjectDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantCardObjectDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantCardObjectDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantCardObjectDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantCardObjectDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantCardObjectDO);
	}

    /**
	 * 插入gas_merchant_card_object表数据
	 */
	public void insertGasMerchantCardObject(GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		gasMerchantCardObjectDAO.insert(gasMerchantCardObjectDO);
	}

    /**
	 * 插入gas_merchant_card_object表数据
	 */
	public void insertGasMerchantCardObject(
			Long id, 
			String objectId, 
			String partnerId, 
			String platPartnerId, 
			String cardType, 
			String tag, 
			String objectName, 
			String objectCompany, 
			String status, 
			Date validStart, 
			Date validEnd, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (validStart == null) {
			validStart = new Date();
		}
		if (validEnd == null) {
			validEnd = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantCardObjectDO gasMerchantCardObjectDO = new GasMerchantCardObjectDO();
		gasMerchantCardObjectDO.setId(id);
		gasMerchantCardObjectDO.setObjectId(objectId);
		gasMerchantCardObjectDO.setPartnerId(partnerId);
		gasMerchantCardObjectDO.setPlatPartnerId(platPartnerId);
		gasMerchantCardObjectDO.setCardType(cardType);
		gasMerchantCardObjectDO.setTag(tag);
		gasMerchantCardObjectDO.setObjectName(objectName);
		gasMerchantCardObjectDO.setObjectCompany(objectCompany);
		gasMerchantCardObjectDO.setStatus(status);
		gasMerchantCardObjectDO.setValidStart(validStart);
		gasMerchantCardObjectDO.setValidEnd(validEnd);
		gasMerchantCardObjectDO.setMemo(memo);
		gasMerchantCardObjectDO.setRawAddTime(rawAddTime);
		gasMerchantCardObjectDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantCardObjectDAO.insert(gasMerchantCardObjectDO);
	}

    /**
     * 删除gas_merchant_card_object表所有数据
     */
    public void cleanGasMerchantCardObject() {
        GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
        exam.createCriteria();
        gasMerchantCardObjectDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_card_object表数据
	 */
	public void cleanGasMerchantCardObjectById(Long id) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantCardObjectDAO.deleteByExample(exam);
	}

	/**
	 * 根据objectId删除gas_merchant_card_object表数据
	 */
	public void cleanGasMerchantCardObjectByObjectId(String objectId) {
        if (StringUtils.isBlank(objectId)){
            objectId = "test_objectId";
        }
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andObjectIdEqualTo(objectId);
		gasMerchantCardObjectDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_card_object表数据
	 */
	public void cleanGasMerchantCardObjectByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantCardObjectDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_card_object表数据
	 */
	public void cleanGasMerchantCardObjectByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantCardObjectDAO.deleteByExample(exam);
	}

	/**
	* 根据objectName删除gas_merchant_card_object表数据
	*/
	public void cleanGasMerchantCardObjectByObjectName(String objectName) {
        if (StringUtils.isBlank(objectName)){
            objectName = "test_objectName";
        }
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andObjectNameEqualTo(objectName);
		gasMerchantCardObjectDAO.deleteByExample(exam);
	}

	/**
	 * 根据validStart删除gas_merchant_card_object表数据
	 */
	public void cleanGasMerchantCardObjectByValidStart(Date validStart) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andValidStartEqualTo(validStart);
		gasMerchantCardObjectDAO.deleteByExample(exam);
	}

	/**
	 * 根据validEnd删除gas_merchant_card_object表数据
	 */
	public void cleanGasMerchantCardObjectByValidEnd(Date validEnd) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andValidEndEqualTo(validEnd);
		gasMerchantCardObjectDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_card_object表所有数据
     */
    public List<GasMerchantCardObjectDO> findGasMerchantCardObjectAll() {
        GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
        exam.createCriteria();
		return gasMerchantCardObjectDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_card_object表数据
	 */
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectById(Long id) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantCardObjectDAO.selectByExample(exam);
	}

    /**
	 * 根据objectId查询gas_merchant_card_object表数据
	 */
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectByObjectId(String objectId) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andObjectIdEqualTo(objectId);
		return gasMerchantCardObjectDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_card_object表数据
	 */
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectByPartnerId(String partnerId) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantCardObjectDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_card_object表数据
	 */
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectByPlatPartnerId(String platPartnerId) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantCardObjectDAO.selectByExample(exam);
	}

	/**
	* 根据objectName查询gas_merchant_card_object表数据
	*/
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectByObjectName(String objectName) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andObjectNameEqualTo(objectName);
		return gasMerchantCardObjectDAO.selectByExample(exam);
	}

    /**
	 * 根据validStart查询gas_merchant_card_object表数据
	 */
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectByValidStart(Date validStart) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andValidStartEqualTo(validStart);
		return gasMerchantCardObjectDAO.selectByExample(exam);
	}

    /**
	 * 根据validEnd查询gas_merchant_card_object表数据
	 */
	public List<GasMerchantCardObjectDO> findGasMerchantCardObjectByValidEnd(Date validEnd) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andValidEndEqualTo(validEnd);
		return gasMerchantCardObjectDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_card_object表数据
	 */
	public void updateGasMerchantCardObjectById(Long id,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantCardObjectDAO.updateByExample(gasMerchantCardObjectDO, exam);
	}

    /**
	 * 根据objectId更新gas_merchant_card_object表数据
	 */
	public void updateGasMerchantCardObjectByObjectId(String objectId,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andObjectIdEqualTo(objectId);
		gasMerchantCardObjectDAO.updateByExample(gasMerchantCardObjectDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_card_object表数据
	 */
	public void updateGasMerchantCardObjectByPartnerId(String partnerId,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantCardObjectDAO.updateByExample(gasMerchantCardObjectDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_card_object表数据
	 */
	public void updateGasMerchantCardObjectByPlatPartnerId(String platPartnerId,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantCardObjectDAO.updateByExample(gasMerchantCardObjectDO, exam);
	}

	/**
	* 根据objectName更新gas_merchant_card_object表数据
	*/
	public void updateGasMerchantCardObjectByObjectName(String objectName,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andObjectNameEqualTo(objectName);
		gasMerchantCardObjectDAO.updateByExample(gasMerchantCardObjectDO, exam);
	}

    /**
	 * 根据validStart更新gas_merchant_card_object表数据
	 */
	public void updateGasMerchantCardObjectByValidStart(Date validStart,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andValidStartEqualTo(validStart);
		gasMerchantCardObjectDAO.updateByExample(gasMerchantCardObjectDO, exam);
	}

    /**
	 * 根据validEnd更新gas_merchant_card_object表数据
	 */
	public void updateGasMerchantCardObjectByValidEnd(Date validEnd,GasMerchantCardObjectDO gasMerchantCardObjectDO) {
		GasMerchantCardObjectDOExample exam = new GasMerchantCardObjectDOExample();
		exam.createCriteria().andValidEndEqualTo(validEnd);
		gasMerchantCardObjectDAO.updateByExample(gasMerchantCardObjectDO, exam);
	}

    /**
	 * 断言gas_merchant_card_rule表
	 */
	public void gasMerchantCardRuleAssert(
	        GasMerchantCardRuleDO gasMerchantCardRuleDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			Integer rangeStart, 
			Integer rangeEnd, 
			String excludeCardNo, 
			String excludeNumber, 
			Integer validCount, 
			String operatorAccount, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantCardRuleDO.getId());
        assertEquals(partnerId, gasMerchantCardRuleDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantCardRuleDO.getPlatPartnerId());
        assertEquals(rangeStart, gasMerchantCardRuleDO.getRangeStart());
        assertEquals(rangeEnd, gasMerchantCardRuleDO.getRangeEnd());
        assertEquals(excludeCardNo, gasMerchantCardRuleDO.getExcludeCardNo());
        assertEquals(excludeNumber, gasMerchantCardRuleDO.getExcludeNumber());
        assertEquals(validCount, gasMerchantCardRuleDO.getValidCount());
        assertEquals(operatorAccount, gasMerchantCardRuleDO.getOperatorAccount());
        assertEquals(memo, gasMerchantCardRuleDO.getMemo());
        assertEquals(rawAddTime, gasMerchantCardRuleDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantCardRuleDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_card_rule表数据
	 */
	public void assertGasMerchantCardRule(GasMerchantCardRuleDO expect, GasMerchantCardRuleDO gasMerchantCardRuleDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantCardRuleDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantCardRuleDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantCardRuleDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantCardRuleDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantCardRuleDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantCardRuleDO);
	}

    /**
	 * 插入gas_merchant_card_rule表数据
	 */
	public void insertGasMerchantCardRule(GasMerchantCardRuleDO gasMerchantCardRuleDO) {
		gasMerchantCardRuleDAO.insert(gasMerchantCardRuleDO);
	}

    /**
	 * 插入gas_merchant_card_rule表数据
	 */
	public void insertGasMerchantCardRule(
			Long id, 
			String partnerId, 
			String platPartnerId, 
			Integer rangeStart, 
			Integer rangeEnd, 
			String excludeCardNo, 
			String excludeNumber, 
			Integer validCount, 
			String operatorAccount, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantCardRuleDO gasMerchantCardRuleDO = new GasMerchantCardRuleDO();
		gasMerchantCardRuleDO.setId(id);
		gasMerchantCardRuleDO.setPartnerId(partnerId);
		gasMerchantCardRuleDO.setPlatPartnerId(platPartnerId);
		gasMerchantCardRuleDO.setRangeStart(rangeStart);
		gasMerchantCardRuleDO.setRangeEnd(rangeEnd);
		gasMerchantCardRuleDO.setExcludeCardNo(excludeCardNo);
		gasMerchantCardRuleDO.setExcludeNumber(excludeNumber);
		gasMerchantCardRuleDO.setValidCount(validCount);
		gasMerchantCardRuleDO.setOperatorAccount(operatorAccount);
		gasMerchantCardRuleDO.setMemo(memo);
		gasMerchantCardRuleDO.setRawAddTime(rawAddTime);
		gasMerchantCardRuleDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantCardRuleDAO.insert(gasMerchantCardRuleDO);
	}

    /**
     * 删除gas_merchant_card_rule表所有数据
     */
    public void cleanGasMerchantCardRule() {
        GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
        exam.createCriteria();
        gasMerchantCardRuleDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_card_rule表数据
	 */
	public void cleanGasMerchantCardRuleById(Long id) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantCardRuleDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_card_rule表数据
	 */
	public void cleanGasMerchantCardRuleByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantCardRuleDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_card_rule表数据
	 */
	public void cleanGasMerchantCardRuleByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantCardRuleDAO.deleteByExample(exam);
	}

	/**
	 * 根据excludeCardNo删除gas_merchant_card_rule表数据
	 */
	public void cleanGasMerchantCardRuleByExcludeCardNo(String excludeCardNo) {
        if (StringUtils.isBlank(excludeCardNo)){
            excludeCardNo = "test_excludeCardNo";
        }
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andExcludeCardNoEqualTo(excludeCardNo);
		gasMerchantCardRuleDAO.deleteByExample(exam);
	}

	/**
	* 根据excludeNumber删除gas_merchant_card_rule表数据
	*/
	public void cleanGasMerchantCardRuleByExcludeNumber(String excludeNumber) {
        if (StringUtils.isBlank(excludeNumber)){
            excludeNumber = "test_excludeNumber";
        }
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andExcludeNumberEqualTo(excludeNumber);
		gasMerchantCardRuleDAO.deleteByExample(exam);
	}

	/**
	 * 根据validCount删除gas_merchant_card_rule表数据
	 */
	public void cleanGasMerchantCardRuleByValidCount(Integer validCount) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andValidCountEqualTo(validCount);
		gasMerchantCardRuleDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_card_rule表所有数据
     */
    public List<GasMerchantCardRuleDO> findGasMerchantCardRuleAll() {
        GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
        exam.createCriteria();
		return gasMerchantCardRuleDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_card_rule表数据
	 */
	public List<GasMerchantCardRuleDO> findGasMerchantCardRuleById(Long id) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantCardRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_card_rule表数据
	 */
	public List<GasMerchantCardRuleDO> findGasMerchantCardRuleByPartnerId(String partnerId) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantCardRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_card_rule表数据
	 */
	public List<GasMerchantCardRuleDO> findGasMerchantCardRuleByPlatPartnerId(String platPartnerId) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantCardRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据excludeCardNo查询gas_merchant_card_rule表数据
	 */
	public List<GasMerchantCardRuleDO> findGasMerchantCardRuleByExcludeCardNo(String excludeCardNo) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andExcludeCardNoEqualTo(excludeCardNo);
		return gasMerchantCardRuleDAO.selectByExample(exam);
	}

	/**
	* 根据excludeNumber查询gas_merchant_card_rule表数据
	*/
	public List<GasMerchantCardRuleDO> findGasMerchantCardRuleByExcludeNumber(String excludeNumber) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andExcludeNumberEqualTo(excludeNumber);
		return gasMerchantCardRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据validCount查询gas_merchant_card_rule表数据
	 */
	public List<GasMerchantCardRuleDO> findGasMerchantCardRuleByValidCount(Integer validCount) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andValidCountEqualTo(validCount);
		return gasMerchantCardRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_card_rule表数据
	 */
	public void updateGasMerchantCardRuleById(Long id,GasMerchantCardRuleDO gasMerchantCardRuleDO) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantCardRuleDAO.updateByExample(gasMerchantCardRuleDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_card_rule表数据
	 */
	public void updateGasMerchantCardRuleByPartnerId(String partnerId,GasMerchantCardRuleDO gasMerchantCardRuleDO) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantCardRuleDAO.updateByExample(gasMerchantCardRuleDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_card_rule表数据
	 */
	public void updateGasMerchantCardRuleByPlatPartnerId(String platPartnerId,GasMerchantCardRuleDO gasMerchantCardRuleDO) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantCardRuleDAO.updateByExample(gasMerchantCardRuleDO, exam);
	}

    /**
	 * 根据excludeCardNo更新gas_merchant_card_rule表数据
	 */
	public void updateGasMerchantCardRuleByExcludeCardNo(String excludeCardNo,GasMerchantCardRuleDO gasMerchantCardRuleDO) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andExcludeCardNoEqualTo(excludeCardNo);
		gasMerchantCardRuleDAO.updateByExample(gasMerchantCardRuleDO, exam);
	}

    /**
	 * 根据validCount更新gas_merchant_card_rule表数据
	 */
	public void updateGasMerchantCardRuleByValidCount(Integer validCount,GasMerchantCardRuleDO gasMerchantCardRuleDO) {
		GasMerchantCardRuleDOExample exam = new GasMerchantCardRuleDOExample();
		exam.createCriteria().andValidCountEqualTo(validCount);
		gasMerchantCardRuleDAO.updateByExample(gasMerchantCardRuleDO, exam);
	}

    /**
	 * 断言gas_merchant表
	 */
	public void gasMerchantAssert(
	        GasMerchantDO gasMerchantDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String partnerName, 
			String shortName, 
			String mobileNo, 
			String email, 
			String accountNo, 
			String marketAccountNo, 
			String status, 
			String headImgUrl, 
			Date queryDepth, 
			String collectionModel, 
			String monthTime, 
			String dayTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantDO.getId());
        assertEquals(partnerId, gasMerchantDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantDO.getPlatPartnerId());
        assertEquals(partnerName, gasMerchantDO.getPartnerName());
        assertEquals(shortName, gasMerchantDO.getShortName());
        assertEquals(mobileNo, gasMerchantDO.getMobileNo());
        assertEquals(email, gasMerchantDO.getEmail());
        assertEquals(accountNo, gasMerchantDO.getAccountNo());
        assertEquals(marketAccountNo, gasMerchantDO.getMarketAccountNo());
        assertEquals(status, gasMerchantDO.getStatus());
        assertEquals(headImgUrl, gasMerchantDO.getHeadImgUrl());
        assertEquals(queryDepth, gasMerchantDO.getQueryDepth());
        assertEquals(collectionModel, gasMerchantDO.getCollectionModel());
        assertEquals(monthTime, gasMerchantDO.getMonthTime());
        assertEquals(dayTime, gasMerchantDO.getDayTime());
        assertEquals(rawAddTime, gasMerchantDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant表数据
	 */
	public void assertGasMerchant(GasMerchantDO expect, GasMerchantDO gasMerchantDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantDO);
	}

    /**
	 * 插入gas_merchant表数据
	 */
	public void insertGasMerchant(GasMerchantDO gasMerchantDO) {
		gasMerchantDAO.insert(gasMerchantDO);
	}

    /**
	 * 插入gas_merchant表数据
	 */
	public void insertGasMerchant(
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String partnerName, 
			String shortName, 
			String mobileNo, 
			String email, 
			String accountNo, 
			String marketAccountNo, 
			String status, 
			String headImgUrl, 
			Date queryDepth, 
			String collectionModel, 
			String monthTime, 
			String dayTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (queryDepth == null) {
			queryDepth = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantDO gasMerchantDO = new GasMerchantDO();
		gasMerchantDO.setId(id);
		gasMerchantDO.setPartnerId(partnerId);
		gasMerchantDO.setPlatPartnerId(platPartnerId);
		gasMerchantDO.setPartnerName(partnerName);
		gasMerchantDO.setShortName(shortName);
		gasMerchantDO.setMobileNo(mobileNo);
		gasMerchantDO.setEmail(email);
		gasMerchantDO.setAccountNo(accountNo);
		gasMerchantDO.setMarketAccountNo(marketAccountNo);
		gasMerchantDO.setStatus(status);
		gasMerchantDO.setHeadImgUrl(headImgUrl);
		gasMerchantDO.setQueryDepth(queryDepth);
		gasMerchantDO.setCollectionModel(collectionModel);
		gasMerchantDO.setMonthTime(monthTime);
		gasMerchantDO.setDayTime(dayTime);
		gasMerchantDO.setRawAddTime(rawAddTime);
		gasMerchantDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantDAO.insert(gasMerchantDO);
	}

    /**
     * 删除gas_merchant表所有数据
     */
    public void cleanGasMerchant() {
        GasMerchantDOExample exam = new GasMerchantDOExample();
        exam.createCriteria();
        gasMerchantDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant表数据
	 */
	public void cleanGasMerchantById(Long id) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant表数据
	 */
	public void cleanGasMerchantByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant表数据
	 */
	public void cleanGasMerchantByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_merchant表数据
	*/
	public void cleanGasMerchantByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasMerchantDAO.deleteByExample(exam);
	}

	/**
	* 根据shortName删除gas_merchant表数据
	*/
	public void cleanGasMerchantByShortName(String shortName) {
        if (StringUtils.isBlank(shortName)){
            shortName = "test_shortName";
        }
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andShortNameEqualTo(shortName);
		gasMerchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobileNo删除gas_merchant表数据
	 */
	public void cleanGasMerchantByMobileNo(String mobileNo) {
        if (StringUtils.isBlank(mobileNo)){
            mobileNo = "test_mobileNo";
        }
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		gasMerchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据accountNo删除gas_merchant表数据
	 */
	public void cleanGasMerchantByAccountNo(String accountNo) {
        if (StringUtils.isBlank(accountNo)){
            accountNo = "test_accountNo";
        }
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		gasMerchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据marketAccountNo删除gas_merchant表数据
	 */
	public void cleanGasMerchantByMarketAccountNo(String marketAccountNo) {
        if (StringUtils.isBlank(marketAccountNo)){
            marketAccountNo = "test_marketAccountNo";
        }
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andMarketAccountNoEqualTo(marketAccountNo);
		gasMerchantDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant表所有数据
     */
    public List<GasMerchantDO> findGasMerchantAll() {
        GasMerchantDOExample exam = new GasMerchantDOExample();
        exam.createCriteria();
		return gasMerchantDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant表数据
	 */
	public List<GasMerchantDO> findGasMerchantById(Long id) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant表数据
	 */
	public List<GasMerchantDO> findGasMerchantByPartnerId(String partnerId) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant表数据
	 */
	public List<GasMerchantDO> findGasMerchantByPlatPartnerId(String platPartnerId) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_merchant表数据
	*/
	public List<GasMerchantDO> findGasMerchantByPartnerName(String partnerName) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasMerchantDAO.selectByExample(exam);
	}

	/**
	* 根据shortName查询gas_merchant表数据
	*/
	public List<GasMerchantDO> findGasMerchantByShortName(String shortName) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andShortNameEqualTo(shortName);
		return gasMerchantDAO.selectByExample(exam);
	}

    /**
	 * 根据mobileNo查询gas_merchant表数据
	 */
	public List<GasMerchantDO> findGasMerchantByMobileNo(String mobileNo) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		return gasMerchantDAO.selectByExample(exam);
	}

    /**
	 * 根据accountNo查询gas_merchant表数据
	 */
	public List<GasMerchantDO> findGasMerchantByAccountNo(String accountNo) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		return gasMerchantDAO.selectByExample(exam);
	}

    /**
	 * 根据marketAccountNo查询gas_merchant表数据
	 */
	public List<GasMerchantDO> findGasMerchantByMarketAccountNo(String marketAccountNo) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andMarketAccountNoEqualTo(marketAccountNo);
		return gasMerchantDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant表数据
	 */
	public void updateGasMerchantById(Long id,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant表数据
	 */
	public void updateGasMerchantByPartnerId(String partnerId,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant表数据
	 */
	public void updateGasMerchantByPlatPartnerId(String platPartnerId,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

	/**
	* 根据partnerName更新gas_merchant表数据
	*/
	public void updateGasMerchantByPartnerName(String partnerName,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

	/**
	* 根据shortName更新gas_merchant表数据
	*/
	public void updateGasMerchantByShortName(String shortName,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andShortNameEqualTo(shortName);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

    /**
	 * 根据mobileNo更新gas_merchant表数据
	 */
	public void updateGasMerchantByMobileNo(String mobileNo,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

    /**
	 * 根据accountNo更新gas_merchant表数据
	 */
	public void updateGasMerchantByAccountNo(String accountNo,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

    /**
	 * 根据marketAccountNo更新gas_merchant表数据
	 */
	public void updateGasMerchantByMarketAccountNo(String marketAccountNo,GasMerchantDO gasMerchantDO) {
		GasMerchantDOExample exam = new GasMerchantDOExample();
		exam.createCriteria().andMarketAccountNoEqualTo(marketAccountNo);
		gasMerchantDAO.updateByExample(gasMerchantDO, exam);
	}

    /**
	 * 断言gas_merchant_device表
	 */
	public void gasMerchantDeviceAssert(
	        GasMerchantDeviceDO gasMerchantDeviceDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String deviceType, 
			String deviceCode, 
			String loginStatus, 
			String loginUserId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantDeviceDO.getId());
        assertEquals(partnerId, gasMerchantDeviceDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantDeviceDO.getPlatPartnerId());
        assertEquals(deviceType, gasMerchantDeviceDO.getDeviceType());
        assertEquals(deviceCode, gasMerchantDeviceDO.getDeviceCode());
        assertEquals(loginStatus, gasMerchantDeviceDO.getLoginStatus());
        assertEquals(loginUserId, gasMerchantDeviceDO.getLoginUserId());
        assertEquals(rawAddTime, gasMerchantDeviceDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantDeviceDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_device表数据
	 */
	public void assertGasMerchantDevice(GasMerchantDeviceDO expect, GasMerchantDeviceDO gasMerchantDeviceDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantDeviceDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantDeviceDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantDeviceDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantDeviceDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantDeviceDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantDeviceDO);
	}

    /**
	 * 插入gas_merchant_device表数据
	 */
	public void insertGasMerchantDevice(GasMerchantDeviceDO gasMerchantDeviceDO) {
		gasMerchantDeviceDAO.insert(gasMerchantDeviceDO);
	}

    /**
	 * 插入gas_merchant_device表数据
	 */
	public void insertGasMerchantDevice(
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String deviceType, 
			String deviceCode, 
			String loginStatus, 
			String loginUserId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantDeviceDO gasMerchantDeviceDO = new GasMerchantDeviceDO();
		gasMerchantDeviceDO.setId(id);
		gasMerchantDeviceDO.setPartnerId(partnerId);
		gasMerchantDeviceDO.setPlatPartnerId(platPartnerId);
		gasMerchantDeviceDO.setDeviceType(deviceType);
		gasMerchantDeviceDO.setDeviceCode(deviceCode);
		gasMerchantDeviceDO.setLoginStatus(loginStatus);
		gasMerchantDeviceDO.setLoginUserId(loginUserId);
		gasMerchantDeviceDO.setRawAddTime(rawAddTime);
		gasMerchantDeviceDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantDeviceDAO.insert(gasMerchantDeviceDO);
	}

    /**
     * 删除gas_merchant_device表所有数据
     */
    public void cleanGasMerchantDevice() {
        GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
        exam.createCriteria();
        gasMerchantDeviceDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_device表数据
	 */
	public void cleanGasMerchantDeviceById(Long id) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantDeviceDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_device表数据
	 */
	public void cleanGasMerchantDeviceByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantDeviceDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_device表数据
	 */
	public void cleanGasMerchantDeviceByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantDeviceDAO.deleteByExample(exam);
	}

	/**
	* 根据deviceCode删除gas_merchant_device表数据
	*/
	public void cleanGasMerchantDeviceByDeviceCode(String deviceCode) {
        if (StringUtils.isBlank(deviceCode)){
            deviceCode = "test_deviceCode";
        }
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasMerchantDeviceDAO.deleteByExample(exam);
	}

	/**
	 * 根据loginUserId删除gas_merchant_device表数据
	 */
	public void cleanGasMerchantDeviceByLoginUserId(String loginUserId) {
        if (StringUtils.isBlank(loginUserId)){
            loginUserId = "test_loginUserId";
        }
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andLoginUserIdEqualTo(loginUserId);
		gasMerchantDeviceDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_device表所有数据
     */
    public List<GasMerchantDeviceDO> findGasMerchantDeviceAll() {
        GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
        exam.createCriteria();
		return gasMerchantDeviceDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_device表数据
	 */
	public List<GasMerchantDeviceDO> findGasMerchantDeviceById(Long id) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantDeviceDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_device表数据
	 */
	public List<GasMerchantDeviceDO> findGasMerchantDeviceByPartnerId(String partnerId) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantDeviceDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_device表数据
	 */
	public List<GasMerchantDeviceDO> findGasMerchantDeviceByPlatPartnerId(String platPartnerId) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantDeviceDAO.selectByExample(exam);
	}

	/**
	* 根据deviceCode查询gas_merchant_device表数据
	*/
	public List<GasMerchantDeviceDO> findGasMerchantDeviceByDeviceCode(String deviceCode) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		return gasMerchantDeviceDAO.selectByExample(exam);
	}

    /**
	 * 根据loginUserId查询gas_merchant_device表数据
	 */
	public List<GasMerchantDeviceDO> findGasMerchantDeviceByLoginUserId(String loginUserId) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andLoginUserIdEqualTo(loginUserId);
		return gasMerchantDeviceDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_device表数据
	 */
	public void updateGasMerchantDeviceById(Long id,GasMerchantDeviceDO gasMerchantDeviceDO) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantDeviceDAO.updateByExample(gasMerchantDeviceDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_device表数据
	 */
	public void updateGasMerchantDeviceByPartnerId(String partnerId,GasMerchantDeviceDO gasMerchantDeviceDO) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantDeviceDAO.updateByExample(gasMerchantDeviceDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_device表数据
	 */
	public void updateGasMerchantDeviceByPlatPartnerId(String platPartnerId,GasMerchantDeviceDO gasMerchantDeviceDO) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantDeviceDAO.updateByExample(gasMerchantDeviceDO, exam);
	}

	/**
	* 根据deviceCode更新gas_merchant_device表数据
	*/
	public void updateGasMerchantDeviceByDeviceCode(String deviceCode,GasMerchantDeviceDO gasMerchantDeviceDO) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasMerchantDeviceDAO.updateByExample(gasMerchantDeviceDO, exam);
	}

    /**
	 * 根据loginUserId更新gas_merchant_device表数据
	 */
	public void updateGasMerchantDeviceByLoginUserId(String loginUserId,GasMerchantDeviceDO gasMerchantDeviceDO) {
		GasMerchantDeviceDOExample exam = new GasMerchantDeviceDOExample();
		exam.createCriteria().andLoginUserIdEqualTo(loginUserId);
		gasMerchantDeviceDAO.updateByExample(gasMerchantDeviceDO, exam);
	}

    /**
	 * 断言gas_merchant_device_function表
	 */
	public void gasMerchantDeviceFunctionAssert(
	        GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String funcType, 
			Byte open, 
			String deviceType, 
			String deviceCode, 
			String userId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantDeviceFunctionDO.getId());
        assertEquals(partnerId, gasMerchantDeviceFunctionDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantDeviceFunctionDO.getPlatPartnerId());
        assertEquals(stationId, gasMerchantDeviceFunctionDO.getStationId());
        assertEquals(funcType, gasMerchantDeviceFunctionDO.getFuncType());
        assertEquals(open, gasMerchantDeviceFunctionDO.getOpen());
        assertEquals(deviceType, gasMerchantDeviceFunctionDO.getDeviceType());
        assertEquals(deviceCode, gasMerchantDeviceFunctionDO.getDeviceCode());
        assertEquals(userId, gasMerchantDeviceFunctionDO.getUserId());
        assertEquals(rawAddTime, gasMerchantDeviceFunctionDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantDeviceFunctionDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_device_function表数据
	 */
	public void assertGasMerchantDeviceFunction(GasMerchantDeviceFunctionDO expect, GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantDeviceFunctionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantDeviceFunctionDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantDeviceFunctionDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantDeviceFunctionDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantDeviceFunctionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantDeviceFunctionDO);
	}

    /**
	 * 插入gas_merchant_device_function表数据
	 */
	public void insertGasMerchantDeviceFunction(GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		gasMerchantDeviceFunctionDAO.insert(gasMerchantDeviceFunctionDO);
	}

    /**
	 * 插入gas_merchant_device_function表数据
	 */
	public void insertGasMerchantDeviceFunction(
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String funcType, 
			Byte open, 
			String deviceType, 
			String deviceCode, 
			String userId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO = new GasMerchantDeviceFunctionDO();
		gasMerchantDeviceFunctionDO.setId(id);
		gasMerchantDeviceFunctionDO.setPartnerId(partnerId);
		gasMerchantDeviceFunctionDO.setPlatPartnerId(platPartnerId);
		gasMerchantDeviceFunctionDO.setStationId(stationId);
		gasMerchantDeviceFunctionDO.setFuncType(funcType);
		gasMerchantDeviceFunctionDO.setOpen(open);
		gasMerchantDeviceFunctionDO.setDeviceType(deviceType);
		gasMerchantDeviceFunctionDO.setDeviceCode(deviceCode);
		gasMerchantDeviceFunctionDO.setUserId(userId);
		gasMerchantDeviceFunctionDO.setRawAddTime(rawAddTime);
		gasMerchantDeviceFunctionDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantDeviceFunctionDAO.insert(gasMerchantDeviceFunctionDO);
	}

    /**
     * 删除gas_merchant_device_function表所有数据
     */
    public void cleanGasMerchantDeviceFunction() {
        GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
        exam.createCriteria();
        gasMerchantDeviceFunctionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_device_function表数据
	 */
	public void cleanGasMerchantDeviceFunctionById(Long id) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantDeviceFunctionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_device_function表数据
	 */
	public void cleanGasMerchantDeviceFunctionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantDeviceFunctionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_device_function表数据
	 */
	public void cleanGasMerchantDeviceFunctionByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantDeviceFunctionDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_merchant_device_function表数据
	 */
	public void cleanGasMerchantDeviceFunctionByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantDeviceFunctionDAO.deleteByExample(exam);
	}

	/**
	* 根据deviceCode删除gas_merchant_device_function表数据
	*/
	public void cleanGasMerchantDeviceFunctionByDeviceCode(String deviceCode) {
        if (StringUtils.isBlank(deviceCode)){
            deviceCode = "test_deviceCode";
        }
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasMerchantDeviceFunctionDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_merchant_device_function表数据
	 */
	public void cleanGasMerchantDeviceFunctionByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantDeviceFunctionDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_device_function表所有数据
     */
    public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionAll() {
        GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
        exam.createCriteria();
		return gasMerchantDeviceFunctionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_device_function表数据
	 */
	public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionById(Long id) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantDeviceFunctionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_device_function表数据
	 */
	public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionByPartnerId(String partnerId) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantDeviceFunctionDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_device_function表数据
	 */
	public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionByPlatPartnerId(String platPartnerId) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantDeviceFunctionDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_merchant_device_function表数据
	 */
	public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionByStationId(String stationId) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasMerchantDeviceFunctionDAO.selectByExample(exam);
	}

	/**
	* 根据deviceCode查询gas_merchant_device_function表数据
	*/
	public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionByDeviceCode(String deviceCode) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		return gasMerchantDeviceFunctionDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_merchant_device_function表数据
	 */
	public List<GasMerchantDeviceFunctionDO> findGasMerchantDeviceFunctionByUserId(String userId) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasMerchantDeviceFunctionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_device_function表数据
	 */
	public void updateGasMerchantDeviceFunctionById(Long id,GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantDeviceFunctionDAO.updateByExample(gasMerchantDeviceFunctionDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_device_function表数据
	 */
	public void updateGasMerchantDeviceFunctionByPartnerId(String partnerId,GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantDeviceFunctionDAO.updateByExample(gasMerchantDeviceFunctionDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_device_function表数据
	 */
	public void updateGasMerchantDeviceFunctionByPlatPartnerId(String platPartnerId,GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantDeviceFunctionDAO.updateByExample(gasMerchantDeviceFunctionDO, exam);
	}

    /**
	 * 根据stationId更新gas_merchant_device_function表数据
	 */
	public void updateGasMerchantDeviceFunctionByStationId(String stationId,GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantDeviceFunctionDAO.updateByExample(gasMerchantDeviceFunctionDO, exam);
	}

	/**
	* 根据deviceCode更新gas_merchant_device_function表数据
	*/
	public void updateGasMerchantDeviceFunctionByDeviceCode(String deviceCode,GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andDeviceCodeEqualTo(deviceCode);
		gasMerchantDeviceFunctionDAO.updateByExample(gasMerchantDeviceFunctionDO, exam);
	}

    /**
	 * 根据userId更新gas_merchant_device_function表数据
	 */
	public void updateGasMerchantDeviceFunctionByUserId(String userId,GasMerchantDeviceFunctionDO gasMerchantDeviceFunctionDO) {
		GasMerchantDeviceFunctionDOExample exam = new GasMerchantDeviceFunctionDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantDeviceFunctionDAO.updateByExample(gasMerchantDeviceFunctionDO, exam);
	}

    /**
	 * 断言gas_merchant_goods表
	 */
	public void gasMerchantGoodsAssert(
	        GasMerchantGoodsDO gasMerchantGoodsDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String goodsName, 
			String goodsCode, 
			Double taxGoodsRate, 
			String taxGoodsCode, 
			String taxGoodsName, 
			String goodsType, 
			Long groupId, 
			Integer orderNo, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantGoodsDO.getId());
        assertEquals(partnerId, gasMerchantGoodsDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantGoodsDO.getPlatPartnerId());
        assertEquals(goodsName, gasMerchantGoodsDO.getGoodsName());
        assertEquals(goodsCode, gasMerchantGoodsDO.getGoodsCode());
        assertEquals(taxGoodsRate, gasMerchantGoodsDO.getTaxGoodsRate());
        assertEquals(taxGoodsCode, gasMerchantGoodsDO.getTaxGoodsCode());
        assertEquals(taxGoodsName, gasMerchantGoodsDO.getTaxGoodsName());
        assertEquals(goodsType, gasMerchantGoodsDO.getGoodsType());
        assertEquals(groupId, gasMerchantGoodsDO.getGroupId());
        assertEquals(orderNo, gasMerchantGoodsDO.getOrderNo());
        assertEquals(status, gasMerchantGoodsDO.getStatus());
        assertEquals(rawAddTime, gasMerchantGoodsDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantGoodsDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_goods表数据
	 */
	public void assertGasMerchantGoods(GasMerchantGoodsDO expect, GasMerchantGoodsDO gasMerchantGoodsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantGoodsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantGoodsDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantGoodsDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantGoodsDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantGoodsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantGoodsDO);
	}

    /**
	 * 插入gas_merchant_goods表数据
	 */
	public void insertGasMerchantGoods(GasMerchantGoodsDO gasMerchantGoodsDO) {
		gasMerchantGoodsDAO.insert(gasMerchantGoodsDO);
	}

    /**
	 * 插入gas_merchant_goods表数据
	 */
	public void insertGasMerchantGoods(
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String goodsName, 
			String goodsCode, 
			Double taxGoodsRate, 
			String taxGoodsCode, 
			String taxGoodsName, 
			String goodsType, 
			Long groupId, 
			Integer orderNo, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantGoodsDO gasMerchantGoodsDO = new GasMerchantGoodsDO();
		gasMerchantGoodsDO.setId(id);
		gasMerchantGoodsDO.setPartnerId(partnerId);
		gasMerchantGoodsDO.setPlatPartnerId(platPartnerId);
		gasMerchantGoodsDO.setGoodsName(goodsName);
		gasMerchantGoodsDO.setGoodsCode(goodsCode);
		gasMerchantGoodsDO.setTaxGoodsRate(taxGoodsRate);
		gasMerchantGoodsDO.setTaxGoodsCode(taxGoodsCode);
		gasMerchantGoodsDO.setTaxGoodsName(taxGoodsName);
		gasMerchantGoodsDO.setGoodsType(goodsType);
		gasMerchantGoodsDO.setGroupId(groupId);
		gasMerchantGoodsDO.setOrderNo(orderNo);
		gasMerchantGoodsDO.setStatus(status);
		gasMerchantGoodsDO.setRawAddTime(rawAddTime);
		gasMerchantGoodsDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantGoodsDAO.insert(gasMerchantGoodsDO);
	}

    /**
     * 删除gas_merchant_goods表所有数据
     */
    public void cleanGasMerchantGoods() {
        GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
        exam.createCriteria();
        gasMerchantGoodsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_goods表数据
	 */
	public void cleanGasMerchantGoodsById(Long id) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_goods表数据
	 */
	public void cleanGasMerchantGoodsByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_goods表数据
	 */
	public void cleanGasMerchantGoodsByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsName删除gas_merchant_goods表数据
	*/
	public void cleanGasMerchantGoodsByGoodsName(String goodsName) {
        if (StringUtils.isBlank(goodsName)){
            goodsName = "test_goodsName";
        }
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsCode删除gas_merchant_goods表数据
	*/
	public void cleanGasMerchantGoodsByGoodsCode(String goodsCode) {
        if (StringUtils.isBlank(goodsCode)){
            goodsCode = "test_goodsCode";
        }
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据taxGoodsCode删除gas_merchant_goods表数据
	*/
	public void cleanGasMerchantGoodsByTaxGoodsCode(String taxGoodsCode) {
        if (StringUtils.isBlank(taxGoodsCode)){
            taxGoodsCode = "test_taxGoodsCode";
        }
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andTaxGoodsCodeEqualTo(taxGoodsCode);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据taxGoodsName删除gas_merchant_goods表数据
	*/
	public void cleanGasMerchantGoodsByTaxGoodsName(String taxGoodsName) {
        if (StringUtils.isBlank(taxGoodsName)){
            taxGoodsName = "test_taxGoodsName";
        }
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andTaxGoodsNameEqualTo(taxGoodsName);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据groupId删除gas_merchant_goods表数据
	 */
	public void cleanGasMerchantGoodsByGroupId(Long groupId) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据orderNo删除gas_merchant_goods表数据
	 */
	public void cleanGasMerchantGoodsByOrderNo(Integer orderNo) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasMerchantGoodsDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_goods表所有数据
     */
    public List<GasMerchantGoodsDO> findGasMerchantGoodsAll() {
        GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
        exam.createCriteria();
		return gasMerchantGoodsDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_goods表数据
	 */
	public List<GasMerchantGoodsDO> findGasMerchantGoodsById(Long id) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_goods表数据
	 */
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByPartnerId(String partnerId) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_goods表数据
	 */
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByPlatPartnerId(String platPartnerId) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsName查询gas_merchant_goods表数据
	*/
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByGoodsName(String goodsName) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsCode查询gas_merchant_goods表数据
	*/
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByGoodsCode(String goodsCode) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据taxGoodsCode查询gas_merchant_goods表数据
	*/
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByTaxGoodsCode(String taxGoodsCode) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andTaxGoodsCodeEqualTo(taxGoodsCode);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据taxGoodsName查询gas_merchant_goods表数据
	*/
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByTaxGoodsName(String taxGoodsName) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andTaxGoodsNameEqualTo(taxGoodsName);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据groupId查询gas_merchant_goods表数据
	 */
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByGroupId(Long groupId) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据orderNo查询gas_merchant_goods表数据
	 */
	public List<GasMerchantGoodsDO> findGasMerchantGoodsByOrderNo(Integer orderNo) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		return gasMerchantGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_goods表数据
	 */
	public void updateGasMerchantGoodsById(Long id,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_goods表数据
	 */
	public void updateGasMerchantGoodsByPartnerId(String partnerId,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_goods表数据
	 */
	public void updateGasMerchantGoodsByPlatPartnerId(String platPartnerId,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

	/**
	* 根据goodsName更新gas_merchant_goods表数据
	*/
	public void updateGasMerchantGoodsByGoodsName(String goodsName,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

	/**
	* 根据goodsCode更新gas_merchant_goods表数据
	*/
	public void updateGasMerchantGoodsByGoodsCode(String goodsCode,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

	/**
	* 根据taxGoodsCode更新gas_merchant_goods表数据
	*/
	public void updateGasMerchantGoodsByTaxGoodsCode(String taxGoodsCode,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andTaxGoodsCodeEqualTo(taxGoodsCode);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

	/**
	* 根据taxGoodsName更新gas_merchant_goods表数据
	*/
	public void updateGasMerchantGoodsByTaxGoodsName(String taxGoodsName,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andTaxGoodsNameEqualTo(taxGoodsName);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

    /**
	 * 根据groupId更新gas_merchant_goods表数据
	 */
	public void updateGasMerchantGoodsByGroupId(Long groupId,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andGroupIdEqualTo(groupId);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

    /**
	 * 根据orderNo更新gas_merchant_goods表数据
	 */
	public void updateGasMerchantGoodsByOrderNo(Integer orderNo,GasMerchantGoodsDO gasMerchantGoodsDO) {
		GasMerchantGoodsDOExample exam = new GasMerchantGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasMerchantGoodsDAO.updateByExample(gasMerchantGoodsDO, exam);
	}

    /**
	 * 断言gas_merchant_goods_price_plan表
	 */
	public void gasMerchantGoodsPricePlanAssert(
	        GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO,
			Long id, 
			String planId, 
			String priceName, 
			String partnerId, 
			String platPartnerId, 
			Date effectTime, 
			String deleteFlag, 
			String operatorId, 
			String operatorName, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String goodsInfo
	) {
        assertEquals(id, gasMerchantGoodsPricePlanDO.getId());
        assertEquals(planId, gasMerchantGoodsPricePlanDO.getPlanId());
        assertEquals(priceName, gasMerchantGoodsPricePlanDO.getPriceName());
        assertEquals(partnerId, gasMerchantGoodsPricePlanDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantGoodsPricePlanDO.getPlatPartnerId());
        assertEquals(effectTime, gasMerchantGoodsPricePlanDO.getEffectTime());
        assertEquals(deleteFlag, gasMerchantGoodsPricePlanDO.getDeleteFlag());
        assertEquals(operatorId, gasMerchantGoodsPricePlanDO.getOperatorId());
        assertEquals(operatorName, gasMerchantGoodsPricePlanDO.getOperatorName());
        assertEquals(rawAddTime, gasMerchantGoodsPricePlanDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantGoodsPricePlanDO.getRawUpdateTime());
        assertEquals(goodsInfo, gasMerchantGoodsPricePlanDO.getGoodsInfo());
	}

	/**
	 * 断言gas_merchant_goods_price_plan表数据
	 */
	public void assertGasMerchantGoodsPricePlan(GasMerchantGoodsPricePlanDO expect, GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantGoodsPricePlanDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantGoodsPricePlanDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantGoodsPricePlanDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantGoodsPricePlanDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantGoodsPricePlanDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantGoodsPricePlanDO);
	}

    /**
	 * 插入gas_merchant_goods_price_plan表数据
	 */
	public void insertGasMerchantGoodsPricePlan(GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		gasMerchantGoodsPricePlanDAO.insert(gasMerchantGoodsPricePlanDO);
	}

    /**
	 * 插入gas_merchant_goods_price_plan表数据
	 */
	public void insertGasMerchantGoodsPricePlan(
			Long id, 
			String planId, 
			String priceName, 
			String partnerId, 
			String platPartnerId, 
			Date effectTime, 
			String deleteFlag, 
			String operatorId, 
			String operatorName, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String goodsInfo
	) {
		if (effectTime == null) {
			effectTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO = new GasMerchantGoodsPricePlanDO();
		gasMerchantGoodsPricePlanDO.setId(id);
		gasMerchantGoodsPricePlanDO.setPlanId(planId);
		gasMerchantGoodsPricePlanDO.setPriceName(priceName);
		gasMerchantGoodsPricePlanDO.setPartnerId(partnerId);
		gasMerchantGoodsPricePlanDO.setPlatPartnerId(platPartnerId);
		gasMerchantGoodsPricePlanDO.setEffectTime(effectTime);
		gasMerchantGoodsPricePlanDO.setDeleteFlag(deleteFlag);
		gasMerchantGoodsPricePlanDO.setOperatorId(operatorId);
		gasMerchantGoodsPricePlanDO.setOperatorName(operatorName);
		gasMerchantGoodsPricePlanDO.setRawAddTime(rawAddTime);
		gasMerchantGoodsPricePlanDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantGoodsPricePlanDO.setGoodsInfo(goodsInfo);
		gasMerchantGoodsPricePlanDAO.insert(gasMerchantGoodsPricePlanDO);
	}

    /**
     * 删除gas_merchant_goods_price_plan表所有数据
     */
    public void cleanGasMerchantGoodsPricePlan() {
        GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
        exam.createCriteria();
        gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_goods_price_plan表数据
	 */
	public void cleanGasMerchantGoodsPricePlanById(Long id) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据planId删除gas_merchant_goods_price_plan表数据
	 */
	public void cleanGasMerchantGoodsPricePlanByPlanId(String planId) {
        if (StringUtils.isBlank(planId)){
            planId = "test_planId";
        }
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	* 根据priceName删除gas_merchant_goods_price_plan表数据
	*/
	public void cleanGasMerchantGoodsPricePlanByPriceName(String priceName) {
        if (StringUtils.isBlank(priceName)){
            priceName = "test_priceName";
        }
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_goods_price_plan表数据
	 */
	public void cleanGasMerchantGoodsPricePlanByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_goods_price_plan表数据
	 */
	public void cleanGasMerchantGoodsPricePlanByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据operatorId删除gas_merchant_goods_price_plan表数据
	 */
	public void cleanGasMerchantGoodsPricePlanByOperatorId(String operatorId) {
        if (StringUtils.isBlank(operatorId)){
            operatorId = "test_operatorId";
        }
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	* 根据operatorName删除gas_merchant_goods_price_plan表数据
	*/
	public void cleanGasMerchantGoodsPricePlanByOperatorName(String operatorName) {
        if (StringUtils.isBlank(operatorName)){
            operatorName = "test_operatorName";
        }
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		gasMerchantGoodsPricePlanDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_goods_price_plan表所有数据
     */
    public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanAll() {
        GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
        exam.createCriteria();
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_goods_price_plan表数据
	 */
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanById(Long id) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据planId查询gas_merchant_goods_price_plan表数据
	 */
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanByPlanId(String planId) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
	}

	/**
	* 根据priceName查询gas_merchant_goods_price_plan表数据
	*/
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanByPriceName(String priceName) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_goods_price_plan表数据
	 */
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanByPartnerId(String partnerId) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_goods_price_plan表数据
	 */
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanByPlatPartnerId(String platPartnerId) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据operatorId查询gas_merchant_goods_price_plan表数据
	 */
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanByOperatorId(String operatorId) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
	}

	/**
	* 根据operatorName查询gas_merchant_goods_price_plan表数据
	*/
	public List<GasMerchantGoodsPricePlanDO> findGasMerchantGoodsPricePlanByOperatorName(String operatorName) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		return gasMerchantGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_goods_price_plan表数据
	 */
	public void updateGasMerchantGoodsPricePlanById(Long id,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantGoodsPricePlanDAO.updateByExample(gasMerchantGoodsPricePlanDO, exam);
	}

    /**
	 * 根据planId更新gas_merchant_goods_price_plan表数据
	 */
	public void updateGasMerchantGoodsPricePlanByPlanId(String planId,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		gasMerchantGoodsPricePlanDAO.updateByExample(gasMerchantGoodsPricePlanDO, exam);
	}

	/**
	* 根据priceName更新gas_merchant_goods_price_plan表数据
	*/
	public void updateGasMerchantGoodsPricePlanByPriceName(String priceName,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		gasMerchantGoodsPricePlanDAO.updateByExample(gasMerchantGoodsPricePlanDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_goods_price_plan表数据
	 */
	public void updateGasMerchantGoodsPricePlanByPartnerId(String partnerId,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantGoodsPricePlanDAO.updateByExample(gasMerchantGoodsPricePlanDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_goods_price_plan表数据
	 */
	public void updateGasMerchantGoodsPricePlanByPlatPartnerId(String platPartnerId,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantGoodsPricePlanDAO.updateByExample(gasMerchantGoodsPricePlanDO, exam);
	}

    /**
	 * 根据operatorId更新gas_merchant_goods_price_plan表数据
	 */
	public void updateGasMerchantGoodsPricePlanByOperatorId(String operatorId,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		gasMerchantGoodsPricePlanDAO.updateByExample(gasMerchantGoodsPricePlanDO, exam);
	}

	/**
	* 根据operatorName更新gas_merchant_goods_price_plan表数据
	*/
	public void updateGasMerchantGoodsPricePlanByOperatorName(String operatorName,GasMerchantGoodsPricePlanDO gasMerchantGoodsPricePlanDO) {
		GasMerchantGoodsPricePlanDOExample exam = new GasMerchantGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		gasMerchantGoodsPricePlanDAO.updateByExample(gasMerchantGoodsPricePlanDO, exam);
	}

    /**
	 * 断言gas_merchant_motorcade表
	 */
	public void gasMerchantMotorcadeAssert(
	        GasMerchantMotorcadeDO gasMerchantMotorcadeDO,
			Long id, 
			String platPartnerId, 
			String partnerId, 
			String partnerName, 
			String motorcadeId, 
			String motorcadeName, 
			String motorcadePhone, 
			String userId, 
			String accountNo, 
			Long balance, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantMotorcadeDO.getId());
        assertEquals(platPartnerId, gasMerchantMotorcadeDO.getPlatPartnerId());
        assertEquals(partnerId, gasMerchantMotorcadeDO.getPartnerId());
        assertEquals(partnerName, gasMerchantMotorcadeDO.getPartnerName());
        assertEquals(motorcadeId, gasMerchantMotorcadeDO.getMotorcadeId());
        assertEquals(motorcadeName, gasMerchantMotorcadeDO.getMotorcadeName());
        assertEquals(motorcadePhone, gasMerchantMotorcadeDO.getMotorcadePhone());
        assertEquals(userId, gasMerchantMotorcadeDO.getUserId());
        assertEquals(accountNo, gasMerchantMotorcadeDO.getAccountNo());
        assertEquals(balance, gasMerchantMotorcadeDO.getBalance());
        assertEquals(rawAddTime, gasMerchantMotorcadeDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantMotorcadeDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_motorcade表数据
	 */
	public void assertGasMerchantMotorcade(GasMerchantMotorcadeDO expect, GasMerchantMotorcadeDO gasMerchantMotorcadeDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantMotorcadeDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantMotorcadeDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantMotorcadeDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantMotorcadeDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantMotorcadeDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantMotorcadeDO);
	}

    /**
	 * 插入gas_merchant_motorcade表数据
	 */
	public void insertGasMerchantMotorcade(GasMerchantMotorcadeDO gasMerchantMotorcadeDO) {
		gasMerchantMotorcadeDAO.insert(gasMerchantMotorcadeDO);
	}

    /**
	 * 插入gas_merchant_motorcade表数据
	 */
	public void insertGasMerchantMotorcade(
			Long id, 
			String platPartnerId, 
			String partnerId, 
			String partnerName, 
			String motorcadeId, 
			String motorcadeName, 
			String motorcadePhone, 
			String userId, 
			String accountNo, 
			Long balance, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantMotorcadeDO gasMerchantMotorcadeDO = new GasMerchantMotorcadeDO();
		gasMerchantMotorcadeDO.setId(id);
		gasMerchantMotorcadeDO.setPlatPartnerId(platPartnerId);
		gasMerchantMotorcadeDO.setPartnerId(partnerId);
		gasMerchantMotorcadeDO.setPartnerName(partnerName);
		gasMerchantMotorcadeDO.setMotorcadeId(motorcadeId);
		gasMerchantMotorcadeDO.setMotorcadeName(motorcadeName);
		gasMerchantMotorcadeDO.setMotorcadePhone(motorcadePhone);
		gasMerchantMotorcadeDO.setUserId(userId);
		gasMerchantMotorcadeDO.setAccountNo(accountNo);
		gasMerchantMotorcadeDO.setBalance(balance);
		gasMerchantMotorcadeDO.setRawAddTime(rawAddTime);
		gasMerchantMotorcadeDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantMotorcadeDAO.insert(gasMerchantMotorcadeDO);
	}

    /**
     * 删除gas_merchant_motorcade表所有数据
     */
    public void cleanGasMerchantMotorcade() {
        GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
        exam.createCriteria();
        gasMerchantMotorcadeDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_motorcade表数据
	 */
	public void cleanGasMerchantMotorcadeById(Long id) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantMotorcadeDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_motorcade表数据
	 */
	public void cleanGasMerchantMotorcadeByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantMotorcadeDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_motorcade表数据
	 */
	public void cleanGasMerchantMotorcadeByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantMotorcadeDAO.deleteByExample(exam);
	}

	/**
	* 根据partnerName删除gas_merchant_motorcade表数据
	*/
	public void cleanGasMerchantMotorcadeByPartnerName(String partnerName) {
        if (StringUtils.isBlank(partnerName)){
            partnerName = "test_partnerName";
        }
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasMerchantMotorcadeDAO.deleteByExample(exam);
	}

	/**
	 * 根据motorcadeId删除gas_merchant_motorcade表数据
	 */
	public void cleanGasMerchantMotorcadeByMotorcadeId(String motorcadeId) {
        if (StringUtils.isBlank(motorcadeId)){
            motorcadeId = "test_motorcadeId";
        }
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andMotorcadeIdEqualTo(motorcadeId);
		gasMerchantMotorcadeDAO.deleteByExample(exam);
	}

	/**
	* 根据motorcadeName删除gas_merchant_motorcade表数据
	*/
	public void cleanGasMerchantMotorcadeByMotorcadeName(String motorcadeName) {
        if (StringUtils.isBlank(motorcadeName)){
            motorcadeName = "test_motorcadeName";
        }
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andMotorcadeNameEqualTo(motorcadeName);
		gasMerchantMotorcadeDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_merchant_motorcade表数据
	 */
	public void cleanGasMerchantMotorcadeByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantMotorcadeDAO.deleteByExample(exam);
	}

	/**
	 * 根据accountNo删除gas_merchant_motorcade表数据
	 */
	public void cleanGasMerchantMotorcadeByAccountNo(String accountNo) {
        if (StringUtils.isBlank(accountNo)){
            accountNo = "test_accountNo";
        }
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		gasMerchantMotorcadeDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_motorcade表所有数据
     */
    public List<GasMerchantMotorcadeDO> findGasMerchantMotorcadeAll() {
        GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
        exam.createCriteria();
		return gasMerchantMotorcadeDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_motorcade表数据
	 */
	public List<GasMerchantMotorcadeDO> findGasMerchantMotorcadeById(Long id) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantMotorcadeDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_motorcade表数据
	 */
	public List<GasMerchantMotorcadeDO> findGasMerchantMotorcadeByPlatPartnerId(String platPartnerId) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantMotorcadeDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_motorcade表数据
	 */
	public List<GasMerchantMotorcadeDO> findGasMerchantMotorcadeByPartnerId(String partnerId) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantMotorcadeDAO.selectByExample(exam);
	}

	/**
	* 根据partnerName查询gas_merchant_motorcade表数据
	*/
	public List<GasMerchantMotorcadeDO> findGasMerchantMotorcadeByPartnerName(String partnerName) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		return gasMerchantMotorcadeDAO.selectByExample(exam);
	}

    /**
	 * 根据motorcadeId查询gas_merchant_motorcade表数据
	 */
	public List<GasMerchantMotorcadeDO> findGasMerchantMotorcadeByMotorcadeId(String motorcadeId) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andMotorcadeIdEqualTo(motorcadeId);
		return gasMerchantMotorcadeDAO.selectByExample(exam);
	}

	/**
	* 根据motorcadeName查询gas_merchant_motorcade表数据
	*/
	public List<GasMerchantMotorcadeDO> findGasMerchantMotorcadeByMotorcadeName(String motorcadeName) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andMotorcadeNameEqualTo(motorcadeName);
		return gasMerchantMotorcadeDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_merchant_motorcade表数据
	 */
	public List<GasMerchantMotorcadeDO> findGasMerchantMotorcadeByUserId(String userId) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasMerchantMotorcadeDAO.selectByExample(exam);
	}

    /**
	 * 根据accountNo查询gas_merchant_motorcade表数据
	 */
	public List<GasMerchantMotorcadeDO> findGasMerchantMotorcadeByAccountNo(String accountNo) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		return gasMerchantMotorcadeDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_motorcade表数据
	 */
	public void updateGasMerchantMotorcadeById(Long id,GasMerchantMotorcadeDO gasMerchantMotorcadeDO) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantMotorcadeDAO.updateByExample(gasMerchantMotorcadeDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_motorcade表数据
	 */
	public void updateGasMerchantMotorcadeByPlatPartnerId(String platPartnerId,GasMerchantMotorcadeDO gasMerchantMotorcadeDO) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantMotorcadeDAO.updateByExample(gasMerchantMotorcadeDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_motorcade表数据
	 */
	public void updateGasMerchantMotorcadeByPartnerId(String partnerId,GasMerchantMotorcadeDO gasMerchantMotorcadeDO) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantMotorcadeDAO.updateByExample(gasMerchantMotorcadeDO, exam);
	}

	/**
	* 根据partnerName更新gas_merchant_motorcade表数据
	*/
	public void updateGasMerchantMotorcadeByPartnerName(String partnerName,GasMerchantMotorcadeDO gasMerchantMotorcadeDO) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andPartnerNameEqualTo(partnerName);
		gasMerchantMotorcadeDAO.updateByExample(gasMerchantMotorcadeDO, exam);
	}

    /**
	 * 根据motorcadeId更新gas_merchant_motorcade表数据
	 */
	public void updateGasMerchantMotorcadeByMotorcadeId(String motorcadeId,GasMerchantMotorcadeDO gasMerchantMotorcadeDO) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andMotorcadeIdEqualTo(motorcadeId);
		gasMerchantMotorcadeDAO.updateByExample(gasMerchantMotorcadeDO, exam);
	}

	/**
	* 根据motorcadeName更新gas_merchant_motorcade表数据
	*/
	public void updateGasMerchantMotorcadeByMotorcadeName(String motorcadeName,GasMerchantMotorcadeDO gasMerchantMotorcadeDO) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andMotorcadeNameEqualTo(motorcadeName);
		gasMerchantMotorcadeDAO.updateByExample(gasMerchantMotorcadeDO, exam);
	}

    /**
	 * 根据userId更新gas_merchant_motorcade表数据
	 */
	public void updateGasMerchantMotorcadeByUserId(String userId,GasMerchantMotorcadeDO gasMerchantMotorcadeDO) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantMotorcadeDAO.updateByExample(gasMerchantMotorcadeDO, exam);
	}

    /**
	 * 根据accountNo更新gas_merchant_motorcade表数据
	 */
	public void updateGasMerchantMotorcadeByAccountNo(String accountNo,GasMerchantMotorcadeDO gasMerchantMotorcadeDO) {
		GasMerchantMotorcadeDOExample exam = new GasMerchantMotorcadeDOExample();
		exam.createCriteria().andAccountNoEqualTo(accountNo);
		gasMerchantMotorcadeDAO.updateByExample(gasMerchantMotorcadeDO, exam);
	}

    /**
	 * 断言gas_merchant_payway表
	 */
	public void gasMerchantPaywayAssert(
	        GasMerchantPaywayDO gasMerchantPaywayDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String paywayCode, 
			String paywayName, 
			String paywayType, 
			String paywayIcon, 
			String paywaySmallIcon, 
			String channelCode, 
			String channelFunction, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String paywayScene, 
			String paywayAttribute
	) {
        assertEquals(id, gasMerchantPaywayDO.getId());
        assertEquals(partnerId, gasMerchantPaywayDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantPaywayDO.getPlatPartnerId());
        assertEquals(paywayCode, gasMerchantPaywayDO.getPaywayCode());
        assertEquals(paywayName, gasMerchantPaywayDO.getPaywayName());
        assertEquals(paywayType, gasMerchantPaywayDO.getPaywayType());
        assertEquals(paywayIcon, gasMerchantPaywayDO.getPaywayIcon());
        assertEquals(paywaySmallIcon, gasMerchantPaywayDO.getPaywaySmallIcon());
        assertEquals(channelCode, gasMerchantPaywayDO.getChannelCode());
        assertEquals(channelFunction, gasMerchantPaywayDO.getChannelFunction());
        assertEquals(status, gasMerchantPaywayDO.getStatus());
        assertEquals(rawAddTime, gasMerchantPaywayDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantPaywayDO.getRawUpdateTime());
        assertEquals(paywayScene, gasMerchantPaywayDO.getPaywayScene());
        assertEquals(paywayAttribute, gasMerchantPaywayDO.getPaywayAttribute());
	}

	/**
	 * 断言gas_merchant_payway表数据
	 */
	public void assertGasMerchantPayway(GasMerchantPaywayDO expect, GasMerchantPaywayDO gasMerchantPaywayDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantPaywayDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantPaywayDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantPaywayDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantPaywayDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantPaywayDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantPaywayDO);
	}

    /**
	 * 插入gas_merchant_payway表数据
	 */
	public void insertGasMerchantPayway(GasMerchantPaywayDO gasMerchantPaywayDO) {
		gasMerchantPaywayDAO.insert(gasMerchantPaywayDO);
	}

    /**
	 * 插入gas_merchant_payway表数据
	 */
	public void insertGasMerchantPayway(
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String paywayCode, 
			String paywayName, 
			String paywayType, 
			String paywayIcon, 
			String paywaySmallIcon, 
			String channelCode, 
			String channelFunction, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String paywayScene, 
			String paywayAttribute
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantPaywayDO gasMerchantPaywayDO = new GasMerchantPaywayDO();
		gasMerchantPaywayDO.setId(id);
		gasMerchantPaywayDO.setPartnerId(partnerId);
		gasMerchantPaywayDO.setPlatPartnerId(platPartnerId);
		gasMerchantPaywayDO.setPaywayCode(paywayCode);
		gasMerchantPaywayDO.setPaywayName(paywayName);
		gasMerchantPaywayDO.setPaywayType(paywayType);
		gasMerchantPaywayDO.setPaywayIcon(paywayIcon);
		gasMerchantPaywayDO.setPaywaySmallIcon(paywaySmallIcon);
		gasMerchantPaywayDO.setChannelCode(channelCode);
		gasMerchantPaywayDO.setChannelFunction(channelFunction);
		gasMerchantPaywayDO.setStatus(status);
		gasMerchantPaywayDO.setRawAddTime(rawAddTime);
		gasMerchantPaywayDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantPaywayDO.setPaywayScene(paywayScene);
		gasMerchantPaywayDO.setPaywayAttribute(paywayAttribute);
		gasMerchantPaywayDAO.insert(gasMerchantPaywayDO);
	}

    /**
     * 删除gas_merchant_payway表所有数据
     */
    public void cleanGasMerchantPayway() {
        GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
        exam.createCriteria();
        gasMerchantPaywayDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_payway表数据
	 */
	public void cleanGasMerchantPaywayById(Long id) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantPaywayDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_payway表数据
	 */
	public void cleanGasMerchantPaywayByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantPaywayDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_payway表数据
	 */
	public void cleanGasMerchantPaywayByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantPaywayDAO.deleteByExample(exam);
	}

	/**
	* 根据paywayCode删除gas_merchant_payway表数据
	*/
	public void cleanGasMerchantPaywayByPaywayCode(String paywayCode) {
        if (StringUtils.isBlank(paywayCode)){
            paywayCode = "test_paywayCode";
        }
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPaywayCodeEqualTo(paywayCode);
		gasMerchantPaywayDAO.deleteByExample(exam);
	}

	/**
	* 根据paywayName删除gas_merchant_payway表数据
	*/
	public void cleanGasMerchantPaywayByPaywayName(String paywayName) {
        if (StringUtils.isBlank(paywayName)){
            paywayName = "test_paywayName";
        }
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPaywayNameEqualTo(paywayName);
		gasMerchantPaywayDAO.deleteByExample(exam);
	}

	/**
	* 根据channelCode删除gas_merchant_payway表数据
	*/
	public void cleanGasMerchantPaywayByChannelCode(String channelCode) {
        if (StringUtils.isBlank(channelCode)){
            channelCode = "test_channelCode";
        }
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andChannelCodeEqualTo(channelCode);
		gasMerchantPaywayDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_payway表所有数据
     */
    public List<GasMerchantPaywayDO> findGasMerchantPaywayAll() {
        GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
        exam.createCriteria();
		return gasMerchantPaywayDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_payway表数据
	 */
	public List<GasMerchantPaywayDO> findGasMerchantPaywayById(Long id) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantPaywayDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_payway表数据
	 */
	public List<GasMerchantPaywayDO> findGasMerchantPaywayByPartnerId(String partnerId) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantPaywayDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_payway表数据
	 */
	public List<GasMerchantPaywayDO> findGasMerchantPaywayByPlatPartnerId(String platPartnerId) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantPaywayDAO.selectByExample(exam);
	}

	/**
	* 根据paywayCode查询gas_merchant_payway表数据
	*/
	public List<GasMerchantPaywayDO> findGasMerchantPaywayByPaywayCode(String paywayCode) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPaywayCodeEqualTo(paywayCode);
		return gasMerchantPaywayDAO.selectByExample(exam);
	}

	/**
	* 根据paywayName查询gas_merchant_payway表数据
	*/
	public List<GasMerchantPaywayDO> findGasMerchantPaywayByPaywayName(String paywayName) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPaywayNameEqualTo(paywayName);
		return gasMerchantPaywayDAO.selectByExample(exam);
	}

	/**
	* 根据channelCode查询gas_merchant_payway表数据
	*/
	public List<GasMerchantPaywayDO> findGasMerchantPaywayByChannelCode(String channelCode) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andChannelCodeEqualTo(channelCode);
		return gasMerchantPaywayDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_payway表数据
	 */
	public void updateGasMerchantPaywayById(Long id,GasMerchantPaywayDO gasMerchantPaywayDO) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantPaywayDAO.updateByExample(gasMerchantPaywayDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_payway表数据
	 */
	public void updateGasMerchantPaywayByPartnerId(String partnerId,GasMerchantPaywayDO gasMerchantPaywayDO) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantPaywayDAO.updateByExample(gasMerchantPaywayDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_payway表数据
	 */
	public void updateGasMerchantPaywayByPlatPartnerId(String platPartnerId,GasMerchantPaywayDO gasMerchantPaywayDO) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantPaywayDAO.updateByExample(gasMerchantPaywayDO, exam);
	}

	/**
	* 根据paywayCode更新gas_merchant_payway表数据
	*/
	public void updateGasMerchantPaywayByPaywayCode(String paywayCode,GasMerchantPaywayDO gasMerchantPaywayDO) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPaywayCodeEqualTo(paywayCode);
		gasMerchantPaywayDAO.updateByExample(gasMerchantPaywayDO, exam);
	}

	/**
	* 根据paywayName更新gas_merchant_payway表数据
	*/
	public void updateGasMerchantPaywayByPaywayName(String paywayName,GasMerchantPaywayDO gasMerchantPaywayDO) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andPaywayNameEqualTo(paywayName);
		gasMerchantPaywayDAO.updateByExample(gasMerchantPaywayDO, exam);
	}

	/**
	* 根据channelCode更新gas_merchant_payway表数据
	*/
	public void updateGasMerchantPaywayByChannelCode(String channelCode,GasMerchantPaywayDO gasMerchantPaywayDO) {
		GasMerchantPaywayDOExample exam = new GasMerchantPaywayDOExample();
		exam.createCriteria().andChannelCodeEqualTo(channelCode);
		gasMerchantPaywayDAO.updateByExample(gasMerchantPaywayDO, exam);
	}

    /**
	 * 断言gas_merchant_resource表
	 */
	public void gasMerchantResourceAssert(
	        GasMerchantResourceDO gasMerchantResourceDO,
			Long id, 
			String platPartnerId, 
			Long resourceId
	) {
        assertEquals(id, gasMerchantResourceDO.getId());
        assertEquals(platPartnerId, gasMerchantResourceDO.getPlatPartnerId());
        assertEquals(resourceId, gasMerchantResourceDO.getResourceId());
	}

	/**
	 * 断言gas_merchant_resource表数据
	 */
	public void assertGasMerchantResource(GasMerchantResourceDO expect, GasMerchantResourceDO gasMerchantResourceDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantResourceDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasMerchantResourceDO);
	}

    /**
	 * 插入gas_merchant_resource表数据
	 */
	public void insertGasMerchantResource(GasMerchantResourceDO gasMerchantResourceDO) {
		gasMerchantResourceDAO.insert(gasMerchantResourceDO);
	}

    /**
	 * 插入gas_merchant_resource表数据
	 */
	public void insertGasMerchantResource(
			Long id, 
			String platPartnerId, 
			Long resourceId
	) {
		GasMerchantResourceDO gasMerchantResourceDO = new GasMerchantResourceDO();
		gasMerchantResourceDO.setId(id);
		gasMerchantResourceDO.setPlatPartnerId(platPartnerId);
		gasMerchantResourceDO.setResourceId(resourceId);
		gasMerchantResourceDAO.insert(gasMerchantResourceDO);
	}

    /**
     * 删除gas_merchant_resource表所有数据
     */
    public void cleanGasMerchantResource() {
        GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
        exam.createCriteria();
        gasMerchantResourceDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_resource表数据
	 */
	public void cleanGasMerchantResourceById(Long id) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_resource表数据
	 */
	public void cleanGasMerchantResourceByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据resourceId删除gas_merchant_resource表数据
	 */
	public void cleanGasMerchantResourceByResourceId(Long resourceId) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		gasMerchantResourceDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_resource表所有数据
     */
    public List<GasMerchantResourceDO> findGasMerchantResourceAll() {
        GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
        exam.createCriteria();
		return gasMerchantResourceDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_resource表数据
	 */
	public List<GasMerchantResourceDO> findGasMerchantResourceById(Long id) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_resource表数据
	 */
	public List<GasMerchantResourceDO> findGasMerchantResourceByPlatPartnerId(String platPartnerId) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据resourceId查询gas_merchant_resource表数据
	 */
	public List<GasMerchantResourceDO> findGasMerchantResourceByResourceId(Long resourceId) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		return gasMerchantResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_resource表数据
	 */
	public void updateGasMerchantResourceById(Long id,GasMerchantResourceDO gasMerchantResourceDO) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantResourceDAO.updateByExample(gasMerchantResourceDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_resource表数据
	 */
	public void updateGasMerchantResourceByPlatPartnerId(String platPartnerId,GasMerchantResourceDO gasMerchantResourceDO) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantResourceDAO.updateByExample(gasMerchantResourceDO, exam);
	}

    /**
	 * 根据resourceId更新gas_merchant_resource表数据
	 */
	public void updateGasMerchantResourceByResourceId(Long resourceId,GasMerchantResourceDO gasMerchantResourceDO) {
		GasMerchantResourceDOExample exam = new GasMerchantResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		gasMerchantResourceDAO.updateByExample(gasMerchantResourceDO, exam);
	}

    /**
	 * 断言gas_merchant_role表
	 */
	public void gasMerchantRoleAssert(
	        GasMerchantRoleDO gasMerchantRoleDO,
			Long id, 
			String platPartnerId, 
			Long roleId
	) {
        assertEquals(id, gasMerchantRoleDO.getId());
        assertEquals(platPartnerId, gasMerchantRoleDO.getPlatPartnerId());
        assertEquals(roleId, gasMerchantRoleDO.getRoleId());
	}

	/**
	 * 断言gas_merchant_role表数据
	 */
	public void assertGasMerchantRole(GasMerchantRoleDO expect, GasMerchantRoleDO gasMerchantRoleDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantRoleDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasMerchantRoleDO);
	}

    /**
	 * 插入gas_merchant_role表数据
	 */
	public void insertGasMerchantRole(GasMerchantRoleDO gasMerchantRoleDO) {
		gasMerchantRoleDAO.insert(gasMerchantRoleDO);
	}

    /**
	 * 插入gas_merchant_role表数据
	 */
	public void insertGasMerchantRole(
			Long id, 
			String platPartnerId, 
			Long roleId
	) {
		GasMerchantRoleDO gasMerchantRoleDO = new GasMerchantRoleDO();
		gasMerchantRoleDO.setId(id);
		gasMerchantRoleDO.setPlatPartnerId(platPartnerId);
		gasMerchantRoleDO.setRoleId(roleId);
		gasMerchantRoleDAO.insert(gasMerchantRoleDO);
	}

    /**
     * 删除gas_merchant_role表所有数据
     */
    public void cleanGasMerchantRole() {
        GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
        exam.createCriteria();
        gasMerchantRoleDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_role表数据
	 */
	public void cleanGasMerchantRoleById(Long id) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantRoleDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_role表数据
	 */
	public void cleanGasMerchantRoleByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantRoleDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleId删除gas_merchant_role表数据
	 */
	public void cleanGasMerchantRoleByRoleId(Long roleId) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantRoleDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_role表所有数据
     */
    public List<GasMerchantRoleDO> findGasMerchantRoleAll() {
        GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
        exam.createCriteria();
		return gasMerchantRoleDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_role表数据
	 */
	public List<GasMerchantRoleDO> findGasMerchantRoleById(Long id) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_role表数据
	 */
	public List<GasMerchantRoleDO> findGasMerchantRoleByPlatPartnerId(String platPartnerId) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据roleId查询gas_merchant_role表数据
	 */
	public List<GasMerchantRoleDO> findGasMerchantRoleByRoleId(Long roleId) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		return gasMerchantRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_role表数据
	 */
	public void updateGasMerchantRoleById(Long id,GasMerchantRoleDO gasMerchantRoleDO) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantRoleDAO.updateByExample(gasMerchantRoleDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_role表数据
	 */
	public void updateGasMerchantRoleByPlatPartnerId(String platPartnerId,GasMerchantRoleDO gasMerchantRoleDO) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantRoleDAO.updateByExample(gasMerchantRoleDO, exam);
	}

    /**
	 * 根据roleId更新gas_merchant_role表数据
	 */
	public void updateGasMerchantRoleByRoleId(Long roleId,GasMerchantRoleDO gasMerchantRoleDO) {
		GasMerchantRoleDOExample exam = new GasMerchantRoleDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantRoleDAO.updateByExample(gasMerchantRoleDO, exam);
	}

    /**
	 * 断言gas_merchant_role_resource表
	 */
	public void gasMerchantRoleResourceAssert(
	        GasMerchantRoleResourceDO gasMerchantRoleResourceDO,
			Long id, 
			Long roleId, 
			Long resourceId
	) {
        assertEquals(id, gasMerchantRoleResourceDO.getId());
        assertEquals(roleId, gasMerchantRoleResourceDO.getRoleId());
        assertEquals(resourceId, gasMerchantRoleResourceDO.getResourceId());
	}

	/**
	 * 断言gas_merchant_role_resource表数据
	 */
	public void assertGasMerchantRoleResource(GasMerchantRoleResourceDO expect, GasMerchantRoleResourceDO gasMerchantRoleResourceDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantRoleResourceDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasMerchantRoleResourceDO);
	}

    /**
	 * 插入gas_merchant_role_resource表数据
	 */
	public void insertGasMerchantRoleResource(GasMerchantRoleResourceDO gasMerchantRoleResourceDO) {
		gasMerchantRoleResourceDAO.insert(gasMerchantRoleResourceDO);
	}

    /**
	 * 插入gas_merchant_role_resource表数据
	 */
	public void insertGasMerchantRoleResource(
			Long id, 
			Long roleId, 
			Long resourceId
	) {
		GasMerchantRoleResourceDO gasMerchantRoleResourceDO = new GasMerchantRoleResourceDO();
		gasMerchantRoleResourceDO.setId(id);
		gasMerchantRoleResourceDO.setRoleId(roleId);
		gasMerchantRoleResourceDO.setResourceId(resourceId);
		gasMerchantRoleResourceDAO.insert(gasMerchantRoleResourceDO);
	}

    /**
     * 删除gas_merchant_role_resource表所有数据
     */
    public void cleanGasMerchantRoleResource() {
        GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
        exam.createCriteria();
        gasMerchantRoleResourceDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_role_resource表数据
	 */
	public void cleanGasMerchantRoleResourceById(Long id) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantRoleResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleId删除gas_merchant_role_resource表数据
	 */
	public void cleanGasMerchantRoleResourceByRoleId(Long roleId) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantRoleResourceDAO.deleteByExample(exam);
	}

	/**
	 * 根据resourceId删除gas_merchant_role_resource表数据
	 */
	public void cleanGasMerchantRoleResourceByResourceId(Long resourceId) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		gasMerchantRoleResourceDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_role_resource表所有数据
     */
    public List<GasMerchantRoleResourceDO> findGasMerchantRoleResourceAll() {
        GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
        exam.createCriteria();
		return gasMerchantRoleResourceDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_role_resource表数据
	 */
	public List<GasMerchantRoleResourceDO> findGasMerchantRoleResourceById(Long id) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantRoleResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据roleId查询gas_merchant_role_resource表数据
	 */
	public List<GasMerchantRoleResourceDO> findGasMerchantRoleResourceByRoleId(Long roleId) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		return gasMerchantRoleResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据resourceId查询gas_merchant_role_resource表数据
	 */
	public List<GasMerchantRoleResourceDO> findGasMerchantRoleResourceByResourceId(Long resourceId) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		return gasMerchantRoleResourceDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_role_resource表数据
	 */
	public void updateGasMerchantRoleResourceById(Long id,GasMerchantRoleResourceDO gasMerchantRoleResourceDO) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantRoleResourceDAO.updateByExample(gasMerchantRoleResourceDO, exam);
	}

    /**
	 * 根据roleId更新gas_merchant_role_resource表数据
	 */
	public void updateGasMerchantRoleResourceByRoleId(Long roleId,GasMerchantRoleResourceDO gasMerchantRoleResourceDO) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantRoleResourceDAO.updateByExample(gasMerchantRoleResourceDO, exam);
	}

    /**
	 * 根据resourceId更新gas_merchant_role_resource表数据
	 */
	public void updateGasMerchantRoleResourceByResourceId(Long resourceId,GasMerchantRoleResourceDO gasMerchantRoleResourceDO) {
		GasMerchantRoleResourceDOExample exam = new GasMerchantRoleResourceDOExample();
		exam.createCriteria().andResourceIdEqualTo(resourceId);
		gasMerchantRoleResourceDAO.updateByExample(gasMerchantRoleResourceDO, exam);
	}

    /**
	 * 断言gas_merchant_source_data表
	 */
	public void gasMerchantSourceDataAssert(
	        GasMerchantSourceDataDO gasMerchantSourceDataDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String sourceType, 
			String sourceKey, 
			Date authorizerAccessTokenTime, 
			String authorizerAccessToken, 
			Byte authorized, 
			String authorizerRefreshToken, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String sourceInfo, 
			String funcInfo
	) {
        assertEquals(id, gasMerchantSourceDataDO.getId());
        assertEquals(partnerId, gasMerchantSourceDataDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantSourceDataDO.getPlatPartnerId());
        assertEquals(sourceType, gasMerchantSourceDataDO.getSourceType());
        assertEquals(sourceKey, gasMerchantSourceDataDO.getSourceKey());
        assertEquals(authorizerAccessTokenTime, gasMerchantSourceDataDO.getAuthorizerAccessTokenTime());
        assertEquals(authorizerAccessToken, gasMerchantSourceDataDO.getAuthorizerAccessToken());
        assertEquals(authorized, gasMerchantSourceDataDO.getAuthorized());
        assertEquals(authorizerRefreshToken, gasMerchantSourceDataDO.getAuthorizerRefreshToken());
        assertEquals(rawAddTime, gasMerchantSourceDataDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantSourceDataDO.getRawUpdateTime());
        assertEquals(sourceInfo, gasMerchantSourceDataDO.getSourceInfo());
        assertEquals(funcInfo, gasMerchantSourceDataDO.getFuncInfo());
	}

	/**
	 * 断言gas_merchant_source_data表数据
	 */
	public void assertGasMerchantSourceData(GasMerchantSourceDataDO expect, GasMerchantSourceDataDO gasMerchantSourceDataDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantSourceDataDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantSourceDataDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantSourceDataDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantSourceDataDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantSourceDataDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantSourceDataDO);
	}

    /**
	 * 插入gas_merchant_source_data表数据
	 */
	public void insertGasMerchantSourceData(GasMerchantSourceDataDO gasMerchantSourceDataDO) {
		gasMerchantSourceDataDAO.insert(gasMerchantSourceDataDO);
	}

    /**
	 * 插入gas_merchant_source_data表数据
	 */
	public void insertGasMerchantSourceData(
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String sourceType, 
			String sourceKey, 
			Date authorizerAccessTokenTime, 
			String authorizerAccessToken, 
			Byte authorized, 
			String authorizerRefreshToken, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String sourceInfo, 
			String funcInfo
	) {
		if (authorizerAccessTokenTime == null) {
			authorizerAccessTokenTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantSourceDataDO gasMerchantSourceDataDO = new GasMerchantSourceDataDO();
		gasMerchantSourceDataDO.setId(id);
		gasMerchantSourceDataDO.setPartnerId(partnerId);
		gasMerchantSourceDataDO.setPlatPartnerId(platPartnerId);
		gasMerchantSourceDataDO.setSourceType(sourceType);
		gasMerchantSourceDataDO.setSourceKey(sourceKey);
		gasMerchantSourceDataDO.setAuthorizerAccessTokenTime(authorizerAccessTokenTime);
		gasMerchantSourceDataDO.setAuthorizerAccessToken(authorizerAccessToken);
		gasMerchantSourceDataDO.setAuthorized(authorized);
		gasMerchantSourceDataDO.setAuthorizerRefreshToken(authorizerRefreshToken);
		gasMerchantSourceDataDO.setRawAddTime(rawAddTime);
		gasMerchantSourceDataDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantSourceDataDO.setSourceInfo(sourceInfo);
		gasMerchantSourceDataDO.setFuncInfo(funcInfo);
		gasMerchantSourceDataDAO.insert(gasMerchantSourceDataDO);
	}

    /**
     * 删除gas_merchant_source_data表所有数据
     */
    public void cleanGasMerchantSourceData() {
        GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
        exam.createCriteria();
        gasMerchantSourceDataDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_source_data表数据
	 */
	public void cleanGasMerchantSourceDataById(Long id) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantSourceDataDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_source_data表数据
	 */
	public void cleanGasMerchantSourceDataByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantSourceDataDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_source_data表数据
	 */
	public void cleanGasMerchantSourceDataByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantSourceDataDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_source_data表所有数据
     */
    public List<GasMerchantSourceDataDO> findGasMerchantSourceDataAll() {
        GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
        exam.createCriteria();
		return gasMerchantSourceDataDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_source_data表数据
	 */
	public List<GasMerchantSourceDataDO> findGasMerchantSourceDataById(Long id) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantSourceDataDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_source_data表数据
	 */
	public List<GasMerchantSourceDataDO> findGasMerchantSourceDataByPartnerId(String partnerId) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantSourceDataDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_source_data表数据
	 */
	public List<GasMerchantSourceDataDO> findGasMerchantSourceDataByPlatPartnerId(String platPartnerId) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantSourceDataDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_source_data表数据
	 */
	public void updateGasMerchantSourceDataById(Long id,GasMerchantSourceDataDO gasMerchantSourceDataDO) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantSourceDataDAO.updateByExample(gasMerchantSourceDataDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_source_data表数据
	 */
	public void updateGasMerchantSourceDataByPartnerId(String partnerId,GasMerchantSourceDataDO gasMerchantSourceDataDO) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantSourceDataDAO.updateByExample(gasMerchantSourceDataDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_source_data表数据
	 */
	public void updateGasMerchantSourceDataByPlatPartnerId(String platPartnerId,GasMerchantSourceDataDO gasMerchantSourceDataDO) {
		GasMerchantSourceDataDOExample exam = new GasMerchantSourceDataDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantSourceDataDAO.updateByExample(gasMerchantSourceDataDO, exam);
	}

    /**
	 * 断言gas_merchant_station表
	 */
	public void gasMerchantStationAssert(
	        GasMerchantStationDO gasMerchantStationDO,
			Long id, 
			String stationId, 
			String partnerId, 
			String platPartnerId, 
			String stationName, 
			String stationCode, 
			String phoneNo, 
			String status, 
			Byte connectOilMachine, 
			Long provinceId, 
			Long cityId, 
			Long districtId, 
			String stationAddress, 
			Double longitude, 
			Double latitude, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantStationDO.getId());
        assertEquals(stationId, gasMerchantStationDO.getStationId());
        assertEquals(partnerId, gasMerchantStationDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantStationDO.getPlatPartnerId());
        assertEquals(stationName, gasMerchantStationDO.getStationName());
        assertEquals(stationCode, gasMerchantStationDO.getStationCode());
        assertEquals(phoneNo, gasMerchantStationDO.getPhoneNo());
        assertEquals(status, gasMerchantStationDO.getStatus());
        assertEquals(connectOilMachine, gasMerchantStationDO.getConnectOilMachine());
        assertEquals(provinceId, gasMerchantStationDO.getProvinceId());
        assertEquals(cityId, gasMerchantStationDO.getCityId());
        assertEquals(districtId, gasMerchantStationDO.getDistrictId());
        assertEquals(stationAddress, gasMerchantStationDO.getStationAddress());
        assertEquals(longitude, gasMerchantStationDO.getLongitude());
        assertEquals(latitude, gasMerchantStationDO.getLatitude());
        assertEquals(rawAddTime, gasMerchantStationDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantStationDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_station表数据
	 */
	public void assertGasMerchantStation(GasMerchantStationDO expect, GasMerchantStationDO gasMerchantStationDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantStationDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantStationDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantStationDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantStationDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantStationDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantStationDO);
	}

    /**
	 * 插入gas_merchant_station表数据
	 */
	public void insertGasMerchantStation(GasMerchantStationDO gasMerchantStationDO) {
		gasMerchantStationDAO.insert(gasMerchantStationDO);
	}

    /**
	 * 插入gas_merchant_station表数据
	 */
	public void insertGasMerchantStation(
			Long id, 
			String stationId, 
			String partnerId, 
			String platPartnerId, 
			String stationName, 
			String stationCode, 
			String phoneNo, 
			String status, 
			Byte connectOilMachine, 
			Long provinceId, 
			Long cityId, 
			Long districtId, 
			String stationAddress, 
			Double longitude, 
			Double latitude, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantStationDO gasMerchantStationDO = new GasMerchantStationDO();
		gasMerchantStationDO.setId(id);
		gasMerchantStationDO.setStationId(stationId);
		gasMerchantStationDO.setPartnerId(partnerId);
		gasMerchantStationDO.setPlatPartnerId(platPartnerId);
		gasMerchantStationDO.setStationName(stationName);
		gasMerchantStationDO.setStationCode(stationCode);
		gasMerchantStationDO.setPhoneNo(phoneNo);
		gasMerchantStationDO.setStatus(status);
		gasMerchantStationDO.setConnectOilMachine(connectOilMachine);
		gasMerchantStationDO.setProvinceId(provinceId);
		gasMerchantStationDO.setCityId(cityId);
		gasMerchantStationDO.setDistrictId(districtId);
		gasMerchantStationDO.setStationAddress(stationAddress);
		gasMerchantStationDO.setLongitude(longitude);
		gasMerchantStationDO.setLatitude(latitude);
		gasMerchantStationDO.setRawAddTime(rawAddTime);
		gasMerchantStationDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantStationDAO.insert(gasMerchantStationDO);
	}

    /**
     * 删除gas_merchant_station表所有数据
     */
    public void cleanGasMerchantStation() {
        GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
        exam.createCriteria();
        gasMerchantStationDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationById(Long id) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	* 根据stationName删除gas_merchant_station表数据
	*/
	public void cleanGasMerchantStationByStationName(String stationName) {
        if (StringUtils.isBlank(stationName)){
            stationName = "test_stationName";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	* 根据stationCode删除gas_merchant_station表数据
	*/
	public void cleanGasMerchantStationByStationCode(String stationCode) {
        if (StringUtils.isBlank(stationCode)){
            stationCode = "test_stationCode";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据phoneNo删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByPhoneNo(String phoneNo) {
        if (StringUtils.isBlank(phoneNo)){
            phoneNo = "test_phoneNo";
        }
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPhoneNoEqualTo(phoneNo);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据provinceId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByProvinceId(Long provinceId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据cityId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByCityId(Long cityId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据districtId删除gas_merchant_station表数据
	 */
	public void cleanGasMerchantStationByDistrictId(Long districtId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andDistrictIdEqualTo(districtId);
		gasMerchantStationDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_station表所有数据
     */
    public List<GasMerchantStationDO> findGasMerchantStationAll() {
        GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
        exam.createCriteria();
		return gasMerchantStationDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationById(Long id) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByStationId(String stationId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByPartnerId(String partnerId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByPlatPartnerId(String platPartnerId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

	/**
	* 根据stationName查询gas_merchant_station表数据
	*/
	public List<GasMerchantStationDO> findGasMerchantStationByStationName(String stationName) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		return gasMerchantStationDAO.selectByExample(exam);
	}

	/**
	* 根据stationCode查询gas_merchant_station表数据
	*/
	public List<GasMerchantStationDO> findGasMerchantStationByStationCode(String stationCode) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据phoneNo查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByPhoneNo(String phoneNo) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPhoneNoEqualTo(phoneNo);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据provinceId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByProvinceId(Long provinceId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据cityId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByCityId(Long cityId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据districtId查询gas_merchant_station表数据
	 */
	public List<GasMerchantStationDO> findGasMerchantStationByDistrictId(Long districtId) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andDistrictIdEqualTo(districtId);
		return gasMerchantStationDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationById(Long id,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据stationId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByStationId(String stationId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByPartnerId(String partnerId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByPlatPartnerId(String platPartnerId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

	/**
	* 根据stationName更新gas_merchant_station表数据
	*/
	public void updateGasMerchantStationByStationName(String stationName,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationNameEqualTo(stationName);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

	/**
	* 根据stationCode更新gas_merchant_station表数据
	*/
	public void updateGasMerchantStationByStationCode(String stationCode,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andStationCodeEqualTo(stationCode);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据phoneNo更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByPhoneNo(String phoneNo,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andPhoneNoEqualTo(phoneNo);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据provinceId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByProvinceId(Long provinceId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andProvinceIdEqualTo(provinceId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据cityId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByCityId(Long cityId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andCityIdEqualTo(cityId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 根据districtId更新gas_merchant_station表数据
	 */
	public void updateGasMerchantStationByDistrictId(Long districtId,GasMerchantStationDO gasMerchantStationDO) {
		GasMerchantStationDOExample exam = new GasMerchantStationDOExample();
		exam.createCriteria().andDistrictIdEqualTo(districtId);
		gasMerchantStationDAO.updateByExample(gasMerchantStationDO, exam);
	}

    /**
	 * 断言gas_merchant_user表
	 */
	public void gasMerchantUserAssert(
	        GasMerchantUserDO gasMerchantUserDO,
			Long id, 
			String userId, 
			Long roleId, 
			String userType, 
			String partnerId, 
			String platPartnerId, 
			String userName, 
			String mobileNo, 
			String account, 
			String password, 
			String salt, 
			String status, 
			String uqKey, 
			Integer loginErrorCount, 
			Integer loginErrorLimit, 
			Date lastLoginTime, 
			Date lastLoginSuccessTime, 
			Date lastLogoutSuccessTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasMerchantUserDO.getId());
        assertEquals(userId, gasMerchantUserDO.getUserId());
        assertEquals(roleId, gasMerchantUserDO.getRoleId());
        assertEquals(userType, gasMerchantUserDO.getUserType());
        assertEquals(partnerId, gasMerchantUserDO.getPartnerId());
        assertEquals(platPartnerId, gasMerchantUserDO.getPlatPartnerId());
        assertEquals(userName, gasMerchantUserDO.getUserName());
        assertEquals(mobileNo, gasMerchantUserDO.getMobileNo());
        assertEquals(account, gasMerchantUserDO.getAccount());
        assertEquals(password, gasMerchantUserDO.getPassword());
        assertEquals(salt, gasMerchantUserDO.getSalt());
        assertEquals(status, gasMerchantUserDO.getStatus());
        assertEquals(uqKey, gasMerchantUserDO.getUqKey());
        assertEquals(loginErrorCount, gasMerchantUserDO.getLoginErrorCount());
        assertEquals(loginErrorLimit, gasMerchantUserDO.getLoginErrorLimit());
        assertEquals(lastLoginTime, gasMerchantUserDO.getLastLoginTime());
        assertEquals(lastLoginSuccessTime, gasMerchantUserDO.getLastLoginSuccessTime());
        assertEquals(lastLogoutSuccessTime, gasMerchantUserDO.getLastLogoutSuccessTime());
        assertEquals(rawAddTime, gasMerchantUserDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasMerchantUserDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_merchant_user表数据
	 */
	public void assertGasMerchantUser(GasMerchantUserDO expect, GasMerchantUserDO gasMerchantUserDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantUserDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasMerchantUserDO.getRawAddTime());
		expect.setRawAddTime(gasMerchantUserDO.getRawAddTime());
        Assertions.assertTrue(null != gasMerchantUserDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasMerchantUserDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasMerchantUserDO);
	}

    /**
	 * 插入gas_merchant_user表数据
	 */
	public void insertGasMerchantUser(GasMerchantUserDO gasMerchantUserDO) {
		gasMerchantUserDAO.insert(gasMerchantUserDO);
	}

    /**
	 * 插入gas_merchant_user表数据
	 */
	public void insertGasMerchantUser(
			Long id, 
			String userId, 
			Long roleId, 
			String userType, 
			String partnerId, 
			String platPartnerId, 
			String userName, 
			String mobileNo, 
			String account, 
			String password, 
			String salt, 
			String status, 
			String uqKey, 
			Integer loginErrorCount, 
			Integer loginErrorLimit, 
			Date lastLoginTime, 
			Date lastLoginSuccessTime, 
			Date lastLogoutSuccessTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (lastLoginTime == null) {
			lastLoginTime = new Date();
		}
		if (lastLoginSuccessTime == null) {
			lastLoginSuccessTime = new Date();
		}
		if (lastLogoutSuccessTime == null) {
			lastLogoutSuccessTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasMerchantUserDO gasMerchantUserDO = new GasMerchantUserDO();
		gasMerchantUserDO.setId(id);
		gasMerchantUserDO.setUserId(userId);
		gasMerchantUserDO.setRoleId(roleId);
		gasMerchantUserDO.setUserType(userType);
		gasMerchantUserDO.setPartnerId(partnerId);
		gasMerchantUserDO.setPlatPartnerId(platPartnerId);
		gasMerchantUserDO.setUserName(userName);
		gasMerchantUserDO.setMobileNo(mobileNo);
		gasMerchantUserDO.setAccount(account);
		gasMerchantUserDO.setPassword(password);
		gasMerchantUserDO.setSalt(salt);
		gasMerchantUserDO.setStatus(status);
		gasMerchantUserDO.setUqKey(uqKey);
		gasMerchantUserDO.setLoginErrorCount(loginErrorCount);
		gasMerchantUserDO.setLoginErrorLimit(loginErrorLimit);
		gasMerchantUserDO.setLastLoginTime(lastLoginTime);
		gasMerchantUserDO.setLastLoginSuccessTime(lastLoginSuccessTime);
		gasMerchantUserDO.setLastLogoutSuccessTime(lastLogoutSuccessTime);
		gasMerchantUserDO.setRawAddTime(rawAddTime);
		gasMerchantUserDO.setRawUpdateTime(rawUpdateTime);
		gasMerchantUserDAO.insert(gasMerchantUserDO);
	}

    /**
     * 删除gas_merchant_user表所有数据
     */
    public void cleanGasMerchantUser() {
        GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
        exam.createCriteria();
        gasMerchantUserDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_user表数据
	 */
	public void cleanGasMerchantUserById(Long id) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_merchant_user表数据
	 */
	public void cleanGasMerchantUserByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据roleId删除gas_merchant_user表数据
	 */
	public void cleanGasMerchantUserByRoleId(Long roleId) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_merchant_user表数据
	 */
	public void cleanGasMerchantUserByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_merchant_user表数据
	 */
	public void cleanGasMerchantUserByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantUserDAO.deleteByExample(exam);
	}

	/**
	* 根据userName删除gas_merchant_user表数据
	*/
	public void cleanGasMerchantUserByUserName(String userName) {
        if (StringUtils.isBlank(userName)){
            userName = "test_userName";
        }
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		gasMerchantUserDAO.deleteByExample(exam);
	}

	/**
	 * 根据mobileNo删除gas_merchant_user表数据
	 */
	public void cleanGasMerchantUserByMobileNo(String mobileNo) {
        if (StringUtils.isBlank(mobileNo)){
            mobileNo = "test_mobileNo";
        }
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		gasMerchantUserDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_user表所有数据
     */
    public List<GasMerchantUserDO> findGasMerchantUserAll() {
        GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
        exam.createCriteria();
		return gasMerchantUserDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserById(Long id) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantUserDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserByUserId(String userId) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasMerchantUserDAO.selectByExample(exam);
	}

    /**
	 * 根据roleId查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserByRoleId(Long roleId) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		return gasMerchantUserDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserByPartnerId(String partnerId) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasMerchantUserDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserByPlatPartnerId(String platPartnerId) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasMerchantUserDAO.selectByExample(exam);
	}

	/**
	* 根据userName查询gas_merchant_user表数据
	*/
	public List<GasMerchantUserDO> findGasMerchantUserByUserName(String userName) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		return gasMerchantUserDAO.selectByExample(exam);
	}

    /**
	 * 根据mobileNo查询gas_merchant_user表数据
	 */
	public List<GasMerchantUserDO> findGasMerchantUserByMobileNo(String mobileNo) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		return gasMerchantUserDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserById(Long id,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

    /**
	 * 根据userId更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserByUserId(String userId,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

    /**
	 * 根据roleId更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserByRoleId(Long roleId,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andRoleIdEqualTo(roleId);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

    /**
	 * 根据partnerId更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserByPartnerId(String partnerId,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserByPlatPartnerId(String platPartnerId,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

	/**
	* 根据userName更新gas_merchant_user表数据
	*/
	public void updateGasMerchantUserByUserName(String userName,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andUserNameEqualTo(userName);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

    /**
	 * 根据mobileNo更新gas_merchant_user表数据
	 */
	public void updateGasMerchantUserByMobileNo(String mobileNo,GasMerchantUserDO gasMerchantUserDO) {
		GasMerchantUserDOExample exam = new GasMerchantUserDOExample();
		exam.createCriteria().andMobileNoEqualTo(mobileNo);
		gasMerchantUserDAO.updateByExample(gasMerchantUserDO, exam);
	}

    /**
	 * 断言gas_merchant_user_station表
	 */
	public void gasMerchantUserStationAssert(
	        GasMerchantUserStationDO gasMerchantUserStationDO,
			Long id, 
			String userId, 
			String stationId
	) {
        assertEquals(id, gasMerchantUserStationDO.getId());
        assertEquals(userId, gasMerchantUserStationDO.getUserId());
        assertEquals(stationId, gasMerchantUserStationDO.getStationId());
	}

	/**
	 * 断言gas_merchant_user_station表数据
	 */
	public void assertGasMerchantUserStation(GasMerchantUserStationDO expect, GasMerchantUserStationDO gasMerchantUserStationDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasMerchantUserStationDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasMerchantUserStationDO);
	}

    /**
	 * 插入gas_merchant_user_station表数据
	 */
	public void insertGasMerchantUserStation(GasMerchantUserStationDO gasMerchantUserStationDO) {
		gasMerchantUserStationDAO.insert(gasMerchantUserStationDO);
	}

    /**
	 * 插入gas_merchant_user_station表数据
	 */
	public void insertGasMerchantUserStation(
			Long id, 
			String userId, 
			String stationId
	) {
		GasMerchantUserStationDO gasMerchantUserStationDO = new GasMerchantUserStationDO();
		gasMerchantUserStationDO.setId(id);
		gasMerchantUserStationDO.setUserId(userId);
		gasMerchantUserStationDO.setStationId(stationId);
		gasMerchantUserStationDAO.insert(gasMerchantUserStationDO);
	}

    /**
     * 删除gas_merchant_user_station表所有数据
     */
    public void cleanGasMerchantUserStation() {
        GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
        exam.createCriteria();
        gasMerchantUserStationDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_merchant_user_station表数据
	 */
	public void cleanGasMerchantUserStationById(Long id) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantUserStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除gas_merchant_user_station表数据
	 */
	public void cleanGasMerchantUserStationByUserId(String userId) {
        if (StringUtils.isBlank(userId)){
            userId = "test_userId";
        }
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantUserStationDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_merchant_user_station表数据
	 */
	public void cleanGasMerchantUserStationByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantUserStationDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_merchant_user_station表所有数据
     */
    public List<GasMerchantUserStationDO> findGasMerchantUserStationAll() {
        GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
        exam.createCriteria();
		return gasMerchantUserStationDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_merchant_user_station表数据
	 */
	public List<GasMerchantUserStationDO> findGasMerchantUserStationById(Long id) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasMerchantUserStationDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询gas_merchant_user_station表数据
	 */
	public List<GasMerchantUserStationDO> findGasMerchantUserStationByUserId(String userId) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return gasMerchantUserStationDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_merchant_user_station表数据
	 */
	public List<GasMerchantUserStationDO> findGasMerchantUserStationByStationId(String stationId) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasMerchantUserStationDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_merchant_user_station表数据
	 */
	public void updateGasMerchantUserStationById(Long id,GasMerchantUserStationDO gasMerchantUserStationDO) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasMerchantUserStationDAO.updateByExample(gasMerchantUserStationDO, exam);
	}

    /**
	 * 根据userId更新gas_merchant_user_station表数据
	 */
	public void updateGasMerchantUserStationByUserId(String userId,GasMerchantUserStationDO gasMerchantUserStationDO) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		gasMerchantUserStationDAO.updateByExample(gasMerchantUserStationDO, exam);
	}

    /**
	 * 根据stationId更新gas_merchant_user_station表数据
	 */
	public void updateGasMerchantUserStationByStationId(String stationId,GasMerchantUserStationDO gasMerchantUserStationDO) {
		GasMerchantUserStationDOExample exam = new GasMerchantUserStationDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasMerchantUserStationDAO.updateByExample(gasMerchantUserStationDO, exam);
	}

    /**
	 * 断言gas_oil_station_description表
	 */
	public void gasOilStationDescriptionAssert(
	        GasOilStationDescriptionDO gasOilStationDescriptionDO,
			Integer id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String type, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String description
	) {
        assertEquals(id, gasOilStationDescriptionDO.getId());
        assertEquals(partnerId, gasOilStationDescriptionDO.getPartnerId());
        assertEquals(platPartnerId, gasOilStationDescriptionDO.getPlatPartnerId());
        assertEquals(stationId, gasOilStationDescriptionDO.getStationId());
        assertEquals(type, gasOilStationDescriptionDO.getType());
        assertEquals(rawAddTime, gasOilStationDescriptionDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasOilStationDescriptionDO.getRawUpdateTime());
        assertEquals(description, gasOilStationDescriptionDO.getDescription());
	}

	/**
	 * 断言gas_oil_station_description表数据
	 */
	public void assertGasOilStationDescription(GasOilStationDescriptionDO expect, GasOilStationDescriptionDO gasOilStationDescriptionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasOilStationDescriptionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasOilStationDescriptionDO.getRawAddTime());
		expect.setRawAddTime(gasOilStationDescriptionDO.getRawAddTime());
        Assertions.assertTrue(null != gasOilStationDescriptionDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasOilStationDescriptionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasOilStationDescriptionDO);
	}

    /**
	 * 插入gas_oil_station_description表数据
	 */
	public void insertGasOilStationDescription(GasOilStationDescriptionDO gasOilStationDescriptionDO) {
		gasOilStationDescriptionDAO.insert(gasOilStationDescriptionDO);
	}

    /**
	 * 插入gas_oil_station_description表数据
	 */
	public void insertGasOilStationDescription(
			Integer id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String type, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String description
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasOilStationDescriptionDO gasOilStationDescriptionDO = new GasOilStationDescriptionDO();
		gasOilStationDescriptionDO.setId(id);
		gasOilStationDescriptionDO.setPartnerId(partnerId);
		gasOilStationDescriptionDO.setPlatPartnerId(platPartnerId);
		gasOilStationDescriptionDO.setStationId(stationId);
		gasOilStationDescriptionDO.setType(type);
		gasOilStationDescriptionDO.setRawAddTime(rawAddTime);
		gasOilStationDescriptionDO.setRawUpdateTime(rawUpdateTime);
		gasOilStationDescriptionDO.setDescription(description);
		gasOilStationDescriptionDAO.insert(gasOilStationDescriptionDO);
	}

    /**
     * 删除gas_oil_station_description表所有数据
     */
    public void cleanGasOilStationDescription() {
        GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
        exam.createCriteria();
        gasOilStationDescriptionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_oil_station_description表数据
	 */
	public void cleanGasOilStationDescriptionById(Integer id) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasOilStationDescriptionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_oil_station_description表数据
	 */
	public void cleanGasOilStationDescriptionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasOilStationDescriptionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_oil_station_description表数据
	 */
	public void cleanGasOilStationDescriptionByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasOilStationDescriptionDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_oil_station_description表数据
	 */
	public void cleanGasOilStationDescriptionByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasOilStationDescriptionDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_oil_station_description表所有数据
     */
    public List<GasOilStationDescriptionDO> findGasOilStationDescriptionAll() {
        GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
        exam.createCriteria();
		return gasOilStationDescriptionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_oil_station_description表数据
	 */
	public List<GasOilStationDescriptionDO> findGasOilStationDescriptionById(Integer id) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasOilStationDescriptionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_oil_station_description表数据
	 */
	public List<GasOilStationDescriptionDO> findGasOilStationDescriptionByPartnerId(String partnerId) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasOilStationDescriptionDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_oil_station_description表数据
	 */
	public List<GasOilStationDescriptionDO> findGasOilStationDescriptionByPlatPartnerId(String platPartnerId) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasOilStationDescriptionDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_oil_station_description表数据
	 */
	public List<GasOilStationDescriptionDO> findGasOilStationDescriptionByStationId(String stationId) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasOilStationDescriptionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_oil_station_description表数据
	 */
	public void updateGasOilStationDescriptionById(Integer id,GasOilStationDescriptionDO gasOilStationDescriptionDO) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasOilStationDescriptionDAO.updateByExample(gasOilStationDescriptionDO, exam);
	}

    /**
	 * 根据partnerId更新gas_oil_station_description表数据
	 */
	public void updateGasOilStationDescriptionByPartnerId(String partnerId,GasOilStationDescriptionDO gasOilStationDescriptionDO) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasOilStationDescriptionDAO.updateByExample(gasOilStationDescriptionDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_oil_station_description表数据
	 */
	public void updateGasOilStationDescriptionByPlatPartnerId(String platPartnerId,GasOilStationDescriptionDO gasOilStationDescriptionDO) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasOilStationDescriptionDAO.updateByExample(gasOilStationDescriptionDO, exam);
	}

    /**
	 * 根据stationId更新gas_oil_station_description表数据
	 */
	public void updateGasOilStationDescriptionByStationId(String stationId,GasOilStationDescriptionDO gasOilStationDescriptionDO) {
		GasOilStationDescriptionDOExample exam = new GasOilStationDescriptionDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasOilStationDescriptionDAO.updateByExample(gasOilStationDescriptionDO, exam);
	}

    /**
	 * 断言gas_partner_mapping表
	 */
	public void gasPartnerMappingAssert(
	        GasPartnerMappingDO gasPartnerMappingDO,
			Integer id, 
			String type, 
			String platPartnerId, 
			String partnerId
	) {
        assertEquals(id, gasPartnerMappingDO.getId());
        assertEquals(type, gasPartnerMappingDO.getType());
        assertEquals(platPartnerId, gasPartnerMappingDO.getPlatPartnerId());
        assertEquals(partnerId, gasPartnerMappingDO.getPartnerId());
	}

	/**
	 * 断言gas_partner_mapping表数据
	 */
	public void assertGasPartnerMapping(GasPartnerMappingDO expect, GasPartnerMappingDO gasPartnerMappingDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasPartnerMappingDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasPartnerMappingDO);
	}

    /**
	 * 插入gas_partner_mapping表数据
	 */
	public void insertGasPartnerMapping(GasPartnerMappingDO gasPartnerMappingDO) {
		gasPartnerMappingDAO.insert(gasPartnerMappingDO);
	}

    /**
	 * 插入gas_partner_mapping表数据
	 */
	public void insertGasPartnerMapping(
			Integer id, 
			String type, 
			String platPartnerId, 
			String partnerId
	) {
		GasPartnerMappingDO gasPartnerMappingDO = new GasPartnerMappingDO();
		gasPartnerMappingDO.setId(id);
		gasPartnerMappingDO.setType(type);
		gasPartnerMappingDO.setPlatPartnerId(platPartnerId);
		gasPartnerMappingDO.setPartnerId(partnerId);
		gasPartnerMappingDAO.insert(gasPartnerMappingDO);
	}

    /**
     * 删除gas_partner_mapping表所有数据
     */
    public void cleanGasPartnerMapping() {
        GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
        exam.createCriteria();
        gasPartnerMappingDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_partner_mapping表数据
	 */
	public void cleanGasPartnerMappingById(Integer id) {
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasPartnerMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_partner_mapping表数据
	 */
	public void cleanGasPartnerMappingByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasPartnerMappingDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_partner_mapping表数据
	 */
	public void cleanGasPartnerMappingByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasPartnerMappingDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_partner_mapping表所有数据
     */
    public List<GasPartnerMappingDO> findGasPartnerMappingAll() {
        GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
        exam.createCriteria();
		return gasPartnerMappingDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_partner_mapping表数据
	 */
	public List<GasPartnerMappingDO> findGasPartnerMappingById(Integer id) {
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasPartnerMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_partner_mapping表数据
	 */
	public List<GasPartnerMappingDO> findGasPartnerMappingByPlatPartnerId(String platPartnerId) {
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasPartnerMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_partner_mapping表数据
	 */
	public List<GasPartnerMappingDO> findGasPartnerMappingByPartnerId(String partnerId) {
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasPartnerMappingDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_partner_mapping表数据
	 */
	public void updateGasPartnerMappingById(Integer id,GasPartnerMappingDO gasPartnerMappingDO) {
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasPartnerMappingDAO.updateByExample(gasPartnerMappingDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_partner_mapping表数据
	 */
	public void updateGasPartnerMappingByPlatPartnerId(String platPartnerId,GasPartnerMappingDO gasPartnerMappingDO) {
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasPartnerMappingDAO.updateByExample(gasPartnerMappingDO, exam);
	}

    /**
	 * 根据partnerId更新gas_partner_mapping表数据
	 */
	public void updateGasPartnerMappingByPartnerId(String partnerId,GasPartnerMappingDO gasPartnerMappingDO) {
		GasPartnerMappingDOExample exam = new GasPartnerMappingDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasPartnerMappingDAO.updateByExample(gasPartnerMappingDO, exam);
	}

    /**
	 * 断言gas_province表
	 */
	public void gasProvinceAssert(
	        GasProvinceDO gasProvinceDO,
			Long id, 
			String provinceName, 
			String provinceShort, 
			String provinceChar
	) {
        assertEquals(id, gasProvinceDO.getId());
        assertEquals(provinceName, gasProvinceDO.getProvinceName());
        assertEquals(provinceShort, gasProvinceDO.getProvinceShort());
        assertEquals(provinceChar, gasProvinceDO.getProvinceChar());
	}

	/**
	 * 断言gas_province表数据
	 */
	public void assertGasProvince(GasProvinceDO expect, GasProvinceDO gasProvinceDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasProvinceDO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, gasProvinceDO);
	}

    /**
	 * 插入gas_province表数据
	 */
	public void insertGasProvince(GasProvinceDO gasProvinceDO) {
		gasProvinceDAO.insert(gasProvinceDO);
	}

    /**
	 * 插入gas_province表数据
	 */
	public void insertGasProvince(
			Long id, 
			String provinceName, 
			String provinceShort, 
			String provinceChar
	) {
		GasProvinceDO gasProvinceDO = new GasProvinceDO();
		gasProvinceDO.setId(id);
		gasProvinceDO.setProvinceName(provinceName);
		gasProvinceDO.setProvinceShort(provinceShort);
		gasProvinceDO.setProvinceChar(provinceChar);
		gasProvinceDAO.insert(gasProvinceDO);
	}

    /**
     * 删除gas_province表所有数据
     */
    public void cleanGasProvince() {
        GasProvinceDOExample exam = new GasProvinceDOExample();
        exam.createCriteria();
        gasProvinceDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_province表数据
	 */
	public void cleanGasProvinceById(Long id) {
		GasProvinceDOExample exam = new GasProvinceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasProvinceDAO.deleteByExample(exam);
	}

	/**
	* 根据provinceName删除gas_province表数据
	*/
	public void cleanGasProvinceByProvinceName(String provinceName) {
        if (StringUtils.isBlank(provinceName)){
            provinceName = "test_provinceName";
        }
		GasProvinceDOExample exam = new GasProvinceDOExample();
		exam.createCriteria().andProvinceNameEqualTo(provinceName);
		gasProvinceDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_province表所有数据
     */
    public List<GasProvinceDO> findGasProvinceAll() {
        GasProvinceDOExample exam = new GasProvinceDOExample();
        exam.createCriteria();
		return gasProvinceDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_province表数据
	 */
	public List<GasProvinceDO> findGasProvinceById(Long id) {
		GasProvinceDOExample exam = new GasProvinceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasProvinceDAO.selectByExample(exam);
	}

	/**
	* 根据provinceName查询gas_province表数据
	*/
	public List<GasProvinceDO> findGasProvinceByProvinceName(String provinceName) {
		GasProvinceDOExample exam = new GasProvinceDOExample();
		exam.createCriteria().andProvinceNameEqualTo(provinceName);
		return gasProvinceDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_province表数据
	 */
	public void updateGasProvinceById(Long id,GasProvinceDO gasProvinceDO) {
		GasProvinceDOExample exam = new GasProvinceDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasProvinceDAO.updateByExample(gasProvinceDO, exam);
	}

	/**
	* 根据provinceName更新gas_province表数据
	*/
	public void updateGasProvinceByProvinceName(String provinceName,GasProvinceDO gasProvinceDO) {
		GasProvinceDOExample exam = new GasProvinceDOExample();
		exam.createCriteria().andProvinceNameEqualTo(provinceName);
		gasProvinceDAO.updateByExample(gasProvinceDO, exam);
	}

    /**
	 * 断言gas_role表
	 */
	public void gasRoleAssert(
	        GasRoleDO gasRoleDO,
			Long id, 
			String roleType, 
			Long parentId, 
			String roleName, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasRoleDO.getId());
        assertEquals(roleType, gasRoleDO.getRoleType());
        assertEquals(parentId, gasRoleDO.getParentId());
        assertEquals(roleName, gasRoleDO.getRoleName());
        assertEquals(memo, gasRoleDO.getMemo());
        assertEquals(rawAddTime, gasRoleDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasRoleDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_role表数据
	 */
	public void assertGasRole(GasRoleDO expect, GasRoleDO gasRoleDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasRoleDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasRoleDO.getRawAddTime());
		expect.setRawAddTime(gasRoleDO.getRawAddTime());
        Assertions.assertTrue(null != gasRoleDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasRoleDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasRoleDO);
	}

    /**
	 * 插入gas_role表数据
	 */
	public void insertGasRole(GasRoleDO gasRoleDO) {
		gasRoleDAO.insert(gasRoleDO);
	}

    /**
	 * 插入gas_role表数据
	 */
	public void insertGasRole(
			Long id, 
			String roleType, 
			Long parentId, 
			String roleName, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasRoleDO gasRoleDO = new GasRoleDO();
		gasRoleDO.setId(id);
		gasRoleDO.setRoleType(roleType);
		gasRoleDO.setParentId(parentId);
		gasRoleDO.setRoleName(roleName);
		gasRoleDO.setMemo(memo);
		gasRoleDO.setRawAddTime(rawAddTime);
		gasRoleDO.setRawUpdateTime(rawUpdateTime);
		gasRoleDAO.insert(gasRoleDO);
	}

    /**
     * 删除gas_role表所有数据
     */
    public void cleanGasRole() {
        GasRoleDOExample exam = new GasRoleDOExample();
        exam.createCriteria();
        gasRoleDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_role表数据
	 */
	public void cleanGasRoleById(Long id) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasRoleDAO.deleteByExample(exam);
	}

	/**
	 * 根据parentId删除gas_role表数据
	 */
	public void cleanGasRoleByParentId(Long parentId) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		gasRoleDAO.deleteByExample(exam);
	}

	/**
	* 根据roleName删除gas_role表数据
	*/
	public void cleanGasRoleByRoleName(String roleName) {
        if (StringUtils.isBlank(roleName)){
            roleName = "test_roleName";
        }
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andRoleNameEqualTo(roleName);
		gasRoleDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_role表所有数据
     */
    public List<GasRoleDO> findGasRoleAll() {
        GasRoleDOExample exam = new GasRoleDOExample();
        exam.createCriteria();
		return gasRoleDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_role表数据
	 */
	public List<GasRoleDO> findGasRoleById(Long id) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据parentId查询gas_role表数据
	 */
	public List<GasRoleDO> findGasRoleByParentId(Long parentId) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		return gasRoleDAO.selectByExample(exam);
	}

	/**
	* 根据roleName查询gas_role表数据
	*/
	public List<GasRoleDO> findGasRoleByRoleName(String roleName) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andRoleNameEqualTo(roleName);
		return gasRoleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_role表数据
	 */
	public void updateGasRoleById(Long id,GasRoleDO gasRoleDO) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasRoleDAO.updateByExample(gasRoleDO, exam);
	}

    /**
	 * 根据parentId更新gas_role表数据
	 */
	public void updateGasRoleByParentId(Long parentId,GasRoleDO gasRoleDO) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andParentIdEqualTo(parentId);
		gasRoleDAO.updateByExample(gasRoleDO, exam);
	}

	/**
	* 根据roleName更新gas_role表数据
	*/
	public void updateGasRoleByRoleName(String roleName,GasRoleDO gasRoleDO) {
		GasRoleDOExample exam = new GasRoleDOExample();
		exam.createCriteria().andRoleNameEqualTo(roleName);
		gasRoleDAO.updateByExample(gasRoleDO, exam);
	}

    /**
	 * 断言gas_rule_description表
	 */
	public void gasRuleDescriptionAssert(
	        GasRuleDescriptionDO gasRuleDescriptionDO,
			Integer id, 
			String partnerId, 
			String platPartnerId, 
			String ruleType, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String description
	) {
        assertEquals(id, gasRuleDescriptionDO.getId());
        assertEquals(partnerId, gasRuleDescriptionDO.getPartnerId());
        assertEquals(platPartnerId, gasRuleDescriptionDO.getPlatPartnerId());
        assertEquals(ruleType, gasRuleDescriptionDO.getRuleType());
        assertEquals(rawAddTime, gasRuleDescriptionDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasRuleDescriptionDO.getRawUpdateTime());
        assertEquals(description, gasRuleDescriptionDO.getDescription());
	}

	/**
	 * 断言gas_rule_description表数据
	 */
	public void assertGasRuleDescription(GasRuleDescriptionDO expect, GasRuleDescriptionDO gasRuleDescriptionDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasRuleDescriptionDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasRuleDescriptionDO.getRawAddTime());
		expect.setRawAddTime(gasRuleDescriptionDO.getRawAddTime());
        Assertions.assertTrue(null != gasRuleDescriptionDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasRuleDescriptionDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasRuleDescriptionDO);
	}

    /**
	 * 插入gas_rule_description表数据
	 */
	public void insertGasRuleDescription(GasRuleDescriptionDO gasRuleDescriptionDO) {
		gasRuleDescriptionDAO.insert(gasRuleDescriptionDO);
	}

    /**
	 * 插入gas_rule_description表数据
	 */
	public void insertGasRuleDescription(
			Integer id, 
			String partnerId, 
			String platPartnerId, 
			String ruleType, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String description
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasRuleDescriptionDO gasRuleDescriptionDO = new GasRuleDescriptionDO();
		gasRuleDescriptionDO.setId(id);
		gasRuleDescriptionDO.setPartnerId(partnerId);
		gasRuleDescriptionDO.setPlatPartnerId(platPartnerId);
		gasRuleDescriptionDO.setRuleType(ruleType);
		gasRuleDescriptionDO.setRawAddTime(rawAddTime);
		gasRuleDescriptionDO.setRawUpdateTime(rawUpdateTime);
		gasRuleDescriptionDO.setDescription(description);
		gasRuleDescriptionDAO.insert(gasRuleDescriptionDO);
	}

    /**
     * 删除gas_rule_description表所有数据
     */
    public void cleanGasRuleDescription() {
        GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
        exam.createCriteria();
        gasRuleDescriptionDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_rule_description表数据
	 */
	public void cleanGasRuleDescriptionById(Integer id) {
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasRuleDescriptionDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_rule_description表数据
	 */
	public void cleanGasRuleDescriptionByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasRuleDescriptionDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_rule_description表数据
	 */
	public void cleanGasRuleDescriptionByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasRuleDescriptionDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_rule_description表所有数据
     */
    public List<GasRuleDescriptionDO> findGasRuleDescriptionAll() {
        GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
        exam.createCriteria();
		return gasRuleDescriptionDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_rule_description表数据
	 */
	public List<GasRuleDescriptionDO> findGasRuleDescriptionById(Integer id) {
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasRuleDescriptionDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_rule_description表数据
	 */
	public List<GasRuleDescriptionDO> findGasRuleDescriptionByPartnerId(String partnerId) {
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasRuleDescriptionDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_rule_description表数据
	 */
	public List<GasRuleDescriptionDO> findGasRuleDescriptionByPlatPartnerId(String platPartnerId) {
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasRuleDescriptionDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_rule_description表数据
	 */
	public void updateGasRuleDescriptionById(Integer id,GasRuleDescriptionDO gasRuleDescriptionDO) {
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasRuleDescriptionDAO.updateByExample(gasRuleDescriptionDO, exam);
	}

    /**
	 * 根据partnerId更新gas_rule_description表数据
	 */
	public void updateGasRuleDescriptionByPartnerId(String partnerId,GasRuleDescriptionDO gasRuleDescriptionDO) {
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasRuleDescriptionDAO.updateByExample(gasRuleDescriptionDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_rule_description表数据
	 */
	public void updateGasRuleDescriptionByPlatPartnerId(String platPartnerId,GasRuleDescriptionDO gasRuleDescriptionDO) {
		GasRuleDescriptionDOExample exam = new GasRuleDescriptionDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasRuleDescriptionDAO.updateByExample(gasRuleDescriptionDO, exam);
	}

    /**
	 * 断言gas_station_goods表
	 */
	public void gasStationGoodsAssert(
	        GasStationGoodsDO gasStationGoodsDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String goodsName, 
			String goodsCode, 
			String goodsType, 
			Integer orderNo, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasStationGoodsDO.getId());
        assertEquals(partnerId, gasStationGoodsDO.getPartnerId());
        assertEquals(platPartnerId, gasStationGoodsDO.getPlatPartnerId());
        assertEquals(stationId, gasStationGoodsDO.getStationId());
        assertEquals(goodsName, gasStationGoodsDO.getGoodsName());
        assertEquals(goodsCode, gasStationGoodsDO.getGoodsCode());
        assertEquals(goodsType, gasStationGoodsDO.getGoodsType());
        assertEquals(orderNo, gasStationGoodsDO.getOrderNo());
        assertEquals(status, gasStationGoodsDO.getStatus());
        assertEquals(rawAddTime, gasStationGoodsDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasStationGoodsDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_station_goods表数据
	 */
	public void assertGasStationGoods(GasStationGoodsDO expect, GasStationGoodsDO gasStationGoodsDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasStationGoodsDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasStationGoodsDO.getRawAddTime());
		expect.setRawAddTime(gasStationGoodsDO.getRawAddTime());
        Assertions.assertTrue(null != gasStationGoodsDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasStationGoodsDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasStationGoodsDO);
	}

    /**
	 * 插入gas_station_goods表数据
	 */
	public void insertGasStationGoods(GasStationGoodsDO gasStationGoodsDO) {
		gasStationGoodsDAO.insert(gasStationGoodsDO);
	}

    /**
	 * 插入gas_station_goods表数据
	 */
	public void insertGasStationGoods(
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String goodsName, 
			String goodsCode, 
			String goodsType, 
			Integer orderNo, 
			String status, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasStationGoodsDO gasStationGoodsDO = new GasStationGoodsDO();
		gasStationGoodsDO.setId(id);
		gasStationGoodsDO.setPartnerId(partnerId);
		gasStationGoodsDO.setPlatPartnerId(platPartnerId);
		gasStationGoodsDO.setStationId(stationId);
		gasStationGoodsDO.setGoodsName(goodsName);
		gasStationGoodsDO.setGoodsCode(goodsCode);
		gasStationGoodsDO.setGoodsType(goodsType);
		gasStationGoodsDO.setOrderNo(orderNo);
		gasStationGoodsDO.setStatus(status);
		gasStationGoodsDO.setRawAddTime(rawAddTime);
		gasStationGoodsDO.setRawUpdateTime(rawUpdateTime);
		gasStationGoodsDAO.insert(gasStationGoodsDO);
	}

    /**
     * 删除gas_station_goods表所有数据
     */
    public void cleanGasStationGoods() {
        GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
        exam.createCriteria();
        gasStationGoodsDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_station_goods表数据
	 */
	public void cleanGasStationGoodsById(Long id) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_station_goods表数据
	 */
	public void cleanGasStationGoodsByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasStationGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_station_goods表数据
	 */
	public void cleanGasStationGoodsByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasStationGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_station_goods表数据
	 */
	public void cleanGasStationGoodsByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsName删除gas_station_goods表数据
	*/
	public void cleanGasStationGoodsByGoodsName(String goodsName) {
        if (StringUtils.isBlank(goodsName)){
            goodsName = "test_goodsName";
        }
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasStationGoodsDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsCode删除gas_station_goods表数据
	*/
	public void cleanGasStationGoodsByGoodsCode(String goodsCode) {
        if (StringUtils.isBlank(goodsCode)){
            goodsCode = "test_goodsCode";
        }
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasStationGoodsDAO.deleteByExample(exam);
	}

	/**
	 * 根据orderNo删除gas_station_goods表数据
	 */
	public void cleanGasStationGoodsByOrderNo(Integer orderNo) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasStationGoodsDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_station_goods表所有数据
     */
    public List<GasStationGoodsDO> findGasStationGoodsAll() {
        GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
        exam.createCriteria();
		return gasStationGoodsDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_station_goods表数据
	 */
	public List<GasStationGoodsDO> findGasStationGoodsById(Long id) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasStationGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_station_goods表数据
	 */
	public List<GasStationGoodsDO> findGasStationGoodsByPartnerId(String partnerId) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasStationGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_station_goods表数据
	 */
	public List<GasStationGoodsDO> findGasStationGoodsByPlatPartnerId(String platPartnerId) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasStationGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_station_goods表数据
	 */
	public List<GasStationGoodsDO> findGasStationGoodsByStationId(String stationId) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasStationGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsName查询gas_station_goods表数据
	*/
	public List<GasStationGoodsDO> findGasStationGoodsByGoodsName(String goodsName) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		return gasStationGoodsDAO.selectByExample(exam);
	}

	/**
	* 根据goodsCode查询gas_station_goods表数据
	*/
	public List<GasStationGoodsDO> findGasStationGoodsByGoodsCode(String goodsCode) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		return gasStationGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据orderNo查询gas_station_goods表数据
	 */
	public List<GasStationGoodsDO> findGasStationGoodsByOrderNo(Integer orderNo) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		return gasStationGoodsDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_station_goods表数据
	 */
	public void updateGasStationGoodsById(Long id,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

    /**
	 * 根据partnerId更新gas_station_goods表数据
	 */
	public void updateGasStationGoodsByPartnerId(String partnerId,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_station_goods表数据
	 */
	public void updateGasStationGoodsByPlatPartnerId(String platPartnerId,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

    /**
	 * 根据stationId更新gas_station_goods表数据
	 */
	public void updateGasStationGoodsByStationId(String stationId,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

	/**
	* 根据goodsName更新gas_station_goods表数据
	*/
	public void updateGasStationGoodsByGoodsName(String goodsName,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andGoodsNameEqualTo(goodsName);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

	/**
	* 根据goodsCode更新gas_station_goods表数据
	*/
	public void updateGasStationGoodsByGoodsCode(String goodsCode,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

    /**
	 * 根据orderNo更新gas_station_goods表数据
	 */
	public void updateGasStationGoodsByOrderNo(Integer orderNo,GasStationGoodsDO gasStationGoodsDO) {
		GasStationGoodsDOExample exam = new GasStationGoodsDOExample();
		exam.createCriteria().andOrderNoEqualTo(orderNo);
		gasStationGoodsDAO.updateByExample(gasStationGoodsDO, exam);
	}

    /**
	 * 断言gas_station_goods_price_plan表
	 */
	public void gasStationGoodsPricePlanAssert(
	        GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO,
			Long id, 
			String planId, 
			String merchantPlanId, 
			String priceName, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			Date effectTime, 
			String deleteFlag, 
			String operatorId, 
			String operatorName, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String goodsInfo
	) {
        assertEquals(id, gasStationGoodsPricePlanDO.getId());
        assertEquals(planId, gasStationGoodsPricePlanDO.getPlanId());
        assertEquals(merchantPlanId, gasStationGoodsPricePlanDO.getMerchantPlanId());
        assertEquals(priceName, gasStationGoodsPricePlanDO.getPriceName());
        assertEquals(partnerId, gasStationGoodsPricePlanDO.getPartnerId());
        assertEquals(platPartnerId, gasStationGoodsPricePlanDO.getPlatPartnerId());
        assertEquals(stationId, gasStationGoodsPricePlanDO.getStationId());
        assertEquals(effectTime, gasStationGoodsPricePlanDO.getEffectTime());
        assertEquals(deleteFlag, gasStationGoodsPricePlanDO.getDeleteFlag());
        assertEquals(operatorId, gasStationGoodsPricePlanDO.getOperatorId());
        assertEquals(operatorName, gasStationGoodsPricePlanDO.getOperatorName());
        assertEquals(rawAddTime, gasStationGoodsPricePlanDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasStationGoodsPricePlanDO.getRawUpdateTime());
        assertEquals(goodsInfo, gasStationGoodsPricePlanDO.getGoodsInfo());
	}

	/**
	 * 断言gas_station_goods_price_plan表数据
	 */
	public void assertGasStationGoodsPricePlan(GasStationGoodsPricePlanDO expect, GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasStationGoodsPricePlanDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasStationGoodsPricePlanDO.getRawAddTime());
		expect.setRawAddTime(gasStationGoodsPricePlanDO.getRawAddTime());
        Assertions.assertTrue(null != gasStationGoodsPricePlanDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasStationGoodsPricePlanDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasStationGoodsPricePlanDO);
	}

    /**
	 * 插入gas_station_goods_price_plan表数据
	 */
	public void insertGasStationGoodsPricePlan(GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		gasStationGoodsPricePlanDAO.insert(gasStationGoodsPricePlanDO);
	}

    /**
	 * 插入gas_station_goods_price_plan表数据
	 */
	public void insertGasStationGoodsPricePlan(
			Long id, 
			String planId, 
			String merchantPlanId, 
			String priceName, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			Date effectTime, 
			String deleteFlag, 
			String operatorId, 
			String operatorName, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String goodsInfo
	) {
		if (effectTime == null) {
			effectTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO = new GasStationGoodsPricePlanDO();
		gasStationGoodsPricePlanDO.setId(id);
		gasStationGoodsPricePlanDO.setPlanId(planId);
		gasStationGoodsPricePlanDO.setMerchantPlanId(merchantPlanId);
		gasStationGoodsPricePlanDO.setPriceName(priceName);
		gasStationGoodsPricePlanDO.setPartnerId(partnerId);
		gasStationGoodsPricePlanDO.setPlatPartnerId(platPartnerId);
		gasStationGoodsPricePlanDO.setStationId(stationId);
		gasStationGoodsPricePlanDO.setEffectTime(effectTime);
		gasStationGoodsPricePlanDO.setDeleteFlag(deleteFlag);
		gasStationGoodsPricePlanDO.setOperatorId(operatorId);
		gasStationGoodsPricePlanDO.setOperatorName(operatorName);
		gasStationGoodsPricePlanDO.setRawAddTime(rawAddTime);
		gasStationGoodsPricePlanDO.setRawUpdateTime(rawUpdateTime);
		gasStationGoodsPricePlanDO.setGoodsInfo(goodsInfo);
		gasStationGoodsPricePlanDAO.insert(gasStationGoodsPricePlanDO);
	}

    /**
     * 删除gas_station_goods_price_plan表所有数据
     */
    public void cleanGasStationGoodsPricePlan() {
        GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
        exam.createCriteria();
        gasStationGoodsPricePlanDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_station_goods_price_plan表数据
	 */
	public void cleanGasStationGoodsPricePlanById(Long id) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据planId删除gas_station_goods_price_plan表数据
	 */
	public void cleanGasStationGoodsPricePlanByPlanId(String planId) {
        if (StringUtils.isBlank(planId)){
            planId = "test_planId";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据merchantPlanId删除gas_station_goods_price_plan表数据
	 */
	public void cleanGasStationGoodsPricePlanByMerchantPlanId(String merchantPlanId) {
        if (StringUtils.isBlank(merchantPlanId)){
            merchantPlanId = "test_merchantPlanId";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andMerchantPlanIdEqualTo(merchantPlanId);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	* 根据priceName删除gas_station_goods_price_plan表数据
	*/
	public void cleanGasStationGoodsPricePlanByPriceName(String priceName) {
        if (StringUtils.isBlank(priceName)){
            priceName = "test_priceName";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_station_goods_price_plan表数据
	 */
	public void cleanGasStationGoodsPricePlanByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_station_goods_price_plan表数据
	 */
	public void cleanGasStationGoodsPricePlanByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_station_goods_price_plan表数据
	 */
	public void cleanGasStationGoodsPricePlanByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	 * 根据operatorId删除gas_station_goods_price_plan表数据
	 */
	public void cleanGasStationGoodsPricePlanByOperatorId(String operatorId) {
        if (StringUtils.isBlank(operatorId)){
            operatorId = "test_operatorId";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

	/**
	* 根据operatorName删除gas_station_goods_price_plan表数据
	*/
	public void cleanGasStationGoodsPricePlanByOperatorName(String operatorName) {
        if (StringUtils.isBlank(operatorName)){
            operatorName = "test_operatorName";
        }
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		gasStationGoodsPricePlanDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_station_goods_price_plan表所有数据
     */
    public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanAll() {
        GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
        exam.createCriteria();
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanById(Long id) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据planId查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByPlanId(String planId) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据merchantPlanId查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByMerchantPlanId(String merchantPlanId) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andMerchantPlanIdEqualTo(merchantPlanId);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

	/**
	* 根据priceName查询gas_station_goods_price_plan表数据
	*/
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByPriceName(String priceName) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByPartnerId(String partnerId) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByPlatPartnerId(String platPartnerId) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByStationId(String stationId) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据operatorId查询gas_station_goods_price_plan表数据
	 */
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByOperatorId(String operatorId) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

	/**
	* 根据operatorName查询gas_station_goods_price_plan表数据
	*/
	public List<GasStationGoodsPricePlanDO> findGasStationGoodsPricePlanByOperatorName(String operatorName) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		return gasStationGoodsPricePlanDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanById(Long id,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

    /**
	 * 根据planId更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanByPlanId(String planId,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPlanIdEqualTo(planId);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

    /**
	 * 根据merchantPlanId更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanByMerchantPlanId(String merchantPlanId,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andMerchantPlanIdEqualTo(merchantPlanId);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

	/**
	* 根据priceName更新gas_station_goods_price_plan表数据
	*/
	public void updateGasStationGoodsPricePlanByPriceName(String priceName,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPriceNameEqualTo(priceName);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

    /**
	 * 根据partnerId更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanByPartnerId(String partnerId,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanByPlatPartnerId(String platPartnerId,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

    /**
	 * 根据stationId更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanByStationId(String stationId,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

    /**
	 * 根据operatorId更新gas_station_goods_price_plan表数据
	 */
	public void updateGasStationGoodsPricePlanByOperatorId(String operatorId,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorIdEqualTo(operatorId);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

	/**
	* 根据operatorName更新gas_station_goods_price_plan表数据
	*/
	public void updateGasStationGoodsPricePlanByOperatorName(String operatorName,GasStationGoodsPricePlanDO gasStationGoodsPricePlanDO) {
		GasStationGoodsPricePlanDOExample exam = new GasStationGoodsPricePlanDOExample();
		exam.createCriteria().andOperatorNameEqualTo(operatorName);
		gasStationGoodsPricePlanDAO.updateByExample(gasStationGoodsPricePlanDO, exam);
	}

    /**
	 * 断言gas_station_oil_gun表
	 */
	public void gasStationOilGunAssert(
	        GasStationOilGunDO gasStationOilGunDO,
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String oilGunNo, 
			String goodsCode, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			Integer sortNo
	) {
        assertEquals(id, gasStationOilGunDO.getId());
        assertEquals(partnerId, gasStationOilGunDO.getPartnerId());
        assertEquals(platPartnerId, gasStationOilGunDO.getPlatPartnerId());
        assertEquals(stationId, gasStationOilGunDO.getStationId());
        assertEquals(oilGunNo, gasStationOilGunDO.getOilGunNo());
        assertEquals(goodsCode, gasStationOilGunDO.getGoodsCode());
        assertEquals(rawAddTime, gasStationOilGunDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasStationOilGunDO.getRawUpdateTime());
        assertEquals(sortNo, gasStationOilGunDO.getSortNo());
	}

	/**
	 * 断言gas_station_oil_gun表数据
	 */
	public void assertGasStationOilGun(GasStationOilGunDO expect, GasStationOilGunDO gasStationOilGunDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasStationOilGunDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasStationOilGunDO.getRawAddTime());
		expect.setRawAddTime(gasStationOilGunDO.getRawAddTime());
        Assertions.assertTrue(null != gasStationOilGunDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasStationOilGunDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasStationOilGunDO);
	}

    /**
	 * 插入gas_station_oil_gun表数据
	 */
	public void insertGasStationOilGun(GasStationOilGunDO gasStationOilGunDO) {
		gasStationOilGunDAO.insert(gasStationOilGunDO);
	}

    /**
	 * 插入gas_station_oil_gun表数据
	 */
	public void insertGasStationOilGun(
			Long id, 
			String partnerId, 
			String platPartnerId, 
			String stationId, 
			String oilGunNo, 
			String goodsCode, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			Integer sortNo
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasStationOilGunDO gasStationOilGunDO = new GasStationOilGunDO();
		gasStationOilGunDO.setId(id);
		gasStationOilGunDO.setPartnerId(partnerId);
		gasStationOilGunDO.setPlatPartnerId(platPartnerId);
		gasStationOilGunDO.setStationId(stationId);
		gasStationOilGunDO.setOilGunNo(oilGunNo);
		gasStationOilGunDO.setGoodsCode(goodsCode);
		gasStationOilGunDO.setRawAddTime(rawAddTime);
		gasStationOilGunDO.setRawUpdateTime(rawUpdateTime);
		gasStationOilGunDO.setSortNo(sortNo);
		gasStationOilGunDAO.insert(gasStationOilGunDO);
	}

    /**
     * 删除gas_station_oil_gun表所有数据
     */
    public void cleanGasStationOilGun() {
        GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
        exam.createCriteria();
        gasStationOilGunDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_station_oil_gun表数据
	 */
	public void cleanGasStationOilGunById(Long id) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationOilGunDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除gas_station_oil_gun表数据
	 */
	public void cleanGasStationOilGunByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasStationOilGunDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除gas_station_oil_gun表数据
	 */
	public void cleanGasStationOilGunByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasStationOilGunDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_station_oil_gun表数据
	 */
	public void cleanGasStationOilGunByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationOilGunDAO.deleteByExample(exam);
	}

	/**
	 * 根据oilGunNo删除gas_station_oil_gun表数据
	 */
	public void cleanGasStationOilGunByOilGunNo(String oilGunNo) {
        if (StringUtils.isBlank(oilGunNo)){
            oilGunNo = "test_oilGunNo";
        }
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andOilGunNoEqualTo(oilGunNo);
		gasStationOilGunDAO.deleteByExample(exam);
	}

	/**
	* 根据goodsCode删除gas_station_oil_gun表数据
	*/
	public void cleanGasStationOilGunByGoodsCode(String goodsCode) {
        if (StringUtils.isBlank(goodsCode)){
            goodsCode = "test_goodsCode";
        }
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasStationOilGunDAO.deleteByExample(exam);
	}

	/**
	 * 根据sortNo删除gas_station_oil_gun表数据
	 */
	public void cleanGasStationOilGunBySortNo(Integer sortNo) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andSortNoEqualTo(sortNo);
		gasStationOilGunDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_station_oil_gun表所有数据
     */
    public List<GasStationOilGunDO> findGasStationOilGunAll() {
        GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
        exam.createCriteria();
		return gasStationOilGunDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_station_oil_gun表数据
	 */
	public List<GasStationOilGunDO> findGasStationOilGunById(Long id) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasStationOilGunDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询gas_station_oil_gun表数据
	 */
	public List<GasStationOilGunDO> findGasStationOilGunByPartnerId(String partnerId) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return gasStationOilGunDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询gas_station_oil_gun表数据
	 */
	public List<GasStationOilGunDO> findGasStationOilGunByPlatPartnerId(String platPartnerId) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return gasStationOilGunDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_station_oil_gun表数据
	 */
	public List<GasStationOilGunDO> findGasStationOilGunByStationId(String stationId) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasStationOilGunDAO.selectByExample(exam);
	}

    /**
	 * 根据oilGunNo查询gas_station_oil_gun表数据
	 */
	public List<GasStationOilGunDO> findGasStationOilGunByOilGunNo(String oilGunNo) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andOilGunNoEqualTo(oilGunNo);
		return gasStationOilGunDAO.selectByExample(exam);
	}

	/**
	* 根据goodsCode查询gas_station_oil_gun表数据
	*/
	public List<GasStationOilGunDO> findGasStationOilGunByGoodsCode(String goodsCode) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		return gasStationOilGunDAO.selectByExample(exam);
	}

    /**
	 * 根据sortNo查询gas_station_oil_gun表数据
	 */
	public List<GasStationOilGunDO> findGasStationOilGunBySortNo(Integer sortNo) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andSortNoEqualTo(sortNo);
		return gasStationOilGunDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_station_oil_gun表数据
	 */
	public void updateGasStationOilGunById(Long id,GasStationOilGunDO gasStationOilGunDO) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationOilGunDAO.updateByExample(gasStationOilGunDO, exam);
	}

    /**
	 * 根据partnerId更新gas_station_oil_gun表数据
	 */
	public void updateGasStationOilGunByPartnerId(String partnerId,GasStationOilGunDO gasStationOilGunDO) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		gasStationOilGunDAO.updateByExample(gasStationOilGunDO, exam);
	}

    /**
	 * 根据platPartnerId更新gas_station_oil_gun表数据
	 */
	public void updateGasStationOilGunByPlatPartnerId(String platPartnerId,GasStationOilGunDO gasStationOilGunDO) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		gasStationOilGunDAO.updateByExample(gasStationOilGunDO, exam);
	}

    /**
	 * 根据stationId更新gas_station_oil_gun表数据
	 */
	public void updateGasStationOilGunByStationId(String stationId,GasStationOilGunDO gasStationOilGunDO) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationOilGunDAO.updateByExample(gasStationOilGunDO, exam);
	}

    /**
	 * 根据oilGunNo更新gas_station_oil_gun表数据
	 */
	public void updateGasStationOilGunByOilGunNo(String oilGunNo,GasStationOilGunDO gasStationOilGunDO) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andOilGunNoEqualTo(oilGunNo);
		gasStationOilGunDAO.updateByExample(gasStationOilGunDO, exam);
	}

	/**
	* 根据goodsCode更新gas_station_oil_gun表数据
	*/
	public void updateGasStationOilGunByGoodsCode(String goodsCode,GasStationOilGunDO gasStationOilGunDO) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andGoodsCodeEqualTo(goodsCode);
		gasStationOilGunDAO.updateByExample(gasStationOilGunDO, exam);
	}

    /**
	 * 根据sortNo更新gas_station_oil_gun表数据
	 */
	public void updateGasStationOilGunBySortNo(Integer sortNo,GasStationOilGunDO gasStationOilGunDO) {
		GasStationOilGunDOExample exam = new GasStationOilGunDOExample();
		exam.createCriteria().andSortNoEqualTo(sortNo);
		gasStationOilGunDAO.updateByExample(gasStationOilGunDO, exam);
	}

    /**
	 * 断言gas_station_voice_broadcast表
	 */
	public void gasStationVoiceBroadcastAssert(
	        GasStationVoiceBroadcastDO gasStationVoiceBroadcastDO,
			Integer id, 
			String stationId, 
			String broadcastType, 
			String fieldCodes, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasStationVoiceBroadcastDO.getId());
        assertEquals(stationId, gasStationVoiceBroadcastDO.getStationId());
        assertEquals(broadcastType, gasStationVoiceBroadcastDO.getBroadcastType());
        assertEquals(fieldCodes, gasStationVoiceBroadcastDO.getFieldCodes());
        assertEquals(rawAddTime, gasStationVoiceBroadcastDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasStationVoiceBroadcastDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_station_voice_broadcast表数据
	 */
	public void assertGasStationVoiceBroadcast(GasStationVoiceBroadcastDO expect, GasStationVoiceBroadcastDO gasStationVoiceBroadcastDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasStationVoiceBroadcastDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasStationVoiceBroadcastDO.getRawAddTime());
		expect.setRawAddTime(gasStationVoiceBroadcastDO.getRawAddTime());
        Assertions.assertTrue(null != gasStationVoiceBroadcastDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasStationVoiceBroadcastDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasStationVoiceBroadcastDO);
	}

    /**
	 * 插入gas_station_voice_broadcast表数据
	 */
	public void insertGasStationVoiceBroadcast(GasStationVoiceBroadcastDO gasStationVoiceBroadcastDO) {
		gasStationVoiceBroadcastDAO.insert(gasStationVoiceBroadcastDO);
	}

    /**
	 * 插入gas_station_voice_broadcast表数据
	 */
	public void insertGasStationVoiceBroadcast(
			Integer id, 
			String stationId, 
			String broadcastType, 
			String fieldCodes, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasStationVoiceBroadcastDO gasStationVoiceBroadcastDO = new GasStationVoiceBroadcastDO();
		gasStationVoiceBroadcastDO.setId(id);
		gasStationVoiceBroadcastDO.setStationId(stationId);
		gasStationVoiceBroadcastDO.setBroadcastType(broadcastType);
		gasStationVoiceBroadcastDO.setFieldCodes(fieldCodes);
		gasStationVoiceBroadcastDO.setRawAddTime(rawAddTime);
		gasStationVoiceBroadcastDO.setRawUpdateTime(rawUpdateTime);
		gasStationVoiceBroadcastDAO.insert(gasStationVoiceBroadcastDO);
	}

    /**
     * 删除gas_station_voice_broadcast表所有数据
     */
    public void cleanGasStationVoiceBroadcast() {
        GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
        exam.createCriteria();
        gasStationVoiceBroadcastDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_station_voice_broadcast表数据
	 */
	public void cleanGasStationVoiceBroadcastById(Integer id) {
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationVoiceBroadcastDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_station_voice_broadcast表数据
	 */
	public void cleanGasStationVoiceBroadcastByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationVoiceBroadcastDAO.deleteByExample(exam);
	}

	/**
	* 根据fieldCodes删除gas_station_voice_broadcast表数据
	*/
	public void cleanGasStationVoiceBroadcastByFieldCodes(String fieldCodes) {
        if (StringUtils.isBlank(fieldCodes)){
            fieldCodes = "test_fieldCodes";
        }
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andFieldCodesEqualTo(fieldCodes);
		gasStationVoiceBroadcastDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_station_voice_broadcast表所有数据
     */
    public List<GasStationVoiceBroadcastDO> findGasStationVoiceBroadcastAll() {
        GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
        exam.createCriteria();
		return gasStationVoiceBroadcastDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_station_voice_broadcast表数据
	 */
	public List<GasStationVoiceBroadcastDO> findGasStationVoiceBroadcastById(Integer id) {
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasStationVoiceBroadcastDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_station_voice_broadcast表数据
	 */
	public List<GasStationVoiceBroadcastDO> findGasStationVoiceBroadcastByStationId(String stationId) {
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasStationVoiceBroadcastDAO.selectByExample(exam);
	}

	/**
	* 根据fieldCodes查询gas_station_voice_broadcast表数据
	*/
	public List<GasStationVoiceBroadcastDO> findGasStationVoiceBroadcastByFieldCodes(String fieldCodes) {
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andFieldCodesEqualTo(fieldCodes);
		return gasStationVoiceBroadcastDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_station_voice_broadcast表数据
	 */
	public void updateGasStationVoiceBroadcastById(Integer id,GasStationVoiceBroadcastDO gasStationVoiceBroadcastDO) {
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasStationVoiceBroadcastDAO.updateByExample(gasStationVoiceBroadcastDO, exam);
	}

    /**
	 * 根据stationId更新gas_station_voice_broadcast表数据
	 */
	public void updateGasStationVoiceBroadcastByStationId(String stationId,GasStationVoiceBroadcastDO gasStationVoiceBroadcastDO) {
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasStationVoiceBroadcastDAO.updateByExample(gasStationVoiceBroadcastDO, exam);
	}

	/**
	* 根据fieldCodes更新gas_station_voice_broadcast表数据
	*/
	public void updateGasStationVoiceBroadcastByFieldCodes(String fieldCodes,GasStationVoiceBroadcastDO gasStationVoiceBroadcastDO) {
		GasStationVoiceBroadcastDOExample exam = new GasStationVoiceBroadcastDOExample();
		exam.createCriteria().andFieldCodesEqualTo(fieldCodes);
		gasStationVoiceBroadcastDAO.updateByExample(gasStationVoiceBroadcastDO, exam);
	}

    /**
	 * 断言gas_ticket_print表
	 */
	public void gasTicketPrintAssert(
	        GasTicketPrintDO gasTicketPrintDO,
			Integer id, 
			String stationId, 
			String printType, 
			Integer printNum, 
			Integer printSleep, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasTicketPrintDO.getId());
        assertEquals(stationId, gasTicketPrintDO.getStationId());
        assertEquals(printType, gasTicketPrintDO.getPrintType());
        assertEquals(printNum, gasTicketPrintDO.getPrintNum());
        assertEquals(printSleep, gasTicketPrintDO.getPrintSleep());
        assertEquals(memo, gasTicketPrintDO.getMemo());
        assertEquals(rawAddTime, gasTicketPrintDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasTicketPrintDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_ticket_print表数据
	 */
	public void assertGasTicketPrint(GasTicketPrintDO expect, GasTicketPrintDO gasTicketPrintDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasTicketPrintDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasTicketPrintDO.getRawAddTime());
		expect.setRawAddTime(gasTicketPrintDO.getRawAddTime());
        Assertions.assertTrue(null != gasTicketPrintDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasTicketPrintDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasTicketPrintDO);
	}

    /**
	 * 插入gas_ticket_print表数据
	 */
	public void insertGasTicketPrint(GasTicketPrintDO gasTicketPrintDO) {
		gasTicketPrintDAO.insert(gasTicketPrintDO);
	}

    /**
	 * 插入gas_ticket_print表数据
	 */
	public void insertGasTicketPrint(
			Integer id, 
			String stationId, 
			String printType, 
			Integer printNum, 
			Integer printSleep, 
			String memo, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasTicketPrintDO gasTicketPrintDO = new GasTicketPrintDO();
		gasTicketPrintDO.setId(id);
		gasTicketPrintDO.setStationId(stationId);
		gasTicketPrintDO.setPrintType(printType);
		gasTicketPrintDO.setPrintNum(printNum);
		gasTicketPrintDO.setPrintSleep(printSleep);
		gasTicketPrintDO.setMemo(memo);
		gasTicketPrintDO.setRawAddTime(rawAddTime);
		gasTicketPrintDO.setRawUpdateTime(rawUpdateTime);
		gasTicketPrintDAO.insert(gasTicketPrintDO);
	}

    /**
     * 删除gas_ticket_print表所有数据
     */
    public void cleanGasTicketPrint() {
        GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
        exam.createCriteria();
        gasTicketPrintDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_ticket_print表数据
	 */
	public void cleanGasTicketPrintById(Integer id) {
		GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTicketPrintDAO.deleteByExample(exam);
	}

	/**
	 * 根据stationId删除gas_ticket_print表数据
	 */
	public void cleanGasTicketPrintByStationId(String stationId) {
        if (StringUtils.isBlank(stationId)){
            stationId = "test_stationId";
        }
		GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTicketPrintDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_ticket_print表所有数据
     */
    public List<GasTicketPrintDO> findGasTicketPrintAll() {
        GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
        exam.createCriteria();
		return gasTicketPrintDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_ticket_print表数据
	 */
	public List<GasTicketPrintDO> findGasTicketPrintById(Integer id) {
		GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasTicketPrintDAO.selectByExample(exam);
	}

    /**
	 * 根据stationId查询gas_ticket_print表数据
	 */
	public List<GasTicketPrintDO> findGasTicketPrintByStationId(String stationId) {
		GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		return gasTicketPrintDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_ticket_print表数据
	 */
	public void updateGasTicketPrintById(Integer id,GasTicketPrintDO gasTicketPrintDO) {
		GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTicketPrintDAO.updateByExample(gasTicketPrintDO, exam);
	}

    /**
	 * 根据stationId更新gas_ticket_print表数据
	 */
	public void updateGasTicketPrintByStationId(String stationId,GasTicketPrintDO gasTicketPrintDO) {
		GasTicketPrintDOExample exam = new GasTicketPrintDOExample();
		exam.createCriteria().andStationIdEqualTo(stationId);
		gasTicketPrintDAO.updateByExample(gasTicketPrintDO, exam);
	}

    /**
	 * 断言gas_trade_notify_task_wash表
	 */
	public void gasTradeNotifyTaskWashAssert(
	        GasTradeNotifyTaskWashDO gasTradeNotifyTaskWashDO,
			Long id, 
			String bizNo, 
			String notifyCategory, 
			String notifyType, 
			String status, 
			Integer retryCount, 
			Integer maxRetryCount, 
			String detail, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasTradeNotifyTaskWashDO.getId());
        assertEquals(bizNo, gasTradeNotifyTaskWashDO.getBizNo());
        assertEquals(notifyCategory, gasTradeNotifyTaskWashDO.getNotifyCategory());
        assertEquals(notifyType, gasTradeNotifyTaskWashDO.getNotifyType());
        assertEquals(status, gasTradeNotifyTaskWashDO.getStatus());
        assertEquals(retryCount, gasTradeNotifyTaskWashDO.getRetryCount());
        assertEquals(maxRetryCount, gasTradeNotifyTaskWashDO.getMaxRetryCount());
        assertEquals(detail, gasTradeNotifyTaskWashDO.getDetail());
        assertEquals(rawAddTime, gasTradeNotifyTaskWashDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasTradeNotifyTaskWashDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_trade_notify_task_wash表数据
	 */
	public void assertGasTradeNotifyTaskWash(GasTradeNotifyTaskWashDO expect, GasTradeNotifyTaskWashDO gasTradeNotifyTaskWashDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasTradeNotifyTaskWashDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasTradeNotifyTaskWashDO.getRawAddTime());
		expect.setRawAddTime(gasTradeNotifyTaskWashDO.getRawAddTime());
        Assertions.assertTrue(null != gasTradeNotifyTaskWashDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasTradeNotifyTaskWashDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasTradeNotifyTaskWashDO);
	}

    /**
	 * 插入gas_trade_notify_task_wash表数据
	 */
	public void insertGasTradeNotifyTaskWash(GasTradeNotifyTaskWashDO gasTradeNotifyTaskWashDO) {
		gasTradeNotifyTaskWashDAO.insert(gasTradeNotifyTaskWashDO);
	}

    /**
	 * 插入gas_trade_notify_task_wash表数据
	 */
	public void insertGasTradeNotifyTaskWash(
			Long id, 
			String bizNo, 
			String notifyCategory, 
			String notifyType, 
			String status, 
			Integer retryCount, 
			Integer maxRetryCount, 
			String detail, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasTradeNotifyTaskWashDO gasTradeNotifyTaskWashDO = new GasTradeNotifyTaskWashDO();
		gasTradeNotifyTaskWashDO.setId(id);
		gasTradeNotifyTaskWashDO.setBizNo(bizNo);
		gasTradeNotifyTaskWashDO.setNotifyCategory(notifyCategory);
		gasTradeNotifyTaskWashDO.setNotifyType(notifyType);
		gasTradeNotifyTaskWashDO.setStatus(status);
		gasTradeNotifyTaskWashDO.setRetryCount(retryCount);
		gasTradeNotifyTaskWashDO.setMaxRetryCount(maxRetryCount);
		gasTradeNotifyTaskWashDO.setDetail(detail);
		gasTradeNotifyTaskWashDO.setRawAddTime(rawAddTime);
		gasTradeNotifyTaskWashDO.setRawUpdateTime(rawUpdateTime);
		gasTradeNotifyTaskWashDAO.insert(gasTradeNotifyTaskWashDO);
	}

    /**
     * 删除gas_trade_notify_task_wash表所有数据
     */
    public void cleanGasTradeNotifyTaskWash() {
        GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
        exam.createCriteria();
        gasTradeNotifyTaskWashDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_trade_notify_task_wash表数据
	 */
	public void cleanGasTradeNotifyTaskWashById(Long id) {
		GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTradeNotifyTaskWashDAO.deleteByExample(exam);
	}

	/**
	 * 根据bizNo删除gas_trade_notify_task_wash表数据
	 */
	public void cleanGasTradeNotifyTaskWashByBizNo(String bizNo) {
        if (StringUtils.isBlank(bizNo)){
            bizNo = "test_bizNo";
        }
		GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasTradeNotifyTaskWashDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_trade_notify_task_wash表所有数据
     */
    public List<GasTradeNotifyTaskWashDO> findGasTradeNotifyTaskWashAll() {
        GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
        exam.createCriteria();
		return gasTradeNotifyTaskWashDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_trade_notify_task_wash表数据
	 */
	public List<GasTradeNotifyTaskWashDO> findGasTradeNotifyTaskWashById(Long id) {
		GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasTradeNotifyTaskWashDAO.selectByExample(exam);
	}

    /**
	 * 根据bizNo查询gas_trade_notify_task_wash表数据
	 */
	public List<GasTradeNotifyTaskWashDO> findGasTradeNotifyTaskWashByBizNo(String bizNo) {
		GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		return gasTradeNotifyTaskWashDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_trade_notify_task_wash表数据
	 */
	public void updateGasTradeNotifyTaskWashById(Long id,GasTradeNotifyTaskWashDO gasTradeNotifyTaskWashDO) {
		GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasTradeNotifyTaskWashDAO.updateByExample(gasTradeNotifyTaskWashDO, exam);
	}

    /**
	 * 根据bizNo更新gas_trade_notify_task_wash表数据
	 */
	public void updateGasTradeNotifyTaskWashByBizNo(String bizNo,GasTradeNotifyTaskWashDO gasTradeNotifyTaskWashDO) {
		GasTradeNotifyTaskWashDOExample exam = new GasTradeNotifyTaskWashDOExample();
		exam.createCriteria().andBizNoEqualTo(bizNo);
		gasTradeNotifyTaskWashDAO.updateByExample(gasTradeNotifyTaskWashDO, exam);
	}

    /**
	 * 断言gas_voice_broadcast_field表
	 */
	public void gasVoiceBroadcastFieldAssert(
	        GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO,
			Integer id, 
			String broadcastType, 
			String fieldCode, 
			String fieldName, 
			String preValue, 
			String defaultValue, 
			String suffixValue, 
			String required, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasVoiceBroadcastFieldDO.getId());
        assertEquals(broadcastType, gasVoiceBroadcastFieldDO.getBroadcastType());
        assertEquals(fieldCode, gasVoiceBroadcastFieldDO.getFieldCode());
        assertEquals(fieldName, gasVoiceBroadcastFieldDO.getFieldName());
        assertEquals(preValue, gasVoiceBroadcastFieldDO.getPreValue());
        assertEquals(defaultValue, gasVoiceBroadcastFieldDO.getDefaultValue());
        assertEquals(suffixValue, gasVoiceBroadcastFieldDO.getSuffixValue());
        assertEquals(required, gasVoiceBroadcastFieldDO.getRequired());
        assertEquals(rawAddTime, gasVoiceBroadcastFieldDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasVoiceBroadcastFieldDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_voice_broadcast_field表数据
	 */
	public void assertGasVoiceBroadcastField(GasVoiceBroadcastFieldDO expect, GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasVoiceBroadcastFieldDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasVoiceBroadcastFieldDO.getRawAddTime());
		expect.setRawAddTime(gasVoiceBroadcastFieldDO.getRawAddTime());
        Assertions.assertTrue(null != gasVoiceBroadcastFieldDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasVoiceBroadcastFieldDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasVoiceBroadcastFieldDO);
	}

    /**
	 * 插入gas_voice_broadcast_field表数据
	 */
	public void insertGasVoiceBroadcastField(GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO) {
		gasVoiceBroadcastFieldDAO.insert(gasVoiceBroadcastFieldDO);
	}

    /**
	 * 插入gas_voice_broadcast_field表数据
	 */
	public void insertGasVoiceBroadcastField(
			Integer id, 
			String broadcastType, 
			String fieldCode, 
			String fieldName, 
			String preValue, 
			String defaultValue, 
			String suffixValue, 
			String required, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO = new GasVoiceBroadcastFieldDO();
		gasVoiceBroadcastFieldDO.setId(id);
		gasVoiceBroadcastFieldDO.setBroadcastType(broadcastType);
		gasVoiceBroadcastFieldDO.setFieldCode(fieldCode);
		gasVoiceBroadcastFieldDO.setFieldName(fieldName);
		gasVoiceBroadcastFieldDO.setPreValue(preValue);
		gasVoiceBroadcastFieldDO.setDefaultValue(defaultValue);
		gasVoiceBroadcastFieldDO.setSuffixValue(suffixValue);
		gasVoiceBroadcastFieldDO.setRequired(required);
		gasVoiceBroadcastFieldDO.setRawAddTime(rawAddTime);
		gasVoiceBroadcastFieldDO.setRawUpdateTime(rawUpdateTime);
		gasVoiceBroadcastFieldDAO.insert(gasVoiceBroadcastFieldDO);
	}

    /**
     * 删除gas_voice_broadcast_field表所有数据
     */
    public void cleanGasVoiceBroadcastField() {
        GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
        exam.createCriteria();
        gasVoiceBroadcastFieldDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_voice_broadcast_field表数据
	 */
	public void cleanGasVoiceBroadcastFieldById(Integer id) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasVoiceBroadcastFieldDAO.deleteByExample(exam);
	}

	/**
	* 根据fieldCode删除gas_voice_broadcast_field表数据
	*/
	public void cleanGasVoiceBroadcastFieldByFieldCode(String fieldCode) {
        if (StringUtils.isBlank(fieldCode)){
            fieldCode = "test_fieldCode";
        }
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andFieldCodeEqualTo(fieldCode);
		gasVoiceBroadcastFieldDAO.deleteByExample(exam);
	}

	/**
	* 根据fieldName删除gas_voice_broadcast_field表数据
	*/
	public void cleanGasVoiceBroadcastFieldByFieldName(String fieldName) {
        if (StringUtils.isBlank(fieldName)){
            fieldName = "test_fieldName";
        }
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andFieldNameEqualTo(fieldName);
		gasVoiceBroadcastFieldDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_voice_broadcast_field表所有数据
     */
    public List<GasVoiceBroadcastFieldDO> findGasVoiceBroadcastFieldAll() {
        GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
        exam.createCriteria();
		return gasVoiceBroadcastFieldDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_voice_broadcast_field表数据
	 */
	public List<GasVoiceBroadcastFieldDO> findGasVoiceBroadcastFieldById(Integer id) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasVoiceBroadcastFieldDAO.selectByExample(exam);
	}

	/**
	* 根据fieldCode查询gas_voice_broadcast_field表数据
	*/
	public List<GasVoiceBroadcastFieldDO> findGasVoiceBroadcastFieldByFieldCode(String fieldCode) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andFieldCodeEqualTo(fieldCode);
		return gasVoiceBroadcastFieldDAO.selectByExample(exam);
	}

	/**
	* 根据fieldName查询gas_voice_broadcast_field表数据
	*/
	public List<GasVoiceBroadcastFieldDO> findGasVoiceBroadcastFieldByFieldName(String fieldName) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andFieldNameEqualTo(fieldName);
		return gasVoiceBroadcastFieldDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_voice_broadcast_field表数据
	 */
	public void updateGasVoiceBroadcastFieldById(Integer id,GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasVoiceBroadcastFieldDAO.updateByExample(gasVoiceBroadcastFieldDO, exam);
	}

	/**
	* 根据fieldCode更新gas_voice_broadcast_field表数据
	*/
	public void updateGasVoiceBroadcastFieldByFieldCode(String fieldCode,GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andFieldCodeEqualTo(fieldCode);
		gasVoiceBroadcastFieldDAO.updateByExample(gasVoiceBroadcastFieldDO, exam);
	}

	/**
	* 根据fieldName更新gas_voice_broadcast_field表数据
	*/
	public void updateGasVoiceBroadcastFieldByFieldName(String fieldName,GasVoiceBroadcastFieldDO gasVoiceBroadcastFieldDO) {
		GasVoiceBroadcastFieldDOExample exam = new GasVoiceBroadcastFieldDOExample();
		exam.createCriteria().andFieldNameEqualTo(fieldName);
		gasVoiceBroadcastFieldDAO.updateByExample(gasVoiceBroadcastFieldDO, exam);
	}

    /**
	 * 断言gas_wechat_token表
	 */
	public void gasWechatTokenAssert(
	        GasWechatTokenDO gasWechatTokenDO,
			Long id, 
			String componentAccessToken, 
			String componentVerifyTicket, 
			String appId, 
			Date tokenAddTime, 
			Date ticketAddTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
        assertEquals(id, gasWechatTokenDO.getId());
        assertEquals(componentAccessToken, gasWechatTokenDO.getComponentAccessToken());
        assertEquals(componentVerifyTicket, gasWechatTokenDO.getComponentVerifyTicket());
        assertEquals(appId, gasWechatTokenDO.getAppId());
        assertEquals(tokenAddTime, gasWechatTokenDO.getTokenAddTime());
        assertEquals(ticketAddTime, gasWechatTokenDO.getTicketAddTime());
        assertEquals(rawAddTime, gasWechatTokenDO.getRawAddTime());
        assertEquals(rawUpdateTime, gasWechatTokenDO.getRawUpdateTime());
	}

	/**
	 * 断言gas_wechat_token表数据
	 */
	public void assertGasWechatToken(GasWechatTokenDO expect, GasWechatTokenDO gasWechatTokenDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			gasWechatTokenDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != gasWechatTokenDO.getRawAddTime());
		expect.setRawAddTime(gasWechatTokenDO.getRawAddTime());
        Assertions.assertTrue(null != gasWechatTokenDO.getRawUpdateTime());
		expect.setRawUpdateTime(gasWechatTokenDO.getRawUpdateTime());
		Assertions.assertEquals(expect, gasWechatTokenDO);
	}

    /**
	 * 插入gas_wechat_token表数据
	 */
	public void insertGasWechatToken(GasWechatTokenDO gasWechatTokenDO) {
		gasWechatTokenDAO.insert(gasWechatTokenDO);
	}

    /**
	 * 插入gas_wechat_token表数据
	 */
	public void insertGasWechatToken(
			Long id, 
			String componentAccessToken, 
			String componentVerifyTicket, 
			String appId, 
			Date tokenAddTime, 
			Date ticketAddTime, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (tokenAddTime == null) {
			tokenAddTime = new Date();
		}
		if (ticketAddTime == null) {
			ticketAddTime = new Date();
		}
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		GasWechatTokenDO gasWechatTokenDO = new GasWechatTokenDO();
		gasWechatTokenDO.setId(id);
		gasWechatTokenDO.setComponentAccessToken(componentAccessToken);
		gasWechatTokenDO.setComponentVerifyTicket(componentVerifyTicket);
		gasWechatTokenDO.setAppId(appId);
		gasWechatTokenDO.setTokenAddTime(tokenAddTime);
		gasWechatTokenDO.setTicketAddTime(ticketAddTime);
		gasWechatTokenDO.setRawAddTime(rawAddTime);
		gasWechatTokenDO.setRawUpdateTime(rawUpdateTime);
		gasWechatTokenDAO.insert(gasWechatTokenDO);
	}

    /**
     * 删除gas_wechat_token表所有数据
     */
    public void cleanGasWechatToken() {
        GasWechatTokenDOExample exam = new GasWechatTokenDOExample();
        exam.createCriteria();
        gasWechatTokenDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除gas_wechat_token表数据
	 */
	public void cleanGasWechatTokenById(Long id) {
		GasWechatTokenDOExample exam = new GasWechatTokenDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasWechatTokenDAO.deleteByExample(exam);
	}

	/**
	 * 根据appId删除gas_wechat_token表数据
	 */
	public void cleanGasWechatTokenByAppId(String appId) {
        if (StringUtils.isBlank(appId)){
            appId = "test_appId";
        }
		GasWechatTokenDOExample exam = new GasWechatTokenDOExample();
		exam.createCriteria().andAppIdEqualTo(appId);
		gasWechatTokenDAO.deleteByExample(exam);
	}

    /**
     * 查询gas_wechat_token表所有数据
     */
    public List<GasWechatTokenDO> findGasWechatTokenAll() {
        GasWechatTokenDOExample exam = new GasWechatTokenDOExample();
        exam.createCriteria();
		return gasWechatTokenDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询gas_wechat_token表数据
	 */
	public List<GasWechatTokenDO> findGasWechatTokenById(Long id) {
		GasWechatTokenDOExample exam = new GasWechatTokenDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return gasWechatTokenDAO.selectByExample(exam);
	}

    /**
	 * 根据appId查询gas_wechat_token表数据
	 */
	public List<GasWechatTokenDO> findGasWechatTokenByAppId(String appId) {
		GasWechatTokenDOExample exam = new GasWechatTokenDOExample();
		exam.createCriteria().andAppIdEqualTo(appId);
		return gasWechatTokenDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新gas_wechat_token表数据
	 */
	public void updateGasWechatTokenById(Long id,GasWechatTokenDO gasWechatTokenDO) {
		GasWechatTokenDOExample exam = new GasWechatTokenDOExample();
		exam.createCriteria().andIdEqualTo(id);
		gasWechatTokenDAO.updateByExample(gasWechatTokenDO, exam);
	}

    /**
	 * 根据appId更新gas_wechat_token表数据
	 */
	public void updateGasWechatTokenByAppId(String appId,GasWechatTokenDO gasWechatTokenDO) {
		GasWechatTokenDOExample exam = new GasWechatTokenDOExample();
		exam.createCriteria().andAppIdEqualTo(appId);
		gasWechatTokenDAO.updateByExample(gasWechatTokenDO, exam);
	}

    /**
	 * 断言merchant_protocol_rule表
	 */
	public void merchantProtocolRuleAssert(
	        MerchantProtocolRuleDO merchantProtocolRuleDO,
			Long id, 
			String platPartnerId, 
			String status, 
			String ruleType, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String protocol, 
			String description, 
			String ruleData
	) {
        assertEquals(id, merchantProtocolRuleDO.getId());
        assertEquals(platPartnerId, merchantProtocolRuleDO.getPlatPartnerId());
        assertEquals(status, merchantProtocolRuleDO.getStatus());
        assertEquals(ruleType, merchantProtocolRuleDO.getRuleType());
        assertEquals(rawAddTime, merchantProtocolRuleDO.getRawAddTime());
        assertEquals(rawUpdateTime, merchantProtocolRuleDO.getRawUpdateTime());
        assertEquals(protocol, merchantProtocolRuleDO.getProtocol());
        assertEquals(description, merchantProtocolRuleDO.getDescription());
        assertEquals(ruleData, merchantProtocolRuleDO.getRuleData());
	}

	/**
	 * 断言merchant_protocol_rule表数据
	 */
	public void assertMerchantProtocolRule(MerchantProtocolRuleDO expect, MerchantProtocolRuleDO merchantProtocolRuleDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantProtocolRuleDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantProtocolRuleDO.getRawAddTime());
		expect.setRawAddTime(merchantProtocolRuleDO.getRawAddTime());
        Assertions.assertTrue(null != merchantProtocolRuleDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantProtocolRuleDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantProtocolRuleDO);
	}

    /**
	 * 插入merchant_protocol_rule表数据
	 */
	public void insertMerchantProtocolRule(MerchantProtocolRuleDO merchantProtocolRuleDO) {
		merchantProtocolRuleDAO.insert(merchantProtocolRuleDO);
	}

    /**
	 * 插入merchant_protocol_rule表数据
	 */
	public void insertMerchantProtocolRule(
			Long id, 
			String platPartnerId, 
			String status, 
			String ruleType, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String protocol, 
			String description, 
			String ruleData
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		MerchantProtocolRuleDO merchantProtocolRuleDO = new MerchantProtocolRuleDO();
		merchantProtocolRuleDO.setId(id);
		merchantProtocolRuleDO.setPlatPartnerId(platPartnerId);
		merchantProtocolRuleDO.setStatus(status);
		merchantProtocolRuleDO.setRuleType(ruleType);
		merchantProtocolRuleDO.setRawAddTime(rawAddTime);
		merchantProtocolRuleDO.setRawUpdateTime(rawUpdateTime);
		merchantProtocolRuleDO.setProtocol(protocol);
		merchantProtocolRuleDO.setDescription(description);
		merchantProtocolRuleDO.setRuleData(ruleData);
		merchantProtocolRuleDAO.insert(merchantProtocolRuleDO);
	}

    /**
     * 删除merchant_protocol_rule表所有数据
     */
    public void cleanMerchantProtocolRule() {
        MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
        exam.createCriteria();
        merchantProtocolRuleDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_protocol_rule表数据
	 */
	public void cleanMerchantProtocolRuleById(Long id) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantProtocolRuleDAO.deleteByExample(exam);
	}

	/**
	 * 根据platPartnerId删除merchant_protocol_rule表数据
	 */
	public void cleanMerchantProtocolRuleByPlatPartnerId(String platPartnerId) {
        if (StringUtils.isBlank(platPartnerId)){
            platPartnerId = "test_platPartnerId";
        }
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		merchantProtocolRuleDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_protocol_rule表所有数据
     */
    public List<MerchantProtocolRuleDO> findMerchantProtocolRuleAll() {
        MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
        exam.createCriteria();
		return merchantProtocolRuleDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_protocol_rule表数据
	 */
	public List<MerchantProtocolRuleDO> findMerchantProtocolRuleById(Long id) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantProtocolRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据platPartnerId查询merchant_protocol_rule表数据
	 */
	public List<MerchantProtocolRuleDO> findMerchantProtocolRuleByPlatPartnerId(String platPartnerId) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		return merchantProtocolRuleDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_protocol_rule表数据
	 */
	public void updateMerchantProtocolRuleById(Long id,MerchantProtocolRuleDO merchantProtocolRuleDO) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantProtocolRuleDAO.updateByExample(merchantProtocolRuleDO, exam);
	}

    /**
	 * 根据platPartnerId更新merchant_protocol_rule表数据
	 */
	public void updateMerchantProtocolRuleByPlatPartnerId(String platPartnerId,MerchantProtocolRuleDO merchantProtocolRuleDO) {
		MerchantProtocolRuleDOExample exam = new MerchantProtocolRuleDOExample();
		exam.createCriteria().andPlatPartnerIdEqualTo(platPartnerId);
		merchantProtocolRuleDAO.updateByExample(merchantProtocolRuleDO, exam);
	}

    /**
	 * 断言notify_task表
	 */
	public void notifyTaskAssert(
	        NotifyTaskDO notifyTaskDO,
			Long id, 
			String identity, 
			String notifyType, 
			Integer retryCount, 
			Integer maxRetryCount, 
			String status, 
			String detail, 
			String gid, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String context
	) {
        assertEquals(id, notifyTaskDO.getId());
        assertEquals(identity, notifyTaskDO.getIdentity());
        assertEquals(notifyType, notifyTaskDO.getNotifyType());
        assertEquals(retryCount, notifyTaskDO.getRetryCount());
        assertEquals(maxRetryCount, notifyTaskDO.getMaxRetryCount());
        assertEquals(status, notifyTaskDO.getStatus());
        assertEquals(detail, notifyTaskDO.getDetail());
        assertEquals(gid, notifyTaskDO.getGid());
        assertEquals(rawAddTime, notifyTaskDO.getRawAddTime());
        assertEquals(rawUpdateTime, notifyTaskDO.getRawUpdateTime());
        assertEquals(context, notifyTaskDO.getContext());
	}

	/**
	 * 断言notify_task表数据
	 */
	public void assertNotifyTask(NotifyTaskDO expect, NotifyTaskDO notifyTaskDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			notifyTaskDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != notifyTaskDO.getRawAddTime());
		expect.setRawAddTime(notifyTaskDO.getRawAddTime());
        Assertions.assertTrue(null != notifyTaskDO.getRawUpdateTime());
		expect.setRawUpdateTime(notifyTaskDO.getRawUpdateTime());
		Assertions.assertEquals(expect, notifyTaskDO);
	}

    /**
	 * 插入notify_task表数据
	 */
	public void insertNotifyTask(NotifyTaskDO notifyTaskDO) {
		notifyTaskDAO.insert(notifyTaskDO);
	}

    /**
	 * 插入notify_task表数据
	 */
	public void insertNotifyTask(
			Long id, 
			String identity, 
			String notifyType, 
			Integer retryCount, 
			Integer maxRetryCount, 
			String status, 
			String detail, 
			String gid, 
			Date rawAddTime, 
			Date rawUpdateTime, 
			String context
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		NotifyTaskDO notifyTaskDO = new NotifyTaskDO();
		notifyTaskDO.setId(id);
		notifyTaskDO.setIdentity(identity);
		notifyTaskDO.setNotifyType(notifyType);
		notifyTaskDO.setRetryCount(retryCount);
		notifyTaskDO.setMaxRetryCount(maxRetryCount);
		notifyTaskDO.setStatus(status);
		notifyTaskDO.setDetail(detail);
		notifyTaskDO.setGid(gid);
		notifyTaskDO.setRawAddTime(rawAddTime);
		notifyTaskDO.setRawUpdateTime(rawUpdateTime);
		notifyTaskDO.setContext(context);
		notifyTaskDAO.insert(notifyTaskDO);
	}

    /**
     * 删除notify_task表所有数据
     */
    public void cleanNotifyTask() {
        NotifyTaskDOExample exam = new NotifyTaskDOExample();
        exam.createCriteria();
        notifyTaskDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除notify_task表数据
	 */
	public void cleanNotifyTaskById(Long id) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		notifyTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据identity删除notify_task表数据
	 */
	public void cleanNotifyTaskByIdentity(String identity) {
        if (StringUtils.isBlank(identity)){
            identity = "test_identity";
        }
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		notifyTaskDAO.deleteByExample(exam);
	}

	/**
	 * 根据gid删除notify_task表数据
	 */
	public void cleanNotifyTaskByGid(String gid) {
        if (StringUtils.isBlank(gid)){
            gid = "test_gid";
        }
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		notifyTaskDAO.deleteByExample(exam);
	}

    /**
     * 查询notify_task表所有数据
     */
    public List<NotifyTaskDO> findNotifyTaskAll() {
        NotifyTaskDOExample exam = new NotifyTaskDOExample();
        exam.createCriteria();
		return notifyTaskDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询notify_task表数据
	 */
	public List<NotifyTaskDO> findNotifyTaskById(Long id) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return notifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据identity查询notify_task表数据
	 */
	public List<NotifyTaskDO> findNotifyTaskByIdentity(String identity) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		return notifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据gid查询notify_task表数据
	 */
	public List<NotifyTaskDO> findNotifyTaskByGid(String gid) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		return notifyTaskDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新notify_task表数据
	 */
	public void updateNotifyTaskById(Long id,NotifyTaskDO notifyTaskDO) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andIdEqualTo(id);
		notifyTaskDAO.updateByExample(notifyTaskDO, exam);
	}

    /**
	 * 根据identity更新notify_task表数据
	 */
	public void updateNotifyTaskByIdentity(String identity,NotifyTaskDO notifyTaskDO) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		notifyTaskDAO.updateByExample(notifyTaskDO, exam);
	}

    /**
	 * 根据gid更新notify_task表数据
	 */
	public void updateNotifyTaskByGid(String gid,NotifyTaskDO notifyTaskDO) {
		NotifyTaskDOExample exam = new NotifyTaskDOExample();
		exam.createCriteria().andGidEqualTo(gid);
		notifyTaskDAO.updateByExample(notifyTaskDO, exam);
	}

    /**
	 * 断言s_list表
	 */
	public void sListAssert(
	        SListDO sListDO,
			String name, 
			String name1, 
			String c1, 
			String c2, 
			String c3, 
			String c4, 
			String c5, 
			String c6, 
			String c7, 
			String c8, 
			String c9, 
			String c10
	) {
        assertEquals(name, sListDO.getName());
        assertEquals(name1, sListDO.getName1());
        assertEquals(c1, sListDO.getC1());
        assertEquals(c2, sListDO.getC2());
        assertEquals(c3, sListDO.getC3());
        assertEquals(c4, sListDO.getC4());
        assertEquals(c5, sListDO.getC5());
        assertEquals(c6, sListDO.getC6());
        assertEquals(c7, sListDO.getC7());
        assertEquals(c8, sListDO.getC8());
        assertEquals(c9, sListDO.getC9());
        assertEquals(c10, sListDO.getC10());
	}

	/**
	 * 断言s_list表数据
	 */
	public void assertSList(SListDO expect, SListDO sListDO) {
		Assertions.assertEquals(expect, sListDO);
	}

    /**
	 * 插入s_list表数据
	 */
	public void insertSList(SListDO sListDO) {
		sListDAO.insert(sListDO);
	}

    /**
	 * 插入s_list表数据
	 */
	public void insertSList(
			String name, 
			String name1, 
			String c1, 
			String c2, 
			String c3, 
			String c4, 
			String c5, 
			String c6, 
			String c7, 
			String c8, 
			String c9, 
			String c10
	) {
		SListDO sListDO = new SListDO();
		sListDO.setName(name);
		sListDO.setName1(name1);
		sListDO.setC1(c1);
		sListDO.setC2(c2);
		sListDO.setC3(c3);
		sListDO.setC4(c4);
		sListDO.setC5(c5);
		sListDO.setC6(c6);
		sListDO.setC7(c7);
		sListDO.setC8(c8);
		sListDO.setC9(c9);
		sListDO.setC10(c10);
		sListDAO.insert(sListDO);
	}

    /**
     * 删除s_list表所有数据
     */
    public void cleanSList() {
        SListDOExample exam = new SListDOExample();
        exam.createCriteria();
        sListDAO.deleteByExample(exam);
    }


	/**
	* 根据name删除s_list表数据
	*/
	public void cleanSListByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		SListDOExample exam = new SListDOExample();
		exam.createCriteria().andNameEqualTo(name);
		sListDAO.deleteByExample(exam);
	}

	/**
	* 根据name1删除s_list表数据
	*/
	public void cleanSListByName1(String name1) {
        if (StringUtils.isBlank(name1)){
            name1 = "test_name1";
        }
		SListDOExample exam = new SListDOExample();
		exam.createCriteria().andName1EqualTo(name1);
		sListDAO.deleteByExample(exam);
	}

    /**
     * 查询s_list表所有数据
     */
    public List<SListDO> findSListAll() {
        SListDOExample exam = new SListDOExample();
        exam.createCriteria();
		return sListDAO.selectByExample(exam);
    }

	/**
	* 根据name查询s_list表数据
	*/
	public List<SListDO> findSListByName(String name) {
		SListDOExample exam = new SListDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return sListDAO.selectByExample(exam);
	}

	/**
	* 根据name1查询s_list表数据
	*/
	public List<SListDO> findSListByName1(String name1) {
		SListDOExample exam = new SListDOExample();
		exam.createCriteria().andName1EqualTo(name1);
		return sListDAO.selectByExample(exam);
	}

	/**
	* 根据name更新s_list表数据
	*/
	public void updateSListByName(String name,SListDO sListDO) {
		SListDOExample exam = new SListDOExample();
		exam.createCriteria().andNameEqualTo(name);
		sListDAO.updateByExample(sListDO, exam);
	}

	/**
	* 根据name1更新s_list表数据
	*/
	public void updateSListByName1(String name1,SListDO sListDO) {
		SListDOExample exam = new SListDOExample();
		exam.createCriteria().andName1EqualTo(name1);
		sListDAO.updateByExample(sListDO, exam);
	}

    /**
	 * 断言sheet1表
	 */
	public void sheet1Assert(
	        Sheet1DO sheet1DO,
			Integer id, 
			String mName, 
			String mId, 
			String sName, 
			String sId, 
			String sCode, 
			String oName, 
			String oId, 
			String tatalAmount, 
			String startTime, 
			String endTime
	) {
        assertEquals(id, sheet1DO.getId());
        assertEquals(mName, sheet1DO.getmName());
        assertEquals(mId, sheet1DO.getmId());
        assertEquals(sName, sheet1DO.getsName());
        assertEquals(sId, sheet1DO.getsId());
        assertEquals(sCode, sheet1DO.getsCode());
        assertEquals(oName, sheet1DO.getoName());
        assertEquals(oId, sheet1DO.getoId());
        assertEquals(tatalAmount, sheet1DO.getTatalAmount());
        assertEquals(startTime, sheet1DO.getStartTime());
        assertEquals(endTime, sheet1DO.getEndTime());
	}

	/**
	 * 断言sheet1表数据
	 */
	public void assertSheet1(Sheet1DO expect, Sheet1DO sheet1DO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			sheet1DO.setId(expect.getId());
		}
		Assertions.assertEquals(expect, sheet1DO);
	}

    /**
	 * 插入sheet1表数据
	 */
	public void insertSheet1(Sheet1DO sheet1DO) {
		sheet1DAO.insert(sheet1DO);
	}

    /**
	 * 插入sheet1表数据
	 */
	public void insertSheet1(
			Integer id, 
			String mName, 
			String mId, 
			String sName, 
			String sId, 
			String sCode, 
			String oName, 
			String oId, 
			String tatalAmount, 
			String startTime, 
			String endTime
	) {
		Sheet1DO sheet1DO = new Sheet1DO();
		sheet1DO.setId(id);
		sheet1DO.setmName(mName);
		sheet1DO.setmId(mId);
		sheet1DO.setsName(sName);
		sheet1DO.setsId(sId);
		sheet1DO.setsCode(sCode);
		sheet1DO.setoName(oName);
		sheet1DO.setoId(oId);
		sheet1DO.setTatalAmount(tatalAmount);
		sheet1DO.setStartTime(startTime);
		sheet1DO.setEndTime(endTime);
		sheet1DAO.insert(sheet1DO);
	}

    /**
     * 删除sheet1表所有数据
     */
    public void cleanSheet1() {
        Sheet1DOExample exam = new Sheet1DOExample();
        exam.createCriteria();
        sheet1DAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除sheet1表数据
	 */
	public void cleanSheet1ById(Integer id) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andIdEqualTo(id);
		sheet1DAO.deleteByExample(exam);
	}

	/**
	* 根据mName删除sheet1表数据
	*/
	public void cleanSheet1ByMName(String mName) {
        if (StringUtils.isBlank(mName)){
            mName = "test_mName";
        }
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andMNameEqualTo(mName);
		sheet1DAO.deleteByExample(exam);
	}

	/**
	 * 根据mId删除sheet1表数据
	 */
	public void cleanSheet1ByMId(String mId) {
        if (StringUtils.isBlank(mId)){
            mId = "test_mId";
        }
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andMIdEqualTo(mId);
		sheet1DAO.deleteByExample(exam);
	}

	/**
	* 根据sName删除sheet1表数据
	*/
	public void cleanSheet1BySName(String sName) {
        if (StringUtils.isBlank(sName)){
            sName = "test_sName";
        }
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andSNameEqualTo(sName);
		sheet1DAO.deleteByExample(exam);
	}

	/**
	 * 根据sId删除sheet1表数据
	 */
	public void cleanSheet1BySId(String sId) {
        if (StringUtils.isBlank(sId)){
            sId = "test_sId";
        }
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andSIdEqualTo(sId);
		sheet1DAO.deleteByExample(exam);
	}

	/**
	* 根据sCode删除sheet1表数据
	*/
	public void cleanSheet1BySCode(String sCode) {
        if (StringUtils.isBlank(sCode)){
            sCode = "test_sCode";
        }
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andSCodeEqualTo(sCode);
		sheet1DAO.deleteByExample(exam);
	}

	/**
	* 根据oName删除sheet1表数据
	*/
	public void cleanSheet1ByOName(String oName) {
        if (StringUtils.isBlank(oName)){
            oName = "test_oName";
        }
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andONameEqualTo(oName);
		sheet1DAO.deleteByExample(exam);
	}

	/**
	 * 根据oId删除sheet1表数据
	 */
	public void cleanSheet1ByOId(String oId) {
        if (StringUtils.isBlank(oId)){
            oId = "test_oId";
        }
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andOIdEqualTo(oId);
		sheet1DAO.deleteByExample(exam);
	}

    /**
     * 查询sheet1表所有数据
     */
    public List<Sheet1DO> findSheet1All() {
        Sheet1DOExample exam = new Sheet1DOExample();
        exam.createCriteria();
		return sheet1DAO.selectByExample(exam);
    }

    /**
	 * 根据id查询sheet1表数据
	 */
	public List<Sheet1DO> findSheet1ById(Integer id) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andIdEqualTo(id);
		return sheet1DAO.selectByExample(exam);
	}

	/**
	* 根据mName查询sheet1表数据
	*/
	public List<Sheet1DO> findSheet1ByMName(String mName) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andMNameEqualTo(mName);
		return sheet1DAO.selectByExample(exam);
	}

    /**
	 * 根据mId查询sheet1表数据
	 */
	public List<Sheet1DO> findSheet1ByMId(String mId) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andMIdEqualTo(mId);
		return sheet1DAO.selectByExample(exam);
	}

	/**
	* 根据sName查询sheet1表数据
	*/
	public List<Sheet1DO> findSheet1BySName(String sName) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andSNameEqualTo(sName);
		return sheet1DAO.selectByExample(exam);
	}

    /**
	 * 根据sId查询sheet1表数据
	 */
	public List<Sheet1DO> findSheet1BySId(String sId) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andSIdEqualTo(sId);
		return sheet1DAO.selectByExample(exam);
	}

	/**
	* 根据sCode查询sheet1表数据
	*/
	public List<Sheet1DO> findSheet1BySCode(String sCode) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andSCodeEqualTo(sCode);
		return sheet1DAO.selectByExample(exam);
	}

	/**
	* 根据oName查询sheet1表数据
	*/
	public List<Sheet1DO> findSheet1ByOName(String oName) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andONameEqualTo(oName);
		return sheet1DAO.selectByExample(exam);
	}

    /**
	 * 根据oId查询sheet1表数据
	 */
	public List<Sheet1DO> findSheet1ByOId(String oId) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andOIdEqualTo(oId);
		return sheet1DAO.selectByExample(exam);
	}

    /**
	 * 根据id更新sheet1表数据
	 */
	public void updateSheet1ById(Integer id,Sheet1DO sheet1DO) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andIdEqualTo(id);
		sheet1DAO.updateByExample(sheet1DO, exam);
	}

	/**
	* 根据mName更新sheet1表数据
	*/
	public void updateSheet1ByMName(String mName,Sheet1DO sheet1DO) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andMNameEqualTo(mName);
		sheet1DAO.updateByExample(sheet1DO, exam);
	}

    /**
	 * 根据mId更新sheet1表数据
	 */
	public void updateSheet1ByMId(String mId,Sheet1DO sheet1DO) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andMIdEqualTo(mId);
		sheet1DAO.updateByExample(sheet1DO, exam);
	}

	/**
	* 根据sName更新sheet1表数据
	*/
	public void updateSheet1BySName(String sName,Sheet1DO sheet1DO) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andSNameEqualTo(sName);
		sheet1DAO.updateByExample(sheet1DO, exam);
	}

    /**
	 * 根据sId更新sheet1表数据
	 */
	public void updateSheet1BySId(String sId,Sheet1DO sheet1DO) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andSIdEqualTo(sId);
		sheet1DAO.updateByExample(sheet1DO, exam);
	}

	/**
	* 根据sCode更新sheet1表数据
	*/
	public void updateSheet1BySCode(String sCode,Sheet1DO sheet1DO) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andSCodeEqualTo(sCode);
		sheet1DAO.updateByExample(sheet1DO, exam);
	}

	/**
	* 根据oName更新sheet1表数据
	*/
	public void updateSheet1ByOName(String oName,Sheet1DO sheet1DO) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andONameEqualTo(oName);
		sheet1DAO.updateByExample(sheet1DO, exam);
	}

    /**
	 * 根据oId更新sheet1表数据
	 */
	public void updateSheet1ByOId(String oId,Sheet1DO sheet1DO) {
		Sheet1DOExample exam = new Sheet1DOExample();
		exam.createCriteria().andOIdEqualTo(oId);
		sheet1DAO.updateByExample(sheet1DO, exam);
	}

    /**
	 * 断言single表
	 */
	public void singleAssert(
	        SingleDO singleDO,
			String name, 
			String username, 
			String p, 
			String pName, 
			String c, 
			String cName, 
			String d, 
			String dNname, 
			String addres, 
			String temp, 
			String type, 
			String num
	) {
        assertEquals(name, singleDO.getName());
        assertEquals(username, singleDO.getUsername());
        assertEquals(p, singleDO.getP());
        assertEquals(pName, singleDO.getpName());
        assertEquals(c, singleDO.getC());
        assertEquals(cName, singleDO.getcName());
        assertEquals(d, singleDO.getD());
        assertEquals(dNname, singleDO.getdNname());
        assertEquals(addres, singleDO.getAddres());
        assertEquals(temp, singleDO.getTemp());
        assertEquals(type, singleDO.getType());
        assertEquals(num, singleDO.getNum());
	}

	/**
	 * 断言single表数据
	 */
	public void assertSingle(SingleDO expect, SingleDO singleDO) {
		Assertions.assertEquals(expect, singleDO);
	}

    /**
	 * 插入single表数据
	 */
	public void insertSingle(SingleDO singleDO) {
		singleDAO.insert(singleDO);
	}

    /**
	 * 插入single表数据
	 */
	public void insertSingle(
			String name, 
			String username, 
			String p, 
			String pName, 
			String c, 
			String cName, 
			String d, 
			String dNname, 
			String addres, 
			String temp, 
			String type, 
			String num
	) {
		SingleDO singleDO = new SingleDO();
		singleDO.setName(name);
		singleDO.setUsername(username);
		singleDO.setP(p);
		singleDO.setpName(pName);
		singleDO.setC(c);
		singleDO.setcName(cName);
		singleDO.setD(d);
		singleDO.setdNname(dNname);
		singleDO.setAddres(addres);
		singleDO.setTemp(temp);
		singleDO.setType(type);
		singleDO.setNum(num);
		singleDAO.insert(singleDO);
	}

    /**
     * 删除single表所有数据
     */
    public void cleanSingle() {
        SingleDOExample exam = new SingleDOExample();
        exam.createCriteria();
        singleDAO.deleteByExample(exam);
    }


	/**
	* 根据name删除single表数据
	*/
	public void cleanSingleByName(String name) {
        if (StringUtils.isBlank(name)){
            name = "test_name";
        }
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andNameEqualTo(name);
		singleDAO.deleteByExample(exam);
	}

	/**
	* 根据username删除single表数据
	*/
	public void cleanSingleByUsername(String username) {
        if (StringUtils.isBlank(username)){
            username = "test_username";
        }
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andUsernameEqualTo(username);
		singleDAO.deleteByExample(exam);
	}

	/**
	* 根据pName删除single表数据
	*/
	public void cleanSingleByPName(String pName) {
        if (StringUtils.isBlank(pName)){
            pName = "test_pName";
        }
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andPNameEqualTo(pName);
		singleDAO.deleteByExample(exam);
	}

	/**
	* 根据cName删除single表数据
	*/
	public void cleanSingleByCName(String cName) {
        if (StringUtils.isBlank(cName)){
            cName = "test_cName";
        }
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andCNameEqualTo(cName);
		singleDAO.deleteByExample(exam);
	}

	/**
	* 根据dNname删除single表数据
	*/
	public void cleanSingleByDNname(String dNname) {
        if (StringUtils.isBlank(dNname)){
            dNname = "test_dNname";
        }
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andDNnameEqualTo(dNname);
		singleDAO.deleteByExample(exam);
	}

    /**
     * 查询single表所有数据
     */
    public List<SingleDO> findSingleAll() {
        SingleDOExample exam = new SingleDOExample();
        exam.createCriteria();
		return singleDAO.selectByExample(exam);
    }

	/**
	* 根据name查询single表数据
	*/
	public List<SingleDO> findSingleByName(String name) {
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andNameEqualTo(name);
		return singleDAO.selectByExample(exam);
	}

	/**
	* 根据username查询single表数据
	*/
	public List<SingleDO> findSingleByUsername(String username) {
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andUsernameEqualTo(username);
		return singleDAO.selectByExample(exam);
	}

	/**
	* 根据pName查询single表数据
	*/
	public List<SingleDO> findSingleByPName(String pName) {
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andPNameEqualTo(pName);
		return singleDAO.selectByExample(exam);
	}

	/**
	* 根据cName查询single表数据
	*/
	public List<SingleDO> findSingleByCName(String cName) {
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andCNameEqualTo(cName);
		return singleDAO.selectByExample(exam);
	}

	/**
	* 根据dNname查询single表数据
	*/
	public List<SingleDO> findSingleByDNname(String dNname) {
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andDNnameEqualTo(dNname);
		return singleDAO.selectByExample(exam);
	}

	/**
	* 根据name更新single表数据
	*/
	public void updateSingleByName(String name,SingleDO singleDO) {
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andNameEqualTo(name);
		singleDAO.updateByExample(singleDO, exam);
	}

	/**
	* 根据username更新single表数据
	*/
	public void updateSingleByUsername(String username,SingleDO singleDO) {
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andUsernameEqualTo(username);
		singleDAO.updateByExample(singleDO, exam);
	}

	/**
	* 根据pName更新single表数据
	*/
	public void updateSingleByPName(String pName,SingleDO singleDO) {
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andPNameEqualTo(pName);
		singleDAO.updateByExample(singleDO, exam);
	}

	/**
	* 根据cName更新single表数据
	*/
	public void updateSingleByCName(String cName,SingleDO singleDO) {
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andCNameEqualTo(cName);
		singleDAO.updateByExample(singleDO, exam);
	}

	/**
	* 根据dNname更新single表数据
	*/
	public void updateSingleByDNname(String dNname,SingleDO singleDO) {
		SingleDOExample exam = new SingleDOExample();
		exam.createCriteria().andDNnameEqualTo(dNname);
		singleDAO.updateByExample(singleDO, exam);
	}

    /**
	 * 断言station_channal表
	 */
	public void stationChannalAssert(
	        StationChannalDO stationChannalDO,
			String 渠道名称, 
			String 交易总金额, 
			String 收益, 
			String 油站数量
	) {
        assertEquals(渠道名称, stationChannalDO.get渠道名称());
        assertEquals(交易总金额, stationChannalDO.get交易总金额());
        assertEquals(收益, stationChannalDO.get收益());
        assertEquals(油站数量, stationChannalDO.get油站数量());
	}

	/**
	 * 断言station_channal表数据
	 */
	public void assertStationChannal(StationChannalDO expect, StationChannalDO stationChannalDO) {
		Assertions.assertEquals(expect, stationChannalDO);
	}

    /**
	 * 插入station_channal表数据
	 */
	public void insertStationChannal(StationChannalDO stationChannalDO) {
		stationChannalDAO.insert(stationChannalDO);
	}

    /**
	 * 插入station_channal表数据
	 */
	public void insertStationChannal(
			String 渠道名称, 
			String 交易总金额, 
			String 收益, 
			String 油站数量
	) {
		StationChannalDO stationChannalDO = new StationChannalDO();
		stationChannalDO.set渠道名称(渠道名称);
		stationChannalDO.set交易总金额(交易总金额);
		stationChannalDO.set收益(收益);
		stationChannalDO.set油站数量(油站数量);
		stationChannalDAO.insert(stationChannalDO);
	}

    /**
     * 删除station_channal表所有数据
     */
    public void cleanStationChannal() {
        StationChannalDOExample exam = new StationChannalDOExample();
        exam.createCriteria();
        stationChannalDAO.deleteByExample(exam);
    }


    /**
     * 查询station_channal表所有数据
     */
    public List<StationChannalDO> findStationChannalAll() {
        StationChannalDOExample exam = new StationChannalDOExample();
        exam.createCriteria();
		return stationChannalDAO.selectByExample(exam);
    }

    /**
	 * 断言sys_id_gen表
	 */
	public void sysIdGenAssert(
	        SysIdGenDO sysIdGenDO,
			Long identity, 
			Date rawUpdateTime
	) {
        assertEquals(identity, sysIdGenDO.getIdentity());
        assertEquals(rawUpdateTime, sysIdGenDO.getRawUpdateTime());
	}

	/**
	 * 断言sys_id_gen表数据
	 */
	public void assertSysIdGen(SysIdGenDO expect, SysIdGenDO sysIdGenDO) {
        Assertions.assertTrue(null != sysIdGenDO.getRawUpdateTime());
		expect.setRawUpdateTime(sysIdGenDO.getRawUpdateTime());
		Assertions.assertEquals(expect, sysIdGenDO);
	}

    /**
	 * 插入sys_id_gen表数据
	 */
	public void insertSysIdGen(SysIdGenDO sysIdGenDO) {
		sysIdGenDAO.insert(sysIdGenDO);
	}

    /**
	 * 插入sys_id_gen表数据
	 */
	public void insertSysIdGen(
			Long identity, 
			Date rawUpdateTime
	) {
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		SysIdGenDO sysIdGenDO = new SysIdGenDO();
		sysIdGenDO.setIdentity(identity);
		sysIdGenDO.setRawUpdateTime(rawUpdateTime);
		sysIdGenDAO.insert(sysIdGenDO);
	}

    /**
     * 删除sys_id_gen表所有数据
     */
    public void cleanSysIdGen() {
        SysIdGenDOExample exam = new SysIdGenDOExample();
        exam.createCriteria();
        sysIdGenDAO.deleteByExample(exam);
    }


	/**
	 * 根据identity删除sys_id_gen表数据
	 */
	public void cleanSysIdGenByIdentity(Long identity) {
		SysIdGenDOExample exam = new SysIdGenDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		sysIdGenDAO.deleteByExample(exam);
	}

    /**
     * 查询sys_id_gen表所有数据
     */
    public List<SysIdGenDO> findSysIdGenAll() {
        SysIdGenDOExample exam = new SysIdGenDOExample();
        exam.createCriteria();
		return sysIdGenDAO.selectByExample(exam);
    }

    /**
	 * 根据identity查询sys_id_gen表数据
	 */
	public List<SysIdGenDO> findSysIdGenByIdentity(Long identity) {
		SysIdGenDOExample exam = new SysIdGenDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		return sysIdGenDAO.selectByExample(exam);
	}

    /**
	 * 根据identity更新sys_id_gen表数据
	 */
	public void updateSysIdGenByIdentity(Long identity,SysIdGenDO sysIdGenDO) {
		SysIdGenDOExample exam = new SysIdGenDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		sysIdGenDAO.updateByExample(sysIdGenDO, exam);
	}

    /**
	 * 断言sys_seq表
	 */
	public void sysSeqAssert(
	        SysSeqDO sysSeqDO,
			Long identity, 
			String seqName
	) {
        assertEquals(identity, sysSeqDO.getIdentity());
        assertEquals(seqName, sysSeqDO.getSeqName());
	}

	/**
	 * 断言sys_seq表数据
	 */
	public void assertSysSeq(SysSeqDO expect, SysSeqDO sysSeqDO) {
		Assertions.assertEquals(expect, sysSeqDO);
	}

    /**
	 * 插入sys_seq表数据
	 */
	public void insertSysSeq(SysSeqDO sysSeqDO) {
		sysSeqDAO.insert(sysSeqDO);
	}

    /**
	 * 插入sys_seq表数据
	 */
	public void insertSysSeq(
			Long identity, 
			String seqName
	) {
		SysSeqDO sysSeqDO = new SysSeqDO();
		sysSeqDO.setIdentity(identity);
		sysSeqDO.setSeqName(seqName);
		sysSeqDAO.insert(sysSeqDO);
	}

    /**
     * 删除sys_seq表所有数据
     */
    public void cleanSysSeq() {
        SysSeqDOExample exam = new SysSeqDOExample();
        exam.createCriteria();
        sysSeqDAO.deleteByExample(exam);
    }


	/**
	 * 根据identity删除sys_seq表数据
	 */
	public void cleanSysSeqByIdentity(Long identity) {
		SysSeqDOExample exam = new SysSeqDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		sysSeqDAO.deleteByExample(exam);
	}

	/**
	* 根据seqName删除sys_seq表数据
	*/
	public void cleanSysSeqBySeqName(String seqName) {
        if (StringUtils.isBlank(seqName)){
            seqName = "test_seqName";
        }
		SysSeqDOExample exam = new SysSeqDOExample();
		exam.createCriteria().andSeqNameEqualTo(seqName);
		sysSeqDAO.deleteByExample(exam);
	}

    /**
     * 查询sys_seq表所有数据
     */
    public List<SysSeqDO> findSysSeqAll() {
        SysSeqDOExample exam = new SysSeqDOExample();
        exam.createCriteria();
		return sysSeqDAO.selectByExample(exam);
    }

    /**
	 * 根据identity查询sys_seq表数据
	 */
	public List<SysSeqDO> findSysSeqByIdentity(Long identity) {
		SysSeqDOExample exam = new SysSeqDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		return sysSeqDAO.selectByExample(exam);
	}

	/**
	* 根据seqName查询sys_seq表数据
	*/
	public List<SysSeqDO> findSysSeqBySeqName(String seqName) {
		SysSeqDOExample exam = new SysSeqDOExample();
		exam.createCriteria().andSeqNameEqualTo(seqName);
		return sysSeqDAO.selectByExample(exam);
	}

    /**
	 * 根据identity更新sys_seq表数据
	 */
	public void updateSysSeqByIdentity(Long identity,SysSeqDO sysSeqDO) {
		SysSeqDOExample exam = new SysSeqDOExample();
		exam.createCriteria().andIdentityEqualTo(identity);
		sysSeqDAO.updateByExample(sysSeqDO, exam);
	}

	/**
	* 根据seqName更新sys_seq表数据
	*/
	public void updateSysSeqBySeqName(String seqName,SysSeqDO sysSeqDO) {
		SysSeqDOExample exam = new SysSeqDOExample();
		exam.createCriteria().andSeqNameEqualTo(seqName);
		sysSeqDAO.updateByExample(sysSeqDO, exam);
	}

    /**
	 * 断言t_order表
	 */
	public void tOrderAssert(
	        TOrderDO tOrderDO,
			Long orderId, 
			Integer userId, 
			String status
	) {
        assertEquals(orderId, tOrderDO.getOrderId());
        assertEquals(userId, tOrderDO.getUserId());
        assertEquals(status, tOrderDO.getStatus());
	}

	/**
	 * 断言t_order表数据
	 */
	public void assertTOrder(TOrderDO expect, TOrderDO tOrderDO) {
		Assertions.assertEquals(expect, tOrderDO);
	}

    /**
	 * 插入t_order表数据
	 */
	public void insertTOrder(TOrderDO tOrderDO) {
		tOrderDAO.insert(tOrderDO);
	}

    /**
	 * 插入t_order表数据
	 */
	public void insertTOrder(
			Long orderId, 
			Integer userId, 
			String status
	) {
		TOrderDO tOrderDO = new TOrderDO();
		tOrderDO.setOrderId(orderId);
		tOrderDO.setUserId(userId);
		tOrderDO.setStatus(status);
		tOrderDAO.insert(tOrderDO);
	}

    /**
     * 删除t_order表所有数据
     */
    public void cleanTOrder() {
        TOrderDOExample exam = new TOrderDOExample();
        exam.createCriteria();
        tOrderDAO.deleteByExample(exam);
    }


	/**
	 * 根据orderId删除t_order表数据
	 */
	public void cleanTOrderByOrderId(Long orderId) {
		TOrderDOExample exam = new TOrderDOExample();
		exam.createCriteria().andOrderIdEqualTo(orderId);
		tOrderDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除t_order表数据
	 */
	public void cleanTOrderByUserId(Integer userId) {
		TOrderDOExample exam = new TOrderDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		tOrderDAO.deleteByExample(exam);
	}

    /**
     * 查询t_order表所有数据
     */
    public List<TOrderDO> findTOrderAll() {
        TOrderDOExample exam = new TOrderDOExample();
        exam.createCriteria();
		return tOrderDAO.selectByExample(exam);
    }

    /**
	 * 根据orderId查询t_order表数据
	 */
	public List<TOrderDO> findTOrderByOrderId(Long orderId) {
		TOrderDOExample exam = new TOrderDOExample();
		exam.createCriteria().andOrderIdEqualTo(orderId);
		return tOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询t_order表数据
	 */
	public List<TOrderDO> findTOrderByUserId(Integer userId) {
		TOrderDOExample exam = new TOrderDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return tOrderDAO.selectByExample(exam);
	}

    /**
	 * 根据orderId更新t_order表数据
	 */
	public void updateTOrderByOrderId(Long orderId,TOrderDO tOrderDO) {
		TOrderDOExample exam = new TOrderDOExample();
		exam.createCriteria().andOrderIdEqualTo(orderId);
		tOrderDAO.updateByExample(tOrderDO, exam);
	}

    /**
	 * 根据userId更新t_order表数据
	 */
	public void updateTOrderByUserId(Integer userId,TOrderDO tOrderDO) {
		TOrderDOExample exam = new TOrderDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		tOrderDAO.updateByExample(tOrderDO, exam);
	}

    /**
	 * 断言t_order_item表
	 */
	public void tOrderItemAssert(
	        TOrderItemDO tOrderItemDO,
			Long orderItemId, 
			Long orderId, 
			Integer userId
	) {
        assertEquals(orderItemId, tOrderItemDO.getOrderItemId());
        assertEquals(orderId, tOrderItemDO.getOrderId());
        assertEquals(userId, tOrderItemDO.getUserId());
	}

	/**
	 * 断言t_order_item表数据
	 */
	public void assertTOrderItem(TOrderItemDO expect, TOrderItemDO tOrderItemDO) {
		Assertions.assertEquals(expect, tOrderItemDO);
	}

    /**
	 * 插入t_order_item表数据
	 */
	public void insertTOrderItem(TOrderItemDO tOrderItemDO) {
		tOrderItemDAO.insert(tOrderItemDO);
	}

    /**
	 * 插入t_order_item表数据
	 */
	public void insertTOrderItem(
			Long orderItemId, 
			Long orderId, 
			Integer userId
	) {
		TOrderItemDO tOrderItemDO = new TOrderItemDO();
		tOrderItemDO.setOrderItemId(orderItemId);
		tOrderItemDO.setOrderId(orderId);
		tOrderItemDO.setUserId(userId);
		tOrderItemDAO.insert(tOrderItemDO);
	}

    /**
     * 删除t_order_item表所有数据
     */
    public void cleanTOrderItem() {
        TOrderItemDOExample exam = new TOrderItemDOExample();
        exam.createCriteria();
        tOrderItemDAO.deleteByExample(exam);
    }


	/**
	 * 根据orderItemId删除t_order_item表数据
	 */
	public void cleanTOrderItemByOrderItemId(Long orderItemId) {
		TOrderItemDOExample exam = new TOrderItemDOExample();
		exam.createCriteria().andOrderItemIdEqualTo(orderItemId);
		tOrderItemDAO.deleteByExample(exam);
	}

	/**
	 * 根据orderId删除t_order_item表数据
	 */
	public void cleanTOrderItemByOrderId(Long orderId) {
		TOrderItemDOExample exam = new TOrderItemDOExample();
		exam.createCriteria().andOrderIdEqualTo(orderId);
		tOrderItemDAO.deleteByExample(exam);
	}

	/**
	 * 根据userId删除t_order_item表数据
	 */
	public void cleanTOrderItemByUserId(Integer userId) {
		TOrderItemDOExample exam = new TOrderItemDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		tOrderItemDAO.deleteByExample(exam);
	}

    /**
     * 查询t_order_item表所有数据
     */
    public List<TOrderItemDO> findTOrderItemAll() {
        TOrderItemDOExample exam = new TOrderItemDOExample();
        exam.createCriteria();
		return tOrderItemDAO.selectByExample(exam);
    }

    /**
	 * 根据orderItemId查询t_order_item表数据
	 */
	public List<TOrderItemDO> findTOrderItemByOrderItemId(Long orderItemId) {
		TOrderItemDOExample exam = new TOrderItemDOExample();
		exam.createCriteria().andOrderItemIdEqualTo(orderItemId);
		return tOrderItemDAO.selectByExample(exam);
	}

    /**
	 * 根据orderId查询t_order_item表数据
	 */
	public List<TOrderItemDO> findTOrderItemByOrderId(Long orderId) {
		TOrderItemDOExample exam = new TOrderItemDOExample();
		exam.createCriteria().andOrderIdEqualTo(orderId);
		return tOrderItemDAO.selectByExample(exam);
	}

    /**
	 * 根据userId查询t_order_item表数据
	 */
	public List<TOrderItemDO> findTOrderItemByUserId(Integer userId) {
		TOrderItemDOExample exam = new TOrderItemDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		return tOrderItemDAO.selectByExample(exam);
	}

    /**
	 * 根据orderItemId更新t_order_item表数据
	 */
	public void updateTOrderItemByOrderItemId(Long orderItemId,TOrderItemDO tOrderItemDO) {
		TOrderItemDOExample exam = new TOrderItemDOExample();
		exam.createCriteria().andOrderItemIdEqualTo(orderItemId);
		tOrderItemDAO.updateByExample(tOrderItemDO, exam);
	}

    /**
	 * 根据orderId更新t_order_item表数据
	 */
	public void updateTOrderItemByOrderId(Long orderId,TOrderItemDO tOrderItemDO) {
		TOrderItemDOExample exam = new TOrderItemDOExample();
		exam.createCriteria().andOrderIdEqualTo(orderId);
		tOrderItemDAO.updateByExample(tOrderItemDO, exam);
	}

    /**
	 * 根据userId更新t_order_item表数据
	 */
	public void updateTOrderItemByUserId(Integer userId,TOrderItemDO tOrderItemDO) {
		TOrderItemDOExample exam = new TOrderItemDOExample();
		exam.createCriteria().andUserIdEqualTo(userId);
		tOrderItemDAO.updateByExample(tOrderItemDO, exam);
	}

    /**
	 * 断言tmp_points_goods_map表
	 */
	public void tmpPointsGoodsMapAssert(
	        TmpPointsGoodsMapDO tmpPointsGoodsMapDO,
			String oldPointsGoodsId, 
			String newPointsGoodsId, 
			String goodsType
	) {
        assertEquals(oldPointsGoodsId, tmpPointsGoodsMapDO.getOldPointsGoodsId());
        assertEquals(newPointsGoodsId, tmpPointsGoodsMapDO.getNewPointsGoodsId());
        assertEquals(goodsType, tmpPointsGoodsMapDO.getGoodsType());
	}

	/**
	 * 断言tmp_points_goods_map表数据
	 */
	public void assertTmpPointsGoodsMap(TmpPointsGoodsMapDO expect, TmpPointsGoodsMapDO tmpPointsGoodsMapDO) {
		Assertions.assertEquals(expect, tmpPointsGoodsMapDO);
	}

    /**
	 * 插入tmp_points_goods_map表数据
	 */
	public void insertTmpPointsGoodsMap(TmpPointsGoodsMapDO tmpPointsGoodsMapDO) {
		tmpPointsGoodsMapDAO.insert(tmpPointsGoodsMapDO);
	}

    /**
	 * 插入tmp_points_goods_map表数据
	 */
	public void insertTmpPointsGoodsMap(
			String oldPointsGoodsId, 
			String newPointsGoodsId, 
			String goodsType
	) {
		TmpPointsGoodsMapDO tmpPointsGoodsMapDO = new TmpPointsGoodsMapDO();
		tmpPointsGoodsMapDO.setOldPointsGoodsId(oldPointsGoodsId);
		tmpPointsGoodsMapDO.setNewPointsGoodsId(newPointsGoodsId);
		tmpPointsGoodsMapDO.setGoodsType(goodsType);
		tmpPointsGoodsMapDAO.insert(tmpPointsGoodsMapDO);
	}

    /**
     * 删除tmp_points_goods_map表所有数据
     */
    public void cleanTmpPointsGoodsMap() {
        TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
        exam.createCriteria();
        tmpPointsGoodsMapDAO.deleteByExample(exam);
    }


	/**
	 * 根据oldPointsGoodsId删除tmp_points_goods_map表数据
	 */
	public void cleanTmpPointsGoodsMapByOldPointsGoodsId(String oldPointsGoodsId) {
        if (StringUtils.isBlank(oldPointsGoodsId)){
            oldPointsGoodsId = "test_oldPointsGoodsId";
        }
		TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
		exam.createCriteria().andOldPointsGoodsIdEqualTo(oldPointsGoodsId);
		tmpPointsGoodsMapDAO.deleteByExample(exam);
	}

	/**
	 * 根据newPointsGoodsId删除tmp_points_goods_map表数据
	 */
	public void cleanTmpPointsGoodsMapByNewPointsGoodsId(String newPointsGoodsId) {
        if (StringUtils.isBlank(newPointsGoodsId)){
            newPointsGoodsId = "test_newPointsGoodsId";
        }
		TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
		exam.createCriteria().andNewPointsGoodsIdEqualTo(newPointsGoodsId);
		tmpPointsGoodsMapDAO.deleteByExample(exam);
	}

    /**
     * 查询tmp_points_goods_map表所有数据
     */
    public List<TmpPointsGoodsMapDO> findTmpPointsGoodsMapAll() {
        TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
        exam.createCriteria();
		return tmpPointsGoodsMapDAO.selectByExample(exam);
    }

    /**
	 * 根据oldPointsGoodsId查询tmp_points_goods_map表数据
	 */
	public List<TmpPointsGoodsMapDO> findTmpPointsGoodsMapByOldPointsGoodsId(String oldPointsGoodsId) {
		TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
		exam.createCriteria().andOldPointsGoodsIdEqualTo(oldPointsGoodsId);
		return tmpPointsGoodsMapDAO.selectByExample(exam);
	}

    /**
	 * 根据newPointsGoodsId查询tmp_points_goods_map表数据
	 */
	public List<TmpPointsGoodsMapDO> findTmpPointsGoodsMapByNewPointsGoodsId(String newPointsGoodsId) {
		TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
		exam.createCriteria().andNewPointsGoodsIdEqualTo(newPointsGoodsId);
		return tmpPointsGoodsMapDAO.selectByExample(exam);
	}

    /**
	 * 根据oldPointsGoodsId更新tmp_points_goods_map表数据
	 */
	public void updateTmpPointsGoodsMapByOldPointsGoodsId(String oldPointsGoodsId,TmpPointsGoodsMapDO tmpPointsGoodsMapDO) {
		TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
		exam.createCriteria().andOldPointsGoodsIdEqualTo(oldPointsGoodsId);
		tmpPointsGoodsMapDAO.updateByExample(tmpPointsGoodsMapDO, exam);
	}

    /**
	 * 根据newPointsGoodsId更新tmp_points_goods_map表数据
	 */
	public void updateTmpPointsGoodsMapByNewPointsGoodsId(String newPointsGoodsId,TmpPointsGoodsMapDO tmpPointsGoodsMapDO) {
		TmpPointsGoodsMapDOExample exam = new TmpPointsGoodsMapDOExample();
		exam.createCriteria().andNewPointsGoodsIdEqualTo(newPointsGoodsId);
		tmpPointsGoodsMapDAO.updateByExample(tmpPointsGoodsMapDO, exam);
	}
}
