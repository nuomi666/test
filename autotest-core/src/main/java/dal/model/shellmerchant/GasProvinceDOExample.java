package dal.model.shellmerchant;

import java.util.ArrayList;
import java.util.List;

public class GasProvinceDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GasProvinceDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNull() {
            addCriterion("province_name is null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNotNull() {
            addCriterion("province_name is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameEqualTo(String value) {
            addCriterion("province_name =", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotEqualTo(String value) {
            addCriterion("province_name <>", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThan(String value) {
            addCriterion("province_name >", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("province_name >=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThan(String value) {
            addCriterion("province_name <", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("province_name <=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLike(String value) {
            addCriterion("province_name like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotLike(String value) {
            addCriterion("province_name not like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIn(List<String> values) {
            addCriterion("province_name in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotIn(List<String> values) {
            addCriterion("province_name not in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameBetween(String value1, String value2) {
            addCriterion("province_name between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotBetween(String value1, String value2) {
            addCriterion("province_name not between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceShortIsNull() {
            addCriterion("province_short is null");
            return (Criteria) this;
        }

        public Criteria andProvinceShortIsNotNull() {
            addCriterion("province_short is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceShortEqualTo(String value) {
            addCriterion("province_short =", value, "provinceShort");
            return (Criteria) this;
        }

        public Criteria andProvinceShortNotEqualTo(String value) {
            addCriterion("province_short <>", value, "provinceShort");
            return (Criteria) this;
        }

        public Criteria andProvinceShortGreaterThan(String value) {
            addCriterion("province_short >", value, "provinceShort");
            return (Criteria) this;
        }

        public Criteria andProvinceShortGreaterThanOrEqualTo(String value) {
            addCriterion("province_short >=", value, "provinceShort");
            return (Criteria) this;
        }

        public Criteria andProvinceShortLessThan(String value) {
            addCriterion("province_short <", value, "provinceShort");
            return (Criteria) this;
        }

        public Criteria andProvinceShortLessThanOrEqualTo(String value) {
            addCriterion("province_short <=", value, "provinceShort");
            return (Criteria) this;
        }

        public Criteria andProvinceShortLike(String value) {
            addCriterion("province_short like", value, "provinceShort");
            return (Criteria) this;
        }

        public Criteria andProvinceShortNotLike(String value) {
            addCriterion("province_short not like", value, "provinceShort");
            return (Criteria) this;
        }

        public Criteria andProvinceShortIn(List<String> values) {
            addCriterion("province_short in", values, "provinceShort");
            return (Criteria) this;
        }

        public Criteria andProvinceShortNotIn(List<String> values) {
            addCriterion("province_short not in", values, "provinceShort");
            return (Criteria) this;
        }

        public Criteria andProvinceShortBetween(String value1, String value2) {
            addCriterion("province_short between", value1, value2, "provinceShort");
            return (Criteria) this;
        }

        public Criteria andProvinceShortNotBetween(String value1, String value2) {
            addCriterion("province_short not between", value1, value2, "provinceShort");
            return (Criteria) this;
        }

        public Criteria andProvinceCharIsNull() {
            addCriterion("province_char is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCharIsNotNull() {
            addCriterion("province_char is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCharEqualTo(String value) {
            addCriterion("province_char =", value, "provinceChar");
            return (Criteria) this;
        }

        public Criteria andProvinceCharNotEqualTo(String value) {
            addCriterion("province_char <>", value, "provinceChar");
            return (Criteria) this;
        }

        public Criteria andProvinceCharGreaterThan(String value) {
            addCriterion("province_char >", value, "provinceChar");
            return (Criteria) this;
        }

        public Criteria andProvinceCharGreaterThanOrEqualTo(String value) {
            addCriterion("province_char >=", value, "provinceChar");
            return (Criteria) this;
        }

        public Criteria andProvinceCharLessThan(String value) {
            addCriterion("province_char <", value, "provinceChar");
            return (Criteria) this;
        }

        public Criteria andProvinceCharLessThanOrEqualTo(String value) {
            addCriterion("province_char <=", value, "provinceChar");
            return (Criteria) this;
        }

        public Criteria andProvinceCharLike(String value) {
            addCriterion("province_char like", value, "provinceChar");
            return (Criteria) this;
        }

        public Criteria andProvinceCharNotLike(String value) {
            addCriterion("province_char not like", value, "provinceChar");
            return (Criteria) this;
        }

        public Criteria andProvinceCharIn(List<String> values) {
            addCriterion("province_char in", values, "provinceChar");
            return (Criteria) this;
        }

        public Criteria andProvinceCharNotIn(List<String> values) {
            addCriterion("province_char not in", values, "provinceChar");
            return (Criteria) this;
        }

        public Criteria andProvinceCharBetween(String value1, String value2) {
            addCriterion("province_char between", value1, value2, "provinceChar");
            return (Criteria) this;
        }

        public Criteria andProvinceCharNotBetween(String value1, String value2) {
            addCriterion("province_char not between", value1, value2, "provinceChar");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}