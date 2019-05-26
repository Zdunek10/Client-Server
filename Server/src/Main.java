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
        main.ServConnection();
    }

    int port = 4321;

    private void ServConnection() {
        //server socket waits for request to come in over the network
        //server listening on port 4321
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


/* Lukasz,

         W temacie zadania, o którym wspominałem.

Proszę o napisanie aplikacji klient oraz server:
        - jezyk java lub python
        - architektura klient/server
        - aplikacja klient
            aplikacja klient pyta uzytkownika o wyrażenie algebraiczne np. 2+2
            aplikacja klient wysyla polecenie do servera: 2+2
            aplikacja server oblicza i zwraca wartość 4 do klienta
        - aplikacja server
            aplikacja klient wyswietla wartosc
            komunikacja po IP
                dla uproszczenia 1 zapytanie na raz
            odbiera zapytanie
            oblicza wartośćzwraca
            obliczona wartość do klienta
            wspierane są podstawowe operacje algebraiczne + nawiasy (kilka zagłębień)
                 np.
                 1 + 2
                 2 + 2) * 2
                 ((((2 + 2) * 2) + 2) * 2)
                 1.0 / 2
Jak zrobisz to daj znac, możemy się spotkać i zobaczyć jak sobie poradziles.
To nie jest trywialne zadanie, możesz zdecydować się na*/


