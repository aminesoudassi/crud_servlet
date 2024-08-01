package com.soudassi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soudassi.bean.Employee;
import com.soudassi.dao.EmployeeDao;


/**
 * Servlet implementation class EditEmployee
 */
@WebServlet("/editEmployee")
public class EditEmployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>");  
        String sid=request.getParameter("id"); 
        String page=request.getParameter("page");
        int id=Integer.parseInt(sid);  
          
        Employee e=EmployeeDao.getEmployeeById(id);  
          
        out.print("<form action='editEmployee2' method='post'>");  
        out.print("<table>");
        out.print("<tr>"
        		+ "<td></td>"
        		+ "<td><input type='hidden' name='page' value='"+page+"'/></td>"
        		+ "</tr>");
        out.print("<tr>"
        		+ "<td></td>"
        		+ "<td><input type='hidden' name='id' value='"+e.getId()+"'/></td>"
        		+ "</tr>");
        
        out.print("<tr>"
        		+ "<td>Name:</td>"
        		+ "<td><input type='text' name='name' value='"+e.getName()+"'/></td>"
        		+ "</tr>");  
        
        out.print("<tr>"
        		+ "<td>Password:</td>"
        		+ "<td><input type='password' name='password' value='"+e.getPassword()+"'/></td>"
        		+ "</tr>");  
        out.print("<tr>"
        		+ "<td>Email:</td>"
        		+ "<td><input type='email' name='email' value='"+e.getEmail()+"'/></td>"
        				+ "</tr>");  
        out.print("<tr>"
        		+ "<td>Country:</td>"
        		+ "<td><select name='country' style='width:100px'>"
	        		+ "<option>Morocco</option>"
	        		+ "<option>France</option>"
	        		+ "<option>Other</option>"
	        	+ "</select></td>"
        		+ "</tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
	}

	

}
