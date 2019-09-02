package com.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.Address;
import com.banking.Bank;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Bank theBank = null;
		try {
			theBank = Bank.load();
			System.out.println(theBank.getUsers()[0].getFirstName());
		} catch (Exception e) {
			theBank = new Bank();
			System.out.println(e.getMessage());
		}
		User user = theBank.getRealUser((User)session.getAttribute("user"));
		String newStreet = request.getParameter("street");
		String newCity = request.getParameter("city");
		String newState = request.getParameter("state");
		String newZip = request.getParameter("zipCode");
		Address address = new Address();
		address.setStreet(newStreet);
		address.setCity(newCity);
		address.setState(newState);
		address.setZipCode(newZip);
		System.out.println(address);
		user.setAddress(address);
		theBank.save();
		session.setAttribute("user", user);
		RequestDispatcher rs= request.getRequestDispatcher("requestCheckBook.jsp");
		rs.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
