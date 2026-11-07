package com.umg.labsiete.proveedor.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Proveedor {
    private Long id;

    @NotBlank(message ="El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @Email(message = "Correo no válido")
    private String correo;

    private String categoria;
    private ProveedorStatus estado;

    public Proveedor(){}

    public Proveedor(Long id, String nombre, String apellido, String correo, String categoria, ProveedorStatus estado){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.categoria = categoria;
        this.estado = estado;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getApellido(){
        return apellido;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setEstado(ProveedorStatus estado){
        this.estado = estado;
    }

    public ProveedorStatus getEstado(){
        return estado;
    }
}
