package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.UserService;

public class HelloSpring {
	
	public void menu(ApplicationContext applicationContext) {
		Scanner scan = new Scanner(System.in);
		UserService userService = null;
		int num;
		
		while(true) {
			System.out.println();
			System.out.println("**************");
			System.out.println("   1. 입력");
			System.out.println("   2. 출력");
			System.out.println("   3. 수정");
			System.out.println("   4. 삭제");
			System.out.println("   5. 끝");
			System.out.println("**************");
			System.out.print(" 번호 입력 : ");
			num = scan.nextInt();
			
			if(num == 5) break;
			
			if(num == 1) 
				userService = (UserService) applicationContext.getBean("userInsertService");
			else if(num == 2) 
				userService = (UserService) applicationContext.getBean("userSelectService");
			else if(num == 3)
				userService = applicationContext.getBean("userUpdateService", UserService.class);
			else if(num == 4)
				userService = applicationContext.getBean("userDeleteService", UserService.class);
					
			userService.execute();//호출
		}//while
	}
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml"); 
		HelloSpring helloSpring = (HelloSpring) applicationContext.getBean("helloSpring");
		helloSpring.menu(applicationContext);
		System.out.println("프로그램 종료합니다.");
	}

}









