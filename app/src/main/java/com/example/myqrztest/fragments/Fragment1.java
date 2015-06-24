package com.example.myqrztest.fragments;




import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myqrztest.adapters.AdapterForCountries;
import com.example.myqrztest.BaseFragment;
import com.example.myqrztest.rest.GetCountries;
import com.example.myqrztest.R;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import com.example.myqrztest.model.CountryModel;


/**
 * Created by Дмитрий on 12.06.2015.
 */
    public class Fragment1 extends BaseFragment {
    AdapterForCountries adapter;
    ListView listViewCountries;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_view_countries,container,false);
        listViewCountries = (ListView)rootView.findViewById(R.id.listView_countries);
        adapter = new AdapterForCountries(getActivity(),inflater);
        getRestManager().execute(new GetCountries.Request(), new GetCountiesListener());
        listViewCountries.setAdapter(adapter);
        listViewCountries.setOnItemClickListener((AdapterView.OnItemClickListener) getActivity());
        return rootView;
    }


    private class GetCountiesListener implements RequestListener<CountryModel.List> {
        @Override
        public void onRequestFailure(SpiceException spiceException) {
            Toast.makeText(getActivity(), "failure", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRequestSuccess(CountryModel.List countryModels) {
            Toast.makeText(getActivity(),"success",Toast.LENGTH_SHORT).show();
            adapter.setAdapterData(countryModels);

        }
    }
}
