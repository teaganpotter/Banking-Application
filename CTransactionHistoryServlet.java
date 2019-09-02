package com.banking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.User;

/**
 * Servlet implementation class CTransactionHistoryServlet
 */
@WebServlet("/CTransactionHistoryServlet")
public class CTransactionHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CTransactionHistoryServlet() {
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
	String numberOfTransactionsStr = request.getParameter("numberOfTransactions");
	int numberOfTransactions = Integer.parseInt(numberOfTransactionsStr);
	session.setAttribute("user", user);
	session.setAttribute("trans", user.getChecking().getLastTransactions(numberOfTransactions));
	System.out.println(user.getChecking().getLastTransactions(numberOfTransactions).length);
	RequestDispatcher rs= request.getRequestDispatcher("checkingTransactions.jsp");
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
