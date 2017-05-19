package labosi.android.tvitko.restaurants.database.tables;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import labosi.android.tvitko.restaurants.database.RestaurantsDataBase;

/**
 * Created by tvitko on 15.5.2017..
 */
@Table(database = RestaurantsDataBase.class)
public class Restaurants extends BaseModel{
    @Column
    @PrimaryKey(autoincrement = true)
    int id;
    @Column
    String naziv;
    @Column
    String adresa;
    @Column
    String opis;
    @Column
    int slika;

    public Restaurants(){}

    public Restaurants(String naziv, String adresa, String opis, int slika) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.opis = opis;
        this.slika = slika;
    }

    public int getSlika() {
        return slika;
    }

    public void setSlika(int slika) {
        this.slika = slika;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
