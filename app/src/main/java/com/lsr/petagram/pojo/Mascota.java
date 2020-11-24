package com.lsr.petagram.pojo;

public class Mascota {
    private int id;
    private String nombre;
    private int likes = 0;
    private int foto;

    public Mascota(){

    }
    public Mascota(String nombre, int likes,int foto ) {
        this.nombre     = nombre;
        this.likes       = likes;
        this.foto       = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
