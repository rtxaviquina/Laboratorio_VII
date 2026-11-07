package com.umg.labsiete.empleado.controller;

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

import com.umg.labsiete.empleado.model.Empleado;
import com.umg.labsiete.empleado.service.EmpleadoService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/empleados")
public class EmpleadoController {
    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@Valid @RequestBody Empleado empleado){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearEmpleado(empleado));
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> obtenerEmpleados(@RequestParam (required = false) String especialidad){
        return ResponseEntity.ok(service.getEmpleados(especialidad));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.getEmpleadoById(id));
    }

    @GetMapping("/inactivos")
    public ResponseEntity<List<Empleado>> obtenerEmpleadosInactivos(@RequestParam (required = false) String especialidad){
        return ResponseEntity.ok(service.getEmpleadosInactivos(especialidad));
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Empleado> desactivarEmpleado(@PathVariable Long id){
        return ResponseEntity.ok(service.deactivateEmpleado(id));
    }

    @PatchMapping ("/{id}/activar")
    public ResponseEntity<Empleado> activarEmpleado(@PathVariable Long id){
        return ResponseEntity.ok(service.activateEmpleado(id));
    }
}
