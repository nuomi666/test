package dal.model.promotion;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "fun_log")
public class FunLogDO implements Serializable {
    @Id
    private String code;

    private String name;

    private Integer num;

    private Double price;

    private Double pe;

    private Double roe;

    private Double value;

    private static final long serialVersionUID = 1L;

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return pe
     */
    public Double getPe() {
        return pe;
    }

    /**
     * @param pe
     */
    public void setPe(Double pe) {
        this.pe = pe;
    }

    /**
     * @return roe
     */
    public Double getRoe() {
        return roe;
    }

    /**
     * @param roe
     */
    public void setRoe(Double roe) {
        this.roe = roe;
    }

    /**
     * @return value
     */
    public Double getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", num=").append(num);
        sb.append(", price=").append(price);
        sb.append(", pe=").append(pe);
        sb.append(", roe=").append(roe);
        sb.append(", value=").append(value);
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
        FunLogDO other = (FunLogDO) that;
        return (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getPe() == null ? other.getPe() == null : this.getPe().equals(other.getPe()))
            && (this.getRoe() == null ? other.getRoe() == null : this.getRoe().equals(other.getRoe()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getPe() == null) ? 0 : getPe().hashCode());
        result = prime * result + ((getRoe() == null) ? 0 : getRoe().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        return result;
    }
}