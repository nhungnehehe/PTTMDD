package com.phamtuyetnhung.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.phamtuyetnhung.models.Customer;
import com.phamtuyetnhung.models.Product;

public class ProductDetailActivity extends AppCompatActivity {
    EditText edt_product_id;
    EditText edt_product_name;
    EditText edt_product_price;
    EditText edt_product_quantity;
    EditText edt_category_id;
    EditText edt_product_description;
    Button btnNew;
    Button btnSave;
    Button btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        edt_product_id = findViewById(R.id.edt_product_id);
        edt_product_name = findViewById(R.id.edt_product_name);
        edt_product_price = findViewById(R.id.edt_product_price);
        edt_product_quantity = findViewById(R.id.edt_product_quantity);
        edt_category_id = findViewById(R.id.edt_category_id);
        edt_product_description = findViewById(R.id.edt_product_description);
        display_infor();
    }

    private void display_infor() {
        Intent intent=getIntent();
        Product p = (Product) intent.getSerializableExtra("SELECTED_PRODUCT");
        if (p==null)
            return;
        edt_product_id.setText(p.getId()+"");
        edt_product_name.setText(p.getName());
        edt_product_price.setText(p.getQuantity()+"");
        edt_product_quantity.setText(p.getPrice()+"");
        edt_category_id.setText(p.getCate_id()+"");
        edt_product_description.setText(p.getDescription());
    }
}