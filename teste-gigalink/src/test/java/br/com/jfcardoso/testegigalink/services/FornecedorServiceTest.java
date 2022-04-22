package br.com.jfcardoso.testegigalink.services;

import br.com.jfcardoso.testegigalink.entities.Fornecedor;
import br.com.jfcardoso.testegigalink.repositories.FornecedorRepository;
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
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class FornecedorServiceTest {

    @Mock
    FornecedorRepository fornecedorRepository;

    @InjectMocks
    FornecedorService fornecedorService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_getAll() {
        List<Fornecedor> expectedEntities = Collections.singletonList(buildFornecedor("test"));
        when(fornecedorRepository.findAll()).thenReturn(expectedEntities);

        List<Fornecedor> responseEntities = fornecedorService.getAll();

        verify(fornecedorRepository, times(1)).findAll();
        assertEquals(expectedEntities, responseEntities);
    }

    @Test
    public void test_getById_withSuccess() {
        Fornecedor fornecedor = buildFornecedor("test");
        fornecedor.setId(102030L);

        when(fornecedorRepository.getById(fornecedor.getId())).thenReturn(fornecedor);

        Fornecedor response = fornecedorService.getById(fornecedor.getId());

        verify(fornecedorRepository, times(1)).getById(fornecedor.getId());

        assertEquals(fornecedor, response);
    }

    @Test
    public void test_getById_whenNotFound() {
        Fornecedor fornecedor = buildFornecedor("test");
        fornecedor.setId(102030L);

        when(fornecedorRepository.getById(fornecedor.getId())).thenThrow(new EntityNotFoundException("Fake Error"));

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            fornecedorService.getById(fornecedor.getId());
        });

        verify(fornecedorRepository, times(1)).getById(fornecedor.getId());
        assertEquals("Fake Error", exception.getMessage());
    }

    @Test
    public void test_save() {
        Fornecedor fornecedorNovo = buildFornecedor("test new");
        Fornecedor fornecedorSalvo = buildFornecedor("test saved");

        when(fornecedorRepository.save(fornecedorNovo)).thenReturn(fornecedorSalvo);

        Fornecedor response = fornecedorService.save(fornecedorNovo);

        verify(fornecedorRepository, times(1)).save(fornecedorNovo);

        assertEquals(response, fornecedorSalvo);

    }

    @Test
    public void test_delete() {
        doNothing().when(fornecedorRepository).deleteById(102030L);

        fornecedorService.delete(102030L);

        verify(fornecedorRepository, times(1)).deleteById(102030L);
    }

    private Fornecedor buildFornecedor(String nome) {
        return Fornecedor.builder().nome(nome).nome("unit test").build();
    }
}
