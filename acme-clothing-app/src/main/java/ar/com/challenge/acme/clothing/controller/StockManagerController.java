package ar.com.challenge.acme.clothing.controller;

import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.entities.Stock;
import ar.com.challenge.acme.clothing.logging.LogApp;
import ar.com.challenge.acme.clothing.reqres.ProductRequest;
import ar.com.challenge.acme.clothing.reqres.StockRequest;
import ar.com.challenge.acme.clothing.services.StockService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.time.temporal.ChronoUnit;
import java.util.List;


@RestController
@RequestMapping("/api/stock")
public class StockManagerController {


    @Autowired
    private StockService stockService;


    @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @GetMapping
    public ResponseEntity<List<Stock>> getStockByStorageName(@RequestParam(required = false) String storageName) {
        if (Strings.isEmpty(storageName)) {
            HttpHeaders headers = new HttpHeaders();
            return new ResponseEntity<List<Stock>>(headers, HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(stockService.findByLstStorage_Nombre(storageName));
        }

    }

    @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @GetMapping("/product")
    public ResponseEntity<List<Stock>> getStockByProducteName(@RequestParam(required = false) String nombre) {
        return ResponseEntity.ok(stockService.getStockByProductName(nombre));
    }


    @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateStockProduct(@PathVariable("id") String id, @Valid @RequestBody StockRequest productRequest) {
        return ResponseEntity.ok(stockService.updateStockPerProduct(id, productRequest));
    }


}
