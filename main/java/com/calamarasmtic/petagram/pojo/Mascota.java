package com.calamarasmtic.petagram.pojo;

/**
 * Created by Calamar Asmàtic on 30/10/2016.
 */

public class Mascota {

    private int foto;
    private String nombre;
    private int votos;

    public Mascota(int foto, String nombre, int votos){
        this.foto = foto;
        this.nombre = nombre;
        this.votos = votos;
    }

    public Mascota(int foto, int votos){
        this.foto = foto;
        this.votos = votos;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public  void upRatePet(Mascota m){
        int v = m.getVotos();
        setVotos(v+=1);
    }
}
