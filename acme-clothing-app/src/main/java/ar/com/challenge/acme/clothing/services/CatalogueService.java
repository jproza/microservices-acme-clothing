package ar.com.challenge.acme.clothing.services;

import ar.com.challenge.acme.clothing.entities.Family;
import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.reqres.FamilyRequest;
import ar.com.challenge.acme.clothing.reqres.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@CacheConfig(cacheNames = "catalogue")
//Compositor pattern - Orchestation
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
  public List<Product> findProdcutByFamilyContainingIgnoreCase(String familiaNombre) {
    return productService.findByfamiliaProdutoContainingIgnoreCase(familiaNombre);
  }



  //especifico un id de prod
  public Product getProdcutById(String id) {
    Product requestedProduct = productService.getProductById(id);
        return requestedProduct;
  }

    public List<Product> findProductByNombreContainingIgnoreCase(String nombre) {
        return productService.findByNombreContainingIgnoreCase(nombre);
    }



    public String createNewFamily(FamilyRequest familyRequest) {
        return familyService.createNewFamily(familyRequest);
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public List<Family> findFamiliesByNombreContainingIgnoreCase(String nombre) {
        return familyService.findByNombreContainingIgnoreCase(nombre);
    }


    public Family getFamilyById(String id) {
       return familyService.getFamilyById(id);
    }

    @Transactional
    public Family updateFamily(String id, FamilyRequest familyToUpdateRequest) {
       return familyService.updateFamily(id,familyToUpdateRequest);
    }

    @Transactional
    public Product updateProduct(String id, ProductRequest productToUpdateRequest) {
        return productService.updateProduct(id,productToUpdateRequest);
    }

    @Transactional
    public Product createProduct(ProductRequest productToUpdateRequest) {
        return productService.createNewProduct(productToUpdateRequest);
    }

    public void deleteFamilyById(String id) {
      familyService.deleteFamilyById(id);
    }

}
