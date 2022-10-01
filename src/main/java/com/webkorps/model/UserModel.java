package com.webkorps.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.webkorps.entity.User;
import com.webkorps.util.DataBaseUtil;
import com.webkorps.util.EmailUtil;


public class UserModel 
{
  public boolean registerUser(User user) 
  {
	  Boolean flag=false;
	  Connection con=DataBaseUtil.getConnection();
	  PreparedStatement ps;
	  try {
		ps=con.prepareStatement("INSERT INTO user (name, email, role, password)"+"VALUES(?, ?, ?, ?)");
		ps.setString(1,user.getName());
		ps.setString(2,user.getEmail());
		ps.setString(3,user.getRole());
		ps.setString(4,user.getPassword());
		int row=ps.executeUpdate();
		if(row>0) {
			flag=true;
			EmailUtil.sendMail(user.getEmail(),"Hello "+user.getName()+" you registered succesfully on onlineBookStore.");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	  return flag;
  }
  
  public User loginUser(String email,String pwd) {
	  User user=null;
	  Connection con=DataBaseUtil.getConnection();
	  PreparedStatement ps;
	  try {
		ps=con.prepareStatement("select *from user where email=? and password=?");
		ps.setString(1,email);
		ps.setString(2,pwd);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			user=new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setRole(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setCity(rs.getString(6));
			user.setState(rs.getString(7));
			user.setPincode(rs.getString(8));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return user;
  }
  
}
