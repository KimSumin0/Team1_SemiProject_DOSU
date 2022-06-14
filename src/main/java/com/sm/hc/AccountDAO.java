package com.sm.hc;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.db.DBManager;


//���� ���� db �۾� ó���ϴ� M��
public class AccountDAO {
	
	//���� �����Ǹ� ������ ���·� ������ ������
	public static void loginCheck(HttpServletRequest req) {
		HttpSession hs = req.getSession(); //���� ����
		Account a = (Account) hs.getAttribute("accountInfo");
		
		if (a == null) {
			req.setAttribute("contentPage", "jsp/sm/login.jsp");
		}else {
			req.setAttribute("contentPage", "jsp/sm/loginOK.jsp");
		}
	}

	
	
	public static void login(HttpServletRequest request) {
		
		// �α���
			
			// 1. �� �ޱ�
			String userId = request.getParameter("user_id"); //userId�� �Է��� id�� �޾Ƴ���
			String userPw = request.getParameter("user_pw"); //request.getParameter("id") id�� ������
			
			// @ ���� �� �α��� �ٽ� �ϱ� -> �ٽ� ì�������. �ؿ� �ִ� updateAccount
			/*
			 * String iddd = (String) request.getAttribute("iddd"); String pwww = (String)
			 * request.getAttribute("pwww"); if (iddd != null) {//���� ���������! userId = iddd;
			 * userPw = pwww; }
			 */		
			
			// 2. db�� �� (������ �ø���) ��ġ�ϴ��� ���ϴ��� ���ؾ���
			Connection con = null; //���� ��ü
			PreparedStatement pstmt = null; //���� ����
			ResultSet rs = null; //���
			
			System.out.println("���������?");
			
			try { //������ ������
					String sql = "select * from user_info_tbl where user_id = ?";
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
								a.setUser_level(rs.getString("user_level"));
								
								//������ ��� ��𼭳� ��� ���� -> ���� ���� �� ���ǿ� �� �ٽ� ����
								HttpSession hs = request.getSession();//���� ����
								hs.setAttribute("accountInfo", a);//�� ����
								hs.setMaxInactiveInterval(5*60); //���ǽð� ����
								
							} else {
								request.setAttribute("r", "�н����� ����");
							}
						} else {
							request.setAttribute("r", "�������� �ʴ� ȸ��");
						}
				

				
			//������ �߻��ϸ� catch	
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("����...");
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
			String sql = "insert into account_test values(?,?,?,?,?,?,?,?)";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			// �̹��� lib
			String path = request.getSession().getServletContext().getRealPath("fileFolder");
			System.out.println(path);
			
			// �̹� ���ε� ��� ó�� ��
			MultipartRequest mr = new MultipartRequest(request, path, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			String name = mr.getParameter("name");
			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw1");
			String gender = mr.getParameter("gender"); //w�ƴϸ� m -> ������ ��ȯ? if �� ���
			
			if (gender.equals('w')) {
				gender = "��";
			} if (gender.equals('m')) {
				gender = "��";
			}
			
			String addr = mr.getParameter("addr");
			String[] interest = mr.getParameterValues("hobby");//�迭�̴ϱ� �迭�� ���
			String txt = mr.getParameter("txt");
			String img = mr.getFilesystemName("img");
			
			String interest2 = ""; //�迭 ������ ���� ���� ����
			
			
			System.out.println(name);
			System.out.println(id);
			System.out.println(pw);
			System.out.println(gender);
			System.out.println(addr);
			
//			for (String s : interest) {
//				System.out.println(s);
//				interest2 += s + "!"; // �����ڸ� �־ ���� �ʰ� - Ȯ���� ����
//			}
			System.out.println(interest); //�迭
			System.out.println(interest2); //������ ���
			System.out.println(txt);
			System.out.println(img);
			
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
			pstmt.setString(8, img);
			
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("���� ����");				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
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
			MultipartRequest mr = new MultipartRequest(request, path, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			String name = mr.getParameter("name");
			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw1");
			String gender = mr.getParameter("gender");
			String addr = mr.getParameter("addr");
			String[] interest = mr.getParameterValues("hobby");
			String txt = mr.getParameter("txt");
			String img = mr.getFilesystemName("img");
			
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
			pstmt.setString(8, img);
			
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
		String sql = "update account_test set a_name=?, a_pw=?, a_addr=?, a_interest=?, a_introduce=? where a_id=?";

		try {
			request.setCharacterEncoding("utf-8");
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			// �� �ޱ�
			String name = request.getParameter("name");
			String pw = request.getParameter("pw1");
			String addr = request.getParameter("addr");
			String interest = request.getParameter("hobby");
			String[] interest2 = request.getParameterValues("hobby2");//�迭�̴ϱ� �迭�� ���
			String txt = request.getParameter("txt");
			
			String interest3 = ""; //�迭 ������ ���� ���� ����

			// ���� ������ �Ѱ� �ִ���
			Account aa = (Account)request.getSession().getAttribute("accountInfo");
			String id = aa.getUser_id();
			
			if (interest2 != null) {
				for (String s : interest2) {
					System.out.println(s);
					interest3 += s + "!";
				}
			}else {
				interest3 = interest;
			}
			
			if (txt.isEmpty()) {
				txt = "...";
			}

			//�� �Է¹ޱ�			
			pstmt.setString(1, name);
			pstmt.setString(2, pw);
			pstmt.setString(3, addr);
			pstmt.setString(4, interest3);
			pstmt.setString(5, txt);
			pstmt.setString(6, id); //where���� �� id��
			
			//�α��� �ٽ� ���� -> ������ �� �ٷ� �� �� �ְ� -> login���� �޾��༭ �� �Ƿ�����
			//���� ����� ����Ǹ� ���� �Ƿ��ְ� �ƴϸ� ���� ��������
			request.setAttribute("iddd", id);
			request.setAttribute("pwww", pw);
			
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("���� ����");				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, null);
		}			

	}
		
	}
	
	
	

	

