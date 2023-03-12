package com.example.pims;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ShowProductDiscription extends AppCompatActivity {
    TextView toolbar_text, sp_name1, cat_name1, dis_name1;
    ImageView sp_img;
    int id;
    Button inquery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showproductdetails);
        toolbar_text = findViewById(R.id.toolbar_text);
        toolbar_text.setText("Product Discription");
        FindViewByID();
        Intent i = getIntent();
        Product p = (Product) i.getSerializableExtra("product");

        Glide.with(this).load(WebServices.imgURL + p.getProImage()).into(sp_img);
        id = p.getId();
        Toast.makeText(getApplicationContext(), "id is "+id, Toast.LENGTH_SHORT).show();
        sp_name1.setText("Product Name : " + p.getProName());
        cat_name1.setText("Category Name : " + p.getCatName());
        dis_name1.setText(Html.fromHtml("<b>Description : <b> \n\n" + p.getProDiscription()));


        inquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Simple_Inqury.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("productID",""+p.getId());
                i.putExtra("productname",p.getProName());
                startActivity(i);
            }
        });


    }

    private void FindViewByID() {
        toolbar_text = findViewById(R.id.toolbar_text);
        sp_img = findViewById(R.id.sp_img);
        sp_name1 = findViewById(R.id.txtProductName);
        cat_name1 = findViewById(R.id.txtCategoryName);
        dis_name1 = findViewById(R.id.txtDescription);
        inquery = findViewById(R.id.inquery);
    }

}
