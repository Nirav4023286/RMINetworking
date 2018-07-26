import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server1 {
	public static void main(String[] args) {
		try {
			Scanner cin=new Scanner(System.in);
			System.out.println("Waiting for connection");
			ServerSocket ss = new ServerSocket(12121);
			Socket socket = ss.accept();
			System.out.println("[SERVER]: Server started, connection established!!!");
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			String msg=null;
			do
			{
				msg = dis.readUTF();
				System.out.println("[Client]: " + msg );

				System.out.printf("%10s","[Me    ]: ");
				msg = cin.nextLine();
				dos.writeUTF( msg );

			}while( !msg.equals("bye") );



		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
