package Client;

import Utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * questa class serve per la gestione del client
 * @author Ahmed Mera
 */

@SuppressWarnings("all")
public class Client {


    public Client() throws IOException {
        System.out.println("\n\t\t\t\t\t\t\t\t\tType any number between them one space and (0) to Exit like that (2 3 4 5)\n\n");
    }


    /**
     * un metodo per creare la socket che a noi serve per la connessione
     * @return {@link Socket}
     * see {@link Socket}
     * @throws IOException genera una eccezione del tipo comunicativo <b>( nel caso se ci sono problemi su il livello di rete)</b>
     */
    public Socket getSocket() throws IOException {
        return new Socket("localhost", 2020);
    }


    /**
     * il nostro metodo principale per la gestione del tutto <b>( mandare/ricevere dati al/dal server ) </b>
     * @param socket {@link Socket}
     * @throws IOException genera una eccezione del tipo comunicativo
     */
    public void startClient(Socket socket) throws IOException {


        while (true){
            Utils.clear();
            System.out.print("Enter numbers :_ ");
            String input = (new BufferedReader( new InputStreamReader( System.in ))).readLine();

            Utils.sendData(socket, input);

            System.out.println("Avg = " + Utils.readData(socket));

            if(Utils.checkCondition(input)){
                socket.close();
                System.out.println( "Connection closed");
                return;
            }
        }
    }


    public static void main(String... args) throws IOException {
        Client client = new Client();
        client.startClient(client.getSocket());
    }

}
