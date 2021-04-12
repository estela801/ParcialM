package com.example.thesalon;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.thesalon.datos.Cita;

import java.util.List;
public class ProgCitas extends ArrayAdapter<Cita>{

    List<Cita> citas;
    private Activity context;

    public ProgCitas(@NonNull Activity context, @NonNull List<Cita> citas) {
        super(context, R.layout.activity_prog_citas, citas);
        this.context = context;
        this.citas = citas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        // Método invocado tantas veces como elementos tenga la coleccion personas
        // para formar a cada item que se visualizara en la lista personalizada
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View rowview=null;
        // optimizando las diversas llamadas que se realizan a este método
        // pues a partir de la segunda llamada el objeto view ya viene formado
        // y no sera necesario hacer el proceso de "inflado" que conlleva tiempo y
        // desgaste de bateria del dispositivo
        if (view == null)
            rowview = layoutInflater.inflate(R.layout.activity_prog_citas,null);
        else rowview = view;

        TextView tvServicio = rowview.findViewById(R.id.tvServicio);
        TextView tvFecha = rowview.findViewById(R.id.tvFecha);
        TextView tvHora = rowview.findViewById(R.id.tvHora);
        TextView tvObservacion = rowview.findViewById(R.id.tvObservaciones);


        tvServicio.setText("servicio : "+citas.get(position).getServicio());
        tvFecha.setText("fecha : " + citas.get(position).getFecha());
        tvHora.setText("hora : " + citas.get(position).getHora());
        tvObservacion.setText("observaciones : " + citas.get(position).getObservacion());

        return rowview;
    }
}