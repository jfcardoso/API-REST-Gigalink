package br.com.jfcardoso.testegigalink.services;

import br.com.jfcardoso.testegigalink.entities.Transportadora;
import br.com.jfcardoso.testegigalink.repositories.TransportadoraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class TransportadoraServiceTest {

    @Mock
    TransportadoraRepository transportadoraRepository;

    @InjectMocks
    TransportadoraService transportadoraService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_getAll() {
        List<Transportadora> expectedEntities = Collections.singletonList(buildTransportadora("test"));
        when(transportadoraRepository.findAll()).thenReturn(expectedEntities);

        List<Transportadora> responseEntities = transportadoraService.getAll();

        verify(transportadoraRepository, times(1)).findAll();
        assertEquals(expectedEntities, responseEntities);
    }

    @Test
    public void test_getById_withSuccess() {
        Transportadora transportadora = buildTransportadora("test");
        transportadora.setId(102030L);

        when(transportadoraRepository.findById(anyLong())).thenReturn(Optional.of(transportadora));

        Transportadora response = transportadoraService.getById(transportadora.getId());

        verify(transportadoraRepository, times(1)).findById(transportadora.getId());

        assertEquals(transportadora, response);
    }

    @Test
    public void test_getById_whenNotFound() {
        Transportadora transportadora = buildTransportadora("test");
        transportadora.setId(102030L);

        when(transportadoraRepository.getById(transportadora.getId()))
                .thenThrow(new RuntimeException("Transportadora não cadastrada"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            transportadoraService.getById(transportadora.getId());
        });

        verify(transportadoraRepository, times(1)).findById(transportadora.getId());
        assertEquals("Transportadora não cadastrada", exception.getMessage());
    }

    @Test
    public void test_save() {
        Transportadora transportadoraNova = buildTransportadora("test new");
        Transportadora transportadoraSalva = buildTransportadora("test saved");

        when(transportadoraRepository.save(transportadoraNova)).thenReturn(transportadoraSalva);

        Transportadora response = transportadoraService.save(transportadoraNova);

        verify(transportadoraRepository, times(1)).save(transportadoraNova);

        assertEquals(response, transportadoraSalva);

    }

    @Test
    public void test_delete() {
        doNothing().when(transportadoraRepository).deleteById(102030L);

        transportadoraService.delete(102030L);

        verify(transportadoraRepository, times(1)).deleteById(102030L);
    }

    private Transportadora buildTransportadora(String nome) {
        return Transportadora.builder().nome(nome).nome("unit test").build();
    }
}
