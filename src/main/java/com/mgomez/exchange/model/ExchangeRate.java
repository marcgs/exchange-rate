package com.mgomez.exchange.model;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

public class ExchangeRate {

    @XmlAttribute
    private String currency;

    @XmlAttribute
    private String rate;

    public ExchangeRate() {
    }

    public ExchangeRate(String currency, String rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public String getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExchangeRate that = (ExchangeRate) o;
        return Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, rate);
    }
}
