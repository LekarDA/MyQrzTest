package com.example.myqrztest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Дмитрий on 12.06.2015.
 */
public class AdapterForContries extends BaseAdapter {
    private Context mContext;
    private List<String> countries;
    private LayoutInflater mLayoutInflator;
    private String data[] = new String[] { "Russia", "Ukraine", "Moldova", "Germany" };

    public AdapterForContries(Context context, LayoutInflater inflater) {
        mContext = context;
        mLayoutInflator = inflater;
        generateCountries();
    }

    private void generateCountries() {
        for (int i= 0; i<data.length;i++){
            countries.add(data[i]);
        }
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public String getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView = mLayoutInflator.inflate(R.layout.item_country,parent,false);
        TextView countryName = (TextView)convertView.findViewById(R.id.fragment_country_list_view_item);
        countryName.setText(countries.get(position));
        return convertView;
    }
}
