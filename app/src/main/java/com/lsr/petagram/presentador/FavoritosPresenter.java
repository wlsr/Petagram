package com.lsr.petagram.presentador;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.lsr.petagram.fragment.IFavoritosFragmentView;
import com.lsr.petagram.db.ConstructorMascotas;
import com.lsr.petagram.pojo.Mascota;

import java.util.ArrayList;

public class FavoritosPresenter implements IFavoritosPresenter {
    private IFavoritosFragmentView iFavoritos;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> listaMascotasF;

    public FavoritosPresenter(IFavoritosFragmentView iFavoritos, Context context) {
        this.iFavoritos = iFavoritos;
        this.context = context;
        obtenerMascotasFBaseDatos();
    }

    @Override
    public void obtenerMascotasFBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        listaMascotasF = constructorMascotas.obtenerDatosF();
        mostrarMascotasFRV();
    }

    @Override
    public void mostrarMascotasFRV() {
        iFavoritos.inicializarAdaptadorRV(iFavoritos.crearAdaptador(listaMascotasF));
        iFavoritos.generarLinearLayoutVertical();
    }
}
