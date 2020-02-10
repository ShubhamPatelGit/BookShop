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

@WebServlet("/Purchase")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao bd = new BookDao();
		
		try {
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
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
