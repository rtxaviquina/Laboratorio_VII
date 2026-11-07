package com.umg.labsiete.profesor.repository;

import java.util.ArrayList;
import java.util.List;

import com.umg.labsiete.profesor.model.Profesor;

public class ProfesorRepository {
    private final List<Profesor> profesores = new ArrayList<>();

    public Profesor save(Profesor profesor){
        profesores.add(profesor);
        return profesor;
    }

    public List<Profesor> getProfesoresList(){
        return profesores;
    }
}
