package com.lsr.petagram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsr.petagram.R;
import com.lsr.petagram.adapter.MascotaAdaptador;
import com.lsr.petagram.adapter.PerfilAdaptador;
import com.lsr.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class perfilMascotas extends Fragment {
    ArrayList<Mascota> perfil;
    private RecyclerView perfilMascotas;

    public perfilMascotas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil_mascotas, container, false);
        // Para poder manipular como un objeto.
        perfilMascotas = (RecyclerView) v.findViewById(R.id.rvPerfilMascotas);
        //Lo vamos a mostrar como una lista
        GridLayoutManager glm= new GridLayoutManager(getActivity(),3);
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        perfilMascotas.setLayoutManager(glm);
        inicalizarPerfilMascota();
        inicializarAdaptador();
        return v;
    }
    public PerfilAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador  = new PerfilAdaptador(perfil,getActivity());
        perfilMascotas.setAdapter(adaptador);
    }
    public  void inicalizarPerfilMascota(){
        perfil = new ArrayList<Mascota>();

        perfil.add(new Mascota("Theo","18",R.drawable.theo1));
        perfil.add(new Mascota("Theo","15",R.drawable.theo2));
        perfil.add(new Mascota("Theo","20",R.drawable.theo3));
        perfil.add(new Mascota("Theo","6",R.drawable.theo4));
        perfil.add(new Mascota("Theo","9",R.drawable.theo5));
        perfil.add(new Mascota("Theo","5",R.drawable.theo6));
        perfil.add(new Mascota("Theo","6",R.drawable.theo7));
        }

}