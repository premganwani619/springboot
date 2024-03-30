package com.dailycodebuffer.springboot.tutorial.repository;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findByDepartmentName(String departmentName);

}
//repository layer also called data access layer
//this layer is responsible for database interaction and dababase operations
//jpa repository gives many methods to interact entity, with database
