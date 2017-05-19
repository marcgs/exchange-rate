package com.mgomez.exchange.xml;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

@Component
public class EuroXRefXmlProvider {

    public String getXml() {
        try {
            URL url = new URL("http://www.ecb.europa.eu/stats/eurofxref/eurofxref-hist-90d.xml");
            URLConnection urlConnection = url.openConnection();
            return new BufferedReader(new InputStreamReader(urlConnection.getInputStream())).lines().collect(Collectors.joining("\n"));
        } catch (Exception e) {
            throw new RuntimeException("Could not load EuroRef xml", e);
        }
    }

}
