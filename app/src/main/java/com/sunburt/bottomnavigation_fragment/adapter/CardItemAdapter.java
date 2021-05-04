package com.sunburt.bottomnavigation_fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.sunburt.bottomnavigation_fragment.MainActivity;
import com.sunburt.bottomnavigation_fragment.R;
import com.sunburt.bottomnavigation_fragment.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CardItemAdapter extends RecyclerView.Adapter<CardItemAdapter.CardViewHolder> {

    private List<Product> products;
    private Fragment fragment;
    private MainActivity mainActivity;

    public CardItemAdapter(Fragment fragment){
        fragment = fragment;
        products = new ArrayList<Product>();
    }

    public List<Product> getListProduct(){
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardItemAdapter.CardViewHolder holder, final int position) {
        final Product product = products.get(position);
        if (product!=null){
            holder.img.setImageResource(product.getImg());
            holder.txt1.setText(product.getName());
            holder.txt2.setText(product.getPrice() + "");
            holder.txt3.setText(product.getDescr());

            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    products.remove(product);
                    notifyDataSetChanged();
                   // mainActivity.list = products;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txt1, txt2, txt3;
        private ImageButton btnDelete;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imgProduct);
            txt1 = (TextView) itemView.findViewById(R.id.txtName);
            txt2 = (TextView) itemView.findViewById(R.id.txtPrice);
            txt3 = (TextView) itemView.findViewById(R.id.txtDescr);
            btnDelete = (ImageButton) itemView.findViewById(R.id.btnDelete);
        }
    }
}
