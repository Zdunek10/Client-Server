import sun.plugin.cache.OldCacheEntry;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //  SERVER  //
    public static void main(String[] args) {
        Main main = new Main();
        main.ClientServConnection();
    }

    int port = 4321;

    private void ClientServConnection() {
        //server socket waits for request to come in over the network
        //server listening on port 5000
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            //https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String echoString = input.readLine();
                //output.println("Echo from the server: " + echoString);

                try {
                    ScriptEngineManager mgr = new ScriptEngineManager();
                    ScriptEngine engine = mgr.getEngineByName("JavaScript");
                    //engine.eval(echoString);
                    System.out.println("Requestet task to calculate: " + echoString);
                    System.out.println("Result: " + engine.eval(echoString));
                    output.println("The result of requested mathematic task '" +
                            echoString + "' is: " +
                            engine.eval(echoString));

                } catch (ScriptException e) {
                    e.printStackTrace();
                }
                if (echoString.equals("exit")) { //if message sent from Client is EXIT, connection is stopped
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

