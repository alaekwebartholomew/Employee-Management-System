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
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        return new ResponseEntity<>(employeeServiceImp.getEmployees(pageNumber, pageSize), HttpStatus.OK);
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
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return new ResponseEntity<>(employeeServiceImp.updatedEmployee(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
        employeeServiceImp.deleteEmployee(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("employee/findByDepartment")
    public ResponseEntity<List<Employee>> getEmployeeByDepartment(@RequestParam String department){
        return new ResponseEntity<>(employeeServiceImp.getEmployeeByDepartment(department), HttpStatus.OK);
    }

    @GetMapping("employee/findByLocationAndRemote")
    public ResponseEntity<List<Employee>> getEmployeeByLocationAndRemote(@RequestParam String location, @RequestParam Boolean remote){
        return new ResponseEntity<>(employeeServiceImp.getEmployeeByLocationAndRemote(location, remote), HttpStatus.OK);
    }

    @GetMapping("employee/findByKeyword")
    public ResponseEntity<List<Employee>> getEmployeeByKeyword(@RequestParam String  name){
        return new ResponseEntity<>(employeeServiceImp.getEmployeeByKeyword(name), HttpStatus.OK);
    }

    @GetMapping("employee/{firstName}/{location}")
    public ResponseEntity<List<Employee>> getEmployeeByFirstNameAndLocation(@PathVariable String  firstName, @PathVariable String location){
        return new ResponseEntity<>(employeeServiceImp.getEmployeeByFirstNameOrLocation(firstName, location), HttpStatus.OK);
    }
}
