package com.globot.hmi.attendance.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Employee {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.id
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.name
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.gender
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    private Boolean gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.job_number
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    private String jobNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.email
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.mobile
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.position
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    private Byte position;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.birthday
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.org
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    private String org;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.add_time
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    private Date addTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.modify_time
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.memo
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    private String memo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.status
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.password
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.id
     *
     * @return the value of employee.id
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.id
     *
     * @param id the value for employee.id
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.name
     *
     * @return the value of employee.name
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.name
     *
     * @param name the value for employee.name
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.gender
     *
     * @return the value of employee.gender
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public Boolean getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.gender
     *
     * @param gender the value for employee.gender
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.job_number
     *
     * @return the value of employee.job_number
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public String getJobNumber() {
        return jobNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.job_number
     *
     * @param jobNumber the value for employee.job_number
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.email
     *
     * @return the value of employee.email
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.email
     *
     * @param email the value for employee.email
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.mobile
     *
     * @return the value of employee.mobile
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.mobile
     *
     * @param mobile the value for employee.mobile
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.position
     *
     * @return the value of employee.position
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public Byte getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.position
     *
     * @param position the value for employee.position
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public void setPosition(Byte position) {
        this.position = position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.birthday
     *
     * @return the value of employee.birthday
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.birthday
     *
     * @param birthday the value for employee.birthday
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.org
     *
     * @return the value of employee.org
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public String getOrg() {
        return org;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.org
     *
     * @param org the value for employee.org
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.add_time
     *
     * @return the value of employee.add_time
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.add_time
     *
     * @param addTime the value for employee.add_time
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.modify_time
     *
     * @return the value of employee.modify_time
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.modify_time
     *
     * @param modifyTime the value for employee.modify_time
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.memo
     *
     * @return the value of employee.memo
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.memo
     *
     * @param memo the value for employee.memo
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.status
     *
     * @return the value of employee.status
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.status
     *
     * @param status the value for employee.status
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.password
     *
     * @return the value of employee.password
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.password
     *
     * @param password the value for employee.password
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}