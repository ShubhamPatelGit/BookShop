package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.pojos.BookPojo;
import com.sql.SQLConnection;


public class BookDao {
	
	public int maxid() throws Exception{
		Connection con = null;
		try {
			con = SQLConnection.connect();
			PreparedStatement ps = con.prepareStatement("select max(id) from books");
			ResultSet rs = ps.executeQuery();
			
			if(!rs.next())
				return 1;
			//rs.next();
			int max = Integer.parseInt(rs.getString(1));
			return max+1;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.close();
		}
	}
	
	public void upload(BookPojo book) throws Exception{
		Connection con = null;
		try {
			con = SQLConnection.connect();
			PreparedStatement ps = con.prepareStatement("insert into books values(?,?,?,?,?,?)");
			ps.setInt(1, book.getbId());
			ps.setString(2, book.getbName());
			ps.setString(3, book.getbAuthor());
			ps.setInt(4, book.getbPrice());
			ps.setInt(5, book.getbQuantity());
			ps.setString(6, book.getbCourse());
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.close();
		}
	}
	
	public BookPojo edit(int id)throws Exception{
		Connection con = null;
		try {
			con = SQLConnection.connect();
			PreparedStatement ps = con.prepareStatement("select * from books where id= "+id);
			ResultSet rs = ps.executeQuery();
			BookPojo book = new BookPojo();
			if(!rs.next())
				book.setbId(0);
			else {
				book.setbId(Integer.parseInt(rs.getString(1)));
				book.setbName(rs.getString(2));
				book.setbAuthor(rs.getString(3));
				book.setbPrice(Integer.parseInt(rs.getString(4)));
				book.setbQuantity(Integer.parseInt(rs.getString(5)));
				book.setbCourse(rs.getString(6));
			}
			return book;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.close();
		}
	}
	
	public void editBook(BookPojo book) throws Exception{
		Connection con = null;
		try {
			con = SQLConnection.connect();
			PreparedStatement ps = con.prepareStatement("update books set name=?, author=?, price=?, quantity=?, course=? where id=?");
			ps.setInt(6, book.getbId());
			ps.setString(1, book.getbName());
			ps.setString(2, book.getbAuthor());
			ps.setInt(3, book.getbPrice());
			ps.setInt(4, book.getbQuantity());
			ps.setString(5, book.getbCourse());
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.close();
		}
	}
	
	public void delete(int id) throws Exception{
		Connection con = null;
		try {
			con = SQLConnection.connect();
			PreparedStatement ps = con.prepareStatement("delete from books where id="+id);
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.close();
		}
	}
	
	public BookPojo purchase(int id, int quantity) throws Exception{
		Connection con = null;
		try {
			con = SQLConnection.connect();
			PreparedStatement ps = con.prepareStatement("select * from books where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			BookPojo book = new BookPojo();
			rs.next();
			book.setbId(Integer.parseInt(rs.getString(1)));
			book.setbName(rs.getString(2));
			book.setbAuthor(rs.getString(3));
			book.setbPrice(Integer.parseInt(rs.getString(4)));
			book.setbQuantity(Integer.parseInt(rs.getString(5)));
			if(book.getbQuantity() < quantity)
				book.setbId(0);
			book.setbCourse(rs.getString(6));

			return book;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.close();
		}
	}
	
	public void purchaseConfirm(int id, int quantity) throws Exception{
		Connection con = null;
		try {
			con = SQLConnection.connect();
			PreparedStatement ps = con.prepareStatement("update books set quantity =? where id=?");
			ps.setInt(2, id);
			ps.setInt(1, quantity);
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.close();
		}
	}
	
	public ArrayList<BookPojo> search(String type, String value) throws Exception{
        Connection con = null;
        try {	
            con = SQLConnection.connect();
            PreparedStatement ps = null;
            ArrayList<BookPojo> books = new ArrayList<>();
            if(type.equals("id")) {
            	ps = con.prepareStatement("select * from books where id=?");
                ps.setString(1, value);
            }
            else if(type.equals("title")) {
            	ps = con.prepareStatement("select * from books where name=?");
                ps.setString(1, value);
            }
            else if(type.equals("author")) {
            	ps = con.prepareStatement("select * from books where author=?");
                ps.setString(1, value);
            }
            else if(type.equals("price")) {
            	ps = con.prepareStatement("select * from books where price=?");
                ps.setString(1, value);
            }
            else if(type.equals("quantity")) {
            	ps = con.prepareStatement("select * from books where quantity=?");
                ps.setString(1, value);
            }
            else if(type.equals("courses")) {
            	ps = con.prepareStatement("select * from books where course=?");
                ps.setString(1, value);
            }
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	BookPojo book = new BookPojo();
            	book.setbId(rs.getInt(1));
            	book.setbName(rs.getString(2));
            	book.setbAuthor(rs.getString(3));
            	book.setbPrice(rs.getInt(4));
            	book.setbQuantity(rs.getInt(5));
            	book.setbCourse(rs.getString(6));
            	books.add(book);
            }
            return books;      

        } catch (Exception e) {
                e.printStackTrace();
                throw e;
        } finally {
                con.close();
        }
	}
	
	public ArrayList <BookPojo> allBooks() throws Exception{
		Connection con = null;
		try {
			ArrayList <BookPojo> list = new ArrayList<>();
			con = SQLConnection.connect();
			PreparedStatement ps = con.prepareStatement("select * from books");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				BookPojo book = new BookPojo();
				book.setbId(Integer.parseInt(rs.getString(1)));
				book.setbName(rs.getString(2));
				book.setbAuthor(rs.getString(3));
				book.setbPrice(Integer.parseInt(rs.getString(4)));
				book.setbQuantity(Integer.parseInt(rs.getString(5)));
				book.setbCourse(rs.getString(6));
				
				list.add(book);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			con.close();
		}
	}
	
}
