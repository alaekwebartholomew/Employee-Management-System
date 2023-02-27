package io.barth.employeemanagementsystem.department;

import io.barth.employeemanagementsystem.employee.Employee;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
