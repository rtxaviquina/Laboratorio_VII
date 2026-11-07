package com.umg.labsiete.profesor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.umg.labsiete.profesor.exception.ProfesorNotFoundException;
import com.umg.labsiete.profesor.model.Profesor;
import com.umg.labsiete.profesor.service.ProfesorService;

public class ProfesorServiceTest {
    private final ProfesorService service = new ProfesorService();

    @Test
    void crearProfesor(){
        Profesor profesor = new Profesor();
        profesor.setNombre("Maria");
        profesor.setApellido("Perla");
        Profesor resultado = service.crearProfesor(profesor);
        assertNotNull(resultado.getId());
    }

    @Test
    void ObtenerProfesorExistente(){
        Profesor profesor = new Profesor();
        profesor.setNombre("Maria");
        profesor.setApellido("Perla");
        service.crearProfesor(profesor);
        Profesor encontrado = service.getProfesorById(1L);
        assertEquals("Maria", encontrado.getNombre());
    }

    @Test
    void obtenerProfesorInexistente(){
        assertThrows(ProfesorNotFoundException.class, ()-> service.getProfesorById(23L));
    }
}
