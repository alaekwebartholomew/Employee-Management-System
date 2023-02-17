package io.barth.employeemanagementsystem.employee;

import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> getEmployees(int pageNumber, int pageSize);

    public Employee createEmployee(Employee employee);

    public Employee getEmployee(Long id);

    public Employee updatedEmployee(Employee employee);

    public void deleteEmployee(Long id);

    public List<Employee> getEmployeeByDepartment(String department);

    public List<Employee> getEmployeeByLocationAndRemote(String location, Boolean remote);

    public List<Employee> getEmployeeByKeyword(String name);

    public List<Employee> getEmployeeByFirstNameOrLocation(String name, String location);

    Integer deleteEmployeeByFirstName(String name);

}
