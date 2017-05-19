package com.mgomez.exchange.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Envelope", namespace ="http://www.gesmes.org/xml/2002-08-01")
public class Envelope {

    @XmlElement
    private String subject;

    @XmlElement(name = "Sender")
    private Sender sender;

    @XmlElement(name = "Cube")
    private Container cube;


    public Sender getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public Container getCube() {
        return cube;
    }
}
