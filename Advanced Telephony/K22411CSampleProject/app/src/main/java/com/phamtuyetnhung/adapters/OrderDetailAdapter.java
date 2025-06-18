package com.phamtuyetnhung.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.phamtuyetnhung.k22411csampleproject.R;
import com.phamtuyetnhung.models.OrderDetails;

import java.util.List;

public class OrderDetailAdapter extends ArrayAdapter<OrderDetails> {
    private int resource;
    public OrderDetailAdapter(Context ctx, int res, List<OrderDetails> list) {
        super(ctx, res, list);
        resource = res;
    }
    @NonNull
    @Override
    public View getView(int pos, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(resource, parent, false);
        }
        OrderDetails od = getItem(pos);
        ((TextView)convertView.findViewById(R.id.edt_order_id))
                .setText(String.valueOf(od.getOrderId()));
        ((TextView)convertView.findViewById(R.id.edt_product_id))
                .setText(String.valueOf(od.getProductId()));
        ((TextView)convertView.findViewById(R.id.edt_product_quantity))
                .setText(String.valueOf(od.getQuantity()));
        ((TextView)convertView.findViewById(R.id.edt_product_price))
                .setText(String.valueOf(od.getPrice()));
        ((TextView)convertView.findViewById(R.id.edt_discount))
                .setText(String.valueOf(od.getDiscount()));
        ((TextView)convertView.findViewById(R.id.edt_VAT))
                .setText(String.valueOf(od.getVAT()));
        ((TextView)convertView.findViewById(R.id.edt_order_value))
                .setText(String.format("%.2f", od.getTotalValue()));
        return convertView;
    }
}

