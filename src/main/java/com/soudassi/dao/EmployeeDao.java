package com.soudassi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.soudassi.bean.Employee;

public class EmployeeDao {

	public static int MaxIdEmployee=0;
	
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_servlet","root","");
        }catch(Exception e){
        	System.out.println(e);
        	}  
        return con;  
    }
	
	public static void getMaxId() {
	        try{  
	            Connection con = EmployeeDao.getConnection();  
	            PreparedStatement ps = con.prepareStatement("select nvl(max(id),0)+1 from employee");   
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	            	MaxIdEmployee=rs.getInt(1);    
	            }  
	            con.close();
	            ps.close();
	        }catch(Exception ex){ex.printStackTrace();}  
	}
	
	public static int save(Employee employee){  
        int status=0;
        getMaxId();
        try{  
            Connection con = EmployeeDao.getConnection();
            
            PreparedStatement ps =
            		con.prepareStatement("insert into employee(id,name,password,email,country) values (?,?,?,?,?)");
            
            ps.setInt(1, MaxIdEmployee);
            ps.setString(2,employee.getName());  
            ps.setString(3,employee.getPassword());  
            ps.setString(4,employee.getEmail());  
            ps.setString(5,employee.getCountry());  
              
            status=ps.executeUpdate();  
              
            con.close();
            ps.close();
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
}
