import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Random;

public class Screen extends JFrame implements MouseMotionListener, MouseListener {
    int width = 800;
    int height = 800;
    List<User> users;
    int color = new Random().nextInt(16777215);
    Gson gson = new Gson();

    public Screen() {
        setSize(width, height);
        setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    public void setUser(List<User> users) {
        this.users = users;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics graphics = getContentPane().getGraphics();
        if (users != null) {
            users.forEach(user -> {
                graphics.setColor(new Color(user.color));
                int len = user.x.length;
                for (int i = 0; i < len; i++) {
                    graphics.drawPolyline(user.x[i], user.y[i], user.x[i].length);
                }
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
    public void mouseReleased(MouseEvent mouseEvent) {
        Send s = new Send(color, -1, -1);
        String str = gson.toJson(s);
        Client.client.send(str);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
