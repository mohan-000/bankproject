package com.bankproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/deposit")

public class Deposit extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=req.getParameter("i");
		int acc1=Integer.parseInt(id);
		
		String password=req.getParameter("p");
		int acc=Integer.parseInt(password);
		
		String deposit=req.getParameter("o");
		int ac=Integer.parseInt(deposit);
		
		PrintWriter out=resp.getWriter();
		
		String Query="UPDATE CUSTOMER SET BALANCE=BALANCE+? WHERE ACCNO=? AND PIN=?"; 
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK?"+"user=root&password=simmy");
				PreparedStatement pre=con.prepareStatement(Query);
				pre.setInt(1, ac);
				pre.setInt(2, acc1);
				pre.setInt(3,acc );
				int k=pre.executeUpdate();
				if(k>0) {
					out.println("<html><body><center><br>"+"your deposite amount is below here"+deposit+" your amount is sucesfully deposit"+"</center></body></html>");
				}
				else {
					resp.sendRedirect("deposit.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}

}
