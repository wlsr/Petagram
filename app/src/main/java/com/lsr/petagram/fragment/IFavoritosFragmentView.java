package com.lsr.petagram.fragment;

import com.lsr.petagram.adapter.FavoritoAdaptador;
import com.lsr.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IFavoritosFragmentView {
    public void generarLinearLayoutVertical();
    public FavoritoAdaptador crearAdaptador(ArrayList<Mascota> listaMascotasF);
    public void inicializarAdaptadorRV(FavoritoAdaptador adaptador);
}
