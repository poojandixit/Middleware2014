/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tud.omazan.ejb;

import java.util.List;
import javax.ejb.Remote;
import omazan.entities.ProductEntity;

/**
 *
 * @author raghu
 */
@Remote
public interface ProductEntityFacadeRemote {

    void create(ProductEntity productEntity);

    void edit(ProductEntity productEntity);

    void remove(ProductEntity productEntity);

    ProductEntity find(Object id);

    List<ProductEntity> findAll();

    List<ProductEntity> findRange(int[] range);

    int count();
    
}
