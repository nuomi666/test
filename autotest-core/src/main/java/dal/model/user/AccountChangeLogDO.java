package dal.model.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "account_change_log")
public class AccountChangeLogDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 全局流水号
     */
    private String gid;

    /**
     * 外部订单号
     */
    @Column(name = "req_id")
    private String reqId;

    /**
     * 账号编号
     */
    @Column(name = "account_no")
    private String accountNo;

    /**
     * 请求余额，单位分
     */
    private Long balance;

    /**
     * 账务时间
     */
    @Column(name = "account_time")
    private Date accountTime;

    /**
     * 签约商户id
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 平台商户id
     */
    @Column(name = "plat_partner_id")
    private String platPartnerId;

    /**
     * 签约商户订单号
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    /**
     * 平台商户订单号
     */
    @Column(name = "plat_merchant_order_no")
    private String platMerchantOrderNo;

    /**
     * 账号备注
     */
    private String memo;

    /**
     * 创建时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 更新时间
     */
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
     * 获取全局流水号
     *
     * @return gid - 全局流水号
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置全局流水号
     *
     * @param gid 全局流水号
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 获取外部订单号
     *
     * @return req_id - 外部订单号
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置外部订单号
     *
     * @param reqId 外部订单号
     */
    public void setReqId(String reqId) {
        this.reqId = reqId == null ? null : reqId.trim();
    }

    /**
     * 获取账号编号
     *
     * @return account_no - 账号编号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * 设置账号编号
     *
     * @param accountNo 账号编号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * 获取请求余额，单位分
     *
     * @return balance - 请求余额，单位分
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * 设置请求余额，单位分
     *
     * @param balance 请求余额，单位分
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }

    /**
     * 获取账务时间
     *
     * @return account_time - 账务时间
     */
    public Date getAccountTime() {
        return accountTime;
    }

    /**
     * 设置账务时间
     *
     * @param accountTime 账务时间
     */
    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }

    /**
     * 获取签约商户id
     *
     * @return partner_id - 签约商户id
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置签约商户id
     *
     * @param partnerId 签约商户id
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取平台商户id
     *
     * @return plat_partner_id - 平台商户id
     */
    public String getPlatPartnerId() {
        return platPartnerId;
    }

    /**
     * 设置平台商户id
     *
     * @param platPartnerId 平台商户id
     */
    public void setPlatPartnerId(String platPartnerId) {
        this.platPartnerId = platPartnerId == null ? null : platPartnerId.trim();
    }

    /**
     * 获取签约商户订单号
     *
     * @return merchant_order_no - 签约商户订单号
     */
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    /**
     * 设置签约商户订单号
     *
     * @param merchantOrderNo 签约商户订单号
     */
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo == null ? null : merchantOrderNo.trim();
    }

    /**
     * 获取平台商户订单号
     *
     * @return plat_merchant_order_no - 平台商户订单号
     */
    public String getPlatMerchantOrderNo() {
        return platMerchantOrderNo;
    }

    /**
     * 设置平台商户订单号
     *
     * @param platMerchantOrderNo 平台商户订单号
     */
    public void setPlatMerchantOrderNo(String platMerchantOrderNo) {
        this.platMerchantOrderNo = platMerchantOrderNo == null ? null : platMerchantOrderNo.trim();
    }

    /**
     * 获取账号备注
     *
     * @return memo - 账号备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置账号备注
     *
     * @param memo 账号备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * 获取创建时间
     *
     * @return raw_add_time - 创建时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置创建时间
     *
     * @param rawAddTime 创建时间
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * 获取更新时间
     *
     * @return raw_update_time - 更新时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param rawUpdateTime 更新时间
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
        sb.append(", gid=").append(gid);
        sb.append(", reqId=").append(reqId);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", balance=").append(balance);
        sb.append(", accountTime=").append(accountTime);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", platPartnerId=").append(platPartnerId);
        sb.append(", merchantOrderNo=").append(merchantOrderNo);
        sb.append(", platMerchantOrderNo=").append(platMerchantOrderNo);
        sb.append(", memo=").append(memo);
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
        AccountChangeLogDO other = (AccountChangeLogDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getAccountTime() == null ? other.getAccountTime() == null : this.getAccountTime().equals(other.getAccountTime()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getPlatPartnerId() == null ? other.getPlatPartnerId() == null : this.getPlatPartnerId().equals(other.getPlatPartnerId()))
            && (this.getMerchantOrderNo() == null ? other.getMerchantOrderNo() == null : this.getMerchantOrderNo().equals(other.getMerchantOrderNo()))
            && (this.getPlatMerchantOrderNo() == null ? other.getPlatMerchantOrderNo() == null : this.getPlatMerchantOrderNo().equals(other.getPlatMerchantOrderNo()))
            && (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getAccountTime() == null) ? 0 : getAccountTime().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getPlatPartnerId() == null) ? 0 : getPlatPartnerId().hashCode());
        result = prime * result + ((getMerchantOrderNo() == null) ? 0 : getMerchantOrderNo().hashCode());
        result = prime * result + ((getPlatMerchantOrderNo() == null) ? 0 : getPlatMerchantOrderNo().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}