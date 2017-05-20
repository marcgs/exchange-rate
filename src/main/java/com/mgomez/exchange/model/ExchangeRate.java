package com.mgomez.exchange.model;

import com.google.common.base.MoreObjects;

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
        return Objects.equals(currency, that.currency) && Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, rate);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("currency", currency)
                .add("rate", rate)
                .toString();
    }
}
