import java.net.*;
import java.io.*;

public class Server {
    static ServerSocket serverSocket1 = null;
    static ServerSocket serverSocket2 = null;
    static Socket socket1 = null;
    static Socket socket2 = null;
    static DataOutputStream dataOutputStream1 = null;
    static DataOutputStream dataOutputStream2 = null;
    static DataInputStream dataInputStream1 = null;
    static DataInputStream dataInputStream2 = null;

    public static void main(String[] args) throws IOException {
        Integer PORT1 = 12099;
        Integer PORT2 = 22099;

        serverSocket1 = new ServerSocket(PORT1);
        serverSocket2 = new ServerSocket(PORT2);

        socket1 = serverSocket1.accept();
        socket2 = serverSocket2.accept();

        dataInputStream1 = new DataInputStream(socket1.getInputStream());
        String name = dataInputStream1.readUTF();

        dataOutputStream1 = new DataOutputStream(socket1.getOutputStream());
        dataOutputStream1.writeUTF("Server 1 : Server recieved");
        
        System.out.println(name);
        
        dataInputStream2 = new DataInputStream(socket2.getInputStream());
        Integer birth = dataInputStream2.readInt();
        birth = birth - 543;
        dataOutputStream2 = new DataOutputStream(socket2.getOutputStream());
        dataOutputStream2.writeInt(birth);

        dataInputStream2 = new DataInputStream(socket2.getInputStream());
        String messege = dataInputStream2.readUTF();
        System.out.println(messege);

        dataInputStream1.close();
        dataInputStream2.close();
        dataOutputStream1.close();
        dataOutputStream2.close();
        socket1.close();
        socket2.close();
    }
}