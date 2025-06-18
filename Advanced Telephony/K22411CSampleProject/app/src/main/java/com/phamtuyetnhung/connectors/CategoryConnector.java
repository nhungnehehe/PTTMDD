package com.phamtuyetnhung.connectors;

import com.phamtuyetnhung.models.Category;
import com.phamtuyetnhung.models.ListCategory;


import java.util.ArrayList;


public class CategoryConnector {
    ListCategory listCategory;
    public CategoryConnector()
    {
        listCategory = new ListCategory();
        listCategory.generate_sample_dataset();
    }
    public ArrayList<Category> get_all_categories()
    {
        if (listCategory==null)
        {
            listCategory = new ListCategory();
            listCategory.generate_sample_dataset();
        }
        return listCategory.getCategories();
    }

}
