/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tud.omazan.web;

import de.tud.omazan.ejb.ShipmentEntityFacadeRemote;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import omazan.entities.ShipmentEntity;

/**
 *
 * @author raghu
 */
@ManagedBean
@RequestScoped
public class ShipmentManager implements Serializable {
    @EJB
    private ShipmentEntityFacadeRemote shipmentEntityFacade;
    private ShipmentEntity se;
    private List<ShipmentEntity> shipments;
    private String shipment_status;
    private Long id;
    private Long prodid;
    private Long custid;
    private int count;

    public Long getProdid() {
        return prodid;
    }

    public void setProdid(Long prodid) {
        this.prodid = prodid;
    }

    public Long getCustid() {
        return custid;
    }

    public void setCustid(Long custid) {
        this.custid = custid;
    }

    public ShipmentEntity getSe() {
        return se;
    }

    public void setSe(ShipmentEntity se) {
        this.se = se;
    }

    public List<ShipmentEntity> getShipments() {
        return shipments;
    }

    public void setShipments(List<ShipmentEntity> shipments) {
        this.shipments = shipments;
    }

    public String getShipment_status() {
        return shipment_status;
    }

    public void setShipment_status(String shipment_status) {
        this.shipment_status = shipment_status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    /**
     * Creates a new instance of ShipmentManager
     */
    public ShipmentManager() {
    }
    
    public void purchaseItem() {
        try {
            se = new ShipmentEntity();
            se.setProdid(this.prodid);
            se.setCustid(this.custid);
            se.setShipstatus("packing");
            shipmentEntityFacade.create(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editShipmentStatus() {
        try {
            se = new ShipmentEntity();
            se.setId(this.id);
            se.setShipstatus(this.shipment_status);
            shipmentEntityFacade.edit(se);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public int shipItemCount() {
        this.count = shipmentEntityFacade.count();
        return this.count;
    }
    
    public List<ShipmentEntity> allShipmentItems() {
        try {
            shipments = new ArrayList<>();
            this.shipments = shipmentEntityFacade.findAll();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return shipments;
    }
    
}
