package com.example.myqrztest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myqrztest.BaseFragment;
import com.example.myqrztest.R;

/**
 * Created by dmitriy on 26.06.15.
 */
public class Fragment3DetailDiplom extends BaseFragment {
    public final String TITLE ="title";
    public final String DESCRIPTION ="description";

    TextView title;
    TextView description;

    public static Fragment3DetailDiplom newInstance(String title,String description){
        Fragment3DetailDiplom f3 = new Fragment3DetailDiplom();
        Bundle args = new Bundle();
        args.putString("title",title);
        args.putString("description", description);
        f3.setArguments(args);
        return f3;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_3_detail_diplom,container,false);
        title = (TextView)rootView.findViewById(R.id.textView_title);
        description = (TextView)rootView.findViewById(R.id.textView_Description);
        title.setText(getArguments().get(TITLE).toString());
        description.setText(getArguments().getString(DESCRIPTION));

        return rootView;
    }
}
