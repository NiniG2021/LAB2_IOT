package edu.pucp.lab2_iot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ListarComputadoraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_computadora);
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
                        Toast.makeText(ListarComputadoraActivity.this, "buscar", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.btn_popuptodo:
                        Toast.makeText(ListarComputadoraActivity.this, "todo", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }
}