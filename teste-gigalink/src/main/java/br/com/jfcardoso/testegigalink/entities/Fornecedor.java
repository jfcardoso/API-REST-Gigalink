package br.com.jfcardoso.testegigalink.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String cidade;
    private String endereco;
    private String bairro;
    private Integer numero;
    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    List<Email> emails;
    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    List<Telefone> telefones;

}
