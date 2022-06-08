package az.spring.boot.controller;

import az.spring.boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    private EmployeeService employeeService;

    @Autowired
    public ViewController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/home")
    public String index(Model model) {
        model.addAttribute("employee",employeeService.getEmployee());
        return "index";
    }
}
