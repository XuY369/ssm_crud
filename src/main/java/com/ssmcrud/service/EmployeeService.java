package com.ssmcrud.service;

import com.ssmcrud.bean.Employee;
import com.ssmcrud.bean.EmployeeExample;
import com.ssmcrud.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeDao;
    public List<Employee> getAllEmployeeWithDept(){
        List<Employee> employees = employeeDao.selectByExampleWithDept(null);
        return employees;
    }

    public void saveEmp(Employee employee) {
        employeeDao.insert(employee);
    }

    public boolean getEmpName(String empName) {
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andEmpNameEqualTo(empName);
        List<Employee> employees = employeeDao.selectByExample(example);
        if (employees.size()==0)return true;
        else return false;
    }
}
