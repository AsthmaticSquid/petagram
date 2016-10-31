package com.calamarasmtic.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import static com.calamarasmtic.petagram.R.id.rvMascotas;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaPets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miToolBar = (Toolbar) findViewById(R.id.miToolBar);
        setSupportActionBar(miToolBar);

        listaPets = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaPets.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();

    }

    public MascotaAdaptador adaptador;

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaPets.setAdapter(adaptador);
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.ca, "Duff", 1));
        mascotas.add(new Mascota(R.drawable.gat, "Nermal", 1));
        mascotas.add(new Mascota(R.drawable.lloro, "Wings", 1));
        mascotas.add(new Mascota(R.drawable.zoid, "Mister Zoid", 5));
        mascotas.add(new Mascota(R.drawable.pandaaligator, "Bear", 4));

    }

}
