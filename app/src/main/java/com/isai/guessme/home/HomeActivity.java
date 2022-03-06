package com.isai.guessme.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.isai.guessme.R;
import com.isai.guessme.home.adapter.DynamicViewPager;
import com.isai.guessme.home.fragment.CertificateFragment;
import com.isai.guessme.home.fragment.ChatFragment;
import com.isai.guessme.home.fragment.ProfileFragment;
import com.isai.guessme.home.fragment.ScoreFragment;

public class HomeActivity extends AppCompatActivity {
    ViewPager vpHome;
    TabLayout tlHome;
    DynamicViewPager dynamicViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        vpHome = findViewById(R.id.vp_parent);
        tlHome = findViewById(R.id.tl_parent);
        dynamicViewPager = new DynamicViewPager(getSupportFragmentManager(), 0);
        dynamicViewPager.addFragment(new ProfileFragment(),"Profile");
        dynamicViewPager.addFragment(new CertificateFragment(),"Certificate");
        dynamicViewPager.addFragment(new ChatFragment(),"Chat");
        dynamicViewPager.addFragment(new ScoreFragment(),"Score");
        vpHome.setAdapter(dynamicViewPager);
        tlHome.setupWithViewPager(vpHome);
    }
}
