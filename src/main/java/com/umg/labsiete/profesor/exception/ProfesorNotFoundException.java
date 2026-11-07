package com.umg.labsiete.profesor.exception;

public class ProfesorNotFoundException extends RuntimeException {
    public ProfesorNotFoundException(Long id){
        super("Profesor no encontrado con el id: "+id);
    }
}
