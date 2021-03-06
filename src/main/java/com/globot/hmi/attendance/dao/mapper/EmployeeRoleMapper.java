package com.globot.hmi.attendance.dao.mapper;

import com.globot.hmi.attendance.domain.EmployeeRoleExample;
import com.globot.hmi.attendance.domain.EmployeeRole;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_role
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int countByExample(EmployeeRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_role
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int deleteByExample(EmployeeRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_role
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_role
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int insert(EmployeeRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_role
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int insertSelective(EmployeeRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_role
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    List<EmployeeRole> selectByExample(EmployeeRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_role
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    EmployeeRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_role
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int updateByExampleSelective(@Param("record") EmployeeRole record, @Param("example") EmployeeRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_role
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int updateByExample(@Param("record") EmployeeRole record, @Param("example") EmployeeRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_role
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int updateByPrimaryKeySelective(EmployeeRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_role
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int updateByPrimaryKey(EmployeeRole record);
}