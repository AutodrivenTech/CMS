package com.huazhu.application.cms.wechat.menu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WechatMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WechatMenuExample() {
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

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIsNull() {
            addCriterion("menu_type is null");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIsNotNull() {
            addCriterion("menu_type is not null");
            return (Criteria) this;
        }

        public Criteria andMenuTypeEqualTo(String value) {
            addCriterion("menu_type =", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotEqualTo(String value) {
            addCriterion("menu_type <>", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeGreaterThan(String value) {
            addCriterion("menu_type >", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeGreaterThanOrEqualTo(String value) {
            addCriterion("menu_type >=", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLessThan(String value) {
            addCriterion("menu_type <", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLessThanOrEqualTo(String value) {
            addCriterion("menu_type <=", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLike(String value) {
            addCriterion("menu_type like", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotLike(String value) {
            addCriterion("menu_type not like", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIn(List<String> values) {
            addCriterion("menu_type in", values, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotIn(List<String> values) {
            addCriterion("menu_type not in", values, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeBetween(String value1, String value2) {
            addCriterion("menu_type between", value1, value2, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotBetween(String value1, String value2) {
            addCriterion("menu_type not between", value1, value2, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNull() {
            addCriterion("menu_url is null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNotNull() {
            addCriterion("menu_url is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlEqualTo(String value) {
            addCriterion("menu_url =", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotEqualTo(String value) {
            addCriterion("menu_url <>", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThan(String value) {
            addCriterion("menu_url >", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("menu_url >=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThan(String value) {
            addCriterion("menu_url <", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("menu_url <=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLike(String value) {
            addCriterion("menu_url like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotLike(String value) {
            addCriterion("menu_url not like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIn(List<String> values) {
            addCriterion("menu_url in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotIn(List<String> values) {
            addCriterion("menu_url not in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlBetween(String value1, String value2) {
            addCriterion("menu_url between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotBetween(String value1, String value2) {
            addCriterion("menu_url not between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andParentMenuIsNull() {
            addCriterion("parent_menu is null");
            return (Criteria) this;
        }

        public Criteria andParentMenuIsNotNull() {
            addCriterion("parent_menu is not null");
            return (Criteria) this;
        }

        public Criteria andParentMenuEqualTo(Long value) {
            addCriterion("parent_menu =", value, "parentMenu");
            return (Criteria) this;
        }

        public Criteria andParentMenuNotEqualTo(Long value) {
            addCriterion("parent_menu <>", value, "parentMenu");
            return (Criteria) this;
        }

        public Criteria andParentMenuGreaterThan(Long value) {
            addCriterion("parent_menu >", value, "parentMenu");
            return (Criteria) this;
        }

        public Criteria andParentMenuGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_menu >=", value, "parentMenu");
            return (Criteria) this;
        }

        public Criteria andParentMenuLessThan(Long value) {
            addCriterion("parent_menu <", value, "parentMenu");
            return (Criteria) this;
        }

        public Criteria andParentMenuLessThanOrEqualTo(Long value) {
            addCriterion("parent_menu <=", value, "parentMenu");
            return (Criteria) this;
        }

        public Criteria andParentMenuIn(List<Long> values) {
            addCriterion("parent_menu in", values, "parentMenu");
            return (Criteria) this;
        }

        public Criteria andParentMenuNotIn(List<Long> values) {
            addCriterion("parent_menu not in", values, "parentMenu");
            return (Criteria) this;
        }

        public Criteria andParentMenuBetween(Long value1, Long value2) {
            addCriterion("parent_menu between", value1, value2, "parentMenu");
            return (Criteria) this;
        }

        public Criteria andParentMenuNotBetween(Long value1, Long value2) {
            addCriterion("parent_menu not between", value1, value2, "parentMenu");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(Byte value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(Byte value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(Byte value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(Byte value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(Byte value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<Byte> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<Byte> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(Byte value1, Byte value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(Byte value1, Byte value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andVakue5IsNull() {
            addCriterion("vakue5 is null");
            return (Criteria) this;
        }

        public Criteria andVakue5IsNotNull() {
            addCriterion("vakue5 is not null");
            return (Criteria) this;
        }

        public Criteria andVakue5EqualTo(String value) {
            addCriterion("vakue5 =", value, "vakue5");
            return (Criteria) this;
        }

        public Criteria andVakue5NotEqualTo(String value) {
            addCriterion("vakue5 <>", value, "vakue5");
            return (Criteria) this;
        }

        public Criteria andVakue5GreaterThan(String value) {
            addCriterion("vakue5 >", value, "vakue5");
            return (Criteria) this;
        }

        public Criteria andVakue5GreaterThanOrEqualTo(String value) {
            addCriterion("vakue5 >=", value, "vakue5");
            return (Criteria) this;
        }

        public Criteria andVakue5LessThan(String value) {
            addCriterion("vakue5 <", value, "vakue5");
            return (Criteria) this;
        }

        public Criteria andVakue5LessThanOrEqualTo(String value) {
            addCriterion("vakue5 <=", value, "vakue5");
            return (Criteria) this;
        }

        public Criteria andVakue5Like(String value) {
            addCriterion("vakue5 like", value, "vakue5");
            return (Criteria) this;
        }

        public Criteria andVakue5NotLike(String value) {
            addCriterion("vakue5 not like", value, "vakue5");
            return (Criteria) this;
        }

        public Criteria andVakue5In(List<String> values) {
            addCriterion("vakue5 in", values, "vakue5");
            return (Criteria) this;
        }

        public Criteria andVakue5NotIn(List<String> values) {
            addCriterion("vakue5 not in", values, "vakue5");
            return (Criteria) this;
        }

        public Criteria andVakue5Between(String value1, String value2) {
            addCriterion("vakue5 between", value1, value2, "vakue5");
            return (Criteria) this;
        }

        public Criteria andVakue5NotBetween(String value1, String value2) {
            addCriterion("vakue5 not between", value1, value2, "vakue5");
            return (Criteria) this;
        }

        public Criteria andVakue4IsNull() {
            addCriterion("vakue4 is null");
            return (Criteria) this;
        }

        public Criteria andVakue4IsNotNull() {
            addCriterion("vakue4 is not null");
            return (Criteria) this;
        }

        public Criteria andVakue4EqualTo(String value) {
            addCriterion("vakue4 =", value, "vakue4");
            return (Criteria) this;
        }

        public Criteria andVakue4NotEqualTo(String value) {
            addCriterion("vakue4 <>", value, "vakue4");
            return (Criteria) this;
        }

        public Criteria andVakue4GreaterThan(String value) {
            addCriterion("vakue4 >", value, "vakue4");
            return (Criteria) this;
        }

        public Criteria andVakue4GreaterThanOrEqualTo(String value) {
            addCriterion("vakue4 >=", value, "vakue4");
            return (Criteria) this;
        }

        public Criteria andVakue4LessThan(String value) {
            addCriterion("vakue4 <", value, "vakue4");
            return (Criteria) this;
        }

        public Criteria andVakue4LessThanOrEqualTo(String value) {
            addCriterion("vakue4 <=", value, "vakue4");
            return (Criteria) this;
        }

        public Criteria andVakue4Like(String value) {
            addCriterion("vakue4 like", value, "vakue4");
            return (Criteria) this;
        }

        public Criteria andVakue4NotLike(String value) {
            addCriterion("vakue4 not like", value, "vakue4");
            return (Criteria) this;
        }

        public Criteria andVakue4In(List<String> values) {
            addCriterion("vakue4 in", values, "vakue4");
            return (Criteria) this;
        }

        public Criteria andVakue4NotIn(List<String> values) {
            addCriterion("vakue4 not in", values, "vakue4");
            return (Criteria) this;
        }

        public Criteria andVakue4Between(String value1, String value2) {
            addCriterion("vakue4 between", value1, value2, "vakue4");
            return (Criteria) this;
        }

        public Criteria andVakue4NotBetween(String value1, String value2) {
            addCriterion("vakue4 not between", value1, value2, "vakue4");
            return (Criteria) this;
        }

        public Criteria andVakue3IsNull() {
            addCriterion("vakue3 is null");
            return (Criteria) this;
        }

        public Criteria andVakue3IsNotNull() {
            addCriterion("vakue3 is not null");
            return (Criteria) this;
        }

        public Criteria andVakue3EqualTo(String value) {
            addCriterion("vakue3 =", value, "vakue3");
            return (Criteria) this;
        }

        public Criteria andVakue3NotEqualTo(String value) {
            addCriterion("vakue3 <>", value, "vakue3");
            return (Criteria) this;
        }

        public Criteria andVakue3GreaterThan(String value) {
            addCriterion("vakue3 >", value, "vakue3");
            return (Criteria) this;
        }

        public Criteria andVakue3GreaterThanOrEqualTo(String value) {
            addCriterion("vakue3 >=", value, "vakue3");
            return (Criteria) this;
        }

        public Criteria andVakue3LessThan(String value) {
            addCriterion("vakue3 <", value, "vakue3");
            return (Criteria) this;
        }

        public Criteria andVakue3LessThanOrEqualTo(String value) {
            addCriterion("vakue3 <=", value, "vakue3");
            return (Criteria) this;
        }

        public Criteria andVakue3Like(String value) {
            addCriterion("vakue3 like", value, "vakue3");
            return (Criteria) this;
        }

        public Criteria andVakue3NotLike(String value) {
            addCriterion("vakue3 not like", value, "vakue3");
            return (Criteria) this;
        }

        public Criteria andVakue3In(List<String> values) {
            addCriterion("vakue3 in", values, "vakue3");
            return (Criteria) this;
        }

        public Criteria andVakue3NotIn(List<String> values) {
            addCriterion("vakue3 not in", values, "vakue3");
            return (Criteria) this;
        }

        public Criteria andVakue3Between(String value1, String value2) {
            addCriterion("vakue3 between", value1, value2, "vakue3");
            return (Criteria) this;
        }

        public Criteria andVakue3NotBetween(String value1, String value2) {
            addCriterion("vakue3 not between", value1, value2, "vakue3");
            return (Criteria) this;
        }

        public Criteria andVakue2IsNull() {
            addCriterion("vakue2 is null");
            return (Criteria) this;
        }

        public Criteria andVakue2IsNotNull() {
            addCriterion("vakue2 is not null");
            return (Criteria) this;
        }

        public Criteria andVakue2EqualTo(String value) {
            addCriterion("vakue2 =", value, "vakue2");
            return (Criteria) this;
        }

        public Criteria andVakue2NotEqualTo(String value) {
            addCriterion("vakue2 <>", value, "vakue2");
            return (Criteria) this;
        }

        public Criteria andVakue2GreaterThan(String value) {
            addCriterion("vakue2 >", value, "vakue2");
            return (Criteria) this;
        }

        public Criteria andVakue2GreaterThanOrEqualTo(String value) {
            addCriterion("vakue2 >=", value, "vakue2");
            return (Criteria) this;
        }

        public Criteria andVakue2LessThan(String value) {
            addCriterion("vakue2 <", value, "vakue2");
            return (Criteria) this;
        }

        public Criteria andVakue2LessThanOrEqualTo(String value) {
            addCriterion("vakue2 <=", value, "vakue2");
            return (Criteria) this;
        }

        public Criteria andVakue2Like(String value) {
            addCriterion("vakue2 like", value, "vakue2");
            return (Criteria) this;
        }

        public Criteria andVakue2NotLike(String value) {
            addCriterion("vakue2 not like", value, "vakue2");
            return (Criteria) this;
        }

        public Criteria andVakue2In(List<String> values) {
            addCriterion("vakue2 in", values, "vakue2");
            return (Criteria) this;
        }

        public Criteria andVakue2NotIn(List<String> values) {
            addCriterion("vakue2 not in", values, "vakue2");
            return (Criteria) this;
        }

        public Criteria andVakue2Between(String value1, String value2) {
            addCriterion("vakue2 between", value1, value2, "vakue2");
            return (Criteria) this;
        }

        public Criteria andVakue2NotBetween(String value1, String value2) {
            addCriterion("vakue2 not between", value1, value2, "vakue2");
            return (Criteria) this;
        }

        public Criteria andVakue1IsNull() {
            addCriterion("vakue1 is null");
            return (Criteria) this;
        }

        public Criteria andVakue1IsNotNull() {
            addCriterion("vakue1 is not null");
            return (Criteria) this;
        }

        public Criteria andVakue1EqualTo(String value) {
            addCriterion("vakue1 =", value, "vakue1");
            return (Criteria) this;
        }

        public Criteria andVakue1NotEqualTo(String value) {
            addCriterion("vakue1 <>", value, "vakue1");
            return (Criteria) this;
        }

        public Criteria andVakue1GreaterThan(String value) {
            addCriterion("vakue1 >", value, "vakue1");
            return (Criteria) this;
        }

        public Criteria andVakue1GreaterThanOrEqualTo(String value) {
            addCriterion("vakue1 >=", value, "vakue1");
            return (Criteria) this;
        }

        public Criteria andVakue1LessThan(String value) {
            addCriterion("vakue1 <", value, "vakue1");
            return (Criteria) this;
        }

        public Criteria andVakue1LessThanOrEqualTo(String value) {
            addCriterion("vakue1 <=", value, "vakue1");
            return (Criteria) this;
        }

        public Criteria andVakue1Like(String value) {
            addCriterion("vakue1 like", value, "vakue1");
            return (Criteria) this;
        }

        public Criteria andVakue1NotLike(String value) {
            addCriterion("vakue1 not like", value, "vakue1");
            return (Criteria) this;
        }

        public Criteria andVakue1In(List<String> values) {
            addCriterion("vakue1 in", values, "vakue1");
            return (Criteria) this;
        }

        public Criteria andVakue1NotIn(List<String> values) {
            addCriterion("vakue1 not in", values, "vakue1");
            return (Criteria) this;
        }

        public Criteria andVakue1Between(String value1, String value2) {
            addCriterion("vakue1 between", value1, value2, "vakue1");
            return (Criteria) this;
        }

        public Criteria andVakue1NotBetween(String value1, String value2) {
            addCriterion("vakue1 not between", value1, value2, "vakue1");
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