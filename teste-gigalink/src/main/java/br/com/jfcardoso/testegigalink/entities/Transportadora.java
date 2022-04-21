package br.com.jfcardoso.testegigalink.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transportadora {

    private Long id;
    private String nome;
}
