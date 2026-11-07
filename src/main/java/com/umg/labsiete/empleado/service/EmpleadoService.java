package com.umg.labsiete.empleado.service;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Stream;
import org.springframework.stereotype.Service;

import com.umg.labsiete.empleado.exception.EmpleadoAlreadyActiveException;
import com.umg.labsiete.empleado.exception.EmpleadoAlreadyInactiveException;
import com.umg.labsiete.empleado.exception.EmpleadoNotFoundException;
import com.umg.labsiete.empleado.model.Empleado;
import com.umg.labsiete.empleado.model.EmpleadoStatus;

@Service
public class EmpleadoService {
    private final List<Empleado> empleados = new ArrayList<>();

    public Empleado crearEmpleado(Empleado empleado){
        empleado.setId((long)(empleados.size()+1));
        empleado.setEstado(EmpleadoStatus.ACTIVE);
        empleados.add(empleado);
        return empleado;
    }

    public List<Empleado> getEmpleados(String especialidad){
        Stream<Empleado> stream = empleados.stream().filter(p->p.getEstado() == EmpleadoStatus.ACTIVE);
        if(especialidad != null){
            stream = stream.filter(p->p.getEspecialidad().equalsIgnoreCase(especialidad));
        }
        return stream.toList();
    }

    public List<Empleado> getEmpleadosInactivos(String especialidad){
        Stream<Empleado> stream = empleados.stream().filter(p->p.getEstado() == EmpleadoStatus.INACTIVE);
        if(especialidad != null){
            stream = stream.filter(p->p.getEspecialidad().equalsIgnoreCase(especialidad));
        }
        return stream.toList();
    }

    public Empleado getEmpleadoById(Long id){
        return empleados.stream().filter(p->p.getId().equals(id)).findAny().orElseThrow(()->new EmpleadoNotFoundException(id));
    }

    public Empleado deactivateEmpleado(Long id){
        Empleado empleado = getEmpleadoById(id);
        if(empleado.getEstado() == EmpleadoStatus.INACTIVE){
            throw new EmpleadoAlreadyInactiveException(id);
        }
        empleado.setEstado(EmpleadoStatus.INACTIVE);
        return empleado;
    }

    public Empleado activateEmpleado(Long id){
        Empleado empleado = getEmpleadoById(id);
        if(empleado.getEstado() == EmpleadoStatus.ACTIVE){
            throw new EmpleadoAlreadyActiveException(id);
        }
        empleado.setEstado(EmpleadoStatus.ACTIVE);
        return empleado;
    }
}
