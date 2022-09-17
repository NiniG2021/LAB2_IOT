package edu.pucp.lab2_iot.entity;

import java.util.ArrayList;

public class ListaTeclados {


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

    public static Teclado searchTeclado(String activo){
       for (Teclado tecl: listTeclados){
           if (tecl.getActivo().equalsIgnoreCase(activo)){
               return tecl;
           }

       }
        return null;
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
