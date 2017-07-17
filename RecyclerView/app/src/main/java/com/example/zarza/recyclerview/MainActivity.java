package com.example.zarza.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> names;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = getAllNames();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);

        mAdapter = new MyAdapter(names, R.layout.recycler, new MyAdapter.onItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                Toast.makeText(MainActivity.this, name+" - "+position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

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
