package io.barth.employeemanagementsystem.employee;

import io.barth.employeemanagementsystem.department.Department;
import io.barth.employeemanagementsystem.department.DepartmentRepository;
import io.barth.employeemanagementsystem.utils.EmployeeRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @Autowired
    private DepartmentRepository departmentRepository;

    // Get all employee
    @GetMapping("employee")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        return new ResponseEntity<>(employeeServiceImp.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    // Get employee by Id
    @GetMapping("employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        return new ResponseEntity<>(employeeServiceImp.getEmployee(id), HttpStatus.OK);
    }

    // Create an employee
    @PostMapping("employee")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        Department department = new Department();
        department.setName(employeeRequest.getDepartment());
        department = departmentRepository.save(department);

        Employee employee = new Employee(employeeRequest);
        employee.setDepartment(department);
        employee.setAge(employeeRequest.getAge());
        employee.setEmail(employeeRequest.getEmail());
        employee.setLocation(employeeRequest.getLocation());
        employee.setRemote(employeeRequest.getRemote());
        employee = employeeServiceImp.createEmployee(employee);

        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);

    }

    // Update an employee
    @PutMapping("employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return new ResponseEntity<>(employeeServiceImp.updatedEmployee(employee), HttpStatus.CREATED);
    }

    // Delete an employee
    @DeleteMapping("employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
        employeeServiceImp.deleteEmployee(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("employee/filter/{name}")
    ResponseEntity<List<Employee>> getEmployeeByDepartment(@PathVariable String name){
        return new ResponseEntity<List<Employee>>(employeeServiceImp.getEmployeeByDepartment(name), HttpStatus.OK);
    }

}
