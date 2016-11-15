package hpu.dingyue;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import hpu.dingyue.widget.CustomItemDecoration;
import hpu.dingyue.widget.GridItemDecoration;
import hpu.dingyue.widget.TTT;

/**
 * Created by lenovo on 2016/11/15.
 */

public class Demo2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_two);
        RecyclerView leftRecycler = (RecyclerView) findViewById(R.id.left_recycler);
        RecyclerView rightRecycler = (RecyclerView) findViewById(R.id.right_recycler);

        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        GridLayoutManager manager2 = new GridLayoutManager(this, 2);
        leftRecycler.setLayoutManager(manager1);
        rightRecycler.setLayoutManager(manager2);

//        DemoDecoration decoration = new DemoDecoration(this, R.drawable.divider);
//        rightRecycler.addItemDecoration(decoration);
////        DemoDecoration decoration1 = new DemoDecoration(this, LinearLayoutManager.HORIZONTAL, R.drawable.divider);
//        GridItemDecoration decoration1 = new GridItemDecoration(this, R.drawable.divider);
//        leftRecycler.addItemDecoration(decoration1);

        CustomItemDecoration customItemDecoration1 = new CustomItemDecoration(this, R.drawable.divider, LinearLayoutManager.VERTICAL);
        CustomItemDecoration customItemDecoration2 = new CustomItemDecoration(this, R.drawable.divider, 2);
        TTT ttt1 = new TTT(this, LinearLayout.VERTICAL);
        Drawable drawable1 = ContextCompat.getDrawable(this,  R.drawable.divider);
        Drawable drawable2 = ContextCompat.getDrawable(this,  R.drawable.divider_translate);
        ttt1.setDrawable(drawable1);
//        DividerItemDecoration ttt1 = new DividerItemDecoration(this, LinearLayout.VERTICAL);
        TTT ttt = new TTT(this, 2);
        ttt.setDrawable(drawable1);
        rightRecycler.addItemDecoration(ttt);
        leftRecycler.addItemDecoration(ttt1);


        DemoAdapter1 adapter = new DemoAdapter1();
        leftRecycler.setAdapter(adapter);
        rightRecycler.setAdapter(new DemoAdapter2());
        syncScrollEvent(leftRecycler, rightRecycler);
    }

    class DemoAdapter2 extends RecyclerView.Adapter<Demo2Activity.DemoAdapter2.MyViewHolder> {
        @Override
        public Demo2Activity.DemoAdapter2.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Demo2Activity.DemoAdapter2.MyViewHolder holder = new Demo2Activity.DemoAdapter2
                    .MyViewHolder(View.inflate(Demo2Activity.this, R.layout.grid_view, null));
            return holder;
        }

        @Override
        public void onBindViewHolder(Demo2Activity.DemoAdapter2.MyViewHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return 200;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView tv;
            public MyViewHolder(View itemView) {
                super(itemView);
            }
        }
    }

    class DemoAdapter1 extends RecyclerView.Adapter<Demo2Activity.DemoAdapter1.MyViewHolder> {
        @Override
        public Demo2Activity.DemoAdapter1.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Demo2Activity.DemoAdapter1.MyViewHolder holder = new Demo2Activity.DemoAdapter1
                    .MyViewHolder(View.inflate(Demo2Activity.this, R.layout.item, null));
            return holder;
        }

        @Override
        public void onBindViewHolder(Demo2Activity.DemoAdapter1.MyViewHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return 100;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView tv;
            public MyViewHolder(View itemView) {
                super(itemView);
            }
        }
    }

    private void syncScrollEvent(final RecyclerView leftList, final RecyclerView rightList) {

        /*leftList.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return rightList.getScrollState() != RecyclerView.SCROLL_STATE_IDLE;
            }
        });
        rightList.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return leftList.getScrollState() != RecyclerView.SCROLL_STATE_IDLE;
            }
        });*/

        leftList.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (recyclerView.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
                    rightList.scrollBy(dx, dy);
                    Log.e("左侧", dx + "/" + dy);
                }
            }
        });
        rightList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (recyclerView.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
                    leftList.scrollBy(dx, dy);
                    Log.e("右侧", dx + "/" + dy);
                }
            }
        });

    }
}
