package edu.pucp.lab2_iot.entity;


import java.io.Serializable;

public class Teclado implements Serializable {


    public Teclado(String activo, String pcactiv, String marca, Integer anio, String idioma, String modelo) {
        this.activo = activo;
        this.pcactiv = pcactiv;
        this.marca = marca;
        this.anio = anio;
        this.idioma = idioma;
        this.modelo = modelo;
    }

    public String activo;
    public String pcactiv;
    public String marca;
    public Integer anio;
    public String idioma;



    public String getPcactiv() {
        return pcactiv;
    }

    public void setPcactiv(String pcactiv) {
        this.pcactiv = pcactiv;
    }



    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String modelo;



}

