package edu.pucp.lab2_iot;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import edu.pucp.lab2_iot.entity.Computadora;
import edu.pucp.lab2_iot.entity.ListaComputadoras;
import edu.pucp.lab2_iot.entity.ListaMonitores;
import edu.pucp.lab2_iot.entity.ListaTeclados;
import edu.pucp.lab2_iot.entity.Monitor;


public class reporte extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);


        if(ListaComputadoras.getListaComputadoras().size() >0){
            String cantidad_computadoras = "-Total: "+ ListaComputadoras.getListaComputadoras().size();
            ((TextView)findViewById(R.id.reporte_computadoras)).setText(cantidad_computadoras);

        }else{
            TextView textView= findViewById(R.id.reporte_computadoras);
            textView.setText("No se registra computadoras");

        }

        if(ListaMonitores.getlistamonitores().size() >0){
            String cantidad_monitores = "Monitores: " + ListaMonitores.getlistamonitores().size();
            ((TextView)findViewById(R.id.reporte_monitor)).setText(cantidad_monitores);

        }else{
            TextView textView= findViewById(R.id.reporte_monitor);
            textView.setText("Monitores: No se registran monitores");

        }

        if( ListaTeclados.getListTeclados().size() > 0){
            String cantidad_teclados = "Teclados: "+ListaTeclados.getListTeclados().size();
            ((TextView)findViewById(R.id.reporte_teclado)).setText(cantidad_teclados);

        }else{
            TextView textView= findViewById(R.id.reporte_teclado);
            textView.setText("Teclados: No se registran teclados");

        }






    }



}