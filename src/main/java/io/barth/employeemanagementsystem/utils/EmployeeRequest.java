package io.barth.employeemanagementsystem.utils;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeRequest {

    private String name;
    private Long age = 0L;
    private String location;

    private String department;

    private String email;

    private Boolean remote = false;

    private Date createdAt;

    private Date updatedAt;
}
