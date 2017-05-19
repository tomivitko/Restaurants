package labosi.android.tvitko.restaurants;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tvitko on 22.4.2017..
 */

public class RestaurantFragment extends Fragment{

    private Button buttonCall;
    private Button buttonDetails;
    private Button buttonGalery;
    private Button buttonComment;
    private EditText editTextComment;
    private EditText editTextNickname;
    private TextView textViewAbout;
    private ImageView imageViewMainImage;


    public RestaurantFragment(){
    }

    public static RestaurantFragment newInstance(@NonNull final Restaurant restaurant) {
        final RestaurantFragment fragment = new RestaurantFragment();
        final Bundle args = new Bundle();
        args.putParcelable("restaurant", restaurant);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_resta, container, false);

        Restaurant restaurant = null;
        //Bundle args = getArguments();

        restaurant = (Restaurant) getArguments().getParcelable("restaurant");

        //Intent intent = getIntent();
        //final Restaurant restaurant = (Restaurant) intent.getExtras().getParcelable("restaurant");
        //final Restaurant restaurant = getArguments().getParcelable("restaurant");



        buttonCall = (Button) rootView.findViewById(R.id.buttonCall);
        buttonDetails = (Button) rootView.findViewById(R.id.buttonDetails);
        buttonGalery = (Button) rootView.findViewById(R.id.buttonGalery);
        buttonComment = (Button) rootView.findViewById(R.id.buttonSendComment);
        editTextComment = (EditText) rootView.findViewById(R.id.comment);
        editTextNickname = (EditText) rootView.findViewById(R.id.nickname);
        textViewAbout = (TextView) rootView.findViewById(R.id.textViewAbout);
        imageViewMainImage = (ImageView) rootView.findViewById(R.id.imageViewMainImage);

        textViewAbout.setText(restaurant.opis);
        imageViewMainImage.setImageResource(restaurant.slika);

        buttonComment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Comment comment = new Comment(editTextNickname.getText().toString(), editTextComment.getText().toString());
                Intent intent = new Intent(new Intent(getActivity(), CommentActivity.class));
                intent.putExtra("komentar", comment);
                startActivity(intent);
            }
        });


        buttonCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0377778888"));

                if (ActivityCompat.checkSelfPermission(getContext(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });


        buttonDetails.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                startActivity(new Intent(getActivity(), DetailActivity.class));
            }
        });

        buttonGalery.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent intent = new Intent(new Intent(getActivity(), PicturesActivity.class));

                startActivity(intent);
            }
        });

        return rootView;
    }

}
