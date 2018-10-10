package info.androidhive.firebase;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class RentalSubListActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView rvRentalSubItems;
    GridLayoutManager productsRecyclerLayoutManager;
    ArrayList<RentalItemsObject> rentalSubListArray = new ArrayList<RentalItemsObject>();
    RentalSubListAdapter rentalSubListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_sub_list);

        init();
        prepareActionBar();
        prepareRentalSubItem();
        prepareAdapter();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    void prepareAdapter() {
        rentalSubListAdapter = new RentalSubListAdapter(RentalSubListActivity.this);
        rvRentalSubItems.addItemDecoration(new RecyclerMarginDecorator(RentalSubListActivity.this, RecyclerMarginDecorator.ORIENTATION.BOTH));
        rvRentalSubItems.setItemAnimator(new DefaultItemAnimator());
        rvRentalSubItems.setHasFixedSize(true);
        productsRecyclerLayoutManager = new GridLayoutManager(RentalSubListActivity.this, 1);
        rvRentalSubItems.setLayoutManager(productsRecyclerLayoutManager);
        rvRentalSubItems.setAdapter(rentalSubListAdapter);

        rentalSubListAdapter.addProducts(rentalSubListArray);
    }

    void prepareRentalSubItem() {
        rentalSubListArray.clear();
        rentalSubListArray.add(new RentalItemsObject(R.drawable.image1, "Duplex Toilet"));
        rentalSubListArray.add(new RentalItemsObject(R.drawable.image2, "Duplex Toilet"));
        rentalSubListArray.add(new RentalItemsObject(R.drawable.image3, "Duplex Toilet"));
        rentalSubListArray.add(new RentalItemsObject(R.drawable.image4, "Duplex Toilet"));
        rentalSubListArray.add(new RentalItemsObject(R.drawable.image5, "Duplex Toilet"));
        rentalSubListArray.add(new RentalItemsObject(R.drawable.image6, "Duplex Toilet"));
    }

    void prepareActionBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (getIntent().hasExtra("title")) {
            actionBar.setTitle(getIntent().getStringExtra("title"));
        } else {
            actionBar.setTitle("");
        }
    }

    void init() {
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        rvRentalSubItems = (RecyclerView) findViewById(R.id.rvRentalSubItems);
    }
}
