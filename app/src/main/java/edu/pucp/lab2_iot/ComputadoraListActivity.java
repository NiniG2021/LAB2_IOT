package edu.pucp.lab2_iot;

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

import edu.pucp.lab2_iot.entity.ListaComputadoras;

public class ComputadoraListActivity extends AppCompatActivity {

    String computadora="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_computadora);

        //Floating Button
        FloatingActionButton floatingActionButton=findViewById(R.id.fab_addPC);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, ComputadoraFormActivity.class);
            intent.putExtra("actionForm","createComputer");
            startActivity(intent);
        });

        //to list all the computers
        if(!ListaComputadoras.getListaComputadoras().isEmpty()){
            //cleaning the message notification
            TextView textView= findViewById(R.id.msjListComputadora);
            textView.setText("");
            textView.setTextSize(0);

            //get the list UI element
            ListView listView=findViewById(R.id.lista_Computadoras);
            //Create an adapter with values of list that already been created
            ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,ListaComputadoras.returnComputadoras());
            //Put the adapter on the UI list element
            listView.setAdapter(arrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ComputadoraListActivity.this, ComputadoraActualizarActivity.class);
                    //intent.putExtra("computerToUpdate", ListaComputadoras.getListaComputadoras().get(position));
                    intent.putExtra("position",Integer.toString(position));
                    //intent.putExtra("actionForm","updateComputer");
                    startActivity(intent);
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lista_pc_menu,menu);
        return true;
    }

    public void menulistPC(MenuItem menuItem){
        View menuItemView= findViewById(R.id.btn_options_listPC);
        PopupMenu popupMenu= new PopupMenu(this,menuItemView);
        popupMenu.getMenuInflater().inflate(R.menu.lista_pc_popup_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.btn_popupbuscar:
                        buscarComputadora();
                        return true;
                    case R.id.btn_popuptodo:
                        Toast.makeText(ComputadoraListActivity.this, "Lista de computadoras", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }

    //Dialog con input
    public void buscarComputadora() {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        alertDialog.setView(inflater.inflate(R.layout.dialog_search_computadora, null));

        TextView inputStr=findViewById(R.id.activo_input);

        alertDialog.setTitle("Computadora");
        alertDialog.setPositiveButton("Buscar",
                (dialogInterface, i) ->
                        Toast.makeText(ComputadoraListActivity.this, "Se esta buscando", Toast.LENGTH_SHORT).show());
                        try{
                            computadora= inputStr.getText().toString();
                            inputStr.setText(computadora.toString());
                        }catch (Exception e){
                            computadora= "nothing";
                        }
                        Log.d("msg",computadora);

        alertDialog.setNegativeButton("Cancelar",
                (dialogInterface, i) ->
                        Toast.makeText(ComputadoraListActivity.this, "canceled", Toast.LENGTH_SHORT).show());
        alertDialog.show();
    }
}