package intelliBuy.login;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import intelliBuy.mapper.UserMapper;
import intelliBuy.po.User;

public class AuthServiceImpl implements AuthService {
	
	private SqlSessionFactory sqlSessionFactory;
	private static volatile AuthService _authService = null;
	
	public static AuthService getInstance(){
		synchronized(AuthServiceImpl.class){
			if(_authService==null){
				_authService=new AuthServiceImpl();
			}
		}
		return _authService;
	}

	@Override
	public User authService(String username, String password) throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserByUsername(username);
		if(user!=null){
			if(password.equals(user.getPassword())){
				System.out.println("username:"+user.getUsername()+", password:"+user.getPassword());
				return user;
			}
		}else throw new InvalidUsernameAndPasswordException();
		
		return null;

	}

}
