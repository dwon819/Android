package org.techtown.pager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    String[] name = {"아지","까르","부륭"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                pager.setCurrentItem(0);
            }
        });Button button2 = findViewById(R.id.button1);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                pager.setCurrentItem(1);
            }
        });

        Button button3 = findViewById(R.id.button2);
        button3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                pager.setCurrentItem(2);
            }
        });
        

        pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        Fragment1 fragment1 = new Fragment1();
        adapter.addItem(fragment1);

        Fragment2 fragment2 = new Fragment2();
        adapter.addItem(fragment2);

        Fragment3 fragment3 = new Fragment3();
        adapter.addItem(fragment3);

        pager.setAdapter(adapter);
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter{
        ArrayList<Fragment> items = new ArrayList<Fragment>();
        public MyPagerAdapter(FragmentManager fm){
            super(fm);
        }

        public void addItem(Fragment item){
            items.add(item);
        }


        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }


        @Override
        public int getCount() {
            return items.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position){
            return name[position];
        }

    }
}