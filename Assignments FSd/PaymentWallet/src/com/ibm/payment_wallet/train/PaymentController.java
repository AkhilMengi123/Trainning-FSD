package com.ibm.payment_wallet.train;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.payment_wallet.service.WalletServiceClass;
import com.ibm.payment_wallet.service.WalletServiceInterface;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet(urlPatterns= {"/payment","/create","/balance","/Login","/deposit"})
public class PaymentController extends HttpServlet {
	WalletServiceInterface service;
 public PaymentController() {
       
    }

	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		service=new WalletServiceClass();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String path=request.getServletPath();
		System.out.println(path);
		PrintWriter pw=response.getWriter();
		boolean b=false;
		int balance=0;
		switch(path) {
	
			
		case "/create":
			b=service.createWallet(request, response);
			if(b) {
				pw.println("Wallet created Successfully...");
				request.getRequestDispatcher("login.jsp").include(request,response);
			}
			
			
			break;
		
		case "/balance":
			//int bal=(Integer)request.getSession().getAttribute("balance");
			//request.getRequestDispatcher("balance.jsp").forward(request,response);
			balance=service.showBalance(request, response);
			request.getSession().setAttribute("balance",balance);
				request.getRequestDispatcher("balance.jsp").include(request,response);
			break;
		case "/login":
			//int bal=(Integer)request.getSession().getAttribute("balance");
			request.getRequestDispatcher("login.jsp").forward(request,response);
			break;
			
		case "/deposit":
			String deposit_message=service.depositMoney(request, response);
			
			request.getRequestDispatcher("balance").include(request,response);	
			pw.println("<br>"+deposit_message);
			break;
		case "/withdraw":
			String withdraw_message=service.withdrawMoney(request, response);
			
			request.getRequestDispatcher("balance").include(request,response);	
			pw.println("<br>"+withdraw_message);
			break;
			
		
		default:
			b=service.isWalletExist(request, response);
			if(b) {
				pw.println("Successfully Logged in...");
			balance=service.showBalance(request, response);
			request.getSession().setAttribute("balance",balance);
				request.getRequestDispatcher("balance.jsp").include(request,response);
			}
			break;
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
