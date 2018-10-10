package info.androidhive.firebase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class RentalListAdapter extends RecyclerView.Adapter<RentalListAdapter.MyViewHolder> {

    Context context;
    ArrayList<RentalItemsObject> rentalListArray = new ArrayList<RentalItemsObject>();

    public RentalListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_rantallist, parent, false);

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

        if(rentalListArray.size() > 0){
            RentalItemsObject product = getItem(position);
            holder.bindContent(product);
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

        public MyViewHolder(View view) {
            super(view);
            tvRentalItem = (TextView) view.findViewById(R.id.tvRentalItem);
            imgRental = (ImageView) view.findViewById(R.id.imgRental);
        }

        public void bindContent(RentalItemsObject product) {
            this.product = product;
        }
    }
}
