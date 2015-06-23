package com.example.myqrztest;

import android.app.Fragment;

import com.octo.android.robospice.SpiceManager;

/**
 * Created by dmitriy on 21.06.15.
 */
public class BaseFragment extends Fragment {

    protected SpiceManager getRestManager() {

        return ((BaseActivity)getActivity()).getRestManager();
    }
}
