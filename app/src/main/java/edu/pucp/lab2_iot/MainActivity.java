package edu.pucp.lab2_iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irAComputadora(View view){
        Intent intent = new Intent(MainActivity.this, ComputadoraListActivity.class);
        startActivity(intent);
    }

    public void IraMonitor(View view){
        Intent intent= new Intent(MainActivity.this,MonitorMenu.class);
        startActivity(intent);
    }


    public void IraReporte(View view){
        Intent intent= new Intent(MainActivity.this, Reporte.class);
        startActivity(intent);
    }

    public void IraTeclado(View view){
        Intent intent= new Intent(MainActivity.this,ListarTecladosActivity.class);
        startActivity(intent);
    }
}