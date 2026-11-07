package com.umg.labsiete.empleado.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Empleado {
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @Email(message = "Correo no valido")
    private String correo;
    private String especialidad;
    private EmpleadoStatus estado;

    public Empleado(){}

    public Empleado(Long id, String nombre, String apellido, String correo, String especialidad, EmpleadoStatus estado){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.especialidad = especialidad;
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

    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }

    public String getEspecialidad(){
        return especialidad;
    }

    public void setEstado(EmpleadoStatus estado){
        this.estado = estado;
    }

    public EmpleadoStatus getEstado(){
        return estado;
    }

}
