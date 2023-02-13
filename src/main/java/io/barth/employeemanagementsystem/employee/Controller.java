package io.barth.employeemanagementsystem.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @GetMapping("employee")
    public List<Employee> getEmployees(){
        return employeeServiceImp.getEmployees();
    }

    @GetMapping("employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeServiceImp.getEmployee(id);
    }

    @PostMapping("employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeServiceImp.createEmployee(employee);
    }

    @PutMapping("employee/{id}")
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        employee.setId(id);
        return employeeServiceImp.updatedEmployee(employee);
    }

    @DeleteMapping("employee/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeServiceImp.deleteEmployee(id);
    }
}
