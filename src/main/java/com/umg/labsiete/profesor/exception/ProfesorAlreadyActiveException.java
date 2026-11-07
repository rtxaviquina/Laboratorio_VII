package com.umg.labsiete.profesor.exception;

public class ProfesorAlreadyActiveException extends RuntimeException{
    public ProfesorAlreadyActiveException(Long id){
        super("El profesor con id: "+id+" ya está activo");
    }
}
