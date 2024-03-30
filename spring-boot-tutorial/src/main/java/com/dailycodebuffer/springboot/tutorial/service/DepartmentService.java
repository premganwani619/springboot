package com.dailycodebuffer.springboot.tutorial.service;
import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;


public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartments();
    public Department fetchDepartmentsById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentsById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);


    public Department fetchDepartmentByName(String departmentName) throws DepartmentNotFoundException;
}
