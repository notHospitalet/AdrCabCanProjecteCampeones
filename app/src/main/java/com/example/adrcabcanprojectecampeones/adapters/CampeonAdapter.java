package com.example.adrcabcanprojectecampeones.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.adrcabcanprojectecampeones.R;
import com.example.adrcabcanprojectecampeones.models.Campeon;

import java.util.List;

public class CampeonAdapter extends BaseAdapter {

    private final Context context;
    private final List<Campeon> campeonList;

    public CampeonAdapter(Context context, List<Campeon> campeonList) {
        this.context = context;
        this.campeonList = campeonList;
    }

    @Override
    public int getCount() {
        return campeonList.size();
    }

    @Override
    public Object getItem(int position) {
        return campeonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.campeon_row, viewGroup, false);
        }

        Campeon campeon = campeonList.get(position);

        TextView nombreTextView = view.findViewById(R.id.textView_nombreCampeon);
        nombreTextView.setText(campeon.getNombre());

        ImageView imagenView = view.findViewById(R.id.imageViewCampeon);
        Glide.with(context).load(campeon.getImagen()).into(imagenView);

        return view;
    }
}