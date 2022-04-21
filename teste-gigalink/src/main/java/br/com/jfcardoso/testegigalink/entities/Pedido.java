package br.com.jfcardoso.testegigalink.entities;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class Pedido {
    private Long id;
    private Date dataHora;
    private String notaFiscal;
    private BigDecimal valorFrete;
    private BigDecimal desconto;
    private BigDecimal valorTotal;
}
