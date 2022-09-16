package edu.pucp.lab2_iot.entity;

import java.io.Serializable;

public class Monitor implements Serializable {
    public Monitor(String activo, String pcActivo, String marca, double pulgadas, int ano, String modelo) {
        this.activo = activo;
        this.pcActivo = pcActivo;
        this.marca = marca;
        this.pulgadas = pulgadas;
        this.ano = ano;
        this.modelo = modelo;
    }

    private String activo;
    private String  pcActivo;
    private String marca;
    private double pulgadas;
    private int ano;
    private String modelo;




    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getPcActivo() {
        return pcActivo;
    }

    public void setPcActivo(String pcActivo) {
        this.pcActivo = pcActivo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(double pulgadas) {
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
