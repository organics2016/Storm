import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * Created by 王汗超 on 2017/4/12.
 */
public class JSONTest {


    public static void main(String[] args) {

        String json = "{}";

        BeanTest test = JSONObject.parseObject(json, BeanTest.class);

        String json1 = JSONObject.toJSONString(null);

        BeanTest2 s = new BeanTest2();

        System.out.println(Serializable.class.isAssignableFrom(s.getClass()));

        System.out.println(test);
        System.out.println(json1);
    }
}
