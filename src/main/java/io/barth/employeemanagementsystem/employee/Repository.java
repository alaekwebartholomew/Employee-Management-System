package io.barth.employeemanagementsystem.employee;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(String department);
    List<Employee> findByLocationAndRemote(String location, Boolean remote);

    List<Employee> findByFirstNameContaining(String keyword, Sort sort);

    @Query("FROM Employee WHERE firstName = :firstName or location = :location")
    List<Employee> getEmployeeByFirstNameOrByLocation(String firstName, String location);

    @Query("DELETE FROM Employee WHERE firstName = :FirstName")
    Integer deleteEmployeeByFirstName(String name);


}
