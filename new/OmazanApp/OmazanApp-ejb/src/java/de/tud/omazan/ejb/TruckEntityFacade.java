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
import javax.persistence.Query;
import omazan.entities.TruckEntity;

/**
 *
 * @author raghu
 */
@Stateless
public class TruckEntityFacade implements TruckEntityFacadeRemote {
    @PersistenceContext(unitName = "OmazanApp-ejbPU")
    private EntityManager em;

    public TruckEntityFacade() {
    }

    @Override
    public void create(TruckEntity truckEntity) {
        em.persist(truckEntity);
    }

    @Override
    public void edit(TruckEntity truckEntity) {
        em.merge(truckEntity);
    }

    @Override
    public void remove(TruckEntity truckEntity) {
        em.remove(em.merge(truckEntity));
    }

    @Override
    public TruckEntity find(Object id) {
        return em.find(TruckEntity.class, id);
    }

    @Override
    public List<TruckEntity> findAll() {
        try {
            return em.createNamedQuery("findAllTrucks")
                     .getResultList();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    @Override
    public List<TruckEntity> findTruckByShipId(long shid) {
        try {
            Query query = em.createNamedQuery("findTruckByShipId");
            query.setParameter("ship_id", shid);
            return query.getResultList();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    @Override
    public List<TruckEntity> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() {
        try {
            return em.createNamedQuery("findAllTrucks")
                      .getResultList()
                      .size();
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
}
