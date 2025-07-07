package com.example.prm392.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.prm392.R;
import com.example.prm392.adapter.CategoryAdapter;
import com.example.prm392.adapter.SuggestProductAdapter;
import com.example.prm392.dao.CategoryDAO;
import com.example.prm392.dao.ProductDAO;
import com.example.prm392.dao.room.AppDatabase;
import com.example.prm392.entity.Category;
import com.example.prm392.entity.Product;
import com.example.prm392.entity.relation.ProductWithProductImages;

import java.util.List;


public class HomeFragment extends Fragment {

    private GridView gridCategory;
    private RecyclerView recyclerSuggest;
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        gridCategory = view.findViewById(R.id.gridCategory);
        recyclerSuggest = view.findViewById(R.id.recyclerSuggest);

        AppDatabase db = AppDatabase.getInstance(getContext());
        productDAO = db.productDao();
        categoryDAO = db.categoryDAO();

        loadCategory();
        loadSuggestedProducts();


        return view;
    }

    private void loadCategory() {
        List<Category> categories = categoryDAO.getAll();
        CategoryAdapter adapter = new CategoryAdapter(getContext(), categories);
        gridCategory.setAdapter(adapter);
    }

    private void loadSuggestedProducts() {
        List<ProductWithProductImages> suggested = productDAO.getRandomWithImages(4);
        SuggestProductAdapter adapter = new SuggestProductAdapter(requireContext(), suggested);
        recyclerSuggest.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerSuggest.setAdapter(adapter);
    }
}
