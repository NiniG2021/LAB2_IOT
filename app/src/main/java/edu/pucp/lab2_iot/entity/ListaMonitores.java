package edu.pucp.lab2_iot.entity;

import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.pucp.lab2_iot.MonitorMenu;

public class ListaMonitores {

    public static ArrayList<Monitor> listaMonitores = new ArrayList<>();

    public static ArrayList<Monitor> getlistamonitores(){return listaMonitores;}

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


    private static String marcaValue(int i){
        String marcas[] = new String[]{
                "Apple","DELL", "LG", "Samsung", "Microsoft"
        };
        return marcas[i];
    }

    private static String pulgadasValue(int i){
        String pulgadas[] = new String[]{
                "14","17","20","24"
        };
        return pulgadas[i];
    }



    public static boolean existMonitor(String activo){
        for(Monitor i : listaMonitores){
            if(i.getActivo().equalsIgnoreCase(activo)){
                return true;
            }
        }
        return false;
    }

    public static Monitor findMonitorSave(String activo){
        Monitor ret = null;
        //String msg="nada";
        for(Monitor i : listaMonitores){
            //msg=i.getActivo()+" !=? "+activo;
            if(i.getActivo().equals(activo)){
                //msg="Paso";
                return i;
            }
        }
        return new Monitor("ERROR",0,0,0,0,"No");
    }

    public static ArrayList<String> searchMonitor(String activo){
        ArrayList<String> ret = new ArrayList<>();
        String desc = "";
        for(Monitor i : listaMonitores){
            if(i.getActivo().equalsIgnoreCase(activo)){
                desc="";
                desc+="Activo: "+i.getActivo()+"\n";
                desc+="PC: "+CompOli.retActivoEquipo(i.getPcActivo())+"\n";
                desc+="Marca: "+marcaValue(i.getMarca())+"\n";
                desc+="Pulgadas: "+pulgadasValue(i.getPulgadas())+"\n";
                desc+="Año: "+i.getAno()+"\n";
                desc+="Modelo: "+i.getModelo()+"\n";
                ret.add(desc);
                return ret;
            }
        }
        return ret;
    }

    public static ArrayList<String> retDescpMonitores(){
        ArrayList<String> lista = new ArrayList<>();
        String desc = "";
        for(Monitor i : listaMonitores){
            desc="";
            desc+="Activo: "+i.getActivo()+"\n";
            desc+="PC: "+CompOli.retActivoEquipo(i.getPcActivo())+"\n";
            desc+="Marca: "+marcaValue(i.getMarca())+"\n";
            desc+="Pulgadas: "+pulgadasValue(i.getPulgadas())+"\n";
            desc+="Año: "+i.getAno()+"\n";
            desc+="Modelo: "+i.getModelo()+"\n";
            lista.add(desc);
        }
        return lista;
    }

    public static void updateMonitor(String activo, Monitor monitor){

        for(Monitor i : listaMonitores){
            if(i.getActivo().equalsIgnoreCase(activo)){
                i.setActivo(monitor.getActivo());
                i.setPcActivo(monitor.getPcActivo());
                i.setAno(monitor.getAno());
                i.setModelo(monitor.getModelo());
                i.setPulgadas(monitor.getPulgadas());
                i.setMarca(monitor.getMarca());
                break;
            }
        }
    }


}
