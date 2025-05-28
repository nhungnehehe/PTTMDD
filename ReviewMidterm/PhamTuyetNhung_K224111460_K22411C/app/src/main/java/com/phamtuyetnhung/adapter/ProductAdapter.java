package com.phamtuyetnhung.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.phamtuyetnhung.k22411creviewmidterm.R;
import com.phamtuyetnhung.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.txtName.setText(product.getProductName());
        holder.txtPrice.setText(String.format("%.0f VND", product.getUnitPrice()));
        String imgLink = product.getImageLink();

        if (imgLink == null || imgLink.trim().isEmpty()) {
            // Nếu không có imageLink → dùng ảnh mặc định từ mipmap
            holder.imgProduct.setImageResource(R.mipmap.ic_default_photo);
        } else {
            // Có imageLink → dùng Glide để load ảnh từ internet
            Glide.with(context)
                    .load(imgLink)
                    .into(holder.imgProduct);
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView txtName, txtPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtName = itemView.findViewById(R.id.txtProductName);
            txtPrice = itemView.findViewById(R.id.txtProductPrice);
        }
    }
}

