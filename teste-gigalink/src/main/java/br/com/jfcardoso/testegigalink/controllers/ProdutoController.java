package br.com.jfcardoso.testegigalink.controllers;

import br.com.jfcardoso.testegigalink.entities.Produto;
import br.com.jfcardoso.testegigalink.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public List<Produto> findAll() {
        return produtoService.getAll();
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable Long id) {
        return produtoService.getById(id);
    }

    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/{id}")
    public Produto updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId(id);
        return produtoService.save(produto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoService.delete(id);
    }

}
