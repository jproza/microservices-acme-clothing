package ar.com.challenge.acme.clothing.entities;

import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.security.SecureRandom;
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

    private int priorite;
    private int size;



    public String getId(){
        return id.toHexString();
    }


    public String getIdentificador() {
        if (StringUtils.isEmpty(this.identificador)) {
            this.setIdentificador("MED-"  + sixDigitGenerator());
        }
        return this.identificador;
    }

    public int sixDigitGenerator() {
        SecureRandom secureRandom = new SecureRandom();
        int randomWithSecureRandomWithinARange = secureRandom.nextInt(100000 - 1) + 1 * 100000;
        return randomWithSecureRandomWithinARange;
    }

}
