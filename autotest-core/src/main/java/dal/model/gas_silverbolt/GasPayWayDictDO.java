package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_pay_way_dict")
public class GasPayWayDictDO implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 支付方式类型
     */
    @Column(name = "pay_way_type")
    private String payWayType;

    /**
     * 支付方式编码
     */
    @Column(name = "pay_way_code")
    private String payWayCode;

    /**
     * 支付方式名称
     */
    @Column(name = "pay_way_name")
    private String payWayName;

    /**
     * 支付方式图标
     */
    @Column(name = "pay_way_icon")
    private String payWayIcon;

    /**
     * 支付方式小图标
     */
    @Column(name = "pay_way_small_icon")
    private String payWaySmallIcon;

    /**
     * 渠道配置编码
     */
    @Column(name = "`channel_ code`")
    private String channelCode;

    /**
     * 渠道调用方法
     */
    @Column(name = "channel_function")
    private String channelFunction;

    /**
     * 新增时间
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
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取支付方式类型
     *
     * @return pay_way_type - 支付方式类型
     */
    public String getPayWayType() {
        return payWayType;
    }

    /**
     * 设置支付方式类型
     *
     * @param payWayType 支付方式类型
     */
    public void setPayWayType(String payWayType) {
        this.payWayType = payWayType == null ? null : payWayType.trim();
    }

    /**
     * 获取支付方式编码
     *
     * @return pay_way_code - 支付方式编码
     */
    public String getPayWayCode() {
        return payWayCode;
    }

    /**
     * 设置支付方式编码
     *
     * @param payWayCode 支付方式编码
     */
    public void setPayWayCode(String payWayCode) {
        this.payWayCode = payWayCode == null ? null : payWayCode.trim();
    }

    /**
     * 获取支付方式名称
     *
     * @return pay_way_name - 支付方式名称
     */
    public String getPayWayName() {
        return payWayName;
    }

    /**
     * 设置支付方式名称
     *
     * @param payWayName 支付方式名称
     */
    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName == null ? null : payWayName.trim();
    }

    /**
     * 获取支付方式图标
     *
     * @return pay_way_icon - 支付方式图标
     */
    public String getPayWayIcon() {
        return payWayIcon;
    }

    /**
     * 设置支付方式图标
     *
     * @param payWayIcon 支付方式图标
     */
    public void setPayWayIcon(String payWayIcon) {
        this.payWayIcon = payWayIcon == null ? null : payWayIcon.trim();
    }

    /**
     * 获取支付方式小图标
     *
     * @return pay_way_small_icon - 支付方式小图标
     */
    public String getPayWaySmallIcon() {
        return payWaySmallIcon;
    }

    /**
     * 设置支付方式小图标
     *
     * @param payWaySmallIcon 支付方式小图标
     */
    public void setPayWaySmallIcon(String payWaySmallIcon) {
        this.payWaySmallIcon = payWaySmallIcon == null ? null : payWaySmallIcon.trim();
    }

    /**
     * 获取渠道配置编码
     *
     * @return channel_ code - 渠道配置编码
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * 设置渠道配置编码
     *
     * @param channelCode 渠道配置编码
     */
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    /**
     * 获取渠道调用方法
     *
     * @return channel_function - 渠道调用方法
     */
    public String getChannelFunction() {
        return channelFunction;
    }

    /**
     * 设置渠道调用方法
     *
     * @param channelFunction 渠道调用方法
     */
    public void setChannelFunction(String channelFunction) {
        this.channelFunction = channelFunction == null ? null : channelFunction.trim();
    }

    /**
     * 获取新增时间
     *
     * @return raw_add_time - 新增时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置新增时间
     *
     * @param rawAddTime 新增时间
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
        sb.append(", payWayType=").append(payWayType);
        sb.append(", payWayCode=").append(payWayCode);
        sb.append(", payWayName=").append(payWayName);
        sb.append(", payWayIcon=").append(payWayIcon);
        sb.append(", payWaySmallIcon=").append(payWaySmallIcon);
        sb.append(", channelCode=").append(channelCode);
        sb.append(", channelFunction=").append(channelFunction);
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
        GasPayWayDictDO other = (GasPayWayDictDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPayWayType() == null ? other.getPayWayType() == null : this.getPayWayType().equals(other.getPayWayType()))
            && (this.getPayWayCode() == null ? other.getPayWayCode() == null : this.getPayWayCode().equals(other.getPayWayCode()))
            && (this.getPayWayName() == null ? other.getPayWayName() == null : this.getPayWayName().equals(other.getPayWayName()))
            && (this.getPayWayIcon() == null ? other.getPayWayIcon() == null : this.getPayWayIcon().equals(other.getPayWayIcon()))
            && (this.getPayWaySmallIcon() == null ? other.getPayWaySmallIcon() == null : this.getPayWaySmallIcon().equals(other.getPayWaySmallIcon()))
            && (this.getChannelCode() == null ? other.getChannelCode() == null : this.getChannelCode().equals(other.getChannelCode()))
            && (this.getChannelFunction() == null ? other.getChannelFunction() == null : this.getChannelFunction().equals(other.getChannelFunction()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPayWayType() == null) ? 0 : getPayWayType().hashCode());
        result = prime * result + ((getPayWayCode() == null) ? 0 : getPayWayCode().hashCode());
        result = prime * result + ((getPayWayName() == null) ? 0 : getPayWayName().hashCode());
        result = prime * result + ((getPayWayIcon() == null) ? 0 : getPayWayIcon().hashCode());
        result = prime * result + ((getPayWaySmallIcon() == null) ? 0 : getPayWaySmallIcon().hashCode());
        result = prime * result + ((getChannelCode() == null) ? 0 : getChannelCode().hashCode());
        result = prime * result + ((getChannelFunction() == null) ? 0 : getChannelFunction().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}