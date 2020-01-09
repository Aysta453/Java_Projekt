/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.List;

public abstract class DAO<T, Id extends Serializable> extends HibernateUtil {
   
    public void save(T entity) {
        openCurrentSessionwithTransaction();
        getCurrentSession().save(entity);
        closeCurrentSessionWithTransaction();
    }
    
    public void update(T entity) {
        openCurrentSessionwithTransaction();
        getCurrentSession().update(entity);
        closeCurrentSessionWithTransaction();
    }
      
    public abstract T findById(Id id);
      
    public abstract List<T> findAll();
    
    
    public void delete(T entity) {
        openCurrentSessionwithTransaction();
        getCurrentSession().delete(entity);
        closeCurrentSessionWithTransaction();
    }

    public void deleteAll() {      
        List<T> entityList = findAll();
        for (T entity : entityList) {
            delete(entity);
        }
    }
}
