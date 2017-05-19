package com.mgomez.exchange.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Container {

    @XmlElement(name="Cube")
    private List<Period> periods;

    public List<Period> getPeriods() {
        return periods;
    }

}
