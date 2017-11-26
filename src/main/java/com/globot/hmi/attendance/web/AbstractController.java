package com.globot.hmi.attendance.web;/**
 * Created by lixiaoliang on 2017/11/19.
 */

import com.globot.hmi.attendance.domain.Employee;
import com.globot.hmi.attendance.domain.Menu;
import com.globot.hmi.attendance.domain.Resource;
import com.globot.hmi.attendance.exception.BusinessException;
import com.globot.hmi.attendance.service.auth.SecurityManagement;
import com.globot.hmi.attendance.service.employee.IEmployeeService;
import com.globot.hmi.attendance.util.ThreadCache;
import com.globot.hmi.attendance.web.vo.MenuVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: lixiaoliang
 * Date: 2017/11/19
 * Time: 下午2:26
 */
public abstract class AbstractController {
    /** logger */
    private Logger logger = LoggerFactory.getLogger(AbstractController.class);


    /** SecurityManagement */
    @Autowired
    private SecurityManagement securityManagement;

    @Autowired
    private IEmployeeService employeeService;

    /**
     * set common attributes
     *
     * @param model
     *            Model instance
     * @throws BusinessException
     */
    @ModelAttribute
    public void modelAttribute(Model model) throws BusinessException {
//        model.addAttribute("imgbaseurl", config.getImgbaseurl());
        model.addAttribute("employee", this.getUser()); // 资源Id字符串
        model.addAttribute("menus", this.constructMenus(securityManagement.findAllMenu(),
                securityManagement.findAllResource()));
    }

    /**
     * get current user
     *
     * @return current user information
     */
    protected Employee getUser() {
        String jobNumer = ThreadCache.getJobNumber();
        if(StringUtils.isBlank(jobNumer)) {
            return null;
        }
        Employee employee = employeeService.getByJobNumber(jobNumer);
        if (employee == null) {
            logger.error("查询用户信息失败，员工号为：" + jobNumer);
            return null;
        }
        return employee;

    }

    private List<MenuVO> constructMenus(List<Menu> menus, List<Resource> resources) {
        if(CollectionUtils.isEmpty(menus) || CollectionUtils.isEmpty(resources)) {
            return ListUtils.EMPTY_LIST;
        }
        Collections.sort(menus);
        Map<Integer, MenuVO> menuVOMap = new HashMap<Integer, MenuVO>();
        Map<Integer, Resource> resourceMap = resources.stream().collect(Collectors.toMap(Resource::getId, resource -> resource));
        Map<Integer, Menu> menuMap = menus.stream().collect(Collectors.toMap(Menu::getId, menu -> menu));
        for(Menu menu : menus) {
            if(menuVOMap.containsKey(menu.getId())) {
                continue;
            }
            MenuVO menuVO = new MenuVO(menu);
            menuVO.setResource(resourceMap.get(menu.getResourceId()));
            if (menu.getParentId() == 0) {
                menuVOMap.put(menu.getId(), menuVO);
                continue;
            }
            if (!menuVOMap.containsKey(menu.getParentId())) {
                MenuVO parentMenuVO = new MenuVO(menuMap.get(menu.getParentId()));
                parentMenuVO.setResource(resourceMap.get(parentMenuVO.getResourceId()));
                parentMenuVO.getChildren().add(menuVO);
                menuVOMap.put(parentMenuVO.getId(), parentMenuVO);
            } else  {
                MenuVO parentMenuVO = menuVOMap.get(menu.getParentId());
                parentMenuVO.getChildren().add(menuVO);
            }
        }
        return new ArrayList<>(menuVOMap.values());
    }


    /**
     * get resource for user
     *
     * @return
     */
    protected TreeSet<Resource> getResource() {
        TreeSet<Resource> resources = new TreeSet<Resource>();
//        List<Role> roles = securityManagement
//                .findRolesByUserId(ThreadCache.getUserId(), null, null, null);
//        if (roles == null) {
//            return null;
//        }
//        for (Role role : roles) {
//            List<Resource> res = securityManagement
//                    .findDisplayResourceByRoleId(role.getId());
//            if (res != null) {
//                resources.addAll(res);
//            }
//
//        }
        List<Resource> res = securityManagement.findAllResource();
        resources.addAll(res);
        resources.comparator();

        return resources;
    }

}
