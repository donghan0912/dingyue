package hpu.dingyue;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2016/4/14.
 */
public class ExpandableListViewActivity extends Activity implements View.OnClickListener{

    private ExpandableListView mListView1;
    private ListView mListView;
    private List<String> data;
    private GroupAdapter groupAdapter;
    private List myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

//        mListView1 = (ExpandableListView) findViewById(R.id.expandable_listview);
//        MyExpandableListViewAdapter adapter = new MyExpandableListViewAdapter();
//        mListView1.setAdapter(adapter);

        mListView = (ListView) findViewById(R.id.lv);
        groupAdapter = new GroupAdapter();
        mListView.setAdapter(groupAdapter);

//        ListView listView2 = (ListView) findViewById(R.id.lv2);

        data = new ArrayList();
        data.add("haha1");
        data.add("haha2");
        data.add("haha3");

        List list2 = new ArrayList();
        list2.add("123");
        list2.add("124");
        List list3 = new ArrayList();
        list3.add("1235");
        list3.add("1235");
        list3.add("1235");
        list3.add("1235");
        list3.add("1235");
        list3.add("1245");
        List list4 = new ArrayList();
        list4.add("1236");
        list4.add("1246");
        list4.add("1246");
        list4.add("1246");
        list4.add("1246");
        list4.add("1246");

        myData = new ArrayList();

        for (int i = 0; i <= 8; i++) {
            List<String> list = new ArrayList<>();
            list.add(1 + "这是第" + i + "条数据");
            list.add(2 + "这是第" + i + "条数据");
            list.add(3 + "这是第" + i + "条数据");
            list.add(3 + "这是第" + i + "条数据");
            list.add(3 + "这是第" + i + "条数据");
            list.add(3 + "这是第" + i + "条数据");
            list.add(3 + "这是第" + i + "条数据");
            list.add(3 + "这是第" + i + "条数据");
            list.add(3 + "这是第" + i + "条数据");
            list.add(3 + "这是第" + i + "条数据");
            list.add(3 + "这是第" + i + "条数据");
            list.add(3 + "这是第" + i + "条数据");
            list.add(3 + "这是第" + i + "条数据");
            list.add(3 + "这是第" + i + "条数据");
            list.add(3 + "这是第" + i + "条数据");
            list.add(3 + "这是第" + i + "条数据");
            myData.add(list);
        }

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
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


    class GroupAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 8;
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(getApplicationContext(), R.layout.expendlist_group, null);
                viewHolder.childView = (ListView) convertView.findViewById(R.id.lv_child);
                viewHolder.tv = (TextView) convertView.findViewById(R.id.tv_control);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.tv.setTag(R.id.first_tag, position);
            viewHolder.childView.setTag(R.id.second_tag, position);

            viewHolder.childView.setVisibility(View.GONE);

            if (getPosition().contains(String.valueOf(position))) {
                viewHolder.childView.setVisibility(View.VISIBLE);
                viewHolder.childView.setAdapter(new ChildrenAdapter(position));
                setListViewHeightBasedOnChildren(viewHolder.childView);
                viewHolder.tv.setText("收起笔记");
            } else {
                viewHolder.childView.setVisibility(View.GONE);
                viewHolder.tv.setText("展开笔记");
            }

            final ViewHolder finalViewHolder = viewHolder;
            viewHolder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ("展开笔记".equals(finalViewHolder.tv.getText().toString())) {
                        finalViewHolder.childView.setVisibility(View.VISIBLE);
                        finalViewHolder.childView.setAdapter(new ChildrenAdapter(position));
                        setListViewHeightBasedOnChildren(finalViewHolder.childView);
                        finalViewHolder.tv.setText("收起笔记");
                        setPosition(position);
                    } else {
                        finalViewHolder.childView.setVisibility(View.GONE);
                        finalViewHolder.tv.setText("展开笔记");
                        removePos(position);
                    }

                }
            });

            return convertView;
        }

        class ViewHolder{
            TextView tv;
            ListView childView;
        }

        List<String> mList = new ArrayList<>();
        public void setPosition(int position) {
            mList.add(String.valueOf(position));
        }

        private void removePos(int position) {
            mList.remove(String.valueOf(position));
        }

        public List<String> getPosition() {
            return mList;
        }

    }

    class ChildrenAdapter extends BaseAdapter {

        private int pos;
        List<String> data;

        public ChildrenAdapter(int positon) {
            this.pos = positon;
            data = (List) myData.get(pos);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public String getItem(int position) {
            return  data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(getApplicationContext(), R.layout.expend_listview_item, null);
                viewHolder.tv = (TextView) convertView.findViewById(R.id.tv);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.tv.setText( data.get(position));
            return convertView;
        }

        class ViewHolder{
            TextView tv;
        }
    }

}
