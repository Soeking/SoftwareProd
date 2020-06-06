import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 8080;
        Gson gson = new Gson();
        List<UserData> users = new ArrayList<>();
        Set<Integer> userList = new HashSet<>();

        try (ServerSocket s = new ServerSocket(port)) {
            try (Socket socket = s.accept()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                while (true) {
                    String str = in.readLine();
                    Send receive = gson.fromJson(str, Send.class);

                    if (userList.contains(receive.color)) {
                        for (UserData user : users) {
                            if (user.color==receive.color){
                                user.x.add(receive.x);
                                user.y.add(receive.y);
                            }
                        }
                    } else {
                        userList.add(receive.color);
                        users.add(new UserData(receive));
                    }

                    out.println(gson.toJson(users));
                }
            }
        }
    }
}
