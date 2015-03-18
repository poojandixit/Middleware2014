/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omazan.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author raghu
 */
@Entity
@Table(name = "SHIPMENT")
@NamedQueries({
    @NamedQuery(name = "findAllShipments",query = "SELECT s "
    + "FROM ShipmentEntity s"),
    @NamedQuery(name = "findAllShipmentsForGivenCust",query = "SELECT s "
            + "FROM ShipmentEntity s WHERE s.custid = :custid")
})
public class ShipmentEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "custid", nullable=false)
    private Long custid;
    
    @Column(name = "prodid", nullable=false)
    private Long prodid;
    
    @Column(name = "shipstatus")
    private String shipstatus;

    public Long getCustid() {
        return custid;
    }

    public void setCustid(Long custid) {
        this.custid = custid;
    }

    public Long getProdid() {
        return prodid;
    }

    public void setProdid(Long prodid) {
        this.prodid = prodid;
    }

    public String getShipstatus() {
        return shipstatus;
    }

    public void setShipstatus(String shipstatus) {
        this.shipstatus = shipstatus;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShipmentEntity)) {
            return false;
        }
        ShipmentEntity other = (ShipmentEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "omazan.entities.Shipment[ id=" + id + " ]";
    }
    
}
