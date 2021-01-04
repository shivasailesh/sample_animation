package com.example.animation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
         ViewPager2 vpVertical,vpHorizontal;
         int[] images={R.drawable.number1,R.drawable.number2,R.drawable.number3,R.drawable.master4,R.drawable.master5};

         MainAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        vpVertical=findViewById(R.id.vp_vertical);
        vpHorizontal=findViewById(R.id.vp_horizontal );


        adapter=new MainAdapter(images);
        vpVertical.setAdapter(adapter);
        vpVertical.setClipToPadding(false);
        vpVertical.setClipChildren(false);
        vpHorizontal.setOffscreenPageLimit(3);

        vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        vpHorizontal.setAdapter(adapter);


        CompositePageTransformer transformer=new CompositePageTransformer();

        transformer.addTransformer(new MarginPageTransformer(10));

        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float v =1-Math.abs(position);

                page.setScaleY(0.7f + v*0.2f);
                page.setScaleX(0.8f +v*0.2f);
            }
        });

        vpHorizontal.setPageTransformer(transformer);
    }

}