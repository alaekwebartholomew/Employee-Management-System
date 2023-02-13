package io.barth.employeemanagementsystem.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> getEmployees();

    public Employee createEmployee(Employee employee);

    public Employee getEmployee(Long id);

    public Employee updatedEmployee(Employee employee);

    public void deleteEmployee(Long id);
}
