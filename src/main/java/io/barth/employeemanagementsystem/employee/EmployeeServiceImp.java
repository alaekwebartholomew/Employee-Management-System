package io.barth.employeemanagementsystem.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private Repository repository;

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        PageRequest pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "id");
        Page<Employee> employees = repository.findAll(pages);
        return employees.getContent();
    }

    // create employee
    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> employee = repository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new RuntimeException("Employee with id of "+ id + " does not exist");
    }

    @Override
    public Employee updatedEmployee(Employee employee) {

        return repository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {

        repository.deleteById(id);
    }

}
