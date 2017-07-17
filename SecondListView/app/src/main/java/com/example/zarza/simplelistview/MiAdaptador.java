package com.example.zarza.simplelistview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MiAdaptador extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> nombres;


    public MiAdaptador(Context context,int layout, List<String> nombres){
        this.context = context;
        this.layout = layout;
        this.nombres = nombres;
    }

    @Override //Numero de veces de iteraciòn de una colecciòn
    public int getCount() {
        return this.nombres.size();
    }

    @Override //Obtenemos un item
    public Object getItem(int position) {
        return this.nombres.get(position);
    }

    @Override //Obtenemos el id
    public long getItemId(int id) {
        return 0;
    }

    @Override //Obtenemos el view
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        //ViewHolder Pattern
        ViewHolder holder;

        if(convertView==null){
            //Inflamos el view que almacena los datos personalizados
            LayoutInflater layoutInflater= LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout,null);

            holder = new ViewHolder();

            //Referenciamos el elemento a modificar y lo rellenamos
            holder.nombreTextView = (TextView)convertView.findViewById(R.id.texto);
            convertView.setTag(holder);//inyectamos el dato (nombres)

        }else{
            holder = (ViewHolder)convertView.getTag();
        }


        //traemos el valor actual dependiendo de la position
        String nombreActual = nombres.get(position);

        //Referenciamos el elemento a modificar y lo rellenamos
        holder.nombreTextView.setText(nombreActual);

        //Regresamos modificada nuestra vista
        return convertView  ;
    }


    static class ViewHolder {
        private TextView nombreTextView;
    }
}
