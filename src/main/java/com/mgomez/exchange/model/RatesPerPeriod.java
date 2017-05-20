package com.mgomez.exchange.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class RatesPerPeriod {

    @XmlElement(name="Cube")
    private List<Period> periods;

    public RatesPerPeriod() {
    }

    public RatesPerPeriod(List<Period> periods) {
        this.periods = periods;
    }

    public List<Period> getPeriods() {
        return periods;
    }

}
