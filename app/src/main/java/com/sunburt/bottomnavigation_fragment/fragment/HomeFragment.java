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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.sunburt.bottomnavigation_fragment.R;
import com.sunburt.bottomnavigation_fragment.adapter.CardItemAdapter;
import com.sunburt.bottomnavigation_fragment.model.Product;

public class HomeFragment extends Fragment {

    private Spinner sp;
    private EditText editName, editPrice, editDescr;
    private Button btnAdd;
    private RecyclerView rev;
    private CardItemAdapter adapter = null;

    /**
     * fail
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getControls(view);

        adapter = new CardItemAdapter(HomeFragment.this);
        rev.setAdapter(adapter);
        rev.setLayoutManager(new LinearLayoutManager(view.getContext()));
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product = new Product();
                String s = sp.getSelectedItem().toString();
                int img = 0;
                switch (s){
                    case "Tv":
                        img = R.drawable.tv;
                        break;
                    case "Laptop":
                        img = R.drawable.laptop;
                        break;
                    case "Speaker":
                        img = R.drawable.speaker;
                        break;
                    case "Refrigerator":
                        img = R.drawable.refrigerator;
                        break;
                    case "Air Conditioner":
                        img = R.drawable.airconditioner;
                        break;
                }

                product.setImg(img);
                product.setName(editName.getText().toString());
                product.setPrice(Float.parseFloat(editPrice.getText().toString()));
                product.setDescr(editDescr.getText().toString());
                adapter.addProduct(product);
                Bundle bundle =new Bundle();
                bundle.putSerializable("products", product);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void getControls(View v){
        sp = (Spinner) v.findViewById(R.id.spProduct);
        editName = (EditText) v.findViewById(R.id.editName);
        editPrice = (EditText) v.findViewById(R.id.editPrice);
        editDescr = (EditText) v.findViewById(R.id.editDescr);
        btnAdd = (Button) v.findViewById(R.id.btnAdd);
        rev = (RecyclerView) v.findViewById(R.id.revProduct);
    }
}