package edu.pucp.lab2_iot;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import edu.pucp.lab2_iot.entity.ListaMonitores;

public class MonitorMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_menu);

        if(!ListaMonitores.returnList().isEmpty()){

        }
    }
}