package io.barth.employeemanagementsystem.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentName(String name);

}
