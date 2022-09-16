package edu.pucp.lab2_iot;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import edu.pucp.lab2_iot.entity.ListaMonitores;
import edu.pucp.lab2_iot.entity.Monitor;

public class MonitorMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_menu);
        Monitor prueba = new Monitor("asdsa","asndsad","aksndsad",23.21,10,"toyoya");
        ListaMonitores.addMonitor(prueba);
        Monitor prueba2 = new Monitor("SAC123","asndsad","aksndsad",23.21,10,"toyoya");
        ListaMonitores.addMonitor(prueba2);

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
}