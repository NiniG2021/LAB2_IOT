package edu.pucp.lab2_iot.entity;

import java.util.ArrayList;

public class ListaComputadoras {

    public static ArrayList<Computadora> listaComputadoras= new ArrayList<>();

    public static ArrayList<Computadora> getListaComputadoras(){return listaComputadoras;}

    public static void addComputadora(Computadora computadora){listaComputadoras.add(computadora);}

    public static void deleteComputadora(Computadora computadora){listaComputadoras.remove(computadora);}

    //For search specific Computer
    public static Computadora searchComputadora(String activo){
        for(Computadora n: listaComputadoras){
            if(n.getActivo().equalsIgnoreCase(activo)){return n;}
        }
        return null;
    }

    //To send computer list
    public static ArrayList<String> returnComputadoras(){
        ArrayList<String> lista=new ArrayList<>();
        String temp = "";
        for(Computadora n: listaComputadoras){
            temp="";
            temp+="Activo: "+n.getActivo()+"\n";
            temp+="Marca: "+n.getMarca()+"\n";
            temp+="Año: "+n.getAnho()+"\n";
            temp+="CPU: "+n.getCPU()+"\n";
            lista.add(temp);
        }
        return lista;
    }
}
