package com.example.zarza.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =(ListView)findViewById(R.id.listView);

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

        //Adaptador: forma en que visualizaremos nuestros datos
        // 1 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,nombres);

        //Enlazamos
        // 1 listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long i) {
                Toast.makeText(ListActivity.this, "Click "+nombres.get(posicion), Toast.LENGTH_SHORT).show();
            }
        });

        MiAdaptador miAdaptador = new MiAdaptador(this,R.layout.list_item,nombres);
        listView.setAdapter(miAdaptador);



    }
}

