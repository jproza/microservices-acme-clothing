package ar.com.challenge.acme.clothing.reqres;
import ar.com.challenge.acme.clothing.entities.*;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class StockRequest {
    @Id
    private ObjectId id;

    private List<Slogan> lstSlogan;
    private Stock stock;

}
