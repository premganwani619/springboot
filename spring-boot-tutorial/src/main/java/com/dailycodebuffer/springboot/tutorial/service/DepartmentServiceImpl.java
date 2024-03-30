package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentRepository departmentRepository;
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public Department fetchDepartmentsById(Long departmentId) throws DepartmentNotFoundException {

         Optional<Department> department = departmentRepository.findById(departmentId);
         if (!department.isPresent()){
             throw  new DepartmentNotFoundException("Department not found");
         }
         return department.get();

    }

    @Override
    public void deleteDepartmentsById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department dept = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName())&&!"".equalsIgnoreCase(department.getDepartmentName())){
            dept.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&!"".equalsIgnoreCase(department.getDepartmentAddress())){
            dept.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode())&&!"".equalsIgnoreCase(department.getDepartmentCode())){
            dept.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(dept);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) throws DepartmentNotFoundException {
        Department department = departmentRepository.findByDepartmentName(departmentName);
        if (department == null) {
            throw new DepartmentNotFoundException("Not found");
        }
        return department;
    }



    @Override
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }


}
