package com.banking;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.User;

/**
 * Servlet implementation class CWithdrawServlet
 */
@WebServlet("/CWithdrawServlet")
public class CWithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CWithdrawServlet() {
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
		String amountstr = request.getParameter("amount");
		float amount = Float.parseFloat(amountstr);
		if (user.getHasOverdraftProtection()==true) {
			System.out.println("here");
			Transaction withdraw = new Transaction("Withdraw", amount * -1, Calendar.getInstance().getTime());
			if (user.getChecking().getBalance() + withdraw.getAmount() < 0 ) {
				System.out.println("Your transaction exceeds your balance. Your transaction could not be completed.");
			}else {
				user.getChecking().addTransaction(withdraw);
			}
		}
		else {
			Transaction withdraw = new Transaction("Withdraw", amount * -1, Calendar.getInstance().getTime());
				if(user.getChecking().getBalance() + withdraw.getAmount() < -500) {
					System.out.println("Your transaction exceeds -$500. Your transaction could not be completed.");
				} if ((user.getChecking().getBalance() + withdraw.getAmount()) >= -500 && (user.getChecking().getBalance() + withdraw.getAmount() < 0)){
					Transaction overdraftFee = new Transaction("Overdraft fee", -37, Calendar.getInstance().getTime());
					user.getChecking().addTransaction(withdraw);
					user.getChecking().addTransaction(overdraftFee);
				} if (user.getChecking().getBalance() + withdraw.getAmount() > 0)  {
					user.getChecking().addTransaction(withdraw);
				}
			}
		theBank.save();
		session.setAttribute("user", user);
		RequestDispatcher rs= request.getRequestDispatcher("accounts.jsp");
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
