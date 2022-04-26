package br.com.jfcardoso.testegigalink.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataHora;
    @NotEmpty
    @Size(max =80)
    private String notaFiscal;
    @NotNull
    @Builder.Default
    private BigDecimal valorFrete= new BigDecimal(0);
    @NotNull
    @Builder.Default
    private BigDecimal desconto= new BigDecimal(0);
    @NotNull
    @Builder.Default
    private BigDecimal valorTotal = new BigDecimal(0);
    @ManyToOne(fetch = FetchType.LAZY)
    Transportadora transportadora;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    List<Item> itens;

}
