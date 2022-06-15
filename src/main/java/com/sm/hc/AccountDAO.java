package com.sm.hc;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.util.db.DBManager;


//���� ���� db �۾� ó���ϴ� M��
public class AccountDAO {
	
	//���� �����Ǹ� ������ ���·� ������ ������
	public static void loginCheck(HttpServletRequest req) {
		HttpSession hs = req.getSession(); //���� ����
		Account a = (Account) hs.getAttribute("accountInfo");
		
		if (a == null) {
			req.setAttribute("loginPage", "jsp/sm/loginBefore.jsp");
		}else {
			req.setAttribute("loginPage", "jsp/sm/loginAfter.jsp");
		}
	}

	
	
	public static boolean login(HttpServletRequest request) {
		
		// �α���
			
			// 1. �� �ޱ�
			String userId = request.getParameter("id"); //userId�� �Է��� id�� �޾Ƴ���
			String userPw = request.getParameter("pw"); //request.getParameter("id") id�� ������
			
			// @ ���� �� �α��� �ٽ� �ϱ� -> �ٽ� ì�������. �ؿ� �ִ� updateAccount
			
			 String id_s = (String) request.getAttribute("id_s"); String pw_s = (String)
			 request.getAttribute("pw_s"); if (id_s != null) {//���� ���������! userId = id_s;
			 userPw = pw_s; }
			 	
			
			// 2. db�� �� (������ �ø���) ��ġ�ϴ��� ���ϴ��� ���ؾ���
			Connection con = null; //���� ��ü
			PreparedStatement pstmt = null; //���� ����
			ResultSet rs = null; //���
			
			
			boolean isLogin = false;
			
			try { //������ ������
					String sql = "select * from user_info_tbl where user_id=?";
					con = DBManager.connect();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, userId);
					
					rs = pstmt.executeQuery();
					if (rs.next()) {					
						if (userPw.equals(rs.getString("user_pw"))) {
								request.setAttribute("r", "�α��� ����");
								
								Account a = new Account();
								a.setUser_id(rs.getString("user_id"));
								a.setUser_pw(rs.getString("user_pw"));
								a.setUser_name(rs.getString("user_name"));
								a.setUser_gender(rs.getString("user_gender"));
								a.setUser_addr(rs.getString("user_addr"));
								a.setUser_phoneNumber(rs.getString("user_phoneNumber"));
								a.setUser_age(rs.getString("user_age"));
								
								//������ ��� ��𼭳� ��� ���� -> ���� ���� �� ���ǿ� �� �ٽ� ����
								HttpSession hs = request.getSession();//���� ����
								hs.setAttribute("accountInfo", a);//�� ����
								hs.setMaxInactiveInterval(5*60); //���ǽð� ����
								
								isLogin = true;
								
							} else {
								request.setAttribute("r", "�н����� ����");
							}
						} else {
							request.setAttribute("r", "�������� �ʴ� ȸ��");
						}

				return isLogin;
						
			//������ �߻��ϸ� catch	
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("����...");
				return isLogin;
			} finally {
				com.util.db.DBManager.close(con, pstmt, rs);
			}

		
		
		
	}



	public static void logOut(HttpServletRequest request) {

		// �α׾ƿ� �ϴ� ��
		// ������ �׿��� ��.
		
		HttpSession hs = request.getSession();
		hs.getAttribute("accountInfo"); //������ ��������?
//1.		hs.setAttribute("accountInfo", null); //null ���� �־ accountInfo(����)�� ����
//2.		hs.removeAttribute("accountInfo"); //������ ����
		hs.invalidate(); //�� ����(���� �Ұ�)
//4.		hs.setMaxInactiveInterval(0); //�̰Ŵ� �ȵ�!!!
		
		// ���ʿ� ����������� ������(�α����� �ȵ�����), ������ �ð��� ����Ǹ� -> 2���� ��찡 ����
		
		
		
		
	}




	//�����ϴ� ��
	public static void regAccount(HttpServletRequest request) {
		// ������
		Connection con = null; //���� ��ü
		PreparedStatement pstmt = null; //���� ����
		ResultSet rs = null;
		
		try {
			request.setCharacterEncoding("utf-8");
			String sql = "insert into user_info_tbl values(?,?,?,?,?,?,?)";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw1");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");		
			String addr = request.getParameter("addr");
			String phoneNum = request.getParameter("phoneNum");
			int age1 = Integer.parseInt(request.getParameter("birth"));
			
			int age2 = 2022 - age1;
			
			System.out.println(id);
			System.out.println(pw);
			System.out.println(name);
			System.out.println(gender);
			System.out.println(addr);
			System.out.println(phoneNum);
			System.out.println(age1);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, gender);
			pstmt.setString(5, addr);
			pstmt.setString(6, phoneNum);
			pstmt.setInt(7, age2);
			
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("���� ����");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����");
		}finally {
			DBManager.close(con, pstmt, rs);
		}			
	}

	
	


	// ȸ�� ���� ��������
	public static void getAccount(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from account_test where a_id=?";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			String path = request.getSession().getServletContext().getRealPath("fileFolder");
			System.out.println(path);
			
			// �̹� ���ε� ��� ó�� ��
			
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw1");
			String gender = request.getParameter("gender");
			String addr = request.getParameter("addr");
			String[] interest = request.getParameterValues("hobby");
			String txt = request.getParameter("txt");
			
			String interest2 = "";
			
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, gender);
			pstmt.setString(5, addr);
			
			
			if (txt.isEmpty()) {
				txt = "...";
			}
				
			if (interest != null) {
				for (String s : interest) {
					System.out.println(s);
					interest2 += s + "!";
				}
			}else {
				interest2 = "���ɻ� ����";
			}
			
			pstmt.setString(6, interest2);
			pstmt.setString(7, txt);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}


	//�����ϴ� ��
	public static void updateAccount(HttpServletRequest request) {
		
		Connection con = null; //���� ��ü
		PreparedStatement pstmt = null; //���� ����
		String sql = "update user_info_tbl set user_pw=?, user_addr=?, user_phoneNumber=?, user_age=? where user_id=?";

		try {
			request.setCharacterEncoding("utf-8");
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			// �� �ޱ�
			String pw = request.getParameter("pw1");
			String addr = request.getParameter("addr");
			String phoneNum = request.getParameter("phoneNum");
			int age1 = Integer.parseInt(request.getParameter("birth"));
			String id = request.getParameter("id");

			// ���� ������ �Ѱ� �ִ���
			Account aa = (Account)request.getSession().getAttribute("accountInfo");
			String id1 = aa.getUser_id();			
			
			//�� �Է¹ޱ�
			pstmt.setString(1, pw);
			pstmt.setString(2, addr);
			pstmt.setString(3, phoneNum);
			pstmt.setInt(4, age1);
			pstmt.setString(5, id1);			
			
			//�α��� �ٽ� ���� -> ������ �� �ٷ� �� �� �ְ� -> login���� �޾��༭ �� �Ƿ�����
			//���� ����� ����Ǹ� ���� �Ƿ��ְ� �ƴϸ� ���� ��������
			request.setAttribute("id_s", id);
			request.setAttribute("pw_s", pw);
			
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("���� ����");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, null);
		}			

	}



	public static void passwordCheck(HttpServletRequest request) {
	
		String pwContact = request.getParameter("pwContact");
	
		HttpSession hs = request.getSession();
		Account aa = (Account)request.getSession().getAttribute("accountInfo");
		String pw = aa.getUser_pw();
				
		if (pwContact.equals(pw)) {
			System.out.println("�����̾�????");
			request.setAttribute("contentPage", "jsp/sm/loginUpdate.jsp");
		}else {
			request.setAttribute("contentPage", "jsp/sm/loginContact.jsp");
		}
		
		
	}
		
	
	
	
	}
	
	
	

	

