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


@WebServlet("/editEmployee2")
public class EditEmployee2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);
        String page=request.getParameter("page");
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");  
          
        Employee e=new Employee();  
        e.setId(id);  
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country);  
          
        int status=EmployeeDao.update(e);  
        if(status>0){  
            response.sendRedirect("viewEmployees?page="+page);  
        }else{  
            out.println("<p style=color:red;>Sorry! unable to update record</p>");  
        }  
          
        out.close();
	}

}
