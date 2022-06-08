package az.spring.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {

    @Bean("sms")
    public Message getSms() {
        return new Sms();
    }

    @Bean("email")
    public Message getEmail() {
        return new Email();
    }


    @Bean
    public Employee getEmployee() {
        Employee employee = new Employee();
        employee.setName("Abulfat");
        employee.setSurname("Nasirli");
        employee.setAge(23);
        employee.setSalary(1220.0);
        return employee;
    }

    @Bean("email-notification")
    @Scope("prototype")
    public Notification getNotification(@Qualifier("email") Message message, Employee employee) {
        Notification notification = new Notification(); //setter injection
        notification.setMessage(message);
        notification.setEmployee(employee);
        return notification;
    }

    @Bean("sms-notification")
    @Scope("prototype")
    public Notification getNotification2(@Qualifier("sms") Message message, Employee employee) {
        Notification notification = new Notification(); //setter injection
        notification.setMessage(message);
        notification.setEmployee(employee);
        return notification;
    }

}
