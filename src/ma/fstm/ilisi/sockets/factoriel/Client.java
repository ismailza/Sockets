package ma.fstm.ilisi.sockets.factoriel;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("Connexion au serveur...");
        Socket socket = new Socket("localhost", 6666);
        System.out.println("Connecté au serveur !");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un numéro pour calculer sa factorielle: ");
        int nb = scanner.nextInt();
        System.out.println("Envoyer une requete: " + nb + " au serveur...");
        outputStream.write(nb);
        System.out.println("En attente de la réponse du serveur...");
        int result = inputStream.read();
        System.out.println("Réponse reçue: " + result);
    }

}
