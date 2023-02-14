package io.barth.employeemanagementsystem.employee;

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

    @GetMapping("employee")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeServiceImp.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        return new ResponseEntity<>(employeeServiceImp.getEmployee(id), HttpStatus.OK);
    }

    @PostMapping("employee")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(employeeServiceImp.createEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        employee.setId(id);
        return new ResponseEntity<>(employeeServiceImp.updatedEmployee(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
        employeeServiceImp.deleteEmployee(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
