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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author raghu
 */
@Entity
@Table(name = "TRUCK")
@NamedQueries({
    @NamedQuery(name = "findAllTrucks",query = "SELECT t "
    + "FROM TruckEntity t"),
    @NamedQuery(name = "findTruckByShipId",query = "SELECT t "
            + "FROM TruckEntity t WHERE t.ship_id = :ship_id")
})
@XmlRootElement
@XmlType(propOrder = {"id", "lat", "lng", "excp", "ship_id"})
public class TruckEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Truck ID
    
    @Column(name = "lat")
    private int lat;    // lattitude
    
    @Column(name = "lng")
    private int lng;    // longitude
    
    @Column(name = "excp", nullable=false)
    private String excp;    // shipment exception description
    
    @Column(name = "ship_id", nullable=false)
    private long ship_id;

    @XmlElement(name = "lat")
    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    @XmlElement(name = "long")
    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }

    @XmlElement(name = "excp")
    public String getExcp() {
        return excp;
    }

    public void setExcp(String excp) {
        this.excp = excp;
    }

    @XmlElement(name = "ship_id")
    public long getShip_id() {
        return ship_id;
    }

    public void setShip_id(long ship_id) {
        this.ship_id = ship_id;
    }

    @XmlElement(name = "truckID")
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
        if (!(object instanceof TruckEntity)) {
            return false;
        }
        TruckEntity other = (TruckEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "omazan.entities.TruckEntity[ id=" + id + " ]";
    }
    
}
