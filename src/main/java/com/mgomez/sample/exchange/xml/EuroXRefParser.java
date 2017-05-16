package com.mgomez.sample.exchange.xml;

import com.mgomez.sample.exchange.model.Envelope;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Component
public class EuroXRefParser {

    public Envelope parseXml(String xml) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Envelope) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            throw new RuntimeException("Could not parse EuroXRef xml file", e);
        }
    }

}