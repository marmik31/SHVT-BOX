package info.androidhive.firebase;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.vision.text.Line;

import java.util.ArrayList;

public class RentalSubListAdapter extends RecyclerView.Adapter<RentalSubListAdapter.MyViewHolder> {

    Context context;
    ArrayList<RentalItemsObject> rentalListArray = new ArrayList<RentalItemsObject>();

    public RentalSubListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_rantal_sub_list, parent, false);

        return new MyViewHolder(itemView);
    }

    private RentalItemsObject getItem(int position) {
        return rentalListArray.get(position);
    }

    public void addProducts(ArrayList<RentalItemsObject> productList) {
        if (rentalListArray != null) {
            rentalListArray.clear();
            rentalListArray.addAll(productList);
            notifyDataSetChanged();
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //holder.tvCategory.setText(CommonObject.categoryListArray.get(position).Category.category_text);

        if (rentalListArray.size() > 0) {
            RentalItemsObject product = getItem(position);
            holder.bindContent(product, position);
            holder.tvRentalItem.setText(holder.product.itemName);
            holder.imgRental.setImageDrawable(context.getResources().getDrawable(holder.product.imgResource, context.getTheme()));
        }


    }

    @Override
    public int getItemCount() {
        return rentalListArray.size();
    }

    public void clear() {
        rentalListArray.clear();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgRental;
        public TextView tvRentalItem;
        public RentalItemsObject product;
        LinearLayout llCallPhone, lvMoreInfo;
        int position;

        public MyViewHolder(View view) {
            super(view);
            tvRentalItem = (TextView) view.findViewById(R.id.tvRentalItem);
            imgRental = (ImageView) view.findViewById(R.id.imgRental);
            llCallPhone = (LinearLayout) view.findViewById(R.id.llCallPhone);
            lvMoreInfo = (LinearLayout) view.findViewById(R.id.lvMoreInfo);

            lvMoreInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, RentalDetailsActivity.class);
                    intent.putExtra("index", position);
                    context.startActivity(intent);
                }
            });

            llCallPhone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:123456789"));
                    if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    context.startActivity(callIntent);
                }
            });
        }

        public void bindContent(RentalItemsObject product, int position) {
            this.product = product;
            this.position = position;
        }
    }
}
