/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tud.omazan.web;

import de.tud.omazan.ejb.CustomerEntity;
import de.tud.omazan.ejb.CustomerEntityFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author raghu
 */
@ManagedBean
@RequestScoped
public class CustomerManager {
    @EJB
    private CustomerEntityFacadeLocal customerEntityFacade;
    private CustomerEntity ce;
    private List<CustomerEntity> customers;
    private String name;
    private Long id;
    private int count;

    public CustomerEntity getCe() {
        return ce;
    }

    public void setCe(CustomerEntity ce) {
        this.ce = ce;
    }

    public int getCount() {
        this.count = customerEntityFacade.count();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Creates a new instance of CustomerManager
     */
    public CustomerManager() {
    }
    
    public List<CustomerEntity> getCustomers() {
        try {
    //        customers = new ArrayList<CustomerEntity>();
            this.customers = customerEntityFacade.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void setCustomers(List<CustomerEntity> customers) {
        this.customers = customers;
    }
    
    public CustomerEntity createCustomer() {
        try {
            ce = new CustomerEntity();
            ce.setName(this.name);
            customerEntityFacade.create(ce);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ce;
    }
    
    public void removeCustomer() {
        try {
            ce = new CustomerEntity();
            ce.setId(this.id);
            customerEntityFacade.remove(ce);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editCustomer() {
        try {
            ce = new CustomerEntity();
            ce.setId(this.id);
            ce.setName(this.name);
            customerEntityFacade.edit(ce);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int customerCount() {
        this.count = customerEntityFacade.count();
        return this.count;
    }
    
    public List<CustomerEntity> allCustomers() {
        try {
            customers = new ArrayList<>();
            this.customers = customerEntityFacade.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
    
}
