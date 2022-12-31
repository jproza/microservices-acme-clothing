package ar.com.challenge.acme.clothing.services;

import ar.com.challenge.acme.clothing.entities.Family;
import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.ex.EntityNotFoundException;
import ar.com.challenge.acme.clothing.repository.ProductRepository;
import ar.com.challenge.acme.clothing.reqres.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@CacheConfig(cacheNames = "product")
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public  List<Product> findAll() {
        return repository.findAll();
    };

    public Long createNewProduct(Product product) {
        return 1l;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public List<Product> findByNombreContainingIgnoreCase(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }



    public Product getProductById(String id) {
        Optional<Product> requestedProducts = repository.findById(id);

        if (requestedProducts.isEmpty()) {
            throw new EntityNotFoundException(String.format("Catalogue with id: '%s' not found", id));
        }

        return requestedProducts.get();
    }
//
//    @Caching(evict = {@CacheEvict(value = "getAllCataloguescache", allEntries = true),
//            @CacheEvict(value = "cataloguecache", key = "#catalogueToUpdateRequest.nombre")
//    })
    @Transactional
    public Product updateProduct(String id, ProductRequest productToUpdateRequest) {

        Optional<Product> productFromDatabase = repository.findById(id);

        if (productFromDatabase.isEmpty()) {
            throw new EntityNotFoundException(String.format("Catalogue with id: '%s' not found", id));
        }
        Product productcatalogueToUpdate = productFromDatabase.get();
        productcatalogueToUpdate.setNombre(productToUpdateRequest.getNombre());
        productcatalogueToUpdate.setFamiliaProduto(productToUpdateRequest.getFamiliaProduto());
        productcatalogueToUpdate.setPrecioBase(productToUpdateRequest.getPrecioBase());


        repository.save(productcatalogueToUpdate);


        return productcatalogueToUpdate;
    }

    public void deleteProductById(String id) {
        repository.deleteById(id);
    }


    public List<Product> findByfamiliaProdutoContainingIgnoreCase(String nombreFamilia) {
       return repository.findByFamiliaProduto_NameContains(nombreFamilia);
    }

}
