package ar.com.challenge.acme.clothing.entities;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

  @NotBlank
  @NotNull
  private Double precioBase;
  @NotBlank
  @NotNull
  private Customization customization;
  @NotBlank
  @NotNull
  private List<Slogan> lstSlogan;
  @NotBlank
  @NotNull
  private List<Media> listMedia;
  @NotBlank
  @NotNull
  private Stock stock;

  public String getId(){
    return id.toHexString();
  }

  public String getReferencia() {
    if (this.referencia == null) {
      this.referencia =  "REF-" + fiveDigitGenerator() + "-" + threeDigitGenerator();
    }
    return this.referencia;
  }

  public int fiveDigitGenerator() {
    Random r = new Random( System.currentTimeMillis() );
    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
  }

  public int threeDigitGenerator() {
    Random r = new Random( System.currentTimeMillis() );
    return ((1 + r.nextInt(2)) * 100 + r.nextInt(100));
  }

}
