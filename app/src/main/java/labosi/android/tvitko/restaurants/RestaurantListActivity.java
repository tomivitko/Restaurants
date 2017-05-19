package labosi.android.tvitko.restaurants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import labosi.android.tvitko.restaurants.database.tables.Restaurants;

public class RestaurantListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Restaurants> restaurantList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        // Layout manager:
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        if(SQLite.select().from(Restaurants.class).count() == 0) {
            generateRestaurants();
        }
        getRestaurants();

        mAdapter = new AdapterRestaurantList(restaurantList);
        mRecyclerView.setAdapter(mAdapter);
    }


    public void generateRestaurants(){
        Restaurants r = new Restaurants("Brlog", "Ilica 15, Zagreb", "Restoran u centru Zagreba. Domaća kuhinja.", R.drawable.brlog0);
        r.save();
        r = new Restaurants("Stara hiža", "Frankopanska 15, Zagreb", "Restoran u Frankopanskoj. Leskovački roštilj.", R.drawable.stara_hiza0);
        r.save();
        r = new Restaurants("Kod Iveka", "Zagrebačka 15, Zagreb", "Nudimo sve i svašta.", R.drawable.kod_iveka1);
        r.save();
        /*
        restaurantList.add(new Restaurant("Brlog", "Ilica 15, Zagreb", "Restoran u centru Zagreba. Domaća kuhinja.", R.drawable.brlog0));
        restaurantList.add(new Restaurant("Stara hiža", "Frankopanska 15, Zagreb", "Restoran u Frankopanskoj. Leskovački roštilj.", R.drawable.stara_hiza0));
        restaurantList.add(new Restaurant("Kod Iveka", "Zagrebačka 15, Zagreb", "Nudimo sve i svašta.", R.drawable.kod_iveka1));
        */
    }

    public void getRestaurants(){
        restaurantList = SQLite.select().from(Restaurants.class).queryList();
    }
}
