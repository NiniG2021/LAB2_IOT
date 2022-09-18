package edu.pucp.lab2_iot.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaTeclados implements Serializable {


    public static ArrayList<Teclado> listTeclados= new ArrayList<>();

    public static ArrayList<Teclado> getListTeclados() {
        return listTeclados;
    }

    public static void addTeclado(Teclado teclado){
        listTeclados.add(teclado);
    }

    public static void deleteTeclado(Teclado teclado){
        listTeclados.remove(teclado);
    }


    //For search specific Computer
    public static Integer obtenerPosicion(String activo){
        for(Teclado tec: listTeclados){
            if(tec.getActivo().equalsIgnoreCase(activo)){return listTeclados.indexOf(tec);}
        }
        return null;
    }

    public static ArrayList<String> searchTeclado(String activo){
        ArrayList<String> ret = new ArrayList<>();
        String desc = "";
        for(Teclado tecl : listTeclados){
            if(tecl.getActivo().equalsIgnoreCase(activo)){
                desc="";
                desc+="Activo: "+tecl.getActivo()+"\n";
                desc+="PC: "+tecl.getPcactiv()+"\n";
                desc+="Marca: "+tecl.getMarca()+"\n";
                desc+="Año: "+tecl.getAnio()+"\n";
                desc+="Idioma"+tecl.getIdioma()+"\n";
                desc+="Modelo: "+tecl.getModelo()+"\n";
                ret.add(desc);
                return ret;
            }
        }
        return ret;
    }


    public static ArrayList<String> descripTeclados(){
        ArrayList<String> listaTecl = new ArrayList<>();
        String desc = "";
        for(Teclado tecl : listTeclados){
            desc="";
            desc+="Activo: "+tecl.getActivo()+"\n";
            desc+="PC: "+tecl.getPcactiv()+"\n";
            desc+="Marca: "+tecl.getMarca()+"\n";
            desc+="Año: "+tecl.getAnio()+"\n";
            desc+="Idioma"+tecl.getIdioma()+"\n";
            desc+="Modelo: "+tecl.getModelo()+"\n";
            listaTecl.add(desc);
        }
        return listaTecl;
    }
}
