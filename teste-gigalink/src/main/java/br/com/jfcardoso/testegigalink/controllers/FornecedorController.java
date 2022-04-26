package br.com.jfcardoso.testegigalink.controllers;

import br.com.jfcardoso.testegigalink.entities.Fornecedor;
import br.com.jfcardoso.testegigalink.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> findAll() {
        return fornecedorService.getAll();
    }

    @GetMapping("/{id}")
    public Fornecedor getById(@PathVariable Long id) {
        return fornecedorService.getById(id);
    }

    @PostMapping
    public Fornecedor createFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.save(fornecedor);
    }

    @PutMapping("/{id}")
    public Fornecedor updateFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        fornecedor.setId(id);
        return fornecedorService.save(fornecedor);
    }

    @DeleteMapping("/{id}")
    public void deleteFornecedor(@PathVariable Long id) {
        fornecedorService.delete(id);
    }

}
