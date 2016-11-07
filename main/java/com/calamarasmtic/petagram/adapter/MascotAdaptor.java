package com.calamarasmtic.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.calamarasmtic.petagram.ActivityFavoritoMascotas;
import com.calamarasmtic.petagram.pojo.Mascota;
import com.calamarasmtic.petagram.R;

import java.util.ArrayList;


public class MascotAdaptor extends RecyclerView.Adapter<MascotAdaptor.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    private Activity activity;

    public MascotAdaptor(ArrayList<Mascota> pets, FragmentActivity mainActivity){
        this.mascotas = pets;
        this.activity = mainActivity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota m = mascotas.get(position);
        holder.imgFotoCV.setImageResource(m.getFoto());
        holder.tvNombreCV.setText(m.getNombre());
       // holder.tvContCV.setText(m.getVotos());


        holder.imgFotoCV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, m.getNombre(), Toast.LENGTH_SHORT).show();
                ImageView foto = (ImageView) v.findViewById(R.id.imgFotoCV);
                Bitmap bm = ((BitmapDrawable)foto.getDrawable()).getBitmap();
                Intent i = new Intent( activity, ActivityFavoritoMascotas.class);
                i.putExtra("bitMap", bm);
                i.putExtra("votos", m.getVotos());
                i.putExtra("nombre", m.getNombre());
                activity.startActivity(i);
            }
        });

        holder.btnWhiteBoneCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + m.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvContCV;
        private ImageButton btnWhiteBoneCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvContCV = (TextView) itemView.findViewById(R.id.tvContCV);
            btnWhiteBoneCV = (ImageButton) itemView.findViewById(R.id.btnWhiteBoneCV);
        }
    }



    }

