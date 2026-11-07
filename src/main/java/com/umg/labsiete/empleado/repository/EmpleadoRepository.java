package com.umg.labsiete.empleado.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.umg.labsiete.empleado.model.Empleado;

@Repository 
public class EmpleadoRepository {
    private final List<Empleado> empleados = new ArrayList<>();
    
    public Empleado save(Empleado empleado){
        empleados.add(empleado);
        return empleado;
    }

    public List<Empleado> getEmpleadosList(){
        return empleados;
    }
}
