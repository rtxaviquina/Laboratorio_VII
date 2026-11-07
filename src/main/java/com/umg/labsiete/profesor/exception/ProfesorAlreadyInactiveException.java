package com.umg.labsiete.profesor.exception;

public class ProfesorAlreadyInactiveException extends RuntimeException{
    public ProfesorAlreadyInactiveException(Long id){
        super("El profesor con id: "+id+ " ya se encuentra inactivo");
    }
}
