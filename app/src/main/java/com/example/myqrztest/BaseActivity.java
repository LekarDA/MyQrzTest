package com.example.myqrztest;

import android.app.Activity;

import com.octo.android.robospice.SpiceManager;

import rest.RestService;

/**
 * Created by dmitriy on 21.06.15.
 */
public class BaseActivity extends Activity {
    private SpiceManager mRestManager = new SpiceManager(RestService.class);

    @Override
    protected void onStart() {
        mRestManager.start(this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        mRestManager.shouldStop();
        super.onStop();
    }
    public SpiceManager getRestManager() {
        return mRestManager;
    }
}
