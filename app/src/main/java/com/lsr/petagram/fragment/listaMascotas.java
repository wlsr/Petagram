package com.lsr.petagram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsr.petagram.R;
import com.lsr.petagram.adapter.MascotaAdaptador;
import com.lsr.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class listaMascotas extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public listaMascotas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista_mascotas, container, false);
        // Para poder manipular como un objeto.
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        //Lo vamos a mostrar como una lista
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicalizarListaMascotas();
        inicializarAdaptador();
        return v;
    }
    public MascotaAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador  = new MascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }
    public  void inicalizarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Firulais","Perro","Jack Russell","5","Macho","4",R.drawable.dogs));
        mascotas.add(new Mascota("Kitty","Gato","Friskies","6","Hembra","3",R.drawable.kitty));
        mascotas.add(new Mascota("Lorenzo","Loro","Lor","8","Macho","5",R.drawable.lorenzo));
        mascotas.add(new Mascota("Rulo","perro","Caniche","9","Macho","5",R.drawable.rulo));
        mascotas.add(new Mascota("Manchas","Perro","Mestiza","10","Hembra","4",R.drawable.manchas));
    }
}