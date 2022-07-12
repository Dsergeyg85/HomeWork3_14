import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8089;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            //out.println("GET / HTTP/1.1\n" + "Host: " + host);
            out.println(String.format("Hi, server: \"%s\" on port: \"%x\"", host, port));
            System.out.println(in.readLine());

            BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

            out.println(reader.readLine());
            System.out.println(in.readLine());

            out.println(reader.readLine());
            System.out.println(in.readLine());
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
