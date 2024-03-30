package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @BeforeEach
    void setUp() throws DepartmentNotFoundException {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Ahmedabad")
                .departmentCode("IT-06")
                .departmentId(1L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
    }

    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;

    @Test
    void whenValidDepartmentName_thenDepartmentShouldBeFound() throws DepartmentNotFoundException {
        String departmentName = "IT";
        Department department = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, department.getDepartmentName());
    }
}