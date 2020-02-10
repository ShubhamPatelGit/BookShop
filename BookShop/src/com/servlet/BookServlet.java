package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BookDao;
import com.pojos.BookPojo;


//@WebServlet("/Books")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ArrayList<Integer> id = new ArrayList();
	static ArrayList<String> name = new ArrayList();
	static ArrayList<String> author = new ArrayList();
	static ArrayList<Integer> price = new ArrayList();
	static ArrayList<Integer> quantity = new ArrayList();
	static ArrayList<String> course = new ArrayList();
	
	public void bookList(ArrayList<BookPojo> books) {
		id.clear();
		name.clear();
		author.clear();
		price.clear();
		quantity.clear();
		course.clear();
		for(BookPojo book: books){
			id.add(book.getbId());
			name.add(book.getbName());
			author.add(book.getbAuthor());
			price.add(book.getbPrice());
			quantity.add(book.getbQuantity());
			course.add(book.getbCourse());
		}
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bd = new BookDao();
		
		try {
			String request_type = request.getParameter("request");
			if (request_type.equals("upload")) {
				BookPojo book = new BookPojo();
				int bId = bd.maxid();
				if(bId > 0)
				{
					
					book.setbId(bId);
					
					String name = request.getParameter("bName");
					book.setbName(name);
					String bAuthor = request.getParameter("bAuthor");
					book.setbAuthor(bAuthor);
					int bPrice = Integer.parseInt(request.getParameter("bPrice"));
					book.setbPrice(bPrice);
					int bQuantity = Integer.parseInt(request.getParameter("quantity"));
					book.setbQuantity(bQuantity);
					String bCourse = request.getParameter("course");
					book.setbCourse(bCourse);
					
					bd.upload(book);
					response.sendRedirect("UploadBook.jsp?msg=Book is uploaded Successfully");
				}
				
			}
			else if(request_type.equals("delete")) {
				
				int id = Integer.parseInt(request.getParameter("bId"));

				bd.delete(id);
				response.sendRedirect("DeleteBook.jsp?msg=Book is Deleted Successfully");
			}
			else if(request_type.equals("edit")) {
				BookPojo book = new BookPojo();
				
				int bId = Integer.parseInt(request.getParameter("bId"));
				book = bd.edit(bId);
				
				if(book.getbId() == 0) {
					response.sendRedirect("EditBook.jsp?msg=Book is not found");
				}
				else {
					HttpSession session = request.getSession();
					session.setAttribute("id", book.getbId());
					session.setAttribute("name", book.getbName());
					session.setAttribute("author", book.getbAuthor());
					session.setAttribute("price", book.getbPrice());
					session.setAttribute("quantity", book.getbQuantity());
					session.setAttribute("course", book.getbCourse());
					response.sendRedirect("EditBookPage.jsp?msg=Book found");
					
				}
				
			}
			else if (request_type.equals("editBook")) {
				BookPojo book = new BookPojo();
				
				int bId = Integer.parseInt(request.getParameter("bId"));
				book.setbId(bId);
				String name = request.getParameter("bName");
				book.setbName(name);
				String bAuthor = request.getParameter("bAuthor");
				book.setbAuthor(bAuthor);
				int bPrice = Integer.parseInt(request.getParameter("bPrice"));
				book.setbPrice(bPrice);
				int bQuantity = Integer.parseInt(request.getParameter("quantity"));
				book.setbQuantity(bQuantity);
				String bCourse = request.getParameter("course");
				book.setbCourse(bCourse);
				
				bd.editBook(book);
				response.sendRedirect("EditBook.jsp?msg=Book is Updated Successfully");
				
			}
			else if(request_type.equals("purchase")) {
				BookPojo book = new BookPojo();
				
				int id = Integer.parseInt(request.getParameter("bId"));
				int quantity = Integer.parseInt(request.getParameter("quantity"));

				book = bd.purchase(id, quantity);
				if(book.getbId() == 0) {
					response.sendRedirect("PurchaseBook.jsp?msg=Not Enough Books are avilable");
				}
				else {
					bd.purchaseConfirm(id, book.getbQuantity()-quantity);
					int totalCost = quantity * book.getbPrice();
					HttpSession session = request.getSession();
					session.setAttribute("total", totalCost);
					session.setAttribute("id", book.getbId());
					session.setAttribute("name", book.getbName());
					session.setAttribute("author", book.getbAuthor());
					session.setAttribute("price", book.getbPrice());
					session.setAttribute("quantity", book.getbQuantity());
					session.setAttribute("course", book.getbCourse());
					response.sendRedirect("Purchased.jsp?msg=purchase successful ");
					
				}
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
