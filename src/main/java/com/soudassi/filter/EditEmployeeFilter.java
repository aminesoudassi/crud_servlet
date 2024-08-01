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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@WebFilter("/editEmployee2")
public class EditEmployeeFilter extends HttpFilter implements Filter {
       
   
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        if( name !="" && password !="" && email!="")
        	chain.doFilter(request, response);
        else {
        	response.setContentType("text/html");  
        	PrintWriter pw = response.getWriter();
        	pw.println("<h3 style='color:red;'> You must not update your info with empty values</h3>");
        	
        	// Changing the request method to GET method is just because the method that we are filtering is a POST method
        	// and i want to send it to a GET method
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletRequestWrapper wrappedRequest = new HttpServletRequestWrapper(httpRequest) {
                @Override
                public String getMethod() {
                    return "GET";
                }
            };
            wrappedRequest.getRequestDispatcher("editEmployee").include(wrappedRequest, response);
        	
        	pw.close();
        }
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
