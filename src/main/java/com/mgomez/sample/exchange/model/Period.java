package com.mgomez.sample.exchange.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Period {

    @XmlElement(name="Cube")
    private List<ExchangeRate> exchangeRates;

    @XmlAttribute
    private String time;

    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    public String getTime() {
        return time;
    }
}
