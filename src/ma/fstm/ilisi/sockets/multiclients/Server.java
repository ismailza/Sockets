package ma.fstm.ilisi.sockets.multiclients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable {
    /**
     * Socket pour gérer la communication avec un client spécifique.
     */
    private Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    /**
     * Traite les messages reçus d'un client et envoie des réponses.
     * Lit un message du client, affiche ce message, et permet à l'opérateur du serveur d'entrer une réponse.
     * Si le message reçu est "exit", envoie "Goodbye!" au client et termine la connexion.
     *
     * @return false si le client envoie "exit", signalant la fin de la session client; true sinon.
     * @throws Exception pour gérer les erreurs d'entrée/sortie.
     */
    public boolean handleClient() throws Exception {
        // Créer un BufferedReader pour lire les messages du client.
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        // Créer un PrintWriter pour envoyer des messages au client.
        PrintWriter out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()), true);
        // Lire un message du client.
        String message = in.readLine();
        System.out.println("Reçu du client: " + message);

        // Vérifier si le message est "exit".
        if (message == null || message.equalsIgnoreCase("exit")) {
            out.println("Goodbye!");
            return false;
        }

        // Envoyer une réponse au client.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer un message: ");
        String response = scanner.nextLine();
        out.println(response);

        System.out.println("Réponse envoyée au client.");
        return true;
    }

    @Override
    public void run() {
        try {
            // Boucle tant que le client est connecté.
            while (handleClient());
            // Fermer le socket une fois que le client se déconnecte.
            this.socket.close();
            System.out.println("Client déconnecté !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        // Créer un ServerSocket écoutant sur le port 6666.
        ServerSocket serverSocket = new ServerSocket(6666);

        while (true) {
            System.out.println("Attendre la connexion d’un client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connecté!");

            // Démarrer un nouveau thread pour gérer la communication avec le client connecté.
            new Thread(new Server(socket)).start();
        }
    }

}
