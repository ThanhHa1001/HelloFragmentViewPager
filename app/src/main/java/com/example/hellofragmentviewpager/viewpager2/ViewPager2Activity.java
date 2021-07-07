package com.example.hellofragmentviewpager.viewpager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.hellofragmentviewpager.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class ViewPager2Activity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    private ViewPager2Adapter mViewPager2Adapter;
    private String[] mTitleBalance;
    private Button mBtnUpdateContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager2 = findViewById(R.id.view_pager);
        mBtnUpdateContent = findViewById(R.id.btn_update_content);


        mTitleBalance = new String[] {"Exchange", "Basic", "Promotion", "Data"};

        FirstFragment f1 = FirstFragment.newInstance(1, "Page 1");
        FirstFragment f2 = FirstFragment.newInstance(2, "Page 2");
        FirstFragment f3 = FirstFragment.newInstance(3, "Page 3");
        FirstFragment f4 = FirstFragment.newInstance(4, "Page 4");

        List<FirstFragment> fragmentList = new ArrayList<>();
        fragmentList.add(f1);
        fragmentList.add(f2);
        fragmentList.add(f3);
        fragmentList.add(f4);

        mViewPager2Adapter = new ViewPager2Adapter(this, fragmentList);
        mViewPager2.setAdapter(mViewPager2Adapter);
        new TabLayoutMediator(mTabLayout, mViewPager2, true, (tab, position) -> {
            tab.setText(mTitleBalance[position]);
        }).attach();


        mViewPager2.setOffscreenPageLimit(4);

        mBtnUpdateContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f1.updateContent("Content Update 1");
                f2.updateContent("Content Update 2");
                f3.updateContent("Content Update 3");
                f4.updateContent("Content Update 4");
//                fragmentList.set(0, f1);
//                mViewPager2Adapter.notifyItemChanged(0);

                mViewPager2Adapter.notifyItemChanged(1);
            }
        });
    }
}