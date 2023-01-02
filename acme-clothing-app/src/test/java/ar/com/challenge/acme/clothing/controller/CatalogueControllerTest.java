package ar.com.challenge.acme.clothing.controller;

import ar.com.challenge.acme.clothing.AcmeClothingApplication;
import ar.com.challenge.acme.clothing.DefaultInitializer;
import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.reqres.ProductRequest;
import ar.com.challenge.acme.clothing.services.ProductService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@ActiveProfiles("test")
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AcmeClothingApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"security.basic.enabled=false"})
@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
public class CatalogueControllerTest {

  @Autowired
  private ObjectMapper objectMapper;

  //@MockBean
  @MockBean
  private ProductService productService;

  @Autowired
  private WebTestClient webClient;

  @Autowired
  private DefaultInitializer clr;



  @Captor
  private ArgumentCaptor<ProductRequest> productRequestArgumentCaptor;


  @Before
  public void setUp() throws Exception {
    this.clr.run();
  }

  @Test
  public void postingANewProductWithoutRequestShouldtCreateANewProduct404or500() {
    this.webClient.post().uri("/api/catalogue/product").exchange().expectStatus().is5xxServerError();

  }

  @Test
  public void findingProductsShouldRetrieveAlmost2Products() {
    webClient.get()
            .uri("/api/catalogue/product")
            .exchange()
            .expectStatus().isOk()
            .expectBody(JsonNode.class)
            .consumeWith(result -> {
              System.out.println(result);
            });
  }

}