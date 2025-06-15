package com.phamtuyetnhung.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.phamtuyetnhung.adapters.OrdersViewerAdapter;
import com.phamtuyetnhung.connectors.OrdersViewerConnector;
import com.phamtuyetnhung.connectors.SQLiteConnector;
import com.phamtuyetnhung.models.Orders;
import com.phamtuyetnhung.models.OrdersViewer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OrdersViewerActivity extends AppCompatActivity {
    ListView lvOrdersView;
    OrdersViewerAdapter adapter;
    private ArrayList<OrdersViewer> dataset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_orders_viewer);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        // OrdersViewerActivity.java (thêm vào method addViews())
        lvOrdersView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OrdersViewer ov = adapter.getItem(position);
                Intent intent = new Intent(OrdersViewerActivity.this, OrderDetailActivity.class);
                intent.putExtra("orderId", ov.getId());
                startActivity(intent);
            }
        });


    }

    private void addViews() {
        lvOrdersView = findViewById(R.id.lvOrdersView);
        adapter = new OrdersViewerAdapter(this,R.layout.item_ordersviewer);
        lvOrdersView.setAdapter(adapter);

        SQLiteConnector connector = new SQLiteConnector(this);
        OrdersViewerConnector ovc = new OrdersViewerConnector();
        dataset = ovc.getAllOrdersViewer(connector.openDatabase());
        adapter.addAll(dataset);



    }
}