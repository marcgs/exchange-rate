package com.mgomez.exchange.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Period {

    @XmlElement(name="Cube")
    private List<ExchangeRate> exchangeRates;

    @XmlAttribute
    private String time;

    public Period() {
    }

    public Period(String time, List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
        this.time = time;
    }

    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    public String getTime() {
        return time;
    }
}
