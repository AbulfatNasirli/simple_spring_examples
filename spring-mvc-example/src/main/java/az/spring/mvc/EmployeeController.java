package az.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    // @RequestMapping(value = "/home",method = RequestMethod.GET)
    @GetMapping(value = "/gethome")
    public String index(Model model) {
        String message = employeeService.getMessage();
        model.addAttribute("message",message);
        return "home";
    }
}
