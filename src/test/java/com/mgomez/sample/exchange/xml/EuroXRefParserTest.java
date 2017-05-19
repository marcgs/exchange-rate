package com.mgomez.sample.exchange.xml;

import com.mgomez.sample.exchange.model.Envelope;
import com.mgomez.sample.exchange.model.Period;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static com.mgomez.sample.exchange.util.FileStringReader.readFile;
import static org.assertj.core.api.Assertions.assertThat;

public class EuroXRefParserTest {

    private EuroXRefParser parser = new EuroXRefParser();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_parse_ECB_xml_correctly() throws Exception {
        // given
        String content = readFile("eurofxref-hist-90d.xml");

        // when
        Envelope envelope = parser.parseXml(content);

        // then
        assertThat(envelope).isNotNull();
        List<Period> periods = envelope.getCube().getPeriods();
        assertThat(periods).hasSize(62);
        periods.forEach(period -> assertThat(period.getExchangeRates()).describedAs("Period " + period.getTime()).hasSize(31));
    }

    @Test
    public void should_throw_exception_if_incorrect_xml() throws Exception {
        // given
        String content = readFile("eurofxref-hist-90d-kaputt.xml");
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Could not parse EuroXRef xml file");

        // when
        Envelope envelope = parser.parseXml(content);

        // then
        // exception expected
    }

}
