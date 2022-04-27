package br.com.jfcardoso.testegigalink.services;

import br.com.jfcardoso.testegigalink.entities.Fornecedor;
import br.com.jfcardoso.testegigalink.entities.Item;
import br.com.jfcardoso.testegigalink.entities.Telefone;
import br.com.jfcardoso.testegigalink.repositories.FornecedorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

        when(fornecedorRepository.findById(anyLong())).thenReturn(Optional.of(fornecedor));

        Fornecedor response = fornecedorService.getById(fornecedor.getId());

        verify(fornecedorRepository, times(1)).findById(fornecedor.getId());

        assertEquals(fornecedor, response);
    }

    @Test
    public void test_getById_whenNotFound() {
        Fornecedor fornecedor = buildFornecedor("test");
        fornecedor.setId(102030L);

        when(fornecedorRepository.getById(fornecedor.getId()))
                .thenThrow(new RuntimeException("Fornecedor não cadastrado"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            fornecedorService.getById(fornecedor.getId());
        });

        verify(fornecedorRepository, times(1)).findById(fornecedor.getId());
        assertEquals("Fornecedor não cadastrado", exception.getMessage());
    }

    @Test
    public void test_save() {
        Fornecedor fornecedorNovo = buildFornecedor("test new");
        Fornecedor fornecedorSalvo = buildFornecedor("test saved");

        List<Telefone> telefones = buildTelefone("22", "2522-0000", "Principal");
        fornecedorNovo.setTelefones(telefones);

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
        return Fornecedor.builder()
                .nome(nome)
                .nome("unit test")
                .build();
    }

    private List<Telefone> buildTelefone(String ddd, String numero, String referencia) {
        return Collections.singletonList(Telefone.builder()
                .ddd(ddd)
                .numero(numero)
                .referencia(referencia)
                .build());
    }
}
