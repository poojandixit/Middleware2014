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
import omazan.entities.ShipmentEntity;

/**
 *
 * @author raghu
 */
@Stateless
public class ShipmentEntityFacade implements ShipmentEntityFacadeRemote {
    @PersistenceContext(unitName = "OmazanApp-ejbPU")
    private EntityManager em;

    public ShipmentEntityFacade() {
    }

    @Override
    public void create(ShipmentEntity shipmentEntity) {
        em.persist(shipmentEntity);
    }

    @Override
    public void edit(ShipmentEntity shipmentEntity) {
        em.merge(shipmentEntity);
    }

    @Override
    public void remove(ShipmentEntity shipmentEntity) {
        em.remove(em.merge(shipmentEntity));
    }

    @Override
    public ShipmentEntity find(Object id) {
        return em.find(ShipmentEntity.class, id);
    }

    @Override
    public List<ShipmentEntity> findAll() {
        try {
            return em.createNamedQuery("findAllShipments")
                     .getResultList();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    @Override
    public List<ShipmentEntity> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() {
        try {
            return em.createNamedQuery("findAllShipments")
                      .getResultList()
                      .size();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
}
