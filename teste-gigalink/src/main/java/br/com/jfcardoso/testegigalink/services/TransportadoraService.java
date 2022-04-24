package br.com.jfcardoso.testegigalink.services;

import br.com.jfcardoso.testegigalink.controllers.TransportadoraRequestDTO;
import br.com.jfcardoso.testegigalink.entities.Produto;
import br.com.jfcardoso.testegigalink.entities.Transportadora;
import br.com.jfcardoso.testegigalink.repositories.TransportadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportadoraService {

    @Autowired
    TransportadoraRepository transportadoraRepository;

    public List<Transportadora> getAll() {
        return transportadoraRepository.findAll();
    }

    public Transportadora getById(Long id) {
       Optional<Transportadora> transportadoraOpt = transportadoraRepository.findById(id);
       if (transportadoraOpt.isEmpty()){
           throw new RuntimeException("Transportadora não cadastrada");
       }
       return transportadoraOpt.get();
    }

    public Transportadora save(Transportadora transportadora) {
        return transportadoraRepository.save(transportadora);
    }

    public Transportadora create (TransportadoraRequestDTO transportadoraDTO){
        return this.save(Transportadora.builder().nome(transportadoraDTO.getNome()).build());
    }

    public Transportadora update (Long id, TransportadoraRequestDTO transportadoraDTO){
        Transportadora transportadoraSalva = this.getById(id);
        transportadoraSalva.setNome(transportadoraDTO.getNome());
        return this.save(transportadoraSalva);
    }

    public void delete(Long id) {
        transportadoraRepository.deleteById(id);
    }
}
