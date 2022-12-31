package ar.com.challenge.acme.clothing.repository;

import ar.com.challenge.acme.clothing.entities.Family;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyRepository extends MongoRepository<Family, String> {

    List<Family> findByNameContainingIgnoreCase(String nombre);


}