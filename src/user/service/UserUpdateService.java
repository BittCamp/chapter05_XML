package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {
	@Setter
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("수정 할 아이디 입력");
		String id = scan.next();
		//DB
		UserDTO userDTO = userDAO.getUser(id); // 한사람 분량의 데이터
		if( userDTO == null ) {
			System.out.println("찾고자 하는 아이디가 없습니다.");			
			return;
		}
		System.out.println(userDTO);
		
		System.out.println();
		System.out.println("수정할 이름 입력 : ");
		String name = scan.next();
		System.out.println("수정할 비밀번호 입력 : ");
		String pwd = scan.next();
		
		Map<String , String > map = new HashMap<String,String>();
		map.put("name",name);
		map.put("id",id);
		map.put("pwd",pwd);
		
		userDAO.userUpdate(map);
		
		System.out.println(id+ "님의 데이터를 수정하였습니다.");
	}

}
