import java.util.Arrays;
import java.util.Random;

public class User {
    int color;
    int[] x;
    int[] y;

    public User(int[] x, int[] y) {
        color = new Random().nextInt(8388608);
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "User{" +
                "color=" + color +
                ", x=" + Arrays.toString(x) +
                ", y=" + Arrays.toString(y) +
                '}';
    }
}