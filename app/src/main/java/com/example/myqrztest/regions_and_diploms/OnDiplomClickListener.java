package com.example.myqrztest.regions_and_diploms;

import com.example.myqrztest.model.DiplomDetailModel;
import com.example.myqrztest.model.DiplomModel;

/**
 * Created by dmitriy on 26.06.15.
 */
public interface OnDiplomClickListener {
    void onDiplomClick(DiplomModel model,DiplomViewHolder holder,int position);
}
