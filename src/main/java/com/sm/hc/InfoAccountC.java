package com.sm.hc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InfoAccountC")
public class InfoAccountC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �α��� üũ
		// ����Ʈ ������ ����
		
		AccountDAO.loginCheck(request);

		
		
		
		// �� ������?
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	}
//	주석
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
