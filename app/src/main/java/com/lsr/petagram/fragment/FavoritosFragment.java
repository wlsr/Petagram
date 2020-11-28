package com.lsr.petagram.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.lsr.petagram.R;
import com.lsr.petagram.adapter.FavoritoAdaptador;
import com.lsr.petagram.db.ConstructorMascotas;
import com.lsr.petagram.pojo.Mascota;
import com.lsr.petagram.presentador.FavoritosPresenter;
import com.lsr.petagram.presentador.IFavoritosPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritosFragment extends Fragment implements IFavoritosFragmentView {
    ArrayList<Mascota> favorito;
    private RecyclerView favoritos;
    private IFavoritosPresenter presenter;
    private Toolbar toolbar;
    private Activity activity;
    private TextView tvNoFavoritaP;
    private FavoritoAdaptador favoritoAdaptador;
    private Context context;
    public FavoritosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_favoritos_mascotas, container, false);
        // Para poder manipular como un objeto.
        favoritos = (RecyclerView) v.findViewById(R.id.rvMascotasF);
        presenter = new FavoritosPresenter(this, getContext());
        tvNoFavoritaP = (TextView) v.findViewById(R.id.tvNoFavoritaP);

        Log.i("chingadera", "onCreateView: "+ favoritos.getAdapter().getItemCount());
        if(favoritos.getAdapter() != null){
            //De esta manera sabes si tu RecyclerView está vacío
            if(favoritos.getAdapter().getItemCount() >= 1) {

               tvNoFavoritaP.setVisibility(View.GONE);
            }

        }
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        //Lo vamos a mostrar como una lista
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        favoritos.setLayoutManager(llm);
    }

    @Override
    public FavoritoAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        FavoritoAdaptador adaptador  = new FavoritoAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(FavoritoAdaptador adaptador) {
        favoritos.setAdapter(adaptador);
    }
}