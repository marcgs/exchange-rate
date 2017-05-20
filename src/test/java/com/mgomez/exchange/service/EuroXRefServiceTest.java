package com.mgomez.exchange.service;

import com.mgomez.exchange.date.DateFactory;
import com.mgomez.exchange.model.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class EuroXRefServiceTest {

    public static final String TODAY = "2017-4-4";
    public static final String YESTERDAY = "2017-4-3";
    public static final String SOME_OTHER_DAY = "2015-1-3";

    public static final EuroXRef TEST_DATA = new EuroXRef("subject", new Sender("sender"), new RatesPerPeriod(
            newArrayList(
                    new Period(TODAY, newArrayList(
                            new ExchangeRate("USD", "1.044"),
                            new ExchangeRate("CZK", "25.044"))
                    ),
                    new Period(YESTERDAY, newArrayList(
                            new ExchangeRate("USD", "1.040"),
                            new ExchangeRate("CZK", "26.143")))
            )
        )
    );

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private DateFactory dateFactoryMock;

    private EuroXRefService service;

    @Test
    public void should_get_exchange_rates() {
        // given

        // when
        EuroXRef euroXRef = service.getEuroXRef();

        // then
        assertThat(euroXRef).isSameAs(TEST_DATA);
    }

    @Test
    public void should_get_exchange_rates_for_given_day() {
        // given
        int daysFromToday = 1;
        Mockito.when(dateFactoryMock.daysFromToday(daysFromToday)).thenReturn(YESTERDAY);

        // when
        EuroXRef euroXRef = service.getEuroXRef(daysFromToday);

        // then
        assertThat(euroXRef.getSubject()).isEqualTo("subject");
        assertThat(euroXRef.getSender().getName()).isEqualTo("sender");
        List<Period> periods = euroXRef.getRatesPerPeriod().getPeriods();
        assertThat(periods).hasSize(1);
        Period period = periods.get(0);
        assertThat(period.getTime()).isEqualTo(YESTERDAY);
        assertThat(period.getExchangeRates().get(0)).isEqualTo(new ExchangeRate("USD", "1.040"));
        assertThat(period.getExchangeRates().get(1)).isEqualTo(new ExchangeRate("CZK", "26.143"));
    }

    @Test
    public void should_get_empty_result_for_a_non_valid_day() {
        // given
        int daysFromToday = 1000;
        Mockito.when(dateFactoryMock.daysFromToday(daysFromToday)).thenReturn(SOME_OTHER_DAY);

        // when
        EuroXRef euroXRef = service.getEuroXRef(daysFromToday);

        // then
        assertThat(euroXRef.getSubject()).isEqualTo("subject");
        assertThat(euroXRef.getSender().getName()).isEqualTo("sender");
        List<Period> periods = euroXRef.getRatesPerPeriod().getPeriods();
        assertThat(periods).hasSize(0);
    }

    @Before
    public void setUp() {
        service = new EuroXRefService(TEST_DATA, dateFactoryMock);
    }
}