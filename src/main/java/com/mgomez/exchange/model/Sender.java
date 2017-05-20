package com.mgomez.exchange.model;

import javax.xml.bind.annotation.XmlElement;

public class Sender {

    @XmlElement(namespace = "http://www.gesmes.org/xml/2002-08-01")
    private String name;

    public String getName() {
        return name;
    }
}
