/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tud.omazan.web;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import omazan.entities.TruckEntity;

/**
 *
 * @author raghu
 */
@Singleton
@LocalBean
public class TruckManagerBean implements Serializable {
    @Resource(mappedName = "jms/ExceptionalMessage")
    private Queue exceptionalMessage;
    @Resource(mappedName = "jms/ExceptionalMessageFactory")
    private ConnectionFactory exceptionalMessageFactory;
    @Resource(mappedName = "jms/ShipmentMessage")
    private Queue shipmentMessage;
    @Resource(mappedName = "jms/ShipmentMessageFactory")
    private ConnectionFactory shipmentMessageFactory;
    @Resource(mappedName = "jms/PositionMessage")
    private Queue positionMessage;
    @Resource(mappedName = "jms/PositionMessageFactory")
    private ConnectionFactory positionMessageFactory;

    private Message createJMSMessageForjmsPositionMessage(Session session, TruckEntity messageData) throws JMSException {
        StringWriter sw = new StringWriter();
        try {
            /**
             * Convert into xml
             */
            JAXBContext context = JAXBContext.newInstance(TruckEntity.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(messageData, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        /**
         * Pack the xml string into TextMessage
         */
        TextMessage tm = session.createTextMessage();
        String temp = sw.toString();
        tm.setText(temp);
        return tm;
    }

    public void sendJMSMessageToPositionMessage(TruckEntity messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            /**
             * Send the message to PositionMessage for updating truck position 
             */
            connection = positionMessageFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(positionMessage);
            messageProducer.send(createJMSMessageForjmsPositionMessage(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    private Message createJMSMessageForjmsShipmentMessage(Session session, TruckEntity messageData) throws JMSException {
        StringWriter sw = new StringWriter();
        try {
            /**
             * Convert into xml
             */
            JAXBContext context = JAXBContext.newInstance(TruckEntity.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(messageData, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        /**
         * Pack the xml string into TextMessage
         */
        TextMessage tm = session.createTextMessage();
        String temp = sw.toString();
        tm.setText(temp);
        return tm;
    }

    /**
     *
     * @param messageData
     * @throws JMSException
     */
    public void sendJMSMessageToShipmentMessage(TruckEntity messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = shipmentMessageFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(shipmentMessage);
            messageProducer.send(createJMSMessageForjmsShipmentMessage(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    private Message createJMSMessageForjmsExceptionalMessage(Session session, TruckEntity messageData) throws JMSException {
        StringWriter sw = new StringWriter();
        try {
            /**
             * Convert into xml
             */
            JAXBContext context = JAXBContext.newInstance(TruckEntity.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(messageData, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        /**
         * Pack the xml string into TextMessage
         */
        TextMessage tm = session.createTextMessage();
        String temp = sw.toString();
        tm.setText(temp);
        return tm;
    }

    public void sendJMSMessageToExceptionalMessage(TruckEntity messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = exceptionalMessageFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(exceptionalMessage);
            messageProducer.send(createJMSMessageForjmsExceptionalMessage(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
