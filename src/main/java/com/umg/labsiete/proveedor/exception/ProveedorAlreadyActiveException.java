package com.umg.labsiete.proveedor.exception;

public class ProveedorAlreadyActiveException extends RuntimeException{
    public ProveedorAlreadyActiveException(Long id){
        super("Proveedor con id: "+id+" ya está activo");
    }
}
