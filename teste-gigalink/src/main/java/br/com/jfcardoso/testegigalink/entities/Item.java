package br.com.jfcardoso.testegigalink.entities;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Item {
    private Long id;
    private double quantidade;
    private BigDecimal valor;
}
