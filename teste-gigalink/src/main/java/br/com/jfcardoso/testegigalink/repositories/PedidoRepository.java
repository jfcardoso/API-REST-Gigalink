package br.com.jfcardoso.testegigalink.repositories;

import br.com.jfcardoso.testegigalink.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
