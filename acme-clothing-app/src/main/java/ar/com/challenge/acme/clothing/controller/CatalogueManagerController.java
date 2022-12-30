package ar.com.challenge.acme.clothing.controller;

import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.logging.LogApp;
import ar.com.challenge.acme.clothing.reqres.CatalogueRequest;
import ar.com.challenge.acme.clothing.reqres.FamilyRequest;
import ar.com.challenge.acme.clothing.services.CatalogueService;

import ar.com.challenge.acme.clothing.services.FamilyService;
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

@RestController
@RequestMapping("/api/catalogue")
public class CatalogueManagerController {

  @Autowired
  private CatalogueService catalogueService;



  //dada familia de un producto
  public List<Product> findFamiliaByfamiliaProdutoContainingIgnoreCase(String familiaNombre) {
    return catalogueService.findByfamiliaProdutoContainingIgnoreCase(familiaNombre);
  }



  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String nombre) {
    if (Strings.isEmpty(nombre)) {
      return ResponseEntity.ok(catalogueService.getAllProducts());
    } else {
      return ResponseEntity.ok(catalogueService.findByNombreContainingIgnoreCase(nombre));
    }

  }
  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @GetMapping("/{id}")
  public ResponseEntity<Product> getProdcutById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(catalogueService.getProdcutById(id));
  }

//  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
//  @PutMapping("/{id}")
//  public ResponseEntity<Product> updateCatalogue(@PathVariable("id") Long id, @Valid @RequestBody CatalogueRequest catalogueRequest) {
//    return ResponseEntity.ok(catalogueService.updateCatalogues(id, catalogueRequest));
//  }

//  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
//  @DeleteMapping("/{id}")
//  public ResponseEntity<Void> deleteCatalogue(@PathVariable("id") Long id) {
//    catalogueService.deleteCatalogueById(id);
//    return ResponseEntity.ok().build();
//  }


  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @PostMapping
  public ResponseEntity<Void> createNewFamily(@Valid @RequestBody FamilyRequest familyRequest, UriComponentsBuilder uriComponentsBuilder) {
    Long primaryKey = catalogueService.createNewFamily(familyRequest);

    UriComponents uriComponents = uriComponentsBuilder.path("/api/family/{id}").buildAndExpand(primaryKey);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(uriComponents.toUri());

    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }
  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @GetMapping
  public ResponseEntity<List<Product>> getAllFamilies(@RequestParam(required = false) String nombre) {
    if (Strings.isEmpty(nombre)) {
      return ResponseEntity.ok(catalogueService.getAllFamilies());
    } else {
      return ResponseEntity.ok(catalogueService.findByNombreContainingIgnoreCase(nombre));
    }

  }
  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @GetMapping("/{id}")
  public ResponseEntity<Product> getFamilyById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(catalogueService.getFamilyById(id));
  }

  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @PutMapping("/{id}")
  public ResponseEntity<Product> updateCatalogue(@PathVariable("id") Long id, @Valid @RequestBody FamilyRequest familyRequest) {
    return ResponseEntity.ok(catalogueService.updateFamily(id, familyRequest));
  }

  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFamily(@PathVariable("id") Long id) {
    catalogueService.deleteFamilyById(id);
    return ResponseEntity.ok().build();
  }

}
