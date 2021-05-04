package com.sunburt.bottomnavigation_fragment.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunburt.bottomnavigation_fragment.R;
import com.sunburt.bottomnavigation_fragment.adapter.CardItemAdapter;
import com.sunburt.bottomnavigation_fragment.model.Product;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private RecyclerView revListProduct;
    private CardItemAdapter adapter = null;
    private List<Product> products = new ArrayList<Product>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getControls(view);

        adapter = new CardItemAdapter(ListFragment.this);
        revListProduct.setAdapter(adapter);
        revListProduct.setLayoutManager(new LinearLayoutManager(view.getContext()));
        Bundle bundle = new Bundle();
        Product product = (Product) bundle.getSerializable("products");
        products.add(product);
        adapter.notifyDataSetChanged();
    }

    public void getControls(View view){
        revListProduct = (RecyclerView) view.findViewById(R.id.revListProduct);
    }
}