import java.io.*;
import java.net.*;

public class Client {

    public static void main(String args[]) throws IOException {

        //*Open a connection to the server, create the client socket
        String artistName, serverMessage;
        Socket clientSocket = new Socket("127.0.0.1", 80);
        System.out.println("Client is running");
        //Create I/O streams to read/write data, PrintWriter and BufferedReader
        PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader inFromServer = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        // Read messages continuously until the user types "stop"
        while (true) {
            System.out.println("Enter the artist name:");
            artistName = inFromUser.readLine();
            /*Send message to the server
           Receive response from the server*/
            System.out.println("You entered " + artistName);
            outToServer.println(artistName);
            serverMessage = inFromServer.readLine();
            if (!artistName.equals("stop"))
                System.out.println("FROM SERVER: " + serverMessage);
            if (artistName.equals("stop")){
                System.out.println("FROM SERVER: Connection closed, Goodbye!");
                break;}
            //Close I/O streams and socket
        }
        inFromServer.close();
        inFromUser.close();
        outToServer.close();
        clientSocket.close();
}}
