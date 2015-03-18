/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tud.omazan.msgdrivenjms;

import java.io.StringReader;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import omazan.entities.TruckEntity;

/**
 *
 * @author raghu
 */
@MessageDriven(mappedName = "jms/ExceptionalMessage", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ExceptionalMessage implements MessageListener {
    @Resource
    private MessageDrivenContext mdc;
    @PersistenceContext(unitName = "OmazanApp-ejbPU")
    private EntityManager em;
    
    public ExceptionalMessage() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage txtmsg = (TextMessage) message;
        try {
            if (message instanceof TextMessage) {
                String msgText = txtmsg.getText();
                TruckEntity truckEntity = jaxbXMLToObject(msgText);
                save(truckEntity);            
            }
    } catch (JMSException e) {
        e.printStackTrace();
        mdc.setRollbackOnly();
    } catch (Throwable te) {
        te.printStackTrace();
    }
    }

    public void save(TruckEntity truckEntity) {
        em.merge(truckEntity);
    }
    
    private TruckEntity jaxbXMLToObject(String message) {
        try {
            JAXBContext context = JAXBContext.newInstance(TruckEntity.class);
            Unmarshaller un = context.createUnmarshaller();
            StringReader reader = new StringReader(message);
            TruckEntity te = (TruckEntity) un.unmarshal(reader);
            return te;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
