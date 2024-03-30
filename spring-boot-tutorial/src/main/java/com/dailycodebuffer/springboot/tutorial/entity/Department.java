package com.dailycodebuffer.springboot.tutorial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder//by this annotation entire builder pattern will be implemented for all layers
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long departmentId;
    @NotNull(message = "Please add Department Name")
//    @Length(min = 1 , max = 10,message = "please enter between 1-10 characters")
//    @Size(min = 1 , max = 10,message = "please enter between 1-10 characters")
//    @Email(regexp = "")
//    @Positive()
//    @PositiveOrZero
//    @Negative
//    @NegativeOrZero
//    @Future
//    @FutureOrPresent
//    @Past
//    @PastOrPresent
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
//spring-boot-starter-validation starter module  has hibernate validator dependency used for hibernate validation