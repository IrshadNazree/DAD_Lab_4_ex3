import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCountApplication {
	public static void main(String[] args) throws IOException {
		System.out.println("server started");
		ServerSocket ssc = new ServerSocket(4228);
	
		try {
			Socket sc = ssc.accept();
			System.out.println("client connected");
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			
			String txt = bf.readLine();
			PrintWriter pw = new PrintWriter(sc.getOutputStream());
			
			pw.println(txt.length());
			pw.flush();
			
		} catch (IOException e) {
			if (ssc != null) {
				ssc.close();
			}
			e.printStackTrace();
		}	
	}
}
