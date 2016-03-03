package hpu.dingyue;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        supportFragmentManager = getSupportFragmentManager();
        MyAdapter myAdapter = new MyAdapter(supportFragmentManager);

        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Map<String, String> map = new HashMap<>();
                            Document document = Jsoup.connect("http://www.androidweekly.cn/").get();
//                            Elements links = document.select("a[href]");
                            Elements links = document.select("h2 a");// 获取h2元素下的所有a元素
                            for(Element link : links) {
                                map.put(link.attr("abs:href"), link.text());
                                System.out.println(link.attr("abs:href") + link.text());
                            }
                            Log.w("test2", map.toString());

                            Elements elements = document.select("section p");
                            for(Element element : elements) {
                                System.out.println(element.text());
                            }

                            Elements time = document.getElementsByTag("time");
                            for (Element element : time) {
                                System.out.println(element.text());
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;
        }
    }

    class MyAdapter extends FragmentPagerAdapter {
        public int PAGE_COUNT = 3;
        private String[] tabTitles = {"Tab1", "tab2", "tab3"};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

    }
}
