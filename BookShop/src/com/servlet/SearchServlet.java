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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao da = new BookDao();
		try {
			String type = request.getParameter("type");
			String value = request.getParameter("value");
			ArrayList<BookPojo> books = da.search(type, value);
			
			ArrayList<Integer> id = new ArrayList<>();
			ArrayList<String> name = new ArrayList<>();
			ArrayList<String> author = new ArrayList<>();
			ArrayList<Integer> price = new ArrayList<>();
			ArrayList<Integer> quantity = new ArrayList<>();
			ArrayList<String> course = new ArrayList<>();
			
			for(BookPojo book: books) {
				id.add(book.getbId());
				name.add(book.getbName());
				author.add(book.getbAuthor());
				price.add(book.getbPrice());
				quantity.add(book.getbQuantity());
				course.add(book.getbCourse());
				
				//System.out.println(book.getbId()+"  "+book.getbName());
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("sid", id);
			session.setAttribute("sname", name);
			session.setAttribute("sauthor", author);
			session.setAttribute("sprice", price);
			session.setAttribute("squantity", quantity);
			session.setAttribute("scourse", course);
			response.sendRedirect("ViewBooks.jsp?msg=Searched books are: ");
            	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
