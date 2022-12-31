package ar.com.challenge.acme.clothing.entities;

import com.google.common.collect.Lists;
import lombok.*;
import org.bouncycastle.util.Arrays;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.beans.Beans;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Document("Stocks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {

    @Id
    private ObjectId id;


    private List<Storage> lstStorage;

    private int stockDisponible;

    private boolean hayStock;

    private LocalDateTime fechaLlegada;

    public String getId(){
        return id.toHexString();
    }

    public int getStockDisponible() {
        if (this.lstStorage != null && !this.lstStorage.isEmpty()) {
            int sum = lstStorage.stream()
            .mapToInt(Storage::getQuantity).sum();
            this.stockDisponible = sum;
        }
        return stockDisponible;
    }

    public boolean getHayStock() {
        if (getStockDisponible() <= 0) {
            this.hayStock = false;
        } else {
            this.hayStock = true;
        }
        return this.hayStock;
    }


    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public LocalDateTime getFechaLlegada(){
       if (!getHayStock()) {
           this.fechaLlegada = LocalDateTime.now().plusMonths(2);
       }else {
           this.fechaLlegada = null;
       }
       return this.fechaLlegada;
    }


//    public static void main(String[] args) {
//        Stock s = new Stock();
//        System.out.println(s.getStockDisponible());
//
//        Storage st = new Storage();
//        st.setQuantity(2);
//
//        List<Storage> lstSt = new ArrayList<>();
//
//        lstSt.add(st);
//        s.setLstStorage(lstSt);
//        System.out.println(s.getStockDisponible());
//        st = new Storage();
//        st.setQuantity(23);
//
//        lstSt.add(st);
//        s.setLstStorage(lstSt);
//        System.out.println(s.getStockDisponible());
//
//
//
//    }


}
