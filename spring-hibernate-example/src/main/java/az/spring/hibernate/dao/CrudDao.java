package az.spring.hibernate.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<Entity, ID> {

    void save(Entity entity);

    void update(Entity entity);

    void delete(ID id);

    Optional findById(ID id);

    List<Entity> findAll();


}
