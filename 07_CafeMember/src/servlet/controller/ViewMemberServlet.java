package servlet.controller;

// 전체 회원 조회 하는 역할의 servlet

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. DAO 리턴 받기
		// 2. 바인딩
		// 3. 네비게이션 --> viewMember.jsp
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
