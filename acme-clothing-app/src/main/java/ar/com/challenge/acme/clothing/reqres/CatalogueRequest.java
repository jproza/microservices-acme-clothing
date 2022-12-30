package ar.com.challenge.acme.clothing.reqres;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CatalogueRequest {
  @NotEmpty
  @Size(max = 20)
  private String nombre;
}
