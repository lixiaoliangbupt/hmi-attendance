package com.globot.hmi.attendance.web.employee;

import com.globot.hmi.attendance.domain.Employee;
import com.globot.hmi.attendance.service.employee.IEmployeeService;
import com.globot.hmi.attendance.util.Page;
import com.globot.hmi.attendance.util.AjaxResultUtil;
import com.globot.hmi.attendance.web.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: lixiaoliang
 * Date: 2017/11/19
 * Time: 下午5:37
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController extends AbstractController {

    @Autowired
    private IEmployeeService employeeService;


    @RequestMapping(value = "/list", method = RequestMethod.GET )
    public String login(@RequestParam(value = "page", required = true, defaultValue = "1" ) Integer page,
                              Model model) {
        Page pageUser = new Page();
        pageUser.setPageSize(15);
        pageUser.setPageNo(page);
        pageUser = employeeService.findAllByPage(pageUser);//.findUserByRoles(null, null, null, null, roleIds, null, pageUser);
        List<Integer> pageC = new ArrayList<Integer>();
        int cycle = 0;
        if(page%10==0){
            cycle = page/10-1;
        }
        else{
            cycle = page/10;
        }
        for(int i = 1; i<=pageUser.getTotalPages(); i++){
            if(i>=cycle*10+1&&i<=cycle*10+10){
                pageC.add(i);
            }
        }
        model.addAttribute("users", pageUser.getResult());
        model.addAttribute("page", page);
        model.addAttribute("pagecount", pageC);
        model.addAttribute("maxPage", pageUser.getTotalPages());
        return "/employee/emp_list";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String empInfo(@RequestParam(value = "id", required = true, defaultValue = "1") Integer id,
                           Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "/employee/emp_info";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        return "/employee/emp_add";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST )
    @ResponseBody
    public Map<String, Object> update(@RequestParam(value = "page", required = true ) Integer page,
                        Model model) {
        Page pageUser = new Page();
        pageUser.setPageSize(15);
        pageUser.setPageNo(page);
        pageUser = employeeService.findAllByPage(pageUser);//.findUserByRoles(null, null, null, null, roleIds, null, pageUser);
        List<Integer> pageC = new ArrayList<Integer>();
        int cycle = 0;
        if(page%10==0){
            cycle = page/10-1;
        }
        else{
            cycle = page/10;
        }
        for(int i = 1; i<=pageUser.getTotalPages(); i++){
            if(i>=cycle*10+1&&i<=cycle*10+10){
                pageC.add(i);
            }
        }
        model.addAttribute("users", pageUser.getResult());
        model.addAttribute("page", page);
        model.addAttribute("pagecount", pageC);
        model.addAttribute("maxPage", pageUser.getTotalPages());
        return AjaxResultUtil.success();
    }



}
