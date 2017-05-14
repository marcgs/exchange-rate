package com.mgomez.sample.exchange.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class ExchangeRate {

    @XmlAttribute
    private String currency;

    @XmlAttribute
    private String rate;

    public String getCurrency() {
        return currency;
    }

    public String getRate() {
        return rate;
    }

}
