package az.spring.mvc;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public String getMessage() {
        return "Hello Spring MVC";
    }
}
