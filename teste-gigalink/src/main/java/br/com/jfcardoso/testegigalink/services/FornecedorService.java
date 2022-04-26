package br.com.jfcardoso.testegigalink.services;

import br.com.jfcardoso.testegigalink.entities.Fornecedor;
import br.com.jfcardoso.testegigalink.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository fornecedorRepository;

    public List<Fornecedor> getAll() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor getById(Long id) {
        Optional<Fornecedor> fornecedorOpt = fornecedorRepository.findById(id);
        if (fornecedorOpt.isEmpty()){
            throw new RuntimeException("Fornecedor não cadastrado");
        }
        return fornecedorOpt.get();
    }

    public Fornecedor save(Fornecedor fornecedor) {

        if (fornecedor.getTelefones()==null || fornecedor.getTelefones().isEmpty()){
            throw new RuntimeException("Telefone não pode ficar em branco");
        }

        fornecedor.getTelefones().forEach(t -> t.setFornecedor(fornecedor));

        if(fornecedor.getEmails()!=null) {
            fornecedor.getEmails().forEach(e -> e.setFornecedor(fornecedor));
        }

        return fornecedorRepository.save(fornecedor);
    }

    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
