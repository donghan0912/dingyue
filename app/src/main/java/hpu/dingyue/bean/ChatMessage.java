package hpu.dingyue.bean;

/**
 * Created by Administrator on 2016/3/22.
 */
public class ChatMessage {
    public Type type;
    public String msg;

    public enum Type {
        INPUT, OUTPUT
    }
}
