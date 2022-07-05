package com.sm.hc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CommentMainC")
public class CommentMainC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �ڸ�Ʈ �ۼ� ������
		// �α��� ���� Ȯ��
		
		if (AccountDAO.loginCheck2(request)) {
			//ȸ��
			AccountDAO.loginCheck(request);
			//��� ���
			AccountDAO.regComment(request);
			AccountDAO.getPost(request);
			//��� ��������
			AccountDAO.getComment(request);
			
			//�ٷ� ������
			request.setAttribute("contentPage", "jsp/sm/free_board_detail.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {//��ȸ��
			AccountDAO.loginCheck(request); //��â? ��ư �α����϶�� �޽���
			request.setAttribute("contentPage", "jsp/sm/login.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response); }
		
	}

}
