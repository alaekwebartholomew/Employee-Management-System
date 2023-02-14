package io.barth.employeemanagementsystem.employee;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pagination extends PagingAndSortingRepository<Employee, Long> {
}
