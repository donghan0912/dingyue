package hpu.dingyue.commonUtils;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/3/30.
 */
public class StringUtils {

    /**
     * 使用迭代器，循环遍历删除列表中元素
     */
    public static void remove() {

        List<String> list1 = new ArrayList();
        list1.add("a");
        list1.add("b");
        list1.add("a");
        list1.add("b");
        list1.add("a");
        list1.add("b");
        list1.add("c");
        Log.i("list-1", list1.toString());

        Iterator<String> iterator = list1.iterator();// 迭代器遍历，避免ConcurrentModificationException异常
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.contains("b")) {
                iterator.remove();
            }
        }
        Log.i("list-2", list1.toString());
    }
}
