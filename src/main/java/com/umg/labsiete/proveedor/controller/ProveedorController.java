package com.umg.labsiete.proveedor.controller;

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

import com.umg.labsiete.proveedor.model.Proveedor;
import com.umg.labsiete.proveedor.service.ProveedorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {
    private final ProveedorService service;

    public ProveedorController(ProveedorService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Proveedor> crearProveedor(@Valid @RequestBody Proveedor proveedor){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createProveedor(proveedor));
    }

    @GetMapping
    public ResponseEntity<List<Proveedor>> obtenerProveedores(@RequestParam (required = false) String categoria){
        return ResponseEntity.ok(service.getProveedores(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.getProveedorById(id));
    }

    @GetMapping("/inactivos")
    public ResponseEntity<List<Proveedor>> obtenerProveedoresInactivos(@RequestParam (required = false) String categoria){
        return ResponseEntity.ok(service.getProveedoresInactivos(categoria));
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Proveedor> desactivarProveedor(@PathVariable Long id){
        return ResponseEntity.ok(service.deactivateProveedor(id));
    }

    @PatchMapping ("/{id}/activar")
    public ResponseEntity<Proveedor> activarProveedor(@PathVariable Long id){
        return ResponseEntity.ok(service.activateProveedor(id));
    }
}
