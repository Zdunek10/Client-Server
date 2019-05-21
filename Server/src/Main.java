import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

//SERVER

    public static void main(String[] args) {

        //server socket waits for request to come in over the network
        try (ServerSocket serverSocket = new ServerSocket(5000)) {


            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
