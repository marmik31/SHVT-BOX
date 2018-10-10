package info.androidhive.firebase;

import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class RentalDetailsActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView imgDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_details);

        init();
        prepareActionBar();

        switch (getIntent().getExtras().getInt("index")){
            case 1:
                imgDetails.setImageResource(R.drawable.imgdetails2);
                break;
            case 2:
                imgDetails.setImageResource(R.drawable.imgdetails3);
                break;
            case 3:
                imgDetails.setImageResource(R.drawable.imgdetails4);
                break;
            case 4:
                imgDetails.setImageResource(R.drawable.imgdetails5);
                break;
            default:
                imgDetails.setImageResource(R.drawable.imgdetails2);
                break;
        }
    }

    void init() {
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        imgDetails = (ImageView) findViewById(R.id.imgDetails);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    void prepareActionBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("Details");
    }
}
