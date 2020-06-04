import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    int width = 800;
    int height = 800;
    Graphics graphics;

    public Screen() {
        setSize(width, height);
        setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graphics = getGraphics();
    }

    public void paint(User user) {
        super.paint(graphics);
        graphics.setColor(new Color(user.color));
        int len = user.x.length;
        graphics.drawPolyline(user.x, user.y, len);
    }
}
