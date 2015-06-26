package com.example.myqrztest.regions_and_diploms;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.TreeMap;

import com.example.myqrztest.R;
import com.example.myqrztest.model.DiplomModel;
import com.example.myqrztest.model.RegionModel;

public class RegionsAndDiplomsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnRegionClickListener,OnDiplomClickListener {

    private static final int REGION_VIEW_TYPE = 1;
    private static final int DIPLOM_VIEW_TYPE = 2;

    private ArrayList<RegionModel> mRegions;
    private TreeMap<Long, ArrayList<DiplomModel>> mDiploms;

    private RegionModel mExpandedRegion;

    private LayoutInflater mInflater;
    private OnRegionClickListener onRegionClickListener;
    private OnDiplomClickListener onDiplomClickListener;

    public RegionsAndDiplomsAdapter(LayoutInflater inflater) {
        mInflater = inflater;
    }

    private int getRegionsCount() {
        return mRegions == null ? 0 : mRegions.size();
    }

    private int getExpandedDiplomsCount() {
        if (mDiploms == null) return 0;
        if (mExpandedRegion == null) return 0;
        ArrayList<DiplomModel> diploms = mDiploms.get(mExpandedRegion.getId());
        return diploms == null ? 0 : diploms.size();
    }

    @Override
    public int getItemCount() {
        return getRegionsCount() + getExpandedDiplomsCount();
    }

    @Override
    public int getItemViewType(int position) {
        if (mExpandedRegion == null) return REGION_VIEW_TYPE;
        else if (position <= mRegions.indexOf(mExpandedRegion) ||
                position > mRegions.indexOf(mExpandedRegion) + getExpandedDiplomsCount())
            return REGION_VIEW_TYPE;
        else return DIPLOM_VIEW_TYPE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case REGION_VIEW_TYPE:
                view = mInflater.inflate(R.layout.item_region, parent, false);
                RegionViewHolder regionViewHolder = new RegionViewHolder(view);
                regionViewHolder.setOnRegionClickListener(this);
                return regionViewHolder;
            case DIPLOM_VIEW_TYPE:
                view = mInflater.inflate(R.layout.item_diplom, parent, false);
                DiplomViewHolder diplomViewHolder = new DiplomViewHolder(view);
                diplomViewHolder.setOnDiplomClickListener(this);
                return diplomViewHolder;//new DiplomViewHolder(mInflater.inflate(R.layout.item_diplom, parent, false));
            default:
                return null;
        }
    }

    public RegionModel getRegion(int position) {
        if (mExpandedRegion == null) return mRegions.get(position);
        else if (position <= mRegions.indexOf(mExpandedRegion)) return mRegions.get(position);
        else if (position > mRegions.indexOf(mExpandedRegion) + getExpandedDiplomsCount())
            return mRegions.get(position - getExpandedDiplomsCount());
        else return null;
    }


    public DiplomModel getDiplom(int position) {
        if (mExpandedRegion == null) return null;
        else if (position > mRegions.indexOf(mExpandedRegion) + getExpandedDiplomsCount() ||
                position <= mRegions.indexOf(mExpandedRegion)) return null;
        else
            return mDiploms.get(mExpandedRegion.getId()).get(position - mRegions.indexOf(mExpandedRegion) - 1);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case REGION_VIEW_TYPE:
                ((RegionViewHolder) holder).initView(getRegion(position));
                break;
            case DIPLOM_VIEW_TYPE:
                ((DiplomViewHolder) holder).initView(getDiplom(position));
                break;
        }
    }

    public void setRegions(ArrayList<RegionModel> regions) {
        mRegions = regions;
        notifyDataSetChanged();
    }

    public void expandRegion(RegionModel region, ArrayList<DiplomModel> diploms) {
        if (mDiploms == null) mDiploms = new TreeMap<>();
        mDiploms.put(region.getId(), diploms);
        int position = mRegions.indexOf(region);
        notifyItemChanged(position);
        mExpandedRegion = region;
        notifyItemRangeInserted(position + 1, getExpandedDiplomsCount());
    }

    public void collapseRegion() {
        if (mExpandedRegion == null) return;
        int position = mRegions.indexOf(mExpandedRegion);
        notifyItemRangeRemoved(position + 1, getExpandedDiplomsCount());
        mExpandedRegion = null;
    }

    public boolean isRegionExpanded(RegionModel region) {
        return mExpandedRegion != null && mExpandedRegion.getId() == region.getId();
    }

    public void setOnRegionClickListener(OnRegionClickListener listener) {
        onRegionClickListener = listener;
    }

    public void setOnDiplomClickListener(OnDiplomClickListener listener){
        onDiplomClickListener = listener;
    }

    @Override
    public void onRegionClick(RegionModel regionModel, RegionViewHolder holder, int position) {
        RegionModel region = getRegion(position);
        if (onRegionClickListener != null)
            onRegionClickListener.onRegionClick(region, holder, position);
        collapseRegion();
    }

    @Override
    public void onDiplomClick(DiplomModel model, DiplomViewHolder holder, int position) {

    }
}
