package ar.com.challenge.acme.clothing.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Document("Storages")
@NoArgsConstructor
public class Storage {

        @Id
        private ObjectId id;
        @NotBlank
        @NotNull
        private String nombre;


        public String getId(){
                return id.toHexString();
        }


}
