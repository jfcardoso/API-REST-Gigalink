package br.com.jfcardoso.testegigalink.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String referencia;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    Fornecedor fornecedor;

}
