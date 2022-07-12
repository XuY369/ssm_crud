package com.ssmcrud.service;

import com.ssmcrud.bean.Employee;
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
}
