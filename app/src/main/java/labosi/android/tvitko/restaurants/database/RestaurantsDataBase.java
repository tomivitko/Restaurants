package labosi.android.tvitko.restaurants.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by tvitko on 15.5.2017..
 */

@Database(name = RestaurantsDataBase.NAME, version = RestaurantsDataBase.VERSION)
public class RestaurantsDataBase {
    public static final String NAME = "RestaurantsDb";

    public static final int VERSION = 1;
}
