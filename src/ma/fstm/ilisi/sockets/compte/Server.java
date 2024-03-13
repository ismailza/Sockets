package ma.fstm.ilisi.sockets.compte;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("Attendre la connexion d’un client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connecté!");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

        System.out.println("En attente d'une requette du client...");
        Compte compte = new Compte("Ismail", "ZAHIR", "ismailza407@gmail.com");
        System.out.println("Envoyer le compte: " + compte + " au client");

        objectOutputStream.writeObject(compte);
        System.out.println("Compte envoyé!");
        socket.close();
    }
}
