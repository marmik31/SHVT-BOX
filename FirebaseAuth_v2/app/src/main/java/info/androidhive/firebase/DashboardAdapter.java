package info.androidhive.firebase;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.MyViewHolder> {

    Context context;
    ArrayList<DashboardItemsObject> productListArray = new ArrayList<DashboardItemsObject>();

    public DashboardAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_dashboard, parent, false);

        return new MyViewHolder(itemView);
    }

    private DashboardItemsObject getItem(int position) {
        return productListArray.get(position);
    }

    public void addProducts(ArrayList<DashboardItemsObject> productList) {
        if (productListArray != null) {
            productListArray.clear();
            productListArray.addAll(productList);
            notifyDataSetChanged();
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //holder.tvCategory.setText(CommonObject.categoryListArray.get(position).Category.category_text);

        if(productListArray.size() > 0){
            DashboardItemsObject product = getItem(position);
            holder.bindContent(product);
            holder.tvDashboard.setText(holder.product.itemName);
            holder.imgDashboard.setImageDrawable(context.getResources().getDrawable(holder.product.imgResource, context.getTheme()));
        }

    }

    @Override
    public int getItemCount() {
        return productListArray.size();
    }

    public void clear() {
        productListArray.clear();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgDashboard;
        public TextView tvDashboard;
        public DashboardItemsObject product;

        public MyViewHolder(View view) {
            super(view);
            tvDashboard = (TextView) view.findViewById(R.id.tvDashboard);
            imgDashboard = (ImageView) view.findViewById(R.id.imgDashboard);
        }

        public void bindContent(DashboardItemsObject product) {
            this.product = product;
        }
    }
}
