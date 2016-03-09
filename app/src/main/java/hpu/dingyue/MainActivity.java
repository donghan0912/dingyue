package hpu.dingyue;

import android.os.Looper;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private FragmentManager supportFragmentManager;
    private List mList = new ArrayList();
    private MyAdapter myAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        supportFragmentManager = getSupportFragmentManager();
        myAdapter = new MyAdapter(supportFragmentManager);

        Button btn = (Button) findViewById(R.id.btn);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Document document = Jsoup.connect("http://www.androidweekly.cn/").get();
                            Elements links = document.select("h2 a");// 获取h2元素下的所有a元素
                            List<String> titleList = new ArrayList<String>();
                            List<String> linkList = new ArrayList<String>();
                            for(Element link : links) {
                                linkList.add(link.attr("abs:href"));
                                titleList.add(link.text());
//                                System.out.println(link.attr("abs:href") + link.text());
                            }

                            Elements contents = document.select("section p");
                            List<String> contentList = new ArrayList<String>();
                            for(Element content : contents) {
                                contentList.add(content.text());
//                                System.out.println(content.text());
                            }

                            Elements times = document.getElementsByTag("time");
                            List<String> timeList = new ArrayList<String>();
                            for (Element time : times) {
                                timeList.add(time.text());
//                                System.out.println(time.text());
                            }

                            mList.add(titleList);
                            mList.add(linkList);
                            mList.add(contentList);
                            mList.add(timeList);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    viewPager.setAdapter(myAdapter);
                                    tabLayout.setupWithViewPager(viewPager);
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();*/


                Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        try {
                            Document document = Jsoup.connect("http://www.androidweekly.cn/").get();
                            Elements links = document.select("h2 a");// 获取h2元素下的所有a元素
                            List<String> titleList = new ArrayList<String>();
                            List<String> linkList = new ArrayList<String>();
                            for(Element link : links) {
                                linkList.add(link.attr("abs:href"));
                                titleList.add(link.text());
//                                System.out.println(link.attr("abs:href") + link.text());
                            }

                            Elements contents = document.select("section p");
                            List<String> contentList = new ArrayList<String>();
                            for(Element content : contents) {
                                contentList.add(content.text());
//                                System.out.println(content.text());
                            }

                            Elements times = document.getElementsByTag("time");
                            List<String> timeList = new ArrayList<String>();
                            for (Element time : times) {
                                timeList.add(time.text());
//                                System.out.println(time.text());
                            }
                            mList.add(titleList);
                            mList.add(linkList);
                            mList.add(contentList);
                            mList.add(timeList);

                            subscriber.onCompleted();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer() {
                            @Override
                            public void onCompleted() {
                                viewPager.setAdapter(myAdapter);
                                tabLayout.setupWithViewPager(viewPager);
                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                            }

                            @Override
                            public void onNext(Object o) {

                            }
                        });
                break;
            case R.id.btn2:
                Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("hellow");
                        subscriber.onNext("rx");
                        subscriber.onNext("android");
                        subscriber.onCompleted();
                    }
                })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<String>() {
                            @Override
                            public void onCompleted() {
                                Log.d("complete", "结束");
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(String s) {
                                Log.d("tag", s);
                            }
                        });
                break;
            case R.id.btn3:
                try {
                    int i = 2/0;
                    Log.e("接着：", "------------------");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.e("出来了：", "------------------");
                break;
        }
    }

    /**
     * 检测当前是否为主线程
     *
     * @return
     */
    public boolean isInMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    class MyAdapter extends FragmentPagerAdapter {
        public int PAGE_COUNT = 3;
        private String[] tabTitles = {"Tab1", "tab2", "tab3"};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return FirstPageFragment.newInstance((ArrayList) mList);
            }
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
