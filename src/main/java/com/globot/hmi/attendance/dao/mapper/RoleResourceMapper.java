package com.globot.hmi.attendance.dao.mapper;

import com.globot.hmi.attendance.domain.RoleResource;
import com.globot.hmi.attendance.domain.RoleResourceExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int countByExample(RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int deleteByExample(RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int insert(RoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int insertSelective(RoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    List<RoleResource> selectByExample(RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    RoleResource selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int updateByExampleSelective(@Param("record") RoleResource record, @Param("example") RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int updateByExample(@Param("record") RoleResource record, @Param("example") RoleResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int updateByPrimaryKeySelective(RoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_resource
     *
     * @mbggenerated Sun Nov 19 17:06:02 CST 2017
     */
    int updateByPrimaryKey(RoleResource record);
}