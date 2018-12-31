package intelliBuy.service;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import intelliBuy.mapper.UserMapper;
import intelliBuy.po.User;

public class UserService {
	
//	@Autowired(required=false)
	private UserMapper userMapper;

//	private SqlSessionFactory sqlSessionFactory;
    public List<User> findAllUsers() throws Exception{
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
//		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = userMapper.findAllUsers();
//		sqlSession.commit();
//		sqlSession.close();
		
		users.stream().forEach(System.out::println);
		return users;
	}

}
