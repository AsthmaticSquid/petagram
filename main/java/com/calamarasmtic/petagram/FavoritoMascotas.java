package com.calamarasmtic.petagram;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.calamarasmtic.petagram.R.id.imgFotoCV;
import static com.calamarasmtic.petagram.R.id.tvContCV;
import static com.calamarasmtic.petagram.R.id.tvNombreCV;

public class FavoritoMascotas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito_mascotas);

        Toolbar miToolBar = (Toolbar) findViewById(R.id.miToolBar);
        setSupportActionBar(miToolBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle params = getIntent().getExtras();
        Intent i = getIntent();
        Bitmap bm = i.getParcelableExtra("bitMap");

        int votos = params.getInt("votos");
        String nombre = params.getString("nombre");

        ImageView imgFotoCV = (ImageView) findViewById(R.id.imgFotoCV);
        TextView tvContCV = (TextView) findViewById(R.id.tvContCV);
        TextView tvNombreCV = (TextView) findViewById(R.id.tvNombreCV);

        imgFotoCV.setImageBitmap(bm);
        tvContCV.setText(votos);
        tvNombreCV.setText(nombre);
    }



    public void goToFavs(View v){
        Intent i = new Intent(this, FavoritoMascotas.class);
        startActivity(i);
    }

    public void upRatePet(View view) {
        //todo
        // incrementa el número de votos de una mascota en uno.
    }

    public void goToMain(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
