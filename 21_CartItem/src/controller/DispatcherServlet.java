package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String[] requestURIList = requestURI.split("/");
		String command = requestURIList[requestURIList.length-1];
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		ModelAndView mv = null;
		try {
			mv = controller.handle(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(mv!=null) {
			if(mv.isRedirect()) response.sendRedirect(mv.getPath()); // 경로지정해서 다시 전송함(페이지(jsp)로 이동함) // true니까 리다이렉트
			else request.getRequestDispatcher(mv.getPath()).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
