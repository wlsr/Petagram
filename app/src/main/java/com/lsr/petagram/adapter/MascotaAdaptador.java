package com.lsr.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.lsr.petagram.R;
import com.lsr.petagram.db.ConstructorMascotas;
import com.lsr.petagram.pojo.Mascota;

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
            final Mascota mascota = mascotas.get(position);
            mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
            mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
            mascotaViewHolder.tvLike.setText(String.valueOf(mascota.getLikes()));
            mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity,"Like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();

                    ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                    constructorMascotas.darLikeMascota(mascota);
                    mascotaViewHolder.tvLike.setText(constructorMascotas.obtenerLikesMascota(mascota)+"");
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
            private TextView tvLike;

            public MascotaViewHolder(@NonNull View itemView) {
                super(itemView);
                imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
                btnLike     = (ImageButton) itemView.findViewById(R.id.btnLike);
                tvNombreCV  = (TextView) itemView.findViewById(R.id.tvNombreCV);
                imgLike     = (ImageView) itemView.findViewById(R.id.imgLike);
                tvLike      = (TextView) itemView.findViewById(R.id.tvLike);

            }

        }
    }




