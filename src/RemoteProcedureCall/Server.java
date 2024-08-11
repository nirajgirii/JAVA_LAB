package RemoteProcedureCall;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(3000)) {
            System.out.println("RemoteProcedureCall.Server is listening on port 3000");

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("RemoteProcedureCall.Client connected");

                    InputStream inputStream = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                    OutputStream outputStream = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(outputStream, true);

                    String clientName;

                    while ((clientName = reader.readLine()) != null) {
                        System.out.println("Received: " + clientName);

                        // Acknowledge receipt
                        writer.println("Name received by RemoteProcedureCall.Server ");
                        System.out.println("-----------------------------------------");

                    }
                } catch (IOException e) {
                    System.out.println("Error in client communication: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("RemoteProcedureCall.Server error: " + e.getMessage());
        }
    }
}
