package hpu.dingyue;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/14.
 */
public class ExpandableListViewActivity extends Activity {

    private ExpandableListView mListView1;
    private ListView mListView;
    private List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

//        mListView1 = (ExpandableListView) findViewById(R.id.expandable_listview);
//        MyExpandableListViewAdapter adapter = new MyExpandableListViewAdapter();
//        mListView1.setAdapter(adapter);

        mListView = (ListView) findViewById(R.id.lv);
        GroupAdapter groupAdapter = new GroupAdapter();
        mListView.setAdapter(groupAdapter);

//        ListView listView2 = (ListView) findViewById(R.id.lv2);

        data = new ArrayList();
        data.add("haha1");
        data.add("haha2");
        data.add("haha3");

//        final ChildrenAdapter childrenAdapter = new ChildrenAdapter();
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ListView childView = list.get(position);
//                if (childView.getVisibility() == View.GONE) {
//                    childView.setVisibility(View.VISIBLE);
//                    childView.setAdapter(childrenAdapter);
//                    setListViewHeightBasedOnChildren(childView);
//                } else {
//                    childView.setVisibility(View.GONE);
//                }
//            }
//        });
    }

    /**
     * 解决listview显示一行的问题
     **/
    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


        class MyExpandableListViewAdapter extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return 3;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return 3;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return null;
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            convertView = View.inflate(getApplicationContext(), R.layout.expendlist_group, null);
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            convertView = View.inflate(getApplicationContext(), R.layout.expendlist_item, null);
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

    private List<ListView> list = new ArrayList();
    private ListView childView;
    class GroupAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = new ViewHolder();
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(), R.layout.expendlist_group, null);
                childView = (ListView) convertView.findViewById(R.id.lv_child);


                list.add(childView);
            } else {

            }

            TextView tv = (TextView) convertView.findViewById(R.id.tv_content);
            final ChildrenAdapter childrenAdapter = new ChildrenAdapter();
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    if (childView.getVisibility() == View.GONE) {
//                        childView.setVisibility(View.VISIBLE);
                        childView.setAdapter(childrenAdapter);
                        setListViewHeightBasedOnChildren(childView);
//                    } else {
//                        childView.setVisibility(View.GONE);
//                    }
                }
            });

            return convertView;
        }

        class ViewHolder{

        }



    }


    class ChildrenAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public String getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = new ViewHolder();
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(), R.layout.expend_listview_item, null);
            }
            TextView tv = (TextView) convertView.findViewById(R.id.tv);
            tv.setText(data.get(position));
            return convertView;
        }

        class ViewHolder{

        }
    }
}
