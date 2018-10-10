package info.androidhive.firebase;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.views.BannerSlider;

public class ImageSliderActivity extends AppCompatActivity {

    Toolbar toolbar;
    BannerSlider bannerSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slider);

        init();
        prepareActionBar();


        List<Banner> banners=new ArrayList<>();
        banners.add(new DrawableBanner(R.drawable.img1));
        banners.add(new DrawableBanner(R.drawable.img2));
        banners.add(new DrawableBanner(R.drawable.img3));
        banners.add(new DrawableBanner(R.drawable.img4));
        banners.add(new DrawableBanner(R.drawable.img5));
        banners.add(new DrawableBanner(R.drawable.img6));
        banners.add(new DrawableBanner(R.drawable.img7));
        banners.add(new DrawableBanner(R.drawable.img8));
        banners.add(new DrawableBanner(R.drawable.img9));
        bannerSlider.setBanners(banners);
    }

    void prepareActionBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("Image Slider");

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    void init() {
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        bannerSlider = (BannerSlider) findViewById(R.id.banner_slider1);
    }
}
