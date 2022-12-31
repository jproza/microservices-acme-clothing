package ar.com.challenge.acme.clothing.entities;


import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;


//=Producto
@Document("products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {


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


  //@DocumentReference(lazy = true)
  private Family familiaProduto;

  @NotNull
  private Double precioBase;
//  @NotBlank
//  @NotNull
  private Customization customization;
//  @NotBlank
//  @NotNull
  private List<Slogan> lstSlogan;
//  @NotBlank
//  @NotNull
  private List<Media> listMedia;
//  @NotBlank
//  @NotNull
  private Stock stock;

  public String getId(){
    return id.toHexString();
  }

  public String getReferencia() {
    if (StringUtils.isEmpty(this.referencia)) {
      this.setReferencia("REF-" + fiveDigitGenerator() + "-" + threeDigitGenerator());
    }
    return this.referencia;
  }


  public int fiveDigitGenerator() {
    SecureRandom secureRandom = new SecureRandom();
    int randomWithSecureRandomWithinARange = secureRandom.nextInt(10000 - 1) + 1 * 10000;
    return randomWithSecureRandomWithinARange;
  }

  public int threeDigitGenerator() {
    SecureRandom secureRandom = new SecureRandom();
    int randomWithSecureRandomWithinARange = secureRandom.nextInt(100 - 1) + 1 * 100;
    return randomWithSecureRandomWithinARange;
  }

}
