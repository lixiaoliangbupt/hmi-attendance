package com.globot.hmi.attendance.web;/**
 * Created by lixiaoliang on 2017/11/14.
 */

import com.globot.hmi.attendance.constants.Constants;
import com.globot.hmi.attendance.domain.Employee;
import com.globot.hmi.attendance.service.employee.IEmployeeService;
import com.globot.hmi.attendance.util.CookieUtil;
import com.globot.hmi.attendance.util.MD5Util;
import com.globot.hmi.attendance.util.ThreadCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: lixiaoliang
 * Date: 2017/11/14
 * Time: 下午4:43
 */
@Controller
public class IndexController extends AbstractController{
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/index")
    public ModelAndView index()
    {
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }

    @RequestMapping("/")
    public ModelAndView toIndex(HttpServletRequest request)
    {
        String verificationId = CookieUtil.getByName(Constants.AUTH_INFO, request.getCookies());
        Employee employee = employeeService.getByJobNumber(verificationId);
        ModelAndView modelAndView = new ModelAndView();
        if(employee != null && employee.getId() != null) {
            modelAndView.addObject("employee", employee);
            modelAndView.setViewName("/common/main");
        } else {
            modelAndView.setViewName("/index");
        }
        return modelAndView;
    }
}
