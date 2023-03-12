package com.example.pims;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private View mView;
    private GridView idProductModel;

    private Context mContext;
    private Intent i;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        mContext = container.getContext();

        sliderView();
        FindViewByID(mView);
        return mView;

    }

    private void FindViewByID(View mView) {
        idProductModel = mView.findViewById(R.id.idProductModel);

        OnClick();
    }

    private void sliderView() {


        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = mView.findViewById(R.id.slider_id);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(WebServices.imgURL + "1655111286.jpg"));
        sliderDataArrayList.add(new SliderData(WebServices.imgURL + "1655183295.jpg"));
        sliderDataArrayList.add(new SliderData(WebServices.imgURL + "1655110887.jpg"));
        sliderDataArrayList.add(new SliderData(WebServices.imgURL + "1656659673.jpg"));



        SliderAdapter adapter = new SliderAdapter(mContext, sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);


        sliderView.setSliderAdapter(adapter);

        sliderView.setScrollTimeInSec(3);

        sliderView.setAutoCycle(true);

        sliderView.startAutoCycle();

    }


    private void OnClick() {


        ArrayList<ProductModel> productModelArrayList = new ArrayList<ProductModel>();
        productModelArrayList.add(new ProductModel("Product", R.drawable.product));
        productModelArrayList.add(new ProductModel("Inquiry", R.drawable.inquire));
        productModelArrayList.add(new ProductModel("Contact Us", R.drawable.contectus));
        productModelArrayList.add(new ProductModel("About Us", R.drawable.aboutus));


        ProductGridAdapter adapter = new ProductGridAdapter(mContext, productModelArrayList);
        idProductModel.setAdapter(adapter);
        idProductModel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {

                    i = new Intent(mContext, DisplayProducts.class);
                    startActivity(i);

                } else if (position == 1) {
                    i = new Intent(mContext, Inquire.class);
                    startActivity(i);

                } else if (position == 2) {

                    i = new Intent(mContext, ContectUs.class);
                    startActivity(i);
                } else if (position == 3) {

                    i = new Intent(mContext, About_Us.class);
                    startActivity(i);
                }
            }
        });

    }
}