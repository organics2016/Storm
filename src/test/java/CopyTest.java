import com.organics.base.storm.tools.StormCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王汗超 on 2017/4/10.
 */
public class CopyTest {


    public static void main(String[] args) {
        BeanTest test = new BeanTest();
        test.setAaa("xxxx");


        List<Map<String, List<String>>> xx = new ArrayList<>();

        Map<String, List<String>> xx1 = new HashMap<>();


        List<String> xx2 = new ArrayList<>();
        xx2.add("QQGG");

        xx1.put("qqgg", xx2);

        xx.add(xx1);

        test.setXxx(xx);


        long start = System.currentTimeMillis();
        BeanTest beanTest2 = StormCache.deepCopy(test);
        long end = System.currentTimeMillis();

        System.out.println(end - start);

        System.out.println(beanTest2.getAaa());
        System.out.println(beanTest2.getXxx());

    }
}
