package edu.pucp.lab2_iot.entity;


import java.io.Serializable;

public class Teclado implements Serializable {

    public String activo;
    //public Computadora computadora;
    public String marca;
    public Integer anio;
    public String idioma;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    //public Computadora getComputadora() {
    //    return computadora;
    //}

    //public void setComputadora(Computadora computadora) {
    //    this.computadora = computadora;
    //}

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

