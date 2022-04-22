package br.com.jfcardoso.testegigalink.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double quantidade;
    private BigDecimal valor;
    @ManyToOne(fetch = FetchType.LAZY)
    Pedido pedido;
    @ManyToOne(fetch = FetchType.LAZY)
    Produto produto;

}
