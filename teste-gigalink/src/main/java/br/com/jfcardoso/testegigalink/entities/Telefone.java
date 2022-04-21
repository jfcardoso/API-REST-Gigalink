package br.com.jfcardoso.testegigalink.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Telefone {

    private Long id;
    private String ddd;
    private String numero;
    private String referencia;
}