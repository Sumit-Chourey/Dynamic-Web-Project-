package com.dynamo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.DriverConnectionFactory;

/**
 * Servlet implementation class InsertInfo
 */
@WebServlet("/InsertInfo")
public class InsertInfo extends HttpServlet
{
	//Adding information of user
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("welcome to page.... ");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		//taking response in text and html format
		String id=request.getParameter("userId");
		//converting integer type to string   
		int id1=Integer.parseInt(id);
		String name =request.getParameter("userName");
		String city= request.getParameter("userCity");
		
		//for database connection, jdbc steps
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashtcs","root","8446103055");
			String query="insert into dynamo values(?,?,?)";
			PreparedStatement pst= con.prepareStatement(query);
			
			pst.setInt(1, id1);
			pst.setString(2, name);
			pst.setString(3, city);
			
			//for debugging
			int i= pst.executeUpdate();
			out.print("<h1>"+i+"<h1>");
			
		} catch (ClassNotFoundException e) {
			out.print(e);
			} catch (SQLException e) {
				out.print(e);
		}
		
		
	}

}
