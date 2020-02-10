package com.myproject.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class answerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public answerExample() {
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

        public Criteria andAnsweridIsNull() {
            addCriterion("answerID is null");
            return (Criteria) this;
        }

        public Criteria andAnsweridIsNotNull() {
            addCriterion("answerID is not null");
            return (Criteria) this;
        }

        public Criteria andAnsweridEqualTo(String value) {
            addCriterion("answerID =", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridNotEqualTo(String value) {
            addCriterion("answerID <>", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridGreaterThan(String value) {
            addCriterion("answerID >", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridGreaterThanOrEqualTo(String value) {
            addCriterion("answerID >=", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridLessThan(String value) {
            addCriterion("answerID <", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridLessThanOrEqualTo(String value) {
            addCriterion("answerID <=", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridLike(String value) {
            addCriterion("answerID like", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridNotLike(String value) {
            addCriterion("answerID not like", value, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridIn(List<String> values) {
            addCriterion("answerID in", values, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridNotIn(List<String> values) {
            addCriterion("answerID not in", values, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridBetween(String value1, String value2) {
            addCriterion("answerID between", value1, value2, "answerid");
            return (Criteria) this;
        }

        public Criteria andAnsweridNotBetween(String value1, String value2) {
            addCriterion("answerID not between", value1, value2, "answerid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andOptionsidIsNull() {
            addCriterion("optionsID is null");
            return (Criteria) this;
        }

        public Criteria andOptionsidIsNotNull() {
            addCriterion("optionsID is not null");
            return (Criteria) this;
        }

        public Criteria andOptionsidEqualTo(String value) {
            addCriterion("optionsID =", value, "optionsid");
            return (Criteria) this;
        }

        public Criteria andOptionsidNotEqualTo(String value) {
            addCriterion("optionsID <>", value, "optionsid");
            return (Criteria) this;
        }

        public Criteria andOptionsidGreaterThan(String value) {
            addCriterion("optionsID >", value, "optionsid");
            return (Criteria) this;
        }

        public Criteria andOptionsidGreaterThanOrEqualTo(String value) {
            addCriterion("optionsID >=", value, "optionsid");
            return (Criteria) this;
        }

        public Criteria andOptionsidLessThan(String value) {
            addCriterion("optionsID <", value, "optionsid");
            return (Criteria) this;
        }

        public Criteria andOptionsidLessThanOrEqualTo(String value) {
            addCriterion("optionsID <=", value, "optionsid");
            return (Criteria) this;
        }

        public Criteria andOptionsidLike(String value) {
            addCriterion("optionsID like", value, "optionsid");
            return (Criteria) this;
        }

        public Criteria andOptionsidNotLike(String value) {
            addCriterion("optionsID not like", value, "optionsid");
            return (Criteria) this;
        }

        public Criteria andOptionsidIn(List<String> values) {
            addCriterion("optionsID in", values, "optionsid");
            return (Criteria) this;
        }

        public Criteria andOptionsidNotIn(List<String> values) {
            addCriterion("optionsID not in", values, "optionsid");
            return (Criteria) this;
        }

        public Criteria andOptionsidBetween(String value1, String value2) {
            addCriterion("optionsID between", value1, value2, "optionsid");
            return (Criteria) this;
        }

        public Criteria andOptionsidNotBetween(String value1, String value2) {
            addCriterion("optionsID not between", value1, value2, "optionsid");
            return (Criteria) this;
        }

        public Criteria andQuestionnairenumberIsNull() {
            addCriterion("questionnaireNumber is null");
            return (Criteria) this;
        }

        public Criteria andQuestionnairenumberIsNotNull() {
            addCriterion("questionnaireNumber is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionnairenumberEqualTo(String value) {
            addCriterion("questionnaireNumber =", value, "questionnairenumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnairenumberNotEqualTo(String value) {
            addCriterion("questionnaireNumber <>", value, "questionnairenumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnairenumberGreaterThan(String value) {
            addCriterion("questionnaireNumber >", value, "questionnairenumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnairenumberGreaterThanOrEqualTo(String value) {
            addCriterion("questionnaireNumber >=", value, "questionnairenumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnairenumberLessThan(String value) {
            addCriterion("questionnaireNumber <", value, "questionnairenumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnairenumberLessThanOrEqualTo(String value) {
            addCriterion("questionnaireNumber <=", value, "questionnairenumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnairenumberLike(String value) {
            addCriterion("questionnaireNumber like", value, "questionnairenumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnairenumberNotLike(String value) {
            addCriterion("questionnaireNumber not like", value, "questionnairenumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnairenumberIn(List<String> values) {
            addCriterion("questionnaireNumber in", values, "questionnairenumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnairenumberNotIn(List<String> values) {
            addCriterion("questionnaireNumber not in", values, "questionnairenumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnairenumberBetween(String value1, String value2) {
            addCriterion("questionnaireNumber between", value1, value2, "questionnairenumber");
            return (Criteria) this;
        }

        public Criteria andQuestionnairenumberNotBetween(String value1, String value2) {
            addCriterion("questionnaireNumber not between", value1, value2, "questionnairenumber");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("value like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("value not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("value not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andSavetimeIsNull() {
            addCriterion("saveTime is null");
            return (Criteria) this;
        }

        public Criteria andSavetimeIsNotNull() {
            addCriterion("saveTime is not null");
            return (Criteria) this;
        }

        public Criteria andSavetimeEqualTo(Date value) {
            addCriterion("saveTime =", value, "savetime");
            return (Criteria) this;
        }

        public Criteria andSavetimeNotEqualTo(Date value) {
            addCriterion("saveTime <>", value, "savetime");
            return (Criteria) this;
        }

        public Criteria andSavetimeGreaterThan(Date value) {
            addCriterion("saveTime >", value, "savetime");
            return (Criteria) this;
        }

        public Criteria andSavetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("saveTime >=", value, "savetime");
            return (Criteria) this;
        }

        public Criteria andSavetimeLessThan(Date value) {
            addCriterion("saveTime <", value, "savetime");
            return (Criteria) this;
        }

        public Criteria andSavetimeLessThanOrEqualTo(Date value) {
            addCriterion("saveTime <=", value, "savetime");
            return (Criteria) this;
        }

        public Criteria andSavetimeIn(List<Date> values) {
            addCriterion("saveTime in", values, "savetime");
            return (Criteria) this;
        }

        public Criteria andSavetimeNotIn(List<Date> values) {
            addCriterion("saveTime not in", values, "savetime");
            return (Criteria) this;
        }

        public Criteria andSavetimeBetween(Date value1, Date value2) {
            addCriterion("saveTime between", value1, value2, "savetime");
            return (Criteria) this;
        }

        public Criteria andSavetimeNotBetween(Date value1, Date value2) {
            addCriterion("saveTime not between", value1, value2, "savetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeIsNull() {
            addCriterion("changeTime is null");
            return (Criteria) this;
        }

        public Criteria andChangetimeIsNotNull() {
            addCriterion("changeTime is not null");
            return (Criteria) this;
        }

        public Criteria andChangetimeEqualTo(Date value) {
            addCriterion("changeTime =", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeNotEqualTo(Date value) {
            addCriterion("changeTime <>", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeGreaterThan(Date value) {
            addCriterion("changeTime >", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("changeTime >=", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeLessThan(Date value) {
            addCriterion("changeTime <", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeLessThanOrEqualTo(Date value) {
            addCriterion("changeTime <=", value, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeIn(List<Date> values) {
            addCriterion("changeTime in", values, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeNotIn(List<Date> values) {
            addCriterion("changeTime not in", values, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeBetween(Date value1, Date value2) {
            addCriterion("changeTime between", value1, value2, "changetime");
            return (Criteria) this;
        }

        public Criteria andChangetimeNotBetween(Date value1, Date value2) {
            addCriterion("changeTime not between", value1, value2, "changetime");
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