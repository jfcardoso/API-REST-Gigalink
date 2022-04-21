package br.com.jfcardoso.testegigalink.entities;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Pedido {
    private int id;
    private Date dataHora;
    private String notaFiscal;
    private double valorFrete;
    private double desconto;
    private double valorTotal;
}
