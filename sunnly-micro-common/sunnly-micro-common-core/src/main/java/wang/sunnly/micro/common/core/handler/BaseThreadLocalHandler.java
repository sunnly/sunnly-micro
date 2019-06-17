package wang.sunnly.micro.common.core.handler;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import wang.sunnly.micro.common.core.constants.BaseThreadLocalConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Sunnly
 * @ClassName BaseThreadLocalHandler
 * @Date 2019/6/17 17:46
 * @Version 1.0
 */
public class BaseThreadLocalHandler {
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key){
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static String getUserID(){
        Object value = get(BaseThreadLocalConstants.CONTEXT_KEY_USER_ID);
        return returnObjectValue(value);
    }

    public static String getUsername(){
        Object value = get(BaseThreadLocalConstants.CONTEXT_KEY_USERNAME);
        return returnObjectValue(value);
    }


    public static String getName(){
        Object value = get(BaseThreadLocalConstants.CONTEXT_KEY_USER_NAME);
        return Objects.toString(value);
    }

    public static String getToken(){
        Object value = get(BaseThreadLocalConstants.CONTEXT_KEY_USER_TOKEN);
        return Objects.toString(value);
    }
    public static void setToken(String token){set(BaseThreadLocalConstants.CONTEXT_KEY_USER_TOKEN,token);}

    public static void setName(String name){set(BaseThreadLocalConstants.CONTEXT_KEY_USER_NAME,name);}

    public static void setUserID(String userID){
        set(BaseThreadLocalConstants.CONTEXT_KEY_USER_ID,userID);
    }

    public static void setUsername(String username){
        set(BaseThreadLocalConstants.CONTEXT_KEY_USERNAME,username);
    }

    private static String returnObjectValue(Object value) {
        return value==null?null:value.toString();
    }

    public static void remove(){
        threadLocal.remove();
    }
}
