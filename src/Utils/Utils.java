package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
//        return Arrays.stream(Arrays.copyOfRange(numbers,0, search(numbers, 0))).average().getAsDouble();
        return Arrays.stream(numbers).filter(n -> n != 0).average().getAsDouble();
    }


    /**
     * helper function to serch an element in array
     * @param array
     * @param element
     * @return the index of element if exists else the size of array
     */
    public static int search(double[] array, double element){

        for (int index = 0; index < array.length; index++)
            if (array[index] == element)
                return index;

       return array.length;
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
     * helper function to clear console
     * @throws IOException must be catch
     */
    public static void clear() throws IOException {
        Runtime.getRuntime().exec((System.getProperty("os.name").contains("Windows")) ? "cls" : "clear");
    }


}

