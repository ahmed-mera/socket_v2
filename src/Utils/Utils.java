package Utils;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;


/**
 * class utils to help us for doing some operation without declare the new object.
 * @author Ahmed Mera
 */
@SuppressWarnings("all")
public final class Utils {
    /**
     * un metodo per leggere la data che il server che ci ha inviato
     * @param socket {@link Socket}
     * @return String {@link String}
     * see {@link Socket}, {@link String}
     * @throws IOException genera una eccezione del tipo comunicativo
     */
    public static String readData(Socket socket) throws IOException {
        return (new BufferedReader( new InputStreamReader( socket.getInputStream() ))).readLine();
    }


    /**
     * un metodo per mandare la data al server
     * @param socket {@link Socket}
     * @param data {@link String}
     * see {@link Socket}, {@link String}
     * @throws IOException genera una eccezione del tipo comunicativo
     */
    public static void sendData(Socket socket, String data) throws IOException {
        (new PrintWriter( socket.getOutputStream(), true)).println(data);
    }


    /**
     * function to avg
     * @param numbers arrays of numbers
     * @return avg
     */
    public static double avg(double... numbers){
        return Arrays.stream(numbers).filter(n -> n != 0).average().getAsDouble();
    }


    /**
     * funzione per togliere gli spazi e creare un array di numeri ,
     * @param value type {@link String}
     * @return un array di numeri
     */
    public static double[] split(String value){
        return Arrays.stream(value.split("\\s+")).mapToDouble(Double::parseDouble).toArray();
    }


    /**
     * function to check condition to exit
     * @param input string input to check condition to exit
     * @return boolean value
     */
    public static boolean checkCondition(String input){
        return (Arrays.stream(split(input)).anyMatch(n -> n == 0));
    }


    /**
     * function to execute class Utils
     * @throws IOException genera una eccezione del tipo comunicativo
     */
    public static void executeUtils(){
        try{ if (!(System.getProperty("os.name").contains("Windows"))) Runtime.getRuntime().exec("chmod +x out/production/utils.sh");
            Process p = Runtime.getRuntime().exec((System.getProperty("os.name").contains("Windows")) ?  "out/production/utils.bat" : "out/production/utils.sh");
        }catch(IOException e){ };
    }


    /**
     * helper function to clear console
     * @throws IOException must be catch
     */
    public static void clear() throws IOException {
        Runtime.getRuntime().exec((System.getProperty("os.name").contains("Windows")) ? "cls" : "clear");
    }


}

