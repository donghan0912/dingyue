package hpu.dingyue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/8.
 */

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.second_recycler);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 6);
        recyclerView.setLayoutManager(layoutManager);
//        DemoDecoration decoration = new DemoDecoration(this);
        DemoDecoration decoration = new DemoDecoration(this, R.drawable.divider);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(new DemoAdapter2());

        RecyclerView recyclerView1 = (RecyclerView) findViewById(R.id.first_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(linearLayoutManager);
        DemoDecoration decoration1 = new DemoDecoration(this, R.drawable.divider_translate);
        recyclerView1.addItemDecoration(decoration1);
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
            return 78;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            private TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
//                tv = (TextView) itemView.findViewById(R.id.tv);
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
            return 13;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            private TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
//                tv = (TextView) itemView.findViewById(R.id.tv);
            }
        }
    }


    private void syncScrollEvent(final RecyclerView leftList, final RecyclerView rightList) {

        leftList.setOnTouchListener(new View.OnTouchListener() {
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
        });


        leftList.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (recyclerView.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
                    rightList.scrollBy(dx, dy);
                }
            }
        });
        rightList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (recyclerView.getScrollState() != RecyclerView.SCROLL_STATE_IDLE) {
                    leftList.scrollBy(dx, dy);
                }
            }
        });

    }

}
