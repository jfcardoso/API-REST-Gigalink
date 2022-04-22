package br.com.jfcardoso.testegigalink.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataHora;
    private String notaFiscal;
    private BigDecimal valorFrete;
    private BigDecimal desconto;
    private BigDecimal valorTotal;
    @ManyToOne(fetch = FetchType.LAZY)
    Transportadora transportadora;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    List<Item> itens;

}
