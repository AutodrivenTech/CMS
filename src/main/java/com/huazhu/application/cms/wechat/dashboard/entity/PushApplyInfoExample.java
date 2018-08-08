package com.huazhu.application.cms.wechat.dashboard.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PushApplyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PushApplyInfoExample() {
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

        public Criteria andRowIdIsNull() {
            addCriterion("row_id is null");
            return (Criteria) this;
        }

        public Criteria andRowIdIsNotNull() {
            addCriterion("row_id is not null");
            return (Criteria) this;
        }

        public Criteria andRowIdEqualTo(Long value) {
            addCriterion("row_id =", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdNotEqualTo(Long value) {
            addCriterion("row_id <>", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdGreaterThan(Long value) {
            addCriterion("row_id >", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdGreaterThanOrEqualTo(Long value) {
            addCriterion("row_id >=", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdLessThan(Long value) {
            addCriterion("row_id <", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdLessThanOrEqualTo(Long value) {
            addCriterion("row_id <=", value, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdIn(List<Long> values) {
            addCriterion("row_id in", values, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdNotIn(List<Long> values) {
            addCriterion("row_id not in", values, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdBetween(Long value1, Long value2) {
            addCriterion("row_id between", value1, value2, "rowId");
            return (Criteria) this;
        }

        public Criteria andRowIdNotBetween(Long value1, Long value2) {
            addCriterion("row_id not between", value1, value2, "rowId");
            return (Criteria) this;
        }

        public Criteria andPushTitleIsNull() {
            addCriterion("push_title is null");
            return (Criteria) this;
        }

        public Criteria andPushTitleIsNotNull() {
            addCriterion("push_title is not null");
            return (Criteria) this;
        }

        public Criteria andPushTitleEqualTo(String value) {
            addCriterion("push_title =", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleNotEqualTo(String value) {
            addCriterion("push_title <>", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleGreaterThan(String value) {
            addCriterion("push_title >", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleGreaterThanOrEqualTo(String value) {
            addCriterion("push_title >=", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleLessThan(String value) {
            addCriterion("push_title <", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleLessThanOrEqualTo(String value) {
            addCriterion("push_title <=", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleLike(String value) {
            addCriterion("push_title like", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleNotLike(String value) {
            addCriterion("push_title not like", value, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleIn(List<String> values) {
            addCriterion("push_title in", values, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleNotIn(List<String> values) {
            addCriterion("push_title not in", values, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleBetween(String value1, String value2) {
            addCriterion("push_title between", value1, value2, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTitleNotBetween(String value1, String value2) {
            addCriterion("push_title not between", value1, value2, "pushTitle");
            return (Criteria) this;
        }

        public Criteria andPushTypeIsNull() {
            addCriterion("push_type is null");
            return (Criteria) this;
        }

        public Criteria andPushTypeIsNotNull() {
            addCriterion("push_type is not null");
            return (Criteria) this;
        }

        public Criteria andPushTypeEqualTo(Byte value) {
            addCriterion("push_type =", value, "pushType");
            return (Criteria) this;
        }

        public Criteria andPushTypeNotEqualTo(Byte value) {
            addCriterion("push_type <>", value, "pushType");
            return (Criteria) this;
        }

        public Criteria andPushTypeGreaterThan(Byte value) {
            addCriterion("push_type >", value, "pushType");
            return (Criteria) this;
        }

        public Criteria andPushTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("push_type >=", value, "pushType");
            return (Criteria) this;
        }

        public Criteria andPushTypeLessThan(Byte value) {
            addCriterion("push_type <", value, "pushType");
            return (Criteria) this;
        }

        public Criteria andPushTypeLessThanOrEqualTo(Byte value) {
            addCriterion("push_type <=", value, "pushType");
            return (Criteria) this;
        }

        public Criteria andPushTypeIn(List<Byte> values) {
            addCriterion("push_type in", values, "pushType");
            return (Criteria) this;
        }

        public Criteria andPushTypeNotIn(List<Byte> values) {
            addCriterion("push_type not in", values, "pushType");
            return (Criteria) this;
        }

        public Criteria andPushTypeBetween(Byte value1, Byte value2) {
            addCriterion("push_type between", value1, value2, "pushType");
            return (Criteria) this;
        }

        public Criteria andPushTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("push_type not between", value1, value2, "pushType");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNull() {
            addCriterion("push_time is null");
            return (Criteria) this;
        }

        public Criteria andPushTimeIsNotNull() {
            addCriterion("push_time is not null");
            return (Criteria) this;
        }

        public Criteria andPushTimeEqualTo(Date value) {
            addCriterion("push_time =", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotEqualTo(Date value) {
            addCriterion("push_time <>", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThan(Date value) {
            addCriterion("push_time >", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("push_time >=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThan(Date value) {
            addCriterion("push_time <", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeLessThanOrEqualTo(Date value) {
            addCriterion("push_time <=", value, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeIn(List<Date> values) {
            addCriterion("push_time in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotIn(List<Date> values) {
            addCriterion("push_time not in", values, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeBetween(Date value1, Date value2) {
            addCriterion("push_time between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushTimeNotBetween(Date value1, Date value2) {
            addCriterion("push_time not between", value1, value2, "pushTime");
            return (Criteria) this;
        }

        public Criteria andPushConIsNull() {
            addCriterion("push_con is null");
            return (Criteria) this;
        }

        public Criteria andPushConIsNotNull() {
            addCriterion("push_con is not null");
            return (Criteria) this;
        }

        public Criteria andPushConEqualTo(Long value) {
            addCriterion("push_con =", value, "pushCon");
            return (Criteria) this;
        }

        public Criteria andPushConNotEqualTo(Long value) {
            addCriterion("push_con <>", value, "pushCon");
            return (Criteria) this;
        }

        public Criteria andPushConGreaterThan(Long value) {
            addCriterion("push_con >", value, "pushCon");
            return (Criteria) this;
        }

        public Criteria andPushConGreaterThanOrEqualTo(Long value) {
            addCriterion("push_con >=", value, "pushCon");
            return (Criteria) this;
        }

        public Criteria andPushConLessThan(Long value) {
            addCriterion("push_con <", value, "pushCon");
            return (Criteria) this;
        }

        public Criteria andPushConLessThanOrEqualTo(Long value) {
            addCriterion("push_con <=", value, "pushCon");
            return (Criteria) this;
        }

        public Criteria andPushConIn(List<Long> values) {
            addCriterion("push_con in", values, "pushCon");
            return (Criteria) this;
        }

        public Criteria andPushConNotIn(List<Long> values) {
            addCriterion("push_con not in", values, "pushCon");
            return (Criteria) this;
        }

        public Criteria andPushConBetween(Long value1, Long value2) {
            addCriterion("push_con between", value1, value2, "pushCon");
            return (Criteria) this;
        }

        public Criteria andPushConNotBetween(Long value1, Long value2) {
            addCriterion("push_con not between", value1, value2, "pushCon");
            return (Criteria) this;
        }

        public Criteria andPushStatusIsNull() {
            addCriterion("push_status is null");
            return (Criteria) this;
        }

        public Criteria andPushStatusIsNotNull() {
            addCriterion("push_status is not null");
            return (Criteria) this;
        }

        public Criteria andPushStatusEqualTo(Byte value) {
            addCriterion("push_status =", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusNotEqualTo(Byte value) {
            addCriterion("push_status <>", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusGreaterThan(Byte value) {
            addCriterion("push_status >", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("push_status >=", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusLessThan(Byte value) {
            addCriterion("push_status <", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusLessThanOrEqualTo(Byte value) {
            addCriterion("push_status <=", value, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusIn(List<Byte> values) {
            addCriterion("push_status in", values, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusNotIn(List<Byte> values) {
            addCriterion("push_status not in", values, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusBetween(Byte value1, Byte value2) {
            addCriterion("push_status between", value1, value2, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andPushStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("push_status not between", value1, value2, "pushStatus");
            return (Criteria) this;
        }

        public Criteria andConOrgIsNull() {
            addCriterion("con_org is null");
            return (Criteria) this;
        }

        public Criteria andConOrgIsNotNull() {
            addCriterion("con_org is not null");
            return (Criteria) this;
        }

        public Criteria andConOrgEqualTo(Long value) {
            addCriterion("con_org =", value, "conOrg");
            return (Criteria) this;
        }

        public Criteria andConOrgNotEqualTo(Long value) {
            addCriterion("con_org <>", value, "conOrg");
            return (Criteria) this;
        }

        public Criteria andConOrgGreaterThan(Long value) {
            addCriterion("con_org >", value, "conOrg");
            return (Criteria) this;
        }

        public Criteria andConOrgGreaterThanOrEqualTo(Long value) {
            addCriterion("con_org >=", value, "conOrg");
            return (Criteria) this;
        }

        public Criteria andConOrgLessThan(Long value) {
            addCriterion("con_org <", value, "conOrg");
            return (Criteria) this;
        }

        public Criteria andConOrgLessThanOrEqualTo(Long value) {
            addCriterion("con_org <=", value, "conOrg");
            return (Criteria) this;
        }

        public Criteria andConOrgIn(List<Long> values) {
            addCriterion("con_org in", values, "conOrg");
            return (Criteria) this;
        }

        public Criteria andConOrgNotIn(List<Long> values) {
            addCriterion("con_org not in", values, "conOrg");
            return (Criteria) this;
        }

        public Criteria andConOrgBetween(Long value1, Long value2) {
            addCriterion("con_org between", value1, value2, "conOrg");
            return (Criteria) this;
        }

        public Criteria andConOrgNotBetween(Long value1, Long value2) {
            addCriterion("con_org not between", value1, value2, "conOrg");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNull() {
            addCriterion("org_type is null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNotNull() {
            addCriterion("org_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeEqualTo(Byte value) {
            addCriterion("org_type =", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotEqualTo(Byte value) {
            addCriterion("org_type <>", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThan(Byte value) {
            addCriterion("org_type >", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("org_type >=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThan(Byte value) {
            addCriterion("org_type <", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThanOrEqualTo(Byte value) {
            addCriterion("org_type <=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIn(List<Byte> values) {
            addCriterion("org_type in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotIn(List<Byte> values) {
            addCriterion("org_type not in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeBetween(Byte value1, Byte value2) {
            addCriterion("org_type between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("org_type not between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andPushTagIsNull() {
            addCriterion("push_tag is null");
            return (Criteria) this;
        }

        public Criteria andPushTagIsNotNull() {
            addCriterion("push_tag is not null");
            return (Criteria) this;
        }

        public Criteria andPushTagEqualTo(Long value) {
            addCriterion("push_tag =", value, "pushTag");
            return (Criteria) this;
        }

        public Criteria andPushTagNotEqualTo(Long value) {
            addCriterion("push_tag <>", value, "pushTag");
            return (Criteria) this;
        }

        public Criteria andPushTagGreaterThan(Long value) {
            addCriterion("push_tag >", value, "pushTag");
            return (Criteria) this;
        }

        public Criteria andPushTagGreaterThanOrEqualTo(Long value) {
            addCriterion("push_tag >=", value, "pushTag");
            return (Criteria) this;
        }

        public Criteria andPushTagLessThan(Long value) {
            addCriterion("push_tag <", value, "pushTag");
            return (Criteria) this;
        }

        public Criteria andPushTagLessThanOrEqualTo(Long value) {
            addCriterion("push_tag <=", value, "pushTag");
            return (Criteria) this;
        }

        public Criteria andPushTagIn(List<Long> values) {
            addCriterion("push_tag in", values, "pushTag");
            return (Criteria) this;
        }

        public Criteria andPushTagNotIn(List<Long> values) {
            addCriterion("push_tag not in", values, "pushTag");
            return (Criteria) this;
        }

        public Criteria andPushTagBetween(Long value1, Long value2) {
            addCriterion("push_tag between", value1, value2, "pushTag");
            return (Criteria) this;
        }

        public Criteria andPushTagNotBetween(Long value1, Long value2) {
            addCriterion("push_tag not between", value1, value2, "pushTag");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNull() {
            addCriterion("msg_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNotNull() {
            addCriterion("msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIdEqualTo(String value) {
            addCriterion("msg_id =", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotEqualTo(String value) {
            addCriterion("msg_id <>", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThan(String value) {
            addCriterion("msg_id >", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThanOrEqualTo(String value) {
            addCriterion("msg_id >=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThan(String value) {
            addCriterion("msg_id <", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThanOrEqualTo(String value) {
            addCriterion("msg_id <=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLike(String value) {
            addCriterion("msg_id like", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotLike(String value) {
            addCriterion("msg_id not like", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdIn(List<String> values) {
            addCriterion("msg_id in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotIn(List<String> values) {
            addCriterion("msg_id not in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdBetween(String value1, String value2) {
            addCriterion("msg_id between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotBetween(String value1, String value2) {
            addCriterion("msg_id not between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgDataIdIsNull() {
            addCriterion("msg_data_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgDataIdIsNotNull() {
            addCriterion("msg_data_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgDataIdEqualTo(String value) {
            addCriterion("msg_data_id =", value, "msgDataId");
            return (Criteria) this;
        }

        public Criteria andMsgDataIdNotEqualTo(String value) {
            addCriterion("msg_data_id <>", value, "msgDataId");
            return (Criteria) this;
        }

        public Criteria andMsgDataIdGreaterThan(String value) {
            addCriterion("msg_data_id >", value, "msgDataId");
            return (Criteria) this;
        }

        public Criteria andMsgDataIdGreaterThanOrEqualTo(String value) {
            addCriterion("msg_data_id >=", value, "msgDataId");
            return (Criteria) this;
        }

        public Criteria andMsgDataIdLessThan(String value) {
            addCriterion("msg_data_id <", value, "msgDataId");
            return (Criteria) this;
        }

        public Criteria andMsgDataIdLessThanOrEqualTo(String value) {
            addCriterion("msg_data_id <=", value, "msgDataId");
            return (Criteria) this;
        }

        public Criteria andMsgDataIdLike(String value) {
            addCriterion("msg_data_id like", value, "msgDataId");
            return (Criteria) this;
        }

        public Criteria andMsgDataIdNotLike(String value) {
            addCriterion("msg_data_id not like", value, "msgDataId");
            return (Criteria) this;
        }

        public Criteria andMsgDataIdIn(List<String> values) {
            addCriterion("msg_data_id in", values, "msgDataId");
            return (Criteria) this;
        }

        public Criteria andMsgDataIdNotIn(List<String> values) {
            addCriterion("msg_data_id not in", values, "msgDataId");
            return (Criteria) this;
        }

        public Criteria andMsgDataIdBetween(String value1, String value2) {
            addCriterion("msg_data_id between", value1, value2, "msgDataId");
            return (Criteria) this;
        }

        public Criteria andMsgDataIdNotBetween(String value1, String value2) {
            addCriterion("msg_data_id not between", value1, value2, "msgDataId");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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

        public Criteria andCreateUserEqualTo(Long value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Long> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Long> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIsNull() {
            addCriterion("last_update_date is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIsNotNull() {
            addCriterion("last_update_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateEqualTo(Date value) {
            addCriterion("last_update_date =", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotEqualTo(Date value) {
            addCriterion("last_update_date <>", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateGreaterThan(Date value) {
            addCriterion("last_update_date >", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_date >=", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLessThan(Date value) {
            addCriterion("last_update_date <", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("last_update_date <=", value, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateIn(List<Date> values) {
            addCriterion("last_update_date in", values, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotIn(List<Date> values) {
            addCriterion("last_update_date not in", values, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateBetween(Date value1, Date value2) {
            addCriterion("last_update_date between", value1, value2, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("last_update_date not between", value1, value2, "lastUpdateDate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIsNull() {
            addCriterion("last_update_user is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIsNotNull() {
            addCriterion("last_update_user is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserEqualTo(Long value) {
            addCriterion("last_update_user =", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNotEqualTo(Long value) {
            addCriterion("last_update_user <>", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserGreaterThan(Long value) {
            addCriterion("last_update_user >", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("last_update_user >=", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserLessThan(Long value) {
            addCriterion("last_update_user <", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserLessThanOrEqualTo(Long value) {
            addCriterion("last_update_user <=", value, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIn(List<Long> values) {
            addCriterion("last_update_user in", values, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNotIn(List<Long> values) {
            addCriterion("last_update_user not in", values, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserBetween(Long value1, Long value2) {
            addCriterion("last_update_user between", value1, value2, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserNotBetween(Long value1, Long value2) {
            addCriterion("last_update_user not between", value1, value2, "lastUpdateUser");
            return (Criteria) this;
        }

        public Criteria andActiveFlagIsNull() {
            addCriterion("active_flag is null");
            return (Criteria) this;
        }

        public Criteria andActiveFlagIsNotNull() {
            addCriterion("active_flag is not null");
            return (Criteria) this;
        }

        public Criteria andActiveFlagEqualTo(Byte value) {
            addCriterion("active_flag =", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagNotEqualTo(Byte value) {
            addCriterion("active_flag <>", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagGreaterThan(Byte value) {
            addCriterion("active_flag >", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("active_flag >=", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagLessThan(Byte value) {
            addCriterion("active_flag <", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagLessThanOrEqualTo(Byte value) {
            addCriterion("active_flag <=", value, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagIn(List<Byte> values) {
            addCriterion("active_flag in", values, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagNotIn(List<Byte> values) {
            addCriterion("active_flag not in", values, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagBetween(Byte value1, Byte value2) {
            addCriterion("active_flag between", value1, value2, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andActiveFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("active_flag not between", value1, value2, "activeFlag");
            return (Criteria) this;
        }

        public Criteria andFilterIdIsNull() {
            addCriterion("filter_id is null");
            return (Criteria) this;
        }

        public Criteria andFilterIdIsNotNull() {
            addCriterion("filter_id is not null");
            return (Criteria) this;
        }

        public Criteria andFilterIdEqualTo(Integer value) {
            addCriterion("filter_id =", value, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdNotEqualTo(Integer value) {
            addCriterion("filter_id <>", value, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdGreaterThan(Integer value) {
            addCriterion("filter_id >", value, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("filter_id >=", value, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdLessThan(Integer value) {
            addCriterion("filter_id <", value, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdLessThanOrEqualTo(Integer value) {
            addCriterion("filter_id <=", value, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdIn(List<Integer> values) {
            addCriterion("filter_id in", values, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdNotIn(List<Integer> values) {
            addCriterion("filter_id not in", values, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdBetween(Integer value1, Integer value2) {
            addCriterion("filter_id between", value1, value2, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("filter_id not between", value1, value2, "filterId");
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