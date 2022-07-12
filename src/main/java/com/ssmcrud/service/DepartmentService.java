package com.ssmcrud.service;

import com.ssmcrud.bean.Department;
import com.ssmcrud.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentDao;

    public List showAllDepartmentName() {
        List<Department> departments = departmentDao.selectByExample(null);
        return departments;
    }
}
