package az.spring.demo;

public class Email implements Message{
    @Override
    public void send() {
        System.out.println("email was sent successfully...");
    }
}
