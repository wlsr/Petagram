package com.lsr.petagram.fragment;

import com.lsr.petagram.adapter.MascotaAdaptador;
import com.lsr.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IListaMascotaView {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
