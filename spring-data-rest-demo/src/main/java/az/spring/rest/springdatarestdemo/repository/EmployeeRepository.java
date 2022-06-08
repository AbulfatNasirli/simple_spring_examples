package az.spring.rest.springdatarestdemo.repository;

import az.spring.rest.springdatarestdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path = "/find") resourcenin adini deyisdirmek ucun
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
}
