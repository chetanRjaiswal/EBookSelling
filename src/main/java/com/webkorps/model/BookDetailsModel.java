package com.webkorps.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webkorps.entity.BookDetails;
import com.webkorps.util.DataBaseUtil;
import com.webkorps.util.EmailUtil;


public class BookDetailsModel {
	static Connection con=DataBaseUtil.getConnection();
	static boolean flag=false;
	static PreparedStatement ps;
	public boolean addBook(BookDetails book) 
	{
		  try {
			ps=con.prepareStatement("INSERT INTO book_details (bookName,author,price,img,pdf,email)"+"VALUES(?, ?, ?,?,?,?)");
			ps.setString(1,book.getBookName());
			ps.setString(2,book.getAuthor());
			ps.setString(3,book.getPrice());
			ps.setString(4,book.getImg());
			ps.setString(5,book.getPdf());
			ps.setString(6,book.getEmail());
			//int row= ps.execute()
			int row=ps.executeUpdate();
			if(row>0) {
				flag=true;
				//EmailUtil.sendMail(user.getEmail(),user.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return flag;
	  }
	
	public List<BookDetails> getAllBooks(){
		List<BookDetails> bookList=new ArrayList<BookDetails>();
		BookDetails book;
		try {
		   ps=con.prepareStatement("select * from book_details ");
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()) {
			   book=new BookDetails();
			   book.setbId(rs.getInt(1));
			   book.setBookName(rs.getString(2));
			   book.setAuthor(rs.getString(3));
			   book.setPrice(rs.getString(4));
			   book.setImg(rs.getString(5));
			   book.setPdf(rs.getString(6));
			   book.setEmail(rs.getString(7));
			   bookList.add(book);
		   }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
	
	public BookDetails getBookById(Integer id) 
	{
		BookDetails b=null;
		try {
		    ps=con.prepareStatement("select * from book_details where bId=?");
			ps.setInt(1,id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				b=new BookDetails();
				b.setbId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
			    b.setImg(rs.getString(5));
			    b.setPdf(rs.getString(6));
				b.setEmail(rs.getString(7));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
   public Boolean updateBookById(Integer id,BookDetails book)
   {
		  try {
			ps=con.prepareStatement("update book_details set bookName=?,author=?,price=? where bId=?");
//			ps=con.prepareStatement("update book_details set bookName=?,author=?,price=?,img=?,pdf=? where bId=?");
			ps.setString(1,book.getBookName());
			ps.setString(2,book.getAuthor());
			ps.setString(3,book.getPrice());
//			ps.setString(4,book.getImg());
//			ps.setString(5,book.getPdf());
			ps.setInt(4,id);
			int row=ps.executeUpdate();
			if(row>0) {
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return flag;
	
   }
   
   public Boolean deleteBookById(Integer id)
   {
	   try
	   {
		  ps=con.prepareStatement("DELETE FROM book_details WHERE bId =?");
		  ps.setInt(1, id);
		  int row=ps.executeUpdate();
		  if(row>0) {
			  flag=true;
		  }
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return flag;
   }
   
   public List<BookDetails> getSearchBook(String bookName) {
	   BookDetails b=null;
	   List<BookDetails> bookList=new ArrayList<>();
		try {
			
			//PreparedStatement ps=con.prepareStatement("select * from book_details where bookName=?");
			bookName = bookName
				    .replace("!", "!!")
				    .replace("%", "!%")
				    .replace("_", "!_")
				    .replace("[", "![");
				 ps = con.prepareStatement(
				        "SELECT * FROM book_details WHERE bookName LIKE ? ESCAPE '!'");
				ps.setString(1, "%"+ bookName + "%");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				b=new BookDetails();
				b.setbId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
			    b.setImg(rs.getString(5));
			    b.setPdf(rs.getString(6));
				b.setEmail(rs.getString(7));
				bookList.add(b);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	
   }
	
   public Boolean buyBooks(String userEmail,Integer bId)
   {
	
	 try {
		 BookDetails book=getBookById(bId);
	     ps=con.prepareStatement("INSERT INTO orderedbooks (bookName,author,price,img,pdf,userEmail)"+"VALUES(?, ?, ?, ?,?,?)");
	     ps.setString(1, book.getBookName());
	     ps.setString(2, book.getAuthor());
	     ps.setString(3, book.getPrice());
	     ps.setString(4, book.getImg());
	     ps.setString(5, book.getPdf());
	     ps.setString(6, userEmail); 
	    int row = ps.executeUpdate();
	    if(row>0) {
	    	flag=true;
	    	EmailUtil.sendMail(userEmail,"Book Buyed Successfully");
	    }
	} catch (Exception e) {
		 e.printStackTrace();
	} 
	 return flag;
  }
   
   public List<BookDetails> getBuyedBooks(String userEmail){
	   List<BookDetails> bookList=new ArrayList<BookDetails>();
		BookDetails book;
		try {
		   Connection con= DataBaseUtil.getConnection();
		   ps=con.prepareStatement("select * from orderedbooks where userEmail=?");
		   ps.setString(1, userEmail);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()) {
			   book=new BookDetails();
			   book.setbId(rs.getInt(1));
			   book.setBookName(rs.getString(2));
			   book.setAuthor(rs.getString(3));
			   book.setPrice(rs.getString(4));
			   book.setImg(rs.getString(5));
			   book.setPdf(rs.getString(6));

			   bookList.add(book);
		   }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
   }
   
}

