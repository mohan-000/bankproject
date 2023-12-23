package com.bankproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/sign")
public class Login extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String acc=req.getParameter("a");
	int acc1=Integer.parseInt(acc);
	String cname=req.getParameter("n");
	String phonenumber=req.getParameter("p");
	int pn=Integer.parseInt(phonenumber);
	String balance=req.getParameter("b");
	int b=Integer.parseInt(balance);
	String pin=req.getParameter("i");
	int v=Integer.parseInt(pin);

	String Query="INSERT INTO CUSTOMER WHERE(?,?,?,?,?)"; 
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer?"+"user=root&password=simmy");
		PreparedStatement pre=con.prepareStatement(Query);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the account number");
		int ac=sc.nextInt();
		pre=setInt(1,ac);
		System.out.println("enter name");
		String n=sc.next();
		pre=setString(2,n);
		System.out.println("phone number");
		int p=sc.nextInt();
		pre=setInt(3,p);
		System.out.println("balance");
		int ba=sc.nextInt();
		pre=setInt(4,ba);
		System.out.println("pin");
		int pi=sc.nextInt();
		pre=setInt(5,pi);
		if(pre==true) {
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
		}
			else if (condition) {
				
			
				resp.sendRedirect("forgot.jsp");

			}
			 else if () {
							resp.sendRedirect("login.jsp");

			}
			
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

private PreparedStatement setString(int i, String n) {
	// TODO Auto-generated method stub
	return null;
}

private PreparedStatement setInt(int i, int ac) {
	// TODO Auto-generated method stub
	return null;
}
}
