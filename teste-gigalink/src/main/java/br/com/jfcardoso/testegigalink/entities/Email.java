package br.com.jfcardoso.testegigalink.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Email {

    private Long id;
    private String email;
    private String referencia;
}
