package az.springdata.demo.springdatademo.service;

import az.springdata.demo.springdatademo.model.Adress;
import az.springdata.demo.springdatademo.model.Employee;
import az.springdata.demo.springdatademo.repository.AdressRepository;
import az.springdata.demo.springdatademo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private AdressRepository adressRepository;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, AdressRepository adressRepository) {
        this.employeeRepository = employeeRepository;
        this.adressRepository = adressRepository;
    }

    public List<Employee> getAllEmployees(int page, int size,String property) {

        Sort sort = Sort.by(Sort.Order.desc(property));
        PageRequest pageRequest = PageRequest.of(page, size,sort);
        return (List<Employee>) employeeRepository.findAll(pageRequest);
    }

    public List<Employee> getEmployeeByName(String name) {

        PageRequest pageRequest = PageRequest.of(0, 10);
        return employeeRepository.findByName(name, (Pageable) pageRequest);
    }

    public List<Employee> getEmployeeByNameAndSurname(String name, String surname) {
        return employeeRepository.findByNameAndSurname(name, surname);
    }


    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Employee not found with given id:"));
    }

    public void insert(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    public void update(Employee employee, Adress adress) {

        adressRepository.save(adress);

        if (employee.getId() <= 0) {
            throw new IllegalArgumentException("id can not be empty");
        }
        employeeRepository.save(employee);
    }

    public void delete(long id) {
        employeeRepository.deleteById(id);
    }
}
