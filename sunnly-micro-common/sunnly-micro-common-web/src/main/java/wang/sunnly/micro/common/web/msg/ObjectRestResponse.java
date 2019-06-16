package wang.sunnly.micro.common.web.msg;

import java.util.Map;

public class ObjectRestResponse<E> extends BaseResponse {

    E data;
    boolean rel;

    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }


    public ObjectRestResponse rel(boolean rel) {
        this.setRel(rel);
        return this;
    }


    public ObjectRestResponse data(E data) {
        this.setData(data);
        return this;
    }
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public ObjectRestResponse flush(Map<String,Object> map){
        map.put("data",this);
        return this;
    }

    public String to(String url) {

        return url;
    }
}
