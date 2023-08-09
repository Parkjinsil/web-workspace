package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;

public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		MemberDAO dao = new MemberDAO(); // -> 싱글톤 만들기 전
		
		try {
//			ArrayList<MemberDTO> list = dao.showAllMember(); // -> 싱글톤 만들기 전
			ArrayList<MemberDTO> list = MemberDAO.getInstance().showAllMember(); // -> 싱글톤 만들면 객체 생성 따로 필요 x
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/allShow.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
