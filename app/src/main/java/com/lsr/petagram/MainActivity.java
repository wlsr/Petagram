package com.lsr.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;
import com.lsr.petagram.adapter.MascotaAdaptador;
import com.lsr.petagram.adapter.PageAdapter;
import com.lsr.petagram.fragment.listaMascotas;
import com.lsr.petagram.fragment.perfilMascotas;
import com.lsr.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnLikes;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Casteamos para el view pager
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        // Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        // setSupportActionBar(miActionBar);


        // Validamos el toolbar
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

       // Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);

        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.layout_titulo);

        /*btnLikes    = (ImageButton) findViewById(R.id.btnLikes);



        //GridLayoutManager glm= new GridLayoutManager(this,2);
        ////////////
        btnLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Favoritos.class);
                startActivity(intent);
            }
        });*/

    }
    // Agregamos los fragments a la lista.
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        // Agregamos el primer fragment que se mostrara en el primer tab
        fragments.add(new listaMascotas());
        fragments.add(new perfilMascotas());
        return fragments;
    }
    // Metodo para poner en orbita los fragments
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.bolivia);
        tabLayout.getTabAt(1).setIcon(R.drawable.whatsapp);
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

}