package com.huazhu.application.cms.wechat.event.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerInfoExample() {
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

        public Criteria andCusNameIsNull() {
            addCriterion("cus_name is null");
            return (Criteria) this;
        }

        public Criteria andCusNameIsNotNull() {
            addCriterion("cus_name is not null");
            return (Criteria) this;
        }

        public Criteria andCusNameEqualTo(String value) {
            addCriterion("cus_name =", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotEqualTo(String value) {
            addCriterion("cus_name <>", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameGreaterThan(String value) {
            addCriterion("cus_name >", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameGreaterThanOrEqualTo(String value) {
            addCriterion("cus_name >=", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameLessThan(String value) {
            addCriterion("cus_name <", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameLessThanOrEqualTo(String value) {
            addCriterion("cus_name <=", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameLike(String value) {
            addCriterion("cus_name like", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotLike(String value) {
            addCriterion("cus_name not like", value, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameIn(List<String> values) {
            addCriterion("cus_name in", values, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotIn(List<String> values) {
            addCriterion("cus_name not in", values, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameBetween(String value1, String value2) {
            addCriterion("cus_name between", value1, value2, "cusName");
            return (Criteria) this;
        }

        public Criteria andCusNameNotBetween(String value1, String value2) {
            addCriterion("cus_name not between", value1, value2, "cusName");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNull() {
            addCriterion("hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(Long value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(Long value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(Long value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(Long value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(Long value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<Long> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<Long> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(Long value1, Long value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(Long value1, Long value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andCusSexIsNull() {
            addCriterion("cus_sex is null");
            return (Criteria) this;
        }

        public Criteria andCusSexIsNotNull() {
            addCriterion("cus_sex is not null");
            return (Criteria) this;
        }

        public Criteria andCusSexEqualTo(Byte value) {
            addCriterion("cus_sex =", value, "cusSex");
            return (Criteria) this;
        }

        public Criteria andCusSexNotEqualTo(Byte value) {
            addCriterion("cus_sex <>", value, "cusSex");
            return (Criteria) this;
        }

        public Criteria andCusSexGreaterThan(Byte value) {
            addCriterion("cus_sex >", value, "cusSex");
            return (Criteria) this;
        }

        public Criteria andCusSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("cus_sex >=", value, "cusSex");
            return (Criteria) this;
        }

        public Criteria andCusSexLessThan(Byte value) {
            addCriterion("cus_sex <", value, "cusSex");
            return (Criteria) this;
        }

        public Criteria andCusSexLessThanOrEqualTo(Byte value) {
            addCriterion("cus_sex <=", value, "cusSex");
            return (Criteria) this;
        }

        public Criteria andCusSexIn(List<Byte> values) {
            addCriterion("cus_sex in", values, "cusSex");
            return (Criteria) this;
        }

        public Criteria andCusSexNotIn(List<Byte> values) {
            addCriterion("cus_sex not in", values, "cusSex");
            return (Criteria) this;
        }

        public Criteria andCusSexBetween(Byte value1, Byte value2) {
            addCriterion("cus_sex between", value1, value2, "cusSex");
            return (Criteria) this;
        }

        public Criteria andCusSexNotBetween(Byte value1, Byte value2) {
            addCriterion("cus_sex not between", value1, value2, "cusSex");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCusSignIsNull() {
            addCriterion("cus_sign is null");
            return (Criteria) this;
        }

        public Criteria andCusSignIsNotNull() {
            addCriterion("cus_sign is not null");
            return (Criteria) this;
        }

        public Criteria andCusSignEqualTo(String value) {
            addCriterion("cus_sign =", value, "cusSign");
            return (Criteria) this;
        }

        public Criteria andCusSignNotEqualTo(String value) {
            addCriterion("cus_sign <>", value, "cusSign");
            return (Criteria) this;
        }

        public Criteria andCusSignGreaterThan(String value) {
            addCriterion("cus_sign >", value, "cusSign");
            return (Criteria) this;
        }

        public Criteria andCusSignGreaterThanOrEqualTo(String value) {
            addCriterion("cus_sign >=", value, "cusSign");
            return (Criteria) this;
        }

        public Criteria andCusSignLessThan(String value) {
            addCriterion("cus_sign <", value, "cusSign");
            return (Criteria) this;
        }

        public Criteria andCusSignLessThanOrEqualTo(String value) {
            addCriterion("cus_sign <=", value, "cusSign");
            return (Criteria) this;
        }

        public Criteria andCusSignLike(String value) {
            addCriterion("cus_sign like", value, "cusSign");
            return (Criteria) this;
        }

        public Criteria andCusSignNotLike(String value) {
            addCriterion("cus_sign not like", value, "cusSign");
            return (Criteria) this;
        }

        public Criteria andCusSignIn(List<String> values) {
            addCriterion("cus_sign in", values, "cusSign");
            return (Criteria) this;
        }

        public Criteria andCusSignNotIn(List<String> values) {
            addCriterion("cus_sign not in", values, "cusSign");
            return (Criteria) this;
        }

        public Criteria andCusSignBetween(String value1, String value2) {
            addCriterion("cus_sign between", value1, value2, "cusSign");
            return (Criteria) this;
        }

        public Criteria andCusSignNotBetween(String value1, String value2) {
            addCriterion("cus_sign not between", value1, value2, "cusSign");
            return (Criteria) this;
        }

        public Criteria andCusPhotoIsNull() {
            addCriterion("cus_photo is null");
            return (Criteria) this;
        }

        public Criteria andCusPhotoIsNotNull() {
            addCriterion("cus_photo is not null");
            return (Criteria) this;
        }

        public Criteria andCusPhotoEqualTo(String value) {
            addCriterion("cus_photo =", value, "cusPhoto");
            return (Criteria) this;
        }

        public Criteria andCusPhotoNotEqualTo(String value) {
            addCriterion("cus_photo <>", value, "cusPhoto");
            return (Criteria) this;
        }

        public Criteria andCusPhotoGreaterThan(String value) {
            addCriterion("cus_photo >", value, "cusPhoto");
            return (Criteria) this;
        }

        public Criteria andCusPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("cus_photo >=", value, "cusPhoto");
            return (Criteria) this;
        }

        public Criteria andCusPhotoLessThan(String value) {
            addCriterion("cus_photo <", value, "cusPhoto");
            return (Criteria) this;
        }

        public Criteria andCusPhotoLessThanOrEqualTo(String value) {
            addCriterion("cus_photo <=", value, "cusPhoto");
            return (Criteria) this;
        }

        public Criteria andCusPhotoLike(String value) {
            addCriterion("cus_photo like", value, "cusPhoto");
            return (Criteria) this;
        }

        public Criteria andCusPhotoNotLike(String value) {
            addCriterion("cus_photo not like", value, "cusPhoto");
            return (Criteria) this;
        }

        public Criteria andCusPhotoIn(List<String> values) {
            addCriterion("cus_photo in", values, "cusPhoto");
            return (Criteria) this;
        }

        public Criteria andCusPhotoNotIn(List<String> values) {
            addCriterion("cus_photo not in", values, "cusPhoto");
            return (Criteria) this;
        }

        public Criteria andCusPhotoBetween(String value1, String value2) {
            addCriterion("cus_photo between", value1, value2, "cusPhoto");
            return (Criteria) this;
        }

        public Criteria andCusPhotoNotBetween(String value1, String value2) {
            addCriterion("cus_photo not between", value1, value2, "cusPhoto");
            return (Criteria) this;
        }

        public Criteria andCusOpenIdIsNull() {
            addCriterion("cus_open_id is null");
            return (Criteria) this;
        }

        public Criteria andCusOpenIdIsNotNull() {
            addCriterion("cus_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andCusOpenIdEqualTo(String value) {
            addCriterion("cus_open_id =", value, "cusOpenId");
            return (Criteria) this;
        }

        public Criteria andCusOpenIdNotEqualTo(String value) {
            addCriterion("cus_open_id <>", value, "cusOpenId");
            return (Criteria) this;
        }

        public Criteria andCusOpenIdGreaterThan(String value) {
            addCriterion("cus_open_id >", value, "cusOpenId");
            return (Criteria) this;
        }

        public Criteria andCusOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("cus_open_id >=", value, "cusOpenId");
            return (Criteria) this;
        }

        public Criteria andCusOpenIdLessThan(String value) {
            addCriterion("cus_open_id <", value, "cusOpenId");
            return (Criteria) this;
        }

        public Criteria andCusOpenIdLessThanOrEqualTo(String value) {
            addCriterion("cus_open_id <=", value, "cusOpenId");
            return (Criteria) this;
        }

        public Criteria andCusOpenIdLike(String value) {
            addCriterion("cus_open_id like", value, "cusOpenId");
            return (Criteria) this;
        }

        public Criteria andCusOpenIdNotLike(String value) {
            addCriterion("cus_open_id not like", value, "cusOpenId");
            return (Criteria) this;
        }

        public Criteria andCusOpenIdIn(List<String> values) {
            addCriterion("cus_open_id in", values, "cusOpenId");
            return (Criteria) this;
        }

        public Criteria andCusOpenIdNotIn(List<String> values) {
            addCriterion("cus_open_id not in", values, "cusOpenId");
            return (Criteria) this;
        }

        public Criteria andCusOpenIdBetween(String value1, String value2) {
            addCriterion("cus_open_id between", value1, value2, "cusOpenId");
            return (Criteria) this;
        }

        public Criteria andCusOpenIdNotBetween(String value1, String value2) {
            addCriterion("cus_open_id not between", value1, value2, "cusOpenId");
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

        public Criteria andFollowDateIsNull() {
            addCriterion("follow_date is null");
            return (Criteria) this;
        }

        public Criteria andFollowDateIsNotNull() {
            addCriterion("follow_date is not null");
            return (Criteria) this;
        }

        public Criteria andFollowDateEqualTo(Date value) {
            addCriterion("follow_date =", value, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateNotEqualTo(Date value) {
            addCriterion("follow_date <>", value, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateGreaterThan(Date value) {
            addCriterion("follow_date >", value, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateGreaterThanOrEqualTo(Date value) {
            addCriterion("follow_date >=", value, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateLessThan(Date value) {
            addCriterion("follow_date <", value, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateLessThanOrEqualTo(Date value) {
            addCriterion("follow_date <=", value, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateIn(List<Date> values) {
            addCriterion("follow_date in", values, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateNotIn(List<Date> values) {
            addCriterion("follow_date not in", values, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateBetween(Date value1, Date value2) {
            addCriterion("follow_date between", value1, value2, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateNotBetween(Date value1, Date value2) {
            addCriterion("follow_date not between", value1, value2, "followDate");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNull() {
            addCriterion("language is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNotNull() {
            addCriterion("language is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageEqualTo(String value) {
            addCriterion("language =", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotEqualTo(String value) {
            addCriterion("language <>", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThan(String value) {
            addCriterion("language >", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("language >=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThan(String value) {
            addCriterion("language <", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThanOrEqualTo(String value) {
            addCriterion("language <=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLike(String value) {
            addCriterion("language like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotLike(String value) {
            addCriterion("language not like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageIn(List<String> values) {
            addCriterion("language in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotIn(List<String> values) {
            addCriterion("language not in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageBetween(String value1, String value2) {
            addCriterion("language between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotBetween(String value1, String value2) {
            addCriterion("language not between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andSurveyAgeIsNull() {
            addCriterion("survey_age is null");
            return (Criteria) this;
        }

        public Criteria andSurveyAgeIsNotNull() {
            addCriterion("survey_age is not null");
            return (Criteria) this;
        }

        public Criteria andSurveyAgeEqualTo(String value) {
            addCriterion("survey_age =", value, "surveyAge");
            return (Criteria) this;
        }

        public Criteria andSurveyAgeNotEqualTo(String value) {
            addCriterion("survey_age <>", value, "surveyAge");
            return (Criteria) this;
        }

        public Criteria andSurveyAgeGreaterThan(String value) {
            addCriterion("survey_age >", value, "surveyAge");
            return (Criteria) this;
        }

        public Criteria andSurveyAgeGreaterThanOrEqualTo(String value) {
            addCriterion("survey_age >=", value, "surveyAge");
            return (Criteria) this;
        }

        public Criteria andSurveyAgeLessThan(String value) {
            addCriterion("survey_age <", value, "surveyAge");
            return (Criteria) this;
        }

        public Criteria andSurveyAgeLessThanOrEqualTo(String value) {
            addCriterion("survey_age <=", value, "surveyAge");
            return (Criteria) this;
        }

        public Criteria andSurveyAgeLike(String value) {
            addCriterion("survey_age like", value, "surveyAge");
            return (Criteria) this;
        }

        public Criteria andSurveyAgeNotLike(String value) {
            addCriterion("survey_age not like", value, "surveyAge");
            return (Criteria) this;
        }

        public Criteria andSurveyAgeIn(List<String> values) {
            addCriterion("survey_age in", values, "surveyAge");
            return (Criteria) this;
        }

        public Criteria andSurveyAgeNotIn(List<String> values) {
            addCriterion("survey_age not in", values, "surveyAge");
            return (Criteria) this;
        }

        public Criteria andSurveyAgeBetween(String value1, String value2) {
            addCriterion("survey_age between", value1, value2, "surveyAge");
            return (Criteria) this;
        }

        public Criteria andSurveyAgeNotBetween(String value1, String value2) {
            addCriterion("survey_age not between", value1, value2, "surveyAge");
            return (Criteria) this;
        }

        public Criteria andAbroadDestinationIsNull() {
            addCriterion("abroad_destination is null");
            return (Criteria) this;
        }

        public Criteria andAbroadDestinationIsNotNull() {
            addCriterion("abroad_destination is not null");
            return (Criteria) this;
        }

        public Criteria andAbroadDestinationEqualTo(String value) {
            addCriterion("abroad_destination =", value, "abroadDestination");
            return (Criteria) this;
        }

        public Criteria andAbroadDestinationNotEqualTo(String value) {
            addCriterion("abroad_destination <>", value, "abroadDestination");
            return (Criteria) this;
        }

        public Criteria andAbroadDestinationGreaterThan(String value) {
            addCriterion("abroad_destination >", value, "abroadDestination");
            return (Criteria) this;
        }

        public Criteria andAbroadDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("abroad_destination >=", value, "abroadDestination");
            return (Criteria) this;
        }

        public Criteria andAbroadDestinationLessThan(String value) {
            addCriterion("abroad_destination <", value, "abroadDestination");
            return (Criteria) this;
        }

        public Criteria andAbroadDestinationLessThanOrEqualTo(String value) {
            addCriterion("abroad_destination <=", value, "abroadDestination");
            return (Criteria) this;
        }

        public Criteria andAbroadDestinationLike(String value) {
            addCriterion("abroad_destination like", value, "abroadDestination");
            return (Criteria) this;
        }

        public Criteria andAbroadDestinationNotLike(String value) {
            addCriterion("abroad_destination not like", value, "abroadDestination");
            return (Criteria) this;
        }

        public Criteria andAbroadDestinationIn(List<String> values) {
            addCriterion("abroad_destination in", values, "abroadDestination");
            return (Criteria) this;
        }

        public Criteria andAbroadDestinationNotIn(List<String> values) {
            addCriterion("abroad_destination not in", values, "abroadDestination");
            return (Criteria) this;
        }

        public Criteria andAbroadDestinationBetween(String value1, String value2) {
            addCriterion("abroad_destination between", value1, value2, "abroadDestination");
            return (Criteria) this;
        }

        public Criteria andAbroadDestinationNotBetween(String value1, String value2) {
            addCriterion("abroad_destination not between", value1, value2, "abroadDestination");
            return (Criteria) this;
        }

        public Criteria andDomesticDestinationIsNull() {
            addCriterion("domestic_destination is null");
            return (Criteria) this;
        }

        public Criteria andDomesticDestinationIsNotNull() {
            addCriterion("domestic_destination is not null");
            return (Criteria) this;
        }

        public Criteria andDomesticDestinationEqualTo(String value) {
            addCriterion("domestic_destination =", value, "domesticDestination");
            return (Criteria) this;
        }

        public Criteria andDomesticDestinationNotEqualTo(String value) {
            addCriterion("domestic_destination <>", value, "domesticDestination");
            return (Criteria) this;
        }

        public Criteria andDomesticDestinationGreaterThan(String value) {
            addCriterion("domestic_destination >", value, "domesticDestination");
            return (Criteria) this;
        }

        public Criteria andDomesticDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("domestic_destination >=", value, "domesticDestination");
            return (Criteria) this;
        }

        public Criteria andDomesticDestinationLessThan(String value) {
            addCriterion("domestic_destination <", value, "domesticDestination");
            return (Criteria) this;
        }

        public Criteria andDomesticDestinationLessThanOrEqualTo(String value) {
            addCriterion("domestic_destination <=", value, "domesticDestination");
            return (Criteria) this;
        }

        public Criteria andDomesticDestinationLike(String value) {
            addCriterion("domestic_destination like", value, "domesticDestination");
            return (Criteria) this;
        }

        public Criteria andDomesticDestinationNotLike(String value) {
            addCriterion("domestic_destination not like", value, "domesticDestination");
            return (Criteria) this;
        }

        public Criteria andDomesticDestinationIn(List<String> values) {
            addCriterion("domestic_destination in", values, "domesticDestination");
            return (Criteria) this;
        }

        public Criteria andDomesticDestinationNotIn(List<String> values) {
            addCriterion("domestic_destination not in", values, "domesticDestination");
            return (Criteria) this;
        }

        public Criteria andDomesticDestinationBetween(String value1, String value2) {
            addCriterion("domestic_destination between", value1, value2, "domesticDestination");
            return (Criteria) this;
        }

        public Criteria andDomesticDestinationNotBetween(String value1, String value2) {
            addCriterion("domestic_destination not between", value1, value2, "domesticDestination");
            return (Criteria) this;
        }

        public Criteria andActivityIsNull() {
            addCriterion("activity is null");
            return (Criteria) this;
        }

        public Criteria andActivityIsNotNull() {
            addCriterion("activity is not null");
            return (Criteria) this;
        }

        public Criteria andActivityEqualTo(String value) {
            addCriterion("activity =", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotEqualTo(String value) {
            addCriterion("activity <>", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityGreaterThan(String value) {
            addCriterion("activity >", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityGreaterThanOrEqualTo(String value) {
            addCriterion("activity >=", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLessThan(String value) {
            addCriterion("activity <", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLessThanOrEqualTo(String value) {
            addCriterion("activity <=", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLike(String value) {
            addCriterion("activity like", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotLike(String value) {
            addCriterion("activity not like", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityIn(List<String> values) {
            addCriterion("activity in", values, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotIn(List<String> values) {
            addCriterion("activity not in", values, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityBetween(String value1, String value2) {
            addCriterion("activity between", value1, value2, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotBetween(String value1, String value2) {
            addCriterion("activity not between", value1, value2, "activity");
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