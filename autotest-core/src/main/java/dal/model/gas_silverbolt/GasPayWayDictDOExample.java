package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GasPayWayDictDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GasPayWayDictDOExample() {
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

        public Criteria andPayWayTypeIsNull() {
            addCriterion("pay_way_type is null");
            return (Criteria) this;
        }

        public Criteria andPayWayTypeIsNotNull() {
            addCriterion("pay_way_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayTypeEqualTo(String value) {
            addCriterion("pay_way_type =", value, "payWayType");
            return (Criteria) this;
        }

        public Criteria andPayWayTypeNotEqualTo(String value) {
            addCriterion("pay_way_type <>", value, "payWayType");
            return (Criteria) this;
        }

        public Criteria andPayWayTypeGreaterThan(String value) {
            addCriterion("pay_way_type >", value, "payWayType");
            return (Criteria) this;
        }

        public Criteria andPayWayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_way_type >=", value, "payWayType");
            return (Criteria) this;
        }

        public Criteria andPayWayTypeLessThan(String value) {
            addCriterion("pay_way_type <", value, "payWayType");
            return (Criteria) this;
        }

        public Criteria andPayWayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_way_type <=", value, "payWayType");
            return (Criteria) this;
        }

        public Criteria andPayWayTypeLike(String value) {
            addCriterion("pay_way_type like", value, "payWayType");
            return (Criteria) this;
        }

        public Criteria andPayWayTypeNotLike(String value) {
            addCriterion("pay_way_type not like", value, "payWayType");
            return (Criteria) this;
        }

        public Criteria andPayWayTypeIn(List<String> values) {
            addCriterion("pay_way_type in", values, "payWayType");
            return (Criteria) this;
        }

        public Criteria andPayWayTypeNotIn(List<String> values) {
            addCriterion("pay_way_type not in", values, "payWayType");
            return (Criteria) this;
        }

        public Criteria andPayWayTypeBetween(String value1, String value2) {
            addCriterion("pay_way_type between", value1, value2, "payWayType");
            return (Criteria) this;
        }

        public Criteria andPayWayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_way_type not between", value1, value2, "payWayType");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeIsNull() {
            addCriterion("pay_way_code is null");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeIsNotNull() {
            addCriterion("pay_way_code is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeEqualTo(String value) {
            addCriterion("pay_way_code =", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeNotEqualTo(String value) {
            addCriterion("pay_way_code <>", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeGreaterThan(String value) {
            addCriterion("pay_way_code >", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_way_code >=", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeLessThan(String value) {
            addCriterion("pay_way_code <", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeLessThanOrEqualTo(String value) {
            addCriterion("pay_way_code <=", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeLike(String value) {
            addCriterion("pay_way_code like", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeNotLike(String value) {
            addCriterion("pay_way_code not like", value, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeIn(List<String> values) {
            addCriterion("pay_way_code in", values, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeNotIn(List<String> values) {
            addCriterion("pay_way_code not in", values, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeBetween(String value1, String value2) {
            addCriterion("pay_way_code between", value1, value2, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayCodeNotBetween(String value1, String value2) {
            addCriterion("pay_way_code not between", value1, value2, "payWayCode");
            return (Criteria) this;
        }

        public Criteria andPayWayNameIsNull() {
            addCriterion("pay_way_name is null");
            return (Criteria) this;
        }

        public Criteria andPayWayNameIsNotNull() {
            addCriterion("pay_way_name is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayNameEqualTo(String value) {
            addCriterion("pay_way_name =", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameNotEqualTo(String value) {
            addCriterion("pay_way_name <>", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameGreaterThan(String value) {
            addCriterion("pay_way_name >", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameGreaterThanOrEqualTo(String value) {
            addCriterion("pay_way_name >=", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameLessThan(String value) {
            addCriterion("pay_way_name <", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameLessThanOrEqualTo(String value) {
            addCriterion("pay_way_name <=", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameLike(String value) {
            addCriterion("pay_way_name like", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameNotLike(String value) {
            addCriterion("pay_way_name not like", value, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameIn(List<String> values) {
            addCriterion("pay_way_name in", values, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameNotIn(List<String> values) {
            addCriterion("pay_way_name not in", values, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameBetween(String value1, String value2) {
            addCriterion("pay_way_name between", value1, value2, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayNameNotBetween(String value1, String value2) {
            addCriterion("pay_way_name not between", value1, value2, "payWayName");
            return (Criteria) this;
        }

        public Criteria andPayWayIconIsNull() {
            addCriterion("pay_way_icon is null");
            return (Criteria) this;
        }

        public Criteria andPayWayIconIsNotNull() {
            addCriterion("pay_way_icon is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayIconEqualTo(String value) {
            addCriterion("pay_way_icon =", value, "payWayIcon");
            return (Criteria) this;
        }

        public Criteria andPayWayIconNotEqualTo(String value) {
            addCriterion("pay_way_icon <>", value, "payWayIcon");
            return (Criteria) this;
        }

        public Criteria andPayWayIconGreaterThan(String value) {
            addCriterion("pay_way_icon >", value, "payWayIcon");
            return (Criteria) this;
        }

        public Criteria andPayWayIconGreaterThanOrEqualTo(String value) {
            addCriterion("pay_way_icon >=", value, "payWayIcon");
            return (Criteria) this;
        }

        public Criteria andPayWayIconLessThan(String value) {
            addCriterion("pay_way_icon <", value, "payWayIcon");
            return (Criteria) this;
        }

        public Criteria andPayWayIconLessThanOrEqualTo(String value) {
            addCriterion("pay_way_icon <=", value, "payWayIcon");
            return (Criteria) this;
        }

        public Criteria andPayWayIconLike(String value) {
            addCriterion("pay_way_icon like", value, "payWayIcon");
            return (Criteria) this;
        }

        public Criteria andPayWayIconNotLike(String value) {
            addCriterion("pay_way_icon not like", value, "payWayIcon");
            return (Criteria) this;
        }

        public Criteria andPayWayIconIn(List<String> values) {
            addCriterion("pay_way_icon in", values, "payWayIcon");
            return (Criteria) this;
        }

        public Criteria andPayWayIconNotIn(List<String> values) {
            addCriterion("pay_way_icon not in", values, "payWayIcon");
            return (Criteria) this;
        }

        public Criteria andPayWayIconBetween(String value1, String value2) {
            addCriterion("pay_way_icon between", value1, value2, "payWayIcon");
            return (Criteria) this;
        }

        public Criteria andPayWayIconNotBetween(String value1, String value2) {
            addCriterion("pay_way_icon not between", value1, value2, "payWayIcon");
            return (Criteria) this;
        }

        public Criteria andPayWaySmallIconIsNull() {
            addCriterion("pay_way_small_icon is null");
            return (Criteria) this;
        }

        public Criteria andPayWaySmallIconIsNotNull() {
            addCriterion("pay_way_small_icon is not null");
            return (Criteria) this;
        }

        public Criteria andPayWaySmallIconEqualTo(String value) {
            addCriterion("pay_way_small_icon =", value, "payWaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPayWaySmallIconNotEqualTo(String value) {
            addCriterion("pay_way_small_icon <>", value, "payWaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPayWaySmallIconGreaterThan(String value) {
            addCriterion("pay_way_small_icon >", value, "payWaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPayWaySmallIconGreaterThanOrEqualTo(String value) {
            addCriterion("pay_way_small_icon >=", value, "payWaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPayWaySmallIconLessThan(String value) {
            addCriterion("pay_way_small_icon <", value, "payWaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPayWaySmallIconLessThanOrEqualTo(String value) {
            addCriterion("pay_way_small_icon <=", value, "payWaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPayWaySmallIconLike(String value) {
            addCriterion("pay_way_small_icon like", value, "payWaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPayWaySmallIconNotLike(String value) {
            addCriterion("pay_way_small_icon not like", value, "payWaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPayWaySmallIconIn(List<String> values) {
            addCriterion("pay_way_small_icon in", values, "payWaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPayWaySmallIconNotIn(List<String> values) {
            addCriterion("pay_way_small_icon not in", values, "payWaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPayWaySmallIconBetween(String value1, String value2) {
            addCriterion("pay_way_small_icon between", value1, value2, "payWaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andPayWaySmallIconNotBetween(String value1, String value2) {
            addCriterion("pay_way_small_icon not between", value1, value2, "payWaySmallIcon");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIsNull() {
            addCriterion("`channel_ code` is null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIsNotNull() {
            addCriterion("`channel_ code` is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeEqualTo(String value) {
            addCriterion("`channel_ code` =", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotEqualTo(String value) {
            addCriterion("`channel_ code` <>", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThan(String value) {
            addCriterion("`channel_ code` >", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("`channel_ code` >=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThan(String value) {
            addCriterion("`channel_ code` <", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThanOrEqualTo(String value) {
            addCriterion("`channel_ code` <=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLike(String value) {
            addCriterion("`channel_ code` like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotLike(String value) {
            addCriterion("`channel_ code` not like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIn(List<String> values) {
            addCriterion("`channel_ code` in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotIn(List<String> values) {
            addCriterion("`channel_ code` not in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeBetween(String value1, String value2) {
            addCriterion("`channel_ code` between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotBetween(String value1, String value2) {
            addCriterion("`channel_ code` not between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionIsNull() {
            addCriterion("channel_function is null");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionIsNotNull() {
            addCriterion("channel_function is not null");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionEqualTo(String value) {
            addCriterion("channel_function =", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionNotEqualTo(String value) {
            addCriterion("channel_function <>", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionGreaterThan(String value) {
            addCriterion("channel_function >", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("channel_function >=", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionLessThan(String value) {
            addCriterion("channel_function <", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionLessThanOrEqualTo(String value) {
            addCriterion("channel_function <=", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionLike(String value) {
            addCriterion("channel_function like", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionNotLike(String value) {
            addCriterion("channel_function not like", value, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionIn(List<String> values) {
            addCriterion("channel_function in", values, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionNotIn(List<String> values) {
            addCriterion("channel_function not in", values, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionBetween(String value1, String value2) {
            addCriterion("channel_function between", value1, value2, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andChannelFunctionNotBetween(String value1, String value2) {
            addCriterion("channel_function not between", value1, value2, "channelFunction");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeIsNull() {
            addCriterion("raw_add_time is null");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeIsNotNull() {
            addCriterion("raw_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeEqualTo(Date value) {
            addCriterion("raw_add_time =", value, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeNotEqualTo(Date value) {
            addCriterion("raw_add_time <>", value, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeGreaterThan(Date value) {
            addCriterion("raw_add_time >", value, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("raw_add_time >=", value, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeLessThan(Date value) {
            addCriterion("raw_add_time <", value, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("raw_add_time <=", value, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeIn(List<Date> values) {
            addCriterion("raw_add_time in", values, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeNotIn(List<Date> values) {
            addCriterion("raw_add_time not in", values, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeBetween(Date value1, Date value2) {
            addCriterion("raw_add_time between", value1, value2, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("raw_add_time not between", value1, value2, "rawAddTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeIsNull() {
            addCriterion("raw_update_time is null");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeIsNotNull() {
            addCriterion("raw_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeEqualTo(Date value) {
            addCriterion("raw_update_time =", value, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeNotEqualTo(Date value) {
            addCriterion("raw_update_time <>", value, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeGreaterThan(Date value) {
            addCriterion("raw_update_time >", value, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("raw_update_time >=", value, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeLessThan(Date value) {
            addCriterion("raw_update_time <", value, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("raw_update_time <=", value, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeIn(List<Date> values) {
            addCriterion("raw_update_time in", values, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeNotIn(List<Date> values) {
            addCriterion("raw_update_time not in", values, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("raw_update_time between", value1, value2, "rawUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRawUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("raw_update_time not between", value1, value2, "rawUpdateTime");
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