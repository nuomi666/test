package com.xjy.autotest.testbase;

import java.util.List;
import java.util.Date;
import com.xjy.autotest.utils.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Import;
import com.xyb.adk.common.util.money.Money;
import java.math.BigDecimal;
import dal.dao.merchant.*;
import dal.model.merchant.*;
import com.xjy.autotest.config.MerchantDataSourceConfig;

/**
 * @author autotest
 * Created on 2019/07/19.
 */
@Service
@Import({
        MerchantDataSourceConfig.class
})
public class MerchantTestBase {

	@Autowired
	MerchantDAO merchantDAO;

	@Autowired
	MerchantImgDAO merchantImgDAO;

	public MerchantDAO getMerchantDAO() {
		return this.merchantDAO;
	}

	public MerchantImgDAO getMerchantImgDAO() {
		return this.merchantImgDAO;
	}


	/**
	 * 断言merchant表数据
	 */
	public void assertMerchant(MerchantDO expect, MerchantDO merchantDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantDO.getRawAddTime());
		expect.setRawAddTime(merchantDO.getRawAddTime());
        Assertions.assertTrue(null != merchantDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantDO);
	}

    /**
	 * 插入merchant表数据
	 */
	public void insertMerchant(MerchantDO merchantDO) {
		merchantDAO.insert(merchantDO);
	}

    /**
	 * 插入merchant表数据
	 */
	public void insertMerchant(
			long id, 
			String partnerId, 
			String parentPartnerId, 
			String outUserId, 
			String merchantName, 
			String merchantType, 
			String status, 
			String leadStatus, 
			String appId, 
			String appRefreshToken, 
			String channelId, 
			Date rawAddTime, 
			Date rawUpdateTime
	) {
		if (rawAddTime == null) {
			rawAddTime = new Date();
		}
		if (rawUpdateTime == null) {
			rawUpdateTime = new Date();
		}
		MerchantDO merchantDO = new MerchantDO();
		merchantDO.setId(id);
		merchantDO.setPartnerId(partnerId);
		merchantDO.setParentPartnerId(parentPartnerId);
		merchantDO.setOutUserId(outUserId);
		merchantDO.setMerchantName(merchantName);
		merchantDO.setMerchantType(merchantType);
		merchantDO.setStatus(status);
		merchantDO.setLeadStatus(leadStatus);
		merchantDO.setAppId(appId);
		merchantDO.setAppRefreshToken(appRefreshToken);
		merchantDO.setChannelId(channelId);
		merchantDO.setRawAddTime(rawAddTime);
		merchantDO.setRawUpdateTime(rawUpdateTime);
		merchantDAO.insert(merchantDO);
	}

    /**
     * 删除merchant表所有数据
     */
    public void cleanMerchant() {
        MerchantDOExample exam = new MerchantDOExample();
        exam.createCriteria();
        merchantDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant表数据
	 */
	public void cleanMerchantById(long id) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除merchant表数据
	 */
	public void cleanMerchantByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantDAO.deleteByExample(exam);
	}
	/**
	 * 根据parentPartnerId,id删除merchant表数据
	 */
	public void cleanMerchantByParentPartnerIdAndId(String parentPartnerId,long id) {
        if (StringUtils.isBlank(parentPartnerId)){
            parentPartnerId = "test_parentPartnerId";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId).andIdEqualTo(id);
		merchantDAO.deleteByExample(exam);
	}
	/**
	 * 根据parentPartnerId,outUserId删除merchant表数据
	 */
	public void cleanMerchantByParentPartnerIdAndOutUserId(String parentPartnerId,String outUserId) {
        if (StringUtils.isBlank(parentPartnerId)){
            parentPartnerId = "test_parentPartnerId";
        }
        if (StringUtils.isBlank(outUserId)){
            outUserId = "test_outUserId";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId).andOutUserIdEqualTo(outUserId);
		merchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据parentPartnerId删除merchant表数据
	 */
	public void cleanMerchantByParentPartnerId(String parentPartnerId) {
        if (StringUtils.isBlank(parentPartnerId)){
            parentPartnerId = "test_parentPartnerId";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId);
		merchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据outUserId删除merchant表数据
	 */
	public void cleanMerchantByOutUserId(String outUserId) {
        if (StringUtils.isBlank(outUserId)){
            outUserId = "test_outUserId";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andOutUserIdEqualTo(outUserId);
		merchantDAO.deleteByExample(exam);
	}

	/**
	* 根据merchantName删除merchant表数据
	*/
	public void cleanMerchantByMerchantName(String merchantName) {
        if (StringUtils.isBlank(merchantName)){
            merchantName = "test_merchantName";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andMerchantNameEqualTo(merchantName);
		merchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据appId删除merchant表数据
	 */
	public void cleanMerchantByAppId(String appId) {
        if (StringUtils.isBlank(appId)){
            appId = "test_appId";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andAppIdEqualTo(appId);
		merchantDAO.deleteByExample(exam);
	}

	/**
	 * 根据channelId删除merchant表数据
	 */
	public void cleanMerchantByChannelId(String channelId) {
        if (StringUtils.isBlank(channelId)){
            channelId = "test_channelId";
        }
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		merchantDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant表所有数据
     */
    public List<MerchantDO> findMerchantAll() {
        MerchantDOExample exam = new MerchantDOExample();
        exam.createCriteria();
		return merchantDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant表数据
	 */
	public List<MerchantDO> findMerchantById(long id) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询merchant表数据
	 */
	public List<MerchantDO> findMerchantByPartnerId(String partnerId) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return merchantDAO.selectByExample(exam);
	}

	/**
	 * 根据parentPartnerId,id查询merchant表数据
	 */
	public List<MerchantDO> findMerchantByParentPartnerIdAndId(String parentPartnerId,long id) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId).andIdEqualTo(id);
		return merchantDAO.selectByExample(exam);
	}

	/**
	 * 根据parentPartnerId,outUserId查询merchant表数据
	 */
	public List<MerchantDO> findMerchantByParentPartnerIdAndOutUserId(String parentPartnerId,String outUserId) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId).andOutUserIdEqualTo(outUserId);
		return merchantDAO.selectByExample(exam);
	}

    /**
	 * 根据parentPartnerId查询merchant表数据
	 */
	public List<MerchantDO> findMerchantByParentPartnerId(String parentPartnerId) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId);
		return merchantDAO.selectByExample(exam);
	}

    /**
	 * 根据outUserId查询merchant表数据
	 */
	public List<MerchantDO> findMerchantByOutUserId(String outUserId) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andOutUserIdEqualTo(outUserId);
		return merchantDAO.selectByExample(exam);
	}

	/**
	* 根据merchantName查询merchant表数据
	*/
	public List<MerchantDO> findMerchantByMerchantName(String merchantName) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andMerchantNameEqualTo(merchantName);
		return merchantDAO.selectByExample(exam);
	}

    /**
	 * 根据appId查询merchant表数据
	 */
	public List<MerchantDO> findMerchantByAppId(String appId) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andAppIdEqualTo(appId);
		return merchantDAO.selectByExample(exam);
	}

    /**
	 * 根据channelId查询merchant表数据
	 */
	public List<MerchantDO> findMerchantByChannelId(String channelId) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		return merchantDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant表数据
	 */
	public void updateMerchantById(long id,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantDAO.updateByExample(merchantDO, exam);
	}

    /**
	 * 根据partnerId更新merchant表数据
	 */
	public void updateMerchantByPartnerId(String partnerId,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantDAO.updateByExample(merchantDO, exam);
	}

	/**
	 * 根据parentPartnerId,id更新merchant表数据
	 */
	public void updateMerchantByParentPartnerIdAndId(String parentPartnerId,long id,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId).andIdEqualTo(id);
		merchantDAO.updateByExample(merchantDO, exam);
	}

	/**
	 * 根据parentPartnerId,outUserId更新merchant表数据
	 */
	public void updateMerchantByParentPartnerIdAndOutUserId(String parentPartnerId,String outUserId,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId).andOutUserIdEqualTo(outUserId);
		merchantDAO.updateByExample(merchantDO, exam);
	}

    /**
	 * 根据parentPartnerId更新merchant表数据
	 */
	public void updateMerchantByParentPartnerId(String parentPartnerId,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andParentPartnerIdEqualTo(parentPartnerId);
		merchantDAO.updateByExample(merchantDO, exam);
	}

    /**
	 * 根据outUserId更新merchant表数据
	 */
	public void updateMerchantByOutUserId(String outUserId,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andOutUserIdEqualTo(outUserId);
		merchantDAO.updateByExample(merchantDO, exam);
	}

	/**
	* 根据merchantName更新merchant表数据
	*/
	public void updateMerchantByMerchantName(String merchantName,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andMerchantNameEqualTo(merchantName);
		merchantDAO.updateByExample(merchantDO, exam);
	}

    /**
	 * 根据appId更新merchant表数据
	 */
	public void updateMerchantByAppId(String appId,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andAppIdEqualTo(appId);
		merchantDAO.updateByExample(merchantDO, exam);
	}

    /**
	 * 根据channelId更新merchant表数据
	 */
	public void updateMerchantByChannelId(String channelId,MerchantDO merchantDO) {
		MerchantDOExample exam = new MerchantDOExample();
		exam.createCriteria().andChannelIdEqualTo(channelId);
		merchantDAO.updateByExample(merchantDO, exam);
	}

	/**
	 * 断言merchant_img表数据
	 */
	public void assertMerchantImg(MerchantImgDO expect, MerchantImgDO merchantImgDO) {
		if (null == expect.getId() || 0L == expect.getId()) {
			merchantImgDO.setId(expect.getId());
		}
		Assertions.assertTrue(null != merchantImgDO.getRawAddTime());
		expect.setRawAddTime(merchantImgDO.getRawAddTime());
        Assertions.assertTrue(null != merchantImgDO.getRawUpdateTime());
		expect.setRawUpdateTime(merchantImgDO.getRawUpdateTime());
		Assertions.assertEquals(expect, merchantImgDO);
	}

    /**
	 * 插入merchant_img表数据
	 */
	public void insertMerchantImg(MerchantImgDO merchantImgDO) {
		merchantImgDAO.insert(merchantImgDO);
	}

    /**
	 * 插入merchant_img表数据
	 */
	public void insertMerchantImg(
			long id, 
			String partnerId, 
			String businessLicenseUrl, 
			String organizationCodeUrl, 
			String taxCertificateUrl, 
			String bankSettlementUrl, 
			String legalCerificateFrontUrl, 
			String legalCerificateBackUrl, 
			String oldBusinessLicenseUrl, 
			String oldOrganizationCodeUrl, 
			String oldTaxCertificateUrl, 
			String oldBankSettlementUrl, 
			String oldLegalCerificateFrontUrl, 
			String oldLegalCerificateBackUrl, 
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
		MerchantImgDO merchantImgDO = new MerchantImgDO();
		merchantImgDO.setId(id);
		merchantImgDO.setPartnerId(partnerId);
		merchantImgDO.setBusinessLicenseUrl(businessLicenseUrl);
		merchantImgDO.setOrganizationCodeUrl(organizationCodeUrl);
		merchantImgDO.setTaxCertificateUrl(taxCertificateUrl);
		merchantImgDO.setBankSettlementUrl(bankSettlementUrl);
		merchantImgDO.setLegalCerificateFrontUrl(legalCerificateFrontUrl);
		merchantImgDO.setLegalCerificateBackUrl(legalCerificateBackUrl);
		merchantImgDO.setOldBusinessLicenseUrl(oldBusinessLicenseUrl);
		merchantImgDO.setOldOrganizationCodeUrl(oldOrganizationCodeUrl);
		merchantImgDO.setOldTaxCertificateUrl(oldTaxCertificateUrl);
		merchantImgDO.setOldBankSettlementUrl(oldBankSettlementUrl);
		merchantImgDO.setOldLegalCerificateFrontUrl(oldLegalCerificateFrontUrl);
		merchantImgDO.setOldLegalCerificateBackUrl(oldLegalCerificateBackUrl);
		merchantImgDO.setStatus(status);
		merchantImgDO.setRawAddTime(rawAddTime);
		merchantImgDO.setRawUpdateTime(rawUpdateTime);
		merchantImgDAO.insert(merchantImgDO);
	}

    /**
     * 删除merchant_img表所有数据
     */
    public void cleanMerchantImg() {
        MerchantImgDOExample exam = new MerchantImgDOExample();
        exam.createCriteria();
        merchantImgDAO.deleteByExample(exam);
    }


	/**
	 * 根据id删除merchant_img表数据
	 */
	public void cleanMerchantImgById(long id) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantImgDAO.deleteByExample(exam);
	}

	/**
	 * 根据partnerId删除merchant_img表数据
	 */
	public void cleanMerchantImgByPartnerId(String partnerId) {
        if (StringUtils.isBlank(partnerId)){
            partnerId = "test_partnerId";
        }
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantImgDAO.deleteByExample(exam);
	}

	/**
	* 根据organizationCodeUrl删除merchant_img表数据
	*/
	public void cleanMerchantImgByOrganizationCodeUrl(String organizationCodeUrl) {
        if (StringUtils.isBlank(organizationCodeUrl)){
            organizationCodeUrl = "test_organizationCodeUrl";
        }
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andOrganizationCodeUrlEqualTo(organizationCodeUrl);
		merchantImgDAO.deleteByExample(exam);
	}

	/**
	* 根据oldOrganizationCodeUrl删除merchant_img表数据
	*/
	public void cleanMerchantImgByOldOrganizationCodeUrl(String oldOrganizationCodeUrl) {
        if (StringUtils.isBlank(oldOrganizationCodeUrl)){
            oldOrganizationCodeUrl = "test_oldOrganizationCodeUrl";
        }
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andOldOrganizationCodeUrlEqualTo(oldOrganizationCodeUrl);
		merchantImgDAO.deleteByExample(exam);
	}

    /**
     * 查询merchant_img表所有数据
     */
    public List<MerchantImgDO> findMerchantImgAll() {
        MerchantImgDOExample exam = new MerchantImgDOExample();
        exam.createCriteria();
		return merchantImgDAO.selectByExample(exam);
    }

    /**
	 * 根据id查询merchant_img表数据
	 */
	public List<MerchantImgDO> findMerchantImgById(long id) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andIdEqualTo(id);
		return merchantImgDAO.selectByExample(exam);
	}

    /**
	 * 根据partnerId查询merchant_img表数据
	 */
	public List<MerchantImgDO> findMerchantImgByPartnerId(String partnerId) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		return merchantImgDAO.selectByExample(exam);
	}

	/**
	* 根据organizationCodeUrl查询merchant_img表数据
	*/
	public List<MerchantImgDO> findMerchantImgByOrganizationCodeUrl(String organizationCodeUrl) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andOrganizationCodeUrlEqualTo(organizationCodeUrl);
		return merchantImgDAO.selectByExample(exam);
	}

	/**
	* 根据oldOrganizationCodeUrl查询merchant_img表数据
	*/
	public List<MerchantImgDO> findMerchantImgByOldOrganizationCodeUrl(String oldOrganizationCodeUrl) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andOldOrganizationCodeUrlEqualTo(oldOrganizationCodeUrl);
		return merchantImgDAO.selectByExample(exam);
	}

    /**
	 * 根据id更新merchant_img表数据
	 */
	public void updateMerchantImgById(long id,MerchantImgDO merchantImgDO) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andIdEqualTo(id);
		merchantImgDAO.updateByExample(merchantImgDO, exam);
	}

    /**
	 * 根据partnerId更新merchant_img表数据
	 */
	public void updateMerchantImgByPartnerId(String partnerId,MerchantImgDO merchantImgDO) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andPartnerIdEqualTo(partnerId);
		merchantImgDAO.updateByExample(merchantImgDO, exam);
	}

	/**
	* 根据organizationCodeUrl更新merchant_img表数据
	*/
	public void updateMerchantImgByOrganizationCodeUrl(String organizationCodeUrl,MerchantImgDO merchantImgDO) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andOrganizationCodeUrlEqualTo(organizationCodeUrl);
		merchantImgDAO.updateByExample(merchantImgDO, exam);
	}

	/**
	* 根据oldOrganizationCodeUrl更新merchant_img表数据
	*/
	public void updateMerchantImgByOldOrganizationCodeUrl(String oldOrganizationCodeUrl,MerchantImgDO merchantImgDO) {
		MerchantImgDOExample exam = new MerchantImgDOExample();
		exam.createCriteria().andOldOrganizationCodeUrlEqualTo(oldOrganizationCodeUrl);
		merchantImgDAO.updateByExample(merchantImgDO, exam);
	}
}
