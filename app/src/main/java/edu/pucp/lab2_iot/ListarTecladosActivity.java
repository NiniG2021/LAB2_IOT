package edu.pucp.lab2_iot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import edu.pucp.lab2_iot.entity.ListaMonitores;
import edu.pucp.lab2_iot.entity.ListaTeclados;
import edu.pucp.lab2_iot.entity.Monitor;
import edu.pucp.lab2_iot.entity.Teclado;

public class ListarTecladosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_teclados);

        //boton flotante de agregar
        FloatingActionButton floatingActionButton=findViewById(R.id.btn_form_crear_teclado);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(this,FormTecladoActivity.class);
            startActivity(intent);
        });

        //listar teclados
        if(!ListaTeclados.getListTeclados().isEmpty()){
            ((TextView) findViewById(R.id.msjTeclado)).setText("");
            ((TextView) findViewById(R.id.msjTeclado)).setTextSize(0);

            ListView listviewtecl = findViewById(R.id.lista_Teclados);
            ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListaTeclados.descripTeclados());
            listviewtecl.setAdapter(array);

            //actualizar al hacer click
            listviewtecl.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Toast.makeText(ListarTecladosActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ListarTecladosActivity.this,ActualizarTecladoActivity.class);
                    intent.putExtra("tecladoActualizar",ListaTeclados.getListTeclados().get(position));
                    intent.putExtra("posicion",Integer.toString(position));
                    startActivity(intent);
                }
            });

        }else{
            ((TextView) findViewById(R.id.msjTeclado)).setText("No hay teclados registrados");
            ((TextView) findViewById(R.id.msjTeclado)).setTextSize(27);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_teclado, menu);
        return true;
    }

    public void btnDesplegable(MenuItem menuItem) {
        Log.d("msg", "btn_tool");

        View view = findViewById(R.id.btn_tres_puntos);
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.sub_menu_teclado, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem1 -> {
            switch (menuItem1.getItemId()) {
                case R.id.btn_buscar:
                    buscTeclado(menuItem);
                    return true;
                case R.id.btn_total:
                    //listar teclados
                    if(!ListaTeclados.getListTeclados().isEmpty()){
                        ((TextView) findViewById(R.id.msjTeclado)).setText("");
                        ((TextView) findViewById(R.id.msjTeclado)).setTextSize(0);

                        ListView listviewtecl = findViewById(R.id.lista_Teclados);
                        ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListaTeclados.descripTeclados());
                        listviewtecl.setAdapter(array);

                        //actualizar al hacer click
                        listviewtecl.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Toast.makeText(ListarTecladosActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ListarTecladosActivity.this,ActualizarTecladoActivity.class);
                                intent.putExtra("tecladoActualizar",ListaTeclados.getListTeclados().get(position));
                                intent.putExtra("posicion",Integer.toString(position));
                                startActivity(intent);
                            }
                        });

                    }else{
                        ((TextView) findViewById(R.id.msjTeclado)).setText("No hay teclados registrados");
                        ((TextView) findViewById(R.id.msjTeclado)).setTextSize(27);
                    }
                    return true;
                default:
                    return false;
            }
        });
        popupMenu.show();

    }

    public void buscTeclado(MenuItem menuItem){


        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Teclado");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
        input.setHint("Activo");
        alertDialog.setView(input);


        alertDialog.setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String tecladoSearch = input.getText().toString();
                ArrayList<String> resultado_busqueda = ListaTeclados.searchTeclado(tecladoSearch);
                ListView list = findViewById(R.id.lista_Teclados);
                ArrayAdapter<String> array = new ArrayAdapter<String>(ListarTecladosActivity.this, android.R.layout.simple_list_item_1,resultado_busqueda);
                list.setAdapter(array);

                if(!resultado_busqueda.isEmpty()){
                    ((TextView) findViewById(R.id.msjTeclado)).setText("");
                    ((TextView) findViewById(R.id.msjTeclado)).setTextSize(0);
                    
                    Integer posic=ListaTeclados.obtenerPosicion(tecladoSearch);
                    if(posic!=null){
                        //actualizar al hacer click
                        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Toast.makeText(ListarTecladosActivity.this, Integer.toString(posic), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ListarTecladosActivity.this,ActualizarTecladoActivity.class);
                                intent.putExtra("tecladoActualizar",ListaTeclados.getListTeclados().get(posic));
                                intent.putExtra("posicion",Integer.toString(posic));
                                startActivity(intent);
                            }
                        });
                    }




                }else{
                    ((TextView) findViewById(R.id.msjTeclado)).setText("No existe el equipo con activo: "+tecladoSearch);
                    ((TextView) findViewById(R.id.msjTeclado)).setTextSize(27);
                }
            }
        });
        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.show();
    }

    @Override
    protected void onResume() {
        if(!ListaTeclados.getListTeclados().isEmpty()){
            ((TextView) findViewById(R.id.msjTeclado)).setText("");
            ((TextView) findViewById(R.id.msjTeclado)).setTextSize(0);

            ListView listviewtecl = findViewById(R.id.lista_Teclados);
            ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListaTeclados.descripTeclados());
            listviewtecl.setAdapter(array);

            //actualizar al hacer click
            listviewtecl.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Toast.makeText(ListarTecladosActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ListarTecladosActivity.this,ActualizarTecladoActivity.class);
                    intent.putExtra("tecladoActualizar",ListaTeclados.getListTeclados().get(position));
                    intent.putExtra("posicion",Integer.toString(position));
                    startActivity(intent);
                }
            });

        }else{
            ((TextView) findViewById(R.id.msjTeclado)).setText("No hay teclados registrados");
            ((TextView) findViewById(R.id.msjTeclado)).setTextSize(27);
            ListView listviewtecl = findViewById(R.id.lista_Teclados);
            ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListaTeclados.descripTeclados());
            listviewtecl.setAdapter(array);
        }
        super.onResume();
    }
}