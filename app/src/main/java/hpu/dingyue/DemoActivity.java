package hpu.dingyue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 6);
        recyclerView.setLayoutManager(layoutManager);
        DemoDecoration decoration = new DemoDecoration(this);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(new DemoAdapter());
    }

    class DemoAdapter extends RecyclerView.Adapter<DemoActivity.DemoAdapter.MyViewHolder> {


        @Override
        public DemoActivity.DemoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            DemoActivity.DemoAdapter.MyViewHolder holder = new DemoActivity.DemoAdapter
                    .MyViewHolder(View.inflate(DemoActivity.this, R.layout.grid_view, null));
            return holder;
        }

        @Override
        public void onBindViewHolder(DemoActivity.DemoAdapter.MyViewHolder holder, int position) {
        }


        @Override
        public int getItemCount() {
            return 80;
        }


        class MyViewHolder extends RecyclerView.ViewHolder {

            private TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
//                tv = (TextView) itemView.findViewById(R.id.tv);
            }
        }
    }

}
