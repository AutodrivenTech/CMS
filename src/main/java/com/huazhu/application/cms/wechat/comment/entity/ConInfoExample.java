package com.huazhu.application.cms.wechat.comment.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConInfoExample() {
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

        public Criteria andConTitleIsNull() {
            addCriterion("con_title is null");
            return (Criteria) this;
        }

        public Criteria andConTitleIsNotNull() {
            addCriterion("con_title is not null");
            return (Criteria) this;
        }

        public Criteria andConTitleEqualTo(String value) {
            addCriterion("con_title =", value, "conTitle");
            return (Criteria) this;
        }

        public Criteria andConTitleNotEqualTo(String value) {
            addCriterion("con_title <>", value, "conTitle");
            return (Criteria) this;
        }

        public Criteria andConTitleGreaterThan(String value) {
            addCriterion("con_title >", value, "conTitle");
            return (Criteria) this;
        }

        public Criteria andConTitleGreaterThanOrEqualTo(String value) {
            addCriterion("con_title >=", value, "conTitle");
            return (Criteria) this;
        }

        public Criteria andConTitleLessThan(String value) {
            addCriterion("con_title <", value, "conTitle");
            return (Criteria) this;
        }

        public Criteria andConTitleLessThanOrEqualTo(String value) {
            addCriterion("con_title <=", value, "conTitle");
            return (Criteria) this;
        }

        public Criteria andConTitleLike(String value) {
            addCriterion("con_title like", value, "conTitle");
            return (Criteria) this;
        }

        public Criteria andConTitleNotLike(String value) {
            addCriterion("con_title not like", value, "conTitle");
            return (Criteria) this;
        }

        public Criteria andConTitleIn(List<String> values) {
            addCriterion("con_title in", values, "conTitle");
            return (Criteria) this;
        }

        public Criteria andConTitleNotIn(List<String> values) {
            addCriterion("con_title not in", values, "conTitle");
            return (Criteria) this;
        }

        public Criteria andConTitleBetween(String value1, String value2) {
            addCriterion("con_title between", value1, value2, "conTitle");
            return (Criteria) this;
        }

        public Criteria andConTitleNotBetween(String value1, String value2) {
            addCriterion("con_title not between", value1, value2, "conTitle");
            return (Criteria) this;
        }

        public Criteria andConDescIsNull() {
            addCriterion("con_desc is null");
            return (Criteria) this;
        }

        public Criteria andConDescIsNotNull() {
            addCriterion("con_desc is not null");
            return (Criteria) this;
        }

        public Criteria andConDescEqualTo(String value) {
            addCriterion("con_desc =", value, "conDesc");
            return (Criteria) this;
        }

        public Criteria andConDescNotEqualTo(String value) {
            addCriterion("con_desc <>", value, "conDesc");
            return (Criteria) this;
        }

        public Criteria andConDescGreaterThan(String value) {
            addCriterion("con_desc >", value, "conDesc");
            return (Criteria) this;
        }

        public Criteria andConDescGreaterThanOrEqualTo(String value) {
            addCriterion("con_desc >=", value, "conDesc");
            return (Criteria) this;
        }

        public Criteria andConDescLessThan(String value) {
            addCriterion("con_desc <", value, "conDesc");
            return (Criteria) this;
        }

        public Criteria andConDescLessThanOrEqualTo(String value) {
            addCriterion("con_desc <=", value, "conDesc");
            return (Criteria) this;
        }

        public Criteria andConDescLike(String value) {
            addCriterion("con_desc like", value, "conDesc");
            return (Criteria) this;
        }

        public Criteria andConDescNotLike(String value) {
            addCriterion("con_desc not like", value, "conDesc");
            return (Criteria) this;
        }

        public Criteria andConDescIn(List<String> values) {
            addCriterion("con_desc in", values, "conDesc");
            return (Criteria) this;
        }

        public Criteria andConDescNotIn(List<String> values) {
            addCriterion("con_desc not in", values, "conDesc");
            return (Criteria) this;
        }

        public Criteria andConDescBetween(String value1, String value2) {
            addCriterion("con_desc between", value1, value2, "conDesc");
            return (Criteria) this;
        }

        public Criteria andConDescNotBetween(String value1, String value2) {
            addCriterion("con_desc not between", value1, value2, "conDesc");
            return (Criteria) this;
        }

        public Criteria andConTypeIsNull() {
            addCriterion("con_type is null");
            return (Criteria) this;
        }

        public Criteria andConTypeIsNotNull() {
            addCriterion("con_type is not null");
            return (Criteria) this;
        }

        public Criteria andConTypeEqualTo(Byte value) {
            addCriterion("con_type =", value, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeNotEqualTo(Byte value) {
            addCriterion("con_type <>", value, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeGreaterThan(Byte value) {
            addCriterion("con_type >", value, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("con_type >=", value, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeLessThan(Byte value) {
            addCriterion("con_type <", value, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeLessThanOrEqualTo(Byte value) {
            addCriterion("con_type <=", value, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeIn(List<Byte> values) {
            addCriterion("con_type in", values, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeNotIn(List<Byte> values) {
            addCriterion("con_type not in", values, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeBetween(Byte value1, Byte value2) {
            addCriterion("con_type between", value1, value2, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("con_type not between", value1, value2, "conType");
            return (Criteria) this;
        }

        public Criteria andConTagIsNull() {
            addCriterion("con_tag is null");
            return (Criteria) this;
        }

        public Criteria andConTagIsNotNull() {
            addCriterion("con_tag is not null");
            return (Criteria) this;
        }

        public Criteria andConTagEqualTo(Long value) {
            addCriterion("con_tag =", value, "conTag");
            return (Criteria) this;
        }

        public Criteria andConTagNotEqualTo(Long value) {
            addCriterion("con_tag <>", value, "conTag");
            return (Criteria) this;
        }

        public Criteria andConTagGreaterThan(Long value) {
            addCriterion("con_tag >", value, "conTag");
            return (Criteria) this;
        }

        public Criteria andConTagGreaterThanOrEqualTo(Long value) {
            addCriterion("con_tag >=", value, "conTag");
            return (Criteria) this;
        }

        public Criteria andConTagLessThan(Long value) {
            addCriterion("con_tag <", value, "conTag");
            return (Criteria) this;
        }

        public Criteria andConTagLessThanOrEqualTo(Long value) {
            addCriterion("con_tag <=", value, "conTag");
            return (Criteria) this;
        }

        public Criteria andConTagIn(List<Long> values) {
            addCriterion("con_tag in", values, "conTag");
            return (Criteria) this;
        }

        public Criteria andConTagNotIn(List<Long> values) {
            addCriterion("con_tag not in", values, "conTag");
            return (Criteria) this;
        }

        public Criteria andConTagBetween(Long value1, Long value2) {
            addCriterion("con_tag between", value1, value2, "conTag");
            return (Criteria) this;
        }

        public Criteria andConTagNotBetween(Long value1, Long value2) {
            addCriterion("con_tag not between", value1, value2, "conTag");
            return (Criteria) this;
        }

        public Criteria andConShareIsNull() {
            addCriterion("con_share is null");
            return (Criteria) this;
        }

        public Criteria andConShareIsNotNull() {
            addCriterion("con_share is not null");
            return (Criteria) this;
        }

        public Criteria andConShareEqualTo(Byte value) {
            addCriterion("con_share =", value, "conShare");
            return (Criteria) this;
        }

        public Criteria andConShareNotEqualTo(Byte value) {
            addCriterion("con_share <>", value, "conShare");
            return (Criteria) this;
        }

        public Criteria andConShareGreaterThan(Byte value) {
            addCriterion("con_share >", value, "conShare");
            return (Criteria) this;
        }

        public Criteria andConShareGreaterThanOrEqualTo(Byte value) {
            addCriterion("con_share >=", value, "conShare");
            return (Criteria) this;
        }

        public Criteria andConShareLessThan(Byte value) {
            addCriterion("con_share <", value, "conShare");
            return (Criteria) this;
        }

        public Criteria andConShareLessThanOrEqualTo(Byte value) {
            addCriterion("con_share <=", value, "conShare");
            return (Criteria) this;
        }

        public Criteria andConShareIn(List<Byte> values) {
            addCriterion("con_share in", values, "conShare");
            return (Criteria) this;
        }

        public Criteria andConShareNotIn(List<Byte> values) {
            addCriterion("con_share not in", values, "conShare");
            return (Criteria) this;
        }

        public Criteria andConShareBetween(Byte value1, Byte value2) {
            addCriterion("con_share between", value1, value2, "conShare");
            return (Criteria) this;
        }

        public Criteria andConShareNotBetween(Byte value1, Byte value2) {
            addCriterion("con_share not between", value1, value2, "conShare");
            return (Criteria) this;
        }

        public Criteria andConMessageIsNull() {
            addCriterion("con_message is null");
            return (Criteria) this;
        }

        public Criteria andConMessageIsNotNull() {
            addCriterion("con_message is not null");
            return (Criteria) this;
        }

        public Criteria andConMessageEqualTo(Byte value) {
            addCriterion("con_message =", value, "conMessage");
            return (Criteria) this;
        }

        public Criteria andConMessageNotEqualTo(Byte value) {
            addCriterion("con_message <>", value, "conMessage");
            return (Criteria) this;
        }

        public Criteria andConMessageGreaterThan(Byte value) {
            addCriterion("con_message >", value, "conMessage");
            return (Criteria) this;
        }

        public Criteria andConMessageGreaterThanOrEqualTo(Byte value) {
            addCriterion("con_message >=", value, "conMessage");
            return (Criteria) this;
        }

        public Criteria andConMessageLessThan(Byte value) {
            addCriterion("con_message <", value, "conMessage");
            return (Criteria) this;
        }

        public Criteria andConMessageLessThanOrEqualTo(Byte value) {
            addCriterion("con_message <=", value, "conMessage");
            return (Criteria) this;
        }

        public Criteria andConMessageIn(List<Byte> values) {
            addCriterion("con_message in", values, "conMessage");
            return (Criteria) this;
        }

        public Criteria andConMessageNotIn(List<Byte> values) {
            addCriterion("con_message not in", values, "conMessage");
            return (Criteria) this;
        }

        public Criteria andConMessageBetween(Byte value1, Byte value2) {
            addCriterion("con_message between", value1, value2, "conMessage");
            return (Criteria) this;
        }

        public Criteria andConMessageNotBetween(Byte value1, Byte value2) {
            addCriterion("con_message not between", value1, value2, "conMessage");
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

        public Criteria andConUrlIsNull() {
            addCriterion("con_url is null");
            return (Criteria) this;
        }

        public Criteria andConUrlIsNotNull() {
            addCriterion("con_url is not null");
            return (Criteria) this;
        }

        public Criteria andConUrlEqualTo(String value) {
            addCriterion("con_url =", value, "conUrl");
            return (Criteria) this;
        }

        public Criteria andConUrlNotEqualTo(String value) {
            addCriterion("con_url <>", value, "conUrl");
            return (Criteria) this;
        }

        public Criteria andConUrlGreaterThan(String value) {
            addCriterion("con_url >", value, "conUrl");
            return (Criteria) this;
        }

        public Criteria andConUrlGreaterThanOrEqualTo(String value) {
            addCriterion("con_url >=", value, "conUrl");
            return (Criteria) this;
        }

        public Criteria andConUrlLessThan(String value) {
            addCriterion("con_url <", value, "conUrl");
            return (Criteria) this;
        }

        public Criteria andConUrlLessThanOrEqualTo(String value) {
            addCriterion("con_url <=", value, "conUrl");
            return (Criteria) this;
        }

        public Criteria andConUrlLike(String value) {
            addCriterion("con_url like", value, "conUrl");
            return (Criteria) this;
        }

        public Criteria andConUrlNotLike(String value) {
            addCriterion("con_url not like", value, "conUrl");
            return (Criteria) this;
        }

        public Criteria andConUrlIn(List<String> values) {
            addCriterion("con_url in", values, "conUrl");
            return (Criteria) this;
        }

        public Criteria andConUrlNotIn(List<String> values) {
            addCriterion("con_url not in", values, "conUrl");
            return (Criteria) this;
        }

        public Criteria andConUrlBetween(String value1, String value2) {
            addCriterion("con_url between", value1, value2, "conUrl");
            return (Criteria) this;
        }

        public Criteria andConUrlNotBetween(String value1, String value2) {
            addCriterion("con_url not between", value1, value2, "conUrl");
            return (Criteria) this;
        }

        public Criteria andMateIdIsNull() {
            addCriterion("mate_id is null");
            return (Criteria) this;
        }

        public Criteria andMateIdIsNotNull() {
            addCriterion("mate_id is not null");
            return (Criteria) this;
        }

        public Criteria andMateIdEqualTo(Integer value) {
            addCriterion("mate_id =", value, "mateId");
            return (Criteria) this;
        }

        public Criteria andMateIdNotEqualTo(Integer value) {
            addCriterion("mate_id <>", value, "mateId");
            return (Criteria) this;
        }

        public Criteria andMateIdGreaterThan(Integer value) {
            addCriterion("mate_id >", value, "mateId");
            return (Criteria) this;
        }

        public Criteria andMateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mate_id >=", value, "mateId");
            return (Criteria) this;
        }

        public Criteria andMateIdLessThan(Integer value) {
            addCriterion("mate_id <", value, "mateId");
            return (Criteria) this;
        }

        public Criteria andMateIdLessThanOrEqualTo(Integer value) {
            addCriterion("mate_id <=", value, "mateId");
            return (Criteria) this;
        }

        public Criteria andMateIdIn(List<Integer> values) {
            addCriterion("mate_id in", values, "mateId");
            return (Criteria) this;
        }

        public Criteria andMateIdNotIn(List<Integer> values) {
            addCriterion("mate_id not in", values, "mateId");
            return (Criteria) this;
        }

        public Criteria andMateIdBetween(Integer value1, Integer value2) {
            addCriterion("mate_id between", value1, value2, "mateId");
            return (Criteria) this;
        }

        public Criteria andMateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mate_id not between", value1, value2, "mateId");
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

        public Criteria andReleaseTimeIsNull() {
            addCriterion("release_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("release_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(Date value) {
            addCriterion("release_time =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(Date value) {
            addCriterion("release_time <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(Date value) {
            addCriterion("release_time >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("release_time >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(Date value) {
            addCriterion("release_time <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("release_time <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<Date> values) {
            addCriterion("release_time in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<Date> values) {
            addCriterion("release_time not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(Date value1, Date value2) {
            addCriterion("release_time between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("release_time not between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Date value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Date value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Date value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Date value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Date> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Date> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Date value1, Date value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNull() {
            addCriterion("message_type is null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNotNull() {
            addCriterion("message_type is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeEqualTo(Byte value) {
            addCriterion("message_type =", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotEqualTo(Byte value) {
            addCriterion("message_type <>", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThan(Byte value) {
            addCriterion("message_type >", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("message_type >=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThan(Byte value) {
            addCriterion("message_type <", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThanOrEqualTo(Byte value) {
            addCriterion("message_type <=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIn(List<Byte> values) {
            addCriterion("message_type in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotIn(List<Byte> values) {
            addCriterion("message_type not in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeBetween(Byte value1, Byte value2) {
            addCriterion("message_type between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("message_type not between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("keyword is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("keyword is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("keyword =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("keyword <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("keyword >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("keyword >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("keyword <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("keyword <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("keyword like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("keyword not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("keyword in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("keyword not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("keyword between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("keyword not between", value1, value2, "keyword");
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