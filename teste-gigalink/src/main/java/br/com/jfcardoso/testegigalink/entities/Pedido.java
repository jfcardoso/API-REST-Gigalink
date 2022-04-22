package br.com.jfcardoso.testegigalink.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class Pedido {
    private Long id;
    private Date dataHora;
    private String notaFiscal;
    private BigDecimal valorFrete;
    private BigDecimal desconto;
    private BigDecimal valorTotal;
    @ManyToOne
    @JoinColumn(name = "transportadora_id")
    Transportadora transportadora;
    @OneToMany
    @JoinColumn(name = "item_id")
    List<Item> itens;

}
