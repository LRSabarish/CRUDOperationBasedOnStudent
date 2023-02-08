package com.techpalle;
import java.sql.*;
public class A {
	Connection con=null;
	Statement s=null;
	PreparedStatement ps=null;
	public static String url="jdbc:mysql://localhost:3306/jdbc1";
	public static String username="root";
	public static String password="sabarish";
	
	public void Creating() {
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		s=con.createStatement();
		String qry="create table empl (eid int primary key auto_increment, "
				+ "ename varchar(40) not null,esal int,email varchar(80) unique";
		s.executeUpdate(qry);
		s.close();
		con.close();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void inserting(String name,int esal,String email) throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(url,username,password);
	ps=con.prepareStatement("insert into empl(ename,esal,email) values (?,?,?)");
	ps.setString(1, name);
	ps.setInt(2, esal);
	ps.setString(3, email);
	ps.executeUpdate();
	
	ps.close();
	con.close();
	
}}


