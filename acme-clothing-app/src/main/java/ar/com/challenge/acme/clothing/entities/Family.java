package ar.com.challenge.acme.clothing.entities;

import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document("Families")
@NoArgsConstructor
public class Family {


    @Id
    private ObjectId id;
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private List<Wear> nodes = new ArrayList<>();

    public String getId(){
        return id.toHexString();
    }

}
