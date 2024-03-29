package dal.model.gas_marketpc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PreciseGiveCouponDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PreciseGiveCouponDOExample() {
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

        public Criteria andCampaignNoIsNull() {
            addCriterion("campaign_no is null");
            return (Criteria) this;
        }

        public Criteria andCampaignNoIsNotNull() {
            addCriterion("campaign_no is not null");
            return (Criteria) this;
        }

        public Criteria andCampaignNoEqualTo(String value) {
            addCriterion("campaign_no =", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoNotEqualTo(String value) {
            addCriterion("campaign_no <>", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoGreaterThan(String value) {
            addCriterion("campaign_no >", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoGreaterThanOrEqualTo(String value) {
            addCriterion("campaign_no >=", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoLessThan(String value) {
            addCriterion("campaign_no <", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoLessThanOrEqualTo(String value) {
            addCriterion("campaign_no <=", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoLike(String value) {
            addCriterion("campaign_no like", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoNotLike(String value) {
            addCriterion("campaign_no not like", value, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoIn(List<String> values) {
            addCriterion("campaign_no in", values, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoNotIn(List<String> values) {
            addCriterion("campaign_no not in", values, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoBetween(String value1, String value2) {
            addCriterion("campaign_no between", value1, value2, "campaignNo");
            return (Criteria) this;
        }

        public Criteria andCampaignNoNotBetween(String value1, String value2) {
            addCriterion("campaign_no not between", value1, value2, "campaignNo");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andGiveCouponInfoIsNull() {
            addCriterion("give_coupon_info is null");
            return (Criteria) this;
        }

        public Criteria andGiveCouponInfoIsNotNull() {
            addCriterion("give_coupon_info is not null");
            return (Criteria) this;
        }

        public Criteria andGiveCouponInfoEqualTo(String value) {
            addCriterion("give_coupon_info =", value, "giveCouponInfo");
            return (Criteria) this;
        }

        public Criteria andGiveCouponInfoNotEqualTo(String value) {
            addCriterion("give_coupon_info <>", value, "giveCouponInfo");
            return (Criteria) this;
        }

        public Criteria andGiveCouponInfoGreaterThan(String value) {
            addCriterion("give_coupon_info >", value, "giveCouponInfo");
            return (Criteria) this;
        }

        public Criteria andGiveCouponInfoGreaterThanOrEqualTo(String value) {
            addCriterion("give_coupon_info >=", value, "giveCouponInfo");
            return (Criteria) this;
        }

        public Criteria andGiveCouponInfoLessThan(String value) {
            addCriterion("give_coupon_info <", value, "giveCouponInfo");
            return (Criteria) this;
        }

        public Criteria andGiveCouponInfoLessThanOrEqualTo(String value) {
            addCriterion("give_coupon_info <=", value, "giveCouponInfo");
            return (Criteria) this;
        }

        public Criteria andGiveCouponInfoLike(String value) {
            addCriterion("give_coupon_info like", value, "giveCouponInfo");
            return (Criteria) this;
        }

        public Criteria andGiveCouponInfoNotLike(String value) {
            addCriterion("give_coupon_info not like", value, "giveCouponInfo");
            return (Criteria) this;
        }

        public Criteria andGiveCouponInfoIn(List<String> values) {
            addCriterion("give_coupon_info in", values, "giveCouponInfo");
            return (Criteria) this;
        }

        public Criteria andGiveCouponInfoNotIn(List<String> values) {
            addCriterion("give_coupon_info not in", values, "giveCouponInfo");
            return (Criteria) this;
        }

        public Criteria andGiveCouponInfoBetween(String value1, String value2) {
            addCriterion("give_coupon_info between", value1, value2, "giveCouponInfo");
            return (Criteria) this;
        }

        public Criteria andGiveCouponInfoNotBetween(String value1, String value2) {
            addCriterion("give_coupon_info not between", value1, value2, "giveCouponInfo");
            return (Criteria) this;
        }

        public Criteria andPreciseGiveCouponRuleIsNull() {
            addCriterion("precise_give_coupon_rule is null");
            return (Criteria) this;
        }

        public Criteria andPreciseGiveCouponRuleIsNotNull() {
            addCriterion("precise_give_coupon_rule is not null");
            return (Criteria) this;
        }

        public Criteria andPreciseGiveCouponRuleEqualTo(String value) {
            addCriterion("precise_give_coupon_rule =", value, "preciseGiveCouponRule");
            return (Criteria) this;
        }

        public Criteria andPreciseGiveCouponRuleNotEqualTo(String value) {
            addCriterion("precise_give_coupon_rule <>", value, "preciseGiveCouponRule");
            return (Criteria) this;
        }

        public Criteria andPreciseGiveCouponRuleGreaterThan(String value) {
            addCriterion("precise_give_coupon_rule >", value, "preciseGiveCouponRule");
            return (Criteria) this;
        }

        public Criteria andPreciseGiveCouponRuleGreaterThanOrEqualTo(String value) {
            addCriterion("precise_give_coupon_rule >=", value, "preciseGiveCouponRule");
            return (Criteria) this;
        }

        public Criteria andPreciseGiveCouponRuleLessThan(String value) {
            addCriterion("precise_give_coupon_rule <", value, "preciseGiveCouponRule");
            return (Criteria) this;
        }

        public Criteria andPreciseGiveCouponRuleLessThanOrEqualTo(String value) {
            addCriterion("precise_give_coupon_rule <=", value, "preciseGiveCouponRule");
            return (Criteria) this;
        }

        public Criteria andPreciseGiveCouponRuleLike(String value) {
            addCriterion("precise_give_coupon_rule like", value, "preciseGiveCouponRule");
            return (Criteria) this;
        }

        public Criteria andPreciseGiveCouponRuleNotLike(String value) {
            addCriterion("precise_give_coupon_rule not like", value, "preciseGiveCouponRule");
            return (Criteria) this;
        }

        public Criteria andPreciseGiveCouponRuleIn(List<String> values) {
            addCriterion("precise_give_coupon_rule in", values, "preciseGiveCouponRule");
            return (Criteria) this;
        }

        public Criteria andPreciseGiveCouponRuleNotIn(List<String> values) {
            addCriterion("precise_give_coupon_rule not in", values, "preciseGiveCouponRule");
            return (Criteria) this;
        }

        public Criteria andPreciseGiveCouponRuleBetween(String value1, String value2) {
            addCriterion("precise_give_coupon_rule between", value1, value2, "preciseGiveCouponRule");
            return (Criteria) this;
        }

        public Criteria andPreciseGiveCouponRuleNotBetween(String value1, String value2) {
            addCriterion("precise_give_coupon_rule not between", value1, value2, "preciseGiveCouponRule");
            return (Criteria) this;
        }

        public Criteria andGiveTimeIsNull() {
            addCriterion("give_time is null");
            return (Criteria) this;
        }

        public Criteria andGiveTimeIsNotNull() {
            addCriterion("give_time is not null");
            return (Criteria) this;
        }

        public Criteria andGiveTimeEqualTo(Date value) {
            addCriterion("give_time =", value, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeNotEqualTo(Date value) {
            addCriterion("give_time <>", value, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeGreaterThan(Date value) {
            addCriterion("give_time >", value, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("give_time >=", value, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeLessThan(Date value) {
            addCriterion("give_time <", value, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("give_time <=", value, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeIn(List<Date> values) {
            addCriterion("give_time in", values, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeNotIn(List<Date> values) {
            addCriterion("give_time not in", values, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeBetween(Date value1, Date value2) {
            addCriterion("give_time between", value1, value2, "giveTime");
            return (Criteria) this;
        }

        public Criteria andGiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("give_time not between", value1, value2, "giveTime");
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

        public Criteria andRuleSetCodeIsNull() {
            addCriterion("rule_set_code is null");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeIsNotNull() {
            addCriterion("rule_set_code is not null");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeEqualTo(String value) {
            addCriterion("rule_set_code =", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeNotEqualTo(String value) {
            addCriterion("rule_set_code <>", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeGreaterThan(String value) {
            addCriterion("rule_set_code >", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeGreaterThanOrEqualTo(String value) {
            addCriterion("rule_set_code >=", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeLessThan(String value) {
            addCriterion("rule_set_code <", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeLessThanOrEqualTo(String value) {
            addCriterion("rule_set_code <=", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeLike(String value) {
            addCriterion("rule_set_code like", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeNotLike(String value) {
            addCriterion("rule_set_code not like", value, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeIn(List<String> values) {
            addCriterion("rule_set_code in", values, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeNotIn(List<String> values) {
            addCriterion("rule_set_code not in", values, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeBetween(String value1, String value2) {
            addCriterion("rule_set_code between", value1, value2, "ruleSetCode");
            return (Criteria) this;
        }

        public Criteria andRuleSetCodeNotBetween(String value1, String value2) {
            addCriterion("rule_set_code not between", value1, value2, "ruleSetCode");
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