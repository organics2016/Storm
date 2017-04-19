import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 王汗超 on 2017/4/19.
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Result> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Result r = new Result();
            r.setId(i);

            for (int j = 0; j < 10; j++) {
                Result r2 = new Result();
                r2.setId(j);
                r.getList().add(r2);
            }

            list.add(r);
        }

        List<Long> l = list.stream().map(Result::getList).flatMap(d -> d.stream().map(Result::getId)).collect(Collectors.toList());

        System.out.println(l);
//        System.out.println(list2);
    }
}

class Result {

    private long id;

    private String message;

    private List<Result> list = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Result> getList() {
        return list;
    }

    public void setList(List<Result> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ID : " + this.id + " , " + "msg : " + this.message;
    }
}