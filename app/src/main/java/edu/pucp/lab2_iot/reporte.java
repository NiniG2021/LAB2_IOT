package edu.pucp.lab2_iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import edu.pucp.lab2_iot.entity.ListaComputadoras;
import edu.pucp.lab2_iot.entity.ListaMonitores;
import edu.pucp.lab2_iot.entity.ListaTeclados;


public class reporte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        //esto no
        ListaMonitores listaMonitores = new ListaMonitores();
        ListaTeclados listaTeclados = new ListaTeclados();
        ListaComputadoras listaComputadoras = new ListaComputadoras();

        //Ejemplo
        ((TextView) findViewById(R.id.reporte_computadoras)).setText(ListaComputadoras.getListaComputadoras().size());



    }



}