package info.androidhive.firebase;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RentalListActivity extends AppCompatActivity implements ClickListener {

    Toolbar toolbar;
    RecyclerView rvRentalItems;
    GridLayoutManager productsRecyclerLayoutManager;
    ArrayList<RentalItemsObject> rentalListArray = new ArrayList<RentalItemsObject>();
    RentalListAdapter rentalListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_list);

        init();
        prepareActionBar();
        prepareRentalItem();
        prepareAdapter();
    }

    void prepareAdapter() {
        rentalListAdapter = new RentalListAdapter(RentalListActivity.this);
        rvRentalItems.addItemDecoration(new RecyclerMarginDecorator(RentalListActivity.this, RecyclerMarginDecorator.ORIENTATION.BOTH));
        rvRentalItems.setItemAnimator(new DefaultItemAnimator());
        rvRentalItems.setHasFixedSize(true);
        productsRecyclerLayoutManager = new GridLayoutManager(RentalListActivity.this, 1);
        rvRentalItems.setLayoutManager(productsRecyclerLayoutManager);
        rvRentalItems.setAdapter(rentalListAdapter);

        rvRentalItems.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rvRentalItems, this));

        rentalListAdapter.addProducts(rentalListArray);
    }

    void prepareRentalItem() {
        rentalListArray.clear();
        rentalListArray.add(new RentalItemsObject(R.drawable.image1, "SHVT Box Flush Internal"));
        rentalListArray.add(new RentalItemsObject(R.drawable.image2, "SHVT Box Non-flush "));
        rentalListArray.add(new RentalItemsObject(R.drawable.image3, "SHVT DROP 1"));
        rentalListArray.add(new RentalItemsObject(R.drawable.image4, "SHVT FLUSH 1"));
        rentalListArray.add(new RentalItemsObject(R.drawable.image5, "SHVT Box Towable Open Door"));
        rentalListArray.add(new RentalItemsObject(R.drawable.image6, "SHVT Box Towable Open Door"));
        rentalListArray.add(new RentalItemsObject(R.drawable.image7, "SHVT Towable Rate Card"));
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
        rvRentalItems = (RecyclerView) findViewById(R.id.rvRentalItems);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View view, int position) {
        Intent intent = new Intent(RentalListActivity.this, RentalSubListActivity.class);
        intent.putExtra("title", rentalListArray.get(position).itemName);
        startActivity(intent);
    }

    @Override
    public void onLongClick(View view, int position) {

    }
}
