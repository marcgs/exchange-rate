package com.mgomez.sample.exchange.service;

import com.mgomez.sample.exchange.model.Envelope;
import com.mgomez.sample.exchange.xml.EuroXRefParser;
import com.mgomez.sample.exchange.xml.EuroXRefXmlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EuroXRefService {

    @Autowired
    private EuroXRefParser parser;
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
