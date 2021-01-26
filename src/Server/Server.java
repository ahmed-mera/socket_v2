package Server;

import Utils.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;


/**
 * questa class serve per la gestione del server
 * @author Ahmed Mera
 */

@SuppressWarnings("all")

public class Server {

    private final int port = 2020;


    /**
     * un metodo per creare la socket che a noi serve per la connessione
     * @return {@link Socket}
     * see {@link Socket}
     * @throws IOException genera una eccezione del tipo comunicativo <b>( nel caso se ci sono problemi su il livello di rete)</b>
     */
    public Socket getServerSocket() throws IOException {
        return (new ServerSocket(port)).accept();
    }


    /**
     * constructore to instance Utils
     */
    public Server() throws IOException {
        System.out.println("\t Server Started \n");
    }

    /**
     * il nostro metodo principale per la gestione del tutto <b>( mandare/ricevere dati al/dal client ) </b>
     * @param socket {@link Socket}
     * @throws IOException genera una eccezione del tipo comunicativo
     */
    public  void startServer(Socket socket) throws IOException {
        System.out.println("new connection " + socket.toString());

        while (true){
            String data = Utils.readData(socket);

            System.out.println("Client : " +  Arrays.toString(Utils.split(data)));

            Utils.sendData(socket, Double.toString(Utils.avg( Utils.split(data))));

            if(Utils.checkCondition(data)){
                socket.close();
                System.out.println( "Connection closed");
                return;
            }
        }
    }

    /**
     * metodo che restuisce la port del server sul quale rimane in ascolto
     * @return int
     */
    public int getPort() { return port; }


    public static void main(String... args) throws IOException, NullPointerException {
        Server server = new Server();
        System.out.println("Server Listen on Port : " + server.getPort());
        server.startServer(server.getServerSocket());
    }


}
