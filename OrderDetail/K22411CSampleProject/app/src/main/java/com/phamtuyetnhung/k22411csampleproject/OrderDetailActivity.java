package com.phamtuyetnhung.k22411csampleproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.phamtuyetnhung.adapters.OrderDetailAdapter;
import com.phamtuyetnhung.connectors.OrderDetailsConnector;
import com.phamtuyetnhung.connectors.SQLiteConnector;
import com.phamtuyetnhung.models.OrderDetails;

import java.util.List;

public class OrderDetailActivity extends AppCompatActivity {
    private ListView lvOrderDetails;
    private SQLiteConnector sqlConnector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvOrderDetails = findViewById(R.id.lvOrderDetails);

        // Lấy orderId
        int orderId = getIntent().getIntExtra("orderId", -1);
        if (orderId < 0) {
            finish();
            return;
        }

        // Mở DB và fetch list chi tiết
        sqlConnector = new SQLiteConnector(this);
        SQLiteDatabase db = sqlConnector.openDatabase();
        List<OrderDetails> detailsList =
                new OrderDetailsConnector().getOrderDetailsByOrderId(db, orderId);

        // Gán adapter lên ListView
        OrderDetailAdapter adapter = new OrderDetailAdapter(
                this,
                R.layout.item_order_detail,
                detailsList
        );
        lvOrderDetails.setAdapter(adapter);
    }
}