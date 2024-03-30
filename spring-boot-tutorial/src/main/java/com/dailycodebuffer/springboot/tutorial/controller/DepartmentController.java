package com.dailycodebuffer.springboot.tutorial.controller;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//this Annotation tells us thar what ever methods we are creating inside it are rest api end points
public class DepartmentController {


    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired//means auto-wire the object with our reference variable
    DepartmentService departmentService;

    //auto wire is property based injection
    @PostMapping("/departments")
    //before spring boot we have to map the jason body to our object manually
    //by object mappers
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("Inside saveDepartment() function of Department Controller class");
        //logger.info(""); will log the message whenever the request comes into this function
        //loggers can be added to debug the application
        //loggers can also be added to service layer and repository layer
        //thread class and log message will get printed
        //different types of policies can be used to aggregate logs ex console based, file based,rolling based via config file
        //check the docs to implement
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")

    public List<Department> fetchDepartments() {
        logger.info("Inside fetchDepartment() function of Department Controller class");
        return departmentService.fetchDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        logger.info("Inside fetchDepartmentById() function of Department Controller class");
        return departmentService.fetchDepartmentsById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        logger.info("Inside deleteDepartment() function of Department Controller class");

        departmentService.deleteDepartmentsById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        logger.info("Inside updateDepartment() function of Department Controller class");
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) throws DepartmentNotFoundException {
        logger.info("Inside fetchDepartmentByName() function of Department Controller class");
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
