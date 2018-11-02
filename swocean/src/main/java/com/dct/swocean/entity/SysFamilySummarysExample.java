package com.dct.swocean.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysFamilySummarysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysFamilySummarysExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andShowPositionIdIsNull() {
            addCriterion("show_position_id is null");
            return (Criteria) this;
        }

        public Criteria andShowPositionIdIsNotNull() {
            addCriterion("show_position_id is not null");
            return (Criteria) this;
        }

        public Criteria andShowPositionIdEqualTo(Integer value) {
            addCriterion("show_position_id =", value, "showPositionId");
            return (Criteria) this;
        }

        public Criteria andShowPositionIdNotEqualTo(Integer value) {
            addCriterion("show_position_id <>", value, "showPositionId");
            return (Criteria) this;
        }

        public Criteria andShowPositionIdGreaterThan(Integer value) {
            addCriterion("show_position_id >", value, "showPositionId");
            return (Criteria) this;
        }

        public Criteria andShowPositionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_position_id >=", value, "showPositionId");
            return (Criteria) this;
        }

        public Criteria andShowPositionIdLessThan(Integer value) {
            addCriterion("show_position_id <", value, "showPositionId");
            return (Criteria) this;
        }

        public Criteria andShowPositionIdLessThanOrEqualTo(Integer value) {
            addCriterion("show_position_id <=", value, "showPositionId");
            return (Criteria) this;
        }

        public Criteria andShowPositionIdIn(List<Integer> values) {
            addCriterion("show_position_id in", values, "showPositionId");
            return (Criteria) this;
        }

        public Criteria andShowPositionIdNotIn(List<Integer> values) {
            addCriterion("show_position_id not in", values, "showPositionId");
            return (Criteria) this;
        }

        public Criteria andShowPositionIdBetween(Integer value1, Integer value2) {
            addCriterion("show_position_id between", value1, value2, "showPositionId");
            return (Criteria) this;
        }

        public Criteria andShowPositionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("show_position_id not between", value1, value2, "showPositionId");
            return (Criteria) this;
        }

        public Criteria andRootGroupIsNull() {
            addCriterion("root_group is null");
            return (Criteria) this;
        }

        public Criteria andRootGroupIsNotNull() {
            addCriterion("root_group is not null");
            return (Criteria) this;
        }

        public Criteria andRootGroupEqualTo(String value) {
            addCriterion("root_group =", value, "rootGroup");
            return (Criteria) this;
        }

        public Criteria andRootGroupNotEqualTo(String value) {
            addCriterion("root_group <>", value, "rootGroup");
            return (Criteria) this;
        }

        public Criteria andRootGroupGreaterThan(String value) {
            addCriterion("root_group >", value, "rootGroup");
            return (Criteria) this;
        }

        public Criteria andRootGroupGreaterThanOrEqualTo(String value) {
            addCriterion("root_group >=", value, "rootGroup");
            return (Criteria) this;
        }

        public Criteria andRootGroupLessThan(String value) {
            addCriterion("root_group <", value, "rootGroup");
            return (Criteria) this;
        }

        public Criteria andRootGroupLessThanOrEqualTo(String value) {
            addCriterion("root_group <=", value, "rootGroup");
            return (Criteria) this;
        }

        public Criteria andRootGroupLike(String value) {
            addCriterion("root_group like", value, "rootGroup");
            return (Criteria) this;
        }

        public Criteria andRootGroupNotLike(String value) {
            addCriterion("root_group not like", value, "rootGroup");
            return (Criteria) this;
        }

        public Criteria andRootGroupIn(List<String> values) {
            addCriterion("root_group in", values, "rootGroup");
            return (Criteria) this;
        }

        public Criteria andRootGroupNotIn(List<String> values) {
            addCriterion("root_group not in", values, "rootGroup");
            return (Criteria) this;
        }

        public Criteria andRootGroupBetween(String value1, String value2) {
            addCriterion("root_group between", value1, value2, "rootGroup");
            return (Criteria) this;
        }

        public Criteria andRootGroupNotBetween(String value1, String value2) {
            addCriterion("root_group not between", value1, value2, "rootGroup");
            return (Criteria) this;
        }

        public Criteria andRootPersonIsNull() {
            addCriterion("root_person is null");
            return (Criteria) this;
        }

        public Criteria andRootPersonIsNotNull() {
            addCriterion("root_person is not null");
            return (Criteria) this;
        }

        public Criteria andRootPersonEqualTo(String value) {
            addCriterion("root_person =", value, "rootPerson");
            return (Criteria) this;
        }

        public Criteria andRootPersonNotEqualTo(String value) {
            addCriterion("root_person <>", value, "rootPerson");
            return (Criteria) this;
        }

        public Criteria andRootPersonGreaterThan(String value) {
            addCriterion("root_person >", value, "rootPerson");
            return (Criteria) this;
        }

        public Criteria andRootPersonGreaterThanOrEqualTo(String value) {
            addCriterion("root_person >=", value, "rootPerson");
            return (Criteria) this;
        }

        public Criteria andRootPersonLessThan(String value) {
            addCriterion("root_person <", value, "rootPerson");
            return (Criteria) this;
        }

        public Criteria andRootPersonLessThanOrEqualTo(String value) {
            addCriterion("root_person <=", value, "rootPerson");
            return (Criteria) this;
        }

        public Criteria andRootPersonLike(String value) {
            addCriterion("root_person like", value, "rootPerson");
            return (Criteria) this;
        }

        public Criteria andRootPersonNotLike(String value) {
            addCriterion("root_person not like", value, "rootPerson");
            return (Criteria) this;
        }

        public Criteria andRootPersonIn(List<String> values) {
            addCriterion("root_person in", values, "rootPerson");
            return (Criteria) this;
        }

        public Criteria andRootPersonNotIn(List<String> values) {
            addCriterion("root_person not in", values, "rootPerson");
            return (Criteria) this;
        }

        public Criteria andRootPersonBetween(String value1, String value2) {
            addCriterion("root_person between", value1, value2, "rootPerson");
            return (Criteria) this;
        }

        public Criteria andRootPersonNotBetween(String value1, String value2) {
            addCriterion("root_person not between", value1, value2, "rootPerson");
            return (Criteria) this;
        }

        public Criteria andNetLeaderIsNull() {
            addCriterion("net_leader is null");
            return (Criteria) this;
        }

        public Criteria andNetLeaderIsNotNull() {
            addCriterion("net_leader is not null");
            return (Criteria) this;
        }

        public Criteria andNetLeaderEqualTo(Integer value) {
            addCriterion("net_leader =", value, "netLeader");
            return (Criteria) this;
        }

        public Criteria andNetLeaderNotEqualTo(Integer value) {
            addCriterion("net_leader <>", value, "netLeader");
            return (Criteria) this;
        }

        public Criteria andNetLeaderGreaterThan(Integer value) {
            addCriterion("net_leader >", value, "netLeader");
            return (Criteria) this;
        }

        public Criteria andNetLeaderGreaterThanOrEqualTo(Integer value) {
            addCriterion("net_leader >=", value, "netLeader");
            return (Criteria) this;
        }

        public Criteria andNetLeaderLessThan(Integer value) {
            addCriterion("net_leader <", value, "netLeader");
            return (Criteria) this;
        }

        public Criteria andNetLeaderLessThanOrEqualTo(Integer value) {
            addCriterion("net_leader <=", value, "netLeader");
            return (Criteria) this;
        }

        public Criteria andNetLeaderIn(List<Integer> values) {
            addCriterion("net_leader in", values, "netLeader");
            return (Criteria) this;
        }

        public Criteria andNetLeaderNotIn(List<Integer> values) {
            addCriterion("net_leader not in", values, "netLeader");
            return (Criteria) this;
        }

        public Criteria andNetLeaderBetween(Integer value1, Integer value2) {
            addCriterion("net_leader between", value1, value2, "netLeader");
            return (Criteria) this;
        }

        public Criteria andNetLeaderNotBetween(Integer value1, Integer value2) {
            addCriterion("net_leader not between", value1, value2, "netLeader");
            return (Criteria) this;
        }

        public Criteria andNetPhoneIsNull() {
            addCriterion("net_phone is null");
            return (Criteria) this;
        }

        public Criteria andNetPhoneIsNotNull() {
            addCriterion("net_phone is not null");
            return (Criteria) this;
        }

        public Criteria andNetPhoneEqualTo(String value) {
            addCriterion("net_phone =", value, "netPhone");
            return (Criteria) this;
        }

        public Criteria andNetPhoneNotEqualTo(String value) {
            addCriterion("net_phone <>", value, "netPhone");
            return (Criteria) this;
        }

        public Criteria andNetPhoneGreaterThan(String value) {
            addCriterion("net_phone >", value, "netPhone");
            return (Criteria) this;
        }

        public Criteria andNetPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("net_phone >=", value, "netPhone");
            return (Criteria) this;
        }

        public Criteria andNetPhoneLessThan(String value) {
            addCriterion("net_phone <", value, "netPhone");
            return (Criteria) this;
        }

        public Criteria andNetPhoneLessThanOrEqualTo(String value) {
            addCriterion("net_phone <=", value, "netPhone");
            return (Criteria) this;
        }

        public Criteria andNetPhoneLike(String value) {
            addCriterion("net_phone like", value, "netPhone");
            return (Criteria) this;
        }

        public Criteria andNetPhoneNotLike(String value) {
            addCriterion("net_phone not like", value, "netPhone");
            return (Criteria) this;
        }

        public Criteria andNetPhoneIn(List<String> values) {
            addCriterion("net_phone in", values, "netPhone");
            return (Criteria) this;
        }

        public Criteria andNetPhoneNotIn(List<String> values) {
            addCriterion("net_phone not in", values, "netPhone");
            return (Criteria) this;
        }

        public Criteria andNetPhoneBetween(String value1, String value2) {
            addCriterion("net_phone between", value1, value2, "netPhone");
            return (Criteria) this;
        }

        public Criteria andNetPhoneNotBetween(String value1, String value2) {
            addCriterion("net_phone not between", value1, value2, "netPhone");
            return (Criteria) this;
        }

        public Criteria andWorshipNumIsNull() {
            addCriterion("worship_num is null");
            return (Criteria) this;
        }

        public Criteria andWorshipNumIsNotNull() {
            addCriterion("worship_num is not null");
            return (Criteria) this;
        }

        public Criteria andWorshipNumEqualTo(Integer value) {
            addCriterion("worship_num =", value, "worshipNum");
            return (Criteria) this;
        }

        public Criteria andWorshipNumNotEqualTo(Integer value) {
            addCriterion("worship_num <>", value, "worshipNum");
            return (Criteria) this;
        }

        public Criteria andWorshipNumGreaterThan(Integer value) {
            addCriterion("worship_num >", value, "worshipNum");
            return (Criteria) this;
        }

        public Criteria andWorshipNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("worship_num >=", value, "worshipNum");
            return (Criteria) this;
        }

        public Criteria andWorshipNumLessThan(Integer value) {
            addCriterion("worship_num <", value, "worshipNum");
            return (Criteria) this;
        }

        public Criteria andWorshipNumLessThanOrEqualTo(Integer value) {
            addCriterion("worship_num <=", value, "worshipNum");
            return (Criteria) this;
        }

        public Criteria andWorshipNumIn(List<Integer> values) {
            addCriterion("worship_num in", values, "worshipNum");
            return (Criteria) this;
        }

        public Criteria andWorshipNumNotIn(List<Integer> values) {
            addCriterion("worship_num not in", values, "worshipNum");
            return (Criteria) this;
        }

        public Criteria andWorshipNumBetween(Integer value1, Integer value2) {
            addCriterion("worship_num between", value1, value2, "worshipNum");
            return (Criteria) this;
        }

        public Criteria andWorshipNumNotBetween(Integer value1, Integer value2) {
            addCriterion("worship_num not between", value1, value2, "worshipNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumIsNull() {
            addCriterion("praise_num is null");
            return (Criteria) this;
        }

        public Criteria andPraiseNumIsNotNull() {
            addCriterion("praise_num is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseNumEqualTo(Integer value) {
            addCriterion("praise_num =", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumNotEqualTo(Integer value) {
            addCriterion("praise_num <>", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumGreaterThan(Integer value) {
            addCriterion("praise_num >", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("praise_num >=", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumLessThan(Integer value) {
            addCriterion("praise_num <", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumLessThanOrEqualTo(Integer value) {
            addCriterion("praise_num <=", value, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumIn(List<Integer> values) {
            addCriterion("praise_num in", values, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumNotIn(List<Integer> values) {
            addCriterion("praise_num not in", values, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumBetween(Integer value1, Integer value2) {
            addCriterion("praise_num between", value1, value2, "praiseNum");
            return (Criteria) this;
        }

        public Criteria andPraiseNumNotBetween(Integer value1, Integer value2) {
            addCriterion("praise_num not between", value1, value2, "praiseNum");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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