package ma.fstm.ilisi.sockets.factoriel;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("Attendre la connexion d’un client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connecté!");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("En attente d'une requette du client...");
        int nb = inputStream.read();
        System.out.println("Requette reçue: " + nb);
        System.out.println("Calculer la factorielle de " + nb + "...");
        int result = 1;
        for (int i = 1; i <= nb; i++) {
            result *= i;
        }
        System.out.println("Envoi de la réponse: " + result);
        outputStream.write(result);
        System.out.println("Réponse envoyée!");
        socket.close();
    }

}
