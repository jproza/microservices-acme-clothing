package ar.com.challenge.acme.clothing;

import ar.com.challenge.acme.clothing.entities.Wear;
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

    Wear wear = new Wear();
    wear.setNombre("Catalogue1");
    catalogueRepository.save(wear);

    wear = new Wear();
    wear.setNombre("Catalogue2");
    catalogueRepository.save(wear);

    wear = new Wear();
    wear.setNombre("Catalogue3");
    catalogueRepository.save(wear);

    wear = new Wear();
    wear.setNombre("Catalogue4");
    catalogueRepository.save(wear);

    wear = new Wear();
    wear.setNombre("Catalogue5");
    catalogueRepository.save(wear);

    wear = new Wear();
    wear.setNombre("Catalogue6");
    catalogueRepository.save(wear);

    wear = new Wear();
    wear.setNombre("Catalogue7");
    catalogueRepository.save(wear);

    wear = new Wear();
    wear.setNombre("Catalogue9");
    catalogueRepository.save(wear);

    log.info("... finished app initialization");

  }
}
