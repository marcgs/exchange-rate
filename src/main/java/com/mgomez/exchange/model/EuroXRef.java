package com.mgomez.exchange.model;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "Envelope", namespace ="http://www.gesmes.org/xml/2002-08-01")
public class EuroXRef {

    @XmlElement(namespace = "http://www.gesmes.org/xml/2002-08-01")
    private String subject;

    @XmlElement(name = "Sender", namespace = "http://www.gesmes.org/xml/2002-08-01")
    private Sender sender;

    @XmlElement(name = "Cube")
    private RatesPerPeriod ratesPerPeriod;


    public Sender getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public RatesPerPeriod getRatesPerPeriod() {
        return ratesPerPeriod;
    }
}
