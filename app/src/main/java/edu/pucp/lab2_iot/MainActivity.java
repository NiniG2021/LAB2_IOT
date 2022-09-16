package edu.pucp.lab2_iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void irAComputadora(View view){
        Intent intent = new Intent(MainActivity.this,ListarComputadoraActivity.class);
        startActivity(intent);
    }
/*


    public void IraMonitor(View view){
        Intent intent= new Intent(MainActivity.this,);
        startActivity(intent);
    }
    public void IraTeclado(View view){
        Intent intent= new Intent(MainActivity.this,);
        startActivity(intent);
    }


    public void IraReporte(View view){
        Intent intent= new Intent(MainActivity.this,reporte.class);
        startActivity(intent);
    }

 */

}