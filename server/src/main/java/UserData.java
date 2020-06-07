import java.util.ArrayList;
import java.util.List;

public class UserData {
    int color;
    List<Integer> x = new ArrayList<>();
    List<Integer> y = new ArrayList<>();

    public UserData(Receive receive) {
        this.color = receive.color;
        this.x.add(receive.x);
        this.y.add(receive.y);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "color=" + color +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
