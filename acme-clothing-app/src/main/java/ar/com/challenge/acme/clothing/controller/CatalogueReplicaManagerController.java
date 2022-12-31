package ar.com.challenge.acme.clothing.controller;

import ar.com.challenge.acme.clothing.entities.Family;
import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.logging.LogApp;
import ar.com.challenge.acme.clothing.reqres.FamilyRequest;
import ar.com.challenge.acme.clothing.reqres.ProductRequest;
import ar.com.challenge.acme.clothing.services.CatalogueService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@RestController
@RequestMapping("/api/catalogue/replica")
public class CatalogueReplicaManagerController {

  @Autowired
  private CatalogueService catalogueService;


  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @GetMapping(value="/family/product", produces = APPLICATION_JSON)
  public ResponseEntity<List<Product>> findFamiliaByfamiliaProdutoContainingIgnoreCase(@RequestParam(required = true)String familiaNombre) {
    return ResponseEntity.ok(catalogueService.findProdcutByFamilyContainingIgnoreCase(familiaNombre));
  }


  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @GetMapping(value="/product", produces = APPLICATION_JSON)
  public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String nombre) {
    if (Strings.isEmpty(nombre)) {
      return ResponseEntity.ok(catalogueService.getAllProducts());
    } else {
      return ResponseEntity.ok(catalogueService.findProductByNombreContainingIgnoreCase(nombre));
    }

  }
  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @GetMapping("/product/{id}")
  public ResponseEntity<Product> getProdcutById(@PathVariable("id") String id) {
    return ResponseEntity.ok(catalogueService.getProdcutById(id));
  }


  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @PutMapping("/product/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @Valid @RequestBody ProductRequest productRequest) {
    return ResponseEntity.ok(catalogueService.updateProduct(id, productRequest));
  }


  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @PostMapping(value="/family")
  public ResponseEntity<Void> createNewFamily(@Valid @RequestBody FamilyRequest familyRequest, UriComponentsBuilder uriComponentsBuilder) {
    String primaryKey = catalogueService.createNewFamily(familyRequest);

    UriComponents uriComponents = uriComponentsBuilder.path("/api/family/{id}").buildAndExpand(primaryKey);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(uriComponents.toUri());

    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }

  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @GetMapping(value="/family", produces = APPLICATION_JSON)
  public ResponseEntity<List<Family>> getAllFamilies(@RequestParam(required = false) String nombre) {
    if (Strings.isEmpty(nombre)) {
      return ResponseEntity.ok(catalogueService.getAllFamilies());
    } else {
      return ResponseEntity.ok(catalogueService.findFamiliesByNombreContainingIgnoreCase(nombre));
    }

  }
  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @GetMapping("/family/{id}")
  public ResponseEntity<Family> getFamilyById(@PathVariable("id") String id) {
    return ResponseEntity.ok(catalogueService.getFamilyById(id));
  }

  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @PutMapping("/family/{id}")
  public ResponseEntity<Family> updateFamily(@PathVariable("id") String id, @Valid @RequestBody FamilyRequest familyRequest) {
    return ResponseEntity.ok(catalogueService.updateFamily(id, familyRequest));
  }

  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @DeleteMapping("/family/{id}")
  public ResponseEntity<Void> deleteFamily(@PathVariable("id") String id) {
    catalogueService.deleteFamilyById(id);
    return ResponseEntity.ok().build();
  }

}
