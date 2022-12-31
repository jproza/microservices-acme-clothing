package ar.com.challenge.acme.clothing.entities;

import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document("Families")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Family extends  Customization {

    @NotBlank
    @NotNull
    private String name;


    public String getReferencia() {
        if (!StringUtils.isEmpty(getNombrePersonalizacion())) {

            if (StringUtils.isEmpty(this.referencia)) {
                this.setReferencia("CUS-" + "FAM-" +  fourDigitGenerator());
            }
            return this.referencia;

        }
        return this.referencia;

    }
}
