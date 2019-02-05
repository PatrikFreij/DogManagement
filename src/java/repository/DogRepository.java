package repository;

import entity.Dog;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DogRepository {
    
    @PersistenceContext(name = "PU")
    EntityManager em;
    
    public void create(Dog d) {
        em.persist(d);
    }
    
    public Dog read(Long id) {
        return em.find(Dog.class, id);
    }
    
    public void update(Dog d) {
        em.merge(d);
    }
    
    public void deleteById(Long id) {
        Dog d = em.find(Dog.class, id);
        em.remove(d);
    }
    
    public List<Dog> findAll() {
        return em.createQuery("SELECT e FROM Dog e").getResultList();
    }

}
