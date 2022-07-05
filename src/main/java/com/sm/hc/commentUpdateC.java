package com.sm.hc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/commentUpdateC")
public class commentUpdateC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//��� ���� ���
		AccountDAO.loginCheck(request);
		//��ۼ���
		AccountDAO.updateComment(request);
		AccountDAO.getPost(request);
		AccountDAO.getComment(request);
		
		//�����ϰ� �����
		request.setAttribute("contentPage", "jsp/sm/free_board_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
