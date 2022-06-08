package az.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml"); //xml base configuration
        context.registerShutdownHook();
   //  ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);//java based configuration

        Notification notification = context.getBean("notification",Notification.class);
      //  Notification notification1 = context.getBean("sms-notification",Notification.class);
        notification.alert();
    }
}
