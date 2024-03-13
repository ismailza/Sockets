package ma.fstm.ilisi.sockets.compte;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Connexion au serveur...");
        Socket socket = new Socket("localhost", 6666);
        System.out.println("Connecté au serveur !");

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        System.out.println("En attente d'un compte du serveur...");
        Compte compte = (Compte) objectInputStream.readObject();

        System.out.println("Compte reçu: " + compte);
        socket.close();
    }
}
