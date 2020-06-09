import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Random;

public class Screen extends JFrame implements MouseMotionListener {
    int width = 800;
    int height = 800;
    List<User> users;
    int color = new Random().nextInt(8388608);
    Gson gson = new Gson();

    public Screen() {
        setSize(width, height);
        setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseMotionListener(this);
    }

    public void setUser(List<User> users) {
        this.users = users;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics graphics = getContentPane().getGraphics();
        if (users!=null) {
            users.forEach(user -> {
                graphics.setColor(new Color(user.color));
                int len = user.x.length;
                graphics.drawPolyline(user.x, user.y, len);
            });
        }
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        Send s = new Send(color, mouseEvent.getX(), mouseEvent.getY());
        String str = gson.toJson(s);
        Client.client.send(str);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
