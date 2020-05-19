package dal.model.gas_silverbolt;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "service_node")
public class ServiceNodeDO implements Serializable {
    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 服务器ip
     */
    @Column(name = "node_ip")
    private String nodeIp;

    /**
     * 节点状态
     */
    @Column(name = "node_status")
    private String nodeStatus;

    /**
     * 分配状态
     */
    @Column(name = "allot_status")
    private String allotStatus;

    /**
     * 添加时间
     */
    @Column(name = "raw_add_time")
    private Date rawAddTime;

    /**
     * 更新时间
     */
    @Column(name = "raw_update_time")
    private String rawUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增ID
     *
     * @return id - 自增ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取服务器ip
     *
     * @return node_ip - 服务器ip
     */
    public String getNodeIp() {
        return nodeIp;
    }

    /**
     * 设置服务器ip
     *
     * @param nodeIp 服务器ip
     */
    public void setNodeIp(String nodeIp) {
        this.nodeIp = nodeIp == null ? null : nodeIp.trim();
    }

    /**
     * 获取节点状态
     *
     * @return node_status - 节点状态
     */
    public String getNodeStatus() {
        return nodeStatus;
    }

    /**
     * 设置节点状态
     *
     * @param nodeStatus 节点状态
     */
    public void setNodeStatus(String nodeStatus) {
        this.nodeStatus = nodeStatus == null ? null : nodeStatus.trim();
    }

    /**
     * 获取分配状态
     *
     * @return allot_status - 分配状态
     */
    public String getAllotStatus() {
        return allotStatus;
    }

    /**
     * 设置分配状态
     *
     * @param allotStatus 分配状态
     */
    public void setAllotStatus(String allotStatus) {
        this.allotStatus = allotStatus == null ? null : allotStatus.trim();
    }

    /**
     * 获取添加时间
     *
     * @return raw_add_time - 添加时间
     */
    public Date getRawAddTime() {
        return rawAddTime;
    }

    /**
     * 设置添加时间
     *
     * @param rawAddTime 添加时间
     */
    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    /**
     * 获取更新时间
     *
     * @return raw_update_time - 更新时间
     */
    public String getRawUpdateTime() {
        return rawUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param rawUpdateTime 更新时间
     */
    public void setRawUpdateTime(String rawUpdateTime) {
        this.rawUpdateTime = rawUpdateTime == null ? null : rawUpdateTime.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", nodeIp=").append(nodeIp);
        sb.append(", nodeStatus=").append(nodeStatus);
        sb.append(", allotStatus=").append(allotStatus);
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
        ServiceNodeDO other = (ServiceNodeDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNodeIp() == null ? other.getNodeIp() == null : this.getNodeIp().equals(other.getNodeIp()))
            && (this.getNodeStatus() == null ? other.getNodeStatus() == null : this.getNodeStatus().equals(other.getNodeStatus()))
            && (this.getAllotStatus() == null ? other.getAllotStatus() == null : this.getAllotStatus().equals(other.getAllotStatus()))
            && (this.getRawAddTime() == null ? other.getRawAddTime() == null : this.getRawAddTime().equals(other.getRawAddTime()))
            && (this.getRawUpdateTime() == null ? other.getRawUpdateTime() == null : this.getRawUpdateTime().equals(other.getRawUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNodeIp() == null) ? 0 : getNodeIp().hashCode());
        result = prime * result + ((getNodeStatus() == null) ? 0 : getNodeStatus().hashCode());
        result = prime * result + ((getAllotStatus() == null) ? 0 : getAllotStatus().hashCode());
        result = prime * result + ((getRawAddTime() == null) ? 0 : getRawAddTime().hashCode());
        result = prime * result + ((getRawUpdateTime() == null) ? 0 : getRawUpdateTime().hashCode());
        return result;
    }
}