package edu.pucp.lab2_iot.entity;

import java.util.ArrayList;

public class CompOli {

    private static ArrayList<Object> listaComputadoras = new ArrayList<>();


    //todo: Para hacer TESTS, se necesita implementar lo que está aqui
    public static ArrayList<String> retListaActivos(){
        ArrayList<String> ret = new ArrayList<>();
        ret.add("Ninguna");

        for(Object i : listaComputadoras){
            //ret.add(i.getActivo);
        }
        return ret;
    }

    public static String retActivoEquipo(int i){
        if(i==0){
            return  "ninguna";
        }

        return "";
    }

}
