package br.com.jfcardoso.testegigalink.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fornecedor {

    private int id;
    private String nome;
    private String descricao;
    private String cidade;
    private String endereco;
    private String bairro;
    private int numero;
}
