import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.jdbc.CallableStatement;


public class Student {

	public void studentNormal(boolean val)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/university","root",""); 
		
		try{  
		 
		//here sonoo is database name, root is username and password  
		 
	
		
		  Statement stmt=con.createStatement();
		  
			con.setAutoCommit(val);
			String name="Maryam";
			String n;
			String addr="House no 4 Street no 103 G-13/1 Islamabad";
			Random rand = new Random();
            int rs=0;
			int  sem = rand.nextInt(7) + 1;
			
			long start = System.currentTimeMillis();
             for(int i=0;i<5000;i++)
			{
				n=name+i;
				
				 rs= stmt.executeUpdate("INSERT INTO Student(RegNo,Name,Address,Semester) VALUES ("+i+",'"+n+"','"+addr+"',"+sem+")");
				
				
				

		      
			}
			long end = System.currentTimeMillis();
			System.out.println("time"+(start-end));
			
			if(val==false)
			{
			 con.commit();
			}
			
			stmt.executeUpdate("TRUNCATE STUDENT");
		
		
		}catch(Exception e){ System.out.println(e);}  
		 
	}
	
	
	catch(Exception e){ System.out.println(e);}  
}
	public void studentPrepare(boolean val)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/university","root",""); 
		
		try{  
		 
		//here sonoo is database name, root is username and password  
		 
	
		
		  Statement stmt=con.createStatement();
			con.setAutoCommit(val);
			String name="Maryam";
			String n;
			String addr="House no 4 Street no 103 G-13/1 Islamabad";
			Random rand = new Random();
            int rs=0;
			int  sem = rand.nextInt(7) + 1;
			
			long start = System.currentTimeMillis();
             for(int i=0;i<5000;i++)
			{
				n=name+i;
				
				 String query = " insert into Student (RegNo,Name,Address,Semester)"
     	    	        + " values (?, ?, ?,?)";
     	      PreparedStatement preparedStmt = con.prepareStatement(query);
     	      
					preparedStmt.setInt (1, i);
					preparedStmt.setString (2, name);
					preparedStmt.setString (3, addr);
					preparedStmt.setInt(4, sem);
				    preparedStmt.executeUpdate();
				
				
				

		      
			}
			long end = System.currentTimeMillis();
			System.out.println("time"+(start-end));
			
			
			
			
		if(val==false)
		{
			
			con.commit();
		}
		
		stmt.executeUpdate("TRUNCATE STUDENT");
		}catch(Exception e){ System.out.println(e);}  
		 
	}
	
	
	catch(Exception e){ System.out.println(e);} 
	}
	
	public void studentBatchProcess(boolean val)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/university","root",""); 
		
		try{  
		 
		//here sonoo is database name, root is username and password  
		 
	
		
		  Statement stmt=con.createStatement();
			con.setAutoCommit(val);
			String name="Maryam";
			String n;
			String addr="House no 4 Street no 103 G-13/1 Islamabad";
			Random rand = new Random();
            int rs=0;
			int  sem = rand.nextInt(7) + 1;
			
			long start = System.currentTimeMillis();
             for(int i=0;i<5000;i++)
			{
				n=name+i;
				
				 String query = "INSERT INTO Student(RegNo,Name,Address,Semester) VALUES ("+i+",'"+n+"','"+addr+"',"+sem+")";
     	    	        
     	      stmt.addBatch(query);
				
				
				

		      
			}
             stmt.executeBatch();

			long end = System.currentTimeMillis();
			System.out.println("time"+(end-start));
			
			if(val==false)
			{
				con.commit();
			}
			
			stmt.executeUpdate("TRUNCATE STUDENT");
			
			
		
		
		}catch(Exception e){ System.out.println(e);}  
		 
	}
	
	
	catch(Exception e){ System.out.println(e);} 
	}
	
	
	
	public void studentStoredProcedure(boolean val)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/university","root",""); 
		
		try{  
		 
		//here sonoo is database name, root is username and password  
		 
	
		
		  Statement stmt=con.createStatement();
			con.setAutoCommit(val);
			String name="Maryam";
			String n;
			String addr="House no 4 Street no 103 G-13/1 Islamabad";
			Random rand = new Random();
           
			int  sem = rand.nextInt(7) + 1;
			
			long start = System.currentTimeMillis();
             for(int i=0;i<5000;i++)
			{
            	 java.sql.CallableStatement cStmt = con.prepareCall("{call StudentRecord(?, ?,?,?)}");
                 cStmt.setInt(1, i);
                 cStmt.setString(1, name);
                 cStmt.setString(1, addr);
                 cStmt.setInt(1, sem);
				
				

		      
			}
           

			long end = System.currentTimeMillis();
			System.out.println("time"+(end-start));
			
			if(val==false)
			{
				con.commit();
			}
			
			stmt.executeUpdate("TRUNCATE STUDENT");
			
			
		
		
		}catch(Exception e){ System.out.println(e);}  
		 
	}
	
	
	catch(Exception e){ System.out.println(e);} 
	}
	
	public static void main(String args[]){  
		
		
		Student sd=new Student();
		//sd.studentNormal(false);
		//sd.studentNormal(true);
		//sd.studentPrepare(false);
		//sd.studentPrepare(true);
		//sd.studentBatchProcess(true);
		//sd.studentBatchProcess(false);
		sd.studentStoredProcedure(true);
		sd.studentStoredProcedure(false);
}
}
