package br.com.jfcardoso.testegigalink.repositories;

import br.com.jfcardoso.testegigalink.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
}
