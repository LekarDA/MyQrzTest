package adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myqrztest.R;

import java.util.ArrayList;

import model.CountryModel;


/**
 * Created by Дмитрий on 12.06.2015.
 */
public class AdapterForCountries extends BaseAdapter {
    private Context mContext;
    //private ArrayList<String> countries;
    private ArrayList<CountryModel> mCountries;
    private LayoutInflater mLayoutInflator;
    //private String data[] = new String[] { "Russia", "Ukraine", "Moldova", "Germany" };

    public AdapterForCountries(Context context, LayoutInflater inflater) {
        mContext = context;
        mLayoutInflator = inflater;
        mCountries = new ArrayList<>();
       // generateCountries();
    }

    public void setAdapterData(CountryModel.List countries){
        for (int i = 0;i<countries.size();i++)
        mCountries.add(countries.get(i));
        notifyDataSetChanged();
    }
    /*private ArrayList<String> generateCountries() {
        countries = new ArrayList<>();

        for (int i= 0; i<data.length;i++){
            countries.add(data[i]);
        }
        return countries;
    }*/

    @Override
    public int getCount() {
        return mCountries.size();
    }

    @Override
    public CountryModel getItem(int position) {
        return mCountries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView = mLayoutInflator.inflate(R.layout.item_country,parent,false);
        TextView countryName = (TextView)convertView.findViewById(R.id.fragment_country_list_view_item);
        countryName.setText(mCountries.get(position).getCountry());
        return convertView;
    }


}
