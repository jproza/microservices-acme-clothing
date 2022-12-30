package ar.com.challenge.acme.clothing.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document("Families")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Family {


    @Id
    private ObjectId id;
    @NotBlank
    @NotNull
    private String name;
//    @NotBlank
//    @NotNull
//    private List<Product> nodes = new ArrayList<>();

    public String getId(){
        return id.toHexString();
    }

}
