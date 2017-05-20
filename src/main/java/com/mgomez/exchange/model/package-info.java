@XmlSchema(
        namespace="http://www.ecb.int/vocabulary/2002-08-01/eurofxref",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns={
                @XmlNs(prefix="gesmes", namespaceURI="http://www.gesmes.org/xml/2002-08-01")
        }
)
package com.mgomez.exchange.model;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;