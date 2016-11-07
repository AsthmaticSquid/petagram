package com.calamarasmtic.petagram.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calamarasmtic.petagram.R;
import com.calamarasmtic.petagram.adapter.MascotAdaptor;
import com.calamarasmtic.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Calamar Asmàtic on 05/11/2016.
 */

public class RecyclerViewFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        //
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();
        //
        return v;
    }

    public void inicializarAdaptador(){
        MascotAdaptor adaptador = new MascotAdaptor(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.ca, "Duff", 1));
        mascotas.add(new Mascota(R.drawable.gat, "Nermal", 1));
        mascotas.add(new Mascota(R.drawable.lloro, "Wings", 1));
        mascotas.add(new Mascota(R.drawable.zoid, "Mister Zoid", 5));
        mascotas.add(new Mascota(R.drawable.pandaaligator, "Bear", 4));

    }
}
