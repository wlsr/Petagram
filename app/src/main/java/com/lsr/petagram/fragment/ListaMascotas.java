package com.lsr.petagram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsr.petagram.R;
import com.lsr.petagram.adapter.MascotaAdaptador;
import com.lsr.petagram.pojo.Mascota;
import com.lsr.petagram.presentador.IListaMascotaPresenter;
import com.lsr.petagram.presentador.ListaMascotaPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaMascotas extends Fragment implements IListaMascotaView {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IListaMascotaPresenter presenter;
    public ListaMascotas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista_mascotas, container, false);
        // Para poder manipular como un objeto.
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new ListaMascotaPresenter(this, getContext());
        Log.i("presenter", "obtenerUltimas:" + presenter);
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        //Lo vamos a mostrar como una lista
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador  = new MascotaAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}