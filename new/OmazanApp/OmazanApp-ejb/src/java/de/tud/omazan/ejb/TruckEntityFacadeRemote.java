/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tud.omazan.ejb;

import java.util.List;
import javax.ejb.Remote;
import omazan.entities.TruckEntity;

/**
 *
 * @author raghu
 */
@Remote
public interface TruckEntityFacadeRemote {

    void create(TruckEntity truckEntity);

    void edit(TruckEntity truckEntity);

    void remove(TruckEntity truckEntity);

    TruckEntity find(Object id);

    List<TruckEntity> findAll();
    
    List<TruckEntity> findTruckByShipId(long shid);

    List<TruckEntity> findRange(int[] range);

    int count();
    
}
