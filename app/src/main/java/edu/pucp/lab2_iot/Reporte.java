package edu.pucp.lab2_iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.pucp.lab2_iot.entity.ListaComputadoras;
import edu.pucp.lab2_iot.entity.ListaMonitores;
import edu.pucp.lab2_iot.entity.ListaTeclados;


public class Reporte extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);


        if(ListaComputadoras.getListaComputadoras().size() >0){
            String cantidad_computadoras = "-Total: "+ ListaComputadoras.getListaComputadoras().size();
            cantidad_computadoras+= "\nDel año 2022: " + ListaComputadoras.computadoras2022;
            ((TextView)findViewById(R.id.reporte_computadoras)).setText(cantidad_computadoras);

        }else{
            TextView textView= findViewById(R.id.reporte_computadoras);
            textView.setText("No se registran");

        }

        if(ListaMonitores.getlistamonitores().size() >0){
            String cantidad_monitores = "Monitores: " + ListaMonitores.getlistamonitores().size();
            ((TextView)findViewById(R.id.reporte_monitor)).setText(cantidad_monitores);

        }else{
            TextView textView= findViewById(R.id.reporte_monitor);
            textView.setText("Monitores: No se registran\n");

        }

        if( ListaTeclados.getListTeclados().size() > 0){
            String cantidad_teclados = "Teclados: "+ListaTeclados.getListTeclados().size();
            ((TextView)findViewById(R.id.reporte_teclado)).setText(cantidad_teclados);

        }else{
            TextView textView= findViewById(R.id.reporte_teclado);
            textView.setText("Teclados: No se registran");

        }






    }



}