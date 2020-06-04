import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        String ip = args.length > 0 ? args[0] : "localhost";
//        int port = args.length > 1 ? Integer.parseInt(args[1]) : 8080;
//
//        InetAddress addr = InetAddress.getByName(ip);
//        Socket socket = new Socket(addr, port);

        Screen frame = new Screen();
        int[] x = {20, 40, 80, 800};
        int[] y = {120, 340, 80, 800};
        User user = new User(x, y);
        frame.setUser(user);
        frame.repaint();

        Gson gson = new Gson();
        System.out.println(gson.toJson(user));
        Type list = new TypeToken<List<User>>() {}.getType();
    }
}
