package az.spring.boot.service;

import az.spring.boot.dto.EmployeeDto;
import az.spring.boot.model.Employee;
import az.spring.boot.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> getEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().
                map(employee -> getEmployeeDto(employee)).
                collect(Collectors.toList());
    }

    private EmployeeDto getEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return employeeDto;
    }

//    public List<Employee> getEmployee(){
//        return List.of(Employee.builder().
//                name("abulfat").
//                surname("nasirli").
//                build(),Employee.builder().
//                name("Ahmedshah").
//                surname("Nasirli").
//                build());
//    }
}
