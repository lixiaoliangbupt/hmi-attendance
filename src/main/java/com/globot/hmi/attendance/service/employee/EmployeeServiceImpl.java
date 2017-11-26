package com.globot.hmi.attendance.service.employee;

import com.globot.hmi.attendance.domain.Employee;
import com.globot.hmi.attendance.constants.EmployeeStatusEnum;
import com.globot.hmi.attendance.dao.mapper.EmployeeMapper;
import com.globot.hmi.attendance.domain.EmployeeExample;
import com.globot.hmi.attendance.util.Page;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: lixiaoliang
 * Date: 2017/11/18
 * Time: 上午9:39
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    public static final Employee NULL_EMPLOYEE = new Employee();

    @Autowired
    private EmployeeMapper employeeMapper;


    public Employee getById(Integer employeeId) {
        return employeeMapper.selectByPrimaryKey(employeeId);
    }

    public Employee getByJobNumber(String jobNumber) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andJobNumberEqualTo(jobNumber);
        List<Employee> employees =  employeeMapper.selectByExample(employeeExample);
        if(CollectionUtils.isNotEmpty(employees)) {
            return employees.get(0);
        }
        return NULL_EMPLOYEE;
    }

    public Employee add(Employee employee) {
        employeeMapper.insert(employee);
        return employee;
    }

    public Employee update(Employee employee) {
        employeeMapper.updateByPrimaryKey(employee);
        return employee;
    }

    public void deleteById(Employee employee) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andIdEqualTo(employee.getId()).andStatusEqualTo((byte)EmployeeStatusEnum.LEAVE.getCode());
        employeeMapper.updateByExampleSelective(employee, employeeExample);
    }

    public Page findAllByPage(Page page) {
        if (page == null) {
            page = new Page<Employee>(10);
        }
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andStatusEqualTo((byte) EmployeeStatusEnum.NORMAL.getCode());
        int count = employeeMapper.countByExample(employeeExample);
        List<Employee> employees = employeeMapper.selectByPage(page);
        page.setResult(employees);
        page.setTotalCount(count);
        return page;
    }
}
