package ar.com.challenge.acme.clothing.reqres;
import ar.com.challenge.acme.clothing.entities.*;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ProductRequest {
    @Id
    private ObjectId id;
    @NotBlank
    @NotNull
    private String nombre;
    @NotBlank
    @NotNull
    private String descripcion;
    @NotBlank
    @NotNull
    private String referencia;

    private Family familiaProduto;
    @NotNull
    private Double precioBase;
//    @NotBlank
//    @NotNull
    private Customization customization;
  //  @NotBlank
   // @NotNull
    private List<Slogan> lstSlogan;
   // @NotBlank
   // @NotNull
    private List<Media> listMedia;
   // @NotBlank
   // @NotNull
    private Stock stock;

}
