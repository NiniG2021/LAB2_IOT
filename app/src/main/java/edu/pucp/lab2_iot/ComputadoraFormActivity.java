package edu.pucp.lab2_iot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import edu.pucp.lab2_iot.entity.Computadora;
import edu.pucp.lab2_iot.entity.ListaComputadoras;

public class ComputadoraFormActivity extends AppCompatActivity {

    EditText activo;
    Spinner marca;
    EditText anho;
    EditText CPU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_computadora);
        marca = findViewById(R.id.editMarca);
    }

    //VINCULAMOS EL MENU CON EL ACTIVITY
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nuevo_pc_menu,menu);
        return true;
    }

    //Guardar new computer
    public void saveComputer(MenuItem menuItem){
        activo= findViewById(R.id.pc_activo_input);
        marca=findViewById(R.id.pc_marca_spinner);
        anho=findViewById(R.id.pc_anho_input);
        CPU=findViewById(R.id.pc_cpu_input);

        String activoStr=activo.getText().toString();
        String marcaStr= marca.getSelectedItem().toString();
        String anhoStr=anho.getText().toString();
        String cpuStr=CPU.getText().toString();

        boolean saveAble = false;

        if(activoStr.isEmpty()){
            activo.setError("Ingrese activo");
            saveAble=false;
        }else if(ListaComputadoras.existComutadora(activoStr)){
            activo.setError("Este activo ya existe");
            saveAble=false;
        }else if(marcaStr.equals("Marca:")){
            Toast.makeText(this, "Tiene que llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
        else if(anhoStr.isEmpty()){
            anho.setError("Ingrese año");
            saveAble=false;
        }else if(Integer.parseInt(anhoStr)>2022 ||Integer.parseInt(anhoStr)<1960 ){
            anho.setError("Año no valido");
            saveAble=false;
        }
        else if(cpuStr.isEmpty()){
            saveAble=false;
            CPU.setError("Ingrese CPU");
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            saveAble=true;
        }

        if(saveAble){
            Computadora computadora=new Computadora(activoStr,(marca.getSelectedItemPosition()-1),Integer.parseInt(anhoStr),cpuStr);
            ListaComputadoras.addComputadora(computadora);
            finish();
        }


    }


}