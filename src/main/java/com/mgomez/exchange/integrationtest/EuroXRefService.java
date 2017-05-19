package com.mgomez.exchange.integrationtest;

import com.mgomez.exchange.xml.EuroXRefXmlProvider;
import com.mgomez.exchange.model.Envelope;
import com.mgomez.exchange.xml.EuroXRefXmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EuroXRefService {

    @Autowired
    private EuroXRefXmlParser parser;
    @Autowired
    private EuroXRefXmlProvider xmlProvider;

    private Envelope envelope;

    public Envelope getEnvelope() {
        return envelope;
    }

    @Scheduled(fixedDelay = 60000)
    public void updateData() throws Exception {
        String xmlData = xmlProvider.getXml();
        this.envelope = parser.parseXml(xmlData);
    }

}
