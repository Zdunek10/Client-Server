import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    //CLIENT

    int port = 5000;
    String lHost = "127.0.0.1";

    public static void main(String[] args) {
        Main main = new Main();
        main.ServConnection();
    }

    private void ServConnection() {
        try (Socket socket = new Socket(lHost, port)) {

            BufferedReader client = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToClient = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoS, response;
            do {
                System.out.println("Please enter a mathematical equation for calculation: ");
                echoS = scanner.nextLine(); //echoS = typed text into console
                stringToClient.println(echoS);

                if (!echoS.equals("exit")) {
                    response = client.readLine();
                    System.out.println(response);
                    System.out.println("Connection stopped");
                }
                break;
            } while (!echoS.equals("exit")); //if echo form the server is not EXIT, loop works

        } catch (IOException e) {
            System.out.println("Error - Client not connected: " + e.getMessage());
        }
    }
}
