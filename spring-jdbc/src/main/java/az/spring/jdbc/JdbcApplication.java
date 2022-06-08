package az.spring.jdbc;

import az.spring.jdbc.config.SpringJdbcConfig;
import az.spring.jdbc.dao.EmployeeDao;
import az.spring.jdbc.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
       // ApplicationContext context = new ClassPathXmlApplicationContext("beans/spring-jdbc-config.xml");
        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
           long count = employeeDao.count();
         //  System.out.println(count);

        System.out.println(employeeDao.getAllEmployees());

      // System.out.println( employeeDao.getEmployeeById(2));

//        Employee emp = new Employee();
//        emp.setName("Elxan");
//        emp.setSurname("Iman");
//        emp.setAge(10);
//        emp.setSalary(1220.3);
//        emp.setId(5);
//
//        employeeDao.insert(emp);

    }
}
