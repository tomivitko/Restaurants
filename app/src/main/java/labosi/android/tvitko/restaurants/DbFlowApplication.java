package labosi.android.tvitko.restaurants;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by tvitko on 15.5.2017..
 */

public class DbFlowApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Ovo inicira DBFlow
        FlowManager.init(new FlowConfig.Builder(this).build());
    }
}
