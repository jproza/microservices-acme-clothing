package ar.com.challenge.acme.clothing.controller;


import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.logging.LogApp;
import ar.com.challenge.acme.clothing.reqres.ProductRequest;
import ar.com.challenge.acme.clothing.services.ProductService;
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
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @PostMapping
    public ResponseEntity<Void> createNewProduct(@Valid @RequestBody ProductRequest productRequest, UriComponentsBuilder uriComponentsBuilder) {
        productService.createNewProduct(productRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String nombre) {
        if (Strings.isEmpty(nombre)) {
            return ResponseEntity.ok(productService.getAllProducts());
        } else {
            return ResponseEntity.ok(productService.findByNombreContainingIgnoreCase(nombre));
        }

    }
    @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @Valid @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.updateProduct(id, productRequest));
    }

    @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") String id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }


}
