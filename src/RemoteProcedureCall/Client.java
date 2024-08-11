package RemoteProcedureCall;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000);
            BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true); // Auto-flush enabled
            InputStream inputStream = socket.getInputStream();
            BufferedReader recieveReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("RemoteProcedureCall.Client ready and Connected.....");
            String receiveMessage, sendMessage;

            while (true) {
                System.out.print("Enter your Name: ");
                sendMessage = keyReader.readLine();
                writer.println(sendMessage);

                // Receiving and printing the server's responses
                System.out.println("-----------------------------------------");
                receiveMessage = recieveReader.readLine();
                System.out.println(receiveMessage);

            }

        } catch (SocketException e) {
            System.out.println("Error(Socket): " + e.getMessage());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
