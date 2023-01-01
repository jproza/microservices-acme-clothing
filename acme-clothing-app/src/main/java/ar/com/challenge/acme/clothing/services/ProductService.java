package ar.com.challenge.acme.clothing.services;

import ar.com.challenge.acme.clothing.entities.*;
import ar.com.challenge.acme.clothing.ex.EntityNotFoundException;
import ar.com.challenge.acme.clothing.repository.ProductRepository;
import ar.com.challenge.acme.clothing.reqres.ProductRequest;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@CacheConfig(cacheNames = "product")
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public void save(Product product) {
        repository.save(product);
    };

    public  List<Product> findAll() {
        return repository.findAll();
    };

    public Product createNewProduct(ProductRequest productToCreateRequest) {


        Product productcatalogueToUpdate = new Product();
        productcatalogueToUpdate.setId(new ObjectId());
        productcatalogueToUpdate.setReferencia(productcatalogueToUpdate.getReferencia());
        productcatalogueToUpdate.setNombre(productToCreateRequest.getNombre());
        Family fp = productToCreateRequest.getFamiliaProduto();
        fp.setId(new ObjectId());
        fp.setReferencia(fp.getReferencia());
        productcatalogueToUpdate.setFamiliaProduto(fp);
        productcatalogueToUpdate.setPrecioBase(productToCreateRequest.getPrecioBase());

        if (productToCreateRequest.getCustomization() != null) {
            productcatalogueToUpdate.setDetallePersonalizacion(productToCreateRequest.getCustomization().getDetallePersonalizacion());
            productcatalogueToUpdate.setPrecioPersonalizacion(productToCreateRequest.getCustomization().getPrecioPersonalizacion());
            productcatalogueToUpdate.setNombrePersonalizacion(productToCreateRequest.getCustomization().getNombrePersonalizacion());
        }


        List<Slogan> lstSlogan =  productToCreateRequest.getLstSlogan();
        if (lstSlogan != null) {
            lstSlogan.forEach(s -> {
                s.setId(new ObjectId());
                s.setIdentificador(s.getIdentificador());
                s.getFamilia().setId(new ObjectId());
                s.getFamilia().setReferencia(s.getFamilia().getReferencia());

            });
        }

        productcatalogueToUpdate.setLstSlogan(lstSlogan);


        List<Media> lstMedia = productToCreateRequest.getListMedia();
        if (lstMedia != null) {

            lstMedia.forEach(m -> {
                m.setId(new ObjectId());
                m.setIdentificador(m.getIdentificador());
            });
        }

        productcatalogueToUpdate.setListMedia(lstMedia);

        productcatalogueToUpdate.setDescripcion(productToCreateRequest.getDescripcion());

        Stock stk = productToCreateRequest.getStock();
        if (stk != null) {
            stk.setId(new ObjectId());
            stk.setFechaLlegada(productToCreateRequest.getStock().getFechaLlegada());
            stk.setHayStock(stk.getHayStock());
            stk.setStockDisponible(stk.getStockDisponible());
            stk.setLstStorage(stk.getLstStorage());
            if (stk.getLstStorage() != null ) {
                stk.getLstStorage().forEach(storage -> {
                    storage.setId(new ObjectId());
                });
            }
        }
        productcatalogueToUpdate.setStock(stk);


        return repository.save(productcatalogueToUpdate);

    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public List<Product> findByNombreContainingIgnoreCase(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    public  Optional<Product> findById(String id) {
        return repository.findById(id);
    };

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
