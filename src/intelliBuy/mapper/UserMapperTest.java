package intelliBuy.mapper;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import intelliBuy.po.User;
import intelliBuy.po.UserCustom;
import intelliBuy.po.UserQueryVo;

public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	// 此方法是在执行testFindUserById之前执行
	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory

		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
//		byte[] buffer = new byte[2048];  
//		String result = (new BufferedReader(new InputStreamReader(inputStream))).lines().collect(Collectors.joining(System.lineSeparator()));
//		System.out.println(result);

		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println("@Before...");
	}

	//用户信息的综合 查询
//	@Test
//	public void testFindUserList() throws Exception {
//		
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		
//		//创建UserMapper对象，mybatis自动生成mapper代理对象
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		
//		//创建包装对象，设置查询条件
//		UserQueryVo userQueryVo = new UserQueryVo();
//		UserCustom userCustom = new UserCustom();
//		//由于这里使用动态sql，如果不设置某个值，条件不会拼接在sql中
////		userCustom.setSex("1");
//		userCustom.setUsername("小明");
//		//传入多个id
//		List<Integer> ids = new ArrayList<Integer>();
//		ids.add(1);
//		ids.add(2);
//		ids.add(3);
//		ids.add(4);
//		ids.add(5);
//		ids.add(6);
//		ids.add(7);
//		ids.add(8);
//		ids.add(9);
//		ids.add(10);
//		ids.add(11);
//		ids.add(12);
//		//将ids通过userQueryVo传入statement中
//		userQueryVo.setIds(ids);
//		userQueryVo.setUserCustom(userCustom);
//		//调用userMapper的方法
//		
//		List<UserCustom> list = userMapper.findUserByUsername(userQueryVo);
//		
//		System.out.println(list);
//		
//		
//	}
	
	@Test
	public void testFindUserCount() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("张三丰");
		userQueryVo.setUserCustom(userCustom);
		//调用userMapper的方法
		
		int count = userMapper.countUserByVo(userQueryVo);
		
		System.out.println(count);
		
		
	}
	
	@Test
	public void testFindUserById() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//调用userMapper的方法
		
		User user = userMapper.findUserById(31);
		
		System.out.println(user);
		
		
	}
	
//	@Test
//	public void testFindUserByIdResultMap() throws Exception {
//		
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		
//		//创建UserMapper对象，mybatis自动生成mapper代理对象
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		
//		//调用userMapper的方法
//		
//		User user = userMapper.findUserByIdResultMap(1);
//		
//		System.out.println(user);
//		
//		
//	}

	@Test
	public void testFindUserByUserame() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findUserByUsername("1000032");
		
		sqlSession.close();
		
		System.out.println(list);
		
		
	}

	@Test
	public void testInsertUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user =new User();
		user.setUsername("1000032");
		user.setPassword("123456");
		user.setBirthday(LocalDate.parse("1997-11-19"));
		user.setSex("M");
		user.setAddress("New Deli");
		userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
		
		System.out.println("OrdersId:"+user.getId());
		System.out.println("OrdersUserId:"+user.getUsername());
		System.out.println("OrdersNumber:"+user.getBirthday().toString());
		System.out.println("OrdersCreatetime:"+user.getSex());
		System.out.println("OrdersNote:"+user.getAddress());
	}

	@Test
	public void testFindUserByUsername() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> user =userMapper.findUserByUsername("1000024");
		sqlSession.commit();
		sqlSession.close();

		System.out.println(user.get(0).getId());
		System.out.println(user.get(0).getUsername());
		System.out.println(user.get(0).getBirthday().toString());
		System.out.println(user.get(0).getSex());
		System.out.println(user.get(0).getAddress());
	}

	@Test
	public void testDeleteUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUserById(27);
		sqlSession.commit();
		sqlSession.close();

	}

	@Test
	public void testFindAllUsers() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = userMapper.findAllUsers();
		sqlSession.commit();
		sqlSession.close();
		
		users.stream().forEach(System.out::println);

	}

}
