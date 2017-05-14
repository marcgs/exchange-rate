package com.mgomez.sample.exchange.service;

import com.mgomez.sample.exchange.model.Envelope;
import com.mgomez.sample.exchange.xml.EuroXRefParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

@Service
public class EuroXRefService {

    @Autowired
    private EuroXRefParser parser;
    private Envelope envelope;

    public Envelope getEnvelope() {
        return envelope;
    }

    @Scheduled(fixedDelay = 60000)
    public void updateECBData() throws Exception {
        URL url = new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-hist-90d.xml");
        URLConnection urlConnection = url.openConnection();
        String xmlData = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))
                .lines().collect(Collectors.joining("\n"));
        this.envelope = parser.parseXml(xmlData);
    }

}
