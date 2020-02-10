package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;
import com.pojos.BookPojo;

@WebServlet("/Upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bd = new BookDao();
		try {
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
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
