package util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {
   private static SqlSessionFactory sqlSessionFactory; //[O O O O O ]
	   
	   // 초기화 블럭-프로그램실행시 딱 한번만 실되는 코드영역
	   static {
		   try {
			   String resource = "mybatis/config.xml";
			   System.out.println(resource);
			   InputStream inputStream = Resources.getResourceAsStream(resource);//읽기
			   sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream); 
		   }catch(Exception e) {
			   System.out.println("체크에러 ㅁㄴㅇ");
			   e.printStackTrace();
		   }
	   }
	   
	   public static SqlSessionFactory getInstance() {
		   return sqlSessionFactory;
	   }
}
