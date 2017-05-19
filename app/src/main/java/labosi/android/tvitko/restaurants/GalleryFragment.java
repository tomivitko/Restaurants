package labosi.android.tvitko.restaurants;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tvitko on 22.4.2017..
 */

public class GalleryFragment extends Fragment {
    public GalleryFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_pictures, container, false);

        return rootView;
    }
}
