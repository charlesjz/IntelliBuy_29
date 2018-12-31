package intelliBuy.login;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
		List<User> userList = userMapper.findUserByUsername(username);
		if(userList!=null){
			if(password.equals(userList.get(0).getPassword())){
				System.out.println("username:"+userList.get(0).getUsername()+", password:"+userList.get(0).getPassword());
				return userList.get(0);
			}
		}else throw new InvalidUsernameAndPasswordException();
		
		return null;

	}

}
