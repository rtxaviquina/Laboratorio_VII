package com.umg.labsiete.proveedor.exception;

public class ProveedorAlreadyInactiveException extends RuntimeException{
    public ProveedorAlreadyInactiveException(Long id){
        super("El proveedor con id: "+id+" ya esta inactivo");
    }
}
