package com.phamtuyetnhung.k22411creviewmidterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.phamtuyetnhung.adapter.ProductAdapter;
import com.phamtuyetnhung.connectors.ProductConnector;
import com.phamtuyetnhung.models.ListProduct;
import com.phamtuyetnhung.models.Product;

public class ProductActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter adapter;
    ListProduct listProduct;

    ProductConnector connector;
    ArrayAdapter<Product> productadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        connector = new ProductConnector();
        recyclerView = findViewById(R.id.recyclerView);

        listProduct = new ListProduct();                     // khởi tạo ListProduct
        listProduct.generate_sample_product_dataset();       // tạo dữ liệu mẫu

        adapter = new ProductAdapter(this, listProduct.getProducts()); // truyền danh sách
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.optione_menu_product, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.menu_new_product)
        {
            Toast.makeText(ProductActivity.this,"Mở màn hình thêm mới sản phẩm",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ProductActivity.this,AddProductActivity.class);
            startActivityForResult(intent,300);
        }
        else if (item.getItemId()==R.id.menu_broadcast_advertising)
        {
            Toast.makeText(ProductActivity.this,"About Me",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(ProductActivity.this,AboutActivity.class);
            startActivity(intent);
            //Tim hieu Firebase Cloud Message + push message
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //trường hợp xử lý cho New Customer ta chỉ quan tâm 300 và 500 do ta định nghĩa
        if (requestCode==300 && resultCode==500)
        {
            //lấy gói tin ra
            Product p = (Product) data.getSerializableExtra("NEW_PRODUCT");
            process_save_product(p);
        }
    }

    private void process_save_product(Product p) {
        boolean result = connector.isExist(p);
        if (result==true)
        {
            //tuc la cus nay da ton tai trong he thong va co nhu cau sua cac thong tin khac
            //SINH VIEN TU XU LY TRUONG HOP SUA THONG TIN
        }
        else
        {
            //la them moi cus vi chua ton tai
            connector.addProduct(p);
            listProduct.getProducts().add(p);
            adapter.notifyDataSetChanged();

        }
    }
}