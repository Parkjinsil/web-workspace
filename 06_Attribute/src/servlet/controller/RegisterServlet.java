package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성 !
		/*
		 * 1. 양방향 한글처리
		 * 2. 폼값 받아서 
		 * 3. ViewServlet (view)한테 결과(이름, 나이, 주소) 출력
		 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String adr = request.getParameter("adr");
		
		// a링크로 ViewServlet 결과 확인하러 가기
		out.println("<a href=view?name=" + name + "&age=" + age + "&adr="+ adr + ">view로 이동</a>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
