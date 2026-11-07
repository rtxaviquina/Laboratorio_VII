package com.umg.labsiete.empleado.exception;

public class EmpleadoNotFoundException extends RuntimeException{
    public EmpleadoNotFoundException(Long id){
        super("Empleado con id: "+id+" no existe");
    }
}
