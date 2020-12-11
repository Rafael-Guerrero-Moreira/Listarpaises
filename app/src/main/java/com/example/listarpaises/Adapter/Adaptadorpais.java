package com.example.listarpaises.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.listarpaises.R;
import com.example.listarpaises.model.datos;

import java.util.ArrayList;

public class Adaptadorpais extends ArrayAdapter<datos> {
    public Adaptadorpais(Context context, ArrayList<datos> pais) {
        super(context, R.layout.ly_item, pais);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_item, null);

        TextView lblpais = (TextView)item.findViewById(R.id.lblpais);
        TextView lbltotal = (TextView)item.findViewById(R.id.lbltotal);
        TextView lbltotalmuertes = (TextView)item.findViewById(R.id.lbltotalmuertes);
        TextView lblnuevos = (TextView)item.findViewById(R.id.lblnuevos);



        lblpais.setText("País: "+getItem(position).getPais());
        lbltotal.setText("Total confirmados: "+getItem(position).getTotalconfirmado());
        lbltotalmuertes.setText("Total muertes: "+getItem(position).getTotalmuertes());
        lblnuevos.setText("Total nuevos"+getItem(position).getNuevos());

        return(item);
    }
}
