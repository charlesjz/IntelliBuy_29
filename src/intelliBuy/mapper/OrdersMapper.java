/**
 * 
 */
package intelliBuy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import intelliBuy.po.Orders;
import intelliBuy.po.User;
import intelliBuy.po.UserCustom;
import intelliBuy.po.UserQueryVo;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p>
 * @author Jiang
 * 2018年10月16日 下午12:27:22
 */
public interface OrdersMapper {
	/**
	 * 
	 */
	@Select("SELECT * FROM ORDERS WHERE id=#{id}")
	@ResultType(Orders.class)
	public Orders findOrdersById(int Id) throws Exception;
	
	@Insert("insert into orders(user_id,number,createtime,note) values(#{userId},#{number},#{createtime},#{note})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertOrders(Orders orders) throws Exception;
	
	@Select("select count(*) from orders where user_id=#{userId}")
	public int countOrdersByUserid(int userId);

	@Select("<script>"
            + "SELECT * FROM orders WHERE id IN "
            + "<foreach item='item' index='index' collection='strList' open='(' separator=',' close=')'>"
                + "#{item}"
            + "</foreach>"
        + "</script>")
    @Results({ 
    	@Result(column = "user_id", property = "userId") 
      })
	public List<Orders> findOrdersListByIds(@Param("strList") List<String> strList);

	@Select("select orders.* from user,orders where user.id=orders.user_id and user.username like '%${username}%'")
	public List<Orders> findOrdersByName(User user);

	@Delete("delete from orders where id=#{id}")
	public void deleteOrdersById(int id);

	@Select("select * from orders")
	public List<Orders> ordersFindAll();

	@Select("select * from orders")
	@Results({ 
		  @Result(id=true,property="id",column="id"), 
		  @Result(property="userId",column="user_id") 
		}) 
	public List<Orders> FindOrdersResultMap();


	


}
