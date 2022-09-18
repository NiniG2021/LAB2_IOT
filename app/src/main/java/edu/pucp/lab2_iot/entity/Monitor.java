package edu.pucp.lab2_iot.entity;

import java.io.Serializable;

public class Monitor implements Serializable {
    public Monitor(String activo, int pcActivo, int marca, int pulgadas, int ano, String modelo) {
        this.activo = activo;
        this.pcActivo = pcActivo;
        this.marca = marca;
        this.pulgadas = pulgadas;
        this.ano = ano;
        this.modelo = modelo;
    }

    private String activo;
    private int  pcActivo;
    private int marca;
    private int pulgadas;
    private int ano;
    private String modelo;




    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public int getPcActivo() {
        return pcActivo;
    }

    public void setPcActivo(int pcActivo) {
        this.pcActivo = pcActivo;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


}
