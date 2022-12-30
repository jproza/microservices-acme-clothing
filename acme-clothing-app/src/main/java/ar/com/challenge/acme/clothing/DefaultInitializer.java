package ar.com.challenge.acme.clothing;

import ar.com.challenge.acme.clothing.entities.Family;
import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.repository.FamilyRepository;
import ar.com.challenge.acme.clothing.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultInitializer implements CommandLineRunner {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private FamilyRepository familyRepository;

  @Override
  public void run(String... args) throws Exception {

    log.info("Starting app initialization ...");

    familyRepository.deleteAll();
    productRepository.deleteAll();

    Product product = new Product();
    product.setNombre("Product1");
    product.setReferencia(product.getReferencia());
    product.setId(new ObjectId());

    Family f = new Family();
    f.setName("Familia1");
    f.setId(new ObjectId());
    Family fsaved = familyRepository.save(f);
    product.setFamiliaProduto(fsaved);
    productRepository.save(product);

    product = new Product();
    product.setId(new ObjectId());
    product.setNombre("Product2");
    f = new Family();
    f.setId(new ObjectId());
    f.setName("Familia22");
    product.setReferencia(product.getReferencia());
    fsaved = familyRepository.save(f);
    product.setFamiliaProduto(fsaved);
    productRepository.save(product);


    log.info("... finished app initialization");

  }
}
