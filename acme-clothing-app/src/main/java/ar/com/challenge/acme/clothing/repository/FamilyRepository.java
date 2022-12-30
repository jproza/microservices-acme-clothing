package ar.com.challenge.acme.clothing.repository;

import ar.com.challenge.acme.clothing.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyRepository extends MongoRepository<Product, Long> {

    List<Product> findByNombreContainingIgnoreCase(String nombre);


}