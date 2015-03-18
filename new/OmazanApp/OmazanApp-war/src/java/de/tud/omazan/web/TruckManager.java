/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tud.omazan.web;

import de.tud.omazan.ejb.CustomerEntityFacadeRemote;
import de.tud.omazan.ejb.ShipmentEntityFacadeRemote;
import de.tud.omazan.ejb.TruckEntityFacadeRemote;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.jms.JMSException;
import omazan.entities.CustomerEntity;
import omazan.entities.ShipmentEntity;
import omazan.entities.TruckEntity;

/**
 *
 * @author raghu
 */
@ManagedBean
@RequestScoped
public class TruckManager implements Serializable {
    @EJB
    private TruckManagerBean truckManagerBean;
    @EJB
    private TruckEntityFacadeRemote truckEntityFacade;
    @EJB
    private ShipmentEntityFacadeRemote shipmentEntityFacade;
    @EJB
    private CustomerEntityFacadeRemote customerEntityFacade;
    private TruckEntity te;
    private List<TruckEntity> trucks;
    private List<ExcpStructure> excps;
    private int count;
    private Long id;
    private Long ship_id;
    private int lat;
    private int lng;
    private String excp;

    /**
     * Creates a new instance of TruckManager
     */
    public TruckManager() {
    }

    public String getExcp() {
        return excp;
    }

    public void setExcp(String excp) {
        this.excp = excp;
    }

    public TruckEntity getTe() {
        return te;
    }

    public void setTe(TruckEntity te) {
        this.te = te;
    }

    public int getCount() {
        this.count = truckEntityFacade.count();
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShip_id() {
        return ship_id;
    }

    public void setShip_id(Long ship_id) {
        this.ship_id = ship_id;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }
    
    public List<TruckEntity> getTrucks() {
        try {
            this.trucks = truckEntityFacade.findAll();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return trucks;
    }

    public void setTrucks(List<TruckEntity> trucks) {
        this.trucks = trucks;
    }
    
    public void assignToTruck(TruckEntity truckEntity) {
        try {
            this.te = truckEntity;
            truckEntityFacade.create(this.te);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Manually emitting positions for a given truck id
     * @throws javax.jms.JMSException
     */
    public void emitPosition() throws JMSException {
        TruckEntity ten = findEntity(this.id);
        ten.setLat(randomInt(50, 5000));
        ten.setLng(randomInt(50, 5000));
        truckManagerBean.sendJMSMessageToPositionMessage(ten);
    }
    
    /**
     * Manually emitting delivery status
     * @throws javax.jms.JMSException
     */
    public void emitDeliveryEvent() throws JMSException {
        TruckEntity ten = findEntity(this.id);
        truckManagerBean.sendJMSMessageToShipmentMessage(ten);
    }
    
    /**
     * Employee updates the exceptional status
     * @throws JMSException 
     */
    public void emitExceptionalStatus() throws JMSException {
        TruckEntity ten = findEntity(this.id);
        ten.setExcp(this.excp);
        truckManagerBean.sendJMSMessageToExceptionalMessage(ten);
    }

    public List<ExcpStructure> getExcps() {
        List<ShipmentEntity> se_list = shipmentEntityFacade.findAll();
        excps = new ArrayList<ExcpStructure>();
        CustomerEntity ce;
        ExcpStructure es;
        for (ShipmentEntity se_list1 : se_list) {
            List<TruckEntity> te_list = truckEntityFacade.findTruckByShipId(se_list1.getId());
            if(!te_list.isEmpty()) {
                ce = customerEntityFacade.find(se_list1.getCustid());
                es = new ExcpStructure();
                es.setCust_id(ce.getId());
                es.setCust_name(ce.getName());
                es.setShip_id(se_list1.getId());
                es.setExcp(te_list.get(0).getExcp());
                excps.add(es);
            }
        }
        if(excps.isEmpty()) {
            return null;
        }
        return excps;
    }

    public void setExcps(List<ExcpStructure> excps) {
        this.excps = excps;
    }
    
    public TruckEntity findEntity(long i_d) {
        return truckEntityFacade.find(i_d);
    }
    
    public static int randomInt(int min, int max) {
     return (int) (Math.random()*(max-min))+min;
    }
    
    public int truckItemCount() {
        this.count = truckEntityFacade.count();
        return this.count;
    }
    
    public List<TruckEntity> allTruckItems() {
        try {
            trucks = new ArrayList<>();
            this.trucks = truckEntityFacade.findAll();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return trucks;
    }
    
}
