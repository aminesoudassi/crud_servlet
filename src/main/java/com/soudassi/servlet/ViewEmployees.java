package com.soudassi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.soudassi.bean.Employee;
import com.soudassi.dao.EmployeeDao;

@WebServlet("/viewEmployees")
public class ViewEmployees extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        String spageid=request.getParameter("page");
        int pageid=Integer.parseInt(spageid); 
        int total=5; 
        if(pageid != 1)            
             pageid=(pageid - 1) * total + 1;  
        
        out.println("<a href='index.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<Employee> list=EmployeeDao.getAllEmployees(pageid,total);  
        out.print("<h1>Page No: "+spageid+"</h1>"); 
        out.print("<table border='1' cellpadding='4' width='100%'>");   
        out.print("<tr>"
        		+ "<th>Id</th>"
        		+ "<th>Name</th>"
        		+ "<th>Password</th>"
        		+ "<th>Email</th>"
        		+ "<th>Country</th>"
        		+ "<th>Edit</th>"
        		+ "<th>Delete</th>"
        		+ "</tr>");
        
        for(Employee e:list){  
         out.print("<tr>"
         		+ "<td>"+e.getId()+"</td>"
         		+ "<td>"+e.getName()+"</td>"
         		+ "<td>"+e.getPassword()+"</td>"
         		+ "<td>"+e.getEmail()+"</td>"
         		+ "<td>"+e.getCountry()+"</td>"
         		+ "<td><a href='editEmployee?page="+spageid+"&id="+e.getId()+"'>edit</a></td>"  
                + "<td><a href='deleteEmployee?page="+spageid+"&id="+e.getId()+"'>delete</a></td>"
                + "</tr>");  
        }  
        out.print("</table>");  
        EmployeeDao.getMaxId();
        int pageCount = (int) Math.ceil((double) EmployeeDao.MaxIdEmployee / total);
        for (int i = 1; i <= pageCount; i++) {
            out.print("<a href='viewEmployees?page=" + i + "'>" + i + "</a> ");
        }  
        out.close();  
	}

}
