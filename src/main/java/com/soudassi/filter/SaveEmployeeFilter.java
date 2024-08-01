package com.soudassi.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/saveEmployee")
public class SaveEmployeeFilter extends HttpFilter implements Filter {
    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");
        if( name !="" && password !="" && email!="")
        	chain.doFilter(request, response);
        else {
        	PrintWriter pw = response.getWriter();
        	pw.println("<h3 style='color:red;'> You must fill all infos</h3>");
        	request.getRequestDispatcher("index.html").include(request, response);
        	
        	pw.close();
        }
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
