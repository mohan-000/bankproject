package com.bankproject;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")

public class Loginvalidation extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String i=req.getParameter("i");
		int id=Integer.parseInt(i);
		
		String password=req.getParameter("p");
		
		try
		{
		String QUERY="SELECT * FROM EMPLOYEE WHERE ID=? AND PASSWORD=?";
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"+"user=root&password=simmy");
		PreparedStatement pre=con.prepareStatement(QUERY);
		
		pre.setInt(1,id);
		pre.setString(2, password);
		
		ResultSet re=pre.executeQuery();
		if(re.next()==true) 
		{
			String name=re.getString(2);
			
			req.setAttribute("name", name);
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
			rd.forward(req, resp);
		}
		else 
		{
			resp.sendRedirect("Login.jsp");
		
		}

} 
catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
