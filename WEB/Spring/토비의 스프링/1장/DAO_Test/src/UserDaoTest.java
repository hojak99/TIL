import java.sql.Connection;
import java.sql.SQLException;
import java.text.Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context =
				new AnnotationConfigApplicationContext(DaoFactory.class);
		
		
		
		/*
		 * getBean() 메소드는 ApplicationContext 가 관리하는 오브젝트를 요청하는 메소드이다.
		 * "userDao" 는 ApplicationContext 에 등록된 빈의 이름
		 * */
		UserDao dao = context.getBean("userDaoD", UserDao.class);
		
		User user = new User();
		user.setId("whiteship");
		user.setName("백기선");
		user.setPassword("married");
		
		dao.add(user);
	}

}
