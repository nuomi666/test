package dal.model.gas_silverbolt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GasTradeOilDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GasTradeOilDOExample() {
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

        public Criteria andBizNoIsNull() {
            addCriterion("biz_no is null");
            return (Criteria) this;
        }

        public Criteria andBizNoIsNotNull() {
            addCriterion("biz_no is not null");
            return (Criteria) this;
        }

        public Criteria andBizNoEqualTo(String value) {
            addCriterion("biz_no =", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoNotEqualTo(String value) {
            addCriterion("biz_no <>", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoGreaterThan(String value) {
            addCriterion("biz_no >", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoGreaterThanOrEqualTo(String value) {
            addCriterion("biz_no >=", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoLessThan(String value) {
            addCriterion("biz_no <", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoLessThanOrEqualTo(String value) {
            addCriterion("biz_no <=", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoLike(String value) {
            addCriterion("biz_no like", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoNotLike(String value) {
            addCriterion("biz_no not like", value, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoIn(List<String> values) {
            addCriterion("biz_no in", values, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoNotIn(List<String> values) {
            addCriterion("biz_no not in", values, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoBetween(String value1, String value2) {
            addCriterion("biz_no between", value1, value2, "bizNo");
            return (Criteria) this;
        }

        public Criteria andBizNoNotBetween(String value1, String value2) {
            addCriterion("biz_no not between", value1, value2, "bizNo");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(String value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(String value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(String value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(String value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLike(String value) {
            addCriterion("trade_type like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotLike(String value) {
            addCriterion("trade_type not like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<String> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<String> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(String value1, String value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(String value1, String value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIsNull() {
            addCriterion("partner_id is null");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIsNotNull() {
            addCriterion("partner_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerIdEqualTo(String value) {
            addCriterion("partner_id =", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotEqualTo(String value) {
            addCriterion("partner_id <>", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdGreaterThan(String value) {
            addCriterion("partner_id >", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("partner_id >=", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLessThan(String value) {
            addCriterion("partner_id <", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLessThanOrEqualTo(String value) {
            addCriterion("partner_id <=", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLike(String value) {
            addCriterion("partner_id like", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotLike(String value) {
            addCriterion("partner_id not like", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIn(List<String> values) {
            addCriterion("partner_id in", values, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotIn(List<String> values) {
            addCriterion("partner_id not in", values, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdBetween(String value1, String value2) {
            addCriterion("partner_id between", value1, value2, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotBetween(String value1, String value2) {
            addCriterion("partner_id not between", value1, value2, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerNameIsNull() {
            addCriterion("partner_name is null");
            return (Criteria) this;
        }

        public Criteria andPartnerNameIsNotNull() {
            addCriterion("partner_name is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerNameEqualTo(String value) {
            addCriterion("partner_name =", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotEqualTo(String value) {
            addCriterion("partner_name <>", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameGreaterThan(String value) {
            addCriterion("partner_name >", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("partner_name >=", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameLessThan(String value) {
            addCriterion("partner_name <", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameLessThanOrEqualTo(String value) {
            addCriterion("partner_name <=", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameLike(String value) {
            addCriterion("partner_name like", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotLike(String value) {
            addCriterion("partner_name not like", value, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameIn(List<String> values) {
            addCriterion("partner_name in", values, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotIn(List<String> values) {
            addCriterion("partner_name not in", values, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameBetween(String value1, String value2) {
            addCriterion("partner_name between", value1, value2, "partnerName");
            return (Criteria) this;
        }

        public Criteria andPartnerNameNotBetween(String value1, String value2) {
            addCriterion("partner_name not between", value1, value2, "partnerName");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNull() {
            addCriterion("station_id is null");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNotNull() {
            addCriterion("station_id is not null");
            return (Criteria) this;
        }

        public Criteria andStationIdEqualTo(String value) {
            addCriterion("station_id =", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotEqualTo(String value) {
            addCriterion("station_id <>", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThan(String value) {
            addCriterion("station_id >", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThanOrEqualTo(String value) {
            addCriterion("station_id >=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThan(String value) {
            addCriterion("station_id <", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThanOrEqualTo(String value) {
            addCriterion("station_id <=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLike(String value) {
            addCriterion("station_id like", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotLike(String value) {
            addCriterion("station_id not like", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdIn(List<String> values) {
            addCriterion("station_id in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotIn(List<String> values) {
            addCriterion("station_id not in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdBetween(String value1, String value2) {
            addCriterion("station_id between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotBetween(String value1, String value2) {
            addCriterion("station_id not between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationCodeIsNull() {
            addCriterion("station_code is null");
            return (Criteria) this;
        }

        public Criteria andStationCodeIsNotNull() {
            addCriterion("station_code is not null");
            return (Criteria) this;
        }

        public Criteria andStationCodeEqualTo(String value) {
            addCriterion("station_code =", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotEqualTo(String value) {
            addCriterion("station_code <>", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeGreaterThan(String value) {
            addCriterion("station_code >", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("station_code >=", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeLessThan(String value) {
            addCriterion("station_code <", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeLessThanOrEqualTo(String value) {
            addCriterion("station_code <=", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeLike(String value) {
            addCriterion("station_code like", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotLike(String value) {
            addCriterion("station_code not like", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeIn(List<String> values) {
            addCriterion("station_code in", values, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotIn(List<String> values) {
            addCriterion("station_code not in", values, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeBetween(String value1, String value2) {
            addCriterion("station_code between", value1, value2, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotBetween(String value1, String value2) {
            addCriterion("station_code not between", value1, value2, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNull() {
            addCriterion("station_name is null");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNotNull() {
            addCriterion("station_name is not null");
            return (Criteria) this;
        }

        public Criteria andStationNameEqualTo(String value) {
            addCriterion("station_name =", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotEqualTo(String value) {
            addCriterion("station_name <>", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThan(String value) {
            addCriterion("station_name >", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThanOrEqualTo(String value) {
            addCriterion("station_name >=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThan(String value) {
            addCriterion("station_name <", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThanOrEqualTo(String value) {
            addCriterion("station_name <=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLike(String value) {
            addCriterion("station_name like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotLike(String value) {
            addCriterion("station_name not like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameIn(List<String> values) {
            addCriterion("station_name in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotIn(List<String> values) {
            addCriterion("station_name not in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameBetween(String value1, String value2) {
            addCriterion("station_name between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotBetween(String value1, String value2) {
            addCriterion("station_name not between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andOperateIdIsNull() {
            addCriterion("operate_id is null");
            return (Criteria) this;
        }

        public Criteria andOperateIdIsNotNull() {
            addCriterion("operate_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperateIdEqualTo(String value) {
            addCriterion("operate_id =", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotEqualTo(String value) {
            addCriterion("operate_id <>", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdGreaterThan(String value) {
            addCriterion("operate_id >", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdGreaterThanOrEqualTo(String value) {
            addCriterion("operate_id >=", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLessThan(String value) {
            addCriterion("operate_id <", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLessThanOrEqualTo(String value) {
            addCriterion("operate_id <=", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdLike(String value) {
            addCriterion("operate_id like", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotLike(String value) {
            addCriterion("operate_id not like", value, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdIn(List<String> values) {
            addCriterion("operate_id in", values, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotIn(List<String> values) {
            addCriterion("operate_id not in", values, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdBetween(String value1, String value2) {
            addCriterion("operate_id between", value1, value2, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateIdNotBetween(String value1, String value2) {
            addCriterion("operate_id not between", value1, value2, "operateId");
            return (Criteria) this;
        }

        public Criteria andOperateNameIsNull() {
            addCriterion("operate_name is null");
            return (Criteria) this;
        }

        public Criteria andOperateNameIsNotNull() {
            addCriterion("operate_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperateNameEqualTo(String value) {
            addCriterion("operate_name =", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameNotEqualTo(String value) {
            addCriterion("operate_name <>", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameGreaterThan(String value) {
            addCriterion("operate_name >", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameGreaterThanOrEqualTo(String value) {
            addCriterion("operate_name >=", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameLessThan(String value) {
            addCriterion("operate_name <", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameLessThanOrEqualTo(String value) {
            addCriterion("operate_name <=", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameLike(String value) {
            addCriterion("operate_name like", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameNotLike(String value) {
            addCriterion("operate_name not like", value, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameIn(List<String> values) {
            addCriterion("operate_name in", values, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameNotIn(List<String> values) {
            addCriterion("operate_name not in", values, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameBetween(String value1, String value2) {
            addCriterion("operate_name between", value1, value2, "operateName");
            return (Criteria) this;
        }

        public Criteria andOperateNameNotBetween(String value1, String value2) {
            addCriterion("operate_name not between", value1, value2, "operateName");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeIsNull() {
            addCriterion("terminal_type is null");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeIsNotNull() {
            addCriterion("terminal_type is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeEqualTo(String value) {
            addCriterion("terminal_type =", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeNotEqualTo(String value) {
            addCriterion("terminal_type <>", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeGreaterThan(String value) {
            addCriterion("terminal_type >", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeGreaterThanOrEqualTo(String value) {
            addCriterion("terminal_type >=", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeLessThan(String value) {
            addCriterion("terminal_type <", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeLessThanOrEqualTo(String value) {
            addCriterion("terminal_type <=", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeLike(String value) {
            addCriterion("terminal_type like", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeNotLike(String value) {
            addCriterion("terminal_type not like", value, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeIn(List<String> values) {
            addCriterion("terminal_type in", values, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeNotIn(List<String> values) {
            addCriterion("terminal_type not in", values, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeBetween(String value1, String value2) {
            addCriterion("terminal_type between", value1, value2, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalTypeNotBetween(String value1, String value2) {
            addCriterion("terminal_type not between", value1, value2, "terminalType");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeIsNull() {
            addCriterion("terminal_code is null");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeIsNotNull() {
            addCriterion("terminal_code is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeEqualTo(String value) {
            addCriterion("terminal_code =", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeNotEqualTo(String value) {
            addCriterion("terminal_code <>", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeGreaterThan(String value) {
            addCriterion("terminal_code >", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeGreaterThanOrEqualTo(String value) {
            addCriterion("terminal_code >=", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeLessThan(String value) {
            addCriterion("terminal_code <", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeLessThanOrEqualTo(String value) {
            addCriterion("terminal_code <=", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeLike(String value) {
            addCriterion("terminal_code like", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeNotLike(String value) {
            addCriterion("terminal_code not like", value, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeIn(List<String> values) {
            addCriterion("terminal_code in", values, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeNotIn(List<String> values) {
            addCriterion("terminal_code not in", values, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeBetween(String value1, String value2) {
            addCriterion("terminal_code between", value1, value2, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andTerminalCodeNotBetween(String value1, String value2) {
            addCriterion("terminal_code not between", value1, value2, "terminalCode");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNull() {
            addCriterion("cert_no is null");
            return (Criteria) this;
        }

        public Criteria andCertNoIsNotNull() {
            addCriterion("cert_no is not null");
            return (Criteria) this;
        }

        public Criteria andCertNoEqualTo(String value) {
            addCriterion("cert_no =", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotEqualTo(String value) {
            addCriterion("cert_no <>", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThan(String value) {
            addCriterion("cert_no >", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("cert_no >=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThan(String value) {
            addCriterion("cert_no <", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLessThanOrEqualTo(String value) {
            addCriterion("cert_no <=", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoLike(String value) {
            addCriterion("cert_no like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotLike(String value) {
            addCriterion("cert_no not like", value, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoIn(List<String> values) {
            addCriterion("cert_no in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotIn(List<String> values) {
            addCriterion("cert_no not in", values, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoBetween(String value1, String value2) {
            addCriterion("cert_no between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andCertNoNotBetween(String value1, String value2) {
            addCriterion("cert_no not between", value1, value2, "certNo");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIsNull() {
            addCriterion("member_type is null");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIsNotNull() {
            addCriterion("member_type is not null");
            return (Criteria) this;
        }

        public Criteria andMemberTypeEqualTo(String value) {
            addCriterion("member_type =", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeNotEqualTo(String value) {
            addCriterion("member_type <>", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeGreaterThan(String value) {
            addCriterion("member_type >", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeGreaterThanOrEqualTo(String value) {
            addCriterion("member_type >=", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeLessThan(String value) {
            addCriterion("member_type <", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeLessThanOrEqualTo(String value) {
            addCriterion("member_type <=", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeLike(String value) {
            addCriterion("member_type like", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeNotLike(String value) {
            addCriterion("member_type not like", value, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeIn(List<String> values) {
            addCriterion("member_type in", values, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeNotIn(List<String> values) {
            addCriterion("member_type not in", values, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeBetween(String value1, String value2) {
            addCriterion("member_type between", value1, value2, "memberType");
            return (Criteria) this;
        }

        public Criteria andMemberTypeNotBetween(String value1, String value2) {
            addCriterion("member_type not between", value1, value2, "memberType");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNull() {
            addCriterion("card_no is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("card_no is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("card_no =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("card_no <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("card_no >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("card_no >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("card_no <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("card_no <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("card_no like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("card_no not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("card_no in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("card_no not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("card_no between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("card_no not between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNull() {
            addCriterion("car_number is null");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNotNull() {
            addCriterion("car_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumberEqualTo(String value) {
            addCriterion("car_number =", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotEqualTo(String value) {
            addCriterion("car_number <>", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThan(String value) {
            addCriterion("car_number >", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_number >=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThan(String value) {
            addCriterion("car_number <", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThanOrEqualTo(String value) {
            addCriterion("car_number <=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLike(String value) {
            addCriterion("car_number like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotLike(String value) {
            addCriterion("car_number not like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberIn(List<String> values) {
            addCriterion("car_number in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotIn(List<String> values) {
            addCriterion("car_number not in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberBetween(String value1, String value2) {
            addCriterion("car_number between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotBetween(String value1, String value2) {
            addCriterion("car_number not between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andOilTypeIsNull() {
            addCriterion("oil_type is null");
            return (Criteria) this;
        }

        public Criteria andOilTypeIsNotNull() {
            addCriterion("oil_type is not null");
            return (Criteria) this;
        }

        public Criteria andOilTypeEqualTo(String value) {
            addCriterion("oil_type =", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeNotEqualTo(String value) {
            addCriterion("oil_type <>", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeGreaterThan(String value) {
            addCriterion("oil_type >", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeGreaterThanOrEqualTo(String value) {
            addCriterion("oil_type >=", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeLessThan(String value) {
            addCriterion("oil_type <", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeLessThanOrEqualTo(String value) {
            addCriterion("oil_type <=", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeLike(String value) {
            addCriterion("oil_type like", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeNotLike(String value) {
            addCriterion("oil_type not like", value, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeIn(List<String> values) {
            addCriterion("oil_type in", values, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeNotIn(List<String> values) {
            addCriterion("oil_type not in", values, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeBetween(String value1, String value2) {
            addCriterion("oil_type between", value1, value2, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilTypeNotBetween(String value1, String value2) {
            addCriterion("oil_type not between", value1, value2, "oilType");
            return (Criteria) this;
        }

        public Criteria andOilCodeIsNull() {
            addCriterion("oil_code is null");
            return (Criteria) this;
        }

        public Criteria andOilCodeIsNotNull() {
            addCriterion("oil_code is not null");
            return (Criteria) this;
        }

        public Criteria andOilCodeEqualTo(String value) {
            addCriterion("oil_code =", value, "oilCode");
            return (Criteria) this;
        }

        public Criteria andOilCodeNotEqualTo(String value) {
            addCriterion("oil_code <>", value, "oilCode");
            return (Criteria) this;
        }

        public Criteria andOilCodeGreaterThan(String value) {
            addCriterion("oil_code >", value, "oilCode");
            return (Criteria) this;
        }

        public Criteria andOilCodeGreaterThanOrEqualTo(String value) {
            addCriterion("oil_code >=", value, "oilCode");
            return (Criteria) this;
        }

        public Criteria andOilCodeLessThan(String value) {
            addCriterion("oil_code <", value, "oilCode");
            return (Criteria) this;
        }

        public Criteria andOilCodeLessThanOrEqualTo(String value) {
            addCriterion("oil_code <=", value, "oilCode");
            return (Criteria) this;
        }

        public Criteria andOilCodeLike(String value) {
            addCriterion("oil_code like", value, "oilCode");
            return (Criteria) this;
        }

        public Criteria andOilCodeNotLike(String value) {
            addCriterion("oil_code not like", value, "oilCode");
            return (Criteria) this;
        }

        public Criteria andOilCodeIn(List<String> values) {
            addCriterion("oil_code in", values, "oilCode");
            return (Criteria) this;
        }

        public Criteria andOilCodeNotIn(List<String> values) {
            addCriterion("oil_code not in", values, "oilCode");
            return (Criteria) this;
        }

        public Criteria andOilCodeBetween(String value1, String value2) {
            addCriterion("oil_code between", value1, value2, "oilCode");
            return (Criteria) this;
        }

        public Criteria andOilCodeNotBetween(String value1, String value2) {
            addCriterion("oil_code not between", value1, value2, "oilCode");
            return (Criteria) this;
        }

        public Criteria andOilNameIsNull() {
            addCriterion("oil_name is null");
            return (Criteria) this;
        }

        public Criteria andOilNameIsNotNull() {
            addCriterion("oil_name is not null");
            return (Criteria) this;
        }

        public Criteria andOilNameEqualTo(String value) {
            addCriterion("oil_name =", value, "oilName");
            return (Criteria) this;
        }

        public Criteria andOilNameNotEqualTo(String value) {
            addCriterion("oil_name <>", value, "oilName");
            return (Criteria) this;
        }

        public Criteria andOilNameGreaterThan(String value) {
            addCriterion("oil_name >", value, "oilName");
            return (Criteria) this;
        }

        public Criteria andOilNameGreaterThanOrEqualTo(String value) {
            addCriterion("oil_name >=", value, "oilName");
            return (Criteria) this;
        }

        public Criteria andOilNameLessThan(String value) {
            addCriterion("oil_name <", value, "oilName");
            return (Criteria) this;
        }

        public Criteria andOilNameLessThanOrEqualTo(String value) {
            addCriterion("oil_name <=", value, "oilName");
            return (Criteria) this;
        }

        public Criteria andOilNameLike(String value) {
            addCriterion("oil_name like", value, "oilName");
            return (Criteria) this;
        }

        public Criteria andOilNameNotLike(String value) {
            addCriterion("oil_name not like", value, "oilName");
            return (Criteria) this;
        }

        public Criteria andOilNameIn(List<String> values) {
            addCriterion("oil_name in", values, "oilName");
            return (Criteria) this;
        }

        public Criteria andOilNameNotIn(List<String> values) {
            addCriterion("oil_name not in", values, "oilName");
            return (Criteria) this;
        }

        public Criteria andOilNameBetween(String value1, String value2) {
            addCriterion("oil_name between", value1, value2, "oilName");
            return (Criteria) this;
        }

        public Criteria andOilNameNotBetween(String value1, String value2) {
            addCriterion("oil_name not between", value1, value2, "oilName");
            return (Criteria) this;
        }

        public Criteria andOilPriceIsNull() {
            addCriterion("oil_price is null");
            return (Criteria) this;
        }

        public Criteria andOilPriceIsNotNull() {
            addCriterion("oil_price is not null");
            return (Criteria) this;
        }

        public Criteria andOilPriceEqualTo(Long value) {
            addCriterion("oil_price =", value, "oilPrice");
            return (Criteria) this;
        }

        public Criteria andOilPriceNotEqualTo(Long value) {
            addCriterion("oil_price <>", value, "oilPrice");
            return (Criteria) this;
        }

        public Criteria andOilPriceGreaterThan(Long value) {
            addCriterion("oil_price >", value, "oilPrice");
            return (Criteria) this;
        }

        public Criteria andOilPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("oil_price >=", value, "oilPrice");
            return (Criteria) this;
        }

        public Criteria andOilPriceLessThan(Long value) {
            addCriterion("oil_price <", value, "oilPrice");
            return (Criteria) this;
        }

        public Criteria andOilPriceLessThanOrEqualTo(Long value) {
            addCriterion("oil_price <=", value, "oilPrice");
            return (Criteria) this;
        }

        public Criteria andOilPriceIn(List<Long> values) {
            addCriterion("oil_price in", values, "oilPrice");
            return (Criteria) this;
        }

        public Criteria andOilPriceNotIn(List<Long> values) {
            addCriterion("oil_price not in", values, "oilPrice");
            return (Criteria) this;
        }

        public Criteria andOilPriceBetween(Long value1, Long value2) {
            addCriterion("oil_price between", value1, value2, "oilPrice");
            return (Criteria) this;
        }

        public Criteria andOilPriceNotBetween(Long value1, Long value2) {
            addCriterion("oil_price not between", value1, value2, "oilPrice");
            return (Criteria) this;
        }

        public Criteria andOilLiterIsNull() {
            addCriterion("oil_liter is null");
            return (Criteria) this;
        }

        public Criteria andOilLiterIsNotNull() {
            addCriterion("oil_liter is not null");
            return (Criteria) this;
        }

        public Criteria andOilLiterEqualTo(Double value) {
            addCriterion("oil_liter =", value, "oilLiter");
            return (Criteria) this;
        }

        public Criteria andOilLiterNotEqualTo(Double value) {
            addCriterion("oil_liter <>", value, "oilLiter");
            return (Criteria) this;
        }

        public Criteria andOilLiterGreaterThan(Double value) {
            addCriterion("oil_liter >", value, "oilLiter");
            return (Criteria) this;
        }

        public Criteria andOilLiterGreaterThanOrEqualTo(Double value) {
            addCriterion("oil_liter >=", value, "oilLiter");
            return (Criteria) this;
        }

        public Criteria andOilLiterLessThan(Double value) {
            addCriterion("oil_liter <", value, "oilLiter");
            return (Criteria) this;
        }

        public Criteria andOilLiterLessThanOrEqualTo(Double value) {
            addCriterion("oil_liter <=", value, "oilLiter");
            return (Criteria) this;
        }

        public Criteria andOilLiterIn(List<Double> values) {
            addCriterion("oil_liter in", values, "oilLiter");
            return (Criteria) this;
        }

        public Criteria andOilLiterNotIn(List<Double> values) {
            addCriterion("oil_liter not in", values, "oilLiter");
            return (Criteria) this;
        }

        public Criteria andOilLiterBetween(Double value1, Double value2) {
            addCriterion("oil_liter between", value1, value2, "oilLiter");
            return (Criteria) this;
        }

        public Criteria andOilLiterNotBetween(Double value1, Double value2) {
            addCriterion("oil_liter not between", value1, value2, "oilLiter");
            return (Criteria) this;
        }

        public Criteria andOilGunIsNull() {
            addCriterion("oil_gun is null");
            return (Criteria) this;
        }

        public Criteria andOilGunIsNotNull() {
            addCriterion("oil_gun is not null");
            return (Criteria) this;
        }

        public Criteria andOilGunEqualTo(String value) {
            addCriterion("oil_gun =", value, "oilGun");
            return (Criteria) this;
        }

        public Criteria andOilGunNotEqualTo(String value) {
            addCriterion("oil_gun <>", value, "oilGun");
            return (Criteria) this;
        }

        public Criteria andOilGunGreaterThan(String value) {
            addCriterion("oil_gun >", value, "oilGun");
            return (Criteria) this;
        }

        public Criteria andOilGunGreaterThanOrEqualTo(String value) {
            addCriterion("oil_gun >=", value, "oilGun");
            return (Criteria) this;
        }

        public Criteria andOilGunLessThan(String value) {
            addCriterion("oil_gun <", value, "oilGun");
            return (Criteria) this;
        }

        public Criteria andOilGunLessThanOrEqualTo(String value) {
            addCriterion("oil_gun <=", value, "oilGun");
            return (Criteria) this;
        }

        public Criteria andOilGunLike(String value) {
            addCriterion("oil_gun like", value, "oilGun");
            return (Criteria) this;
        }

        public Criteria andOilGunNotLike(String value) {
            addCriterion("oil_gun not like", value, "oilGun");
            return (Criteria) this;
        }

        public Criteria andOilGunIn(List<String> values) {
            addCriterion("oil_gun in", values, "oilGun");
            return (Criteria) this;
        }

        public Criteria andOilGunNotIn(List<String> values) {
            addCriterion("oil_gun not in", values, "oilGun");
            return (Criteria) this;
        }

        public Criteria andOilGunBetween(String value1, String value2) {
            addCriterion("oil_gun between", value1, value2, "oilGun");
            return (Criteria) this;
        }

        public Criteria andOilGunNotBetween(String value1, String value2) {
            addCriterion("oil_gun not between", value1, value2, "oilGun");
            return (Criteria) this;
        }

        public Criteria andOilAmountIsNull() {
            addCriterion("oil_amount is null");
            return (Criteria) this;
        }

        public Criteria andOilAmountIsNotNull() {
            addCriterion("oil_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOilAmountEqualTo(Long value) {
            addCriterion("oil_amount =", value, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountNotEqualTo(Long value) {
            addCriterion("oil_amount <>", value, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountGreaterThan(Long value) {
            addCriterion("oil_amount >", value, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("oil_amount >=", value, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountLessThan(Long value) {
            addCriterion("oil_amount <", value, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountLessThanOrEqualTo(Long value) {
            addCriterion("oil_amount <=", value, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountIn(List<Long> values) {
            addCriterion("oil_amount in", values, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountNotIn(List<Long> values) {
            addCriterion("oil_amount not in", values, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountBetween(Long value1, Long value2) {
            addCriterion("oil_amount between", value1, value2, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilAmountNotBetween(Long value1, Long value2) {
            addCriterion("oil_amount not between", value1, value2, "oilAmount");
            return (Criteria) this;
        }

        public Criteria andOilFavourAmountIsNull() {
            addCriterion("oil_favour_amount is null");
            return (Criteria) this;
        }

        public Criteria andOilFavourAmountIsNotNull() {
            addCriterion("oil_favour_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOilFavourAmountEqualTo(Long value) {
            addCriterion("oil_favour_amount =", value, "oilFavourAmount");
            return (Criteria) this;
        }

        public Criteria andOilFavourAmountNotEqualTo(Long value) {
            addCriterion("oil_favour_amount <>", value, "oilFavourAmount");
            return (Criteria) this;
        }

        public Criteria andOilFavourAmountGreaterThan(Long value) {
            addCriterion("oil_favour_amount >", value, "oilFavourAmount");
            return (Criteria) this;
        }

        public Criteria andOilFavourAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("oil_favour_amount >=", value, "oilFavourAmount");
            return (Criteria) this;
        }

        public Criteria andOilFavourAmountLessThan(Long value) {
            addCriterion("oil_favour_amount <", value, "oilFavourAmount");
            return (Criteria) this;
        }

        public Criteria andOilFavourAmountLessThanOrEqualTo(Long value) {
            addCriterion("oil_favour_amount <=", value, "oilFavourAmount");
            return (Criteria) this;
        }

        public Criteria andOilFavourAmountIn(List<Long> values) {
            addCriterion("oil_favour_amount in", values, "oilFavourAmount");
            return (Criteria) this;
        }

        public Criteria andOilFavourAmountNotIn(List<Long> values) {
            addCriterion("oil_favour_amount not in", values, "oilFavourAmount");
            return (Criteria) this;
        }

        public Criteria andOilFavourAmountBetween(Long value1, Long value2) {
            addCriterion("oil_favour_amount between", value1, value2, "oilFavourAmount");
            return (Criteria) this;
        }

        public Criteria andOilFavourAmountNotBetween(Long value1, Long value2) {
            addCriterion("oil_favour_amount not between", value1, value2, "oilFavourAmount");
            return (Criteria) this;
        }

        public Criteria andTradePayTypeIsNull() {
            addCriterion("trade_pay_type is null");
            return (Criteria) this;
        }

        public Criteria andTradePayTypeIsNotNull() {
            addCriterion("trade_pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradePayTypeEqualTo(String value) {
            addCriterion("trade_pay_type =", value, "tradePayType");
            return (Criteria) this;
        }

        public Criteria andTradePayTypeNotEqualTo(String value) {
            addCriterion("trade_pay_type <>", value, "tradePayType");
            return (Criteria) this;
        }

        public Criteria andTradePayTypeGreaterThan(String value) {
            addCriterion("trade_pay_type >", value, "tradePayType");
            return (Criteria) this;
        }

        public Criteria andTradePayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trade_pay_type >=", value, "tradePayType");
            return (Criteria) this;
        }

        public Criteria andTradePayTypeLessThan(String value) {
            addCriterion("trade_pay_type <", value, "tradePayType");
            return (Criteria) this;
        }

        public Criteria andTradePayTypeLessThanOrEqualTo(String value) {
            addCriterion("trade_pay_type <=", value, "tradePayType");
            return (Criteria) this;
        }

        public Criteria andTradePayTypeLike(String value) {
            addCriterion("trade_pay_type like", value, "tradePayType");
            return (Criteria) this;
        }

        public Criteria andTradePayTypeNotLike(String value) {
            addCriterion("trade_pay_type not like", value, "tradePayType");
            return (Criteria) this;
        }

        public Criteria andTradePayTypeIn(List<String> values) {
            addCriterion("trade_pay_type in", values, "tradePayType");
            return (Criteria) this;
        }

        public Criteria andTradePayTypeNotIn(List<String> values) {
            addCriterion("trade_pay_type not in", values, "tradePayType");
            return (Criteria) this;
        }

        public Criteria andTradePayTypeBetween(String value1, String value2) {
            addCriterion("trade_pay_type between", value1, value2, "tradePayType");
            return (Criteria) this;
        }

        public Criteria andTradePayTypeNotBetween(String value1, String value2) {
            addCriterion("trade_pay_type not between", value1, value2, "tradePayType");
            return (Criteria) this;
        }

        public Criteria andPayModelIsNull() {
            addCriterion("pay_model is null");
            return (Criteria) this;
        }

        public Criteria andPayModelIsNotNull() {
            addCriterion("pay_model is not null");
            return (Criteria) this;
        }

        public Criteria andPayModelEqualTo(String value) {
            addCriterion("pay_model =", value, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelNotEqualTo(String value) {
            addCriterion("pay_model <>", value, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelGreaterThan(String value) {
            addCriterion("pay_model >", value, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelGreaterThanOrEqualTo(String value) {
            addCriterion("pay_model >=", value, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelLessThan(String value) {
            addCriterion("pay_model <", value, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelLessThanOrEqualTo(String value) {
            addCriterion("pay_model <=", value, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelLike(String value) {
            addCriterion("pay_model like", value, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelNotLike(String value) {
            addCriterion("pay_model not like", value, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelIn(List<String> values) {
            addCriterion("pay_model in", values, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelNotIn(List<String> values) {
            addCriterion("pay_model not in", values, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelBetween(String value1, String value2) {
            addCriterion("pay_model between", value1, value2, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelNotBetween(String value1, String value2) {
            addCriterion("pay_model not between", value1, value2, "payModel");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
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