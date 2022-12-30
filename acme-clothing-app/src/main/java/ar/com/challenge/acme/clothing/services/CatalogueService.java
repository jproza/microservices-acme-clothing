package ar.com.challenge.acme.clothing.services;

import ar.com.challenge.acme.clothing.entities.Wear;
import ar.com.challenge.acme.clothing.repository.CatalogueRepository;
import ar.com.challenge.acme.clothing.reqres.CatalogueRequest;
import ar.com.challenge.acme.clothing.ex.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@CacheConfig(cacheNames = "product")
@Service
public class CatalogueService {

  @Autowired
  private CatalogueRepository catalogueRepository;

  @Caching(evict = {@CacheEvict(value = "getAllCataloguescache", allEntries = true),
          @CacheEvict(value = "cataloguecache", key = "#catalogueRequest.nombre")
  })
  public Long createNewCatalogue(CatalogueRequest catalogueRequest) {
  /*  Wear wear = new Wear();
    wear.setNombre(catalogueRequest.getNombre());
    wear = catalogueRepository.save(wear);
    return wear.getId();*/
    return 1l;
  }

  @Cacheable(value = "getAllCataloguescache")
  public List<Wear> getAllCatalogues() {
    return catalogueRepository.findAll();
  }

  public List<Wear> findByNombreContainingIgnoreCase(String nombre) {
    return catalogueRepository.findByNombreContainingIgnoreCase(nombre);
  }


  public Wear getCataloguesById(Long id) {
    Optional<Wear> requestedCatalogues = catalogueRepository.findById(id);

    if (requestedCatalogues.isEmpty()) {
      throw new EntityNotFoundException(String.format("Catalogue with id: '%s' not found", id));
    }

    return requestedCatalogues.get();
  }

  @Caching(evict = {@CacheEvict(value = "getAllCataloguescache", allEntries = true),
          @CacheEvict(value = "cataloguecache", key = "#catalogueToUpdateRequest.nombre")
  })
  @Transactional
  public Wear updateCatalogues(Long id, CatalogueRequest catalogueToUpdateRequest) {

    Optional<Wear> catalogueFromDatabase = catalogueRepository.findById(id);

    if (catalogueFromDatabase.isEmpty()) {
      throw new EntityNotFoundException(String.format("Catalogue with id: '%s' not found", id));
    }
    Wear catalogueToUpdate = catalogueFromDatabase.get();
    catalogueToUpdate.setNombre(catalogueToUpdateRequest.getNombre());
    return catalogueToUpdate;
  }

  public void deleteCatalogueById(Long id) {
    catalogueRepository.deleteById(id);
  }
}
