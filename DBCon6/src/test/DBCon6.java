package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DBCon6 {
	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:PLSExtProc","scott","tiger");
			PreparedStatement ps=con.prepareStatement("insert into User27(?,?,?,?,?,?,?)");
			Scanner s=new Scanner(System.in);
			
			System.out.println("enter the user name");
			ps.setString(1,s.nextLine());
			
			System.out.println("enter the password");
			ps.setString(2,s.nextLine());
			
			System.out.println("enter the first Name");
			ps.setString(3,s.nextLine());
			
			System.out.println("enter the Last Name");
			ps.setString(4,s.nextLine());
			
			System.out.println("enter the Address");
			ps.setString(5,s.nextLine());
			
			System.out.println("enter the Mobile Number");
			ps.setLong(6,Long.parseLong(s.nextLine()));
			
			System.out.println("enter the emailId");
			ps.setString(7,s.nextLine());
		
			
			int k=ps.executeUpdate();
			if(k>0)
			{
				System.out.println("Registration is sucessfully.....");
			}
			s.close();
			con.close();
		}
		catch(ClassNotFoundException | SQLException ob)
		{
			ob.printStackTrace();
		
			
		
			
		}
		
	}

}
