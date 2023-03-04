package io.barth.employeemanagementsystem.employee;

import io.barth.employeemanagementsystem.department.Department;
import io.barth.employeemanagementsystem.utils.EmployeeRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name shouldn't be null")
    private String name;
    private Long age = 0L;
    private String location;

    @Email(message = "Enter valid email")
    private String email;

    private Boolean remote = false;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public Employee(@Valid EmployeeRequest request) {
        this.name = request.getName();
        this.age = request.getAge();
        this.remote = request.getRemote();
        this.email = request.getEmail();
        this.location = request.getLocation();
    }
}
