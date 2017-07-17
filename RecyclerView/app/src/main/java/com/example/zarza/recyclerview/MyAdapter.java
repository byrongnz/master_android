package com.example.zarza.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zarza on 24/01/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> names;
    private int layout;
    private onItemClickListener itemClickListener;


    public MyAdapter (List<String> names, int layout, onItemClickListener itemClickListener){
        this.names = names;
        this.layout = layout;
        this.itemClickListener= itemClickListener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflamos el layout
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);


        return viewHolder;
    }

    //Volcamos los datos en el viewHolder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(names.get(position),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.nameTextView = (TextView)itemView.findViewById(R.id.miPerro);
        }
        public void bind(final String name, final onItemClickListener listener){
            this.nameTextView.setText(name);
            //Es nuestra vista de la lista. Un object de ViewHolder de Recycler View
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Ese get adapterPosition nos da la posición actul
                    listener.onItemClick(name,getAdapterPosition());
                }
            });

        }
    }

    public interface onItemClickListener{
        void onItemClick(String name,int position);
    }

}
