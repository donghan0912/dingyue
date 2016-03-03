package hpu.dingyue;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/3.
 */
public class FirstPageFragment extends Fragment {

    private ListView mListView;
    private CustomAdapter mAdapter;
    private static final String NEWS_DATA = "NEWS_DATA";
    private ArrayList mList;
    private List<String> mLinkList;

    public static FirstPageFragment newInstance(ArrayList list) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(NEWS_DATA, list);
        FirstPageFragment fragment = new FirstPageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList = getArguments().getParcelableArrayList(NEWS_DATA);
        mLinkList = (List<String>) mList.get(1);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        mListView = (ListView) view.findViewById(R.id.lv);
        mAdapter = new CustomAdapter(mList);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = InfoActivity.getIntent(getActivity(), mLinkList.get(position));
                startActivity(intent);
            }
        });
        return view;
    }

    public class CustomAdapter extends BaseAdapter {

        private List data;
        private List<String> titleList;
        private List<String> contentList;
        private List<String> timeList;

        public CustomAdapter(List<List<String>> list) {
            this.data = list;
            titleList = (List<String>) data.get(0);
            contentList = (List<String>) data.get(2);
            timeList = (List<String>) data.get(3);
        }

        @Override
        public int getCount() {
            return ((List<String>)data.get(0)).size();
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
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(getActivity(), R.layout.listview_item, null);
                holder.mTitle = (TextView) convertView.findViewById(R.id.tv_title);
                holder.mTime = (TextView) convertView.findViewById(R.id.tv_time);
                holder.mContent = (TextView) convertView.findViewById(R.id.tv_content);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.mTitle.setText(titleList.get(position));
            holder.mTime.setText(timeList.get(position));
            holder.mContent.setText(contentList.get(position));
            return convertView;
        }
    }

    class ViewHolder {
        TextView mTitle;
        TextView mContent;
        TextView mTime;
    }
}
