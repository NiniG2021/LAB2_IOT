package edu.pucp.lab2_iot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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


        if(!ListaTeclados.getListTeclados().isEmpty()){
            ((TextView) findViewById(R.id.msjTeclado)).setText("");
            ((TextView) findViewById(R.id.msjTeclado)).setTextSize(0);

            ListView listviewtecl = findViewById(R.id.lista_Teclados);
            ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListaTeclados.descripTeclados());
            listviewtecl.setAdapter(array);

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
                    buscarTeclado();
                    return true;
                case R.id.btn_total:
                    Toast.makeText(ListarTecladosActivity.this, "Lista de teclados", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return false;
            }
        });
        popupMenu.show();

    }

    //Dialog con input
    String teclado="";
    public void buscarTeclado() {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        alertDialog.setView(inflater.inflate(R.layout.dialog_search_computadora, null));

        TextView inputStr=findViewById(R.id.activo_input);

        alertDialog.setTitle("Teclado");
        alertDialog.setPositiveButton("Buscar",
                (dialogInterface, i) ->
                        Toast.makeText(ListarTecladosActivity.this, "Se esta buscando", Toast.LENGTH_SHORT).show());
        try{
            teclado= inputStr.getText().toString();
            inputStr.setText(teclado.toString());
        }catch (Exception e){
            teclado= "nothing";
        }
        Log.d("msg",teclado);

        alertDialog.setNegativeButton("Cancelar",
                (dialogInterface, i) ->
                        Toast.makeText(ListarTecladosActivity.this, "cancelado", Toast.LENGTH_SHORT).show());
        alertDialog.show();
    }



}