package com.ssmcrud.controller;

import com.ssmcrud.bean.Msg;
import com.ssmcrud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/dept")
    @ResponseBody
    public Msg getAllDeptName(){
        System.out.println("getAllDeptName()方法调用");
        List list = departmentService.showAllDepartmentName();
        return Msg.success().add("deptList",list);
    }
}
