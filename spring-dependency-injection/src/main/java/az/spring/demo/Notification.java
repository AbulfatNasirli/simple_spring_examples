package az.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class Notification {
     @Autowired
   private Message message;
   private Employee employee;


   public Notification(){
       System.out.println("notification constructor worked");
   }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // setter injection
    public void setMessage(Message message){
        this.message=message;
    }

    public void alert() {
        System.out.println("Notification...");
        System.out.println(employee);
        message.send();
    }
    public void myInit(){
        System.out.println("my init method work");
    }

    public void destroyMethod(){
        System.out.println("destroy method work");
    }
}
