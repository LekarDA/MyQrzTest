package com.example.myqrztest.regions_and_diploms;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myqrztest.R;
import com.example.myqrztest.model.RegionModel;

public class RegionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView tvName;
    private ProgressBar pbLoading;

    private OnRegionClickListener onRegionClickListener;

    public RegionViewHolder(View itemView) {
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.item_region_tvName);
        pbLoading = (ProgressBar) itemView.findViewById(R.id.item_region_pbLoading);
        itemView.setOnClickListener(this);
    }

    public void initView(RegionModel region) {
        tvName.setText(region.getName());
        setLoading(false);
    }

    public void setLoading(boolean isLoading) {
        pbLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }

    public void setOnRegionClickListener(OnRegionClickListener listener) {
        onRegionClickListener = listener;
    }

    @Override
    public void onClick(View view) {
        if (onRegionClickListener != null)
            onRegionClickListener.onRegionClick(null, this, getAdapterPosition());
    }
}
