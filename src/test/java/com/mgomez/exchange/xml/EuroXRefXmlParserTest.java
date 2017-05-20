package com.mgomez.exchange.xml;

import com.mgomez.exchange.model.EuroXRef;
import com.mgomez.exchange.model.Period;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static com.mgomez.exchange.util.FileStringReader.readFile;
import static org.assertj.core.api.Assertions.assertThat;

public class EuroXRefXmlParserTest {

    private EuroXRefXmlParser parser = new EuroXRefXmlParser();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_parse_ECB_xml_correctly() throws Exception {
        // given
        String content = readFile("eurofxref-hist-90d.xml");

        // when
        EuroXRef euroXRef = parser.parseXml(content);

        // then
        assertThat(euroXRef).isNotNull();
        List<Period> periods = euroXRef.getRatesPerPeriod().getPeriods();
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
        EuroXRef euroXRef = parser.parseXml(content);

        // then
        // exception expected
    }

}
