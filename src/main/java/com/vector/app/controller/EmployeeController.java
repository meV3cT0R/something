package com.vector.app.controller;

import com.vector.app.model.Employee;
import com.vector.app.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @RequestMapping(value="/addEmployee",method=RequestMethod.GET)
    public String getAddEmployee() {
        return "employeeindex";
    }

    @RequestMapping(value="/addEmployee",method=RequestMethod.POST)
    public String doAddEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "employeeindex";
    }
}
