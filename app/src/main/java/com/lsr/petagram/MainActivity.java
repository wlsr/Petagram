package com.lsr.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private ImageButton btnLikes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.layout_titulo);

        btnLikes    = (ImageButton) findViewById(R.id.btnLikes);

        // Para poder manipular como un objeto.
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        //Lo vamos a mostrar como una lista
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm= new GridLayoutManager(this,2);
        ////////////
        btnLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Favoritos.class);
                startActivity(intent);
            }
        });
        ////////////////
        listaMascotas.setLayoutManager(llm);
        inicalizarListaMascotas();
        inicializarAdaptador();
    }
    // menu de opciones

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opcion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       switch  (item.getItemId()){
           case R.id.mContact:
               Intent intent = new Intent(this, FormularioContacto.class);
               startActivity(intent);
           break;
           case R.id.mAbout:
               Intent intent1 = new Intent(this, About.class);
               startActivity(intent1);
           break;
       }
        return super.onOptionsItemSelected(item);
    }

    public MascotaAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador  = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }
    public  void inicalizarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Firulais","Perro","Jack Russell","5","Macho","4",R.drawable.dogs));
        mascotas.add(new Mascota("Kitty","Gato","Friskies","6","Hembra","3",R.drawable.kitty));
        mascotas.add(new Mascota("Lorenzo","Loro","Lor","8","Macho","5",R.drawable.lorenzo));
        mascotas.add(new Mascota("Rulo","perro","Caniche","9","Macho","5",R.drawable.rulo));
        mascotas.add(new Mascota("Manchas","Perro","Mestiza","10","Hembra","4",R.drawable.manchas));


    }
}