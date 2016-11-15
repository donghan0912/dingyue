package hpu.dingyue;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import hpu.dingyue.widget.GridItemDecoration;
import hpu.dingyue.widget.TTT;

/**
 * Created by Administrator on 2016/11/8.
 */

public class DemoActivity extends AppCompatActivity {

    private RecyclerView recyclerView1;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        recyclerView = (RecyclerView) findViewById(R.id.second_recycler);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 6);
        recyclerView.setLayoutManager(layoutManager);
//        DemoDecoration decoration = new DemoDecoration(this, R.drawable.divider);
//        GridItemDecoration decoration = new GridItemDecoration(this, R.drawable.divider);
//        recyclerView.addItemDecoration(decoration);
        // 第一种方式
//        TTT ttt = new TTT(this, 2);
//        Drawable drawable1 = ContextCompat.getDrawable(this,  R.drawable.divider);
//        ttt.setDrawable(drawable1);

        // 第二种方式
        TTT ttt = new TTT(this, 2, R.drawable.divider);
        recyclerView.addItemDecoration(ttt);


        recyclerView.setAdapter(new DemoAdapter2());

        recyclerView1 = (RecyclerView) findViewById(R.id.first_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager);
//        DemoDecoration decoration1 = new DemoDecoration(this, LinearLayoutManager.HORIZONTAL, R.drawable.divider_translate);
//        DemoDecoration decoration1 = new DemoDecoration(this, R.drawable.divider_translate);
//        recyclerView1.addItemDecoration(decoration1);

//        TTT ttt1 = new TTT(this, LinearLayout.VERTICAL);
//        Drawable drawable2 = ContextCompat.getDrawable(this, R.drawable.divider_translate);
//        ttt1.setDrawable(drawable2);

        TTT ttt1 = new TTT(this, TTT.VERTICAL, R.drawable.divider_translate);
        recyclerView1.addItemDecoration(ttt1);

        recyclerView1.setAdapter(new DemoAdapter1());
        syncScrollEvent(recyclerView1, recyclerView);

    }

    class DemoAdapter2 extends RecyclerView.Adapter<DemoActivity.DemoAdapter2.MyViewHolder> {
        @Override
        public DemoActivity.DemoAdapter2.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            DemoActivity.DemoAdapter2.MyViewHolder holder = new DemoActivity.DemoAdapter2
                    .MyViewHolder(View.inflate(DemoActivity.this, R.layout.grid_view, null));
            return holder;
        }

        @Override
        public void onBindViewHolder(DemoActivity.DemoAdapter2.MyViewHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return 300;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView tv;
            public MyViewHolder(View itemView) {
                super(itemView);
            }
        }
    }

    class DemoAdapter1 extends RecyclerView.Adapter<DemoActivity.DemoAdapter1.MyViewHolder> {
        @Override
        public DemoActivity.DemoAdapter1.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            DemoActivity.DemoAdapter1.MyViewHolder holder = new DemoActivity.DemoAdapter1
                    .MyViewHolder(View.inflate(DemoActivity.this, R.layout.item, null));
            return holder;
        }

        @Override
        public void onBindViewHolder(DemoActivity.DemoAdapter1.MyViewHolder holder, int position) {
        }

        @Override
        public int getItemCount() {
            return 50;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView tv;
            public MyViewHolder(View itemView) {
                super(itemView);
            }
        }
    }

    private int i = 0;
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
