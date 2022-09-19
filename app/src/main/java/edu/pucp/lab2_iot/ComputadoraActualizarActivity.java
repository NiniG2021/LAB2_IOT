package edu.pucp.lab2_iot;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import edu.pucp.lab2_iot.entity.Computadora;
import edu.pucp.lab2_iot.entity.ListaComputadoras;

public class ComputadoraActualizarActivity extends AppCompatActivity {

    EditText activo;
    Spinner marca;
    EditText anho;
    EditText CPU;
    int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_computadora);

        activo= findViewById(R.id.pc_activo_update);
        marca=findViewById(R.id.pc_marca_update);
        anho=findViewById(R.id.pc_anho_update);
        CPU=findViewById(R.id.pc_input_update);
        activo.setEnabled(false);


        Intent intent=getIntent();
        posicion = Integer.parseInt(intent.getStringExtra("position"));
        //posicion = intent.getIntExtra("position");
        Computadora pc= ListaComputadoras.getListaComputadoras().get(posicion);
        activo.setText(pc.getActivo());
        marca.setSelection(pc.getMarca());
        anho.setText(String.valueOf(pc.getAnho()));
        CPU.setText(pc.getCPU());
    }
    //Actualizar new computer
    public void updateComputer(MenuItem menuItem){
        String activoStr=activo.getText().toString();
        String anhoStr=anho.getText().toString();
        String cpuStr=CPU.getText().toString();

        if(activoStr.isEmpty()  || anhoStr.isEmpty() || cpuStr.isEmpty()){
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }

        Computadora pcA= new Computadora(activoStr,marca.getSelectedItemPosition(),Integer.parseInt(anhoStr),cpuStr);
        ListaComputadoras.updateComputadora(posicion,pcA);
        finish();
    }
    //Delete computer
    public void deleteComputer(MenuItem menuItem){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Esta seguro de eliminar?");
        alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ListaComputadoras.deleteComputadora(ListaComputadoras.getListaComputadoras().get(posicion));
                Toast.makeText(ComputadoraActualizarActivity.this, "Eliminado", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();


    }

    //VINCULAMOS EL MENU CON EL ACTIVITY
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actualizar_pc_menu,menu);
        return true;
    }
}