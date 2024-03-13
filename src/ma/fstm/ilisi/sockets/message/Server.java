package ma.fstm.ilisi.sockets.message;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("Attendre la connexion d’un client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connecté!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        System.out.println("En attente d'une requette du client...");
        String message = in.readLine();
        System.out.println("Reçu du client: " + message);

        String response = "Bien reçu!";

        System.out.println("Envoi de la réponse: " + response);
        out.println(response);
        System.out.println("Réponse envoyée!");
        socket.close();
    }

}
