package az.spring.hibernate.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
}
