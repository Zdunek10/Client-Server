import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        try(Socket socket = new Socket("localhost" , 5000)) {

            BufferedReader client = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoS;
            String response;



        }
        catch (IOException e){
            System.out.println("Error - Client not connected");
        }
    }
}
