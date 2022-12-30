package ar.com.challenge.acme.clothing.entities;

import ar.com.challenge.acme.clothing.entities.Node;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Random;

@Document("Customizations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customization {

  @Id
  private ObjectId id;
  @NotBlank
  @NotNull
  private String nombre_personalización;
  @NotBlank
  @NotNull
  private String referencia;
  @NotBlank
  @NotNull
  private Family familia;


  public String getId(){
    return id.toHexString();
  }

  public String getReferencia() {
    if (referencia == null) {
      referencia =  "CUS-" + "FAM/REF" +  fourDigitGenerator();
    }
    return referencia;
  }

  public int fourDigitGenerator() {
    Random r = new Random( System.currentTimeMillis() );
    return ((1 + r.nextInt(2)) * 1000 + r.nextInt(1000));
  }

  public int threeDigitGenerator() {
    Random r = new Random( System.currentTimeMillis() );
    return ((1 + r.nextInt(2)) * 100 + r.nextInt(100));
  }

}
