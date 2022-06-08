package az.springdata.demo.springdatademo.repository;

import az.springdata.demo.springdatademo.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress,Integer> {

}
