package com.digis01.PokeApiClient.ML;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;


public class Usuario {

    private int idUsuario;
    
    private String nombreUsuario;
    
    private String apellidoPatUsuario;
    
    private String apellidoMatUsuario;
    
    private String userName;
    
    private String telefonoUsuario;
    
    private String emailUsuario;
    
    private String passwordUsuario;
    
    private List<Favorito> favoritos = new ArrayList<>();
    
    @JsonProperty("RolJPA")
    public Rol Rol;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoPatUsuario() {
        return apellidoPatUsuario;
    }

    public void setApellidoPatUsuario(String apellidoPatUsuario) {
        this.apellidoPatUsuario = apellidoPatUsuario;
    }

    public String getApellidoMatUsuario() {
        return apellidoMatUsuario;
    }

    public void setApellidoMatUsuario(String apellidoMatUsuario) {
        this.apellidoMatUsuario = apellidoMatUsuario;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public Rol getRol() {
        return Rol;
    }

    public void setRol(Rol Rol) {
        this.Rol = Rol;
    }

    public List<Favorito> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<Favorito> favoritos) {
        this.favoritos = favoritos;
    }
   
    
}
