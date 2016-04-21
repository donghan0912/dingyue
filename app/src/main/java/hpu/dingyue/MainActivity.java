package hpu.dingyue;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Looper;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hpu.dingyue.commonUtils.AnimationUtils;
import hpu.dingyue.commonUtils.SharePreUtil;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private FragmentManager supportFragmentManager;
    private List mList = new ArrayList();
    private MyAdapter myAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    private EditText etText;
    private EditText etText2;
    private Button btn5;
    private TextView scale1;
    private TextView scale2;
    private Button btn6;

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
        Button btn4 = (Button) findViewById(R.id.btn4);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        etText = (EditText) findViewById(R.id.et_text);
        etText2 = (EditText) findViewById(R.id.et_text2);
        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(this);

        scale1 = (TextView) findViewById(R.id.tv_scale1);
        scale2 = (TextView) findViewById(R.id.tv_scale2);

        findViewById(R.id.btn7).setOnClickListener(this);

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
                AnimationUtils.scale(scale1);
                AnimationUtils.translation(scale2);
                try {
                    int i = 2/0;
                    Log.e("接着：", "------------------");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.e("出来了：", "------------------");
                break;
            case R.id.btn4:

                startActivity(new Intent(this, TestActivity.class));

                Map map = new HashMap();
                map.put("pwd", "123456");
                map.put("userName", "dh");

                JSONArray array = new JSONArray();
                array.add("hehehhe");
                Map map1 = new HashMap();
                map1.put("id", "hehehhe");

                JSONArray array2 = new JSONArray();
                array2.add("hahahahah");
                Map map2 = new HashMap();
                map2.put("name", "hahahahah");

                List list = new ArrayList();
                list.add(map1);
                list.add(map2);


                map.put("test", list);
                String s = JSON.toJSONString(map);
                Log.i("fastJson", s);

                Date date = new Date(System.currentTimeMillis());
                Date date1 = new Date(System.currentTimeMillis() + 8 * 60 * 60 * 1000);
                boolean sameDay = isSameDay(date, date1);
                if (sameDay) {
                    Log.i("ce", "是在同一天啊");
                }

                SharePreUtil.getIntance(this).setKey("123456");
                Toast.makeText(this, SharePreUtil.getIntance(this).getKey(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn5:
                startActivity(new Intent(this, ChatActivity.class));
                break;
            case R.id.btn6:
                startActivity(new Intent(this, ExpandableListViewActivity.class));
                break;
            case R.id.btn7:
                startActivity(new Intent(this, RadioActivity.class));
                break;
        }
    }

    public boolean isSameDay(Date day1, Date day2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ds1 = sdf.format(day1);
        String ds2 = sdf.format(day2);
        if (ds1.equals(ds2)) {
            return true;
        } else {
            return false;
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                Toast.makeText(this, "音量--------", Toast.LENGTH_SHORT).show();
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                Toast.makeText(this, "音量++++++++", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
