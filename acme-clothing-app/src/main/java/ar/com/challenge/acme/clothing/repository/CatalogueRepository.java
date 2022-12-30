package ar.com.challenge.acme.clothing.repository;

import ar.com.challenge.acme.clothing.entities.Wear;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogueRepository extends MongoRepository<Wear, Long> {

    List<Wear> findByNombreContainingIgnoreCase(String nombre);


}
