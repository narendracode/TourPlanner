package com.tourplanner;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.Toast;
import com.tourplanner.adapter.AttractionsListAdapter;
import com.tourplanner.dto.Attraction;


public class AttractionsActivity  extends BaseActivity {
   // private TextView textView;
    Activity activity = null;
    private ListView listView;
    private ArrayAdapter adapter;
    private AttractionsListAdapter attractionsListAdapter;
    private HashMap<Integer,Boolean> selectedIndexes;
    ArrayList<Attraction> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);
        selectedIndexes = new HashMap<Integer,Boolean>();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Attractions Activity");
        setUpToolbar();

        activity = this;
        mDrawerLayout = (DrawerLayout) findViewById(R.id.nav_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mContentFrame = (FrameLayout) findViewById(R.id.nav_contentframe);
       // textView = (TextView)mContentFrame.findViewById(R.id.enterprise_name);
        listView = (ListView)mContentFrame.findViewById(R.id.listView);

       // String[] sports = getResources().getStringArray(R.array.sports_array);
       // adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, sports);
      //  listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        data = getData();
        attractionsListAdapter = new AttractionsListAdapter(this,getResources(),data);
        listView.setAdapter(attractionsListAdapter);

       // this.listView.setItemsCanFocus(true);
       // this.listView.clearChoices();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(activity, "hello "+position, Toast.LENGTH_LONG).show();
                toggleSelection(position);
                data.get(position).setSelected(selectedIndexes.get(position));
                attractionsListAdapter = new AttractionsListAdapter(activity,getResources(),data);
                listView.setAdapter(attractionsListAdapter);
                listView.deferNotifyDataSetChanged();
            }
        });

        setupNavMenu();

        setUpNavDrawer();
        setSelectedNavItmId(R.id.navigation_attractions);
    }//onCreate

    @Override
    protected void onResume() {
        super.onResume();
        setSelectedNavItmId(R.id.navigation_attractions);
    }

    private void toggleSelection(int index){
            if(!selectedIndexes.containsKey(index) || !selectedIndexes.get(index)){
                selectedIndexes.put(index,true);
            }else
                selectedIndexes.put(index,false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tour, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public ArrayList<Attraction> getData(){
        ArrayList<Attraction> data = new ArrayList<Attraction>();
        for(int i = 0;i<5;i++){
            Attraction attr = new Attraction(i,"attr : "+i,"type : "+i);
            data.add(attr);
        }
        return data;
    }

}
