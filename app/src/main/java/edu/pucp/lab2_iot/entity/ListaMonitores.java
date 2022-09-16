package edu.pucp.lab2_iot.entity;

import java.util.ArrayList;

public class ListaMonitores {
    public static ArrayList<Monitor> listaMonitores = new ArrayList<>();

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



}
