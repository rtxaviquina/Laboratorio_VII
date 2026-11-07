package com.umg.labsiete.empleado.exception;

public class EmpleadoAlreadyInactiveException extends RuntimeException{
    public EmpleadoAlreadyInactiveException(Long id){
        super("Empleado con id: "+id+" ya esta inactivo");
    }
}
