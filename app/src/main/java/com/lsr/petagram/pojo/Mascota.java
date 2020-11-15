package com.lsr.petagram.pojo;

public class Mascota {
    private String nombre;
    private String tipo;
    private String raza;
    private String edad;
    private String genero;
    private String likes;
    private int foto;

    public Mascota(String nombre, String tipo, String raza, String edad,String genero,String likes,int foto ) {
        this.nombre     = nombre;
        this.tipo       = tipo;
        this.raza       = raza;
        this.edad       = edad;
        this.genero     = genero;
        this.likes       = likes;
        this.foto       = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
