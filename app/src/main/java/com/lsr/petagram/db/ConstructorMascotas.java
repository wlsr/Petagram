package com.lsr.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.lsr.petagram.R;
import com.lsr.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
       /* ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Firulais",4, R.drawable.dogs));
        mascotas.add(new Mascota("Kitty",3,R.drawable.kitty));
        mascotas.add(new Mascota("Lorenzo",5,R.drawable.lorenzo));
        mascotas.add(new Mascota("Rulo",5,R.drawable.rulo));
        mascotas.add(new Mascota("Manchas",4,R.drawable.manchas));
        return mascotas;

        */
        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        return db.obtenerTodasLasMascotas();
    }
    public void insertarTresMascotas(BaseDatos db){
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
    }
}
