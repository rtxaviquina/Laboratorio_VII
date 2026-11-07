package com.umg.labsiete.proveedor.service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import com.umg.labsiete.proveedor.exception.ProveedorAlreadyActiveException;
import com.umg.labsiete.proveedor.exception.ProveedorAlreadyInactiveException;
import com.umg.labsiete.proveedor.exception.ProveedorNotFoundException;
import com.umg.labsiete.proveedor.model.Proveedor;
import com.umg.labsiete.proveedor.model.ProveedorStatus;

@Service
public class ProveedorService {
    private final List<Proveedor> proveedores = new ArrayList<>();

    public Proveedor createProveedor(Proveedor proveedor){
        proveedor.setId((long) proveedores.size()+1);
        proveedor.setEstado(ProveedorStatus.ACTIVE);
        proveedores.add(proveedor);
        return proveedor;
    }

    public List<Proveedor> getProveedores(String categoria){
        Stream<Proveedor> stream = proveedores.stream().filter(p->p.getEstado() == ProveedorStatus.ACTIVE);
        if(categoria != null){
            stream = stream.filter(p->p.getCategoria().equalsIgnoreCase(categoria));
        }
        return stream.toList();
    }

    public List<Proveedor> getProveedoresInactivos(String categoria){
        Stream<Proveedor> stream = proveedores.stream().filter(p->p.getEstado() == ProveedorStatus.INACTIVE);
        if(categoria != null){
            stream = stream.filter(p->p.getCategoria().equalsIgnoreCase(categoria));
        }
        return stream.toList();
    }

    public Proveedor getProveedorById(Long id){
        return proveedores.stream().filter(p->p.getId().equals(id)).findFirst().orElseThrow(()->new ProveedorNotFoundException(id));
    }

    public Proveedor deactivateProveedor(Long id){
        Proveedor proveedor = getProveedorById(id);
        if(proveedor.getEstado() == ProveedorStatus.INACTIVE){
            throw new ProveedorAlreadyInactiveException(id);
        }
        proveedor.setEstado(ProveedorStatus.INACTIVE);
        return proveedor;
    }

    public Proveedor activateProveedor(Long id){
        Proveedor proveedor = getProveedorById(id);
        if(proveedor.getEstado() == ProveedorStatus.ACTIVE){
            throw new ProveedorAlreadyActiveException(id);
        }

        proveedor.setEstado(ProveedorStatus.ACTIVE);
        return proveedor;
    }
}
