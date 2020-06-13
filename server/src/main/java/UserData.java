import java.util.ArrayList;
import java.util.List;

public class UserData {
    int color;
    List<List<Integer>> x = new ArrayList<>();
    List<List<Integer>> y = new ArrayList<>();

    public UserData(Receive receive) {
        this.color = receive.color;
        updateList();
    }

    void updateList() {
        x.add(new ArrayList<>());
        y.add(new ArrayList<>());
    }

    public void addLast(Receive receive) {
        if (receive.x < 0) updateList();
        else {
            x.get(x.size() - 1).add(receive.x);
            y.get(y.size() - 1).add(receive.y);
        }
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
