package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

@WebServlet(urlPatterns="/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청이 어디에서 들어오는 요청인.. command 값 받는다.
		String command = request.getParameter("command");
		String path = "index.jsp";
		
		try {
			if(command.equals("register")) {
				path = register(request,response);
			} else if(command.equals("login")) {
				path = login(request,response);
			} else if(command.equals("findMember")) {
				path = findMember(request,response);
			} else if(command.equals("allMember")) {
				path = allMember(request,response);
			} else if(command.equals("update")) {
				path = update(request,response);
			} else if(command.equals("logout")) {
				path = logout(request,response);
			}
		} catch (SQLException e) {}
		
		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response); // 경로가 바뀌기 때문에 path로 빼놓기
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// 1. 폼값 가져온다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		// 2. 객체 생성 - 폼값 담기
		MemberVO vo = new MemberVO(id, password, name, address);
		
		// 3. DAO와 연결
		MemberDAO.getInstance().registerMember(vo);
			
		// 바인딩 생략
			
		return "index.jsp";
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberVO vo = MemberDAO.getInstance().login(id, password);
		
		HttpSession session = request.getSession();
		session.setAttribute("vo", vo);
		
		return "views/login_result.jsp";
	}
	
	protected String findMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

		String id = request.getParameter("id");
		
		MemberVO vo = MemberDAO.getInstance().findMyIdMember(id);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			return "views/find_ok.jsp";
		} else {
			return "views/find_fail.jsp";
		}
		
	}
	
	protected String allMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ArrayList<MemberVO> list = MemberDAO.getInstance().showAllMember();
			request.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "views/allShow.jsp";
	}
	
	protected String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id, password, name, address);
		
		try {
			MemberDAO.getInstance().updateMember(vo);
			
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) {
				session.setAttribute("vo", vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "views/update_result.jsp";
		
		}
	
	protected String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
			return "views/logout.jsp";
		}
		
		return "index.jsp";
		
	}
}



















