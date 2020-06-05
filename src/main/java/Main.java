import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

public class Main {
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        String ip = args.length > 0 ? args[0] : "localhost";
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 8080;

        InetAddress addr = InetAddress.getByName(ip);

        Gson gson = new Gson();
        Type list = new TypeToken<List<User>>() {
        }.getType();
        Screen frame = new Screen();

        try (Socket socket = new Socket(addr, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            while (true) {
                String str = in.readLine();
                List<User> users = gson.fromJson(str, list);
                for (User user : users) {
                    frame.setUser(user);
                    frame.repaint();
                }
            }
        }
    }
}
