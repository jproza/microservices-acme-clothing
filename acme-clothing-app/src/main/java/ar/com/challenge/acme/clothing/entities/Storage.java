package ar.com.challenge.acme.clothing.entities;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Document("Storages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Storage {

        @Id
        private ObjectId id;
        @NotBlank
        @NotNull
        private String nombre;

        private int quantity;


        public String getId(){
                return id.toHexString();
        }


}
