package com.example.pims;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Simple_Inqury extends AppCompatActivity {

    ArrayList<ModelProductForSppiner> list = new ArrayList<>();
    Button submit_inq;
    EditText txt_fname, txt_lname, txt_mobileno, txt_email, txt_compnyname, txt_qtyname, txt_message, product_name;
    String fname, lname, mobileno, email, compnyname, qtyname, message, productname;
    Product p;
    String MobilePattern = "[0-9]{10}";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private Context mContext;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_inqury);
        mContext = Simple_Inqury.this;
        mIntent = getIntent();
        p = (Product) mIntent.getSerializableExtra("product");
        findViewByID();
        Body();
    }


    private void findViewByID() {
        submit_inq = findViewById(R.id.submit_inq);
        txt_fname = findViewById(R.id.txt_fname);
        txt_lname = findViewById(R.id.txt_lname);
        txt_mobileno = findViewById(R.id.txt_mobileno);
        txt_email = findViewById(R.id.txt_email);
        txt_compnyname = findViewById(R.id.txt_compnyname);
        txt_qtyname = findViewById(R.id.txt_qtyname);
        txt_message = findViewById(R.id.txt_message);

    }

    private void Body() {
        submit_inq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname = txt_fname.getText().toString().trim();
                lname = txt_lname.getText().toString().trim();
                mobileno = txt_mobileno.getText().toString().trim();
                email = txt_email.getText().toString().trim();
                compnyname = txt_compnyname.getText().toString().trim();
                qtyname = txt_qtyname.getText().toString().trim();
                message = txt_message.getText().toString().trim();


                if (TextUtils.isEmpty(fname)) {
                    txt_fname.setError("First name is required!");
                } else if (TextUtils.isEmpty(lname)) {
                    txt_lname.setError("Last name is required!");
                } else if (TextUtils.isEmpty(mobileno) || !mobileno.matches(MobilePattern)) {
                    txt_mobileno.setError("Please Enter Valid Mobile Number ");
                } else if (TextUtils.isEmpty(email) || !email.matches(emailPattern)) {
                    txt_email.setError("Please Enter Valid Email ");
                } else if (TextUtils.isEmpty(compnyname)) {
                    txt_compnyname.setError("Company name is required!");
                } else if (TextUtils.isEmpty(qtyname)) {
                    txt_qtyname.setError("Qty is required!");
                } else if (TextUtils.isEmpty(message)) {
                    txt_message.setError("Description is required!");
                } else {
                    InsertInquiryApi();
                }
            }
        });
    }


    private void InsertInquiryApi() {
        StringRequest mStringRequest = new StringRequest(Request.Method.POST, WebServices.insertInquire, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(mContext, "" + response, Toast.LENGTH_SHORT).show();
                mIntent = new Intent(mContext, DashboardActivity.class);
                startActivity(mIntent);
                Toast.makeText(mContext, "Inquiry Submitted Successfully", Toast.LENGTH_LONG).show();
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse networkResponse = error.networkResponse;
                Toast.makeText(mContext, "" + networkResponse.statusCode, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("inq_fname", fname);
                param.put("inq_lname", lname);
                param.put("inq_mobileno", mobileno);
                param.put("inq_emailid", email);
                param.put("inq_compnyame", compnyname);
                param.put("product_id", "" + mIntent.getStringExtra("productID"));
                param.put("inq_qty", qtyname);
                param.put("inq_discription", message);

                return param;
            }
        };
        RequestQueue mQueue = Volley.newRequestQueue(mContext);
        mQueue.add(mStringRequest);

    }
}

