package io.barth.employeemanagementsystem.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Employee, Long> {

}
