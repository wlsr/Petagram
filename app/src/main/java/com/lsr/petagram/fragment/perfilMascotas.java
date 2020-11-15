package com.lsr.petagram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lsr.petagram.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class perfilMascotas extends Fragment {

    public perfilMascotas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil_mascotas, container, false);
    }
}