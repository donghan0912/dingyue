package hpu.dingyue;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
public class ImageActivity extends AppCompatActivity {
    public static final int[] images = new int[]{R.drawable.bg_guide1,
            R.drawable.bg_guide2, R.drawable.bg_guide3};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        List<String> urls = new ArrayList<>();
        urls.add("1");
        urls.add("1");
        urls.add("1");
        viewPager.setAdapter(new PhotoPager(this, urls));
        List<Fragment> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ImageFragment imageFragment = new ImageFragment();
            list.add(imageFragment);
        }
//        viewPager.setAdapter(new PhotoFragmentAdapter(getSupportFragmentManager(), list));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class PhotoPager extends PagerAdapter {

        private Context context;
        private List<String> urls;

        public PhotoPager(Context context, List<String> urls) {
            this.urls = urls;
            this.context = context;
        }

        @Override
        public int getCount() {
            return urls.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(context).inflate(R.layout.popup_image, null);
            ImageView iv = (ImageView) view.findViewById(R.id.img);
//            Picasso.with(getApplicationContext()).load(urls.get(position)).into(iv);
            iv.setImageResource(images[position]);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    class PhotoFragmentAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public PhotoFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }
}
