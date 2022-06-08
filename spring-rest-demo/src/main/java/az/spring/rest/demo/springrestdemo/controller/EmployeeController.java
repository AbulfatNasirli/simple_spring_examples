package az.spring.rest.demo.springrestdemo.controller;


import az.spring.rest.demo.springrestdemo.rest.model.dto.EmployeeDto;
import az.spring.rest.demo.springrestdemo.rest.model.response.EmployeeResponse;
import az.spring.rest.demo.springrestdemo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Tag(name = "Employee services", description = "employee services")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EmployeeResponse> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{employee-id}")//http://localhost:8089/api/2 pathvariable
    @Operation(summary = "This gets employee by id")
    public EmployeeDto getEmployeeById(@PathVariable("employee-id") long id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/search") //http://localhost:8089/api/search?name=Jorge&surname=Jesus
    public EmployeeResponse getEmployeeByNameAndSurname(@RequestParam("name") String name,
                                                        @RequestParam("surname") String surname) {
        return employeeService.getEmployeByNameAndSurname(name, surname);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody @Valid EmployeeDto employeeDto) {
        employeeService.insert(employeeDto);
    }


    @PutMapping("/{id}")
    public void updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable long id) {
        employeeService.update(employeeDto, id);
    }

    @PatchMapping("/{id}")
    public void updateSome(@RequestBody EmployeeDto employeeDto, @PathVariable long id) {
        employeeService.update(employeeDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        employeeService.delete(id);
    }

}
