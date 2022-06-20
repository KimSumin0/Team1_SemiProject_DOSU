package com.sm.hc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AccountDropController2")
public class AccountDropController2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Ż���ϴ� ��
		AccountDAO.DeleteAccount(request);
		AccountDAO.logOut(request);
		AccountDAO.loginCheck(request);
		
		//Ż�� ������ �����
		request.setAttribute("contentPage", "jsp/sm/accountDrop.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
