package edu.pucp.lab2_iot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.pucp.lab2_iot.entity.Computadora;
import edu.pucp.lab2_iot.entity.ListaComputadoras;
import edu.pucp.lab2_iot.entity.ListaMonitores;
import edu.pucp.lab2_iot.entity.ListaTeclados;
import edu.pucp.lab2_iot.entity.Teclado;

public class ActualizarTecladoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_teclado);
        //obtengo el teclado que quiero actualizar
        Teclado teclado_actualiz=(Teclado) getIntent().getSerializableExtra("tecladoActualizar");


        //spinner PC activos

        List<String> valuesSpinner = new ArrayList<>();
        valuesSpinner.add(0,"PC Activo:");
        valuesSpinner.add(1,"Ninguna");


        for (Computadora comp: ListaComputadoras.getListaComputadoras()){
            valuesSpinner.add(comp.getActivo());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,valuesSpinner);
        Spinner spinner = findViewById(R.id.spinner_PC_Activ_Actualiz);
        spinner.setAdapter(arrayAdapter);


        //spinner Marcas
        String [] marcas={"Marca:","Asus","Lenovo","Msi","Razer","Microsoft","Logitech","VSG"};
        ArrayAdapter<String> adapterMarcas= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,marcas);
        Spinner spinnerMarcas =findViewById(R.id.spinner_marca_actualiz);

        spinnerMarcas.setAdapter(adapterMarcas);

        //spinner Idioma
        String [] idiomas={"Idioma:","Español Latam","Ingles","Frances","Italiano","Chino","Japones","Coreano"};
        ArrayAdapter<String> adapterIdioma= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,idiomas);
        Spinner spinnerIdioma =findViewById(R.id.spinner_idioma_actualiz);

        spinnerIdioma.setAdapter(adapterIdioma);


        //Seleccion para PC activo

        for (int i=0; i<valuesSpinner.size(); i++){
            if(valuesSpinner.get(i).equals(teclado_actualiz.getPcactiv())){
                spinner.setSelection(i);
            }
        }


        //Seleccion para marcas
        for (int i=0; i<marcas.length; i++){
            if(marcas[i].equals(teclado_actualiz.getMarca())){
                spinnerMarcas.setSelection(i);
            }
        }

        //Seleccion para idioma
        for (int i=0; i<idiomas.length; i++){
            if(idiomas[i].equals(teclado_actualiz.getIdioma())){
                spinnerIdioma.setSelection(i);
            }
        }

        EditText activo_tecl = findViewById(R.id.editText_activo_actualiz);
        activo_tecl.setText(teclado_actualiz.getActivo());
        activo_tecl.setEnabled(false);
        EditText anio_tecl = findViewById(R.id.editText_Anio_Actualizad);
        anio_tecl.setText(teclado_actualiz.getAnio());
        EditText modelo_tecl = findViewById(R.id.editText_modelo_actualiz);
        modelo_tecl.setText(teclado_actualiz.getModelo());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actualizar_teclado_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Integer position = Integer.parseInt(getIntent().getStringExtra("posicion"));
        switch (item.getItemId()) {
            case R.id.btn_guar_actualiz_teclado:

                //Log.d("msg", "botón alert presionado");
                boolean fine = true;
                //guardar la data del formulario(crear)
                //obteniendo texto ingresado
                EditText textoActivoTecl = findViewById(R.id.editText_activo_actualiz);
                String textoStringActivo = textoActivoTecl.getText().toString();
                if(textoStringActivo.isEmpty()){
                    fine=false;
                    textoActivoTecl.setError("No puede estar vacío");
                }
                //obteniendo de la lista pcs
                Spinner spinnerPcActivo =findViewById(R.id.spinner_PC_Activ_Actualiz);
                String pcactivo=spinnerPcActivo.getSelectedItem().toString();
                if (pcactivo.equals("PC Activo:")){
                    pcactivo="";
                    fine=false;
                }

                //obteniendo de la lista marcas
                Spinner spinnerMarcas =findViewById(R.id.spinner_marca_actualiz);
                String marca=spinnerMarcas.getSelectedItem().toString();
                if (marca.equals("Marca:")){
                    marca="";
                    fine=false;
                }


                //obteniendo de la lista idioma
                Spinner spinnerIdioma =findViewById(R.id.spinner_idioma_actualiz);
                String idioma=spinnerIdioma.getSelectedItem().toString();
                if (idioma.equals("Idioma:")){
                    idioma="";
                    fine=false;
                }

                //obteniendo texto ingresado año
                EditText editTextAnio = findViewById(R.id.editText_Anio_Actualizad);
                String anio = editTextAnio.getText().toString();

                int anoint=0;
                try{
                    anoint = Integer.parseInt(anio);
                }catch (Exception e ){
                    fine = false;
                    editTextAnio.setError("No puede estar vacío");
                }

                if(anoint>2022 || anoint<1960){
                    fine = false;
                    editTextAnio.setError("Año no aceptado, revise el valor");
                }


                //obteniendo texto ingresado modelo
                EditText editTextModelo = findViewById(R.id.editText_modelo_actualiz);
                String modelo = editTextModelo.getText().toString();

                if(modelo.isEmpty()){
                    editTextModelo.setError("No puede estar vacío");
                    fine=false;
                }
                //se actualiza en el objeto de la lista dinamica
                if(fine) {
                    Teclado tecl = ListaTeclados.getListTeclados().get(position);
                    tecl.setAnio(anio);
                    tecl.setActivo(textoStringActivo);
                    tecl.setPcactiv(pcactivo);
                    tecl.setIdioma(idioma);
                    tecl.setMarca(marca);
                    tecl.setModelo(modelo);

                    finish();
                } else{
                    Toast.makeText(this, "Tiene que llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_borrar_teclado:


                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Esta seguro que desea borrar?");


                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListaTeclados.deleteTeclado(ListaTeclados.getListTeclados().get(position));
                        finish();
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();


        }

        return super.onOptionsItemSelected(item);
    }






}