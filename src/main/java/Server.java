import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 8080;
        try (ServerSocket s = new ServerSocket(port)) {
            try (Socket socket = s.accept()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                while (true) {
                    String str = in.readLine();
                    if (str.equals("END")) break;
                    System.out.println("Echoing : ");
                    out.println(str);
                }
            }
        }
    }
}
