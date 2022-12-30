package ar.com.challenge.acme.clothing.controller;

import ar.com.challenge.acme.clothing.entities.Wear;
import ar.com.challenge.acme.clothing.logging.LogApp;
import ar.com.challenge.acme.clothing.reqres.CatalogueRequest;
import ar.com.challenge.acme.clothing.services.CatalogueService;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/api/catalogue")
public class CatalogueManagerController {

  @Autowired
  private CatalogueService catalogueService;

  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @PostMapping
//  @Operation(summary = "Crear un nuevo Catalogo")
//  @ApiResponses(value = {
//          @ApiResponse(responseCode = "200", description = "Se creó correctamente el registro del Catalogue",
//                  content = { @Content(mediaType = "application/json",
//                          schema = @Schema(implementation = Wear.class)) }),
//          @ApiResponse(responseCode = "400", description = "Parametros incorrecto",
//                  content = @Content),
//          @ApiResponse(responseCode = "404", description = "Errores al crear un Catalogue",
//                  content = @Content) })
  public ResponseEntity<Void> createNewCatalogue(@Valid @RequestBody CatalogueRequest catalogueRequest, UriComponentsBuilder uriComponentsBuilder) {
    Long primaryKey = catalogueService.createNewCatalogue(catalogueRequest);

    UriComponents uriComponents = uriComponentsBuilder.path("/api/catalogue/{id}").buildAndExpand(primaryKey);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(uriComponents.toUri());

    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }
  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @GetMapping

/*  @Operation(summary = "Obtener el total de los  catalogue existentes, puede especificar un filtro por nombre")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Se encontraron registros de los Catalogue",
                  content = { @Content(mediaType = "application/json",
                          schema = @Schema(implementation = Wear.class)) }),
          @ApiResponse(responseCode = "400", description = "Parametro incorrecto",
                  content = @Content),
          @ApiResponse(responseCode = "404", description = "Catalogue inexistente",
                  content = @Content) })*/
  public ResponseEntity<List<Wear>> getAllCatalogues(@RequestParam(required = false) String nombre) {
    if (Strings.isEmpty(nombre)) {
      return ResponseEntity.ok(catalogueService.getAllCatalogues());
    } else {
      return ResponseEntity.ok(catalogueService.findByNombreContainingIgnoreCase(nombre));
    }

  }
  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @GetMapping("/{id}")
//  @Operation(summary = "Obtener un catalogue por Id")
//  @ApiResponses(value = {
//          @ApiResponse(responseCode = "200", description = "Se encontro registro del Catalogue",
//                  content = { @Content(mediaType = "application/json",
//                          schema = @Schema(implementation = Wear.class)) }),
//          @ApiResponse(responseCode = "400", description = "Parametro incorrecto",
//                  content = @Content),
//          @ApiResponse(responseCode = "404", description = "catalogue inexistente",
//                  content = @Content) })
  public ResponseEntity<Wear> getCatalogueById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(catalogueService.getCataloguesById(id));
  }

//  @Operation(summary = "Actualiza catalogue de forma total")
//  @ApiResponses(value = {
//          @ApiResponse(responseCode = "200", description = "Se actualizó registro del Catalogue",
//                  content = { @Content(mediaType = "application/json",
//                          schema = @Schema(implementation = Wear.class)) }),
//          @ApiResponse(responseCode = "400", description = "Parametro incorrecto",
//                  content = @Content),
//          @ApiResponse(responseCode = "404", description = "catalogue inexistente",
//                  content = @Content) })
  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @PutMapping("/{id}")
  public ResponseEntity<Wear> updateCatalogue(@PathVariable("id") Long id, @Valid @RequestBody CatalogueRequest catalogueRequest) {
    return ResponseEntity.ok(catalogueService.updateCatalogues(id, catalogueRequest));
  }

//  @Operation(summary = "Eliminar el catalogo por Id")
//  @ApiResponses(value = {
//          @ApiResponse(responseCode = "200", description = "Se eliminó registro del catalogue",
//                  content = { @Content(mediaType = "application/json",
//                          schema = @Schema(implementation = Wear.class)) }),
//          @ApiResponse(responseCode = "400", description = "Parametro incorrecto",
//                  content = @Content),
//          @ApiResponse(responseCode = "404", description = "catalogue inexistente",
//                  content = @Content) })
  @LogApp(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCatalogue(@PathVariable("id") Long id) {
    catalogueService.deleteCatalogueById(id);
    return ResponseEntity.ok().build();
  }

}
