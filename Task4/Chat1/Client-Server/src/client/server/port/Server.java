package client.server.port;

import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5056);
        while (true) {
            Socket socket = null;

            try {
                socket = ss.accept();
                System.out.println("A new client is connected : " + socket);
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                System.out.println("Assigning new thread for this client");
                Thread clientHandler = new ClientHandler(socket, dis, dos);
                clientHandler.start();
            } catch (Exception e) {
                socket.close();
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread {
    DateFormat dayFormatted = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat timeFormatted = new SimpleDateFormat("hh:mm:ss");
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket socket;

    public ClientHandler(Socket socket, DataInputStream dis, DataOutputStream dos) {
        this.socket = socket;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String received;
        String toreturn;
        while (true) {
            try {

                dos.writeUTF("What do you want?[Date | Time]..\n" +
                        "Type Exit to terminate connection.");

                received = dis.readUTF();

                if (received.equals("Exit")) {
                    System.out.println("client.server.port.Client " + this.socket + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.socket.close();
                    System.out.println("Connection closed");
                    break;
                }
                Date date = new Date();
                switch (received) {
                    case "Date" -> {
                        toreturn = dayFormatted.format(date);
                        dos.writeUTF(toreturn);
                    }
                    case "Time" -> {
                        toreturn = timeFormatted.format(date);
                        dos.writeUTF(toreturn);
                    }
                    default -> dos.writeUTF("Invalid input");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            this.dis.close();
            this.dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
