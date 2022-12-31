package ar.com.challenge.acme.clothing.services;


import ar.com.challenge.acme.clothing.entities.Family;
import ar.com.challenge.acme.clothing.entities.Product;
import ar.com.challenge.acme.clothing.repository.FamilyRepository;
import ar.com.challenge.acme.clothing.ex.EntityNotFoundException;
import ar.com.challenge.acme.clothing.reqres.FamilyRequest;
import org.bson.types.ObjectId;
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
    public String createNewFamily(FamilyRequest catalogueRequest) {
        Family f = new Family();
        f.setName(catalogueRequest.getNombre());
        f.setId(new ObjectId());
        return familyRepository.save(f).getId();
    }
//
//    @Cacheable(value = "getAllCataloguescache")
    public List<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

    public List<Family> findByNombreContainingIgnoreCase(String nombre) {
        return familyRepository.findByNameContainingIgnoreCase(nombre);
    }


    public Family getFamilyById(String id) {
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
    public Family updateFamily(String id, FamilyRequest familyToUpdateRequest) {

        Optional<Family> familyFromDatabase = familyRepository.findById(id);

        if (familyFromDatabase.isEmpty()) {
            throw new EntityNotFoundException(String.format("Catalogue with id: '%s' not found", id));
        }
        Family familyToUpdate = familyFromDatabase.get();
        familyToUpdate.setName(familyToUpdateRequest.getNombre());
        familyRepository.save(familyToUpdate);
        return familyToUpdate;
    }

    public void deleteFamilyById(String id) {
        familyRepository.deleteById(id);
    }
}
