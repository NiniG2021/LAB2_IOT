package edu.pucp.lab2_iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import edu.pucp.lab2_iot.entity.CompOli;
import edu.pucp.lab2_iot.entity.ListaMonitores;
import edu.pucp.lab2_iot.entity.Monitor;

public class MonitorForm extends AppCompatActivity {

    EditText activo;
    Spinner activoPC;
    Spinner marca;
    Spinner pulgadas;
    EditText modelo;
    EditText ano;

    String monitActivo= null;
    Monitor monitor = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_form);

        activo = findViewById(R.id.editActivo);
        activoPC = findViewById(R.id.editPCActivo);
        marca = findViewById(R.id.editMarca);
        pulgadas = findViewById(R.id.editPulgadas);
        modelo = findViewById(R.id.editModelo);
        ano = findViewById(R.id.editAno);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, CompOli.retListaActivos());

        activoPC.setAdapter(adapter);

        Intent intent = getIntent();
        monitActivo = intent.getStringExtra("activo");

        if(monitActivo!=null){
            monitor = ListaMonitores.findMonitorSave(monitActivo.trim());
            //Toast.makeText(this, monitor.getActivo(), Toast.LENGTH_SHORT).show();
            activo.setText(monitor.getActivo());
            activoPC.setSelection(monitor.getPcActivo()+1);
            marca.setSelection(monitor.getMarca()+1);
            modelo.setText(monitor.getModelo());
            pulgadas.setSelection(monitor.getPulgadas()+1);
            ano.setText(String.valueOf(monitor.getAno()));
            activo.setEnabled(false);

            setTitle("Actualizar");
        } else{
            setTitle("Nuevo");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_monitor_context,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }



    public void saveMonitor(MenuItem menuItem){


        String activoStr = activo.getText().toString().trim();
        boolean shouldSave = true;
        if(activoStr.isEmpty()){
            shouldSave = false;
            activo.setError("No puede estar vac??o");
        }
        if(monitActivo==null && ListaMonitores.existMonitor(activoStr)){
            shouldSave = false;
            activo.setError("No se pueden repetir los activos");
        }




        int anoint=0;
        try{
            anoint = Integer.parseInt(ano.getText().toString());
        }catch (Exception e ){
            shouldSave = false;
            ano.setError("No puede estar vac??o");
        }


        if(anoint>2022 || anoint<1960){
            shouldSave = false;
            ano.setError("A??o no aceptado, revise el valor");
        }

        String modeloStr = modelo.getText().toString();
        if(modeloStr.isEmpty()){
            shouldSave = false;
            modelo.setError("No puede estar vac??o");
        }

        if(marca.getSelectedItemPosition()==0 || pulgadas.getSelectedItemPosition()==0 || activoPC.getSelectedItemPosition()==0){
            shouldSave = false;
            Toast.makeText(this, "Tiene que llenar todos los campos", Toast.LENGTH_SHORT).show();
        }

        if(shouldSave){
            Monitor monitor = new Monitor(
                activoStr, (activoPC.getSelectedItemPosition()-1),(marca.getSelectedItemPosition()-1),(pulgadas.getSelectedItemPosition()-1),anoint,modeloStr
            );

            if(monitActivo==null){
                ListaMonitores.addMonitor(monitor);
            }else{
                ListaMonitores.updateMonitor(monitActivo.trim(),monitor);
            }
            finish();
        }




    }
}