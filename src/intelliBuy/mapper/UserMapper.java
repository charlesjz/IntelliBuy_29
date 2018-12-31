package intelliBuy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import intelliBuy.po.User;
import intelliBuy.po.UserQueryVo;

public interface UserMapper {

	@Select("SELECT * FROM USER WHERE id=#{id}")
	@ResultType(User.class)
	public User findUserById(int Id) throws Exception;
	
	@Select("SELECT * FROM USER WHERE USERNAME LIKE #{username}")
	@ResultType(User.class)
	public List<User> findUserByUsername(String  username) throws Exception;
	
	@Insert("insert into user(id,username,birthday,sex,address,password) values(#{id},#{username},#{birthday},#{sex},#{address},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertUser(User user) throws Exception;

	
	@Delete("delete from user where id=#{id}")
	public void deleteUserById(int id) throws Exception;

	
	public int countUserByVo(UserQueryVo userQueryVo);

	@Select("select * from user")
	@ResultType(User.class)
	public List<User> findAllUsers()throws Exception;

	@Update("update user set #{modifystmt} where id=#{id}")
	public void updateUser(String modifystmt, int id)throws Exception;


	

}
