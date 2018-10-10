package info.androidhive.firebase;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class SearchFragment extends Fragment implements ClickListener {

    View rootView;
    String searchQuery;

    ArrayList<RentalItemsObject> rentalListArray = new ArrayList<RentalItemsObject>();
    ArrayList<RentalItemsObject> rentalSearchArray = new ArrayList<RentalItemsObject>();

    RecyclerView rvRentalItems;
    GridLayoutManager productsRecyclerLayoutManager;
    RentalListAdapter rentalListAdapter;

    public static SearchFragment newInstance(String searchQuery) {
        SearchFragment fragment = new SearchFragment();
        fragment.searchQuery = searchQuery;
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    void prepareArray() {
        rentalListArray.clear();
        rentalListArray.add(new RentalItemsObject(R.drawable.image1, "SHVT Box Flush Internal"));
        rentalListArray.add(new RentalItemsObject(R.drawable.image2, "SHVT Box Non-flush "));
        rentalListArray.add(new RentalItemsObject(R.drawable.image3, "SHVT DROP 1"));
        rentalListArray.add(new RentalItemsObject(R.drawable.image4, "SHVT FLUSH 1"));
        rentalListArray.add(new RentalItemsObject(R.drawable.image5, "SHVT Box Towable Open Door"));
        rentalListArray.add(new RentalItemsObject(R.drawable.image6, "SHVT Box Towable Open Door"));
        rentalListArray.add(new RentalItemsObject(R.drawable.image7, "SHVT Towable Rate Card"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_search, container, false);

        init();
        prepareAdapter();
        prepareArray();
        prepareSearchArray();

        return rootView;
    }

    void prepareSearchArray() {
        rentalSearchArray.clear();

        for (RentalItemsObject rentalItemsObject : rentalListArray) {
            if (rentalItemsObject.itemName.toLowerCase().contains(searchQuery)) {
                rentalSearchArray.add(rentalItemsObject);
            }
        }

        if (rentalSearchArray.size() > 0) {
            rentalListAdapter.addProducts(rentalSearchArray);
        } else {
            rentalListAdapter.clear();
            Toast.makeText(getActivity(), "No data found", Toast.LENGTH_LONG).show();
        }
    }

    void init() {
        rvRentalItems = (RecyclerView) rootView.findViewById(R.id.searchRecycler);
    }

    void prepareAdapter() {
        rentalListAdapter = new RentalListAdapter(getActivity());
        rvRentalItems.addItemDecoration(new RecyclerMarginDecorator(getActivity(), RecyclerMarginDecorator.ORIENTATION.BOTH));
        rvRentalItems.setItemAnimator(new DefaultItemAnimator());
        rvRentalItems.setHasFixedSize(true);
        productsRecyclerLayoutManager = new GridLayoutManager(getActivity(), 1);
        rvRentalItems.setLayoutManager(productsRecyclerLayoutManager);
        rvRentalItems.setAdapter(rentalListAdapter);

        rvRentalItems.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), rvRentalItems, this));
    }

    @Override
    public void onClick(View view, int position) {
        Intent intent = new Intent(getActivity(), RentalSubListActivity.class);
        intent.putExtra("title", rentalSearchArray.get(position).itemName);
        startActivity(intent);
    }

    @Override
    public void onLongClick(View view, int position) {

    }
}
