package com.hackaprende.earthquakemonitor;

public class RolDTO {

    private String idRol;
    private String nombre;

    public RolDTO(){

    }

    public RolDTO(String idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
