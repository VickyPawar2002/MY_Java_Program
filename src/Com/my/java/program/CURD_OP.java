package Com.my.java.program;
import java.sql.*;
import java.util.Scanner;
public class CURD_OP {
	static final String db="jdbc:mysql://localhost:3306/db02";
	static final String user= "root";
	static final String password ="mysql@123";
	static final String Driver = "com.mysql.cj.jdbc.Driver";
	
	int rollno;
	String name;
	int marks;
	

	Scanner sc= new Scanner(System.in);
 
	
	void Add() {
	try {
		System.out.println("enter the roll Number ");
		rollno = sc.nextInt();
		System.out.println("enter the name ");
		name= sc.next();
		System.out.println("enter the marks ");
		marks= sc.nextInt();
		Class.forName(Driver);
		Connection con= DriverManager.getConnection(db,user,password);
		PreparedStatement stat =con.prepareStatement("INSERT INTO student VALUES(?,?,?)");
		stat.setInt(1, rollno);
		stat.setString(2, name);
		stat.setInt(3, marks);
			stat.executeUpdate();
			 System.out.println(" record Insert Done ");
			 stat.close();

			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
 void delete()
 {
	 try {
			System.out.println("enter the roll Number ");
			rollno = sc.nextInt();
			Class.forName(Driver);
			Connection con= DriverManager.getConnection(db,user,password);
			PreparedStatement stat =con.prepareStatement("Delete from student where roll=?");
			stat.setInt(1, rollno);
				stat.executeUpdate();
				 System.out.println(" record Delete  Done ");
				 stat.close();	
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
 }
	
	void update()
	{
		try {
			System.out.println("enter the new name  ");
			name=sc.next();
			System.out.println("enter the marks ");
			marks=sc.nextInt();
			System.out.println("enter the roll number do you have update ");
			rollno =sc.nextInt();
			Class.forName(Driver);
			Connection con= DriverManager.getConnection(db,user,password);
			PreparedStatement stat =con.prepareStatement("UPDATE student SET name=?, marks=? where roll =?");
			stat.setString(1,name );
			stat.setInt(2, marks);
			stat.setInt(3, rollno);
				stat.executeUpdate();
				 System.out.println(" record update Done ");
				 stat.close();	
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
	}
	
	void Retrive()
	{
		
		try {
			
			Class.forName(Driver);
			Connection con= DriverManager.getConnection(db,user,password);
			Statement stat =con.createStatement();
			ResultSet rs =stat.executeQuery("SELECT * FROM student");
			 	
			while (rs.next())
			{
				System.out.println(rs.getInt(1)+ " " +rs.getString(2) +" "+ rs.getInt(3));
			}
				 stat.close();	
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	
	
	
	public static void main(String[] args) {
	
		CURD_OP co = new CURD_OP();
		
		while (true) {
		
		System.out.println("Enter the chocice /n Add /n update /n delete /n retrive /n Exit ");
		String choice= new java.util.Scanner(System.in).next();
		
		if(choice.equals("Exit")) {
			System.out.println("Exiting system ");
			break;
		}
		
		
		switch(choice)
		{
		case "Add": co.Add();
				break;
		case "Update" : co.update();
				break;
		case "Delete" : co.delete();
				break;
		case "Retrive": co.Retrive();
				break;
		default : System.out.println("not currect choice");
		
		}
		}
	}

}
