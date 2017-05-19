package com.mgomez.sample.exchange.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EuroXRefServiceIntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    public void should_retrieve_exchange_rates() {
        given()
                .basePath("/api/euroxref")
                .port(port)
        .when()
                .get()
        .then()
                .statusCode(200)
                .body("subject", equalTo("Reference rates"))
                .body("sender.name", equalTo("European Central Bank"))
                .body("cube.periods.find { it.time == '2017-05-12' }.exchangeRates.size()", equalTo(31));
    }

}
