package labosi.android.tvitko.restaurants;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import labosi.android.tvitko.restaurants.database.tables.Restaurants;

public class AdapterRestaurantList extends RecyclerView.Adapter<AdapterRestaurantList.ViewHolder> {

    private List<Restaurants> restaurantList;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView nazivText, adresaText;
        public ImageView slikaImageView;
        public ViewHolder(View view){
            super(view);

            nazivText = (TextView) view.findViewById(R.id.restaurantName);
            adresaText = (TextView) view.findViewById(R.id.restaurantAddress);
            slikaImageView = (ImageView) view.findViewById(R.id.restaurant_adapter_picture);
            view.setClickable(true);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int poz = getAdapterPosition();
            Restaurants restaurant = restaurantList.get(poz);

            Restaurant r = new Restaurant(restaurant.getNaziv(), restaurant.getAdresa(), restaurant.getOpis(), restaurant.getSlika());

            Intent intent = new Intent(v.getContext(), REstaActivity.class);
            intent.putExtra("restaurant", r);
            v.getContext().startActivity(intent);

        }


    }

    public AdapterRestaurantList(List<Restaurants> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Restaurants r = restaurantList.get(position);
        holder.nazivText.setText(r.getNaziv());
        holder.adresaText.setText(String.valueOf(r.getAdresa()));
        holder.slikaImageView.setImageResource(r.getSlika());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent, false);
        return new ViewHolder(v);
    }


    @Override
    public int getItemCount() {
        return restaurantList.size();
    }
}
