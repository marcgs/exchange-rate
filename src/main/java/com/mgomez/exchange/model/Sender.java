package com.mgomez.exchange.model;

import javax.xml.bind.annotation.XmlElement;

public class Sender {

    @XmlElement
    private String name;

    public String getName() {
        return name;
    }
}
