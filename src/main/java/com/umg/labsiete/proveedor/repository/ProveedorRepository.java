package com.umg.labsiete.proveedor.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.umg.labsiete.proveedor.model.Proveedor;

@Repository
public class ProveedorRepository {
    private final List<Proveedor> proveedores = new ArrayList<>();

    public Proveedor save(Proveedor proveedor){
        proveedores.add(proveedor);
        return proveedor;
    }

    public List<Proveedor> getProveedorList(){
        return proveedores;
    }
}
