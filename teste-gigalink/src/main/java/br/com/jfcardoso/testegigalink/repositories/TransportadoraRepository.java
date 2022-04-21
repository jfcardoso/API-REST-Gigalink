package br.com.jfcardoso.testegigalink.repositories;

import br.com.jfcardoso.testegigalink.entities.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {
}
