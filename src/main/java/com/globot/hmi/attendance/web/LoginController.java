package com.globot.hmi.attendance.web;

import com.globot.hmi.attendance.util.ThreadCache;
import com.globot.hmi.attendance.constants.Constants;
import com.globot.hmi.attendance.domain.Employee;
import com.globot.hmi.attendance.service.employee.IEmployeeService;
import com.globot.hmi.attendance.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * User: lixiaoliang
 * Date: 2017/11/17
 * Time: 下午3:19
 */
@Controller
public class LoginController extends AbstractController{
    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView login(@RequestParam(value = "verificationId", required = true) String verificationId,
                              @RequestParam(value = "passWord", required = true) String passWord,
                              HttpServletResponse response)
    {

        ModelAndView modelAndView = new ModelAndView();
        if(StringUtils.isBlank(verificationId) || StringUtils.isBlank(passWord)) {
            modelAndView.setViewName("/login");
            modelAndView.addObject("errorInfo", "用户名和密码不能为空");
        }
        Employee employee = employeeService.getByJobNumber(verificationId);
        if(employee.getId() != null && MD5Util.equals(passWord, employee.getPassword())) {
            Cookie cookie = new Cookie("auth_info",verificationId);
            cookie.setMaxAge(Constants.ONE_WEEK);
            cookie.setPath("/");
            response.addCookie(cookie);
            ThreadCache.setJobNumber(verificationId);
            modelAndView.addObject("employee", employee);
            modelAndView.setViewName("/common/main");
        } else {
            modelAndView.setViewName("/login");
            modelAndView.addObject("errorInfo", "用户名或密码错误");
        }
        return modelAndView;
    }

}
