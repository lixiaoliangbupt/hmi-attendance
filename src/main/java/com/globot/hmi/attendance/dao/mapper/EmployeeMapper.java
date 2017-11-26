package com.globot.hmi.attendance.dao.mapper;

import com.globot.hmi.attendance.domain.Employee;
import com.globot.hmi.attendance.domain.EmployeeExample;
import com.globot.hmi.attendance.util.Page;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    int countByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    int deleteByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    int insert(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    int insertSelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    List<Employee> selectByExample(EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    Employee selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbggenerated Sun Nov 19 16:28:02 CST 2017
     */
    int updateByPrimaryKey(Employee record);

    /**
     *
     */
    List<Employee> selectByPage(Page page);
}