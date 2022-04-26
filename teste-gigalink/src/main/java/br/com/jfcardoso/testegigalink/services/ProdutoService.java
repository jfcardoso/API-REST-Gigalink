package br.com.jfcardoso.testegigalink.services;

import br.com.jfcardoso.testegigalink.entities.Produto;
import br.com.jfcardoso.testegigalink.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Produto getById(Long id) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoOpt.isEmpty()){
            throw new RuntimeException("Produto não encontrado");
        }
        return produtoOpt.get();
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}

