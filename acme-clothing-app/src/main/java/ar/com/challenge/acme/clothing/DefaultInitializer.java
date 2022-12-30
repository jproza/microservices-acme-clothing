package ar.com.challenge.acme.clothing;

import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.repository.CatalogueRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultInitializer implements CommandLineRunner {

  @Autowired
  private CatalogueRepository catalogueRepository;

  @Override
  public void run(String... args) throws Exception {



    log.info("Starting app initialization ...");

    Product product = new Product();
    product.setNombre("Catalogue1");
    catalogueRepository.save(product);

    product = new Product();
    product.setNombre("Catalogue2");
    catalogueRepository.save(product);

    product = new Product();
    product.setNombre("Catalogue3");
    catalogueRepository.save(product);

    product = new Product();
    product.setNombre("Catalogue4");
    catalogueRepository.save(product);

    product = new Product();
    product.setNombre("Catalogue5");
    catalogueRepository.save(product);

    product = new Product();
    product.setNombre("Catalogue6");
    catalogueRepository.save(product);

    product = new Product();
    product.setNombre("Catalogue7");
    catalogueRepository.save(product);

    product = new Product();
    product.setNombre("Catalogue9");
    catalogueRepository.save(product);

    log.info("... finished app initialization");

  }
}
