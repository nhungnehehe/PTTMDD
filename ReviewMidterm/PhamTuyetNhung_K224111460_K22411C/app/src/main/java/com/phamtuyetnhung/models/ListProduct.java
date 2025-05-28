package com.phamtuyetnhung.models;

import java.io.Serializable;
import java.util.ArrayList;

public class ListProduct implements Serializable {
    private ArrayList<Product> products;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public ListProduct()
    {
        products = new ArrayList<>();
    }
    public void addProduct(Product p)
    {
        products.add(p);
    }
    public void generate_sample_product_dataset()
    {
        Product p1 = new Product(1, "SH350i", "SH350i", 151190000, "https://cdn.honda.com.vn/motorbike-versions/Image360/November2024/1730800747/6.png");
        Product p2 = new Product(2, "SH160", "SH160i/125i", 73921091, "https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729586212/0.png");
        Product p3 = new Product(3, "SHMode", "SH Mode 125", 57132000, "https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729594648/0.png");
        Product p4 = new Product(4, "Vario160", "Vario 160", 51990000,"https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729588421/6.png");
        Product p5 = new Product(5, "AirBlade", "Air Blade 160/125", 42012000,"https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729588716/6.png");
        Product p6 = new Product(6, "Vario125", "Vario 125", 40735637, "https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729580777/6.png");
        Product p7 = new Product(7, "LeadABS", "LEAD ABS", 39557455, "https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729507554/6.png");
        Product p8 = new Product(8, "Vision", "Vision", 31310182, "https://cdn.honda.com.vn/motorbike-versions/Image360/November2024/1732161471/6.png");
        Product p9 = new Product(9, "CubC125", "Super Cub C125", 86292000, "https://cdn.honda.com.vn/motorbike-versions/July2024/4mvfY4O7TXBSDullbfAZ.png");
        Product p10 = new Product(10, "Future", "Future 125 FI", 30524727, "https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729596190/0.png");
        Product p11 = new Product(11, "WaveClassic", "Wave Alpha cổ điển", 18939273, "https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729593444/0.png");
        Product p12 = new Product(12, "WaveRSX", "Wave RSX", 22032000, "https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729605364/0.png");
        Product p13 = new Product(13, "Blade", "Blade", 18900000, "https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729582594/0.png");
        Product p14 = new Product(14, "Wave110", "Wave Alpha 110", 17859273, "https://cdn.honda.com.vn/motorbike-versions/Image360/August2024/1725011319/6.png");
        Product p15 = new Product(15, "CBR150R", "CBR150R", 72290000, "https://cdn.honda.com.vn/motorbike-versions/October2024/WvoUdFXIBpKfCwuMDjmX.png");
        Product p16 = new Product(16, "WinnerX", "Winner X", 46160000, "https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729586598/6.png");
        Product p17 = new Product(17, "GoldWing", "Gold Wing 2024", 1231500000, "https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729591065/0.png");
        Product p18 = new Product(18, "Fireblade", "CBR1000RR-R Fireblade SP 2024", 1051000000, "https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729823404/27.png");
        Product p19 = new Product(19, "AfricaADV", "Africa Twin 2025 Adventure", 620990000, "https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729590356/27.png");
        Product p20 = new Product(20, "CBHornet", "CB1000 Hornet", 339900000, "https://cdn.honda.com.vn/motorbike-versions/Image360/October2024/1729590271/1.png");
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);
        products.add(p7);
        products.add(p8);
        products.add(p9);
        products.add(p10);
        products.add(p11);
        products.add(p12);
        products.add(p13);
        products.add(p14);
        products.add(p15);
        products.add(p16);
        products.add(p17);
        products.add(p18);
        products.add(p19);
        products.add(p20);

    }

    public boolean isExist(Product p) {
        for (Product pro : products)
        {
            if (pro.getId()==p.getId())
                return true;
        }
        return false;
    }
}
