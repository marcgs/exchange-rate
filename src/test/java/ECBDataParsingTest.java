import com.mgomez.sample.exchange.model.Envelope;
import com.mgomez.sample.exchange.model.Period;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.ClassLoader.getSystemResource;
import static org.assertj.core.api.Assertions.assertThat;

public class ECBDataParsingTest {

    @Test
    public void should_parse_ECB_xml_correctly() throws Exception {
        URI fileUri = getSystemResource("eurofxref-hist-90d.xml").toURI();
        String content = new String(Files.readAllBytes(Paths.get(fileUri)));

        JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(content);
        Envelope envelope = (Envelope) unmarshaller.unmarshal(reader);

        assertThat(envelope).isNotNull();
        List<Period> periods = envelope.getCube().getPeriods();
        assertThat(periods).hasSize(62);
        periods.forEach(period -> assertThat(period.getExchangeRates()).describedAs("Period " + period.getTime()).hasSize(31));
    }

}
