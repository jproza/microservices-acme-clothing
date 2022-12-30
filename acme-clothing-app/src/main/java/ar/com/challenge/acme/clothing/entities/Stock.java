package ar.com.challenge.acme.clothing.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;




@Document("Stocks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {

    @Id
    private ObjectId id;
    @NotBlank
    @NotNull
    private List<Storage> lstStorage;


    public String getId(){
        return id.toHexString();
    }




}
