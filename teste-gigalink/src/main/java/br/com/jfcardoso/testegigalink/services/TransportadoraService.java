package br.com.jfcardoso.testegigalink.services;

import br.com.jfcardoso.testegigalink.entities.Produto;
import br.com.jfcardoso.testegigalink.entities.Transportadora;
import br.com.jfcardoso.testegigalink.repositories.TransportadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportadoraService {

    @Autowired
    TransportadoraRepository transportadoraRepository;

    public List<Transportadora> getAll() {
        return transportadoraRepository.findAll();
    }

    public Transportadora getById(Long id) {
        return transportadoraRepository.getById(id);
    }

    public Transportadora save(Transportadora transportadora) {
        return transportadoraRepository.save(transportadora);
    }

    public void delete(Long id) {
        transportadoraRepository.deleteById(id);
    }
}
