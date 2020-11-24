package com.lsr.petagram.presentador;

import android.content.Context;

import com.lsr.petagram.db.ConstructorMascotas;
import com.lsr.petagram.fragment.IListaMascotaView;
import com.lsr.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ListaMascotaPresenter implements IListaMascotaPresenter {
    private IListaMascotaView iListaMascotaView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public ListaMascotaPresenter(IListaMascotaView iListaMascotaView, Context context) {
    this.iListaMascotaView = iListaMascotaView;
    this.context = context;
    obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
    constructorMascotas = new ConstructorMascotas(context);
    mascotas = constructorMascotas.obtenerDatos();
    mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
    iListaMascotaView.inicializarAdaptadorRV(iListaMascotaView.crearAdaptador(mascotas));
    iListaMascotaView.generarLinearLayoutVertical();
    }
}
