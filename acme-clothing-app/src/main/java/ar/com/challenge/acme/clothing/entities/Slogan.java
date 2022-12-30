package ar.com.challenge.acme.clothing.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Random;


@Document("Slogans")
@NoArgsConstructor
public class Slogan {

    @Id
    private ObjectId id;
    @NotBlank
    @NotNull
    private String identificador;
    @NotBlank
    @NotNull
    private String text;
    @NotBlank
    @NotNull
    private String alternateText;
    @NotBlank
    @NotNull
    private Node familia;



    public String getId(){
        return id.toHexString();
    }


    public String getReferencia() {
        if (identificador == null) {
            identificador =  "SLO-" + "-" + fourDigitGenerator();
        }
        return identificador;
    }

    public int fourDigitGenerator() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 1000 + r.nextInt(1000));
    }

}
