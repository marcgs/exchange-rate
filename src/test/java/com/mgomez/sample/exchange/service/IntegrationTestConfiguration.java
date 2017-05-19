package com.mgomez.sample.exchange.service;

import com.mgomez.sample.exchange.xml.EuroXRefXmlProvider;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import static com.mgomez.sample.exchange.util.FileStringReader.readFile;

@Profile("test")
@Configuration
public class IntegrationTestConfiguration {

    @Bean
    @Primary
    public EuroXRefXmlProvider xmlProvider() {
        EuroXRefXmlProvider mock = Mockito.mock(EuroXRefXmlProvider.class);
        Mockito.when(mock.getXml()).thenReturn(readFile("eurofxref-hist-90d.xml"));
        return mock;

    }

}
