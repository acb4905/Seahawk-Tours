package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.FragmentTransaction;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements MainBuildingListFragment.Listener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public void itemClicked(long id){
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer !=null){
            DetailFragment details = new DetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setBuilding((int)id);;
            ft.replace(R.id.fragment_container,details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }
        else{
            Intent intent = new Intent (this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_BUILDINGID,(int)id);
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            //action to take when the action create order button is tapped
            case R.id.menu:
                Intent intent = new Intent (this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
