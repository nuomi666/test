package dal.model.pay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BatchStepExecutionDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BatchStepExecutionDOExample() {
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

        public Criteria andStepExecutionIdIsNull() {
            addCriterion("STEP_EXECUTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andStepExecutionIdIsNotNull() {
            addCriterion("STEP_EXECUTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStepExecutionIdEqualTo(Long value) {
            addCriterion("STEP_EXECUTION_ID =", value, "stepExecutionId");
            return (Criteria) this;
        }

        public Criteria andStepExecutionIdNotEqualTo(Long value) {
            addCriterion("STEP_EXECUTION_ID <>", value, "stepExecutionId");
            return (Criteria) this;
        }

        public Criteria andStepExecutionIdGreaterThan(Long value) {
            addCriterion("STEP_EXECUTION_ID >", value, "stepExecutionId");
            return (Criteria) this;
        }

        public Criteria andStepExecutionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("STEP_EXECUTION_ID >=", value, "stepExecutionId");
            return (Criteria) this;
        }

        public Criteria andStepExecutionIdLessThan(Long value) {
            addCriterion("STEP_EXECUTION_ID <", value, "stepExecutionId");
            return (Criteria) this;
        }

        public Criteria andStepExecutionIdLessThanOrEqualTo(Long value) {
            addCriterion("STEP_EXECUTION_ID <=", value, "stepExecutionId");
            return (Criteria) this;
        }

        public Criteria andStepExecutionIdIn(List<Long> values) {
            addCriterion("STEP_EXECUTION_ID in", values, "stepExecutionId");
            return (Criteria) this;
        }

        public Criteria andStepExecutionIdNotIn(List<Long> values) {
            addCriterion("STEP_EXECUTION_ID not in", values, "stepExecutionId");
            return (Criteria) this;
        }

        public Criteria andStepExecutionIdBetween(Long value1, Long value2) {
            addCriterion("STEP_EXECUTION_ID between", value1, value2, "stepExecutionId");
            return (Criteria) this;
        }

        public Criteria andStepExecutionIdNotBetween(Long value1, Long value2) {
            addCriterion("STEP_EXECUTION_ID not between", value1, value2, "stepExecutionId");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNull() {
            addCriterion("STEP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNotNull() {
            addCriterion("STEP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStepNameEqualTo(String value) {
            addCriterion("STEP_NAME =", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotEqualTo(String value) {
            addCriterion("STEP_NAME <>", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThan(String value) {
            addCriterion("STEP_NAME >", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThanOrEqualTo(String value) {
            addCriterion("STEP_NAME >=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThan(String value) {
            addCriterion("STEP_NAME <", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThanOrEqualTo(String value) {
            addCriterion("STEP_NAME <=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLike(String value) {
            addCriterion("STEP_NAME like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotLike(String value) {
            addCriterion("STEP_NAME not like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameIn(List<String> values) {
            addCriterion("STEP_NAME in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotIn(List<String> values) {
            addCriterion("STEP_NAME not in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameBetween(String value1, String value2) {
            addCriterion("STEP_NAME between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotBetween(String value1, String value2) {
            addCriterion("STEP_NAME not between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdIsNull() {
            addCriterion("JOB_EXECUTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdIsNotNull() {
            addCriterion("JOB_EXECUTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdEqualTo(Long value) {
            addCriterion("JOB_EXECUTION_ID =", value, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdNotEqualTo(Long value) {
            addCriterion("JOB_EXECUTION_ID <>", value, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdGreaterThan(Long value) {
            addCriterion("JOB_EXECUTION_ID >", value, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("JOB_EXECUTION_ID >=", value, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdLessThan(Long value) {
            addCriterion("JOB_EXECUTION_ID <", value, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdLessThanOrEqualTo(Long value) {
            addCriterion("JOB_EXECUTION_ID <=", value, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdIn(List<Long> values) {
            addCriterion("JOB_EXECUTION_ID in", values, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdNotIn(List<Long> values) {
            addCriterion("JOB_EXECUTION_ID not in", values, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdBetween(Long value1, Long value2) {
            addCriterion("JOB_EXECUTION_ID between", value1, value2, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andJobExecutionIdNotBetween(Long value1, Long value2) {
            addCriterion("JOB_EXECUTION_ID not between", value1, value2, "jobExecutionId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCommitCountIsNull() {
            addCriterion("COMMIT_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andCommitCountIsNotNull() {
            addCriterion("COMMIT_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andCommitCountEqualTo(Long value) {
            addCriterion("COMMIT_COUNT =", value, "commitCount");
            return (Criteria) this;
        }

        public Criteria andCommitCountNotEqualTo(Long value) {
            addCriterion("COMMIT_COUNT <>", value, "commitCount");
            return (Criteria) this;
        }

        public Criteria andCommitCountGreaterThan(Long value) {
            addCriterion("COMMIT_COUNT >", value, "commitCount");
            return (Criteria) this;
        }

        public Criteria andCommitCountGreaterThanOrEqualTo(Long value) {
            addCriterion("COMMIT_COUNT >=", value, "commitCount");
            return (Criteria) this;
        }

        public Criteria andCommitCountLessThan(Long value) {
            addCriterion("COMMIT_COUNT <", value, "commitCount");
            return (Criteria) this;
        }

        public Criteria andCommitCountLessThanOrEqualTo(Long value) {
            addCriterion("COMMIT_COUNT <=", value, "commitCount");
            return (Criteria) this;
        }

        public Criteria andCommitCountIn(List<Long> values) {
            addCriterion("COMMIT_COUNT in", values, "commitCount");
            return (Criteria) this;
        }

        public Criteria andCommitCountNotIn(List<Long> values) {
            addCriterion("COMMIT_COUNT not in", values, "commitCount");
            return (Criteria) this;
        }

        public Criteria andCommitCountBetween(Long value1, Long value2) {
            addCriterion("COMMIT_COUNT between", value1, value2, "commitCount");
            return (Criteria) this;
        }

        public Criteria andCommitCountNotBetween(Long value1, Long value2) {
            addCriterion("COMMIT_COUNT not between", value1, value2, "commitCount");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNull() {
            addCriterion("READ_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNotNull() {
            addCriterion("READ_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReadCountEqualTo(Long value) {
            addCriterion("READ_COUNT =", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotEqualTo(Long value) {
            addCriterion("READ_COUNT <>", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThan(Long value) {
            addCriterion("READ_COUNT >", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThanOrEqualTo(Long value) {
            addCriterion("READ_COUNT >=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThan(Long value) {
            addCriterion("READ_COUNT <", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThanOrEqualTo(Long value) {
            addCriterion("READ_COUNT <=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountIn(List<Long> values) {
            addCriterion("READ_COUNT in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotIn(List<Long> values) {
            addCriterion("READ_COUNT not in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountBetween(Long value1, Long value2) {
            addCriterion("READ_COUNT between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotBetween(Long value1, Long value2) {
            addCriterion("READ_COUNT not between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andFilterCountIsNull() {
            addCriterion("FILTER_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andFilterCountIsNotNull() {
            addCriterion("FILTER_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andFilterCountEqualTo(Long value) {
            addCriterion("FILTER_COUNT =", value, "filterCount");
            return (Criteria) this;
        }

        public Criteria andFilterCountNotEqualTo(Long value) {
            addCriterion("FILTER_COUNT <>", value, "filterCount");
            return (Criteria) this;
        }

        public Criteria andFilterCountGreaterThan(Long value) {
            addCriterion("FILTER_COUNT >", value, "filterCount");
            return (Criteria) this;
        }

        public Criteria andFilterCountGreaterThanOrEqualTo(Long value) {
            addCriterion("FILTER_COUNT >=", value, "filterCount");
            return (Criteria) this;
        }

        public Criteria andFilterCountLessThan(Long value) {
            addCriterion("FILTER_COUNT <", value, "filterCount");
            return (Criteria) this;
        }

        public Criteria andFilterCountLessThanOrEqualTo(Long value) {
            addCriterion("FILTER_COUNT <=", value, "filterCount");
            return (Criteria) this;
        }

        public Criteria andFilterCountIn(List<Long> values) {
            addCriterion("FILTER_COUNT in", values, "filterCount");
            return (Criteria) this;
        }

        public Criteria andFilterCountNotIn(List<Long> values) {
            addCriterion("FILTER_COUNT not in", values, "filterCount");
            return (Criteria) this;
        }

        public Criteria andFilterCountBetween(Long value1, Long value2) {
            addCriterion("FILTER_COUNT between", value1, value2, "filterCount");
            return (Criteria) this;
        }

        public Criteria andFilterCountNotBetween(Long value1, Long value2) {
            addCriterion("FILTER_COUNT not between", value1, value2, "filterCount");
            return (Criteria) this;
        }

        public Criteria andWriteCountIsNull() {
            addCriterion("WRITE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andWriteCountIsNotNull() {
            addCriterion("WRITE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andWriteCountEqualTo(Long value) {
            addCriterion("WRITE_COUNT =", value, "writeCount");
            return (Criteria) this;
        }

        public Criteria andWriteCountNotEqualTo(Long value) {
            addCriterion("WRITE_COUNT <>", value, "writeCount");
            return (Criteria) this;
        }

        public Criteria andWriteCountGreaterThan(Long value) {
            addCriterion("WRITE_COUNT >", value, "writeCount");
            return (Criteria) this;
        }

        public Criteria andWriteCountGreaterThanOrEqualTo(Long value) {
            addCriterion("WRITE_COUNT >=", value, "writeCount");
            return (Criteria) this;
        }

        public Criteria andWriteCountLessThan(Long value) {
            addCriterion("WRITE_COUNT <", value, "writeCount");
            return (Criteria) this;
        }

        public Criteria andWriteCountLessThanOrEqualTo(Long value) {
            addCriterion("WRITE_COUNT <=", value, "writeCount");
            return (Criteria) this;
        }

        public Criteria andWriteCountIn(List<Long> values) {
            addCriterion("WRITE_COUNT in", values, "writeCount");
            return (Criteria) this;
        }

        public Criteria andWriteCountNotIn(List<Long> values) {
            addCriterion("WRITE_COUNT not in", values, "writeCount");
            return (Criteria) this;
        }

        public Criteria andWriteCountBetween(Long value1, Long value2) {
            addCriterion("WRITE_COUNT between", value1, value2, "writeCount");
            return (Criteria) this;
        }

        public Criteria andWriteCountNotBetween(Long value1, Long value2) {
            addCriterion("WRITE_COUNT not between", value1, value2, "writeCount");
            return (Criteria) this;
        }

        public Criteria andReadSkipCountIsNull() {
            addCriterion("READ_SKIP_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andReadSkipCountIsNotNull() {
            addCriterion("READ_SKIP_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReadSkipCountEqualTo(Long value) {
            addCriterion("READ_SKIP_COUNT =", value, "readSkipCount");
            return (Criteria) this;
        }

        public Criteria andReadSkipCountNotEqualTo(Long value) {
            addCriterion("READ_SKIP_COUNT <>", value, "readSkipCount");
            return (Criteria) this;
        }

        public Criteria andReadSkipCountGreaterThan(Long value) {
            addCriterion("READ_SKIP_COUNT >", value, "readSkipCount");
            return (Criteria) this;
        }

        public Criteria andReadSkipCountGreaterThanOrEqualTo(Long value) {
            addCriterion("READ_SKIP_COUNT >=", value, "readSkipCount");
            return (Criteria) this;
        }

        public Criteria andReadSkipCountLessThan(Long value) {
            addCriterion("READ_SKIP_COUNT <", value, "readSkipCount");
            return (Criteria) this;
        }

        public Criteria andReadSkipCountLessThanOrEqualTo(Long value) {
            addCriterion("READ_SKIP_COUNT <=", value, "readSkipCount");
            return (Criteria) this;
        }

        public Criteria andReadSkipCountIn(List<Long> values) {
            addCriterion("READ_SKIP_COUNT in", values, "readSkipCount");
            return (Criteria) this;
        }

        public Criteria andReadSkipCountNotIn(List<Long> values) {
            addCriterion("READ_SKIP_COUNT not in", values, "readSkipCount");
            return (Criteria) this;
        }

        public Criteria andReadSkipCountBetween(Long value1, Long value2) {
            addCriterion("READ_SKIP_COUNT between", value1, value2, "readSkipCount");
            return (Criteria) this;
        }

        public Criteria andReadSkipCountNotBetween(Long value1, Long value2) {
            addCriterion("READ_SKIP_COUNT not between", value1, value2, "readSkipCount");
            return (Criteria) this;
        }

        public Criteria andWriteSkipCountIsNull() {
            addCriterion("WRITE_SKIP_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andWriteSkipCountIsNotNull() {
            addCriterion("WRITE_SKIP_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andWriteSkipCountEqualTo(Long value) {
            addCriterion("WRITE_SKIP_COUNT =", value, "writeSkipCount");
            return (Criteria) this;
        }

        public Criteria andWriteSkipCountNotEqualTo(Long value) {
            addCriterion("WRITE_SKIP_COUNT <>", value, "writeSkipCount");
            return (Criteria) this;
        }

        public Criteria andWriteSkipCountGreaterThan(Long value) {
            addCriterion("WRITE_SKIP_COUNT >", value, "writeSkipCount");
            return (Criteria) this;
        }

        public Criteria andWriteSkipCountGreaterThanOrEqualTo(Long value) {
            addCriterion("WRITE_SKIP_COUNT >=", value, "writeSkipCount");
            return (Criteria) this;
        }

        public Criteria andWriteSkipCountLessThan(Long value) {
            addCriterion("WRITE_SKIP_COUNT <", value, "writeSkipCount");
            return (Criteria) this;
        }

        public Criteria andWriteSkipCountLessThanOrEqualTo(Long value) {
            addCriterion("WRITE_SKIP_COUNT <=", value, "writeSkipCount");
            return (Criteria) this;
        }

        public Criteria andWriteSkipCountIn(List<Long> values) {
            addCriterion("WRITE_SKIP_COUNT in", values, "writeSkipCount");
            return (Criteria) this;
        }

        public Criteria andWriteSkipCountNotIn(List<Long> values) {
            addCriterion("WRITE_SKIP_COUNT not in", values, "writeSkipCount");
            return (Criteria) this;
        }

        public Criteria andWriteSkipCountBetween(Long value1, Long value2) {
            addCriterion("WRITE_SKIP_COUNT between", value1, value2, "writeSkipCount");
            return (Criteria) this;
        }

        public Criteria andWriteSkipCountNotBetween(Long value1, Long value2) {
            addCriterion("WRITE_SKIP_COUNT not between", value1, value2, "writeSkipCount");
            return (Criteria) this;
        }

        public Criteria andProcessSkipCountIsNull() {
            addCriterion("PROCESS_SKIP_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andProcessSkipCountIsNotNull() {
            addCriterion("PROCESS_SKIP_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andProcessSkipCountEqualTo(Long value) {
            addCriterion("PROCESS_SKIP_COUNT =", value, "processSkipCount");
            return (Criteria) this;
        }

        public Criteria andProcessSkipCountNotEqualTo(Long value) {
            addCriterion("PROCESS_SKIP_COUNT <>", value, "processSkipCount");
            return (Criteria) this;
        }

        public Criteria andProcessSkipCountGreaterThan(Long value) {
            addCriterion("PROCESS_SKIP_COUNT >", value, "processSkipCount");
            return (Criteria) this;
        }

        public Criteria andProcessSkipCountGreaterThanOrEqualTo(Long value) {
            addCriterion("PROCESS_SKIP_COUNT >=", value, "processSkipCount");
            return (Criteria) this;
        }

        public Criteria andProcessSkipCountLessThan(Long value) {
            addCriterion("PROCESS_SKIP_COUNT <", value, "processSkipCount");
            return (Criteria) this;
        }

        public Criteria andProcessSkipCountLessThanOrEqualTo(Long value) {
            addCriterion("PROCESS_SKIP_COUNT <=", value, "processSkipCount");
            return (Criteria) this;
        }

        public Criteria andProcessSkipCountIn(List<Long> values) {
            addCriterion("PROCESS_SKIP_COUNT in", values, "processSkipCount");
            return (Criteria) this;
        }

        public Criteria andProcessSkipCountNotIn(List<Long> values) {
            addCriterion("PROCESS_SKIP_COUNT not in", values, "processSkipCount");
            return (Criteria) this;
        }

        public Criteria andProcessSkipCountBetween(Long value1, Long value2) {
            addCriterion("PROCESS_SKIP_COUNT between", value1, value2, "processSkipCount");
            return (Criteria) this;
        }

        public Criteria andProcessSkipCountNotBetween(Long value1, Long value2) {
            addCriterion("PROCESS_SKIP_COUNT not between", value1, value2, "processSkipCount");
            return (Criteria) this;
        }

        public Criteria andRollbackCountIsNull() {
            addCriterion("ROLLBACK_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andRollbackCountIsNotNull() {
            addCriterion("ROLLBACK_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andRollbackCountEqualTo(Long value) {
            addCriterion("ROLLBACK_COUNT =", value, "rollbackCount");
            return (Criteria) this;
        }

        public Criteria andRollbackCountNotEqualTo(Long value) {
            addCriterion("ROLLBACK_COUNT <>", value, "rollbackCount");
            return (Criteria) this;
        }

        public Criteria andRollbackCountGreaterThan(Long value) {
            addCriterion("ROLLBACK_COUNT >", value, "rollbackCount");
            return (Criteria) this;
        }

        public Criteria andRollbackCountGreaterThanOrEqualTo(Long value) {
            addCriterion("ROLLBACK_COUNT >=", value, "rollbackCount");
            return (Criteria) this;
        }

        public Criteria andRollbackCountLessThan(Long value) {
            addCriterion("ROLLBACK_COUNT <", value, "rollbackCount");
            return (Criteria) this;
        }

        public Criteria andRollbackCountLessThanOrEqualTo(Long value) {
            addCriterion("ROLLBACK_COUNT <=", value, "rollbackCount");
            return (Criteria) this;
        }

        public Criteria andRollbackCountIn(List<Long> values) {
            addCriterion("ROLLBACK_COUNT in", values, "rollbackCount");
            return (Criteria) this;
        }

        public Criteria andRollbackCountNotIn(List<Long> values) {
            addCriterion("ROLLBACK_COUNT not in", values, "rollbackCount");
            return (Criteria) this;
        }

        public Criteria andRollbackCountBetween(Long value1, Long value2) {
            addCriterion("ROLLBACK_COUNT between", value1, value2, "rollbackCount");
            return (Criteria) this;
        }

        public Criteria andRollbackCountNotBetween(Long value1, Long value2) {
            addCriterion("ROLLBACK_COUNT not between", value1, value2, "rollbackCount");
            return (Criteria) this;
        }

        public Criteria andExitCodeIsNull() {
            addCriterion("EXIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andExitCodeIsNotNull() {
            addCriterion("EXIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andExitCodeEqualTo(String value) {
            addCriterion("EXIT_CODE =", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeNotEqualTo(String value) {
            addCriterion("EXIT_CODE <>", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeGreaterThan(String value) {
            addCriterion("EXIT_CODE >", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EXIT_CODE >=", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeLessThan(String value) {
            addCriterion("EXIT_CODE <", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeLessThanOrEqualTo(String value) {
            addCriterion("EXIT_CODE <=", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeLike(String value) {
            addCriterion("EXIT_CODE like", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeNotLike(String value) {
            addCriterion("EXIT_CODE not like", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeIn(List<String> values) {
            addCriterion("EXIT_CODE in", values, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeNotIn(List<String> values) {
            addCriterion("EXIT_CODE not in", values, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeBetween(String value1, String value2) {
            addCriterion("EXIT_CODE between", value1, value2, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeNotBetween(String value1, String value2) {
            addCriterion("EXIT_CODE not between", value1, value2, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitMessageIsNull() {
            addCriterion("EXIT_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andExitMessageIsNotNull() {
            addCriterion("EXIT_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andExitMessageEqualTo(String value) {
            addCriterion("EXIT_MESSAGE =", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageNotEqualTo(String value) {
            addCriterion("EXIT_MESSAGE <>", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageGreaterThan(String value) {
            addCriterion("EXIT_MESSAGE >", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageGreaterThanOrEqualTo(String value) {
            addCriterion("EXIT_MESSAGE >=", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageLessThan(String value) {
            addCriterion("EXIT_MESSAGE <", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageLessThanOrEqualTo(String value) {
            addCriterion("EXIT_MESSAGE <=", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageLike(String value) {
            addCriterion("EXIT_MESSAGE like", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageNotLike(String value) {
            addCriterion("EXIT_MESSAGE not like", value, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageIn(List<String> values) {
            addCriterion("EXIT_MESSAGE in", values, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageNotIn(List<String> values) {
            addCriterion("EXIT_MESSAGE not in", values, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageBetween(String value1, String value2) {
            addCriterion("EXIT_MESSAGE between", value1, value2, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andExitMessageNotBetween(String value1, String value2) {
            addCriterion("EXIT_MESSAGE not between", value1, value2, "exitMessage");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIsNull() {
            addCriterion("LAST_UPDATED is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIsNotNull() {
            addCriterion("LAST_UPDATED is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedEqualTo(Date value) {
            addCriterion("LAST_UPDATED =", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotEqualTo(Date value) {
            addCriterion("LAST_UPDATED <>", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThan(Date value) {
            addCriterion("LAST_UPDATED >", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATED >=", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThan(Date value) {
            addCriterion("LAST_UPDATED <", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATED <=", value, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedIn(List<Date> values) {
            addCriterion("LAST_UPDATED in", values, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotIn(List<Date> values) {
            addCriterion("LAST_UPDATED not in", values, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATED between", value1, value2, "lastUpdated");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATED not between", value1, value2, "lastUpdated");
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