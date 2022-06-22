package com.sm.hc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/postSearchC")
public class postSearchC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//�Խ��� - �� �˻� ���
		AccountDAO.loginCheck(request);
		AccountDAO.searchPost(request);
		
		//�˻��ϰ� �˻� ��� ��������
		request.setAttribute("contentPage", "jsp/sm/searchResult.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
