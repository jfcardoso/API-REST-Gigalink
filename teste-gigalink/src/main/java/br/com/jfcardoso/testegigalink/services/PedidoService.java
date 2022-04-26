package br.com.jfcardoso.testegigalink.services;

import br.com.jfcardoso.testegigalink.entities.Fornecedor;
import br.com.jfcardoso.testegigalink.entities.Pedido;
import br.com.jfcardoso.testegigalink.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

   @Autowired
   PedidoRepository pedidoRepository;

    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }

    public Pedido getById(Long id) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findById(id);
        if (pedidoOpt.isEmpty()){
            throw new RuntimeException("Pedido não cadastrado");
        }
        return pedidoOpt.get();
    }

    public Pedido save(Pedido pedido) {
        if (pedido.getItens()==null || pedido.getItens().isEmpty()){
            throw new RuntimeException("É necessário pelo menos um item no Pedido.");
        }
        pedido.getItens().forEach(i -> i.setPedido(pedido));
        if (pedido.getDataHora()== null){
            pedido.setDataHora(new Date());
        }
        return pedidoRepository.save(pedido);
    }

    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }

  }
