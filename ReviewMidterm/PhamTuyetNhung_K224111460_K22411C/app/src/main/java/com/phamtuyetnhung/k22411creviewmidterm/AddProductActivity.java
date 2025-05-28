package com.phamtuyetnhung.k22411creviewmidterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.phamtuyetnhung.models.Product;

public class AddProductActivity extends AppCompatActivity {
    EditText edt_product_id;
    EditText edt_product_code;
    EditText edt_product_name;
    EditText edt_product_price;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addEvents() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process_save_product();
            }
        });
    }

    private void process_save_product() {
        //lấy dữ liệu treen giao diện và mô hình hóa lại hướng đối tượng Cus
        Product p = new Product();
        p.setId(Integer.parseInt(edt_product_id.getText().toString()));
        p.setProductCode(edt_product_code.getText().toString());
        p.setProductName(edt_product_name.getText().toString());
        p.setUnitPrice(Integer.parseInt(edt_product_price.getText().toString()));

        //lấy intent từ màn hình gọi nó
        Intent intent = getIntent();
        //đóng gói dữ lệu vao intent
        intent.putExtra("NEW_PRODUCT",p);
        //đóng dấu là sẽ gửi gói hàng này đi
        setResult(500,intent);
        //đóng màn hình này lại, để màn hình gọi nó nhận được kết quả
        finish();
    }

    private void addViews() {
        edt_product_id = findViewById(R.id.edt_product_id);
        edt_product_code = findViewById(R.id.edt_product_code);
        edt_product_name = findViewById(R.id.edt_product_name);
        edt_product_price = findViewById(R.id.edt_product_price);
        btnSave = findViewById(R.id.btnSave);
    }


}