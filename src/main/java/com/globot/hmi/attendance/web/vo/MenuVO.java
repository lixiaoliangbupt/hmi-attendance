package com.globot.hmi.attendance.web.vo;

import com.globot.hmi.attendance.domain.Menu;
import com.globot.hmi.attendance.domain.Resource;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: lixiaoliang
 * Date: 2017/11/25
 * Time: 下午8:49
 */
public class MenuVO extends Menu {

    private Resource resource;
    private List<MenuVO> children = new ArrayList<>();

    public MenuVO(Menu menu) {
        if (menu != null) {
            BeanCopier beanCopier = BeanCopier.create(Menu.class, MenuVO.class, false);
            beanCopier.copy(menu, this, null);
        }
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public List<MenuVO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVO> children) {
        this.children = children;
    }
}
