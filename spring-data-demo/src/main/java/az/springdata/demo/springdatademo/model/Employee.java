package az.springdata.demo.springdatademo.model;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "surname", length = 40)
    private String surname;

    private int age;
    private double salary;

    @OneToOne(mappedBy = "employee")
    private Adress adress;

}
