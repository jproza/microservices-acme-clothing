package ar.com.challenge.acme.clothing.entities;

import ar.com.challenge.acme.clothing.entities.Node;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.security.SecureRandom;
import java.util.Random;

@Document("Customizations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customization extends  IEntityModel {

  @Id
  public ObjectId id;

  private String nombrePersonalizacion;

  String referencia;
  private Double precioPersonalizacion;
  private String detallePersonalizacion;

  public String getId(){
    return id.toHexString();
  }


  public int fourDigitGenerator() {
    SecureRandom secureRandom = new SecureRandom();
    int randomWithSecureRandomWithinARange = secureRandom.nextInt(1000 - 1) + 1 * 1000;
    return randomWithSecureRandomWithinARange;
  }

}
