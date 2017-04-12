import com.organics.base.storm.cache.StormCache;

/**
 * Created by 王汗超 on 2017/4/12.
 */
public class MapTest {


    public static void main(String[] args) {
//        StormCache.set(MapTest.class, "ddd", new MapTest());

        System.out.println(StormCache.get(CopyTest.class,"ddd",false));
    }
}
