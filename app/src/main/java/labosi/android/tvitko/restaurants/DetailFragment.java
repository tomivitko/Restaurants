package labosi.android.tvitko.restaurants;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tvitko on 22.4.2017..
 */

public class DetailFragment extends Fragment{
    public DetailFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_detail, container, false);

        return rootView;
    }
}
