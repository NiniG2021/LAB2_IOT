package edu.pucp.lab2_iot;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.pucp.lab2_iot.entity.ListaMonitores;
import edu.pucp.lab2_iot.entity.Monitor;

public class MonitorMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_menu);
        //Monitor prueba = new Monitor("act",0, 1,0,10,"toyoya");
        //ListaMonitores.addMonitor(prueba);
        ListView list = findViewById(R.id.listMonitors);

        if(!ListaMonitores.returnList().isEmpty()){
            ((TextView) findViewById(R.id.messageMonitor)).setText("");
            ((TextView) findViewById(R.id.messageMonitor)).setTextSize(0);
            ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListaMonitores.retDescpMonitores());
            list.setAdapter(array);
        }else{
            ((TextView) findViewById(R.id.messageMonitor)).setText("No hay monitores registrados");
            ((TextView) findViewById(R.id.messageMonitor)).setTextSize(27);
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = adapterView.getItemAtPosition(i).toString();
                text = text.substring(text.indexOf(":")+1, text.indexOf("\n"));
                Intent intent = new Intent(MonitorMenu.this, MonitorForm.class);
                intent.putExtra("activo",text);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_monitor_list,menu);
        return true;

        //return super.onCreateOptionsMenu(menu);
    }
    public void showAll(MenuItem menuItem){
        if(!ListaMonitores.returnList().isEmpty()){
            ((TextView) findViewById(R.id.messageMonitor)).setText("");
            ((TextView) findViewById(R.id.messageMonitor)).setTextSize(0);

            ListView list = findViewById(R.id.listMonitors);
            ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListaMonitores.retDescpMonitores());
            list.setAdapter(array);
        }else{
            ((TextView) findViewById(R.id.messageMonitor)).setText("No hay monitores registrados");
            ((TextView) findViewById(R.id.messageMonitor)).setTextSize(27);
        }
    }

    public void searchMonitor(MenuItem menuItem){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Monitor");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
        input.setHint("Activo");
        builder.setView(input);


        builder.setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String monitorSearch = input.getText().toString();
                ArrayList<String> resultado = ListaMonitores.searchMonitor(monitorSearch);
                ListView list = findViewById(R.id.listMonitors);
                ArrayAdapter<String> array = new ArrayAdapter<String>(MonitorMenu.this, android.R.layout.simple_list_item_1,resultado);
                list.setAdapter(array);
                if(!resultado.isEmpty()){
                    ((TextView) findViewById(R.id.messageMonitor)).setText("");
                    ((TextView) findViewById(R.id.messageMonitor)).setTextSize(0);
                }else{
                    ((TextView) findViewById(R.id.messageMonitor)).setText("No existe el equipo con activo: "+monitorSearch);
                    ((TextView) findViewById(R.id.messageMonitor)).setTextSize(27);
                }
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

    public void addMonitor(View view){
        Intent intent = new Intent(MonitorMenu.this,MonitorForm.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        if(!ListaMonitores.returnList().isEmpty()){
            ((TextView) findViewById(R.id.messageMonitor)).setText("");
            ((TextView) findViewById(R.id.messageMonitor)).setTextSize(0);

            ListView list = findViewById(R.id.listMonitors);
            ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListaMonitores.retDescpMonitores());
            list.setAdapter(array);
        }else{
            ((TextView) findViewById(R.id.messageMonitor)).setText("No hay monitores registrados");
            ((TextView) findViewById(R.id.messageMonitor)).setTextSize(27);
        }
        super.onResume();
    }
}