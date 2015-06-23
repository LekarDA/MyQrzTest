package com.example.myqrztest;




import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import fragments.Fragment1;
import fragments.Fragment2;


public class MainActivity extends BaseActivity implements View.OnClickListener,AdapterView.OnItemClickListener {
    private Button diplom;
    private Fragment1 fragment1;
    private Fragment2 fragment2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null)
            getFragmentManager().beginTransaction().commit();
        fragment1 = new Fragment1();

        diplom = (Button)findViewById(R.id.button_diplom);
        diplom.setOnClickListener(this);


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        diplom.setVisibility(View.GONE);

        getFragmentManager().beginTransaction().add(R.id.frame_layout_context,fragment1)
                .addToBackStack(null)
                .commit();

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        fragment2 = Fragment2.newInstance(id);
        getFragmentManager().beginTransaction().replace(R.id.frame_layout_context, fragment2)
                .addToBackStack(null).commit();
       
    }


}
