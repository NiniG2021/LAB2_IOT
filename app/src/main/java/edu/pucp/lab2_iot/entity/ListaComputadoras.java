package edu.pucp.lab2_iot.entity;

import java.util.ArrayList;

public class ListaComputadoras {


    public static ArrayList<Computadora> listaComputadoras= new ArrayList<>();

    public static ArrayList<Computadora> getListaComputadoras(){return listaComputadoras;}

    public static int ret2022(){
        int j = 0;
        for(Computadora i : listaComputadoras){
            if(i.getAnho()==2022){
                j++;
            }
        }
        return j;
    }

    public static void addComputadora(Computadora computadora){
        listaComputadoras.add(computadora);
    }

    public static void deleteComputadora(Computadora computadora){
        listaComputadoras.remove(computadora);
    }

    //For search specific Computer
    public static ArrayList<String>  searchComputadora(String activo){
        ArrayList<String> lista = new ArrayList<>();
        String temp = "";
        for(Computadora n : listaComputadoras){
            if(n.getActivo().equalsIgnoreCase(activo)){
                temp="";
                temp+="Activo: "+n.getActivo()+"\n";
                temp+="Marca: "+marcaValue(n.getMarca())+"\n";
                temp+="Año: "+n.getAnho()+"\n";
                temp+="CPU: "+n.getCPU()+"\n";
                lista.add(temp);
                return lista;
            }
        }
        return lista;
    }

    private static String marcaValue(int i){
        String marcas[] = new String[]{
                "ACER","ASUS", "CORSAIR", "DELL", "HP","LENOVO","APPLE", "MEDION", "MSI", "ZOTAC", "HUAWEI", "Otro"
        };
        return marcas[i];
    }

    //To send computer list
    public static ArrayList<String> returnComputadoras(){
        ArrayList<String> lista=new ArrayList<>();
        String temp = "";
        for(Computadora n: listaComputadoras){
            temp="";
            temp+="Activo: "+n.getActivo()+"\n";
            temp+="Marca: "+marcaValue(n.getMarca())+"\n";
            temp+="Año: "+n.getAnho()+"\n";
            temp+="CPU: "+n.getCPU()+"\n";
            lista.add(temp);
        }
        return lista;
    }
    //For find the orden
    public static Integer obtenerPosicion(String activo){
        for(Computadora computadora: listaComputadoras){
            if(computadora.getActivo().equalsIgnoreCase(activo)){return listaComputadoras.indexOf(computadora);}
        }
        return null;
    }

    public static void updateComputadora(int posicion,Computadora computadora){

        Computadora n=ListaComputadoras.getListaComputadoras().get(posicion);
        n.setActivo(computadora.getActivo());
        n.setMarca(computadora.getMarca());
        n.setAnho(computadora.getAnho());
        n.setCPU(computadora.getCPU());

    }

    public static boolean existComutadora(String activo){
        for(Computadora i : listaComputadoras){
            if(i.getActivo().equalsIgnoreCase(activo)){
                return true;
            }
        }
        return false;
    }
}
