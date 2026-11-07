package com.umg.labsiete.profesor.service;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Stream;
import org.springframework.stereotype.Service;

import com.umg.labsiete.profesor.exception.ProfesorAlreadyActiveException;
import com.umg.labsiete.profesor.exception.ProfesorAlreadyInactiveException;
import com.umg.labsiete.profesor.exception.ProfesorNotFoundException;
import com.umg.labsiete.profesor.model.Profesor;
import com.umg.labsiete.profesor.model.ProfesorStatus;

@Service 
public class ProfesorService {
    private final List<Profesor> profesores = new ArrayList<>();

    public Profesor crearProfesor(Profesor profesor){
        profesor.setId((long)(profesores.size()+1));
        profesor.setEstado(ProfesorStatus.ACTIVE);
        profesores.add(profesor);
        return profesor;
    }

    public List<Profesor> getProfesores(String especialidad){
        Stream<Profesor> stream = profesores.stream().filter(p->p.getEstado() == ProfesorStatus.ACTIVE);
        if(especialidad != null){
            stream = stream.filter(p->p.getEspecialidad().equalsIgnoreCase(especialidad));
        }
        return stream.toList();
    }

    public List<Profesor> getProfesoresInactivos(String especialidad){
        Stream<Profesor> stream = profesores.stream().filter(p->p.getEstado()== ProfesorStatus.INACTIVE);
        if(especialidad!= null){
            stream = stream.filter(p->p.getEspecialidad().equalsIgnoreCase(especialidad));
        }
        return stream.toList();
    }

    public Profesor getProfesorById(Long id){
        return profesores.stream().filter(p->p.getId().equals(id)).findFirst().orElseThrow(()->new ProfesorNotFoundException(id));
    }

    public Profesor deactivateProfesor(Long id){
        Profesor profesor = getProfesorById(id);

        if(profesor.getEstado() == ProfesorStatus.INACTIVE){
            throw new ProfesorAlreadyInactiveException(id);
        }
        profesor.setEstado(ProfesorStatus.INACTIVE);
        return profesor;
    }

    public Profesor activateProfesor(Long id){
        Profesor profesor = getProfesorById(id);

        if(profesor.getEstado()==ProfesorStatus.ACTIVE){
            throw new ProfesorAlreadyActiveException(id);
        }
        profesor.setEstado(ProfesorStatus.ACTIVE);
        return profesor;
    }
}
