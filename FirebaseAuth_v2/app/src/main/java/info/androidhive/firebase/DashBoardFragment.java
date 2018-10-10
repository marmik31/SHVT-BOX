package info.androidhive.firebase;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DashBoardFragment extends Fragment implements ClickListener {

    View rootView;
    RecyclerView rvHomeItems;
    ArrayList<DashboardItemsObject> dashboardListArray = new ArrayList<DashboardItemsObject>();
    DashboardAdapter dashboardAdapter;
    GridLayoutManager productsRecyclerLayoutManager;

    public static DashBoardFragment newInstance() {
        DashBoardFragment fragment = new DashBoardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_dash_board, container, false);

        init();
        prepareDashBoardItem();
        prepareAdapter();


        return rootView;
    }

    void init() {
        rvHomeItems = (RecyclerView) rootView.findViewById(R.id.rvHomeItems);
    }

    void prepareAdapter() {
        dashboardAdapter = new DashboardAdapter(getActivity());
        rvHomeItems.addItemDecoration(new RecyclerMarginDecorator(getActivity(), RecyclerMarginDecorator.ORIENTATION.BOTH));
        rvHomeItems.setItemAnimator(new DefaultItemAnimator());
        rvHomeItems.setHasFixedSize(true);
        productsRecyclerLayoutManager = new GridLayoutManager(getActivity(), 2);
        rvHomeItems.setLayoutManager(productsRecyclerLayoutManager);
        rvHomeItems.setAdapter(dashboardAdapter);

        rvHomeItems.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), rvHomeItems, this));

        dashboardAdapter.addProducts(dashboardListArray);
    }

    void prepareDashBoardItem() {
        dashboardListArray.clear();
        dashboardListArray.add(new DashboardItemsObject(R.drawable.image2, "Rental"));
        dashboardListArray.add(new DashboardItemsObject(R.drawable.toiletoption, "Toilet Option"));
        dashboardListArray.add(new DashboardItemsObject(R.drawable.contactus, "Contct Us"));
        dashboardListArray.add(new DashboardItemsObject(R.drawable.gallery, "Image Slider"));
        dashboardListArray.add(new DashboardItemsObject(R.drawable.prestige, "Prestige"));
        dashboardListArray.add(new DashboardItemsObject(R.drawable.locationhome, "Location"));
        //dashboardListArray.add(new DashboardItemsObject(R.drawable.rental, "Locations"));
        //dashboardListArray.add(new DashboardItemsObject(R.drawable.rental, "Contact"));
    }

    @Override
    public void onClick(View view, int position) {
        switch (position) {
            case 0:
                Intent intent = new Intent(getActivity(), RentalListActivity.class);
                intent.putExtra("title", dashboardListArray.get(position).itemName);
                startActivity(intent);
                break;
            case 5:
                Intent myToolsActivity = new Intent(getActivity(), MapsActivity.class);
                startActivity(myToolsActivity);
                break;
            case 1:
                Intent toiletOption = new Intent(getActivity(), ToiletOptionActivity.class);
                startActivity(toiletOption);
                break;
            case 3:
                Intent imageSlider = new Intent(getActivity(), ImageSliderActivity.class);
                startActivity(imageSlider);
                break;
            case 4:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.prestigeloos.co.nz"));
                startActivity(browserIntent);
                break;
            case 2:
                Intent contactUs = new Intent(getActivity(), ContactUsActivity.class);
                startActivity(contactUs);
                break;
        }
    }

    @Override
    public void onLongClick(View view, int position) {

    }
}
