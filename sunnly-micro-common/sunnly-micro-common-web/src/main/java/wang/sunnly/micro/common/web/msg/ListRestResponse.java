package wang.sunnly.micro.common.web.msg;

import java.util.List;

public class ListRestResponse<E> {
    String msg;
    List<E> result;
    int count;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<E> getResult() {
        return result;
    }

    public void setResult(List<E> result) {
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ListRestResponse count(int count) {
        this.setCount(count);
        return this;
    }

    public ListRestResponse count(Long count) {
        this.setCount(count.intValue());
        return this;
    }

    public ListRestResponse msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    public ListRestResponse result(List<E> result) {
        this.setResult(result);
        return this;
    }

}
