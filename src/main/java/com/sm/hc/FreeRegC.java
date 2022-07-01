package com.sm.hc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FreeRegC")
public class FreeRegC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�� ��� ������
		//�α��� ���� Ȯ���ؼ� �α��� �Ǿ� ������ �۾��� ������, �ƴϸ� ������.
		if (AccountDAO.loginCheck2(request)) {//ȸ��
			AccountDAO.loginCheck(request);
			request.setAttribute("contentPage", "jsp/sm/free_board_reg.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {//��ȸ��
			AccountDAO.loginCheck(request);
			request.setAttribute("contentPage", "jsp/sm/login.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);	
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AccountDAO.loginCheck(request);
		
		//�� ����ϴ� ��
		AccountDAO.regFree(request);
		
		//�� ��� ������
		AccountDAO.getAllFree(request);
		AccountDAO.paging(1, request);
		//AccountDAO.getAllFree(request);
		
		//�� �����ְ� ���� �����
		request.setAttribute("contentPage", "jsp/sm/boardFree.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
		
	
	}

}
