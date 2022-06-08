package az.spring.rest.demo.springrestdemo.repository;

import az.spring.rest.demo.springrestdemo.model.Employee;
import az.spring.rest.demo.springrestdemo.rest.model.dto.EmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameAndSurname(String name, String surname);
}

