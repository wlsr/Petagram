package com.lsr.petagram.db;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.lsr.petagram.Favoritos;
import com.lsr.petagram.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {


    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATA_BASE_NAME, null, ConstantesBaseDatos.DATA_BASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE "+ ConstantesBaseDatos.TABLE_MASCOTA + "("+
                ConstantesBaseDatos.TABLE_MASCOTA_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO   + " INTEGER"+ ")";

        String queryLikes = "CREATE TABLE "+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "("+
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA+ " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_LIKES + " INTEGER, "+
                "FOREIGN KEY ("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") " +
                "REFERENCES "+ ConstantesBaseDatos.TABLE_MASCOTA + "("+ConstantesBaseDatos.TABLE_MASCOTA_ID+")"+ ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }
    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor registros = db.rawQuery(query, null);


        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);

        }

        db.close();

        return mascotas;
    }
    public ArrayList<Mascota> obtenerUltimas() {
        ArrayList<Mascota> listaMascotasF = new ArrayList<>();

        String query = "SELECT DISTINCT mascota.id,mascota.nombre,mascota.foto,mascota_likes.id_mascota FROM mascota,mascota_likes WHERE mascota.id = mascota_likes.id_mascota Order by (mascota_likes.id) DESC LIMIT 5";
        Log.i("CONSULTA", "obtenerUltimas: "+ query);
        //SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db= this.getReadableDatabase();
        Log.i("CONSULTA2", "obtenerUltimas: "+ db);
        Cursor registros = db.rawQuery(query, null);



        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_LIKES+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }
            listaMascotasF.add(mascotaActual);
        }

        db.close();

        return listaMascotasF;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA,null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }


    public int obtenerLikesMascotas(Mascota mascota){
        int likes = 0;
        String query = " SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_LIKES+")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "="+mascota.getId();


        //String query = "SELECT COUNT (numero_likes) FROM contacto_likes WHERE id_contacto="+contacto.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }

}
