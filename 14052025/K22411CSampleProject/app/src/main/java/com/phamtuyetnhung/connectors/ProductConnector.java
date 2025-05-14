package com.phamtuyetnhung.connectors;

import com.phamtuyetnhung.models.Category;
import com.phamtuyetnhung.models.ListCategory;
import com.phamtuyetnhung.models.ListProduct;
import com.phamtuyetnhung.models.Product;

import java.util.ArrayList;

public class ProductConnector {
    ListProduct listProduct;
    public ProductConnector()
    {
        listProduct = new ListProduct();
        listProduct.generate_sample_dataset();
    }
    public ArrayList<Product> get_all_products()
    {
        if ( listProduct==null)
        {
            listProduct = new ListProduct();
            listProduct.generate_sample_dataset();
        }
        return  listProduct.getProducts();
    }
}
