package javaee7crud.repositories;

import javaee7crud.entities.Record;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Implementation of Record repository using postgresql database and hibernate.
 * 
 * @author Petr Smrcek <smrkous@gmail.com>
 */
@Stateless(mappedName="recordBean")
public class RecordRepositoryDatabase implements RecordRepository{

    
    @PersistenceContext(unitName="javaEE7CRUD_hibernate_PU")
    EntityManager entityManager;
    
    
    @Override
    public void create(Record r) {
        entityManager.persist(r);
    }

    @Override
    public void delete(int id) {
        Record r = (Record)entityManager.find(Record.class, id);
        entityManager.remove(r);
    }   
    
    @Override
    public void updateContent(int id, String content) {
        Record r = (Record)entityManager.find(Record.class, id);
        r.setContent(content);
    }  

    @Override
    @SuppressWarnings("unchecked")
    public List<Record> getAll() {
        return entityManager.createQuery("SELECT r FROM Record r").getResultList();
    }
}
