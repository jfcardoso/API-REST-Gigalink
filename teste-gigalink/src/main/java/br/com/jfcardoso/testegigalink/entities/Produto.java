package br.com.jfcardoso.testegigalink.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Produto {

    private int id;
    private String nome;
    private String descricao;
}
