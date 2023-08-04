package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class MemberDAO implements MemberDAOTemplate{
	
	public static void main(String[] args) {
		
		MemberDAO dao = new MemberDAO();
		try {
//			dao.insertMember(new MemberVO("마마마", 3, "바바바"));
//			for(MemberVO vo : dao.showAllMember()) {
//				System.out.println(vo);
//			}
			System.out.println(dao.findByNameMember("가가가"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		try {
//			// 1. 드라이버 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("Driver Loading Success..!!");
//			
//			// 2. 데이터베이스와 연결
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sample", "sample");
//			System.out.println("DB Connection..!!");
//			
//			// 3. Statement 객체 생성
//			PreparedStatement ps = conn.prepareStatement("INSERT INTO MEMBER(NAME, AGE, ADDR) VALUES (?, ?, ?)");
//			
//			ps.setString(1, "다다다");
//			ps.setInt(2, 2);
//			ps.setString(3, "라라라");
//			
//			// 4. 쿼리문 실행
//			System.out.println(ps.executeUpdate() + "명 가입!");
//			
//			// 5. close 닫기
//			ps.close();
//			conn.close();
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
		
	}

	public MemberDAO() {
		// 1. 드라이버 로딩
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success..!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		// 2. 데이터베이스와 연결
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connection..!!");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		// 5. close 닫기
		ps.close();
		conn.close();		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps,conn);
	}

	@Override
	public void insertMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection(); // 추가
		
		// 3. Statement 객체 생성
		String query = "INSERT INTO MEMBER(NAME, AGE, ADDR) VALUES (?, ?, ?)"; // 추가
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getName()); // 바꿈
		ps.setInt(2, vo.getAge()); // 바꿈
		ps.setString(3, vo.getAddr()); // 바꿈
		
		// 4. 쿼리문 실행
		System.out.println(ps.executeUpdate() + "명 가입!");
		
		closeAll(ps, conn); // 추가
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		
		Connection conn = getConnection();
		
		// 3. Statement 객체 생성
		String query = "SELECT * FROM MEMBER";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ArrayList<MemberVO> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new MemberVO(rs.getString("name"), rs.getInt("age"), rs.getString("addr")));
		}
		
		closeAll(rs, ps, conn); // 추가
		return list;
	}

	@Override
	public MemberVO findByNameMember(String name) throws SQLException {
		
		Connection conn = getConnection();
		
		// 3. Statement 객체 생성
		String query = "SELECT * FROM MEMBER WHERE NAME=? ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);
		
		// 4. 쿼리문 실행
		MemberVO vo = null;
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			vo = new MemberVO(rs.getString("name"), rs.getInt("age"), rs.getString("addr"));
		}
		
		closeAll(rs, ps, conn); // 추가
		return vo;
	}

}













