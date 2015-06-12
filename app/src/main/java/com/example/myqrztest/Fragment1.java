package com.example.myqrztest;


import android.app.Fragment;

import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * Created by Дмитрий on 12.06.2015.
 */
    public class Fragment1 extends Fragment {
    AdapterForContries adapter;
    ListView listViewCountries;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_view_countries,container,false);
        listViewCountries = (ListView)rootView.findViewById(R.id.listView_countries);
        listViewCountries.setAdapter(adapter);
        return rootView;
    }
}
