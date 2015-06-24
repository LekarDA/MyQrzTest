package com.example.myqrztest.regions_and_diploms;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myqrztest.BaseFragment;
import com.example.myqrztest.R;
import com.example.myqrztest.model.DiplomModel;
import com.example.myqrztest.model.RegionModel;
import com.example.myqrztest.rest.GetDiplomsByRegions;
import com.example.myqrztest.rest.GetRegions;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

public class RegionsAndDiplomsFragment extends BaseFragment implements OnRegionClickListener {

    private static final String ARG_COUNTRY_ID = "countryId";

    private RecyclerView rvList;
    private RegionsAndDiplomsAdapter mAdapter;

    private long mCountryId;

    public static RegionsAndDiplomsFragment newInstance(long countryId) {
        RegionsAndDiplomsFragment f = new RegionsAndDiplomsFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_COUNTRY_ID, countryId);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mAdapter = new RegionsAndDiplomsAdapter(activity.getLayoutInflater());
        mCountryId = getArguments().getLong(ARG_COUNTRY_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_regions_and_diploms, container, false);
        rvList = (RecyclerView) rootView.findViewById(R.id.fragment_regions_and_diploms_rvList);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvList.setAdapter(mAdapter);
        mAdapter.setOnRegionClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        getRestManager().execute(new GetRegions.Request(), new GetRegionsListener());
    }

    @Override
    public void onRegionClick(RegionModel region, RegionViewHolder holder, int position) {
        boolean isRegionAlreadyExpanded = mAdapter.isRegionExpanded(region);
        mAdapter.collapseRegion();
        if (isRegionAlreadyExpanded) return;
        holder.setLoading(true);
//        Toast.makeText(getActivity(), "mCountryId "+ mCountryId+", region.getId()"+region.getId(), Toast.LENGTH_SHORT).show();
        getRestManager().execute(new GetDiplomsByRegions.Request(mCountryId, region.getId()), new GetDiplomsByRegionsListener(region));
    }

    private class GetRegionsListener implements RequestListener<RegionModel.List> {

        @Override
        public void onRequestFailure(SpiceException spiceException) {
            Toast.makeText(getActivity(), "failure", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRequestSuccess(RegionModel.List regionModels) {
            mAdapter.setRegions(regionModels);
        }
    }

    private class GetDiplomsByRegionsListener implements RequestListener<com.example.myqrztest.model.DiplomModel.List> {

        private RegionModel mRegion;

        public GetDiplomsByRegionsListener(RegionModel region) {
            mRegion = region;
        }

        @Override
        public void onRequestFailure(SpiceException spiceException) {
            Toast.makeText(getActivity(), "failure", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRequestSuccess(DiplomModel.List diplomModels) {
            mAdapter.expandRegion(mRegion, diplomModels);
//            Toast.makeText(getActivity(), "diplomModels " + diplomModels, Toast.LENGTH_SHORT).show();
        }
    }
}
