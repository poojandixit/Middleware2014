/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tud.omazan.ejb;

import java.util.List;
import javax.ejb.Remote;
import omazan.entities.CustomerEntity;

/**
 *
 * @author raghu
 */
@Remote
public interface CustomerEntityFacadeRemote {

    void create(CustomerEntity customerEntity);

    void edit(CustomerEntity customerEntity);

    void remove(CustomerEntity customerEntity);

    CustomerEntity find(Object id);

    List<CustomerEntity> findAll();

    List<CustomerEntity> findRange(int[] range);

    int count();
    
}
