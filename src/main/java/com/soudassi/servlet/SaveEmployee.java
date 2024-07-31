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

@WebServlet("/saveEmployee")
public class SaveEmployee extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");
        
        Employee e=new Employee();  
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country);  
          
        int status=EmployeeDao.save(e);  
        
        if(status>0){  
        	
            out.print("<p style=color:green;>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
            
        }else{  
        	
            out.println("<p style=color:red;>Sorry! unable to save record</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        }  
          
        out.close(); 
	}

}
