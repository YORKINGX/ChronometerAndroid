package com.administrador.chronometerandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.administrador.chronometerandroid.R;
import com.administrador.chronometerandroid.model.ElemntListLaps;

import java.util.List;

/**
 * Created by Administrador on 09/07/2017.
 */

public class LapsAdapter extends BaseAdapter{



    Context mContext;
    List<ElemntListLaps> mListLaps;



    public LapsAdapter(Context mContext, List<ElemntListLaps> mListLaps) {
        this.mContext = mContext;
        this.mListLaps = mListLaps;
    }
    public LapsAdapter() {
    }


    @Override
    public int getCount() {
        return mListLaps.size();
    }

    @Override
    public Object getItem(int position) {
        return mListLaps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mListLaps.get(position).getNumLaps();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.elemntlist,null);

        TextView id_laps = (TextView) view.findViewById(R.id.id_laps);
        TextView laps_dsc = (TextView) view.findViewById(R.id.laps_dsc);
        TextView laps_value = (TextView) view.findViewById(R.id.laps_value);


       id_laps.setText(String.valueOf(mListLaps.get(position).getNumLaps()));
       laps_dsc.setText(mListLaps.get(position).getDscription());
       laps_value.setText(mListLaps.get(position).getLaps());




        return view;
    }
}
