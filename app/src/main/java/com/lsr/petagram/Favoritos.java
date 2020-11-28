package com.lsr.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.NavUtils;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.lsr.petagram.adapter.FavoritoAdaptador;
import com.lsr.petagram.adapter.PageAdapter;
import com.lsr.petagram.fragment.FavoritosFragment;


import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {
   // private ImageButton btnLikes;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView tvNoFavorita;
    private FavoritoAdaptador favoritoAdaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        //Casteamos para el view pager

        viewPager = (ViewPager) findViewById(R.id.viewPagerF);
        setUpViewPager();
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       //
       // tvNoFavorita = (TextView) findViewById(R.id.tvNoFavorita);
        //tvNoFavorita.setVisibility(View.GONE);
        // Validamos el toolbar
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

    }

    // Agregamos los fragments a la lista.
    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        // Agregamos el primer fragment que se mostrara en el primer tab
        fragments.add(new FavoritosFragment());
        return fragments;
    }

    // Metodo para poner en orbita los fragments
    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
    }

}
