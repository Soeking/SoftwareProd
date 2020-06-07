import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Client extends WebSocketClient {
    static Client client;
    Gson gson = new Gson();
    Type list = new TypeToken<List<User>>() {
    }.getType();
    static Screen frame = new Screen();

    public Client(URI serverUri) {
        super(serverUri);
    }

    public static void main(String[] args) throws URISyntaxException {
        String ip = args.length > 0 ? args[0] : "localhost";
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 8080;
        client = new Client(new URI("ws://" + ip + ":" + port));
        client.connect();

        new Thread(frame).start();
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {

    }

    @Override
    public void onMessage(String message) {
        List<User> users = gson.fromJson(message, list);
        frame.setUser(users);
        frame.repaint();
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println(reason);
        System.exit(code);
    }

    @Override
    public void onError(Exception ex) {

    }
}
