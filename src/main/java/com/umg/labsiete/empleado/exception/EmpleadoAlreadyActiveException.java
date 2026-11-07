package com.umg.labsiete.empleado.exception;

public class EmpleadoAlreadyActiveException extends RuntimeException{
    public EmpleadoAlreadyActiveException(Long id){
        super("Empleado con id: "+id+" ya esta activo");
    }
}
