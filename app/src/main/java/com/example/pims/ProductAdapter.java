package com.example.pims;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.DisplayProductViewHolder> {
    Context context;
    Product[] object;
    int proId;
    public ProductAdapter(Context context,Product[] object)
    {
        this.context=context;
        this.object=object;
    }

    @NonNull
    @Override
    public DisplayProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.product_layout,parent,false);
        return new DisplayProductViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DisplayProductViewHolder holder, int position) {
        Product P = object[position];

        holder.textViewName.setText(""+P.getProName());
        holder.textViewCategory.setText(""+P.getCatName());
        Glide.with(context).load(WebServices.imgURL+P.getProImage()).into(holder.img_viewproduct);

        holder.img_viewproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowProductDiscription.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("product",P);
                context.startActivity(intent);

                proId = P.getId();
                Toast.makeText(context, ""+P.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.inquery_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,Simple_Inqury.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("productID",""+P.getId());
                i.putExtra("productname",""+P.getProName());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return object.length;
    }


    public static class DisplayProductViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewCategory, inquery_btn;
        ImageView img_viewproduct;
        public DisplayProductViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName =itemView.findViewById(R.id.textViewName);
            textViewCategory=itemView.findViewById(R.id.textViewCategory);
            inquery_btn=itemView.findViewById(R.id.inquery_btn);
            img_viewproduct=itemView.findViewById(R.id.img_viewproduct);

        }
    }
}
