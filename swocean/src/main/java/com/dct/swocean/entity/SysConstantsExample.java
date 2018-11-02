package com.dct.swocean.entity;

import java.util.ArrayList;
import java.util.List;

public class SysConstantsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysConstantsExample() {
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

        public Criteria andConstantGroupIsNull() {
            addCriterion("constant_group is null");
            return (Criteria) this;
        }

        public Criteria andConstantGroupIsNotNull() {
            addCriterion("constant_group is not null");
            return (Criteria) this;
        }

        public Criteria andConstantGroupEqualTo(String value) {
            addCriterion("constant_group =", value, "constantGroup");
            return (Criteria) this;
        }

        public Criteria andConstantGroupNotEqualTo(String value) {
            addCriterion("constant_group <>", value, "constantGroup");
            return (Criteria) this;
        }

        public Criteria andConstantGroupGreaterThan(String value) {
            addCriterion("constant_group >", value, "constantGroup");
            return (Criteria) this;
        }

        public Criteria andConstantGroupGreaterThanOrEqualTo(String value) {
            addCriterion("constant_group >=", value, "constantGroup");
            return (Criteria) this;
        }

        public Criteria andConstantGroupLessThan(String value) {
            addCriterion("constant_group <", value, "constantGroup");
            return (Criteria) this;
        }

        public Criteria andConstantGroupLessThanOrEqualTo(String value) {
            addCriterion("constant_group <=", value, "constantGroup");
            return (Criteria) this;
        }

        public Criteria andConstantGroupLike(String value) {
            addCriterion("constant_group like", value, "constantGroup");
            return (Criteria) this;
        }

        public Criteria andConstantGroupNotLike(String value) {
            addCriterion("constant_group not like", value, "constantGroup");
            return (Criteria) this;
        }

        public Criteria andConstantGroupIn(List<String> values) {
            addCriterion("constant_group in", values, "constantGroup");
            return (Criteria) this;
        }

        public Criteria andConstantGroupNotIn(List<String> values) {
            addCriterion("constant_group not in", values, "constantGroup");
            return (Criteria) this;
        }

        public Criteria andConstantGroupBetween(String value1, String value2) {
            addCriterion("constant_group between", value1, value2, "constantGroup");
            return (Criteria) this;
        }

        public Criteria andConstantGroupNotBetween(String value1, String value2) {
            addCriterion("constant_group not between", value1, value2, "constantGroup");
            return (Criteria) this;
        }

        public Criteria andConstantNameIsNull() {
            addCriterion("constant_name is null");
            return (Criteria) this;
        }

        public Criteria andConstantNameIsNotNull() {
            addCriterion("constant_name is not null");
            return (Criteria) this;
        }

        public Criteria andConstantNameEqualTo(String value) {
            addCriterion("constant_name =", value, "constantName");
            return (Criteria) this;
        }

        public Criteria andConstantNameNotEqualTo(String value) {
            addCriterion("constant_name <>", value, "constantName");
            return (Criteria) this;
        }

        public Criteria andConstantNameGreaterThan(String value) {
            addCriterion("constant_name >", value, "constantName");
            return (Criteria) this;
        }

        public Criteria andConstantNameGreaterThanOrEqualTo(String value) {
            addCriterion("constant_name >=", value, "constantName");
            return (Criteria) this;
        }

        public Criteria andConstantNameLessThan(String value) {
            addCriterion("constant_name <", value, "constantName");
            return (Criteria) this;
        }

        public Criteria andConstantNameLessThanOrEqualTo(String value) {
            addCriterion("constant_name <=", value, "constantName");
            return (Criteria) this;
        }

        public Criteria andConstantNameLike(String value) {
            addCriterion("constant_name like", value, "constantName");
            return (Criteria) this;
        }

        public Criteria andConstantNameNotLike(String value) {
            addCriterion("constant_name not like", value, "constantName");
            return (Criteria) this;
        }

        public Criteria andConstantNameIn(List<String> values) {
            addCriterion("constant_name in", values, "constantName");
            return (Criteria) this;
        }

        public Criteria andConstantNameNotIn(List<String> values) {
            addCriterion("constant_name not in", values, "constantName");
            return (Criteria) this;
        }

        public Criteria andConstantNameBetween(String value1, String value2) {
            addCriterion("constant_name between", value1, value2, "constantName");
            return (Criteria) this;
        }

        public Criteria andConstantNameNotBetween(String value1, String value2) {
            addCriterion("constant_name not between", value1, value2, "constantName");
            return (Criteria) this;
        }

        public Criteria andConstantCodeIsNull() {
            addCriterion("constant_code is null");
            return (Criteria) this;
        }

        public Criteria andConstantCodeIsNotNull() {
            addCriterion("constant_code is not null");
            return (Criteria) this;
        }

        public Criteria andConstantCodeEqualTo(String value) {
            addCriterion("constant_code =", value, "constantCode");
            return (Criteria) this;
        }

        public Criteria andConstantCodeNotEqualTo(String value) {
            addCriterion("constant_code <>", value, "constantCode");
            return (Criteria) this;
        }

        public Criteria andConstantCodeGreaterThan(String value) {
            addCriterion("constant_code >", value, "constantCode");
            return (Criteria) this;
        }

        public Criteria andConstantCodeGreaterThanOrEqualTo(String value) {
            addCriterion("constant_code >=", value, "constantCode");
            return (Criteria) this;
        }

        public Criteria andConstantCodeLessThan(String value) {
            addCriterion("constant_code <", value, "constantCode");
            return (Criteria) this;
        }

        public Criteria andConstantCodeLessThanOrEqualTo(String value) {
            addCriterion("constant_code <=", value, "constantCode");
            return (Criteria) this;
        }

        public Criteria andConstantCodeLike(String value) {
            addCriterion("constant_code like", value, "constantCode");
            return (Criteria) this;
        }

        public Criteria andConstantCodeNotLike(String value) {
            addCriterion("constant_code not like", value, "constantCode");
            return (Criteria) this;
        }

        public Criteria andConstantCodeIn(List<String> values) {
            addCriterion("constant_code in", values, "constantCode");
            return (Criteria) this;
        }

        public Criteria andConstantCodeNotIn(List<String> values) {
            addCriterion("constant_code not in", values, "constantCode");
            return (Criteria) this;
        }

        public Criteria andConstantCodeBetween(String value1, String value2) {
            addCriterion("constant_code between", value1, value2, "constantCode");
            return (Criteria) this;
        }

        public Criteria andConstantCodeNotBetween(String value1, String value2) {
            addCriterion("constant_code not between", value1, value2, "constantCode");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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