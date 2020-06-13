import java.util.Arrays;

public class User {
    int color;
    int[][] x;
    int[][] y;

    @Override
    public String toString() {
        return "User{" +
                "color=" + color +
                ", x=" + Arrays.toString(x) +
                ", y=" + Arrays.toString(y) +
                '}';
    }
}