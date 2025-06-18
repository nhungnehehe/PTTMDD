package com.phamtuyetnhung.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.phamtuyetnhung.k22411csampleproject.R;
import com.phamtuyetnhung.k22411csampleproject.SendSMSActivity;
import com.phamtuyetnhung.k22411csampleproject.TelephonyActivity;
import com.phamtuyetnhung.models.TelephonyInfor;

import java.util.List;

public class TelephonyInforAdapter extends ArrayAdapter<TelephonyInfor> {
    Activity context;
    int resource;
    private List<TelephonyInfor> objects;


    public TelephonyInforAdapter(@NonNull Activity context, int resource, List<TelephonyInfor> objects) {
        super(context, resource,objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item = inflater.inflate(this.resource,parent,false);

        TextView txtTelephonyName = item.findViewById(R.id.txtTelephonyName);
        TextView txtTelephonyNumber = item.findViewById(R.id.txtTelephonyNumber);
        ImageView imgDirectCall = item.findViewById(R.id.imgDirectCall);
        ImageView imgDialUp = item.findViewById(R.id.imgDialup);
        ImageView imgSendSms =  item.findViewById(R.id.imgSendSms);

        TelephonyInfor ti = getItem(position);
        txtTelephonyName.setText(ti.getName());
        txtTelephonyNumber.setText(ti.getPhone());
        //cac su kien making telephony lam sau
        imgDirectCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TelephonyActivity)context).directCall(ti);
            }
        });
        imgDialUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TelephonyActivity)context).dialupCall(ti);
            }
        });
        imgSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SendSMSActivity.class);
                intent.putExtra("TI",ti);
                context.startActivity(intent);
            }
        });
        return item;
    }
}
