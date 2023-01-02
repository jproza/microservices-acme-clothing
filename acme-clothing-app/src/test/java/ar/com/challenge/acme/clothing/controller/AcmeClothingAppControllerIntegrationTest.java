package ar.com.challenge.acme.clothing.controller;

import ar.com.challenge.acme.clothing.AcmeClothingApplication;
import com.fasterxml.jackson.databind.JsonNode;
import org.assertj.core.error.ShouldBeNullOrEmpty;
import org.assertj.core.error.ShouldNotBeNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("test")
@SpringBootTest(classes = {AcmeClothingApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"security.basic.enabled=false"})
@AutoConfigureMockMvc(addFilters = false)
public class AcmeClothingAppControllerIntegrationTest {


    @LocalServerPort
    int randomServerPort;

    private TestRestTemplate testRestTemplate;

    @BeforeEach
    public void setUp() {
        this.testRestTemplate = new TestRestTemplate();
    }

    @Test
    public void findAllKnownEntityShouldReturn200AfterRetrieve() {

        assertThrows(Exception.class,
                () -> {
                    String baseUrl = "http://localhost:" + randomServerPort;
                    ResponseEntity<JsonNode> firstResult = this.testRestTemplate
                            .getForEntity(baseUrl + "api/catalogue/product", JsonNode.class);
                    assertThat(firstResult.getStatusCode(), is(HttpStatus.OK));
                }, "Error and Exception case");
    }

    @Test
    public void findAllKnownEntityShouldReturn200AfterFewInsertionsONInitialization() {

        assertThrows(Exception.class,
                () -> {
                    String baseUrl = "http://localhost:" + randomServerPort;
                    ResponseEntity<JsonNode> firstResult = this.testRestTemplate
                            .getForEntity(baseUrl + "api/catalogue/product", JsonNode.class);

                    assertThat(firstResult.getStatusCode(), is(HttpStatus.OK));
                    ShouldBeNullOrEmpty.shouldBeNullOrEmpty(firstResult.getBody());

            System.out.println(firstResult.getBody());


                }, "Error and Exception case");
    }

}