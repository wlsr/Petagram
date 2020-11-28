package com.lsr.petagram.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lsr.petagram.R;
import com.lsr.petagram.pojo.Mascota;

import java.util.ArrayList;

public class FavoritoAdaptador extends RecyclerView.Adapter<FavoritoAdaptador.FavoritoViewHolder> {
    ArrayList<Mascota> favoritos;
    Activity activity;

    public FavoritoAdaptador (ArrayList<Mascota>mascotas, Activity activity){

        this.favoritos = mascotas;
        this.activity  = activity;
    }


    // Inflara el layout y lo pasará al viewholder para el obtenga los views
    @NonNull
    @Override
    public FavoritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_favoritos, parent, false);

        return new FavoritoViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull FavoritoViewHolder favoritoViewHolder, int position) {
        final Mascota mascota = favoritos.get(position);
        favoritoViewHolder.imgFoto.setImageResource(mascota.getFoto());
        favoritoViewHolder.tvNombreCV.setText(mascota.getNombre());
        favoritoViewHolder.tvLike.setText(String.valueOf(mascota.getLikes()));

    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista.
     return favoritos.size();
    }


    public static class FavoritoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageView imgLike;
        private TextView tvLike;



        public FavoritoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV  = (TextView) itemView.findViewById(R.id.tvNombreCV);
            imgLike     = (ImageView) itemView.findViewById(R.id.imgLike);
            tvLike      = (TextView) itemView.findViewById(R.id.tvLike);


        }


    }
}




