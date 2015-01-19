/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tud.omazan.ejb;

import de.tud.omazan.ejb.CustomerEntity;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author raghu
 */
@Remote
public interface CustomerEntityFacadeLocal {

    void create(CustomerEntity customerEntity);

    void edit(CustomerEntity customerEntity);

    void remove(CustomerEntity customerEntity);

    CustomerEntity find(Object id);

    List<CustomerEntity> findAll();

    List<CustomerEntity> findRange(int[] range);

    int count();
    
}
