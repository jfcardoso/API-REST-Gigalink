package br.com.jfcardoso.testegigalink.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 3, max = 200)
    private String nome;
    private String descricao;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String cidade;
    @NotEmpty
    @Size(min = 3, max = 200)
    private String endereco;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String bairro;
    @NotNull
    private Integer numero;
    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<Email> emails;
    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<Telefone> telefones;

}
