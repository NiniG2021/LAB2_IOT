package edu.pucp.lab2_iot.entity;

import java.util.ArrayList;

public class ListaMonitores {

    public static ArrayList<Monitor> listaMonitores = new ArrayList<>();

    public static ArrayList<String> descpMonitores = new ArrayList<>();

    public static ArrayList<Monitor> returnList(){
        return listaMonitores;
    }

    public static void addMonitor(Monitor monitor){
        listaMonitores.add(monitor);
    }

    public static void deleteMonitor(Monitor monitor){
        listaMonitores.remove(monitor);
    }

    public static Monitor searchMonitor(String activo){
        for(Monitor i : listaMonitores){
            if(i.getActivo().equalsIgnoreCase(activo)){
                return i;
            }
        }
        return null;
    }

    public static ArrayList<String> retDescpMonitores(){
        ArrayList<String> lista = new ArrayList<>();
        String desc = "";
        for(Monitor i : listaMonitores){
            desc="";
            desc+="Activo: "+i.getActivo()+"\n";
            desc+="PC: "+i.getPcActivo()+"\n";
            desc+="Marca: "+i.getMarca()+"\n";
            desc+="Pulgadas: "+i.getPulgadas()+"\n";
            desc+="Año: "+i.getAno()+"\n";
            desc+="Modelo: "+i.getModelo()+"\n";
            lista.add(desc);
        }
        return lista;
    }



}
