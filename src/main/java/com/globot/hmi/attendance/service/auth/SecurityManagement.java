package com.globot.hmi.attendance.service.auth;/**
 * Created by lixiaoliang on 2017/11/19.
 */

import com.globot.hmi.attendance.dao.mapper.ResourceMapper;
import com.globot.hmi.attendance.domain.Menu;
import com.globot.hmi.attendance.domain.MenuExample;
import com.globot.hmi.attendance.domain.Resource;
import com.globot.hmi.attendance.domain.ResourceExample;
import com.globot.hmi.attendance.dao.mapper.EmployeeMapper;
import com.globot.hmi.attendance.dao.mapper.MenuMapper;
import com.globot.hmi.attendance.dao.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: lixiaoliang
 * Date: 2017/11/19
 * Time: 下午2:32
 */
@Service
public class SecurityManagement {
    /** 用户Mapper */
    @Autowired
    private EmployeeMapper employeeMapper;
    /** 角色Mapper */
    @Autowired
    private RoleMapper roleMapper;
    /** 资源Mapper */
    @Autowired
    private ResourceMapper resourceMapper;
    /** 菜单Mapper */
    @Autowired
    private MenuMapper menuMapper;



    /**
     * 获取菜单列表
     *
     * @return
     */
    public List<Menu> findAllMenu() {
        MenuExample example = new MenuExample();
        example.createCriteria().andStatusEqualTo((byte)1);
        return menuMapper.selectByExample(example);
    }

    /**
     * 获取菜单列表
     *
     * @return
     */
    public List<Resource> findAllResource() {
        ResourceExample example = new ResourceExample();
        example.createCriteria().andStatusEqualTo((byte)1);
        return resourceMapper.selectByExample(example);
    }





}
