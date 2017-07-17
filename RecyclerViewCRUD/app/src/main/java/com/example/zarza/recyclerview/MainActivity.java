package com.example.zarza.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> names;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private int counter =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = getAllNames();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager = new GridLayoutManager(this,2);
        layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        mAdapter = new MyAdapter(names, R.layout.recycler, new MyAdapter.onItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                deleteName(position);
                Toast.makeText(MainActivity.this, "Elemento "+name+" eliminado "+position, Toast.LENGTH_SHORT).show();
            }
        });

        //Decimos que tenemos un límite establecido para el string
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.add:
                this.addName(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addName(int position) {
        names.add(position,"Nuevo elemento nº: "+(++counter));
        mAdapter.notifyItemInserted(position);
        layoutManager.scrollToPosition(position);
    }

    private void deleteName(int position){
        names.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    private List<String> getAllNames(){
        return new ArrayList<String>(){{
            add("Adrian");
            add("Ken");
            add("Karen");
            add("Tanya");
            add("Bruce");
            add("Carol");
            add("Papu");
        }};
    }
}
