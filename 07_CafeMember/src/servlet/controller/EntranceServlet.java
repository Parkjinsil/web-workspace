package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;

/*
 * 회원 가입하면.. 정보를 바탕으로
 * MemberVO를 생성..ArrayList에 추가
 * ArrayList를 통째로 ServletContext에 바인딩 -> 한번만 하면되니까 init에 들어감
 * 출력 결과는 viewMember.jsp 페이지에
 */

public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private ServletContext context;
//	List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>());

//	public void init(ServletConfig config) throws ServletException {
//		context = config.getServletContext();
//		context.setAttribute("list", list);
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");
		System.out.println("1. 폼값을 받아온다.");
		
		MemberVO vo = new MemberVO(name, age, addr);
		System.out.println("2. MemberVO 생성..");
		
//		list.add(vo);
//		System.out.println("3. MemberVO를 List에 저장");
		
		// 3. DAO로 데이터 전송 (리스트에 저장하는거 대신에)
		MemberDAO dao = new MemberDAO();
		try {
			dao.insertMember(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 4. 네비게이션 -> ViewMemberServlet으로 감
//		RequestDispatcher rdp = request.getRequestDispatcher("viewMember.jsp");
//		rdp.forward(request, response); // 이때 위에 설정한 페이지로 이동
		
//		PrintWriter out = response.getWriter();
		
//		out.println("<a href='viewMember.jsp'>viewMember.jsp 결과 확인하러 가기</a>");
//		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}





















