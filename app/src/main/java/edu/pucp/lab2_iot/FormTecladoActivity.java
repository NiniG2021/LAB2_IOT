package edu.pucp.lab2_iot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import edu.pucp.lab2_iot.entity.Computadora;
import edu.pucp.lab2_iot.entity.ListaComputadoras;
import edu.pucp.lab2_iot.entity.ListaTeclados;
import edu.pucp.lab2_iot.entity.Teclado;

public class FormTecladoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_teclado);


        //spinner PC activos

        List<String> valuesSpinner = new ArrayList<>();
        valuesSpinner.add(0,"PC Activo:");

        for (Computadora comp: ListaComputadoras.getListaComputadoras()){
            valuesSpinner.add(comp.getActivo());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,valuesSpinner);
        Spinner spinner = findViewById(R.id.spinner_pc_activo);
        spinner.setAdapter(arrayAdapter);


        //spinner Marcas
        String [] marcas={"Marca:","Asus","Lenovo","Msi","Razer","Microsoft","Logitech","VSG"};
        ArrayAdapter<String> adapterMarcas= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,marcas);
        Spinner spinnerMarcas =findViewById(R.id.spinner_marca);
        //pinnerMarcas.setPrompt("Marca");
        spinnerMarcas.setAdapter(adapterMarcas);

        //spinner Idioma
        String [] idiomas={"Idioma:","Español Latam","Ingles","Frances","Italiano","Chino","Japones","Coreano"};
        ArrayAdapter<String> adapterIdioma= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,idiomas);
        Spinner spinnerIdioma =findViewById(R.id.spinner_idioma);
        //pinnerMarcas.setPrompt("Idioma");
        spinnerIdioma.setAdapter(adapterIdioma);





    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btn_guardar_teclado:

                //Log.d("msg", "botón alert presionado");

                //guardar la data del formulario(crear)
                //obteniendo texto ingresado
                EditText textoActivoTecl = findViewById(R.id.editText_Activo_teclado);
                String textoStringActivo = textoActivoTecl.getText().toString();
                //obteniendo de la lista pcs
                Spinner spinnerPcActivo =findViewById(R.id.spinner_pc_activo);
                String pcactivo=spinnerPcActivo.getSelectedItem().toString();
                if (pcactivo.equals("PC Activo:")){
                    pcactivo="";
                }

                //obteniendo de la lista marcas
                Spinner spinnerMarcas =findViewById(R.id.spinner_marca);
                String marca=spinnerMarcas.getSelectedItem().toString();
                if (marca.equals("Marca:")){
                    marca="";
                }


                //obteniendo de la lista idioma
                Spinner spinnerIdioma =findViewById(R.id.spinner_idioma);
                String idioma=spinnerIdioma.getSelectedItem().toString();
                if (idioma.equals("Idioma:")){
                    idioma="";
                }

                //obteniendo texto ingresado año
                EditText editTextAnio = findViewById(R.id.editText_anio);
                String anio = editTextAnio.getText().toString();


                //obteniendo texto ingresado modelo
                EditText editTextModelo = findViewById(R.id.editTextModelo);
                String modelo = editTextModelo.getText().toString();

                //se añade a la lista dinamica

                Teclado pruebatecl = new Teclado(textoStringActivo,pcactivo,marca,anio,idioma,modelo);
                ListaTeclados.addTeclado(pruebatecl);


                Intent intent = new Intent(this,ListarTecladosActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nuevo_teclado_menu,menu);
        return true;
    }

}