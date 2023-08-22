package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 이 부분 중요!
public class Template { 
	
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		
		String resource = "/mybatis-config.xml";
		
		try {
			
			InputStream stream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(stream);
			session = factory.openSession(false); // false는 auto commit을 어쩌고
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}
	
}
