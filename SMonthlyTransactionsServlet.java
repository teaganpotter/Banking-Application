package com.banking;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.User;

/**
 * Servlet implementation class SMonthlyTransactionsServlet
 */
@WebServlet("/SMonthlyTransactionsServlet")
public class SMonthlyTransactionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SMonthlyTransactionsServlet() {
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
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		int monthInt = Integer.parseInt(month);
		int yearInt = Integer.parseInt(year);
		session.setAttribute("user", user);
		session.setAttribute("trans", user.getSavings().getMonthlyTransactions(monthInt, yearInt));
		System.out.println(user.getSavings().getMonthlyTransactions(monthInt, yearInt).length);
		RequestDispatcher rs= request.getRequestDispatcher("savingsTransactions.jsp");
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
