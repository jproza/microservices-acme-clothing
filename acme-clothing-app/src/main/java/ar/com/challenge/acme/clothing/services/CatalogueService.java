package ar.com.challenge.acme.clothing.services;

import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.ex.EntityNotFoundException;
import ar.com.challenge.acme.clothing.reqres.FamilyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@CacheConfig(cacheNames = "catalogue")
@Service
public class CatalogueService {


  @Autowired
  private ProductService productService;

  @Autowired
  private FamilyService familyService;

 //todos los prod
  public List<Product> getAllProducts() {
    return productService.findAll();
  }

  //dada familia de un producto
  public List<Product> findByfamiliaProdutoContainingIgnoreCase(String familiaNombre) {
    return productService.findByfamiliaProdutoContainingIgnoreCase(familiaNombre);
  }

  //especifico un id de prod
  public Product getProdcutById(Long id) {
    Product requestedProduct = productService.getProductById(id);
        return requestedProduct;
  }

    public List<Product> findByNombreContainingIgnoreCase(String nombre) {
        return productService.findByNombreContainingIgnoreCase(nombre);
    }



    public Long createNewFamily(FamilyRequest familyRequest) {
        return familyService.createNewFamily(familyRequest);
    }

    public List<Product> getAllFamilies() {
        return familyService.getAllFamilies();

    }


    public Product getFamilyById(Long id) {
       return familyService.getFamilyById(id);
    }

    @Transactional
    public Product updateFamily(Long id, FamilyRequest familyToUpdateRequest) {
       return familyService.updateFamily(id,familyToUpdateRequest);
    }

    public void deleteFamilyById(Long id) {
      familyService.deleteFamilyById(id);
    }

}
