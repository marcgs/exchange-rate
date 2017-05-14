package com.mgomez.sample.exchange.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Cube {

    @XmlElement(name="Cube")
    private List<Cube> cubes;

    @XmlAttribute
    private String time;

    @XmlAttribute
    private String currency;

    @XmlAttribute
    private String rate;


    public List<Cube> getCubes() {
        return cubes;
    }

    public String getCurrency() {
        return currency;
    }

    public String getRate() {
        return rate;
    }

    public String getTime() {
        return time;
    }
}
