package br.com.jfcardoso.testegigalink.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private int id;
    private double quantidade;
    private double valor;
}
