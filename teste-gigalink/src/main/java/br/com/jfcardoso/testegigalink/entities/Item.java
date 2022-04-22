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
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    Produto produto;

}
