package com.globot.hmi.attendance.service.employee;/**
 * Created by lixiaoliang on 2017/11/18.
 */

import com.globot.hmi.attendance.domain.Employee;
import com.globot.hmi.attendance.util.Page;

/**
 * User: lixiaoliang
 * Date: 2017/11/18
 * Time: 上午9:36
 */
public interface IEmployeeService {
    /**
     * 根据员工ID查询
     * @param employeeId
     * @return
     */
    Employee getById(Integer employeeId);

    /**
     * 根据员工号查询
     * @param jobNumber
     * @return
     */
    Employee getByJobNumber(String jobNumber);

    /**
     * 添加员工
     * @param employee
     * @return
     */
    Employee add(Employee employee);

    /**
     * 更新员工信息
     * @param employee
     * @return
     */
    Employee update(Employee employee);

    /**
     * 删除员工
     * @param employee
     */
    void deleteById(Employee employee);

    /**
     * 根据页码查询
     */
    Page findAllByPage(Page page);
}
