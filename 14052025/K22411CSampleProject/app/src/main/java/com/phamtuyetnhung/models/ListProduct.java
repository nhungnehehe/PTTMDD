package com.phamtuyetnhung.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class ListProduct implements Serializable
{
    private ArrayList<Product> products;

    public ListProduct() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public void addProduct(Product p)
    {
        products.add(p);
    }
    public void generate_sample_dataset()
    {
        Random random = new Random();
        for (int i=1;i<=100;i++)
        {
            int id = i;
            String name="Product " +i;
            int quantity = i*10;
            double price = i*100;
            int cate_id = i;
            String description = "This is product " + i;
            Product p = new Product(id,name,quantity,price,cate_id,description);
            addProduct(p);
        }
    }
}
