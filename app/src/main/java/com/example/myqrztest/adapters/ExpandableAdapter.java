package com.example.myqrztest.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.myqrztest.R;

import java.util.ArrayList;

import com.example.myqrztest.fragments.Fragment2;
import com.example.myqrztest.model.RegionModel;


/**
 * Created by dmitriy on 15.06.15.
 */
public class ExpandableAdapter extends BaseExpandableListAdapter {
    private final String KEY = "countryId";

    private  String[] reg = {"Одесская","Киевская","Харьковска","Николаевская"};
    private  String[] odessa = {"Одесса","Балта","Котовск","Раздельная"};
    private  String[] kiev = {"киев","белЦерковь","Борисполь","чернобль"};
    private  String[] harkov = {"харьков","ивановка","петровка"};
    private  String[] nickolaev = {"николаев","херсон","оиаволт"};

    private ArrayList<String> realReg;


    private LayoutInflater mInflater;
    //private ArrayList<String> regions;
    private ArrayList<String> odessaRegion;
    private ArrayList<String> kievRegion;
    private ArrayList<String> harkovRegion;
    private ArrayList<String> nickolaevRegion;
    private Fragment2 mFrag2;
    private ArrayList<ArrayList<String>> country;




    public ExpandableAdapter(LayoutInflater inflater,Fragment2 frag2){
        mInflater=inflater;
        realReg = new ArrayList<>();
        /*mFrag2 = frag2;*/
        generateCountry();
       // if(mFrag2.getArguments().getLong(KEY)==_ID_RUSSIA){
            //getDemoRegions();

        //}
    }

    public void setRegions(RegionModel.List regions){
        for(RegionModel regionModel :regions){
            realReg.add(regionModel.getName());
            notifyDataSetChanged();
        }
    }

    private ArrayList<ArrayList<String>> generateCountry(){
        country = new ArrayList<>();
        odessaRegion = new ArrayList<>();
        kievRegion = new ArrayList<>();
        harkovRegion = new ArrayList<>();
        nickolaevRegion = new ArrayList<>();

        for (int i = 0; i < odessa.length;i++) {
            odessaRegion.add(odessa[i]);
        }
        country.add(odessaRegion);
        for (int i = 0; i < kiev.length; i++){
            kievRegion.add(kiev[i]);
        }
        country.add(kievRegion);
        for (int i = 0; i < harkov.length; i++){
            harkovRegion.add(harkov[i]);
        }
        country.add(harkovRegion);
        for (int i = 0; i < nickolaev.length; i++){
            nickolaevRegion.add(nickolaev[i]);
        }
        country.add(nickolaevRegion);

        return country;
    }

    /*private ArrayList<String> getDemoRegions(){
        regions = new ArrayList<>();
        for(int i = 0; i < reg.length;i++){
            regions.add(reg[i]);
        }
        return regions;
    }*/

    @Override
    public int getGroupCount() {
        return realReg.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return country.get(groupPosition).size();
    }

    @Override
    public ArrayList<String> getGroup(int groupPosition) {
        return country.get(groupPosition);
    }

    @Override
    public String getChild(int groupPosition, int childPosition) {
        return country.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
       if(convertView == null)
           convertView = mInflater.inflate(R.layout.item_regions,parent,false);
        TextView region = (TextView)convertView.findViewById(R.id.fragment_region_expList_item);
        region.setText(realReg.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
       if(convertView==null)
           convertView = mInflater.inflate(R.layout.item_city,parent,false);

        TextView city = (TextView)convertView.findViewById(R.id.fragment_city_expList_item);
        city.setText(country.get(groupPosition).get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
