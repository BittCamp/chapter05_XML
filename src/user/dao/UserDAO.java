package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import user.bean.UserDTO;

public interface UserDAO {

	public void write(UserDTO userDTO);

	public List<UserDTO> getUserList();

	public UserDTO getUser(String id);

	public void userUpdate(Map<String, String> map);

	public void delete(String id);

	

}
