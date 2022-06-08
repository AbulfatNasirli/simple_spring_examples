package az.spring.hibernate;

import az.spring.hibernate.config.SpringHibernateConfig;
import az.spring.hibernate.dao.EmployeeDao;
import az.spring.hibernate.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
        Employee employee = new Employee();
        employee.setName("abulfat");
        employee.setSurname("nasirli");
        employee.setAge(23);
        employee.setSalary(1222.0);
        //employeeDao.insert(employee);
    }
}
