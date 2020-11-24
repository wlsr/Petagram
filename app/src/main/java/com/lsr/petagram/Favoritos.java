package com.lsr.petagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.lsr.petagram.adapter.MascotaAdaptador;
import com.lsr.petagram.pojo.Mascota;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotasF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.layout_titulo);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Para ocultar boton del actionbar
      //  ImageButton resetButton=(ImageButton)findViewById(R.id.btnLikes);
      //  resetButton.setVisibility(View.INVISIBLE); //To set visible

        // Para poder manipular como un objeto.
        listaMascotasF = (RecyclerView) findViewById(R.id.rvMascotasF);
        //Lo vamos a mostrar como una lista
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasF.setLayoutManager(llm);
        inicalizarListaMascotasF();
        inicializarAdaptador();
    }
    public MascotaAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador  = new MascotaAdaptador(mascotas,this);
        listaMascotasF.setAdapter(adaptador);
    }
    public  void inicalizarListaMascotasF(){
       mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Lorenzo",5,R.drawable.lorenzo));
        mascotas.add(new Mascota("Rulo",5,R.drawable.rulo));
        mascotas.add(new Mascota("Firulais",4,R.drawable.dogs));
        mascotas.add(new Mascota("Kitty",3,R.drawable.kitty));
        mascotas.add(new Mascota("Manchas",4,R.drawable.manchas));


    }

}