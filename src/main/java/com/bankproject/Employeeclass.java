package com.bankproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class Employeeclass
{
 public static void employeeLogin()
 {
 Scanner sc=new Scanner(System.in);
 boolean login=false;
 int attempts=0;
 System.out.println("<---Employee Interface--->");
 System.out.println("Welcome to New bank");
 while(!login&&attempts<=0)
 {
 System.out.println("Enter the Employee ID:");
 int id=sc.nextInt();
 System.out.println("Enter the Password:");
 String pwd=sc.next();


 if (loginValidation(id,pwd))
 {
 System.out.println("Login successful!");
login=true;
 }
 else
 {
 attempts++;
System.out.println("Login failed. Please retry.");
 }
 }
 if (attempts>=0)
 {
 System.out.println("Max login attempts reached. Exiting.");
 return;
 }
//after the validation
 System.out.println("Select an option:");
 System.out.println("1. Add a customer data");
 System.out.println(". Update a customer data");
 System.out.println(". Delete customer data");
 System.out.println(". View customer details");
 System.out.println(". Go Back to Main Menu");
 int choice = sc.nextInt();
 switch (choice) {
 case 1:
 addNewCustomer();
 break;
 case 2:
 updateCustomer();
 break;
 case 3:
 deleteCustomer();
 break;
 case 4:
 viewCustomerData();
 break;
 case 5:
 System.out.println("Returning to main menu.");
 break;
 default:
 System.out.println("Invalid choice");
 }
 }



 private static void viewCustomerData() {
 Scanner sc=new Scanner(System.in);
 Connection con=null;
 PreparedStatement ps=null;
 ResultSet rs=null;
 String ViewData="SELECT * FROM CUSTOMER WHERE ACCNO=?";
 try {
 Class.forName("com.mysql.cj.jdbc.Driver");

 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college?user=root&password=simmy");
 ps=con.prepareStatement(ViewData);
 System.out.println("Enter the account number: ");
 int accno=sc.nextInt();
 ps.setInt(1, accno);
 rs=ps.executeQuery();
 if(rs.next())
 {
 String name=rs.getString(accno);
long phone=rs.getLong(accno);
String mail=rs.getString(accno);
double bal=rs.getDouble(accno);
 System.out.println("The account holder name is"+name);
 System.out.println("The phone number is "+phone);
 System.out.println("The mail ID is "+mail);
System.out.println("The account balance is Rs."+bal);
 }
 else {
 System.out.println("Invalid account number");
return;
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();



 }
 finally
 {
 try
 {
 if(rs!=null)rs.close();
if(ps!=null)ps.close();
if(con!=null)con.close();
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 }

 }
 private static void deleteCustomer() {
 Scanner sc=new Scanner(System.in);
 Connection con=null;
 PreparedStatement ps=null;
 String Dquery="DELETE FROM CUSTOMER WHERE ACCNO=?";
 try {
 Class.forName("com.mysql.cj.jdbc.Driver");

 con=DriverManager.getConnection("jdbc:mysql://localhost:0/bank?user=root&password=simmy");
 ps=con.prepareStatement(Dquery);
 System.out.println("Enter the account number: ");
 int accno=sc.nextInt();
 ps.setInt(1,accno);
 System.out.println("Do you like to delete the data of"+accno+"?");
 System.out.println("Press yes to delete.");
 System.out.println("Press any other key to main menu");
 String option=sc.next();
 if(option.equalsIgnoreCase("yes"))
 {
 ps.executeUpdate();
 System.out.println("Data deleted successfully");
 }
 else {
 System.out.println("Returning to main menu..!");
return;
 }
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 finally



 {
 try
 {
 if(ps!=null)ps .close();
 if(con!=null)con.close();
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 }

 }
 private static void updateCustomer()
 {
 Scanner sc=new Scanner(System.in);
 Connection con=null;
 PreparedStatement ps=null;
 String Uquery="UPDATE CUSTOMER SET NAME=?,PHONE=?,EMAIL=? WHEREACCNO=?";
 try {
 Class.forName("com.mysql.cj.jdbc.Driver");

 con=DriverManager.getConnection("jdbc:mysql://localhost:0/bank?user=root&password=simmy");
 ps=con.prepareStatement(Uquery);
 System.out.println("Enter the name to be updated: ");
 String name=sc.next();
 ps.setString(1,name);
 System.out.println("Enter the phone number to be updated:");
 long phone=sc.nextLong();
 ps.setLong( 1, phone);
 System.out.println("Enter the mail ID to be updated: ");
 String mail=sc.next();
 ps.setString(2, mail);
 System.out.println("Enter the account number: ");
 int accno=sc.nextInt();
 ps.setInt( 3, accno);
 int update=ps.executeUpdate();
 if(update>0)
 {
 System.out.println("Data updated successfully");
 }
 else
 {
 System.out.println("Failed to update the data");
 }

 } catch (ClassNotFoundException | SQLException e) {



 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 finally
 {
 try
 {
 if(ps!=null)ps.close();
if(con!=null)con.close();
 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
 }

 }
 //insert the customer data
 private static void addNewCustomer()
 {
 Scanner sc=new Scanner(System.in);
 Connection con=null;
 PreparedStatement ps=null;
 String iQry="INSERT INTOCUSTOMER(NAME,PHONE,EMAIL)VALUES(?,?,?)";
 try
 {
 Class.forName("com.mysql.cj.jdbc.Driver");

 con=DriverManager.getConnection("jdbc:mysql://localhost:0/bank?"
 + "user=root&password=simmy");
 ps=con.prepareStatement(iQry);
 System.out.println("Enter the Customer name: ");
 String name=sc.next();
 ps.setString(1, name);
 System.out.println("Enter the Customer Phone number: ");
 long phone=sc.nextLong();
 ps.setLong(1, phone);
 System.out.println("Enter the Customer mail ID: ");
 String email=sc.next();
 ps.setString(2, email);
 System.out.println("Data added successfully");
 ps.executeUpdate();
 } 
 catch (ClassNotFoundException | SQLException |NoSuchElementException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }finally
 {
 if(ps!=null)
 {
 try {
 ps.close();
 } catch (SQLException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 }
 if(con!=null)
 {
 try {
 con.close();
 } catch (SQLException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 }
 }
 }
 public static boolean loginValidation(int id, String pwd) {
 Scanner sc=new Scanner(System.in);
 Connection con=null;
 PreparedStatement ps1=null;
 ResultSet rs1=null;
 String eVal="SELECT * FROM EMP WHERE EID=? AND PASSWORD=?";
 try {
 Class.forName("com.mysql.cj.jdbc.Driver");

 con=DriverManager.getConnection("jdbc:mysql://localhost:0/bank?"
 + "user=root&password=simmy");
 ps1=con.prepareStatement(eVal);
 ps1.setInt(1, id);
 ps1.setString(2, pwd);
 rs1=ps1.executeQuery();
 if(rs1.next())
 {
 String name=rs1.getString(id);
 System.out.println("Welcome back "+name+",");
return true;
 }
 else
 {
 System.out.println("Invalid Employee Id or password.Please try again!!");
 }
 } 
 catch (ClassNotFoundException | SQLException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 finally
 {
 try {
 if(rs1!=null)rs1.close();
if(ps1!=null)ps1.close();
if(con!=null)con.close();
 }
 catch (SQLException e)
 {
 e.printStackTrace();
 }
 }
 return false;
 }
} 