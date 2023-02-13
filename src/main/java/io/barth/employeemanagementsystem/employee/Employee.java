package io.barth.employeemanagementsystem.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {

    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private Long age;
    private String location;
    private String email;
    private Boolean remote;
    private String department;
}
