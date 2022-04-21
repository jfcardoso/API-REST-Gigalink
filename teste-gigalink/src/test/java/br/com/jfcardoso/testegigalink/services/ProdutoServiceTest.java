package br.com.jfcardoso.testegigalink.services;

import br.com.jfcardoso.testegigalink.entities.Produto;
import br.com.jfcardoso.testegigalink.repositories.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ProdutoServiceTest {

    @Mock
    ProdutoRepository produtoRepository;

    @InjectMocks
    ProdutoService produtoService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_getAll() {
        List<Produto> expectedEntities = Collections.singletonList(buildProduto("test"));
        when(produtoRepository.findAll()).thenReturn(expectedEntities);

        List<Produto> responseEntities = produtoService.getAll();

        verify(produtoRepository, times(1)).findAll();
        assertEquals(expectedEntities, responseEntities);
    }

    @Test
    public void test_getById_withSuccess() {
       Produto produto = buildProduto("test");
       produto.setId(102030L);

        when(produtoRepository.getById(produto.getId())).thenReturn(produto);

        Produto response = produtoService.getById(produto.getId());

        verify(produtoRepository, times(1)).getById(produto.getId());

        assertEquals(produto, response);
    }

    @Test
    public void test_getById_whenNotFound() {
        Produto produto = buildProduto("test");
        produto.setId(102030L);

        when(produtoRepository.getById(produto.getId())).thenThrow(new EntityNotFoundException("Fake Error"));

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            produtoService.getById(produto.getId());
        });

        verify(produtoRepository, times(1)).getById(produto.getId());
        assertEquals("Fake Error", exception.getMessage());
    }

    @Test
    public void test_save() {
        Produto produtoNovo = buildProduto("test new");
        Produto produtoSalvo = buildProduto("test saved");

        when(produtoRepository.save(produtoNovo)).thenReturn(produtoSalvo);

        Produto response = produtoService.save(produtoNovo);

        verify(produtoRepository, times(1)).save(produtoNovo);

        assertEquals(response, produtoSalvo);
    }

    @Test
    public void test_delete() {
        doNothing().when(produtoRepository).deleteById(102030L);

        produtoService.delete(102030L);

        verify(produtoRepository, times(1)).deleteById(102030L);
    }

    private Produto buildProduto(String nome) {
        return Produto.builder().nome(nome).descricao("unit test").build();
    }
}
