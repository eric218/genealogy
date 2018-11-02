package com.dct.swocean.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysATMsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysATMsExample() {
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

        public Criteria andDrowIdIsNull() {
            addCriterion("drow_id is null");
            return (Criteria) this;
        }

        public Criteria andDrowIdIsNotNull() {
            addCriterion("drow_id is not null");
            return (Criteria) this;
        }

        public Criteria andDrowIdEqualTo(Integer value) {
            addCriterion("drow_id =", value, "drowId");
            return (Criteria) this;
        }

        public Criteria andDrowIdNotEqualTo(Integer value) {
            addCriterion("drow_id <>", value, "drowId");
            return (Criteria) this;
        }

        public Criteria andDrowIdGreaterThan(Integer value) {
            addCriterion("drow_id >", value, "drowId");
            return (Criteria) this;
        }

        public Criteria andDrowIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("drow_id >=", value, "drowId");
            return (Criteria) this;
        }

        public Criteria andDrowIdLessThan(Integer value) {
            addCriterion("drow_id <", value, "drowId");
            return (Criteria) this;
        }

        public Criteria andDrowIdLessThanOrEqualTo(Integer value) {
            addCriterion("drow_id <=", value, "drowId");
            return (Criteria) this;
        }

        public Criteria andDrowIdIn(List<Integer> values) {
            addCriterion("drow_id in", values, "drowId");
            return (Criteria) this;
        }

        public Criteria andDrowIdNotIn(List<Integer> values) {
            addCriterion("drow_id not in", values, "drowId");
            return (Criteria) this;
        }

        public Criteria andDrowIdBetween(Integer value1, Integer value2) {
            addCriterion("drow_id between", value1, value2, "drowId");
            return (Criteria) this;
        }

        public Criteria andDrowIdNotBetween(Integer value1, Integer value2) {
            addCriterion("drow_id not between", value1, value2, "drowId");
            return (Criteria) this;
        }

        public Criteria andNetIdIsNull() {
            addCriterion("net_id is null");
            return (Criteria) this;
        }

        public Criteria andNetIdIsNotNull() {
            addCriterion("net_id is not null");
            return (Criteria) this;
        }

        public Criteria andNetIdEqualTo(Integer value) {
            addCriterion("net_id =", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdNotEqualTo(Integer value) {
            addCriterion("net_id <>", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdGreaterThan(Integer value) {
            addCriterion("net_id >", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("net_id >=", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdLessThan(Integer value) {
            addCriterion("net_id <", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdLessThanOrEqualTo(Integer value) {
            addCriterion("net_id <=", value, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdIn(List<Integer> values) {
            addCriterion("net_id in", values, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdNotIn(List<Integer> values) {
            addCriterion("net_id not in", values, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdBetween(Integer value1, Integer value2) {
            addCriterion("net_id between", value1, value2, "netId");
            return (Criteria) this;
        }

        public Criteria andNetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("net_id not between", value1, value2, "netId");
            return (Criteria) this;
        }

        public Criteria andDrowAmountIsNull() {
            addCriterion("drow_amount is null");
            return (Criteria) this;
        }

        public Criteria andDrowAmountIsNotNull() {
            addCriterion("drow_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDrowAmountEqualTo(BigDecimal value) {
            addCriterion("drow_amount =", value, "drowAmount");
            return (Criteria) this;
        }

        public Criteria andDrowAmountNotEqualTo(BigDecimal value) {
            addCriterion("drow_amount <>", value, "drowAmount");
            return (Criteria) this;
        }

        public Criteria andDrowAmountGreaterThan(BigDecimal value) {
            addCriterion("drow_amount >", value, "drowAmount");
            return (Criteria) this;
        }

        public Criteria andDrowAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("drow_amount >=", value, "drowAmount");
            return (Criteria) this;
        }

        public Criteria andDrowAmountLessThan(BigDecimal value) {
            addCriterion("drow_amount <", value, "drowAmount");
            return (Criteria) this;
        }

        public Criteria andDrowAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("drow_amount <=", value, "drowAmount");
            return (Criteria) this;
        }

        public Criteria andDrowAmountIn(List<BigDecimal> values) {
            addCriterion("drow_amount in", values, "drowAmount");
            return (Criteria) this;
        }

        public Criteria andDrowAmountNotIn(List<BigDecimal> values) {
            addCriterion("drow_amount not in", values, "drowAmount");
            return (Criteria) this;
        }

        public Criteria andDrowAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("drow_amount between", value1, value2, "drowAmount");
            return (Criteria) this;
        }

        public Criteria andDrowAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("drow_amount not between", value1, value2, "drowAmount");
            return (Criteria) this;
        }

        public Criteria andDrowTimeIsNull() {
            addCriterion("drow_time is null");
            return (Criteria) this;
        }

        public Criteria andDrowTimeIsNotNull() {
            addCriterion("drow_time is not null");
            return (Criteria) this;
        }

        public Criteria andDrowTimeEqualTo(Date value) {
            addCriterion("drow_time =", value, "drowTime");
            return (Criteria) this;
        }

        public Criteria andDrowTimeNotEqualTo(Date value) {
            addCriterion("drow_time <>", value, "drowTime");
            return (Criteria) this;
        }

        public Criteria andDrowTimeGreaterThan(Date value) {
            addCriterion("drow_time >", value, "drowTime");
            return (Criteria) this;
        }

        public Criteria andDrowTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("drow_time >=", value, "drowTime");
            return (Criteria) this;
        }

        public Criteria andDrowTimeLessThan(Date value) {
            addCriterion("drow_time <", value, "drowTime");
            return (Criteria) this;
        }

        public Criteria andDrowTimeLessThanOrEqualTo(Date value) {
            addCriterion("drow_time <=", value, "drowTime");
            return (Criteria) this;
        }

        public Criteria andDrowTimeIn(List<Date> values) {
            addCriterion("drow_time in", values, "drowTime");
            return (Criteria) this;
        }

        public Criteria andDrowTimeNotIn(List<Date> values) {
            addCriterion("drow_time not in", values, "drowTime");
            return (Criteria) this;
        }

        public Criteria andDrowTimeBetween(Date value1, Date value2) {
            addCriterion("drow_time between", value1, value2, "drowTime");
            return (Criteria) this;
        }

        public Criteria andDrowTimeNotBetween(Date value1, Date value2) {
            addCriterion("drow_time not between", value1, value2, "drowTime");
            return (Criteria) this;
        }

        public Criteria andDrowNameIsNull() {
            addCriterion("drow_name is null");
            return (Criteria) this;
        }

        public Criteria andDrowNameIsNotNull() {
            addCriterion("drow_name is not null");
            return (Criteria) this;
        }

        public Criteria andDrowNameEqualTo(String value) {
            addCriterion("drow_name =", value, "drowName");
            return (Criteria) this;
        }

        public Criteria andDrowNameNotEqualTo(String value) {
            addCriterion("drow_name <>", value, "drowName");
            return (Criteria) this;
        }

        public Criteria andDrowNameGreaterThan(String value) {
            addCriterion("drow_name >", value, "drowName");
            return (Criteria) this;
        }

        public Criteria andDrowNameGreaterThanOrEqualTo(String value) {
            addCriterion("drow_name >=", value, "drowName");
            return (Criteria) this;
        }

        public Criteria andDrowNameLessThan(String value) {
            addCriterion("drow_name <", value, "drowName");
            return (Criteria) this;
        }

        public Criteria andDrowNameLessThanOrEqualTo(String value) {
            addCriterion("drow_name <=", value, "drowName");
            return (Criteria) this;
        }

        public Criteria andDrowNameLike(String value) {
            addCriterion("drow_name like", value, "drowName");
            return (Criteria) this;
        }

        public Criteria andDrowNameNotLike(String value) {
            addCriterion("drow_name not like", value, "drowName");
            return (Criteria) this;
        }

        public Criteria andDrowNameIn(List<String> values) {
            addCriterion("drow_name in", values, "drowName");
            return (Criteria) this;
        }

        public Criteria andDrowNameNotIn(List<String> values) {
            addCriterion("drow_name not in", values, "drowName");
            return (Criteria) this;
        }

        public Criteria andDrowNameBetween(String value1, String value2) {
            addCriterion("drow_name between", value1, value2, "drowName");
            return (Criteria) this;
        }

        public Criteria andDrowNameNotBetween(String value1, String value2) {
            addCriterion("drow_name not between", value1, value2, "drowName");
            return (Criteria) this;
        }

        public Criteria andDrowInNumIsNull() {
            addCriterion("drow_in_num is null");
            return (Criteria) this;
        }

        public Criteria andDrowInNumIsNotNull() {
            addCriterion("drow_in_num is not null");
            return (Criteria) this;
        }

        public Criteria andDrowInNumEqualTo(String value) {
            addCriterion("drow_in_num =", value, "drowInNum");
            return (Criteria) this;
        }

        public Criteria andDrowInNumNotEqualTo(String value) {
            addCriterion("drow_in_num <>", value, "drowInNum");
            return (Criteria) this;
        }

        public Criteria andDrowInNumGreaterThan(String value) {
            addCriterion("drow_in_num >", value, "drowInNum");
            return (Criteria) this;
        }

        public Criteria andDrowInNumGreaterThanOrEqualTo(String value) {
            addCriterion("drow_in_num >=", value, "drowInNum");
            return (Criteria) this;
        }

        public Criteria andDrowInNumLessThan(String value) {
            addCriterion("drow_in_num <", value, "drowInNum");
            return (Criteria) this;
        }

        public Criteria andDrowInNumLessThanOrEqualTo(String value) {
            addCriterion("drow_in_num <=", value, "drowInNum");
            return (Criteria) this;
        }

        public Criteria andDrowInNumLike(String value) {
            addCriterion("drow_in_num like", value, "drowInNum");
            return (Criteria) this;
        }

        public Criteria andDrowInNumNotLike(String value) {
            addCriterion("drow_in_num not like", value, "drowInNum");
            return (Criteria) this;
        }

        public Criteria andDrowInNumIn(List<String> values) {
            addCriterion("drow_in_num in", values, "drowInNum");
            return (Criteria) this;
        }

        public Criteria andDrowInNumNotIn(List<String> values) {
            addCriterion("drow_in_num not in", values, "drowInNum");
            return (Criteria) this;
        }

        public Criteria andDrowInNumBetween(String value1, String value2) {
            addCriterion("drow_in_num between", value1, value2, "drowInNum");
            return (Criteria) this;
        }

        public Criteria andDrowInNumNotBetween(String value1, String value2) {
            addCriterion("drow_in_num not between", value1, value2, "drowInNum");
            return (Criteria) this;
        }

        public Criteria andDrowInNameIsNull() {
            addCriterion("drow_in_name is null");
            return (Criteria) this;
        }

        public Criteria andDrowInNameIsNotNull() {
            addCriterion("drow_in_name is not null");
            return (Criteria) this;
        }

        public Criteria andDrowInNameEqualTo(String value) {
            addCriterion("drow_in_name =", value, "drowInName");
            return (Criteria) this;
        }

        public Criteria andDrowInNameNotEqualTo(String value) {
            addCriterion("drow_in_name <>", value, "drowInName");
            return (Criteria) this;
        }

        public Criteria andDrowInNameGreaterThan(String value) {
            addCriterion("drow_in_name >", value, "drowInName");
            return (Criteria) this;
        }

        public Criteria andDrowInNameGreaterThanOrEqualTo(String value) {
            addCriterion("drow_in_name >=", value, "drowInName");
            return (Criteria) this;
        }

        public Criteria andDrowInNameLessThan(String value) {
            addCriterion("drow_in_name <", value, "drowInName");
            return (Criteria) this;
        }

        public Criteria andDrowInNameLessThanOrEqualTo(String value) {
            addCriterion("drow_in_name <=", value, "drowInName");
            return (Criteria) this;
        }

        public Criteria andDrowInNameLike(String value) {
            addCriterion("drow_in_name like", value, "drowInName");
            return (Criteria) this;
        }

        public Criteria andDrowInNameNotLike(String value) {
            addCriterion("drow_in_name not like", value, "drowInName");
            return (Criteria) this;
        }

        public Criteria andDrowInNameIn(List<String> values) {
            addCriterion("drow_in_name in", values, "drowInName");
            return (Criteria) this;
        }

        public Criteria andDrowInNameNotIn(List<String> values) {
            addCriterion("drow_in_name not in", values, "drowInName");
            return (Criteria) this;
        }

        public Criteria andDrowInNameBetween(String value1, String value2) {
            addCriterion("drow_in_name between", value1, value2, "drowInName");
            return (Criteria) this;
        }

        public Criteria andDrowInNameNotBetween(String value1, String value2) {
            addCriterion("drow_in_name not between", value1, value2, "drowInName");
            return (Criteria) this;
        }

        public Criteria andDrowBankIsNull() {
            addCriterion("drow_bank is null");
            return (Criteria) this;
        }

        public Criteria andDrowBankIsNotNull() {
            addCriterion("drow_bank is not null");
            return (Criteria) this;
        }

        public Criteria andDrowBankEqualTo(String value) {
            addCriterion("drow_bank =", value, "drowBank");
            return (Criteria) this;
        }

        public Criteria andDrowBankNotEqualTo(String value) {
            addCriterion("drow_bank <>", value, "drowBank");
            return (Criteria) this;
        }

        public Criteria andDrowBankGreaterThan(String value) {
            addCriterion("drow_bank >", value, "drowBank");
            return (Criteria) this;
        }

        public Criteria andDrowBankGreaterThanOrEqualTo(String value) {
            addCriterion("drow_bank >=", value, "drowBank");
            return (Criteria) this;
        }

        public Criteria andDrowBankLessThan(String value) {
            addCriterion("drow_bank <", value, "drowBank");
            return (Criteria) this;
        }

        public Criteria andDrowBankLessThanOrEqualTo(String value) {
            addCriterion("drow_bank <=", value, "drowBank");
            return (Criteria) this;
        }

        public Criteria andDrowBankLike(String value) {
            addCriterion("drow_bank like", value, "drowBank");
            return (Criteria) this;
        }

        public Criteria andDrowBankNotLike(String value) {
            addCriterion("drow_bank not like", value, "drowBank");
            return (Criteria) this;
        }

        public Criteria andDrowBankIn(List<String> values) {
            addCriterion("drow_bank in", values, "drowBank");
            return (Criteria) this;
        }

        public Criteria andDrowBankNotIn(List<String> values) {
            addCriterion("drow_bank not in", values, "drowBank");
            return (Criteria) this;
        }

        public Criteria andDrowBankBetween(String value1, String value2) {
            addCriterion("drow_bank between", value1, value2, "drowBank");
            return (Criteria) this;
        }

        public Criteria andDrowBankNotBetween(String value1, String value2) {
            addCriterion("drow_bank not between", value1, value2, "drowBank");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Integer value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Integer value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Integer value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Integer value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Integer value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Integer> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Integer> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Integer value1, Integer value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Integer value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Integer value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Integer value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Integer value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Integer value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<Integer> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<Integer> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Integer value1, Integer value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
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