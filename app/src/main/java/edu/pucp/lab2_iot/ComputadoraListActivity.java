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

import edu.pucp.lab2_iot.entity.Computadora;
import edu.pucp.lab2_iot.entity.ListaComputadoras;

public class ComputadoraListActivity extends AppCompatActivity {


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

        ListView listView=findViewById(R.id.lista_Computadoras);


        //to list all the computers
        listComputer();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(ComputadoraListActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ComputadoraListActivity.this, ComputadoraActualizarActivity.class);
                //intent.putExtra("computerToUpdate", ListaComputadoras.getListaComputadoras().get(position));

                String text = parent.getItemAtPosition(position).toString();
                text = text.substring(text.indexOf(":")+1, text.indexOf("\n"));
                int pos=ListaComputadoras.indexActivo(text.trim());
                intent.putExtra("position",""+pos);
                //Toast.makeText(ComputadoraListActivity.this, ""+pos, Toast.LENGTH_SHORT).show();
                //intent.putExtra("actionForm","updateComputer");
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.lista_pc_menu,menu);
        return true;
    }

    public void menulistPC(MenuItem menuItem){
        View menuItemView= findViewById(R.id.btn_options_listPC);
        PopupMenu popupMenu= new PopupMenu(this,menuItemView);
        popupMenu.getMenuInflater().inflate(R.menu.lista_pc_popup_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem1) {
                switch (menuItem1.getItemId()){
                    case R.id.btn_popupbuscar:
                        buscarComputadora(menuItem);
                        return true;
                    case R.id.btn_popuptodo:
                        listComputer();
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
    public void buscarComputadora(MenuItem menuItem) {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Computadora");
        TextView textView= findViewById(R.id.msjListComputadora);


        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
        alertDialog.setView(input);

        alertDialog.setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String computerSearch= input.getText().toString().trim();
                ArrayList<String> result=ListaComputadoras.searchComputadora(computerSearch);
                ListView listView=findViewById(R.id.lista_Computadoras);

                if(!result.isEmpty()){

                    textView.setText("Resultados de busqueda");
                    textView.setTextSize(24);


                }else{
                    textView.setText("No se encontraron resultados de busqueda");
                    textView.setTextSize(24);

                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ComputadoraListActivity.this, android.R.layout.simple_list_item_1,result);
                listView.setAdapter(arrayAdapter);
            }
        });
        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listComputer();
            }
        });


        alertDialog.show();
    }

    //Computer list
    public  void listComputer(){
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


        }
    }

    @Override
    protected void onResume() {
        listComputer();
        super.onResume();
    }
}