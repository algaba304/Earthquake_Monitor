package com.hackaprende.earthquakemonitor;

public class UsuarioDTO {

    private String idUsuario;
    private String nombre;
    private String nombreUsuaio;
    private String contrasenia;
    private String estadoUsuario;
    private String direccion;
    private int contadorReportes;
    private String fotoPerfilUsuario;
    private String numeroTelefono;
    private String correoEelectronico;
    private String biografia;
    private String fechaNacimiento;
    private RolDTO rol;

    public UsuarioDTO(){

    }

    public UsuarioDTO(String idUsuario, String nombre, String nombreUsuaio, String contrasenia,
                      String estadoUsuario, String direccion, int contadorReportes,
                      String fotoPerfilUsuario, String numeroTelefono, String correoEelectronico,
                      String biografia, String fechaNacimiento, RolDTO rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.nombreUsuaio = nombreUsuaio;
        this.contrasenia = contrasenia;
        this.estadoUsuario = estadoUsuario;
        this.direccion = direccion;
        this.contadorReportes = contadorReportes;
        this.fotoPerfilUsuario = fotoPerfilUsuario;
        this.numeroTelefono = numeroTelefono;
        this.correoEelectronico = correoEelectronico;
        this.biografia = biografia;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuaio() {
        return nombreUsuaio;
    }

    public void setNombreUsuaio(String nombreUsuaio) {
        this.nombreUsuaio = nombreUsuaio;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getContadorReportes() {
        return contadorReportes;
    }

    public void setContadorReportes(int contadorReportes) {
        this.contadorReportes = contadorReportes;
    }

    public String getFotoPerfilUsuario() {
        return fotoPerfilUsuario;
    }

    public void setFotoPerfilUsuario(String fotoPerfilUsuario) {
        this.fotoPerfilUsuario = fotoPerfilUsuario;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCorreoEelectronico() {
        return correoEelectronico;
    }

    public void setCorreoEelectronico(String correoEelectronico) {
        this.correoEelectronico = correoEelectronico;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
    }

    @Override

    public boolean equals(Object o){
        if(this == o) return false;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDTO that = (UsuarioDTO) o;
        return nombreUsuaio.equals(that.nombreUsuaio) && correoEelectronico.equals(that.correoEelectronico);
    }
}
