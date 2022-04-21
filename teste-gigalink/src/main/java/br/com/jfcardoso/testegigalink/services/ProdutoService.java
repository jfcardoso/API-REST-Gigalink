package br.com.jfcardoso.testegigalink.services;

import br.com.jfcardoso.testegigalink.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    // continuar implementação...
}
