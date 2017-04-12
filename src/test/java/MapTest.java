import com.organics.base.storm.cache.StormCache;

/**
 * Created by 王汗超 on 2017/4/12.
 */
public class MapTest {


    public static void main(String[] args) {

        MapTest test = new MapTest();
        StormCache.set(MapTest.class, "ddd", test);

        System.out.println(test);
        System.out.println(StormCache.get(MapTest.class, "ddd", false));

        test = new MapTest();
        StormCache.set(MapTest.class, "ddd", test);

        System.out.println(test);
        System.out.println(StormCache.get(MapTest.class, "ddd", false));

        test = new MapTest();
        StormCache.set(MapTest.class, "ddd", test);

        System.out.println(test);
        System.out.println(StormCache.get(MapTest.class, "ddd", false));

    }
}
