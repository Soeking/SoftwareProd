import java.util.ArrayList;
import java.util.List;

public class UserData {
    int color;
    List<Integer> x = new ArrayList<>();
    List<Integer> y = new ArrayList<>();

    public UserData(Send send) {
        this.color = send.color;
        this.x.add(send.x);
        this.y.add(send.y);
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
