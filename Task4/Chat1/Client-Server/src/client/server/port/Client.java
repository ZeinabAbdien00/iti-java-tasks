package client.server.port;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);
            InetAddress ip = InetAddress.getByName("DESKTOP-7328NV3");
            Socket socket;
            socket = new Socket(ip, 5056);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            while (true) {
                System.out.println(dis.readUTF());
                String toSend = scanner.nextLine();
                dos.writeUTF(toSend);

                if (toSend.equals("Exit")) {
                    System.out.println("Closing this connection : " + socket);
                    socket.close();
                    System.out.println("Connection closed");
                    break;
                }

                String received = dis.readUTF();
                System.out.println(received);
            }
            scanner.close();
            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
