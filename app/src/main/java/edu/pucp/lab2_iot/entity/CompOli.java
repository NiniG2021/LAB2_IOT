package edu.pucp.lab2_iot.entity;

import java.util.ArrayList;

public class CompOli {

    private static ArrayList<Computadora> listaComputadoras = ListaComputadoras.getListaComputadoras();

    public static ArrayList<String> retListaActivos(){
        ArrayList<String> ret = new ArrayList<>();
        ret.add("PC activo:");
        ret.add("Ninguna");
        for(Computadora i : listaComputadoras){
            ret.add(i.getActivo());
        }
        return ret;
    }

    public static String retActivoEquipo(int i){
        if(i==0){
            return  "ninguna";
        }else{
            return listaComputadoras.get(i-1).getActivo();
        }
    }

}
