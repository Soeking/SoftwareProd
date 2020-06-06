public class Send {
    int color;
    int x;
    int y;

    public Send(int color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Send{" +
                "color=" + color +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
