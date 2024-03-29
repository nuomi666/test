package dal.model.shellmerchant;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gas_merchant_device_function")
public class GasMerchantDeviceFunctionDO implements Serializable {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商家号
     */
    @Column(name = "partner_id")
    private String partnerId;

    /**
     * 油站编号
     */
    @Column(name = "station_id")
    private String stationId;

    /**
     * 功能名称
     */
    @Column(name = "func_type")
    private String funcType;

    /**
     * 是否开启
     */
    private Byte open;

    /**
     * 终端类型
     */
    @Column(name = "device_type")
    private String deviceType;

    /**
     * 终端编码
     */
    @Column(name = "device_code")
    private String deviceCode;

    /**
     * 操作用户
     */
    @Column(name = "user_id")
    private String userId;

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
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商家号
     *
     * @return partner_id - 商家号
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * 设置商家号
     *
     * @param partnerId 商家号
     */
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    /**
     * 获取油站编号
     *
     * @return station_id - 油站编号
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * 设置油站编号
     *
     * @param stationId 油站编号
     */
    public void setStationId(String stationId) {
        this.stationId = stationId == null ? null : stationId.trim();
    }

    /**
     * 获取功能名称
     *
     * @return func_type - 功能名称
     */
    public String getFuncType() {
        return funcType;
    }

    /**
     * 设置功能名称
     *
     * @param funcType 功能名称
     */
    public void setFuncType(String funcType) {
        this.funcType = funcType == null ? null : funcType.trim();
    }

    /**
     * 获取是否开启
     *
     * @return open - 是否开启
     */
    public Byte getOpen() {
        return open;
    }

    /**
     * 设置是否开启
     *
     * @param open 是否开启
     */
    public void setOpen(Byte open) {
        this.open = open;
    }

    /**
     * 获取终端类型
     *
     * @return device_type - 终端类型
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * 设置终端类型
     *
     * @param deviceType 终端类型
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    /**
     * 获取终端编码
     *
     * @return device_code - 终端编码
     */
    public String getDeviceCode() {
        return deviceCode;
    }

    /**
     * 设置终端编码
     *
     * @param deviceCode 终端编码
     */
    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode == null ? null : deviceCode.trim();
    }

    /**
     * 获取操作用户
     *
     * @return user_id - 操作用户
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置操作用户
     *
     * @param userId 操作用户
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
        sb.append(", partnerId=").append(partnerId);
        sb.append(", stationId=").append(stationId);
        sb.append(", funcType=").append(funcType);
        sb.append(", open=").append(open);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", deviceCode=").append(deviceCode);
        sb.append(", userId=").append(userId);
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
        GasMerchantDeviceFunctionDO other = (GasMerchantDeviceFunctionDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
            && (this.getStationId() == null ? other.getStationId() == null : this.getStationId().equals(other.getStationId()))
            && (this.getFuncType() == null ? other.getFuncType() == null : this.getFuncType().equals(other.getFuncType()))
            && (this.getOpen() == null ? other.getOpen() == null : this.getOpen().equals(other.getOpen()))
            && (this.getDeviceType() == null ? other.getDeviceType() == null : this.getDeviceType().equals(other.getDeviceType()))
            && (this.getDeviceCode() == null ? other.getDeviceCode() == null : this.getDeviceCode().equals(other.getDeviceCode()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getStationId() == null) ? 0 : getStationId().hashCode());
        result = prime * result + ((getFuncType() == null) ? 0 : getFuncType().hashCode());
        result = prime * result + ((getOpen() == null) ? 0 : getOpen().hashCode());
        result = prime * result + ((getDeviceType() == null) ? 0 : getDeviceType().hashCode());
        result = prime * result + ((getDeviceCode() == null) ? 0 : getDeviceCode().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}