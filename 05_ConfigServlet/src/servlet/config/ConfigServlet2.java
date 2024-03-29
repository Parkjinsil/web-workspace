package servlet.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConfigServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path;

	public void init(ServletConfig config) throws ServletException {
		// 1. ServletConfig의 기능을 사용해서 path에 연결된 값을 받아온다.
		path = config.getInitParameter("path");
		
		// 2. BufferedReader, FileReader를 사용해서 파일을 읽어들인다.
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			// 3. count값으로 필드 초기화
			count = Integer.parseInt(br.readLine());
			br.close();
			
			System.out.println("count.txt 파일의 내용을 읽어들임... count ::" + count);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일을 읽어들이는데 실패...");
		}
	}


	public void destroy() {
		// 4. PrintWriter, FileWriter를 사용해서 count값 저장
		File file = new File(path);
		file.getParentFile().mkdirs();
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			pw.println(count);
			
			pw.close();
			System.out.println(path + "count 값 ::" + count + "파일에 영구적으로 저장" );
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("스트림 생성 실패");
		}
		
		
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // html에서 한글값 받아온게 있을땐 이거 쓰고 없으면 그냥 안써도됨
		response.setContentType("text/html;charset=utf-8");
		
		String userName = request.getParameter("userName");
		
		PrintWriter out = response.getWriter();
		
		out.println("<p>이름 : " + userName +"</p>");
		out.println("<a href=cs2.jsp?userName=" + userName + "&count=" + ++count + ">cs2.jsp로 이동</a>");
		
		// 5. 폼에 입력된 값을 받아서
		//    ~~ 아무개 님은 ~ 몇번째 입장하신 고객입니다...
		//    를 브라우저로 출력 (이때 출력은 config2.jsp에서)
	}

}
