package com.lsr.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lsr.petagram.R;
import com.lsr.petagram.pojo.Mascota;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {
    ArrayList<Mascota> perfilMascota;
    Activity activity;
    public PerfilAdaptador (ArrayList<Mascota>perfilMascota, Activity activity){

        this.perfilMascota = perfilMascota;
        this.activity  = activity;
    }


    // Inflara el layout y lo pasará al viewholder para el obtenga los views
    @NonNull
    @Override
    public PerfilAdaptador.PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascota, parent, false);



        return new PerfilAdaptador.PerfilViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull PerfilAdaptador.PerfilViewHolder perfilViewHolder, int position) {
        Mascota perfil = perfilMascota.get(position);
        perfilViewHolder.imgFoto.setImageResource(perfil.getFoto());
        perfilViewHolder.contadorLike.setText(perfil.getLikes());
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista.
        return perfilMascota.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private ImageView imgLike;
        private TextView contadorLike;



        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
            imgLike     = (ImageView) itemView.findViewById(R.id.imgLike);
            contadorLike= (TextView) itemView.findViewById(R.id.contadorLike);

        }
    }
}
