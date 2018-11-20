
package ICTRT_Automation;
	import java.io.BufferedWriter;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.Scanner;



public class Initial_Data {
	

	
	private String username,pwd,server,browser;

	public void ReadUserInfo() {
	System.out.println("User Name: ");
	Scanner scan = new Scanner(System.in);
	username = scan.nextLine();
	System.out.println("Password: ");
	pwd = scan.nextLine();
	System.out.println("Browser: \n 1.-Chrome \n 2.-Firefox \n");
	browser = scan.nextLine();
	}
	public void SaveUserInfo() throws IOException {
	PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Carlosja\\Documents\\Eclipse\\ICTRT\\src\\credentials.txt"));
	writer.println(username);
	writer.println(pwd);
	writer.println(browser);
	writer.close();
	}
	public static void main(String[] args) throws InterruptedException, IOException {
	Initial_Data str = new Initial_Data();
	str.ReadUserInfo();
	str.SaveUserInfo();

	

	}




}
