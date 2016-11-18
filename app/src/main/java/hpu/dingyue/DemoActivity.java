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

    private RecyclerView rightRecyclerView;
    private RecyclerView leftRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        leftRecyclerView = (RecyclerView) findViewById(R.id.left_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        leftRecyclerView.setLayoutManager(layoutManager);
        DemoDecoration decoration = new DemoDecoration(this, DemoDecoration.VERTICAL, R.drawable.divider_translate);
        leftRecyclerView.addItemDecoration(decoration);
        leftRecyclerView.setAdapter(new DemoAdapter1());

        rightRecyclerView = (RecyclerView) findViewById(R.id.right_recycler);

        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 7);
        rightRecyclerView.setLayoutManager(linearLayoutManager);
        DemoDecoration decoration1 = new DemoDecoration(this, 2, R.drawable.divider);
        rightRecyclerView.addItemDecoration(decoration1);
        rightRecyclerView.setAdapter(new DemoAdapter2());

        syncScrollEvent(leftRecyclerView, rightRecyclerView);
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
            return 350;
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
