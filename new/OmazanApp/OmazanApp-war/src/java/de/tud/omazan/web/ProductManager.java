/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tud.omazan.web;

import de.tud.omazan.ejb.ProductEntityFacadeRemote;
import omazan.entities.ProductEntity;
import java.io.Serializable;
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
public class ProductManager implements Serializable {
    @EJB
    private ProductEntityFacadeRemote productEntityFacade;
    private ProductEntity pe;
    private List<ProductEntity> products;
    private String name;
    private Long id;
    private int count;

    public ProductEntity getPe() {
        return pe;
    }

    public void setPe(ProductEntity pe) {
        this.pe = pe;
    }

    public int getCount() {
        this.count = productEntityFacade.count();
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
    
    public List<ProductEntity> getProducts() {
        try {
    //        products = new ArrayList<ProductEntity>();
            this.products = productEntityFacade.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    /**
     * Creates a new instance of ProductManager
     */
    public ProductManager() {
    }
    
    public void submitItem() {
        try {
            pe = new ProductEntity();
            pe.setName(this.name);
            productEntityFacade.create(pe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void removeItem() {
        try {
            pe = new ProductEntity();
            pe.setId(this.id);
            productEntityFacade.remove(pe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editItem() {
        try {
            pe = new ProductEntity();
            pe.setId(this.id);
            pe.setName(this.name);
            productEntityFacade.edit(pe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int itemCount() {
        this.count = productEntityFacade.count();
        return this.count;
    }
    
    public List<ProductEntity> allProductItems() {
        try {
            products = new ArrayList<>();
            this.products = productEntityFacade.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    
}
