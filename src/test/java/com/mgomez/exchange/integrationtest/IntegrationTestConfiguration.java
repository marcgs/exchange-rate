package com.mgomez.exchange.integrationtest;

import com.mgomez.exchange.date.DateFactory;
import com.mgomez.exchange.xml.EuroXRefXmlProvider;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

import static com.mgomez.exchange.util.FileStringReader.readFile;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@Profile("test")
@Configuration
public class IntegrationTestConfiguration {

    public static final LocalDate MOCKED_CURRENT_DATE = LocalDate.parse("2017-05-12", ISO_LOCAL_DATE);

    @Bean
    @Primary
    public EuroXRefXmlProvider xmlProvider() {
        EuroXRefXmlProvider mock = Mockito.mock(EuroXRefXmlProvider.class);
        when(mock.getXml()).thenReturn(readFile("eurofxref-hist-90d.xml"));
        return mock;
    }

    @Bean
    @Primary
    public DateFactory dateFactory() {
        DateFactory mock = Mockito.mock(DateFactory.class);
        when(mock.daysFromToday(anyLong())).thenAnswer(invocation -> MOCKED_CURRENT_DATE.minusDays(invocation.getArgument(0)).format(ISO_LOCAL_DATE));
        return mock;
    }

}
