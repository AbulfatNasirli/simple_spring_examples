package az.spring.hibernate.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",length = 25)
    private long empId;

    @Column(name = "name",length = 25)
    private String name;

    @Column(name = "surname",length = 25)
    private String surname;

    @Column(name = "age",length = 25)
    private int age;

    @Column(name = "salary", length = 25)
    private double salary;

}
