package az.spring.hibernate.dao;

import az.spring.hibernate.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeDao extends CrudDao<Employee, Long>{

    List<Employee> findByName(String name);

}
