package br.com.jfcardoso.testegigalink.controllers;

import br.com.jfcardoso.testegigalink.entities.Transportadora;
import br.com.jfcardoso.testegigalink.services.TransportadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportadora")
public class TransportadoraController {

    @Autowired
    TransportadoraService transportadoraService;

    @GetMapping
    public List<Transportadora> findAll() {
        return transportadoraService.getAll();
    }

    @GetMapping("/{id}")
    public Transportadora getById(@PathVariable Long id) {
        return transportadoraService.getById(id);
    }

    @PostMapping
    public Transportadora createTransportadora(@RequestBody TransportadoraRequestDTO transportadoraDTO) {
        return transportadoraService.create(transportadoraDTO);
    }

    @PutMapping("/{id}")
    public Transportadora updateTransportadora(@PathVariable Long id, @RequestBody TransportadoraRequestDTO transportadoraDTO) {
        return transportadoraService.update(id, transportadoraDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTransportadora(@PathVariable Long id) {
        transportadoraService.delete(id);
    }

}
