package dal.model.gas_merchant;

import java.util.ArrayList;
import java.util.List;

public class StationChannalDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StationChannalDOExample() {
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

        public Criteria and渠道名称IsNull() {
            addCriterion("渠道名称 is null");
            return (Criteria) this;
        }

        public Criteria and渠道名称IsNotNull() {
            addCriterion("渠道名称 is not null");
            return (Criteria) this;
        }

        public Criteria and渠道名称EqualTo(String value) {
            addCriterion("渠道名称 =", value, "渠道名称");
            return (Criteria) this;
        }

        public Criteria and渠道名称NotEqualTo(String value) {
            addCriterion("渠道名称 <>", value, "渠道名称");
            return (Criteria) this;
        }

        public Criteria and渠道名称GreaterThan(String value) {
            addCriterion("渠道名称 >", value, "渠道名称");
            return (Criteria) this;
        }

        public Criteria and渠道名称GreaterThanOrEqualTo(String value) {
            addCriterion("渠道名称 >=", value, "渠道名称");
            return (Criteria) this;
        }

        public Criteria and渠道名称LessThan(String value) {
            addCriterion("渠道名称 <", value, "渠道名称");
            return (Criteria) this;
        }

        public Criteria and渠道名称LessThanOrEqualTo(String value) {
            addCriterion("渠道名称 <=", value, "渠道名称");
            return (Criteria) this;
        }

        public Criteria and渠道名称Like(String value) {
            addCriterion("渠道名称 like", value, "渠道名称");
            return (Criteria) this;
        }

        public Criteria and渠道名称NotLike(String value) {
            addCriterion("渠道名称 not like", value, "渠道名称");
            return (Criteria) this;
        }

        public Criteria and渠道名称In(List<String> values) {
            addCriterion("渠道名称 in", values, "渠道名称");
            return (Criteria) this;
        }

        public Criteria and渠道名称NotIn(List<String> values) {
            addCriterion("渠道名称 not in", values, "渠道名称");
            return (Criteria) this;
        }

        public Criteria and渠道名称Between(String value1, String value2) {
            addCriterion("渠道名称 between", value1, value2, "渠道名称");
            return (Criteria) this;
        }

        public Criteria and渠道名称NotBetween(String value1, String value2) {
            addCriterion("渠道名称 not between", value1, value2, "渠道名称");
            return (Criteria) this;
        }

        public Criteria and交易总金额IsNull() {
            addCriterion("交易总金额 is null");
            return (Criteria) this;
        }

        public Criteria and交易总金额IsNotNull() {
            addCriterion("交易总金额 is not null");
            return (Criteria) this;
        }

        public Criteria and交易总金额EqualTo(String value) {
            addCriterion("交易总金额 =", value, "交易总金额");
            return (Criteria) this;
        }

        public Criteria and交易总金额NotEqualTo(String value) {
            addCriterion("交易总金额 <>", value, "交易总金额");
            return (Criteria) this;
        }

        public Criteria and交易总金额GreaterThan(String value) {
            addCriterion("交易总金额 >", value, "交易总金额");
            return (Criteria) this;
        }

        public Criteria and交易总金额GreaterThanOrEqualTo(String value) {
            addCriterion("交易总金额 >=", value, "交易总金额");
            return (Criteria) this;
        }

        public Criteria and交易总金额LessThan(String value) {
            addCriterion("交易总金额 <", value, "交易总金额");
            return (Criteria) this;
        }

        public Criteria and交易总金额LessThanOrEqualTo(String value) {
            addCriterion("交易总金额 <=", value, "交易总金额");
            return (Criteria) this;
        }

        public Criteria and交易总金额Like(String value) {
            addCriterion("交易总金额 like", value, "交易总金额");
            return (Criteria) this;
        }

        public Criteria and交易总金额NotLike(String value) {
            addCriterion("交易总金额 not like", value, "交易总金额");
            return (Criteria) this;
        }

        public Criteria and交易总金额In(List<String> values) {
            addCriterion("交易总金额 in", values, "交易总金额");
            return (Criteria) this;
        }

        public Criteria and交易总金额NotIn(List<String> values) {
            addCriterion("交易总金额 not in", values, "交易总金额");
            return (Criteria) this;
        }

        public Criteria and交易总金额Between(String value1, String value2) {
            addCriterion("交易总金额 between", value1, value2, "交易总金额");
            return (Criteria) this;
        }

        public Criteria and交易总金额NotBetween(String value1, String value2) {
            addCriterion("交易总金额 not between", value1, value2, "交易总金额");
            return (Criteria) this;
        }

        public Criteria and收益IsNull() {
            addCriterion("收益 is null");
            return (Criteria) this;
        }

        public Criteria and收益IsNotNull() {
            addCriterion("收益 is not null");
            return (Criteria) this;
        }

        public Criteria and收益EqualTo(String value) {
            addCriterion("收益 =", value, "收益");
            return (Criteria) this;
        }

        public Criteria and收益NotEqualTo(String value) {
            addCriterion("收益 <>", value, "收益");
            return (Criteria) this;
        }

        public Criteria and收益GreaterThan(String value) {
            addCriterion("收益 >", value, "收益");
            return (Criteria) this;
        }

        public Criteria and收益GreaterThanOrEqualTo(String value) {
            addCriterion("收益 >=", value, "收益");
            return (Criteria) this;
        }

        public Criteria and收益LessThan(String value) {
            addCriterion("收益 <", value, "收益");
            return (Criteria) this;
        }

        public Criteria and收益LessThanOrEqualTo(String value) {
            addCriterion("收益 <=", value, "收益");
            return (Criteria) this;
        }

        public Criteria and收益Like(String value) {
            addCriterion("收益 like", value, "收益");
            return (Criteria) this;
        }

        public Criteria and收益NotLike(String value) {
            addCriterion("收益 not like", value, "收益");
            return (Criteria) this;
        }

        public Criteria and收益In(List<String> values) {
            addCriterion("收益 in", values, "收益");
            return (Criteria) this;
        }

        public Criteria and收益NotIn(List<String> values) {
            addCriterion("收益 not in", values, "收益");
            return (Criteria) this;
        }

        public Criteria and收益Between(String value1, String value2) {
            addCriterion("收益 between", value1, value2, "收益");
            return (Criteria) this;
        }

        public Criteria and收益NotBetween(String value1, String value2) {
            addCriterion("收益 not between", value1, value2, "收益");
            return (Criteria) this;
        }

        public Criteria and油站数量IsNull() {
            addCriterion("油站数量 is null");
            return (Criteria) this;
        }

        public Criteria and油站数量IsNotNull() {
            addCriterion("油站数量 is not null");
            return (Criteria) this;
        }

        public Criteria and油站数量EqualTo(String value) {
            addCriterion("油站数量 =", value, "油站数量");
            return (Criteria) this;
        }

        public Criteria and油站数量NotEqualTo(String value) {
            addCriterion("油站数量 <>", value, "油站数量");
            return (Criteria) this;
        }

        public Criteria and油站数量GreaterThan(String value) {
            addCriterion("油站数量 >", value, "油站数量");
            return (Criteria) this;
        }

        public Criteria and油站数量GreaterThanOrEqualTo(String value) {
            addCriterion("油站数量 >=", value, "油站数量");
            return (Criteria) this;
        }

        public Criteria and油站数量LessThan(String value) {
            addCriterion("油站数量 <", value, "油站数量");
            return (Criteria) this;
        }

        public Criteria and油站数量LessThanOrEqualTo(String value) {
            addCriterion("油站数量 <=", value, "油站数量");
            return (Criteria) this;
        }

        public Criteria and油站数量Like(String value) {
            addCriterion("油站数量 like", value, "油站数量");
            return (Criteria) this;
        }

        public Criteria and油站数量NotLike(String value) {
            addCriterion("油站数量 not like", value, "油站数量");
            return (Criteria) this;
        }

        public Criteria and油站数量In(List<String> values) {
            addCriterion("油站数量 in", values, "油站数量");
            return (Criteria) this;
        }

        public Criteria and油站数量NotIn(List<String> values) {
            addCriterion("油站数量 not in", values, "油站数量");
            return (Criteria) this;
        }

        public Criteria and油站数量Between(String value1, String value2) {
            addCriterion("油站数量 between", value1, value2, "油站数量");
            return (Criteria) this;
        }

        public Criteria and油站数量NotBetween(String value1, String value2) {
            addCriterion("油站数量 not between", value1, value2, "油站数量");
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