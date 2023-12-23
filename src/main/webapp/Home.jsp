<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
		background-image: url("image/baj.png.avif");
		}
		form{
			border:10px,none,black;
			padding:10px;
			margin:20px;
		}
		</style>
</head>
<body>

<%
	String name=(String)request.getAttribute("name");
	if(name==null)
	{
		response.sendRedirect("Login.jsp");
	}
	else
	{
		out.println("<html><body><center>"
				+"<h1> Welcome To bank details "+ "</br>"+ "account name :"+name  
		+ "</br>"+"<a href=# >home"+"</br>"+
				"<a href='' >add customer account"+"</br>"+
		"<a href='balance.jsp' >check balance"+"</br>"+
				"<a href='deposit.jsp' >deposit"+"</br>"+
						"<a href=# >with draw"+"</br>"+
								"<a href='transfer.jsp' >transfer amount"+"</br>"+
										"<a href=# >delete account"+"</br>"+
												"<a href='password.jsp' >change password"+"</br>"+
														"<a href=# >all coustomers data"+"</br>"+
																"<a href=# >update customer data"+"</br>"+
																		"<a href=# >logout"+"</br>"+
				"</center></body></html>");
	}
%>

</body>
</html>