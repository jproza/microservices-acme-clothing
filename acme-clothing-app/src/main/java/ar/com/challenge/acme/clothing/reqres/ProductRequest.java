package ar.com.challenge.acme.clothing.reqres;
import lombok.Data;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProductRequest {
    @NotEmpty
    @NotNull
    private ObjectId id;
    @NotEmpty
    @Size(max = 30)
    @NotNull
    private String nombre;

}
