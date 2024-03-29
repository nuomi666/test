package dal.model.gas_marketpc;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "give_goods_detail")
public class GiveGoodsDetailDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 事件id
     */
    @Column(name = "event_id")
    private String eventId;

    /**
     * 赠送订单号
     */
    @Column(name = "give_biz_no")
    private String giveBizNo;

    /**
     * 全局id
     */
    private String gid;

    /**
     * 商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商ID
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 活动编号
     */
    @Column(name = "campaign_no")
    private String campaignNo;

    /**
     * 活动类型
     */
    @Column(name = "campaign_type")
    private String campaignType;

    /**
     * 活动名称
     */
    @Column(name = "campaign_name")
    private String campaignName;

    /**
     * 促销方式
     */
    @Column(name = "promotion_way")
    private String promotionWay;

    /**
     * 触发的规则id
     */
    @Column(name = "rule_id")
    private Long ruleId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 交易时用户的资金账号的标签
     */
    @Column(name = "account_tag")
    private String accountTag;

    /**
     * 会员信息
     */
    @Column(name = "market_user")
    private String marketUser;

    /**
     * 处理状态
     */
    private String status;

    /**
     * 赠送的商品编码
     */
    @Column(name = "goods_codes")
    private String goodsCodes;

    /**
     * 油站ID
     */
    @Column(name = "station_id")
    private String stationId;

    /**
     * 油站名称
     */
    @Column(name = "station_name")
    private String stationName;

    /**
     * 操作员ID
     */
    @Column(name = "operator_id")
    private String operatorId;

    /**
     * 操作员姓名
     */
    @Column(name = "operator_name")
    private String operatorName;

    /**
     * 终端类型
     */
    @Column(name = "terminal_type")
    private String terminalType;

    /**
     * 终端编码
     */
    @Column(name = "terminal_code")
    private String terminalCode;

    @Column(name = "raw_add_time")
    private Date rawAddTime;

    @Column(name = "raw_update_time")
    private Date rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取事件id
     *
     * @return event_id - 事件id
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * 设置事件id
     *
     * @param eventId 事件id
     */
    public void setEventId(String eventId) {
        this.eventId = eventId == null ? null : eventId.trim();
    }

    /**
     * 获取赠送订单号
     *
     * @return give_biz_no - 赠送订单号
     */
    public String getGiveBizNo() {
        return giveBizNo;
    }

    /**
     * 设置赠送订单号
     *
     * @param giveBizNo 赠送订单号
     */
    public void setGiveBizNo(String giveBizNo) {
        this.giveBizNo = giveBizNo == null ? null : giveBizNo.trim();
    }

    /**
     * 获取全局id
     *
     * @return gid - 全局id
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置全局id
     *
     * @param gid 全局id
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 获取商户id
     *
     * @return partner_id - 商户id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户id
     *
     * @param partnerId 商户id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取平台商ID
     *
     * @return plat_partner_id - 平台商ID
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商ID
     *
     * @param platPartnerId 平台商ID
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取活动编号
     *
     * @return campaign_no - 活动编号
     */
    public String getCampaignNo() {
        return campaignNo;
    }

    /**
     * 设置活动编号
     *
     * @param campaignNo 活动编号
     */
    public void setCampaignNo(String campaignNo) {
        this.campaignNo = campaignNo == null ? null : campaignNo.trim();
    }

    /**
     * 获取活动类型
     *
     * @return campaign_type - 活动类型
     */
    public String getCampaignType() {
        return campaignType;
    }

    /**
     * 设置活动类型
     *
     * @param campaignType 活动类型
     */
    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType == null ? null : campaignType.trim();
    }

    /**
     * 获取活动名称
     *
     * @return campaign_name - 活动名称
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * 设置活动名称
     *
     * @param campaignName 活动名称
     */
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName == null ? null : campaignName.trim();
    }

    /**
     * 获取促销方式
     *
     * @return promotion_way - 促销方式
     */
    public String getPromotionWay() {
        return promotionWay;
    }

    /**
     * 设置促销方式
     *
     * @param promotionWay 促销方式
     */
    public void setPromotionWay(String promotionWay) {
        this.promotionWay = promotionWay == null ? null : promotionWay.trim();
    }

    /**
     * 获取触发的规则id
     *
     * @return rule_id - 触发的规则id
     */
    public Long getRuleId() {
        return ruleId;
    }

    /**
     * 设置触发的规则id
     *
     * @param ruleId 触发的规则id
     */
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取交易时用户的资金账号的标签
     *
     * @return account_tag - 交易时用户的资金账号的标签
     */
    public String getAccountTag() {
        return accountTag;
    }

    /**
     * 设置交易时用户的资金账号的标签
     *
     * @param accountTag 交易时用户的资金账号的标签
     */
    public void setAccountTag(String accountTag) {
        this.accountTag = accountTag == null ? null : accountTag.trim();
    }

    /**
     * 获取会员信息
     *
     * @return market_user - 会员信息
     */
    public String getMarketUser() {
        return marketUser;
    }

    /**
     * 设置会员信息
     *
     * @param marketUser 会员信息
     */
    public void setMarketUser(String marketUser) {
        this.marketUser = marketUser == null ? null : marketUser.trim();
    }

    /**
     * 获取处理状态
     *
     * @return status - 处理状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置处理状态
     *
     * @param status 处理状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取赠送的商品编码
     *
     * @return goods_codes - 赠送的商品编码
     */
    public String getGoodsCodes() {
        return goodsCodes;
    }

    /**
     * 设置赠送的商品编码
     *
     * @param goodsCodes 赠送的商品编码
     */
    public void setGoodsCodes(String goodsCodes) {
        this.goodsCodes = goodsCodes == null ? null : goodsCodes.trim();
    }

    /**
     * 获取油站ID
     *
     * @return station_id - 油站ID
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * 设置油站ID
     *
     * @param stationId 油站ID
     */
    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
    }

    /**
     * 获取油站名称
     *
     * @return station_name - 油站名称
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * 设置油站名称
     *
     * @param stationName 油站名称
     */
    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    /**
     * 获取操作员ID
     *
     * @return operator_id - 操作员ID
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * 设置操作员ID
     *
     * @param operatorId 操作员ID
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    /**
     * 获取操作员姓名
     *
     * @return operator_name - 操作员姓名
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置操作员姓名
     *
     * @param operatorName 操作员姓名
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    /**
     * 获取终端类型
     *
     * @return terminal_type - 终端类型
     */
    public String getTerminalType() {
        return terminalType;
    }

    /**
     * 设置终端类型
     *
     * @param terminalType 终端类型
     */
    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType == null ? null : terminalType.trim();
    }

    /**
     * 获取终端编码
     *
     * @return terminal_code - 终端编码
     */
    public String getTerminalCode() {
        return terminalCode;
    }

    /**
     * 设置终端编码
     *
     * @param terminalCode 终端编码
     */
    public void setTerminalCode(String terminalCode) {
        this.terminalCode = terminalCode == null ? null : terminalCode.trim();
    }

    /**
     * @return raw_add_time
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * @param rawAddTime
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * @return raw_update_time
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * @param rawUpdateTime
     */
    public void setRawUpdateTime(Date rawUpdateTime) {
        this.rawUpdateTime = rawUpdateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", eventId=").append(eventId);
        sb.append(", giveBizNo=").append(giveBizNo);
        sb.append(", gid=").append(gid);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", campaignNo=").append(campaignNo);
        sb.append(", campaignType=").append(campaignType);
        sb.append(", campaignName=").append(campaignName);
        sb.append(", promotionWay=").append(promotionWay);
        sb.append(", ruleId=").append(ruleId);
        sb.append(", userId=").append(userId);
        sb.append(", accountTag=").append(accountTag);
        sb.append(", marketUser=").append(marketUser);
        sb.append(", status=").append(status);
        sb.append(", goodsCodes=").append(goodsCodes);
        sb.append(", stationId=").append(stationId);
        sb.append(", stationName=").append(stationName);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", operatorName=").append(operatorName);
        sb.append(", terminalType=").append(terminalType);
        sb.append(", terminalCode=").append(terminalCode);
        sb.append(", rawAddTime=").append(rawAddTime);
        sb.append(", rawUpdateTime=").append(rawUpdateTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GiveGoodsDetailDO other = (GiveGoodsDetailDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEventId() == null ? other.getEventId() == null : this.getEventId().equals(other.getEventId()))
            && (this.getGiveBizNo() == null ? other.getGiveBizNo() == null : this.getGiveBizNo().equals(other.getGiveBizNo()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getCampaignNo() == null ? other.getCampaignNo() == null : this.getCampaignNo().equals(other.getCampaignNo()))
            && (this.getCampaignType() == null ? other.getCampaignType() == null : this.getCampaignType().equals(other.getCampaignType()))
            && (this.getCampaignName() == null ? other.getCampaignName() == null : this.getCampaignName().equals(other.getCampaignName()))
            && (this.getPromotionWay() == null ? other.getPromotionWay() == null : this.getPromotionWay().equals(other.getPromotionWay()))
            && (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAccountTag() == null ? other.getAccountTag() == null : this.getAccountTag().equals(other.getAccountTag()))
            && (this.getMarketUser() == null ? other.getMarketUser() == null : this.getMarketUser().equals(other.getMarketUser()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getGoodsCodes() == null ? other.getGoodsCodes() == null : this.getGoodsCodes().equals(other.getGoodsCodes()))
            && (this.getStationId() == null ? other.getStationId() == null : this.getStationId().equals(other.getStationId()))
            && (this.getStationName() == null ? other.getStationName() == null : this.getStationName().equals(other.getStationName()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getOperatorName() == null ? other.getOperatorName() == null : this.getOperatorName().equals(other.getOperatorName()))
            && (this.getTerminalType() == null ? other.getTerminalType() == null : this.getTerminalType().equals(other.getTerminalType()))
            && (this.getTerminalCode() == null ? other.getTerminalCode() == null : this.getTerminalCode().equals(other.getTerminalCode()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEventId() == null) ? 0 : getEventId().hashCode());
        result = prime * result + ((getGiveBizNo() == null) ? 0 : getGiveBizNo().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getCampaignNo() == null) ? 0 : getCampaignNo().hashCode());
        result = prime * result + ((getCampaignType() == null) ? 0 : getCampaignType().hashCode());
        result = prime * result + ((getCampaignName() == null) ? 0 : getCampaignName().hashCode());
        result = prime * result + ((getPromotionWay() == null) ? 0 : getPromotionWay().hashCode());
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAccountTag() == null) ? 0 : getAccountTag().hashCode());
        result = prime * result + ((getMarketUser() == null) ? 0 : getMarketUser().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getGoodsCodes() == null) ? 0 : getGoodsCodes().hashCode());
        result = prime * result + ((getStationId() == null) ? 0 : getStationId().hashCode());
        result = prime * result + ((getStationName() == null) ? 0 : getStationName().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getOperatorName() == null) ? 0 : getOperatorName().hashCode());
        result = prime * result + ((getTerminalType() == null) ? 0 : getTerminalType().hashCode());
        result = prime * result + ((getTerminalCode() == null) ? 0 : getTerminalCode().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}