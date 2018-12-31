package intelliBuy.mapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import intelliBuy.po.Orders;
import intelliBuy.po.User;
import intelliBuy.po.UserCustom;
import intelliBuy.po.UserQueryVo;

public class OrdersMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println("@Before...");
	}
	
	@Test
	public void testCountOrdersByUserid() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		int count = ordersMapper.countOrdersByUserid(10);
		System.out.println(count);
	}
	
	@Test
	public void testFindOrdersById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		Orders orders = ordersMapper.findOrdersById(3);
		System.out.println(orders);
	}
	
	@Test
	public void testFindOrdersByIds() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		List<String> idList = Arrays.asList("1","2","3","4","5");
		List<Orders> orders = ordersMapper.findOrdersListByIds(idList);
		orders.forEach(System.out::println);
	}
	
	@Test
	public void testInsertOrders() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		Orders orders =new Orders();
		orders.setUserId(16);
		orders.setNumber("1000021");
		orders.setCreatetime(new Date());
		orders.setNote("Je confirme");
		ordersMapper.insertOrders(orders);
		sqlSession.commit();
		sqlSession.close();
		
		System.out.println("OrdersId:"+orders.getId());
		System.out.println("OrdersUserId:"+orders.getUserId());
		System.out.println("OrdersNumber:"+orders.getNumber());
		System.out.println("OrdersCreatetime:"+orders.getCreatetime());
		System.out.println("OrdersNote:"+orders.getNote());
	}
	
	@Test
	public void testDeleteOrdersById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		if(ordersMapper.findOrdersById(21)!=null){
		    ordersMapper.deleteOrdersById(21);
		}
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testOrdersFindAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orders> list = ordersMapper.ordersFindAll();
		sqlSession.commit();
		sqlSession.close();
		list.stream().forEach(e->
				System.out.println(
						e.getId()+ ", "
				       +e.getNumber()+", "
				       +e.getUserId()+", "
				       +e.getCreatetime()+", "
				       +e.getNote()
				       ));
	}
	

	@Test
	public void testFindOrdersByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orders> list = ordersMapper.findOrdersByName(new User("王"));
		sqlSession.close();
		list.forEach(System.out::println);
	}

	@Test
	public void testFindOrdersResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orders> list = ordersMapper.FindOrdersResultMap();
		sqlSession.close();
		list.forEach(System.out::println);
	}

}
