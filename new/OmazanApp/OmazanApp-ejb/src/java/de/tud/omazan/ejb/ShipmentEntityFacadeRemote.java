/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tud.omazan.ejb;

import java.util.List;
import javax.ejb.Remote;
import omazan.entities.ShipmentEntity;

/**
 *
 * @author raghu
 */
@Remote
public interface ShipmentEntityFacadeRemote {

    void create(ShipmentEntity shipmentEntity);

    void edit(ShipmentEntity shipmentEntity);

    void remove(ShipmentEntity shipmentEntity);

    ShipmentEntity find(Object id);

    List<ShipmentEntity> findAll();

    List<ShipmentEntity> findRange(int[] range);

    int count();
    
}
