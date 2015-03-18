/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tud.omazan.web;

/**
 *
 * @author raghu
 */
public class ExcpStructure {
    
    private long ship_id;
    private long cust_id;
    private String excp;
    private String cust_name;

    public long getShip_id() {
        return ship_id;
    }

    public void setShip_id(long ship_id) {
        this.ship_id = ship_id;
    }

    public long getCust_id() {
        return cust_id;
    }

    public void setCust_id(long cust_id) {
        this.cust_id = cust_id;
    }

    public String getExcp() {
        return excp;
    }

    public void setExcp(String excp) {
        this.excp = excp;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }
}
