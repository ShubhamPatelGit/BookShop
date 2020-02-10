package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BookDao;
import com.pojos.BookPojo;

@WebServlet("/Edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bd = new BookDao();
		
		try {
			String request_type = request.getParameter("request");
			if(request_type.equals("edit")) {
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
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
