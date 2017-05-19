package labosi.android.tvitko.restaurants;

import android.Manifest;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class REstaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private String[] mDrawerTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    //FragmentManager fragmentManager = getSupportFragmentManager();
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    private Restaurant restaurant;
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.restaurants_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_share:
                shareMenu();
                return true;
            case R.id.menu_settings:
                settingsMenu();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);



        mDrawerTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_view_item_row, mDrawerTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        Intent intent = getIntent();
        restaurant = (Restaurant) intent.getExtras().getParcelable("restaurant");

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new RestaurantFragment().newInstance(restaurant)).commit();

        //fragmentManager.beginTransaction().replace(R.id.details_content, new DetailFragment()).commit();

        /*
        textViewAbout.setText(restaurant.opis);
        imageViewMainImage.setImageResource(restaurant.slika);

        */

    }

    public void shareMenu() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        final CharSequence[] items = {getString(R.string.dialog_option1), getString(R.string.dialog_option2)};
        // set the message to display
        dialog.setTitle(R.string.dialog_title);
        dialog.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    Toast.makeText(getApplicationContext(), "facebook", Toast.LENGTH_SHORT).show();
                }
                if (which == 1) {
                    Toast.makeText(getApplicationContext(), "twitter", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // show it
        dialog.show();
    }

    public void settingsMenu() {
        showSettings();
    }

    public void showSettings() {


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new RestaurantFragment().newInstance(restaurant);
                break;
            case 1:
                fragment = new DetailFragment();
                break;
            case 2:
                fragment = new GalleryFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("fragment").commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            //setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void setTitle(CharSequence title) {
        //mTitle = title;
        getSupportActionBar().setTitle("Drawer");
    }
/*
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }


    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }
    */
}