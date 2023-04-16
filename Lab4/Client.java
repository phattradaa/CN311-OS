import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    static DataOutputStream dataOutputStream1 = null;
    static DataOutputStream dataOutputStream2 = null;
    static DataOutputStream dataOutputStream3 = null;
    static DataInputStream dataInputStream1 = null;
    static DataInputStream dataInputStream2 = null;
    public static void main(String[] args) throws IOException {
        String HOST = "localhost";
        Integer PORT1 = 12099;
        Integer PORT2 = 22099;

        Socket socket1 = new Socket(HOST, PORT1);
        Socket socket2 = new Socket(HOST, PORT2);

        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your fullname: ");
        String name = input.nextLine();
        System.out.println("Please Enter your birth date(DDMMYYYY): ");
        Integer birth = input.nextInt();
        
        dataOutputStream1 = new DataOutputStream(socket1.getOutputStream());
        dataOutputStream1.writeUTF("Client: " + name);

        dataInputStream1 = new DataInputStream(socket1.getInputStream());
        String messege = dataInputStream1.readUTF();
        System.out.println(messege);

        dataOutputStream2 = new DataOutputStream(socket2.getOutputStream());
        dataOutputStream2.writeInt(birth);

        dataInputStream2 = new DataInputStream(socket2.getInputStream());
        Integer ans = dataInputStream2.readInt();
        System.out.println("Server2 : " + ans);

        dataOutputStream3 = new DataOutputStream(socket2.getOutputStream());
        dataOutputStream3.writeUTF("Client : Bye");

        dataInputStream1.close();
        dataInputStream2.close();
        dataOutputStream1.close();
        dataOutputStream2.close();
        dataOutputStream3.close();
        socket1.close();
        socket2.close();
    }
}