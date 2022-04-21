package br.com.jfcardoso.testegigalink.services;

import br.com.jfcardoso.testegigalink.entities.Pedido;
import br.com.jfcardoso.testegigalink.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

   @Autowired
   PedidoRepository pedidoRepository;

    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }

    public Pedido getById(Long id) {
        return pedidoRepository.getById(id);
    }

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }

  }
