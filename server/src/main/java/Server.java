import com.google.gson.Gson;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server extends WebSocketServer {
    Gson gson = new Gson();
    List<UserData> users = new ArrayList<>();
    Set<Integer> userList = new HashSet<>();

    public Server(int port) {
        super(new InetSocketAddress(port));
    }

    public static void main(String[] args) {
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 8080;
        new Server(port).start();
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {

    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {

    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        if ("clear".equals(message)) {
            users.clear();
            userList.clear();
        } else {
            Receive receive = gson.fromJson(message, Receive.class);

            if (userList.contains(receive.color)) {
                for (UserData user : users) {
                    if (user.color == receive.color) {
                        user.addLast(receive);
                    }
                }
            } else {
                userList.add(receive.color);
                users.add(new UserData(receive));
            }
        }

        broadcast(gson.toJson(users));
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {

    }

    @Override
    public void onStart() {

    }
}
