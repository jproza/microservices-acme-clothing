package ar.com.challenge.acme.clothing.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Random;

@Document("Medias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Media {


    @Id
    private ObjectId id;
    @NotBlank
    @NotNull
    private String path;
    @NotBlank
    @NotNull
    private String identificador;
    @NotBlank
    @NotNull
    private int priorite;



    public String getId(){
        return id.toHexString();
    }


    public String getReferencia() {
        if (identificador == null) {
            identificador =  "MED-"  + sixDigitGenerator();
        }
        return identificador;
    }

    public int sixDigitGenerator() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 100000 + r.nextInt(100000));
    }

}
