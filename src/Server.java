import java.io.*;
import java.net.*;

public class Server {

    public static void main(String args[]) throws IOException {
        //*Open the server socket
        ServerSocket serverSocket = new ServerSocket(80);
        System.out.println("Server is running");
        int count = 0;

        //Create a Database object and check the connection with establishDBConnection():
        Database db = new Database();
        boolean check = db.establishDBConnection();
        //If the db connection fails, print:
        if (check)
            System.out.println("DB connection fail, stopping.");
        else if (!check)
            System.out.println("Server is now connected to DB");

        /*Continuously listen for client requests
                 Accept new connection and create the client socket
                  Increment clientId. The clientId is not reassigned once used.
                  Display clientId and IP address:
                  System.out.println("Client " + clientId + " connected with IP " + clientSocket.getInetAddress().getHostAddress());
                  Create a new client handler object and start the thread*/
        while (true) {
            Socket clientSocket = serverSocket.accept();
            count++;
            System.out.println("Client " + count + " connected with IP " + clientSocket.getInetAddress().getHostAddress());
            ClientHandler clientHandler = new ClientHandler(clientSocket, count, db);
            new Thread(clientHandler).start();
        }

    }
}

