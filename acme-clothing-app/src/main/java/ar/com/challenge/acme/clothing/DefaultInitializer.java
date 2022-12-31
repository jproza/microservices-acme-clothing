package ar.com.challenge.acme.clothing;

import ar.com.challenge.acme.clothing.entities.Family;
import ar.com.challenge.acme.clothing.entities.Media;
import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.entities.Slogan;
import ar.com.challenge.acme.clothing.repository.FamilyRepository;
import ar.com.challenge.acme.clothing.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    product.setNombre("Stanley Classic");
    product.setReferencia(product.getReferencia());
    product.setId(new ObjectId());
    product.setDescripcion("Our Stanley Classic Vacuum Bottle is made with superior insulation that keeps liquids " +
            "(soup, coffee, tea) hot or cold drinks cool for up to 24 hours. It’s also made with BPA-free materials, keeping its contents safe to consume");
    product.setPrecioBase(11.110);


    Family f = new Family();
    f.setName("Mas Vendidos");
    f.setId(new ObjectId());
    Family fsaved = familyRepository.save(f);
    product.setFamiliaProduto(fsaved);

    List<Slogan> lstSlo = new ArrayList<>();

    Slogan slo1 = new Slogan();
    slo1.setId(new ObjectId());
    slo1.setAlternateText("Continua Comprando");
    slo1.setText("Productos mayores a U$S 1000 no están permitidos por la aduana");
    slo1.setFamilia(product.getFamiliaProduto());
    slo1.setIdentificador(slo1.getIdentificador());
    lstSlo.add(slo1);


    slo1 = new Slogan();
    slo1.setId(new ObjectId());
    slo1.setAlternateText("Continua Comprando mas ");
    slo1.setText("Productos MENORES a U$S 10 pagan igualmente tarifa.");
    slo1.setFamilia(product.getFamiliaProduto());
    slo1.setIdentificador(slo1.getIdentificador());
    lstSlo.add(slo1);

    product.setLstSlogan(lstSlo);


    productRepository.save(product);

    product = new Product();
    product.setId(new ObjectId());
    product.setNombre("Apple iPhone 14");
    product.setReferencia(product.getReferencia());
    product.setFamiliaProduto(fsaved);
    product.setDescripcion("El iPhone 8 es el primer smartphone de Apple fabricado exclusivamente con vidrio duradero en la " +
            "parte delantera y trasera, diseñado para soportar salpicaduras de polvo y agua. Funciona con el procesador «Apple A11 Bionic» de 64 bits y tiene dos almacenamientos internos disponibles: 64 GB o 256 GB de almacenamiento flash. Cuenta con una pantalla IPS multitáctil panorámica de 4,7 pulgadas («Retina HD») y " +
            "cámaras duales: una cámara trasera 4K de 12 megapíxeles con estabilización óptica de imagen y una " +
            "cámara frontal «FaceTime HD» de 7 megapíxeles compatible con vídeo de 1080p.");
    product.setPrecioBase(51.20);
    productRepository.save(product);

    product = new Product();
    product.setId(new ObjectId());
    product.setNombre("Tommy Hilfiger  - Watch");
    product.setDescripcion("Relojes Tommy Hilfiger — Clásicos, Americanos, Geniales");
    product.setPrecioBase(50.5);
    f = new Family();
    f.setId(new ObjectId());
    f.setName("Oferta de la Semana");
    product.setReferencia(product.getReferencia());
    fsaved = familyRepository.save(f);
    product.setFamiliaProduto(fsaved);



    Media media1 = new Media().builder().id(new ObjectId()).path("/path/img").priorite(1).size(200).build();
    media1.setIdentificador(media1.getIdentificador());

    Media media2 = new Media().builder().id(new ObjectId()).path("/path/img/alternative").priorite(3).size(80).build();
    media2.setIdentificador(new Media().getIdentificador());

    List<Media> lstMedias = new ArrayList<>();
    lstMedias.add(media1);
    lstMedias.add(media2);
    product.setListMedia(lstMedias);
    productRepository.save(product);


    product = new Product();
    product.setId(new ObjectId());
    product.setNombre("Apple MacBook Air 2020: chip Apple M1");
    product.setDescripcion("Duración de la batería durante todo el día: dure más que nunca con hasta 18 horas de duración de la batería.\n" +
            "Rendimiento potente");
    product.setPrecioBase(250.3);
    f = new Family();
    f.setId(new ObjectId());
    f.setName("Tecnologia");
    product.setReferencia(product.getReferencia());
    fsaved = familyRepository.save(f);
    product.setFamiliaProduto(fsaved);
    productRepository.save(product);



    log.info("... finished app initialization");

  }
}
