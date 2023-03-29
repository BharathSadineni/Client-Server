import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    //declare variables
    //Constructor
    Socket socket;
    int counter;
    Database database;

    public ClientHandler(Socket clientSocket, int count, Database db) {
        socket = clientSocket;
        counter = count;
        database = db;
    }


    public void run() {
        try {
            System.out.println("ClientHandler started...");
            /*Create I/O streams to read/write data, PrintWriter and BufferedReader
            Receive messages from the client and send replies, until the user types "stop"*/
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(socket.getOutputStream(), true);
            String clientMessage;
            while (!(clientMessage = inFromClient.readLine()).equals("stop")) {
                /*Request the number of titles from the db
                Send reply to Client:*/
                System.out.println("Client sent the artist name " + clientMessage);
                int titlesNum = database.getTitles(clientMessage);
                outToClient.println("Number of titles: " + titlesNum + " records found");
            }
            outToClient.println(clientMessage);
            System.out.println("Client " + counter + " has disconnected");


            //Close I/O streams and socket
            inFromClient.close();
            outToClient.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
