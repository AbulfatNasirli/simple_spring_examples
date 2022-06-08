package az.springdata.demo.springdatademo;

import az.springdata.demo.springdatademo.model.Adress;
import az.springdata.demo.springdatademo.model.Employee;
import az.springdata.demo.springdatademo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Employee employee = new Employee();
        Adress adress = new Adress();
        adress.setId(12);
        adress.setStreet("Islam Safarli kucasi");

        employee.setId(0);
        employee.setName("Abulfat");
        employee.setSurname("Nasirli");
        employee.setAge(23);
        employee.setSalary(1200.1);

        //service.insert(employee);
        service.update(employee,adress);
      //  service.getAllEmployees().forEach(System.out::println);
    }
}
