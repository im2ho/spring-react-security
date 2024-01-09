package springChap3googleAPI.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import springChap3googleAPI.model.UserGoogle;

@Mapper
public interface UserMapper {

	//findByUsername
	UserGoogle findByUsername(String username);
	
	//addUser
	void addUser(UserGoogle userGoogle);
}
