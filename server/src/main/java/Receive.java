public class Receive {
    int color;
    int x;
    int y;

    public Receive(int color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Receive{" +
                "color=" + color +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
