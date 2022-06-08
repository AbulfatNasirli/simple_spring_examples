package az.spring.rest.demo.springrestdemo.service.impl;

import az.spring.rest.demo.springrestdemo.enums.ErrorCodeEnum;
import az.spring.rest.demo.springrestdemo.exception.CustomNotFoundException;
import az.spring.rest.demo.springrestdemo.model.Employee;
import az.spring.rest.demo.springrestdemo.repository.EmployeeRepository;
import az.spring.rest.demo.springrestdemo.rest.model.dto.EmployeeDto;
import az.spring.rest.demo.springrestdemo.rest.model.response.EmployeeResponse;
import az.spring.rest.demo.springrestdemo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse getAllEmployees() {
        List<EmployeeDto> employeeDtoList = employeeRepository.findAll().
                stream().
                map(employee -> convertToDto(employee)).
                collect(Collectors.toList());
        return makeEmployeeResponse(employeeDtoList);
    }

    @Override
    public EmployeeDto getEmployee(long id) {
        return employeeRepository.findById(id).
                map(employee -> convertToDto(employee)).
                orElseThrow(() -> new CustomNotFoundException(ErrorCodeEnum.EMPLOYEE_NOT_FOUND));

    }

    @Override
    public EmployeeResponse getEmployeByNameAndSurname(String name, String surname) {
        List<EmployeeDto> employeeDtos = employeeRepository.findByNameAndSurname(name, surname).
                stream().
                map(employee -> convertToDto(employee)).
                collect(Collectors.toList());

        return makeEmployeeResponse(employeeDtos);
    }

    @Override
    public void insert(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeRepository.save(employee);
    }

    @Override
    public void update(EmployeeDto employeeDto, long id) {
        Employee employee = getEmployeeById(id);
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employeeDto.setSalary(employeeDto.getSalary());

        employeeRepository.save(employee);
    }

    @Override
    public void updateSome(EmployeeDto employeeDto, long id) {
        Employee employee = getEmployeeById(id);
        if (employeeDto.getName() != null) {
            employee.setName(employeeDto.getName());
        }
        if (employeeDto.getSurname() != null) {
            employee.setSurname(employeeDto.getName());
        }
        if (employeeDto.getAge() > 0) {
            employee.setAge(employeeDto.getAge());
        }
        if (employeeDto.getSalary() > 0)
            employeeDto.setSalary(employeeDto.getSalary());

        employeeRepository.save(employee);
    }

    @Override
    public void delete(long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }

    private EmployeeDto convertToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto(); // CONVERT
        BeanUtils.copyProperties(employee, employeeDto);
        return employeeDto;


        /*     return EmployeeDto.builder().id(employee.getId()).  CONVERT
                name(employee.getName()).
                surname(employee.getSurname()).
                age(employee.getAge()).
                salary(employee.getSalary()).build();  */

    }

    private EmployeeResponse makeEmployeeResponse(List<EmployeeDto> employeeDtos) {
        return EmployeeResponse.builder()
                .employees(employeeDtos).
                        build();
    }

    private Employee getEmployeeById(long id) {
        Employee employee = employeeRepository.
                findById(id).
                orElseThrow(() -> new CustomNotFoundException(ErrorCodeEnum.EMPLOYEE_NOT_FOUND));
        return employee;
    }

}
