package ar.com.challenge.acme.clothing.services;


import ar.com.challenge.acme.clothing.entities.Family;
import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.repository.FamilyRepository;
import ar.com.challenge.acme.clothing.ex.EntityNotFoundException;
import ar.com.challenge.acme.clothing.reqres.FamilyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@CacheConfig(cacheNames = "families")
@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;
//
//    @Caching(evict = {@CacheEvict(value = "getAllCataloguescache", allEntries = true),
//            @CacheEvict(value = "cataloguecache", key = "#catalogueRequest.nombre")
//    })
    public Long createNewFamily(FamilyRequest catalogueRequest) {

        return 1l;
    }
//
//    @Cacheable(value = "getAllCataloguescache")
    public List<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

    public List<Family> findByNombreContainingIgnoreCase(String nombre) {
        return familyRepository.findByNameContainingIgnoreCase(nombre);
    }


    public Family getFamilyById(Long id) {
        Optional<Family> requestedCatalogues = familyRepository.findById(id);

        if (requestedCatalogues.isEmpty()) {
            throw new EntityNotFoundException(String.format("Catalogue with id: '%s' not found", id));
        }

        return requestedCatalogues.get();
    }

//    @Caching(evict = {@CacheEvict(value = "getAllCataloguescache", allEntries = true),
//            @CacheEvict(value = "cataloguecache", key = "#familyToUpdateRequest.nombre")
//    })
    @Transactional
    public Family updateFamily(Long id, FamilyRequest familyToUpdateRequest) {

        Optional<Family> catalogueFromDatabase = familyRepository.findById(id);

        if (catalogueFromDatabase.isEmpty()) {
            throw new EntityNotFoundException(String.format("Catalogue with id: '%s' not found", id));
        }
        Family catalogueToUpdate = catalogueFromDatabase.get();
        catalogueToUpdate.setName(familyToUpdateRequest.getNombre());
        return catalogueToUpdate;
    }

    public void deleteFamilyById(Long id) {
        familyRepository.deleteById(id);
    }
}
