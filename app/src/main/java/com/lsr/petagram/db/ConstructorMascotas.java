package com.lsr.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.lsr.petagram.MainActivity;
import com.lsr.petagram.R;
import com.lsr.petagram.fragment.FavoritosFragment;
import com.lsr.petagram.pojo.Mascota;

import java.util.ArrayList;
import java.util.prefs.Preferences;

public class ConstructorMascotas {
    private static final int LIKE = 1 ;
    private Context context;


    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        return db.obtenerTodasLasMascotas();
    }
    public ArrayList<Mascota> obtenerDatosF() {
       /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Firulais",4, R.drawable.dogs));
        mascotas.add(new Mascota("Kitty",3,R.drawable.kitty));
        mascotas.add(new Mascota("Lorenzo",5,R.drawable.lorenzo));
        mascotas.add(new Mascota("Rulo",5,R.drawable.rulo));
        mascotas.add(new Mascota("Manchas",4,R.drawable.manchas));
        return mascotas;
        */

        BaseDatos db = new BaseDatos(context);
        return db.obtenerUltimas();
    }
    public void insertarTresMascotas(BaseDatos db){
        // Accede a las preferencias del usuario utilizando el paquete de la clase.
        Preferences preferences = Preferences.userNodeForPackage(Preferences.class);

        // Almacenas las preferencias en pares clave valor.
        //preferences.putBoolean("verdadero", true);

        // Obtienen las preferencias. En caso de que la preferencia
        // no exista, retorna el valor por defecto. El valor por
        // defecto de la preferencia es el que se le pasa como
        // segundo parametro.
        boolean verdadero = preferences.getBoolean("verdadero", false);
        //Log.i("VERDAD", "insertarTresMascotas: " + verdadero);
        if (verdadero == false) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Rulo");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dogs);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Firulais");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.rulo);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Goku");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.manchas);
            db.insertarMascota(contentValues);
            preferences.putBoolean("verdadero", true);
            //Log.i("FALSO", "insertarTresMascotas: " + verdadero);
        }


    }
    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascotas(mascota);

    }
}
