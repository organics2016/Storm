import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 王汗超 on 2017/4/10.
 */

public class BeanTest implements Serializable {

    private String aaa;

    private List<Map<String, List<String>>> xxx;


    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public List<Map<String, List<String>>> getXxx() {
        return xxx;
    }

    public void setXxx(List<Map<String, List<String>>> xxx) {
        this.xxx = xxx;
    }
}
