package com.lsr.petagram;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
        ArrayList<Mascota> mascotas;
        Activity activity;


        public MascotaAdaptador (ArrayList<Mascota>mascotas, Activity activity){

            this.mascotas = mascotas;
            this.activity  = activity;
        }

        // Inflara el layout y lo pasará al viewholder para el obtenga los views
        @NonNull
        @Override
        public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);



            return new MascotaViewHolder(v);
        }

        //Asocia cada elemento de la lista con cada view
        @Override
        public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
            Mascota mascota = mascotas.get(position);
            mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
            mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
            mascotaViewHolder.contadorLike.setText(mascota.getLikes());
            mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity,"Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() { //Cantidad de elementos que contiene mi lista.
            return mascotas.size();
        }

        public static class MascotaViewHolder extends RecyclerView.ViewHolder{
            private ImageView imgFoto;
            private ImageButton btnLike;
            private TextView tvNombreCV;
            private ImageView imgLike;
            private TextView contadorLike;



            public MascotaViewHolder(@NonNull View itemView) {
                super(itemView);
                imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
                btnLike     = (ImageButton) itemView.findViewById(R.id.btnLike);
                tvNombreCV  = (TextView) itemView.findViewById(R.id.tvNombreCV);
                imgLike     = (ImageView) itemView.findViewById(R.id.imgLike);
                contadorLike= (TextView) itemView.findViewById(R.id.contadorLike);




            }

        }
    }




