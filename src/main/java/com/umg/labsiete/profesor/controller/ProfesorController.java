package com.umg.labsiete.profesor.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umg.labsiete.profesor.model.Profesor;
import com.umg.labsiete.profesor.service.ProfesorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    private final ProfesorService service;

    public ProfesorController(ProfesorService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@Valid @RequestBody Profesor profesor){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearProfesor(profesor));
    }

    @GetMapping
    public ResponseEntity<List<Profesor>> obtenerProfesores(@RequestParam(required = false) String especialidad){
        return ResponseEntity.ok(service.getProfesores(especialidad));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerProfesorPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.getProfesorById(id));
    }

    @GetMapping("/inactivos")
    public ResponseEntity<List<Profesor>> obtenerProfesoresInactivos(@RequestParam(required= false) String especialidad){
        return ResponseEntity.ok(service.getProfesoresInactivos(especialidad));
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Profesor> desactivarProfesor(@PathVariable Long id){
        return ResponseEntity.ok(service.deactivateProfesor(id));
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<Profesor> activarProfesor(@PathVariable Long id){
        return ResponseEntity.ok(service.activateProfesor(id));
    }
}
