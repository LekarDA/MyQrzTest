package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import adapters.ExpandableAdapter;
import model.RegionModel;
import rest.GetRegions;

import com.example.myqrztest.BaseFragment;
import com.example.myqrztest.R;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import java.util.Objects;

/**
 * Created by Дмитрий on 12.06.2015.
 */
public class Fragment2 extends BaseFragment {

    private final int _ID_RUSSIA = 1;
    ExpandableListView Exlist;
    RecyclerView recyclerView;
    ExpandableAdapter adapter;

    public static Fragment2 newInstance(long countryId) {
        Fragment2 f = new Fragment2();
        Bundle args = new Bundle();
        args.putLong("countryId", countryId);
        f.setArguments(args);
        return f;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exp_list_regions,container,false);
        Exlist = (ExpandableListView)rootView.findViewById(R.id.expandableListView_regions);
        adapter = new ExpandableAdapter(getActivity().getLayoutInflater(),this);
        getRestManager().execute(new GetRegions.Request(), new GetRegionsListener());
        Exlist.setAdapter(adapter);
        return rootView;
    }

    private class GetRegionsListener implements RequestListener<RegionModel.List> {

        @Override
        public void onRequestFailure(SpiceException spiceException) {
            Toast.makeText(getActivity(), "failure", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRequestSuccess(RegionModel.List regionModels) {
            Toast.makeText(getActivity(),"success",Toast.LENGTH_SHORT).show();
            //if (getArguments().getLong(KEY))
            adapter.setRegions(regionModels);

        }
    }
}
