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

        if(activoStr.isEmpty()|| anhoStr.isEmpty() || cpuStr.isEmpty()){
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }

        Computadora computadora=new Computadora(activoStr,marca.getSelectedItemPosition(),Integer.parseInt(anhoStr),cpuStr);
        ListaComputadoras.addComputadora(computadora);

        Intent intent=new Intent(this,ComputadoraListActivity.class);
        startActivity(intent);

    }


}