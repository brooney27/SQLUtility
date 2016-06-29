import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import DBUtility.DBUtility;

public class SQLQuery {
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("Enter user name");
			String user = in.nextLine();
			System.out.println("Enter password");
			String pw = in.nextLine();
			if(user.equals("ora1")&&pw.equals("ora1"))break;
			System.out.println("Incorrect login");
		}
		System.out.println("Login successful");
		
		System.out.println("Enter SQL Query");
		String query = in.nextLine();
		//String query = "select * from testtable";
		String output = DBUtility.printQuery(query);
		String header = DBUtility.printQueryHead(query,10);
		System.out.println("Press 1 to print in terminal, 2 to save to text file");
		int choice = in.nextInt();
		in.nextLine();
		if(choice==1)System.out.println(header);
		if(choice==2||!output.equals(header)){
		Boolean APPEND = false;
			try {
				File file = new File("myquery.txt");

				file.createNewFile();

				FileWriter fwr = new FileWriter(file, APPEND);
				BufferedWriter bwr = new BufferedWriter(fwr); 
				
				bwr.write(output);
				System.out.println("Query saved to myquery.txt");
			    bwr.flush();
			    bwr.close();
			} catch(IOException e) {
				e.getMessage();
			}
		}
	}
}
