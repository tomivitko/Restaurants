package labosi.android.tvitko.restaurants;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailActivity extends AppCompatActivity {

    private Button buttonWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        buttonWeb = (Button) findViewById(R.id.buttonWWW);

        buttonWeb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browserIntent);
            }
        });

    }
}
