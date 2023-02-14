package io.barth.employeemanagementsystem.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(String department);
    List<Employee> findByLocationAndRemote(String location, Boolean remote);

    List<Employee> findByFirstNameContaining(String keyword);


}
