package br.com.jfcardoso.testegigalink.services;

import br.com.jfcardoso.testegigalink.entities.Pedido;
import br.com.jfcardoso.testegigalink.repositories.PedidoRepository;
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

public class PedidoServiceTest {

    @Mock
    PedidoRepository pedidoRepository;

    @InjectMocks
    PedidoService pedidoService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_getAll() {
        List<Pedido> expectedEntities = Collections.singletonList(buildPedido("test"));
        when(pedidoRepository.findAll()).thenReturn(expectedEntities);

        List<Pedido> responseEntities = pedidoService.getAll();

        verify(pedidoRepository, times(1)).findAll();
        assertEquals(expectedEntities, responseEntities);
    }

    @Test
    public void test_getById_withSuccess() {
        Pedido pedido = buildPedido("test");
        pedido.setId(102030L);

        when(pedidoRepository.getById(pedido.getId())).thenReturn(pedido);

        Pedido response = pedidoService.getById(pedido.getId());

        verify(pedidoRepository, times(1)).getById(pedido.getId());

        assertEquals(pedido, response);
    }

    @Test
    public void test_getById_whenNotFound() {
        Pedido pedido = buildPedido("test");
        pedido.setId(102030L);

        when(pedidoRepository.getById(pedido.getId())).thenThrow(new EntityNotFoundException("Fake Error"));

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            pedidoService.getById(pedido.getId());
        });

        verify(pedidoRepository, times(1)).getById(pedido.getId());
        assertEquals("Fake Error", exception.getMessage());
    }

    @Test
    public void test_save() {
        Pedido pedidoNovo = buildPedido("test new");
        Pedido pedidoSalvo = buildPedido("test saved");

        when(pedidoRepository.save(pedidoNovo)).thenReturn(pedidoSalvo);

        Pedido response = pedidoService.save(pedidoNovo);

        verify(pedidoRepository, times(1)).save(pedidoNovo);

        assertEquals(response, pedidoSalvo);

    }

    @Test
    public void test_delete() {
        doNothing().when(pedidoRepository).deleteById(102030L);

        pedidoService.delete(102030L);

        verify(pedidoRepository, times(1)).deleteById(102030L);
    }

    private Pedido buildPedido(String nota) {
        return Pedido.builder().notaFiscal(nota).notaFiscal("unit test").build();
    }
}
