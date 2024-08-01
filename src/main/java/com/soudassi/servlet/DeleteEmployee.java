package com.soudassi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soudassi.dao.EmployeeDao;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/deleteEmployee")
public class DeleteEmployee extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		String page=request.getParameter("page");
	    int id=Integer.parseInt(sid);  
	    EmployeeDao.delete(id);  
	    response.sendRedirect("viewEmployees?page="+page); 
	}



}
