package com.example.myqrztest.regions_and_diploms;

import com.example.myqrztest.model.RegionModel;

public interface OnRegionClickListener {
    void onRegionClick(RegionModel regionModel, RegionViewHolder holder, int position);
}