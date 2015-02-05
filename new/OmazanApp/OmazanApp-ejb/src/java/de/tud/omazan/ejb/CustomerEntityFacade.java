/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tud.omazan.ejb;

import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import omazan.entities.CustomerEntity;

/**
 *
 * @author raghu
 */
@Stateless
public class CustomerEntityFacade implements CustomerEntityFacadeRemote {
    @PersistenceContext(unitName = "OmazanApp-ejbPU")
    private EntityManager em;

    public CustomerEntityFacade() {
    }

    @Override
    public void create(CustomerEntity customerEntity) {
        em.persist(customerEntity);
    }

    @Override
    public void edit(CustomerEntity customerEntity) {
        em.merge(customerEntity);
    }

    @Override
    public void remove(CustomerEntity customerEntity) {
        em.remove(em.merge(customerEntity));
    }

    @Override
    public CustomerEntity find(Object id) {
        return em.find(CustomerEntity.class, id);
    }

    @Override
    public List<CustomerEntity> findAll() {
        try {
            return em.createNamedQuery("findAllCustomers")
                     .getResultList();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    @Override
    public List<CustomerEntity> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() {
        try {
            return em.createNamedQuery("findAllCustomers")
                      .getResultList()
                      .size();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
}
