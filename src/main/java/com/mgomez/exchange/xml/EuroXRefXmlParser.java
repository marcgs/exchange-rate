package com.mgomez.exchange.xml;

import com.mgomez.exchange.model.EuroXRef;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Component
public class EuroXRefXmlParser {

    public EuroXRef parseXml(String xml) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EuroXRef.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (EuroXRef) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            throw new RuntimeException("Could not parse EuroXRef xml file", e);
        }
    }

}
