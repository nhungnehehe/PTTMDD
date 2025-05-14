package com.phamtuyetnhung.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class ListCategory implements Serializable
{
    private ArrayList<Category> categories;

    public ListCategory() {
        categories = new ArrayList<>();
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
    public void addCategory(Category c)
    {
        categories.add(c);
    }
    public void generate_sample_dataset()
    {
        Random random = new Random();
        for (int i=1;i<=100;i++)
        {
            int id = i;
            String name="Category " +i;

            Category c = new Category(id,name);
            addCategory(c);
        }
    }
}
