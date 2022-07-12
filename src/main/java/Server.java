import jdk.net.Sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8089;
        try (ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("New connection accepted");
            String message = in.readLine();
            System.out.println(message);
            out.println("Write your name");
            String name = in.readLine();
            out.println("Are you child? (yes/no)");
            String answer = in.readLine();
            switch (answer) {
                case "yes":
                    out.println(String.format("Welcome to the kids area, %s Let's play!", name));
                    break;
                case "no":
                    out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
