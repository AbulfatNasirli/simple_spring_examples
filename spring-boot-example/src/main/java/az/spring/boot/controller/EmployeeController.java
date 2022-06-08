package az.spring.boot.controller;

import az.spring.boot.dto.EmployeeDto;
import az.spring.boot.service.EmployeeService;
import az.spring.boot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployes() {
        return employeeService.getEmployee();
    }
}
