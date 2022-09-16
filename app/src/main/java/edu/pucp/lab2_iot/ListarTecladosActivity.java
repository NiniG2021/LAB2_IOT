package edu.pucp.lab2_iot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

public class ListarTecladosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_teclados);
    }



    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_teclado, menu);
        return true;
    }

    public void btnToolAction(MenuItem menuItem) {
        Log.d("msg", "btn_tool");

        View view = findViewById(R.id.btn_tres_puntos);
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.sub_menu_teclado, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem1 -> {
            switch (menuItem1.getItemId()) {
                case R.id.btn_buscar:
                    Log.d("msg", "btn_buscar pressed");
                    return true;
                case R.id.btn_total:
                    Log.d("msg", "btn_total pressed");
                    return true;
                default:
                    return false;
            }
        });
        popupMenu.show();

    }
}