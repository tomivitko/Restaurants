package labosi.android.tvitko.restaurants;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by tvitko on 11.4.2017..
 */

public class Restaurant implements Parcelable{

    String naziv;
    String adresa;
    String opis;


    Integer slika;

    public int describeContents() {
        return 0;
    }

    public Restaurant(String naziv, String adresa, String opis, Integer slika) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.opis = opis;
        this.slika = slika;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(naziv);
        dest.writeString(adresa);
        dest.writeString(opis);
        dest.writeInt(slika);
    }

    private Restaurant(Parcel in){
        this.naziv = in.readString();
        this.adresa = in.readString();
        this.opis = in.readString();
        this.slika = in.readInt();
    }

    public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>() {

        @Override
        public Restaurant createFromParcel(Parcel source) {
            return new Restaurant(source);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }


    public Integer getSlika() {
        return slika;
    }

    public void setSlika(Integer slika) {
        this.slika = slika;
    }
}
