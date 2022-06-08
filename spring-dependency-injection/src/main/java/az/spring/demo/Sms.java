package az.spring.demo;

public class Sms implements Message {
    @Override
    public void send(){
        System.out.println("sms was sent succesfully...");
    }
}
