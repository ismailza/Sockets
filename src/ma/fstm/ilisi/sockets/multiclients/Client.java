package ma.fstm.ilisi.sockets.multiclients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("Connexion au serveur...");
        Socket socket = new Socket("localhost", 6666);
        System.out.println("Connecté au serveur !");

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Scanner scanner = new Scanner(System.in);
        String message;
        do {
            System.out.println("Entrer un message:");
            message = scanner.nextLine();

            System.out.println("Envoyer une requete: '" + message + "' au serveur...");
            out.println(message);

            System.out.println("En attente de la réponse du serveur...");
            String response = in.readLine();

            System.out.println("Réponse de serveur: " + response);

        } while (message != null && !message.equalsIgnoreCase("exit"));
        socket.close();
    }
}
