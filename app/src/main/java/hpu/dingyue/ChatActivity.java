package hpu.dingyue;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

import hpu.dingyue.bean.ChatMessage;
import hpu.dingyue.net.ChatUtil;
import hpu.dingyue.net.DYCallBack;

/**
 * Created by Administrator on 2016/3/22.
 */
public class ChatActivity extends Activity implements View.OnClickListener{

    private final String API_KEY = "3bc4d8968b4bfccf2a1f16e87e1ab0bb";
    private final String POST_URL = "http://www.tuling123.com/openapi/api";

    private ListView mListView;
    private EditText etText;
    private List<ChatMessage> mData = new ArrayList<>();
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mListView = (ListView) findViewById(R.id.lv);
        etText = (EditText) findViewById(R.id.et_info);
        TextView tvSend = (TextView) findViewById(R.id.tv_send);
        tvSend.setOnClickListener(this);

        chatAdapter = new ChatAdapter(mData);
        mListView.setAdapter(chatAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_send:
                ChatMessage chatMessage = new ChatMessage();
                chatMessage.msg = etText.getText().toString().trim();
                chatMessage.type = ChatMessage.Type.INPUT;
                mData.add(chatMessage);
                chatAdapter.notifyDataSetChanged();
                mListView.setSelection(mData.size() - 1);
                etText.setText("");

                ChatUtil.getInfo(chatMessage, new DYCallBack<String>() {
                    @Override
                    public void onGet(String result) {
                        Log.e("success", result);
                        ChatMessage chatMessage1 = new ChatMessage();
                        JSONObject object = JSON.parseObject(result);
                        chatMessage1.msg = ((String) object.get("text")).replace("<br>", "");
                        chatMessage1.type = ChatMessage.Type.OUTPUT;
                        mData.add(chatMessage1);
                        chatAdapter.notifyDataSetChanged();
                        mListView.setSelection(mData.size() - 1);
                    }
                });
                break;
        }
    }


    public class ChatAdapter extends BaseAdapter {

        private List<ChatMessage> mData;
        private static final int TYPE_IN = 0;
        private static final int TYPE_OUT = 1;

        public ChatAdapter(List<ChatMessage> list) {
            this.mData = list;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            return mData.get(position).type == ChatMessage.Type.INPUT ? TYPE_IN : TYPE_OUT;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            int type = getItemViewType(position);
            ViewHolder viewHolder;
            if(convertView == null) {
                 viewHolder = new ViewHolder();
                if (type == TYPE_IN) {
                    convertView = View.inflate(ChatActivity.this, R.layout.listview_item_right, null);
                    viewHolder.textView = (TextView) convertView.findViewById(R.id.tv_right);
                    convertView.setTag(viewHolder);
                } else if (type == TYPE_OUT) {
                    convertView = View.inflate(ChatActivity.this, R.layout.listview_item_left, null);
                    viewHolder.textView = (TextView) convertView.findViewById(R.id.tv_left);
                    convertView.setTag(viewHolder);
                }
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.textView.setText(mData.get(position).msg);
            return convertView;
        }

        private class ViewHolder {
            public TextView textView;
        }
    }
}
