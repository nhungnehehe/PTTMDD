package com.phamtuyetnhung.k22411csampleproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.phamtuyetnhung.adapters.PaymentMethodAdapter;
import com.phamtuyetnhung.connectors.CustomerConnector;
import com.phamtuyetnhung.connectors.PaymentMethodConnector;
import com.phamtuyetnhung.connectors.SQLiteConnector;
import com.phamtuyetnhung.models.Customer;
import com.phamtuyetnhung.models.ListCustomer;
import com.phamtuyetnhung.models.ListPaymentMethod;
import com.phamtuyetnhung.models.PaymentMethod;

public class PaymentMethodActivity extends AppCompatActivity {
    ListView lvPaymentMethod;
//    PaymentMethodAdapter adapter;
ArrayAdapter<PaymentMethod> adapter;
    ListPaymentMethod lpm;
    PaymentMethodConnector connector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment_method);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        lvPaymentMethod = findViewById(R.id.lvPaymentMethod);
        adapter = new PaymentMethodAdapter(PaymentMethodActivity.this,R.layout.item_payment_method);
//        lvPaymentMethod.setAdapter(adapter);
//        lpm = new ListPaymentMethod();
//        lpm.gen_payments_method();
//        adapter.addAll(lpm.getPaymentMethods());
        connector = new PaymentMethodConnector();
        ListPaymentMethod lpm = connector.getAllPaymentMethods(new SQLiteConnector(this).openDatabase());
//        adapter.addAll(connector.get_all_customers());
        adapter.addAll(lpm.getPaymentMethods());
        lvPaymentMethod.setAdapter(adapter);
    }
}