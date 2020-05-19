package dal.model.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_notify_task")
public class UserNotifyTaskDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 请求流水号
     */
    @Column(name = "req_id")
    private String reqId;

    /**
     * 统一流水id
     */
    private String gid;

    /**
     * 商户号
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 推送状态
     */
    private String status;

    /**
     * 通知模式-dubbo,http
     */
    @Column(name = "notify_category")
    private String notifyCategory;

    /**
     * 通知类型-根据业务定义的类型
     */
    @Column(name = "notify_type")
    private String notifyType;

    /**
     * 重试次数
     */
    @Column(name = "retry_count")
    private Integer retryCount;

    /**
     * 最大重试次数
     */
    @Column(name = "max_retry_count")
    private Integer maxRetryCount;

    /**
     * 回调分组名称
     */
    @Column(name = "notify_group")
    private String notifyGroup;

    /**
     * 回调版本号
     */
    @Column(name = "notify_version")
    private String notifyVersion;

    /**
     * http回调地址
     */
    @Column(name = "notify_url")
    private String notifyUrl;

    /**
     * 描述
     */
    private String detail;

    /**
     * 创建时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 修改时间
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
     * 获取请求流水号
     *
     * @return req_id - 请求流水号
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 设置请求流水号
     *
     * @param reqId 请求流水号
     */
    public void setReqId(String reqId) {
        this.reqId = reqId == null ? null : reqId.trim();
    }

    /**
     * 获取统一流水id
     *
     * @return gid - 统一流水id
     */
    public String getGid() {
        return gid;
    }

    /**
     * 设置统一流水id
     *
     * @param gid 统一流水id
     */
    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    /**
     * 获取商户号
     *
     * @return partner_id - 商户号
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商户号
     *
     * @param partnerId 商户号
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取推送状态
     *
     * @return status - 推送状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置推送状态
     *
     * @param status 推送状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取通知模式-dubbo,http
     *
     * @return notify_category - 通知模式-dubbo,http
     */
    public String getNotifyCategory() {
        return notifyCategory;
    }

    /**
     * 设置通知模式-dubbo,http
     *
     * @param notifyCategory 通知模式-dubbo,http
     */
    public void setNotifyCategory(String notifyCategory) {
        this.notifyCategory = notifyCategory == null ? null : notifyCategory.trim();
    }

    /**
     * 获取通知类型-根据业务定义的类型
     *
     * @return notify_type - 通知类型-根据业务定义的类型
     */
    public String getNotifyType() {
        return notifyType;
    }

    /**
     * 设置通知类型-根据业务定义的类型
     *
     * @param notifyType 通知类型-根据业务定义的类型
     */
    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType == null ? null : notifyType.trim();
    }

    /**
     * 获取重试次数
     *
     * @return retry_count - 重试次数
     */
    public Integer getRetryCount() {
        return retryCount;
    }

    /**
     * 设置重试次数
     *
     * @param retryCount 重试次数
     */
    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    /**
     * 获取最大重试次数
     *
     * @return max_retry_count - 最大重试次数
     */
    public Integer getMaxRetryCount() {
        return maxRetryCount;
    }

    /**
     * 设置最大重试次数
     *
     * @param maxRetryCount 最大重试次数
     */
    public void setMaxRetryCount(Integer maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    /**
     * 获取回调分组名称
     *
     * @return notify_group - 回调分组名称
     */
    public String getNotifyGroup() {
        return notifyGroup;
    }

    /**
     * 设置回调分组名称
     *
     * @param notifyGroup 回调分组名称
     */
    public void setNotifyGroup(String notifyGroup) {
        this.notifyGroup = notifyGroup == null ? null : notifyGroup.trim();
    }

    /**
     * 获取回调版本号
     *
     * @return notify_version - 回调版本号
     */
    public String getNotifyVersion() {
        return notifyVersion;
    }

    /**
     * 设置回调版本号
     *
     * @param notifyVersion 回调版本号
     */
    public void setNotifyVersion(String notifyVersion) {
        this.notifyVersion = notifyVersion == null ? null : notifyVersion.trim();
    }

    /**
     * 获取http回调地址
     *
     * @return notify_url - http回调地址
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * 设置http回调地址
     *
     * @param notifyUrl http回调地址
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    /**
     * 获取描述
     *
     * @return detail - 描述
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置描述
     *
     * @param detail 描述
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
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
     * 获取修改时间
     *
     * @return raw_update_time - 修改时间
     */
    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置修改时间
     *
     * @param rawUpdateTime 修改时间
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
        sb.append(", reqId=").append(reqId);
        sb.append(", gid=").append(gid);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", status=").append(status);
        sb.append(", notifyCategory=").append(notifyCategory);
        sb.append(", notifyType=").append(notifyType);
        sb.append(", retryCount=").append(retryCount);
        sb.append(", maxRetryCount=").append(maxRetryCount);
        sb.append(", notifyGroup=").append(notifyGroup);
        sb.append(", notifyVersion=").append(notifyVersion);
        sb.append(", notifyUrl=").append(notifyUrl);
        sb.append(", detail=").append(detail);
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
        UserNotifyTaskDO other = (UserNotifyTaskDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getReqId() == null ? other.getReqId() == null : this.getReqId().equals(other.getReqId()))
            && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getNotifyCategory() == null ? other.getNotifyCategory() == null : this.getNotifyCategory().equals(other.getNotifyCategory()))
            && (this.getNotifyType() == null ? other.getNotifyType() == null : this.getNotifyType().equals(other.getNotifyType()))
            && (this.getRetryCount() == null ? other.getRetryCount() == null : this.getRetryCount().equals(other.getRetryCount()))
            && (this.getMaxRetryCount() == null ? other.getMaxRetryCount() == null : this.getMaxRetryCount().equals(other.getMaxRetryCount()))
            && (this.getNotifyGroup() == null ? other.getNotifyGroup() == null : this.getNotifyGroup().equals(other.getNotifyGroup()))
            && (this.getNotifyVersion() == null ? other.getNotifyVersion() == null : this.getNotifyVersion().equals(other.getNotifyVersion()))
            && (this.getNotifyUrl() == null ? other.getNotifyUrl() == null : this.getNotifyUrl().equals(other.getNotifyUrl()))
            && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getReqId() == null) ? 0 : getReqId().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getNotifyCategory() == null) ? 0 : getNotifyCategory().hashCode());
        result = prime * result + ((getNotifyType() == null) ? 0 : getNotifyType().hashCode());
        result = prime * result + ((getRetryCount() == null) ? 0 : getRetryCount().hashCode());
        result = prime * result + ((getMaxRetryCount() == null) ? 0 : getMaxRetryCount().hashCode());
        result = prime * result + ((getNotifyGroup() == null) ? 0 : getNotifyGroup().hashCode());
        result = prime * result + ((getNotifyVersion() == null) ? 0 : getNotifyVersion().hashCode());
        result = prime * result + ((getNotifyUrl() == null) ? 0 : getNotifyUrl().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}