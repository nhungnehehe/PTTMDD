package com.phamtuyetnhung.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.phamtuyetnhung.k22411csampleproject.R;
import com.phamtuyetnhung.models.Product;

public class ProductAdapter extends ArrayAdapter<Product> {
    Activity context;
    int resource;
    public ProductAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        //nhan ban giao dien theo tu vi tri position ma du lieu duoc duyet qua
        View item = inflater.inflate(this.resource,null);
        //luc nay: Toan bo view nam trong layout resource(item_advanced_product) se duoc mo hinh hoa huong doi tuong va duoc quan ly boi bien item
        //tuc la item la Tong tai view
        //nhu vay muon truy xuat toi cac view con trong no thi phai thong qua bien item
        ImageView imgProduct = item.findViewById(R.id.imgProduct);
        TextView txtProductId = item.findViewById(R.id.txtProductId);
        TextView txtProductName = item.findViewById(R.id.txtProductName);
        TextView txtProductQuantity = item.findViewById(R.id.txtProductQuantity);
        TextView txtProductPrice = item.findViewById(R.id.txtProductPrice);
        ImageView imgCart = item.findViewById(R.id.imgCart);
        //lay mo hinh doi tuong dang duoc nhan ban o vi tri position (doi so 1)
        Product p = getItem(position);
        //Rai du lieu cua Product len giao dien trong item
        imgProduct.setImageResource(p.getImage_id());
        txtProductId.setText(p.getId()+"");
        txtProductName.setText(p.getName());
        txtProductQuantity.setText(p.getQuantity()+"");
        txtProductPrice.setText(p.getPrice()+"VND");
        //xu ly bam vao nut mua ...  tinh sau ....

        return item;
    }
}
