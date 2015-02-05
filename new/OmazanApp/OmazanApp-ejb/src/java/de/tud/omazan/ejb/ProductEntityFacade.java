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
import omazan.entities.ProductEntity;

/**
 *
 * @author raghu
 */
@Stateless
public class ProductEntityFacade implements ProductEntityFacadeRemote {
    @PersistenceContext(unitName = "OmazanApp-ejbPU")
    private EntityManager em;

    public ProductEntityFacade() {
    }

    @Override
    public void create(ProductEntity productEntity) {
        em.persist(productEntity);
    }

    @Override
    public void edit(ProductEntity productEntity) {
        em.merge(productEntity);
    }

    @Override
    public void remove(ProductEntity productEntity) {
        em.remove(em.merge(productEntity));
    }

    @Override
    public ProductEntity find(Object id) {
        return em.find(ProductEntity.class, id);
    }

    @Override
    public List<ProductEntity> findAll() {
        try {
            return em.createNamedQuery("findAllProductItems")
                     .getResultList();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    @Override
    public List<ProductEntity> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() {
        try {
            return em.createNamedQuery("findAllProductItems")
                      .getResultList()
                      .size();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
}
