package wang.sunnly.micro.tools.validate.properties;

/**
 * @author Sunnly
 * @ClassName ValidateProperties
 * @Date 2019/6/10 0010 20:33
 **/
public class ValidateProperties {

    private String key = "";

    private int length = 6;

    private long expire = 3600;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }
}
