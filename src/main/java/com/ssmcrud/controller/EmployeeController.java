package com.ssmcrud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssmcrud.bean.Employee;
import com.ssmcrud.bean.Msg;
import com.ssmcrud.service.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

import static com.ssmcrud.bean.Msg.success;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/emp")
    @ResponseBody
    public Msg empList(Model model,
                       @RequestParam(value ="page",defaultValue="1")int page,@RequestParam(value = "rows",defaultValue = "5")int row){
        PageHelper.startPage(page,row);
        List<Employee> allEmployee = employeeService.getAllEmployeeWithDept();
        PageInfo pageInfo = new PageInfo(allEmployee,row);
        return success().add("pageInfo",pageInfo);
    }

    //    问题一：为什么我ajks发送请求后没有映射到这个方法中
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public void saveEmp(Model model, Employee employee){
        employeeService.saveEmp(employee);
    }


    @RequestMapping("/test")
    public String test(String username,String password){
        System.out.println(username+password);
        return "test";
    }
}
