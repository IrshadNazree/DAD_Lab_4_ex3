import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class ClientCount {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a word");
		String wordEntered = scn.nextLine();
		try {
			Socket sc = new Socket(InetAddress.getLocalHost(),4228);
			
			PrintWriter pw = new PrintWriter(sc.getOutputStream());
			pw.println(wordEntered);
			pw.flush();
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			
			int wordCount = Integer.parseInt(bf.readLine());
			System.out.println(wordCount);
			
			bf.close();
			pw.close();
			sc.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
