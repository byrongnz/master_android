package com.example.zarza.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private GridView  gridView;
    private List<String> nombres;
    public int contador=0;
    MiAdaptador miAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView =(GridView)findViewById(R.id.grid);

        //Datos
        nombres = new ArrayList<String>();
        nombres.add("Adrian");
        nombres.add("Marco");
        nombres.add("Valeria");
        nombres.add("Karla");
        nombres.add("Daniel");
        nombres.add("Sandra");
        nombres.add("Nyck");
        nombres.add("Arthur");
        nombres.add("Andrea");
        nombres.add("Angy");
        nombres.add("Diana");
        nombres.add("Kimberly");
        nombres.add("DJPablito");
        nombres.add("Natalia");
        nombres.add("Oscar");
        nombres.add("Yavhe");
        nombres.add("Adrian");
        nombres.add("Marco");
        nombres.add("Valeria");
        nombres.add("Karla");
        nombres.add("Daniel");
        nombres.add("Sandra");
        nombres.add("Nyck");
        nombres.add("Arthur");
        nombres.add("Andrea");
        nombres.add("Angy");
        nombres.add("Diana");
        nombres.add("Kimberly");
        nombres.add("DJPablito");
        nombres.add("Natalia");
        nombres.add("Oscar");
        nombres.add("Yavhe");

        //Adaptador: forma en que visualizaremos nuestros datos
        // 1 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,nombres);

        //Enlazamos
        // 1 listView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long i) {
                Toast.makeText(GridActivity.this, "Click "+nombres.get(posicion), Toast.LENGTH_SHORT).show();
            }
        });

        miAdaptador = new MiAdaptador(this,R.layout.grid_item,nombres);
        gridView.setAdapter(miAdaptador);

        registerForContextMenu(gridView);

    }
    //INFLAMOS EL LAYOUT DEL MENU DE OPCIONES
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu,menu);
        return true;

    }

    //Manejamos el evento click del menu sencillo
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add_item:
                this.nombres.add("Agregado #"+(++contador));
                this.miAdaptador.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    //Inflamos el menu contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo)menuInfo;
        menu.setHeaderTitle(this.nombres.get(info.position));
        inflater.inflate(R.menu.context_menu,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delete:
                this.nombres.remove(info.position);
                this.miAdaptador.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
