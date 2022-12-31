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


@Document("Slogans")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @NotNull
    private Family familia;



    public String getId(){
        return id.toHexString();
    }


    public String getIdentificador() {
        if (StringUtils.isEmpty(this.identificador)) {
            setIdentificador("SLO-" + fourDigitGenerator());
        }
        return this.identificador;
    }

    public int fourDigitGenerator() {
        SecureRandom secureRandom = new SecureRandom();
        int randomWithSecureRandomWithinARange = secureRandom.nextInt(1000 - 1) + 1 * 1000;
        return randomWithSecureRandomWithinARange;
    }


    public static void main(String[] args) {
        System.out.println(new Slogan().getIdentificador());
        System.out.println(new Slogan().getIdentificador());
        System.out.println(new Slogan().getIdentificador());
        System.out.println(new Slogan().getIdentificador());

    }

}
