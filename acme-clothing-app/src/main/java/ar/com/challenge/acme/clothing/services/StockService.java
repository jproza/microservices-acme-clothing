package ar.com.challenge.acme.clothing.services;

import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.entities.Stock;
import ar.com.challenge.acme.clothing.entities.Storage;
import ar.com.challenge.acme.clothing.ex.EntityNotFoundException;
import ar.com.challenge.acme.clothing.repository.ProductRepository;
import ar.com.challenge.acme.clothing.repository.StockRepository;
import ar.com.challenge.acme.clothing.reqres.ProductRequest;
import ar.com.challenge.acme.clothing.reqres.StockRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private ProductService productService;



    public  List<Stock> findAll() {
        return repository.findAll();
    };

    public Long createNewProduct(Stock product) {
        return 1l;
    }

    public List<Stock> getAllProducts() {
        return repository.findAll();
    }




    public List<Stock> findByLstStorage_Nombre(String nombre) {
        return repository.findByLstStorage_NombreContainingIgnoreCase(nombre);
    }


    public List<Stock> getStockByProductName(String name) {
        List<Product> productStock = productService.findByNombreContainingIgnoreCase(name);
        if (productStock == null && productStock.isEmpty()) {
            throw new EntityNotFoundException(String.format("Stock and product with name: '%s' not found", name));
        }
        return productStock.stream().map(Product::getStock).collect(Collectors.toList());
    }


//
//    @Caching(evict = {@CacheEvict(value = "getAllCataloguescache", allEntries = true),
//            @CacheEvict(value = "cataloguecache", key = "#catalogueToUpdateRequest.nombre")
//    })
    @Transactional
    public Product updateStockPerProduct(String id, StockRequest productToUpdateRequest) {

        Optional<Product> productFromDatabase = productService.findById(id);

        if (productFromDatabase.isEmpty()) {
            throw new EntityNotFoundException(String.format("Catalogue with id: '%s' not found", id));
        }
        Product productcatalogueToUpdate = productFromDatabase.get();
        productcatalogueToUpdate.setStock(productToUpdateRequest.getStock());

        productService.save(productcatalogueToUpdate);


        return productcatalogueToUpdate;
    }

    public void deleteProductById(String id) {
        repository.deleteById(id);
    }


}
